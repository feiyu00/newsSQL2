package com.example.newsqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView showlv;
    private List<NewsBean> mAll;
    private List<NewsBean> mDatas;
    private ListAdapter mAdapter;
    private DrawerLayout drawer=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   /*     DatabaseHelper helper =new DatabaseHelper(this);
          helper.getWritableDatabase();*/
        showlv = findViewById(R.id.layout_list);
        mDatas = new ArrayList<>();
        Dao dao = new Dao(this);
        mAll = dao.query();
        mDatas.addAll(mAll);
        mAdapter =new ListAdapter(this,mDatas);
        showlv.setAdapter(mAdapter);
        showlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewsBean bean = mDatas.get(position);
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("bean",bean);
                startActivity(intent);
            }
        });
    }
}
