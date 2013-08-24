package edu.ecpi.survivethis;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button woodsBt = (Button) findViewById(R.id.woods);
        woodsBt.setOnClickListener(onClickListener);
        Button desertBt = (Button) findViewById(R.id.desert);
        desertBt.setOnClickListener(onClickListener);
        Button snowBt = (Button) findViewById(R.id.snow);
        snowBt.setOnClickListener(onClickListener);
        Button waterBt = (Button) findViewById(R.id.water);
        waterBt.setOnClickListener(onClickListener);
        Button swampBt = (Button) findViewById(R.id.swamp);
        swampBt.setOnClickListener(onClickListener);
        Button fireBt = (Button) findViewById(R.id.fire);
        fireBt.setOnClickListener(onClickListener);
        Button aboutBt = (Button) findViewById(R.id.about);
        aboutBt.setOnClickListener(onClickListener);
        Button compassBt = (Button) findViewById(R.id.compass);
        compassBt.setOnClickListener(onClickListener);
        Button flashlightBt = (Button) findViewById(R.id.flashlight);
        flashlightBt.setOnClickListener(onClickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private OnClickListener onClickListener = new OnClickListener() {
    	public void onClick(View v) {
    		switch(v.getId()) {
	    		case R.id.woods:
	    			Intent woodsIntent = new Intent(MainActivity.this, WoodsActivity.class);
	    			startActivity(woodsIntent);
	    		break;
	    		case R.id.desert:
	    			Intent desertIntent = new Intent(MainActivity.this, DesertActivity.class);
	    			startActivity(desertIntent);
	    		break;
	    		case R.id.snow:
	    			Intent snowIntent = new Intent(MainActivity.this, SnowActivity.class);
	    			startActivity(snowIntent);
	    		break;
	    		case R.id.water:
	    			Intent waterIntent = new Intent(MainActivity.this, WaterActivity.class);
	    			startActivity(waterIntent);
	    		break;
	    		case R.id.swamp:
	    			Intent swampIntent = new Intent(MainActivity.this, SwampActivity.class);
	    			startActivity(swampIntent);
	    		break;
	    		case R.id.fire:
	    			Intent fireIntent = new Intent(MainActivity.this, FireActivity.class);
	    			startActivity(fireIntent);
	    		break;
	    		case R.id.about:
	    			Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
	    			startActivity(aboutIntent);
	    		break;
	    		case R.id.compass:
	    			Intent compassIntent = new Intent(MainActivity.this, CompassActivity.class);
	    			startActivity(compassIntent);
	    		break;
	    		case R.id.flashlight:
	    			Intent flashlightIntent = new Intent(MainActivity.this, FlashLightActivity.class);
	    			startActivity(flashlightIntent);
	    		break;
    		}
        	
        }
    };
    
    
}
