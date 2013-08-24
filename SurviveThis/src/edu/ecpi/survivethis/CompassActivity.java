package edu.ecpi.survivethis;

import java.util.List;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

public class CompassActivity extends Activity implements SensorEventListener, LocationListener {
	SensorManager manager;
	private Sensor accelerometer;
	private Sensor magneticField;
	
	private float[] valuesAcc;
	private float[] valuesMag;
	
	private float[] matrixR;
	private float[] matrixI;
	private float[] matrixValues;
	
	private boolean isAcc = false;
	private boolean isMag = false;
	
	private String[] directions = {"North", "North-East", "East", "South-East", "South", "South-West", "West", "North-West", "North"};
	
	private LocationManager locationManager;
	private String provider;	
	TextView coordinates;
	
	private boolean areSensorsAvailable() {
		manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> magList = manager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
		List<Sensor> accList = manager.getSensorList(Sensor.TYPE_ACCELEROMETER);
		if (magList.size() > 0) { isMag = true; }
		if (accList.size() > 0) { isAcc = true; }
		return ((isMag) && (isAcc));
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compass);
		
		if(!areSensorsAvailable()) {
			manager.unregisterListener(this, accelerometer);
			manager.unregisterListener(this, magneticField);
		}
		
		LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
		boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);
		if (enabled) {
			locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
			Criteria c = new Criteria();
			provider = locationManager.getBestProvider(c, false);
			Location location = locationManager.getLastKnownLocation(provider);
			coordinates = (TextView) findViewById(R.id.coordinates_current);
			
			if (location != null) {
				onLocationChanged(location);
			} else {
				coordinates.setText("GPS Unavailable");
			}
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compass, menu);
		return true;
	}
	
	public void onPause() {
		manager.unregisterListener(this, accelerometer);
		manager.unregisterListener(this, magneticField);
		super.onPause();
		locationManager.removeUpdates(this);
	}
	
	public void onLocationChanged(Location location) {
		int lat = (int) (location.getLatitude());
		int lng = (int) (location.getLongitude());
		coordinates.setText(lat+" Latitude & "+lng+" Longitude");
	}
	
	public void onStatusChanged(String provider, int status, Bundle extras) {};
	
	public void onProviderEnabled(String provider) {}
	
	public void onProviderDisabled(String provider) {}
	
	public void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(provider, 400, 1, this);
	}
	
	public void onAccuracyChanged(Sensor arg0, int arg1) {}
	
	public void onSensorChanged(SensorEvent event) {
		switch (event.sensor.getType()) {
		case Sensor.TYPE_ACCELEROMETER:
			for(int i=0; i<3; ++i) {
				valuesAcc[i] = event.values[i];
			} break;
		case Sensor.TYPE_MAGNETIC_FIELD:
			for(int i=0; i<3; ++i) {
				valuesMag[i] = event.values[i];
			} break;
		}
		
		boolean success = manager.getRotationMatrix(matrixR, matrixI, valuesAcc, valuesMag);
		if (success) {
			manager.getOrientation(matrixR, matrixValues);
			TextView view = (TextView) findViewById(R.id.direction_current);
			view.setText(directions[(int)Math.round(((double)matrixValues[0] % 360)/45)]);
		}
	}

}

