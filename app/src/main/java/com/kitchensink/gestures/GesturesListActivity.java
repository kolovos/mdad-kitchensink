package com.kitchensink.gestures;
import java.text.MessageFormat;
import java.util.ArrayList;

import com.kitchensink.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;

import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;

import android.widget.Toast;

public class GesturesListActivity extends Activity  {
    private int REL_SWIPE_MIN_DISTANCE; 
    private int REL_SWIPE_MAX_OFF_PATH;
    private int REL_SWIPE_THRESHOLD_VELOCITY;
    ListView lv;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // As paiego pointed out, it's better to use density-aware measurements. 
        DisplayMetrics dm = getResources().getDisplayMetrics();
        REL_SWIPE_MIN_DISTANCE = (int)(120.0f * dm.densityDpi / 160.0f + 0.5); 
        REL_SWIPE_MAX_OFF_PATH = (int)(250.0f * dm.densityDpi / 160.0f + 0.5);
        REL_SWIPE_THRESHOLD_VELOCITY = (int)(200.0f * dm.densityDpi / 160.0f + 0.5);
             setContentView(R.layout.activity_gestures_list);
       // ListView lv = getListView();
              lv=(ListView)findViewById(R.id.list);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, 
            m_Starbucks));

        final GestureDetector gestureDetector = new GestureDetector(new MyGestureDetector());
        View.OnTouchListener gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event); 
            }};
        lv.setOnTouchListener(gestureListener);

        // Long-click still works in the usual way.
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String str = MessageFormat.format("Item long clicked = {0,number}", position);
                Toast.makeText(GesturesListActivity.this, str, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    // Do not use LitView.setOnItemClickListener(). Instead, I override 
    // SimpleOnGestureListener.onSingleTapUp() method, and it will call to this method when
    // it detects a tap-up event.
    private void myOnItemClick(int position) {
        String str = MessageFormat.format("Item clicked = {0,number}", position);
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    private void onLTRFling() {
        Toast.makeText(this, "Left-to-right fling", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure delete this contact?")
               .setCancelable(false)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        GesturesListActivity.this.finish();
                   }
               })
               .setNegativeButton("No", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                   }
               });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void onRTLFling() {
        Toast.makeText(this, "Right-to-left fling", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure delete this contact?")
               .setCancelable(false)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        GesturesListActivity.this.finish();
                   }
               })
               .setNegativeButton("No", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                   }
               });
        AlertDialog alert = builder.create();
        alert.show();
    }

    class MyGestureDetector extends SimpleOnGestureListener{ 

        // Detect a single-click and call my own handler.
        @Override 
        public boolean onSingleTapUp(MotionEvent e) {
          //  ListView lv = getListView();
            int pos = lv.pointToPosition((int)e.getX(), (int)e.getY());
            myOnItemClick(pos);
            return false;
        }

        @Override 
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) { 
            if (Math.abs(e1.getY() - e2.getY()) > REL_SWIPE_MAX_OFF_PATH) 
                return false; 
            if(e1.getX() - e2.getX() > REL_SWIPE_MIN_DISTANCE && 
                Math.abs(velocityX) > REL_SWIPE_THRESHOLD_VELOCITY) { 
                onRTLFling(); 
            }  else if (e2.getX() - e1.getX() > REL_SWIPE_MIN_DISTANCE && 
                Math.abs(velocityX) > REL_SWIPE_THRESHOLD_VELOCITY) { 
                onLTRFling(); 
            } 
            return false; 
        } 

    } 

    private static final String[] m_Starbucks = {
        "Latte", "Cappuccino", "Caramel Macchiato", "Americano", "Mocha", "White Mocha", 
        "Mocha Valencia", "Cinnamon Spice Mocha", "Toffee Nut Latte", "Espresso",
        "Espresso Macchiato", "Espresso Con Panna"
    };
}