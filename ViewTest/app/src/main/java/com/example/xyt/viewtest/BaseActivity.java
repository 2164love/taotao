package com.example.xyt.viewtest;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
    public boolean  isHashPemssion(String... permissions)
    {
        for(String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }

        }
        return  true;

    }
   public void requestPermission(int code,String... permission){
       ActivityCompat.requestPermissions(this,permission,code);
   }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case 2000:
                if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                SD();
                }
                else
            {
                Toast.makeText(this,"未授予调用相机权限",1).show();
            }
                break;
            case 2001:
                if(grantResults[0]== PackageManager.PERMISSION_GRANTED) {
                    contacts();
                }
                else
                {
                    Toast.makeText(this,"未授予打电话权限",1).show();
                }
                break;
            default:
                break;
        }
    }

    public void SD()
    {

    }
    public void contacts()
    {

    }

}
