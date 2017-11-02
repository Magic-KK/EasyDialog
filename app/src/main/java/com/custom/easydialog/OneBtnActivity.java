package com.custom.easydialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.custom.supereasydialog.view.EasyDialog;
import com.custom.supereasydialog.view.IEasyDialog;

/**
 * @name zk
 * @class name：一个按钮
 * @time 2017-11-02 下午 5:03
 */
public class OneBtnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onebtn);
        initView();
    }

    private void initView() {
        Button btn_show = (Button) findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }


    private void showDialog() {
        final EasyDialog dialog = new EasyDialog(EasyDialog.DEFAULT_ONE_BTN, this);
        dialog.show();
        //设置标题
        dialog.setTitle("这是标题");
        //设置内容
        dialog.setContent("这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容");
        //设置按钮名字
        dialog.setBtnName("确定");

        dialog.setDefaultClickOne(new IEasyDialog.IBtnClickOne() {
            @Override
            public void click() {
                Toast.makeText(OneBtnActivity.this, "点击", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
}
