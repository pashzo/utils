package com.example.administrator.fish.baseAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.fish.baseHolder.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2015/11/3.
 */
public abstract class MyBaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    private List<T> data;
    private Context context;
    private int Layout;

    public MyBaseAdapter(List<T> data, Context context, int Layout) {
        this.data = data;
        this.context = context;
        this.Layout = Layout;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(Layout, null);

        BaseViewHolder viewHolder = creatViewHold(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder myholder, int i) {
       fillData(myholder,i);
    }

    @Override
    public void onViewRecycled(BaseViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        if (data!=null){
            return data.size();
        }
        return 0;
    }

    public View findView(BaseViewHolder myholder,int ret){
        View view = myholder.itemView.findViewById(ret);
        return view;
    }

    public abstract void fillData(BaseViewHolder myholder,int positin);


    public abstract BaseViewHolder creatViewHold(View view);
}
