package com.example.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
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
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBarCircle;
    private ProgressBar progressBarBar;
    private int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button buttonAlert = (Button) findViewById(R.id.button_alert);
        Button buttonProgress = (Button) findViewById(R.id.button_progress);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBarBar = (ProgressBar) findViewById(R.id.progress_bar_bar) ;
        progressBarCircle = (ProgressBar) findViewById(R.id.progress_bar_circle) ;

        buttonAlert.setOnClickListener(this);   //类内的onClick接口作为监听函数
        buttonProgress.setOnClickListener(this);
        button.setOnClickListener(this);
        img=1;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //第一个按钮：换图，显示文字，显示进度条等功能
            case R.id.button:
                //换图
                if(img == 1)
                {
                    imageView.setImageResource(R.drawable.img_2);
                    img=2;
                }
                else
                {
                    imageView.setImageResource(R.drawable.img_1);
                    img=1;
                }
                //显示输入框的内容
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this, inputText,
                        Toast.LENGTH_SHORT).show();
                //显示圆形进度条
                if (progressBarCircle.getVisibility() == View.GONE) {
                    progressBarCircle.setVisibility(View.VISIBLE);
                } else {
                    progressBarCircle.setVisibility(View.GONE);
                }
                //长条形进度条
                int progress = progressBarBar.getProgress();
                progress = progress + 10;
                progressBarBar.setProgress(progress);
                break;
            //第二个按钮：显示alert dialog
            case R.id.button_alert:
                AlertDialog.Builder dialog = new AlertDialog.Builder (MainActivity.
                        this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.
                        OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }});
                dialog.setNegativeButton("Cancel", new DialogInterface.
                        OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
                break;
            //第三个按钮：显示progress dialog
            case R.id.button_progress:
                ProgressDialog progressDialog = new ProgressDialog
                        (MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                /*注意， 如果在setCancelable() 中传入了false ，
                表示ProgressDialog是不能通过Back键取消掉的，
                这时你就一定要在代码中做好控制，
                当数据加载完成后必须要调用ProgressDialog的dismiss() 方法来关闭对话框，
                否则ProgressDialog将会一直存在。*/
                break;
            default:
                break;
        }
    }}