package com.example.dell.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        bindViewData();
    }

    private void bindViewData() {
        ArrayList<String> list = new ArrayList<>();
        list.add("小美工");
        list.add("行啊哦那个美国");
        list.add("行啊哦那个美国");
        list.add("行啊哦那个美国");
        HashMap<String, Object> obj = new HashMap<>();
        obj.put(RecyclerViewAdapter.mlast, list);
        ArrayList<Sutdy> sutdies = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Sutdy sutdy = new Sutdy();
            sutdy.setButtonName("按钮" + i);
            sutdy.setName("苍井空" + i);
            sutdy.setImage(R.mipmap.apng);
            if (i == 1)
                sutdy.setShowProgress(false);
            else
                sutdy.setShowProgress(true);
            sutdies.add(sutdy);
        }
        obj.put(RecyclerViewAdapter.mFirst, sutdies);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(obj, this);
//        Radapter radapter = new Radapter(list,this);
        GridLayoutManager manager = new GridLayoutManager(this,1);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    }

    public class Sutdy {
        private String name;
        private boolean isShowProgress;
        private int image;
        private String buttonName;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isShowProgress() {
            return isShowProgress;
        }

        public void setShowProgress(boolean showProgress) {
            isShowProgress = showProgress;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getButtonName() {
            return buttonName;
        }

        public void setButtonName(String buttonName) {
            this.buttonName = buttonName;
        }
    }
}
