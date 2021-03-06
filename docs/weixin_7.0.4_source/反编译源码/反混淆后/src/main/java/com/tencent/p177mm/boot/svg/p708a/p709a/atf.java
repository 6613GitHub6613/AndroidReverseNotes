package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.atf */
public final class atf extends C5163c {
    private final int height = 90;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
                Paint k = C5163c.m7883k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = C5163c.m7883k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 30.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1.7763568E-15f, 0.0f);
                l.lineTo(6.0f, 0.0f);
                l.cubicTo(5.9900165f, 2.0f, 5.9900165f, 4.0f, 6.0f, 6.0f);
                l.lineTo(1.7763568E-15f, 6.0f);
                l.lineTo(1.7763568E-15f, 0.0f);
                l.lineTo(1.7763568E-15f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(10.0f, 0.0f);
                l.lineTo(16.0f, 0.0f);
                l.lineTo(16.0f, 6.0f);
                l.lineTo(10.0f, 6.0f);
                l.cubicTo(10.009983f, 4.0f, 10.009983f, 2.0f, 10.0f, 0.0f);
                l.lineTo(10.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(21.0f, 0.0f);
                l2.lineTo(27.0f, 0.0f);
                l2.lineTo(27.0f, 6.0f);
                l2.lineTo(21.0f, 6.0f);
                l2.lineTo(21.0f, 0.0f);
                l2.lineTo(21.0f, 0.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(31.0f, 0.0f);
                l.lineTo(37.0f, 0.0f);
                l.lineTo(37.0f, 6.0f);
                l.lineTo(31.0f, 6.0f);
                l.cubicTo(31.009983f, 4.0f, 31.009983f, 2.0f, 31.0f, 0.0f);
                l.lineTo(31.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(42.0f, 0.0f);
                l.lineTo(48.0f, 0.0f);
                l.cubicTo(47.990017f, 2.0f, 47.990017f, 4.0f, 48.0f, 6.0f);
                l.lineTo(42.0f, 6.0f);
                l.lineTo(42.0f, 0.0f);
                l.lineTo(42.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(52.0f, 0.0f);
                l.lineTo(58.0f, 0.0f);
                l.lineTo(58.0f, 6.0f);
                l.lineTo(52.0f, 6.0f);
                l.cubicTo(52.009983f, 4.0f, 52.009983f, 2.0f, 52.0f, 0.0f);
                l.lineTo(52.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(1.7763568E-15f, 12.0f);
                l.lineTo(6.0f, 12.0f);
                l.cubicTo(5.9900165f, 14.0f, 5.9900165f, 16.0f, 6.0f, 18.0f);
                l.lineTo(1.7763568E-15f, 18.0f);
                l.lineTo(1.7763568E-15f, 12.0f);
                l.lineTo(1.7763568E-15f, 12.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(10.0f, 12.0f);
                l.lineTo(16.0f, 12.0f);
                l.lineTo(16.0f, 18.0f);
                l.lineTo(10.0f, 18.0f);
                l.cubicTo(10.009983f, 16.0f, 10.009983f, 14.0f, 10.0f, 12.0f);
                l.lineTo(10.0f, 12.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(21.0f, 12.0f);
                l2.lineTo(27.0f, 12.0f);
                l2.lineTo(27.0f, 18.0f);
                l2.lineTo(21.0f, 18.0f);
                l2.lineTo(21.0f, 12.0f);
                l2.lineTo(21.0f, 12.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(31.0f, 12.0f);
                l2.lineTo(37.0f, 12.0f);
                l2.lineTo(37.0f, 18.0f);
                l2.lineTo(31.0f, 18.0f);
                l2.lineTo(31.0f, 12.0f);
                l2.lineTo(31.0f, 12.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(42.0f, 12.0f);
                l2.lineTo(48.0f, 12.0f);
                l2.lineTo(48.0f, 18.0f);
                l2.lineTo(42.0f, 18.0f);
                l2.lineTo(42.0f, 12.0f);
                l2.lineTo(42.0f, 12.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(52.0f, 12.0f);
                l.lineTo(58.0f, 12.0f);
                l.lineTo(58.0f, 18.0f);
                l.lineTo(52.0f, 18.0f);
                l.cubicTo(52.009983f, 16.0f, 52.009983f, 14.0f, 52.0f, 12.0f);
                l.lineTo(52.0f, 12.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(10.0f, 24.0f);
                l.lineTo(48.0f, 24.0f);
                l.cubicTo(47.989872f, 25.99852f, 47.989872f, 27.99704f, 48.0f, 30.0f);
                l.cubicTo(35.329956f, 30.005552f, 22.670042f, 29.99556f, 10.0f, 30.0f);
                l.cubicTo(10.010128f, 27.99704f, 10.010128f, 25.99852f, 10.0f, 24.0f);
                l.lineTo(10.0f, 24.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
