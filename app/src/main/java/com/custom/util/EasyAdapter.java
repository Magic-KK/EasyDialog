package com.custom.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * 适配器基类
 *
 * @param <T>
 * @author frj
 */
public abstract class EasyAdapter<T> extends BaseAdapter {

    protected List<T> list;
    protected LayoutInflater mInflater;
    protected Context context;

    public EasyAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public T getItem(int position) {
        if (list != null) {
            return list.get(position);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 移除项
     *
     * @param position 项位置
     */
    public void remove(int position) {
        if (list != null) {
            if (list.size() > position) {
                list.remove(position);
                notifyDataSetChanged();
            }
        }
    }

    /**
     * 添加数据
     *
     * @param t
     */
    public void add(T t) {
        if (t == null) {
            return;
        }
        if (list == null) {
            list = new ArrayList<T>();
        }
        list.add(t);
        notifyDataSetChanged();
    }

    /**
     * 清除数据
     */
    public void clearList() {
        if (list != null) {
            list.clear();
            notifyDataSetChanged();
        }
    }

    /**
     * 添加集合对象
     *
     * @param list       集合对象
     * @param isLoadMore 表示是否是加载更多
     */
    public void addList(List<T> list, boolean isLoadMore) {
        if (list != null) {
            if (isLoadMore) {
                if (this.list == null) {
                    this.list = list;
                } else {
                    this.list.addAll(list);
                }
            } else {
                if (this.list == null) {
                    this.list = list;
                } else {
                    this.list.clear();
                    this.list.addAll(list);
                }
            }
            notifyDataSetChanged();
        }
    }

    /**
     * 返回当前适配器的项的集合
     *
     * @return
     */
    public List<T> getList() {
        return list;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);


}
