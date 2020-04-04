package com.xiayiye.yhshmvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.xiayiye.yhshmvp.R;

/**
 * @author xiayiye
 * Java版本的Activity页面跳转Kotlin版本的Activity页面的方法
 */
public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        Button btToKotlin = findViewById(R.id.bt_to_kotlin);
        btToKotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //方法一
//                MvpPageActivity.Companion.start(JavaActivity.this);
                //方法二
                startActivity(new Intent(JavaActivity.this,MvpPageActivity.class));
            }
        });
    }
}
