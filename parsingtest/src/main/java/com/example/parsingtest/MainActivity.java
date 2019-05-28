package com.example.parsingtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Tour> tourlist;

    Adapter adapter;
    RecyclerView recyclerView;
    XMLPullParserHandler xmlPullParserHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        adapter = new Adapter(new Adapter.OnTourClickListener() {
            @Override
            public void onTourClicked(Tour model) {
                Toast.makeText(MainActivity.this,model.getName(),Toast.LENGTH_SHORT).show();
                int contentid = model.getContentid();
                int contenttypeid = model.getContenttypeid();
                IntentData intentData = new IntentData();
                intentData.setContentid(contentid);
                intentData.setContenttypeid(contenttypeid);

                Intent intent=new Intent(getApplicationContext(),InformActivity.class);
                intent.putExtra("targetData",intentData);
                //인텐트 전달시 Parcelable 사용할지, 아니면 바로꺼내서 사용할지 정해야함
                startActivity(intent); // 상세화면 액티비티 전환.
            }
        });
        xmlPullParserHandler = new XMLPullParserHandler();

        tourlist = new ArrayList<Tour>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        new Thread(new Runnable() {
            @Override
            public void run() {
                tourlist = xmlPullParserHandler.parsing();
                Log.d("jmw93", String.valueOf(tourlist.size()));

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.setItems(tourlist);

                        recyclerView.setAdapter(adapter);

                    }

                });
            }
        }).start();




    }
}