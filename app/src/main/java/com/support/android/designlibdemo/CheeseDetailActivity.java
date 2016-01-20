/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.support.android.designlibdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.GetListener;

public class CheeseDetailActivity extends AppCompatActivity {

    FeedItem feedItem;

    String objectId;
    Integer id;
    Integer likes;
    String title;
    String brand;
    String price;
    String desc;
    String name;
    String avatar;
    String image;
    String time;
    String createAt;

    SliderLayout sliderShow;

    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getWidth();
    }

    //获取屏幕的高度
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getHeight();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        feedItem = (FeedItem) intent.getSerializableExtra("feedItem");
        objectId = feedItem.getObjectId();

        getData();

        sliderShow = (SliderLayout) findViewById(R.id.image);
        sliderShow.stopAutoCycle();

        DefaultSliderView textSliderView = new DefaultSliderView(this);
        textSliderView
                .description("Game of Thrones")
                .image(image);

        sliderShow.addSlider(textSliderView);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(feedItem.getTitle());

//        loadBackdrop();
    }

    void getData() {
        id = feedItem.getId();
        likes = feedItem.getLikes();
        title = feedItem.getTitle();
        brand = feedItem.getBrand();
        price = feedItem.getPrice();
        desc = feedItem.getDesc();
        name = feedItem.getName();
        avatar = feedItem.getAvatar();
        image = feedItem.getImage();
        time = feedItem.getTime();
        createAt = feedItem.getCreatedAt();
    }

    void getDataFromInternet() {
        BmobQuery<FeedItem> bmobQuery = new BmobQuery<FeedItem>();
        bmobQuery.getObject(this, objectId, new GetListener<FeedItem>() {
            @Override
            public void onSuccess(FeedItem object) {
                id = object.getId();
                likes = object.getLikes();
                title = object.getTitle();
                desc = object.getDesc();
                name = object.getName();
                avatar = object.getAvatar();
                image = object.getImage();
                time = object.getTime();
                createAt = object.getCreatedAt();
            }

            @Override
            public void onFailure(int code, String msg) {
                // TODO Auto-generated method stub
//                toast("查询失败：" + msg);
            }
        });
    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.image);

        int screenWidth = getScreenWidth(this);
        int screenHight = getScreenHeight(this);

        ViewGroup.LayoutParams lp = imageView.getLayoutParams();
        lp.width = screenWidth;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        imageView.setLayoutParams(lp);

        imageView.setMaxWidth(screenWidth);
        imageView.setMaxHeight(screenHight);

        Glide.with(this).load(image).crossFade().into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    protected void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }
}
