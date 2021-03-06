package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCFocusIndicatorView extends View {
    private static final int FOCUS_AREA_STROKE = 1;
    private int mFocusAreaStroke = 2;
    private Runnable mHideRunnable = new Runnable() {
        public void run() {
            AppMethodBeat.i(67338);
            TXCFocusIndicatorView.this.setVisibility(8);
            AppMethodBeat.o(67338);
        }
    };
    private Paint mPaint;
    private ScaleAnimation mScaleAnimation;
    private int mSize = 0;

    public TXCFocusIndicatorView(Context context) {
        super(context);
        AppMethodBeat.i(67232);
        init(null, 0);
        AppMethodBeat.o(67232);
    }

    public TXCFocusIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(67233);
        init(attributeSet, 0);
        AppMethodBeat.o(67233);
    }

    public TXCFocusIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(67234);
        init(attributeSet, i);
        AppMethodBeat.o(67234);
    }

    private void init(AttributeSet attributeSet, int i) {
        AppMethodBeat.i(67235);
        this.mPaint = new Paint();
        this.mFocusAreaStroke = (int) ((getContext().getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        this.mScaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.mScaleAnimation.setDuration(200);
        AppMethodBeat.o(67235);
    }

    public void show(int i, int i2, int i3) {
        AppMethodBeat.i(67236);
        removeCallbacks(this.mHideRunnable);
        this.mScaleAnimation.cancel();
        this.mSize = i3;
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.width = this.mSize;
        layoutParams.height = this.mSize;
        setVisibility(0);
        requestLayout();
        this.mScaleAnimation.reset();
        startAnimation(this.mScaleAnimation);
        postDelayed(this.mHideRunnable, 1000);
        AppMethodBeat.o(67236);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(67237);
        canvas.save();
        Rect rect = new Rect(0, 0, this.mSize, this.mSize);
        this.mPaint.setColor(-1);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setStrokeWidth((float) this.mFocusAreaStroke);
        canvas.drawRect(rect, this.mPaint);
        canvas.restore();
        super.onDraw(canvas);
        AppMethodBeat.o(67237);
    }
}
