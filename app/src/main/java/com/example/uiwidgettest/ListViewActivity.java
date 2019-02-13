package com.example.uiwidgettest;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout); //该layout中仅指定了id和长宽

        initFruits(); // 初始化水果数据，将水果名称和图片加到fruitList 这个ArrayList中
        FruitAdapter adapter = new FruitAdapter(ListViewActivity.this,
                R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        //鼠标响应
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewActivity.this, fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * initFruits() ：将水果名称和图片加到List<Fruit> fruitList = new ArrayList<>()中
     */
    private void initFruits()
    {
        /*
        * for 循环将所有的水果数据添加了两遍，
        * 这是因为如果只添加一遍的话， 数据量还不足以充满整个屏幕*/
        for (int i = 0; i < 2; i++)
        {
            Fruit apple = new Fruit("Apple", R.drawable.img_1);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.img_1);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.img_1);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.img_1);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.img_1);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.img_1);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.img_1);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.img_1);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.img_1);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.img_1);
            fruitList.add(mango);
        }
    }

}