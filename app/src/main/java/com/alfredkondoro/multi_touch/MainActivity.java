package com.alfredkondoro.multi_touch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        RelativeLayout mLayout = (RelativeLayout) findViewById (R.id.mLayout);

        mLayout.setOnTouchListener (new RelativeLayout.OnTouchListener () {
            public boolean onTouch(View v, MotionEvent m) {
                handleTouch(m);
                return true;
            }
        });
    }

    private void handleTouch(MotionEvent m) {
        TextView firstTouch  = (TextView) findViewById (R.id.firstTouch);
        TextView secondTouch = (TextView) findViewById (R.id.secondTouch);

        int pointerCount = m.getPointerCount ();

        for(int i=0; i<pointerCount; i++){
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = m.getPointerId (i);

            String touchStatus = " ID " + id + "X: " + x + "Y: " +y;
            if(id==0)
                firstTouch.setText (touchStatus);
            else
                secondTouch.setText (touchStatus);
        }
    }
}