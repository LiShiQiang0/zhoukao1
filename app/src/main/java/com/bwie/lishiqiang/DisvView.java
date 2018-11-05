package com.bwie.lishiqiang;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.RotateAnimation;

/**
 * date:2018/11/5/005
 * author:李世强(北冥有鱼)
 * funcion
 */
public class DisvView  extends View implements View.OnClickListener {

    private int x;
    private int y;
    private RectF rectF;
    private int color[] = {R.color.col4,Color.parseColor("#c7c4c4"),Color.parseColor("#f4e804"),Color.parseColor("#42dc0e"),Color.parseColor("#7c54da"),Color.parseColor("#e67575")};
    private Paint mPaint;
    private Rect mRect;
    private RectF rectF1;
    private boolean flag;
    private   RotateAnimation rotateAnimation;

    String text[] = {"一等奖","二等奖","三等奖","四等奖","参与奖","谢谢参与"};
    public DisvView(Context context) {
        this(context,null);
    }

    public DisvView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DisvView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取屏幕的属性
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        //获取屏幕的宽高
        int width = displayMetrics.widthPixels;
        int heigh = displayMetrics.heightPixels;
        //重置圆点的位置
        x = width / 2;
        y = heigh / 2;

        this.setOnClickListener(this);
        //初始化画笔
        initPaint();
        //设置属性动画
        initAnim();
    }

    private void initAnim() {
        rotateAnimation = new RotateAnimation(0, 720, x, y);
        rotateAnimation.setDuration(4000);
    }

    private void initPaint() {
        mPaint = new Paint();
        //设画笔颜色
        mPaint.setColor(Color.RED);
        //设置画笔的宽度
        mPaint.setStrokeWidth(8);
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //设置画笔的属性
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(x,y);
        rectF = new RectF(-300,-300,300,300);

        for (int i = 0  ; i< 6 ; i++){
            mPaint.setColor(color[i]);
            canvas.drawArc(rectF,360/6 * i , 60 , true,mPaint);
        }
        //绘制内部的小圆
        mPaint.setColor(Color.RED);
        canvas.drawCircle(0,0,100,mPaint);

        //绘制中间展示字的矩形

        rectF1 = new RectF(-200, -200, 200, 200);
        mPaint.setTextSize(40);
        for (int i = 0 ; i< 6 ; i++){
            //设置字体颜色
            mPaint.setColor(Color.RED);
            //创建Path
            Path path = new Path();
            path.addArc(rectF1,360 / 6 * i + 13,60);
            canvas.drawTextOnPath(text[i],path,0,0,mPaint);

        }

        //设置小圆内的字体
        Rect rect = new Rect();
        mPaint.setColor(Color.WHITE);
        mPaint.getTextBounds("start",0,5,rect);
        int width = rect.width();
        int height =  rect.height();
        canvas.drawText("start", - width / 2 , height / 2,mPaint );


    }

    @Override
    public void onClick(View v) {
        if(flag){
            flag = false;
            clearAnimation();

        }else{
            flag = true;
            startAnimation(rotateAnimation);
        }
    }
}
