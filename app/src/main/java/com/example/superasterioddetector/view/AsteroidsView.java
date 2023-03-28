package com.example.superasterioddetector.view;

import static java.lang.Thread.sleep;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

import com.example.superasterioddetector.R;
import com.example.superasterioddetector.model.Asteroids;

import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;

public class AsteroidsView extends View {
    private Paint strokeWhite;
    private Paint fillYellow;
    private Paint fillBlue;
    private Paint fillRed;
    private Asteroids asteroids;
    private static final float EARTH_SUN_DISTANCE = 149597870;
    private int angle = 1;

    public AsteroidsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AsteroidsView(Context context) {
        super(context);
        init();
    }

    public AsteroidsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setAsteroids(Asteroids asteroids) {
        this.asteroids = asteroids;
        invalidate(); //rappelle undraw
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        float radius = 100;


        //Asteroids asteroids = (Asteroids) getTag();
        //String distance = asteroids.getDistance();
        //int earthDistance = 149200000;
        //float size = (float) (Double.parseDouble(distance)/earthDistance);
        //float size = 0.5F;

        canvas.translate(width/2, height/2);

        //sun
        canvas.drawCircle(0, 0, 70, fillYellow);

        //orbit
        canvas.drawCircle(0, 0, width/2-30, strokeWhite);

        canvas.rotate(angle*2, 0, 0);

        canvas.translate(width/2-30, 0);

        //Terre
        canvas.rotate(angle, 0, 0);

        canvas.drawCircle(0, 0, 40, fillBlue);

        if(asteroids != null){
            float distancePercent = Float.parseFloat(asteroids.getDistance())/EARTH_SUN_DISTANCE;

            canvas.drawCircle(0, 0, (width/2 -30)*distancePercent, strokeWhite);

            canvas.rotate(45, 0, 0);
            canvas.drawCircle(-1*(width/2 -30)*distancePercent, 0, 20, fillRed);
        }

        postDelayed(new Runnable() {
            @Override
            public void run() {
                angle++;
                invalidate();
            }
        },20);


        //Sun
        //canvas.drawCircle(0, 0, radius, fillYellow);

        /*
        //float circle_x = radius+370;
        //canvas.drawCircle(0, 0, circle_x, strokeWhite);


        float theta = (float) Math.PI/6;
        float earth_x = (float) (circle_x) * (float) Math.cos(theta);
        float earth_y = (float)(circle_x)* (float) Math.sin(theta);
        canvas.drawCircle(earth_x, earth_y, radius/2, fillBlue);

        canvas.drawCircle(earth_x, earth_y, 100, strokeWhite);

        float theta_red = (float) 0;
        float red_x = (float) earth_x + (100) * (float) Math.cos(theta_red);
        float red_y = (float) earth_y + (100)  * (float) Math.sin(theta_red);
        canvas.drawCircle(red_x, red_y, radius/2*size, fillRed);

*/

    }

    public void init(){
        Resources resources = getResources();
        this.strokeWhite = new Paint();
        this.strokeWhite.setStyle(Paint.Style.STROKE);
        this.strokeWhite.setStrokeWidth(4f);
        this.strokeWhite.setColor(resources.getColor(R.color.orbit));

        this.fillYellow = new Paint();
        this.fillYellow.setStyle(Paint.Style.FILL);
        this.fillYellow.setColor(resources.getColor(R.color.sun));
        this.fillYellow.setColor(Color.YELLOW);

        this.fillBlue = new Paint();
        this.fillBlue.setStyle(Paint.Style.FILL);
        this.fillBlue.setColor(resources.getColor(R.color.earth));
        this.fillBlue.setColor(Color.BLUE);

        this.fillRed = new Paint();
        this.fillRed.setStyle(Paint.Style.FILL);
        this.fillRed.setColor(resources.getColor(R.color.red));
        this.fillRed.setColor(Color.RED);

    }


}
