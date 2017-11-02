package com.custom.supereasydialog.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.custom.supereasydialog.R;

/**
 * @name zk
 * @class name：自定义dialog
 * @time 2017-11-02 下午 3:16
 */

public class EasyDialog extends Dialog {

    private IEasyDialog.IBtnClickOne iBtnClickOne;

    private IEasyDialog.IBtnClickTwo iBtnClickTwo;

    /**
     * 默认样式按钮 一个按钮
     */
    public static final int DEFAULT_ONE_BTN = 32;

    /**
     * 默认样式按钮 两个按钮
     */
    public static final int DEFAULT_TWO_BTN = 33;


    /**
     * 布局文件
     */
    private int mRes;

    /**
     * 布局view
     */
    private View view;


    /**
     * 一个按钮监听器
     *
     * @param btnid    按钮id
     * @param listenrt
     */
    public void setOneBtnDialog(int btnid, IEasyDialog.IBtnClickOne listenrt) {
        this.iBtnClickOne = listenrt;
        btnOneMonitor(btnid);
    }


    /**
     * 两个按钮监听器
     *
     * @param iBtnClickTwo
     * @param left         左侧按钮
     * @param right        右侧按钮
     */
    public void setBtnClickTwo(int left, int right, IEasyDialog.IBtnClickTwo iBtnClickTwo) {
        this.iBtnClickTwo = iBtnClickTwo;
        btnTwoMonitor(left, right);
    }


    /**
     * 默认布局单按钮监听器
     *
     * @param listenrt
     */
    public void setDefaultClickOne(IEasyDialog.IBtnClickOne listenrt) {
        this.iBtnClickOne = listenrt;
        btnOneMonitor(R.id.alert_ok);
    }

    /**
     * 默认布局两个按钮布局
     *
     * @param iBtnClickTwo
     */
    public void setDefaultClickTwo(IEasyDialog.IBtnClickTwo iBtnClickTwo) {
        this.iBtnClickTwo = iBtnClickTwo;
        btnTwoMonitor(R.id.confirm_cancel, R.id.confirm_ok);
    }

    /**
     * 单按钮默认布局样式
     */
    public void setDefaultOneBtn() {

    }


    /**
     * 设置标题(默认样式)
     */
    public void setTitle(String title) {
        if (view != null) {
            if (mRes == DEFAULT_ONE_BTN) {
                TextView alert_title = (TextView) view.findViewById(R.id.alert_title);
                alert_title.setText(title);
            } else if (mRes == DEFAULT_TWO_BTN) {
                TextView alert_title = (TextView) view.findViewById(R.id.confirm_title);
                alert_title.setText(title);
            }
        }
    }

    /**
     * 设置内容(默认样式)
     */
    public void setContent(String content) {
        if (view != null) {
            if (mRes == DEFAULT_ONE_BTN) {
                TextView alert_title = (TextView) view.findViewById(R.id.alert_content);
                alert_title.setText(content);
            } else if (mRes == DEFAULT_TWO_BTN) {
                TextView alert_title = (TextView) view.findViewById(R.id.confirm_content);
                alert_title.setText(content);
            }
        }
    }

    /**
     * 设置按钮名字 单个按钮有效(默认样式)
     */
    public void setBtnName(String btnname) {
        if (view != null) {
            if (mRes == DEFAULT_ONE_BTN) {
                TextView alert_title = (TextView) view.findViewById(R.id.alert_ok);
                alert_title.setText(btnname);
            }
        }
    }

    /**
     * 设置左侧按钮名字(默认样式)
     */
    public void setLeftBtnName(String name) {
        if (view != null) {
            if (mRes == DEFAULT_TWO_BTN) {
                TextView confirm_cancel = (TextView) view.findViewById(R.id.confirm_cancel);
                confirm_cancel.setText(name);
            }
        }

    }

    /**
     * 设置右侧按钮名字(默认样式)
     */
    public void setRightBtnName(String name) {
        if (view != null) {
            if (mRes == DEFAULT_TWO_BTN) {
                TextView confirm_ok = (TextView) view.findViewById(R.id.confirm_ok);
                confirm_ok.setText(name);
            }
        }
    }


    /**
     * 上下人
     */
    private Context mContext;

    /**
     * 初始化布局  默认样式
     *
     * @param res
     * @param context
     */
    public EasyDialog(int res, @NonNull Context context) {
        super(context, R.style.dialog_style);
        this.mContext = context;
        this.mRes = res;
    }


    /**
     * 初始化布局 带样式
     *
     * @param res        布局文件
     * @param context
     * @param themeResId
     */
    public EasyDialog(int res, @NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.mContext = context;
        this.mRes = res;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mRes == DEFAULT_ONE_BTN) {  //默认单按钮
            view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_alert, null);
        } else if (mRes == DEFAULT_TWO_BTN) {  //默认多按钮
            view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_confirm, null);
        } else {
            view = LayoutInflater.from(getContext()).inflate(mRes, null);
        }
        setContentView(view);
    }

    /**
     * 一个按钮处理
     *
     * @param btnid
     */
    private void btnOneMonitor(int btnid) {
        View views = view.findViewById(btnid);
        views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iBtnClickOne != null) {
                    iBtnClickOne.click();
                }
            }
        });
    }


    /**
     * 获取view布局
     *
     * @return
     */
    public View getView() {
        return view;
    }


    /**
     * 两个按钮处理
     *
     * @param left
     * @param right
     */
    private void btnTwoMonitor(int left, int right) {
        View lefts = view.findViewById(left);
        View rights = view.findViewById(right);

        lefts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iBtnClickTwo != null) {
                    iBtnClickTwo.leftOnClick();
                }
            }
        });

        rights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iBtnClickTwo != null) {
                    iBtnClickTwo.rightOnClick();
                }
            }
        });
    }
}
