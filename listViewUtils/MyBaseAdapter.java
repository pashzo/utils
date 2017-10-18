package com.sanjianke.news.application.adapter.baseAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sanjianke.news.application.adapter.myViewHolder.MyViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2015/11/9.
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private List<T> list;
    private Context context;//创建布局填充器
    private int resID;

    public MyBaseAdapter(List<T> list, Context context, int resID) {
        this.list = list;
        this.context = context;
        this.resID = resID;
    }

    @Override
    public int getCount() {
        if (list != null) {

            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //我们可以把 view 放到另外一个类中返回
        MyViewHolder viewHolder = MyViewHolder.getView(convertView, context, resID);
        fillData(viewHolder, position);
        return viewHolder.getmConvertView();
    }
    public abstract void fillData(MyViewHolder myHolder, int position);
}

