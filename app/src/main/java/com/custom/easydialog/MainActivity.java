package com.custom.easydialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.custom.adapter.HomeAdapter;
import com.custom.supereasydialog.view.EasyDialog;
import com.custom.supereasydialog.view.IEasyDialog;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initData();
    }


    private void initView() {
        listview = (ListView) findViewById(R.id.listview);
    }

    private void initListener() {
        listview.setOnItemClickListener(this);
    }

    private void initData() {
        HomeAdapter adapter = new HomeAdapter(this);
        listview.setAdapter(adapter);
        adapter.add("单按钮默认样式");
        adapter.add("两个按钮默认样式");
        adapter.add("单按钮自定义样式");
        adapter.add("两个按钮自定义样式");
        adapter.add("多个按钮自定义样式");

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == 0) {  //单按钮
            jump(OneBtnActivity.class);
        } else if (i == 1) {  //多按钮
            jump(TwoBtnActivity.class);
        } else if (i == 2) { //自定义单选按钮
            jump(OneBtnCustomizeActivity.class);
        } else if (i == 3) { //自定义两个按钮
            jump(TwoBtnCustomzeActivity.class);
        } else if (i == 4) {
            jump(MoreBtnCustomizeActivity.class);
        }
    }

    public void jump(Class classs) {
        startActivity(new Intent(MainActivity.this, classs));
    }
}
