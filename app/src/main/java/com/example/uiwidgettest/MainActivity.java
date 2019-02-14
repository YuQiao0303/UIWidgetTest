package com.example.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //隐藏默认标题栏
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }

        Button buttonLinear = (Button) findViewById(R.id.button_linear);
        Button buttonRelative = (Button) findViewById(R.id.button_relative);
        Button buttonFrame = (Button) findViewById(R.id.button_frame);
        Button buttonPercent = (Button) findViewById(R.id.button_percent);
        Button buttonListView = (Button) findViewById(R.id.button_list_view);
        Button buttonRecyclerView = (Button) findViewById(R.id.button_recycler_view);

        buttonLinear.setOnClickListener(this);   //类内的onClick接口作为监听函数
        buttonRelative.setOnClickListener(this);
        buttonFrame.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonListView.setOnClickListener(this);
        buttonRecyclerView.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_linear:
                Intent intent = new Intent(MainActivity.this, LinearActivity.class);
                startActivity(intent);
                break;

            case R.id.button_relative:
                Intent intent2 = new Intent(MainActivity.this, RelativeActivity.class);
                startActivity(intent2);
                break;

            case R.id.button_frame:
                Intent intent3 = new Intent(MainActivity.this, FrameActivity.class);
                startActivity(intent3);
                break;
            case R.id.button_percent:
                Intent intent4 = new Intent(MainActivity.this, PercentActivity.class);
                startActivity(intent4);
                break;
            case R.id.button_list_view:
                Intent intent5 = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent5);
                break;
            case R.id.button_recycler_view:
                Intent intent6 = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent6);
                break;
            default:
                break;
        }
    }
}