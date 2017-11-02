package com.custom.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.custom.easydialog.R;
import com.custom.util.EasyAdapter;
import com.custom.util.ViewHolder;

/**
 * @name zk
 * @class name：首页列表适配器
 * @time 2017-11-02 下午 4:54
 */
public class HomeAdapter extends EasyAdapter<String> {


    public HomeAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.home_item, null);
        }

        TextView tv_title = ViewHolder.get(convertView, R.id.tv_title);
        tv_title.setText(getItem(position));
        return convertView;
    }
}
