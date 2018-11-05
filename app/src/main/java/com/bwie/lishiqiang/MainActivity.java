package com.bwie.lishiqiang;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件
        Toolbar mToolbar = findViewById(R.id.mToolbar);
        //设置背景颜色
        mToolbar.setBackgroundColor(Color.GREEN);
        //设置左上的点击退出的按钮
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
        //设置Navigation的点击事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "退出", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
