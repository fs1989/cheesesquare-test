package com.support.android.designlibdemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.support.android.designlibdemo.CheeseDetailActivity;
import com.support.android.designlibdemo.Cheeses;
import com.support.android.designlibdemo.FeedItem;
import com.support.android.designlibdemo.R;

import java.util.List;

/**
 * Created by Dan on 2016-01-15.
 */
public class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private List<FeedItem> mdata;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public Integer id;
        public final TextView likes;
        public final TextView name;
        public final TextView desc;
        public final TextView time;
        public final ImageView avatar;
        public final ImageView image;


        public ViewHolder(View view) {
            super(view);
            mView = view;

            likes = (TextView) view.findViewById(R.id.likes);
            name = (TextView) view.findViewById(R.id.name);
            desc = (TextView) view.findViewById(R.id.desc);
            time = (TextView) view.findViewById(R.id.time);
            avatar = (ImageView) view.findViewById(R.id.avatar);
            image = (ImageView) view.findViewById(R.id.image);
        }

    }


    public SimpleStringRecyclerViewAdapter(Context context, List<FeedItem> items) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        mdata = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemLayout  = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        itemLayout .setBackgroundResource(mBackground);
        return new ViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ViewHolder viewHolder = new ViewHolder(holder.mView);

        holder.id = mdata.get(position).getId();

        viewHolder.likes.setText(mdata.get(position).getLikes().toString());
        viewHolder.name.setText(mdata.get(position).getName().toString());
        viewHolder.desc.setText(mdata.get(position).getDesc().toString());

//        holder.mTextView.setText(mdata.get(position).getName());

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Context context = v.getContext();
//                Intent intent = new Intent(context, CheeseDetailActivity.class);
//                intent.putExtra(CheeseDetailActivity.EXTRA_NAME, holder.mBoundString);
//
//                context.startActivity(intent);
//            }
//        });

//        Glide.with(holder.mImageView.getContext())
//                .load(Cheeses.getRandomCheeseDrawable())
//                .fitCenter()
//                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        System.out.println("mdata size: " + mdata.size());
        return mdata.size();
    }
}
