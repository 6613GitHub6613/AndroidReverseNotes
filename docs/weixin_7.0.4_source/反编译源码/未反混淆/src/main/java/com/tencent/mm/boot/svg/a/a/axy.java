package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class axy extends c {
    private final int height = 54;
    private final int width = 54;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 54;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                k = c.a(k2, looper);
                k.setStrokeWidth(1.0f);
                Paint a = c.a(k, looper);
                a.setColor(-1);
                a.setStrokeWidth(3.9f);
                canvas.save();
                k = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(36.0f, 0.0f);
                l.lineTo(36.0f, 17.044964f);
                l.lineTo(53.893173f, 17.044964f);
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(a, looper);
                g = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 89.04497f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l2 = c.l(looper);
                l2.moveTo(36.0f, 36.0f);
                l2.lineTo(36.0f, 53.044964f);
                l2.lineTo(53.893173f, 53.044964f);
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l3 = c.l(looper);
                l3.moveTo(17.893173f, 53.044964f);
                l3.lineTo(17.893173f, 36.0f);
                l3.lineTo(0.0f, 36.0f);
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                canvas.drawPath(l3, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                l3 = c.l(looper);
                l3.moveTo(17.893017f, 0.032633092f);
                l3.lineTo(17.893017f, 17.077597f);
                l3.lineTo(-1.5652174E-4f, 17.077597f);
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                canvas.drawPath(l3, a3);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
