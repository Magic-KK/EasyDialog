package com.custom.easydialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.custom.supereasydialog.view.EasyDialog;

/**
 * @name zk
 * @class name：多按钮布局
 * @time 2017-11-02 下午 8:22
 */
public class MoreBtnCustomizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_btn_customize);
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
        final EasyDialog dialog = new EasyDialog(R.layout.dialog_home_start, this);
        dialog.show();
        //获取布局
        View view = dialog.getView();
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("你好");
    }
}
