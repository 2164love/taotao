package com.example.xyt.viewtest;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.allenliu.badgeview.BadgeFactory;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.CheckedChange;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.CAMERA;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity/* implements ClickListener*/ {
    @ViewById(R.id.layout_include)
    RelativeLayout relativeLayout;
    @ViewById(R.id.tview)
    TextView tv;
    @ViewById(R.id.btn1)
    Button btn_SD;

    @ViewById(R.id.btn2)
    Button btn_Contacts;
    @ViewById(R.id.btn_callBack)
    Button btn_callBack;
    @ViewById(R.id.radioMale)
    RadioButton radioButton;
    @ViewById(R.id.checkBox)
    CheckBox checkBox;



    /* @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

         FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
         fab.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Snackbar.make(view, R.string.snakInfo, Snackbar.LENGTH_LONG)
                         .setAction("Action", null).show();
             }
         });
     }*/
    @Click(R.id.btn1)
    void clickSd() {
        if (!isHashPemssion(CAMERA)) {
            requestPermission(2000, CAMERA);
        } else {
            SD();
        }
    }

    @Click(R.id.btn2)
    void clickContacts() {
        if (!isHashPemssion(CALL_PHONE)) {
            requestPermission(2001, CALL_PHONE);
        } else {
            contacts();
        }
    }

    @Override
    public void SD() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent, 1);


    }


    @Override
    public void contacts() {

        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + "135xxxxxxxx");
        intent.setData(data);
        startActivity(intent);
        // }

    }

    @Click(R.id.btn_callBack)
    void setIntent() {
        //startActivity(new Intent(MainActivity.this,SettingsActivity.class));
        SettingsActivity_.intent(this).start();
    }


    @CheckedChange(R.id.radioMale)
    void setRadioGroup()
    {
        Toast.makeText(MainActivity.this, "男", 1).show();
    }
    @CheckedChange(R.id.radioFemale)
    void setRadioGroup1()
    {
        Toast.makeText(MainActivity.this, "女", 1).show();
    }

    @AfterViews
    void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //  DataBindingUtil.setContentView(this,R.layout.activity_main);
      /* FloatingActionButton fab = (FloatingActionButton) findViewById(fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.snakInfo, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        tv.setText("11111");
        Drawable drawableWeiHui = getResources().getDrawable(R.drawable.radiobutton);
        drawableWeiHui.setBounds(0, 0, 109, 109);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        radioButton.setCompoundDrawables(null, drawableWeiHui, null, null);//只放上面

        checkBox.setCompoundDrawables(null, drawableWeiHui, null, null);//只放上面
       /* BadgeFactory.create(this)
                .setTextColor(Color.WHITE)
                .setWidthAndHeight(25,25)
                .setBadgeBackground(Color.RED)
                .setTextSize(10)
                .setBadgeGravity(Gravity.RIGHT|Gravity.TOP)
                .setBadgeCount(20)
                .setShape(BadgeView.SHAPE_CIRCLE)
                .setMargin(0,0,5,0)
                .bind(tv);*/
         BadgeFactory.createCircle(this).setBadgeCount(20).setWidthAndHeight(25,25).bind(tv);
        // badgeView.unbind();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
