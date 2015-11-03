package com.tes.apotheke;

import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
//import android.widget.ImageView;
import android.content.Intent;

public class MainActivity extends Activity {
	
	//private ImageView splash;
	//private static final int STOPSPLASH = 0;
	//private static final long SPLASHTIME = 2000;
	
	/*private Handler splashhandler = new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			switch (msg.what) {
			case STOPSPLASH:
				splash.setVisibility(View.GONE);
				break;
			}
			super.handleMessage(msg);
		}
	};*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//splash = (ImageView) findViewById(R.id.splashscreen);
	}
	
	public void AboutClick(View v){
		switch (v.getId()) {
		case R.id.button1:
			Intent intent = new Intent(MainActivity.this, About.class);
			startActivity(intent);		
			break;
		}
	}
	
	public void ListClick(View v){
		switch (v.getId()) {
		case R.id.button2:
			Intent intent = new Intent(MainActivity.this, DrugList.class);
			startActivity(intent);		
			break;
		}
	}
	
	public void TagsClick(View v){
		switch (v.getId()) {
		case R.id.button3:
			Intent intent = new Intent(MainActivity.this, Tags.class);
			startActivity(intent);		
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	
}

