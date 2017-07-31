package com.example.listviewclickarea;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */

public class FruitAdapter extends ArrayAdapter {
    private int resourceId;
    private Context mContext;
    public FruitAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
        resourceId = resource;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        final ViewHolder viewHolder;
        if(null != convertView){
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }else{
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView)view.findViewById(R.id.iv_fruit_icon);
            viewHolder.fruitName = (TextView)view.findViewById(R.id.tv_fruit_name);
            view.setTag(viewHolder);
        }

        Fruit fruit = (Fruit) getItem(position);
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());

        view.findViewById(R.id.rl_fruit_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, viewHolder.fruitName.getText(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(mContext,ShowChooseActivity.class);
//                intent.putExtra("fruit_name",viewHolder.fruitName.getText());
//                mContext.startActivity(intent);
            }
        });
        return view;
    }

    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
