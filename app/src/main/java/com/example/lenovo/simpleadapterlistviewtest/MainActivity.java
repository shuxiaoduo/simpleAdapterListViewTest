package com.example.lenovo.simpleadapterlistviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] name={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int image[]={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    private List<Map<String,Object>> lists;
    private SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        lists=new ArrayList<>();
        for(int i = 0;i < 6;i++){
            Map<String,Object> map =new HashMap<>();
            map.put("name",name[i]);
            map.put("image",image[i]);
            lists.add(map);
        }

        adapter=new SimpleAdapter(this,lists,R.layout.layout,new String[] {"name","image"}, new int[] {R.id.text1,R.id.image1});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),name[position],Toast.LENGTH_SHORT).show();
            }
        });

    }
}
