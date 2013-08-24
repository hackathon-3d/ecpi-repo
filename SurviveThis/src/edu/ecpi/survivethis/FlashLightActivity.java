package edu.ecpi.survivethis;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class FlashLightActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flash_light);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.flash_light, menu);
		return true;
	}

}
