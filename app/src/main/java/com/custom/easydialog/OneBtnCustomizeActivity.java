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
 * @class name：自定义单按钮界面
 * @time 2017-11-02 下午 6:45
 */
public class OneBtnCustomizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_btn_customize);
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
        final EasyDialog dialog = new EasyDialog(R.layout.dialog_one, this);
        dialog.show();
        dialog.setOneBtnDialog(R.id.button_ok, new IEasyDialog.IBtnClickOne() {
            @Override
            public void click() {
                Toast.makeText(OneBtnCustomizeActivity.this, "click", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });



    }
}
