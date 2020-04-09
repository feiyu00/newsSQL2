package com.example.newsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView mTv_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTv_content = findViewById(R.id.content);
        NewsBean bean = (NewsBean) getIntent().getSerializableExtra("bean");
        mTv_content.setText(bean.getNewsContent());
    }
}
