package com.app.lesfousdeprog.motstordus;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MemoRigolo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_rigolo);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


    }
}
