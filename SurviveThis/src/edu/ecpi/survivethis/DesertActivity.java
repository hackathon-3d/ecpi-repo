package edu.ecpi.survivethis;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DesertActivity extends Activity {

	private TextView view;
	private int pageID = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_desert);
		Button next = (Button) findViewById(R.id.btnDesertNext);
		next.setOnClickListener(onClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.desert, menu);
		return true;
	}
	private OnClickListener onClickListener = new OnClickListener() {
		public void onClick(View v) {
			switch(pageID) {
				case 0:	
					view = (TextView) findViewById(R.id.desert_hydrationHeader);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.desert_hydrationDetail);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.desert_foodHeader);
					view.setVisibility(0);
					view = (TextView) findViewById(R.id.desert_foodDetail);
					view.setVisibility(0);
					pageID = 1;
					break;
				case 1:
					view = (TextView) findViewById(R.id.desert_foodHeader);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.desert_foodDetail);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.desert_animalsHeader);
					view.setVisibility(0);
					view = (TextView) findViewById(R.id.desert_animalsDetail);
					view.setVisibility(0);
					pageID = 2;
					break;
				case 2:
					view = (TextView) findViewById(R.id.desert_animalsHeader);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.desert_animalsDetail);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.desert_plantsHeader);
					view.setVisibility(0);
					view = (TextView) findViewById(R.id.desert_plantsDetail);
					view.setVisibility(0);
					pageID = 3;
					break;
				case 3:
					view = (TextView) findViewById(R.id.desert_plantsHeader);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.desert_plantsDetail);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.desert_hydrationHeader);
					view.setVisibility(0);
					view = (TextView) findViewById(R.id.desert_hydrationDetail);
					view.setVisibility(0);
					pageID = 0;
					break;
				default:
					break;
			}
		}
	};
}
