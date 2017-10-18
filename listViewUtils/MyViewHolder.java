package com.sanjianke.news.application.adapter.myViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Administrator on 2015/11/9.
 */
public class MyViewHolder {
    private View mConvertView;//返回给 listview 的 view

    public MyViewHolder(Context context, int resID) {
        mConvertView = LayoutInflater.from(context).inflate(resID, null);//加载布局生成 view
        // mConvertView=//////
        mConvertView.setTag(this);// 给 view 设置当前 viewholder 为 tag
    }

    public View getmConvertView() {
        return mConvertView;
    }

    /**
     * @param convertView listview 的覆用 view,根据它的值是否为 null 来判断是否生成新的 view
     * @param context
     * @param resID
     * @return
     */
    public static MyViewHolder getView(View convertView, Context context, int resID) {
        MyViewHolder myHolder = null;
        if (convertView == null) {
            myHolder = new MyViewHolder(context, resID);// 如果为 null 的情况下代表没有可以复用的 view, 需要创建新的
        } else {
            myHolder = (MyViewHolder) convertView.getTag();//因为创建的时候顺便给了 tag. 所以可以根据 tag 再重新获取到 viewholder
        }
        return myHolder;
    }

    /**
     * findviewbyid 方法
     *
     * @param id
     * @return
     */
    public View findView(int id) {

        return mConvertView.findViewById(id);
    }

}