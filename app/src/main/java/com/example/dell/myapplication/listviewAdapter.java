package com.example.dell.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication
 * @Package com.example.dell.myapplication
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/8/22 21:43
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */


public class listviewAdapter extends BaseAdapter {

    private ArrayList<String> mData;
    private Context mContext;
    private final LayoutInflater mInflater;

    public listviewAdapter(ArrayList<String> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData == null ? null : mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View converview, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (converview == null) {
            converview = mInflater.inflate(R.layout.item_last, viewGroup,false);
            holder = new ViewHolder(converview);
            converview.setTag(holder);
        } else {
            holder = (ViewHolder) converview.getTag();
        }
        holder.mListview.setText(mData.get(i));
        return converview;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView mListview;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mListview = (TextView) rootView.findViewById(R.id.textView);
        }

    }
}
