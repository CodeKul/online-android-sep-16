package com.codekul.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_MY_NAME = "myName";
    public static final String KEY_BOOL = "boolean";
    public static final int REQ_NEW = 1234;

    /*
        * 1. Starting new activity
        * 2. Sending data to new activity
        * 3. getting data in new activity
        * 4. throwing data back from new activity to previous activity
        *
        *   aniruddha.kudalkar@gmail.com
        * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NewActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString(KEY_MY_NAME,"codekul.com");
                bundle.putBoolean(KEY_BOOL,true);

                intent.putExtras(bundle);

                //startActivity(intent);

                startActivityForResult(intent,REQ_NEW);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_NEW){

            if(resultCode == RESULT_OK){

                Bundle bundleBack = data.getExtras();
                String resultBack = bundleBack.getString(NewActivity.KEY_MY_RES);
            }
        }
    }
}
