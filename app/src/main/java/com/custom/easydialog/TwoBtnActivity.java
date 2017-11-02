package com.custom.easydialog;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.custom.supereasydialog.view.EasyDialog;
import com.custom.supereasydialog.view.IEasyDialog;

/**
 * @name zk
 * @class name：两个按钮
 * @time 2017-11-02 下午 6:37
 */

public class TwoBtnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_btn);
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
        final EasyDialog dialog = new EasyDialog(EasyDialog.DEFAULT_TWO_BTN, this);
        dialog.show();
        //设置标题
        dialog.setTitle("这是标题");
        //设置内容
        dialog.setContent("这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容");
        //设置左侧按钮名字
        dialog.setLeftBtnName("确定");
        //设置右侧按钮名字
        dialog.setRightBtnName("取消");


        dialog.setDefaultClickTwo(new IEasyDialog.IBtnClickTwo() {
            @Override
            public void leftOnClick() {
                Toast.makeText(TwoBtnActivity.this, "left click", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            @Override
            public void rightOnClick() {
                Toast.makeText(TwoBtnActivity.this, "right click", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

}
