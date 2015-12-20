package com.tes.apotheke;

import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
//import android.widget.ImageView;
import android.content.Intent;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_about).setOnClickListener(this);
        findViewById(R.id.btn_drug_list).setOnClickListener(this);
        findViewById(R.id.btn_tags).setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;

            case R.id.btn_drug_list:
                startActivity(new Intent(MainActivity.this, DrugListActivity.class));
                break;

            case R.id.btn_tags:
                startActivity(new Intent(MainActivity.this, Tags.class));
                break;
        }
    }
}
