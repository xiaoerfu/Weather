package com.example.wether;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    final Timer timer=new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

//        /*隐藏标题栏*/
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null){
//            actionBar.hide();
//        }
                /*沉浸式状态栏*/
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_FULLSCREEN                      //全屏模式
//                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE              //根据布局文件
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);       //显示之后会消失，可以拉下来显示
//            getWindow().setStatusBarColor(Color.BLUE);
        }

        timerInit();
    }

    /*延时管理*/
    private void timerInit(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(StartActivity.this,WeatherActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(timerTask,3000);
    }

    /*监听手机回退键*/

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}
