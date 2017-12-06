package com.example.razor.intent_implicit_phone_sms;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.health.PackageHealthStats;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int CALL = 1;
    private static String[] PERMISSIONS = {

            Manifest.permission.CALL_PHONE

    };

    public void callsomeone(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS, CALL);

        }
    }

    Button btncall;
    Button btnsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callsomeone(MainActivity.this);

        btncall = (Button) findViewById(R.id.btnphone);
        btnsms = (Button) findViewById(R.id.btnsms);

        btncall.setOnClickListener(MainActivity.this);
        btnsms.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnphone:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] { Manifest.permission.CALL_PHONE},CALL);
                }else {
                    Intent intentphone = new Intent(Intent.ACTION_CALL);
                    intentphone.setData(Uri.parse("tel:085320288825"));
                    startActivity(intentphone);
                }
                break;

            case R.id.btnsms:
                break;

        }

    }
}
