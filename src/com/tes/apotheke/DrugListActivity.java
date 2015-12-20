package com.tes.apotheke;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrugListActivity extends Activity {
    ListView listViewDrugs;
    List<Map<String, String>> employeeList = new ArrayList<Map<String, String>>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initListData();
        if (employeeList.size() == 0)
            Log.d("DrugLIstActivity", "employeeList.size() == 0");
        else
            Log.d("DrugLIstActivity", "employeeList.size = " + employeeList.size());
       // listViewDrugs = (ListView) findViewById(R.id.listView);
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this, employeeList, android.R.layout.simple_list_item_1,
//                new String[]{"drugs"}, new int[]{android.R.id.text1});
//
//        listViewDrugs.setAdapter(simpleAdapter);


    }


    private void initListData() {
        try {
            String json_asset = loadJSONFromAsset("json_data.json");
            // Here we parse JSON object
            JSONObject jsonResponse = new JSONObject(json_asset);
            // Here we get main JSON array(list)
            JSONArray jsonMainNode = jsonResponse.optJSONArray("drugs");
            for (int i = 0; i < jsonMainNode.length(); i++) {
                // Here we work with every JSON array item
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);

                String name = jsonChildNode.optString("drug_name");
//                String number = jsonChildNode.optString("drug_no");
                String path = jsonChildNode.optString("html_path");
//                String outPut = name + "-" + number;

                HashMap<String, String> employeeNameNo = new HashMap<String, String>();
                employeeNameNo.put("drugs", name);
//                employeeNameNo.put("paths", path);

                employeeList.add(employeeNameNo);
            }
        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), "Error" + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private String loadJSONFromAsset(String filename) {
        String json;
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.list, menu);
//        return true;
//    }
}
