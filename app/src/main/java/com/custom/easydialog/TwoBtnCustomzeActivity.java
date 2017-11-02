package com.custom.easydialog;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.custom.supereasydialog.view.EasyDialog;
import com.custom.supereasydialog.view.IEasyDialog;

public class TwoBtnCustomzeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_btn_customze);
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
        final EasyDialog dialog = new EasyDialog(R.layout.dialog_two, this);
        dialog.show();
        dialog.setBtnClickTwo(R.id.button_cancal, R.id.button_ok, new IEasyDialog.IBtnClickTwo() {
            @Override
            public void leftOnClick() {
                Toast.makeText(TwoBtnCustomzeActivity.this, "left onclick", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            @Override
            public void rightOnClick() {
                Toast.makeText(TwoBtnCustomzeActivity.this, "right onclick", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

}
