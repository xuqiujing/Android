package com.example.recycleviewclickarea;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> fruitList;
    public Context mContext;

    public FruitAdapter(List<Fruit> fruitList, Context context) {
        this.fruitList = fruitList;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_fruit_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        //viewHolder.fruitView是Item最外层布局，rlFruitItem是设定点击区域
        viewHolder.rlFruitItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = fruitList.get(position);
                Toast.makeText(v.getContext(), fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        //指定点击区域
//        view.findViewById(R.id.rl_fruit_item).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, viewHolder.fruitName.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;
        LinearLayout rlFruitItem;
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(View itemView) {
            super(itemView);
            fruitView = itemView;
            rlFruitItem = (LinearLayout) itemView.findViewById(R.id.rl_fruit_item);
            fruitImage = (ImageView)itemView.findViewById(R.id.iv_fruit_icon);
            fruitName = (TextView)itemView.findViewById(R.id.tv_fruit_name);
        }
    }
}
