package com.custom.supereasydialog.view;

/**
 * @name zk
 * @class name：自定义dialog
 * @time 2017-11-02 下午 3:20
 */

public interface IEasyDialog {

    /**
     * 一个按钮
     */
    public static final int TYPE_BTN_ONE = 1;

    /**
     * 两个按钮
     */
    public static final int TYPE_BTN_TWO = 2;

    /**
     * 一个按钮的监听
     */
    public interface IBtnClickOne {
        /**
         * 点击事件
         */
        void click();
    }

    /**
     * 两个按钮的监听
     */
    public interface IBtnClickTwo {
        /**
         * 左侧按钮监听
         */
        void leftOnClick();

        /**
         * 右侧按钮监听
         */
        void rightOnClick();
    }
}
