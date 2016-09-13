package com.codekul.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity {

    public static final String KEY_MY_RES = "myResult";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent responsibleIntent = getIntent();

        Bundle bundle = responsibleIntent.getExtras();
        if(bundle != null) {
            String myName = bundle.getString(MainActivity.KEY_MY_NAME);
            Boolean bool = bundle.getBoolean(MainActivity.KEY_BOOL);

            ((EditText)findViewById(R.id.edtResult)).setText(myName + System.currentTimeMillis());
        }

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                Bundle bundleBack = new Bundle();
                bundleBack.putString(KEY_MY_RES,((EditText)findViewById(R.id.edtResult)).getText().toString());

                intent.putExtras(bundleBack);

                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
