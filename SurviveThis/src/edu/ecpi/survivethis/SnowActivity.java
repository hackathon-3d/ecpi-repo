package edu.ecpi.survivethis;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SnowActivity extends Activity {

	private TextView view;
	private int pageID = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_snow);
		Button next = (Button) findViewById(R.id.btnSnowNext);
		next.setOnClickListener(onClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.snow, menu);
		return true;
	}
	private OnClickListener onClickListener = new OnClickListener() {
		public void onClick(View v) {
			switch(pageID) {
				case 0:	
					view = (TextView) findViewById(R.id.snow_hydrationHeader);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.snow_hydrationDetail);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.snow_foodHeader);
					view.setVisibility(0);
					view = (TextView) findViewById(R.id.snow_foodDetail);
					view.setVisibility(0);
					pageID = 1;
					break;
				case 1:
					view = (TextView) findViewById(R.id.snow_foodHeader);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.snow_foodDetail);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.snow_animalsHeader);
					view.setVisibility(0);
					view = (TextView) findViewById(R.id.snow_animalsDetail);
					view.setVisibility(0);
					pageID = 2;
					break;
				case 2:
					view = (TextView) findViewById(R.id.snow_animalsHeader);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.snow_animalsDetail);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.snow_shelterHeader);
					view.setVisibility(0);
					view = (TextView) findViewById(R.id.snow_shelterDetail);
					view.setVisibility(0);
					pageID = 3;
					break;
				case 3:
					view = (TextView) findViewById(R.id.snow_shelterHeader);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.snow_shelterDetail);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.snow_hydrationHeader);
					view.setVisibility(0);
					view = (TextView) findViewById(R.id.snow_hydrationDetail);
					view.setVisibility(0);
					pageID = 0;
					break;
				default:
					break;
			}
		}
	};
}
