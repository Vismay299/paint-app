package com.example.practical6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TouchScreen extends View {
    Paint mypaint;
    Path mypath;
        public TouchScreen(Context context, AttributeSet attributeSet)
        {
            super(context,attributeSet);
            mypaint=new Paint();
            mypath=new Path();

            mypaint.setStrokeWidth(6f);
            mypaint.setColor(Color.RED);
            mypaint.setStyle(Paint.Style.STROKE);
            mypaint.setStrokeJoin(Paint.Join.ROUND);
        }

        public void onDrawForeground(Canvas canvas)
        {
            canvas.drawPath(mypath,mypaint);
        }
        public boolean onTouchEvent(MotionEvent event)
        {
            float event_x=event.getX();
            float event_y=event.getY();
            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN: mypath.moveTo(event_x,event_y);
                return true;
                case MotionEvent.ACTION_MOVE: mypath.lineTo(event_x,event_y);
                break;
                case MotionEvent.ACTION_UP: break;
                default:return false;
            }
            invalidate();
            return true;
        }

        public void clearCanvas()
        {
            invalidate();
            mypath.reset();
        }

        public void changeColor(String str)
        {
            mypaint.setColor(Color.parseColor(str));
        }
}
