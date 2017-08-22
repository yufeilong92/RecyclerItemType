package com.example.dell.myapplication;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication
 * @Package com.example.dell.myapplication
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/8/22 20:41
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private HashMap<String, Object> map;
    private ArrayList<String> mData;
    private Context mContext;
    private final LayoutInflater mInflater;
    public static final String mFirst="first";
    public static final String mlast="lastt";
    private int mFirstView = R.layout.item_first;
    private int mlastView = R.layout.litemlastview;
    private int mType;

    public RecyclerViewAdapter(ArrayList<String> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);

    }

    public RecyclerViewAdapter(HashMap<String, Object> obj, MainActivity mContext) {
        this.map=obj;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (mType == mFirstView) {
            view = mInflater.inflate(mFirstView, parent, false);
            return new mfirstViewHolder(view);
        } else if (mType == mlastView) {
            view = mInflater.inflate(mlastView, parent, false);
            return new mlastViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (mType == mFirstView) {
            ArrayList<MainActivity.Sutdy> vo = (ArrayList<MainActivity.Sutdy>) map.get(mFirst);
            MainActivity.Sutdy sutdy = vo.get(position);
            mfirstViewHolder mfirstViewHolder = (mfirstViewHolder) holder;
            mfirstViewHolder.mTextView2.setText(sutdy.getName());
            mfirstViewHolder.mButton.setText(sutdy.getButtonName());
            mfirstViewHolder.mImageView.setImageResource(sutdy.getImage());
            mfirstViewHolder.mProgressBar.setVisibility(sutdy.isShowProgress()?View.VISIBLE:View.GONE);
        }
        if (mType == mlastView) {
            ArrayList<String> vo = (ArrayList<String>) map.get(mlast);
            mlastViewHolder mlastViewHolder = (mlastViewHolder) holder;
//            listviewAdapter listviewAdapter = new listviewAdapter(vo,mContext);

            Radapter radapter = new Radapter(vo,mContext);
            GridLayoutManager manager = new GridLayoutManager(mContext,1);
            manager.setOrientation(GridLayoutManager.VERTICAL);
            mlastViewHolder.mTextView.setLayoutManager(manager);
            mlastViewHolder.mTextView.setAdapter(radapter);
        }
    }

    @Override
    public int getItemCount() {
        return map.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                mType = mFirstView;
                break;
            case 1:
                mType = mlastView;
                break;
        }
        return position;
    }


    public static class mfirstViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView mTextView2;
        public Button mButton;
        public ProgressBar mProgressBar;
        public ImageView mImageView;
        public mfirstViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mTextView2 = (TextView) rootView.findViewById(R.id.textView2);
            this.mButton = (Button) rootView.findViewById(R.id.button);
            this.mProgressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
            this.mImageView = (ImageView) rootView.findViewById(R.id.imageView);
        }

    }

    public static class mlastViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView mTextView;

        public mlastViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mTextView = (RecyclerView) rootView.findViewById(R.id.listview);
        }

    }


}
