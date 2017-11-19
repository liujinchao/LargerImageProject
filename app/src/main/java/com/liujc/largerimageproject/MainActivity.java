package com.liujc.largerimageproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.liujc.largerimagescaleview.LargerImageScaleView;
import com.liujc.largerimagescaleview.activity.viewpager.ViewPagerActivity;

import static com.liujc.largerimagescaleview.activity.viewpager.ViewPagerActivity.IMAGES_KEY;

public class MainActivity extends AppCompatActivity {
    LargerImageScaleView imageView;
    TextView target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private String[] IMAGES = { "ness.jpg", "squirrel.jpg" };
    private void initView() {
        target = (TextView) findViewById(R.id.tv_jump_to_target);
        target.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(MainActivity.this,ViewPagerActivity.class);
                intent3.putExtra(IMAGES_KEY, IMAGES);
                startActivity(intent3);
            }
        });
        imageView = (LargerImageScaleView)findViewById(R.id.imageView);
    }
}
