package com.bywallof.assistance.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.bywallof.assistance.R;

import androidx.annotation.Nullable;

public class PositionIndicators extends View {

    Paint pActive = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pInactive = new Paint(Paint.ANTI_ALIAS_FLAG);

    int activeColor = Color.WHITE;
    int size = 1;
    int activatedIndex = 0;
    int width = -1;
    int height = -1;

    enum Direction{Vertical,Horizontal}

    public PositionIndicators(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray t = context.getTheme().obtainStyledAttributes(attrs,R.styleable.PositionIndicators, 0, 0);
        try{
            activeColor = t.getColor(R.styleable.PositionIndicators_activeColor, activeColor);
        }finally {
            t.recycle();
        }
    }

    public PositionIndicators(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray t = context.getTheme().obtainStyledAttributes(attrs,R.styleable.PositionIndicators, 0, 0);
        try{
            activeColor = t.getColor(R.styleable.PositionIndicators_activeColor, activeColor);
        }finally {
            t.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        pActive.setColor(activeColor);
        pActive.setStrokeWidth(3f);

        for(int x = 0; x < size; ++x)
        {
            if(activatedIndex == x)
            {
                canvas.drawCircle(100,100, 50, pActive);
            }
        }
    }

    @Override
    public ViewGroup.LayoutParams getLayoutParams() {
        //ViewGroup.LayoutParams params = new ViewGroup.LayoutParams()
        return super.getLayoutParams();
    }
}
