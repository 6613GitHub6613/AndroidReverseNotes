package com.tencent.youtu.ytagreflectlivecheck.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController;

public class YTReflectLayout extends RelativeLayout {
    private ColorMatrixColorFilter mColorMatrixColorFilter;
    private Paint mPaint = new Paint(1);
    private Rect mRect = new Rect();

    public YTReflectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(123195);
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setColor(Color.argb(200, 0, 0, 0));
        this.mColorMatrixColorFilter = ReflectController.DEFAULT_MATRIX_COLOR_FILTER;
        setWillNotDraw(false);
        AppMethodBeat.o(123195);
    }

    public void setColorMatrixColorFilter(ColorMatrixColorFilter colorMatrixColorFilter) {
        AppMethodBeat.i(123196);
        this.mColorMatrixColorFilter = colorMatrixColorFilter;
        invalidate();
        AppMethodBeat.o(123196);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(123197);
        super.onDraw(canvas);
        this.mPaint.setColorFilter(this.mColorMatrixColorFilter);
        this.mRect.set(0, 0, getWidth(), getHeight());
        canvas.drawRect(this.mRect, this.mPaint);
        AppMethodBeat.o(123197);
    }
}
