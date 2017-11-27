package com.example.recycleviewclickarea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    private String []fruitNameArray = new String[]{"apple","banana","cherry","grape","mango","orange","pear","pineapple","strawberry","watermelon"};
    private int []fruitIdArray = new int[]{R.mipmap.apple_pic,R.mipmap.banana_pic,R.mipmap.cherry_pic,R.mipmap.grape_pic,R.mipmap.mango_pic,
            R.mipmap.grape_pic,R.mipmap.pear_pic,R.mipmap.pineapple_pic,R.mipmap.strawberry_pic,R.mipmap.watermelon_pic};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruitList();
        FruitAdapter fruitAdapter = new FruitAdapter(fruitList, MainActivity.this);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fruitAdapter);


        DecimalFormat df = new DecimalFormat("0.##");
        Log.d("xuqiujing 2010","$ "+ df.format((float)2010/100f));
        Log.d("xuqiujing 210","$ "+ df.format((float)210/100f));
        Log.d("xuqiujing 2.13","$ "+ df.format((float)2.13/100f));
        Log.d("xuqiujing 123456.789456","$ "+ df.format((float)123456.789456/100f));
    }

    private void initFruitList(){
        for(int j=0;j<2;++j){
            for(int i=0; i<fruitNameArray.length;++i){
                Fruit fruit = new Fruit(fruitNameArray[i],fruitIdArray[i]);
                fruitList.add(fruit);
            }
        }
    }
}
