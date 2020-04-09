package com.example.newsqlite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    Context mContext;
    List<NewsBean> mDatas;

    public ListAdapter(Context context, List<NewsBean> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        NewsBean bean = mDatas.get(position);
        holder.mTv_item.setText(bean.getNewsTitle());
        return convertView;
    }
    class ViewHolder{
        TextView mTv_item;
        public ViewHolder(View view) {
            mTv_item = view.findViewById(R.id.item_tv);
        }
    }
}
