package edu.ecpi.survivethis;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class WoodsActivity extends Activity {
	
	private int pageID = 0;
	private TextView view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_woods);
		
		Button next = (Button) findViewById(R.id.btnWoodsNext);
		next.setOnClickListener(onClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.woods, menu);
		return true;
	}
	
	private OnClickListener onClickListener = new OnClickListener() {
		public void onClick(View v) {
			switch(pageID) {
				case 0:	
					view = (TextView) findViewById(R.id.woods_hydrationHeader);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.woods_hydrationDetail);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.woods_foodHeader);
					view.setVisibility(0);
					view = (TextView) findViewById(R.id.woods_foodDetail);
					view.setVisibility(0);
					pageID = 1;
					break;
				case 1:
					view = (TextView) findViewById(R.id.woods_foodHeader);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.woods_foodDetail);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.woods_animalsHeader);
					view.setVisibility(0);
					view = (TextView) findViewById(R.id.woods_animalsDetail);
					view.setVisibility(0);
					pageID = 2;
					break;
				case 2:
					view = (TextView) findViewById(R.id.woods_animalsHeader);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.woods_animalsDetail);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.woods_plantsHeader);
					view.setVisibility(0);
					view = (TextView) findViewById(R.id.woods_plantsDetail);
					view.setVisibility(0);
					pageID = 3;
					break;
				case 3:
					view = (TextView) findViewById(R.id.woods_plantsHeader);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.woods_plantsDetail);
					view.setVisibility(4);
					view = (TextView) findViewById(R.id.woods_hydrationHeader);
					view.setVisibility(0);
					view = (TextView) findViewById(R.id.woods_hydrationDetail);
					view.setVisibility(0);
					pageID = 0;
					break;
				default:
					break;
			}
		}
	};

}
