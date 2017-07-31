package com.example.listviewclickarea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this, R.layout.layout_item_match_parent, fruitList);
        ListView listView = (ListView)findViewById(R.id.fruit_listview);
        listView.setAdapter(fruitAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Fruit fruit = fruitList.get(position);
//                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
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
