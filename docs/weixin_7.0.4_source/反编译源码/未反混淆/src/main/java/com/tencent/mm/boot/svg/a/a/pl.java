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

public final class pl extends c {
    private final int height = 292;
    private final int width = 378;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 378;
            case 1:
                return 292;
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                float[] a = c.a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(a);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(k, looper);
                a2.setColor(-13092808);
                Path l = c.l(looper);
                l.moveTo(371.0f, 234.001f);
                l.cubicTo(371.0f, 240.066f, 366.063f, 245.001f, 359.993f, 245.001f);
                l.lineTo(14.007f, 245.001f);
                l.cubicTo(7.938f, 245.001f, 3.0f, 240.066f, 3.0f, 234.001f);
                l.lineTo(3.0f, 14.0f);
                l.cubicTo(3.0f, 7.935f, 7.938f, 3.001f, 14.007f, 3.001f);
                l.lineTo(359.993f, 3.001f);
                l.cubicTo(366.063f, 3.001f, 371.0f, 7.935f, 371.0f, 14.0f);
                l.lineTo(371.0f, 234.001f);
                l.lineTo(371.0f, 234.001f);
                l.close();
                l.moveTo(359.993f, 0.0f);
                l.lineTo(14.007f, 0.0f);
                l.cubicTo(6.276f, 0.0f, 0.0f, 6.268f, 0.0f, 14.0f);
                l.lineTo(0.0f, 234.001f);
                l.cubicTo(0.0f, 241.73f, 6.271f, 248.0f, 14.007f, 248.0f);
                l.lineTo(359.993f, 248.0f);
                l.cubicTo(367.724f, 248.0f, 374.0f, 241.733f, 374.0f, 234.001f);
                l.lineTo(374.0f, 14.0f);
                l.cubicTo(374.0f, 6.27f, 367.729f, 0.0f, 359.993f, 0.0f);
                l.lineTo(359.993f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(k, looper);
                a3.setColor(-13092808);
                Path l2 = c.l(looper);
                l2.moveTo(241.0f, 286.0001f);
                l2.lineTo(132.0f, 286.0001f);
                l2.lineTo(132.0f, 284.5041f);
                l2.lineTo(153.712f, 280.5561f);
                l2.lineTo(157.658f, 248.0001f);
                l2.lineTo(215.342f, 248.0001f);
                l2.lineTo(219.288f, 280.5561f);
                l2.lineTo(241.0f, 284.5041f);
                l2.lineTo(241.0f, 286.0001f);
                l2.close();
                l2.moveTo(218.0f, 245.0001f);
                l2.lineTo(155.0f, 245.0001f);
                l2.lineTo(151.0f, 278.0001f);
                l2.lineTo(129.0f, 282.0001f);
                l2.lineTo(129.0f, 289.0001f);
                l2.lineTo(244.0f, 289.0001f);
                l2.lineTo(244.0f, 282.0001f);
                l2.lineTo(222.0f, 278.0001f);
                l2.lineTo(218.0f, 245.0001f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(k, looper);
                a3.setColor(-13092808);
                l2 = c.l(looper);
                l2.moveTo(2.0f, 199.0f);
                l2.lineTo(374.0f, 199.0f);
                l2.lineTo(374.0f, 196.0f);
                l2.lineTo(2.0f, 196.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-13158344);
                g = c.a(a, 1.0f, 0.0f, 164.0f, 0.0f, 1.0f, 86.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(43.0895f, 21.9691f);
                l.lineTo(43.0895f, 49.9671f);
                l.lineTo(3.0895f, 49.9651f);
                l.lineTo(3.0895f, 21.9691f);
                l.lineTo(3.0905f, 21.9671f);
                l.lineTo(8.9995f, 21.9671f);
                l.lineTo(8.9995f, 18.9671f);
                l.lineTo(3.0905f, 18.9671f);
                l.cubicTo(1.4415f, 18.9671f, 0.0895f, 20.3111f, 0.0895f, 21.9691f);
                l.lineTo(0.0895f, 49.9651f);
                l.cubicTo(0.0895f, 51.6241f, 1.4335f, 52.9671f, 3.0905f, 52.9671f);
                l.lineTo(43.0895f, 52.9671f);
                l.cubicTo(44.7385f, 52.9671f, 46.0895f, 51.6231f, 46.0895f, 49.9651f);
                l.lineTo(46.0895f, 21.9691f);
                l.cubicTo(46.0895f, 20.3101f, 44.7465f, 18.9671f, 43.0895f, 18.9671f);
                l.lineTo(36.9995f, 18.9671f);
                l.lineTo(36.9995f, 21.9691f);
                l.lineTo(43.0895f, 21.9691f);
                l.lineTo(43.0895f, 21.9691f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a3 = c.a(k, looper);
                l2 = c.l(looper);
                l2.moveTo(12.0f, 19.0f);
                l2.lineTo(34.0f, 19.0f);
                l2.lineTo(34.0f, 18.967f);
                l2.lineTo(12.0f, 18.967f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a4 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(9.0f, 13.4978f);
                l.lineTo(9.0f, 18.9668f);
                l.lineTo(12.0f, 18.9668f);
                l.lineTo(12.0f, 13.4978f);
                l.cubicTo(12.0f, 7.7088f, 16.714f, 3.0008f, 22.508f, 3.0008f);
                l.lineTo(23.492f, 3.0008f);
                l.cubicTo(29.286f, 3.0008f, 34.0f, 7.7088f, 34.0f, 13.4978f);
                l.lineTo(34.0f, 18.9668f);
                l.lineTo(37.0f, 18.9668f);
                l.lineTo(37.0f, 13.4978f);
                l.cubicTo(37.0f, 6.0438f, 30.952f, -2.0E-4f, 23.492f, -2.0E-4f);
                l.lineTo(22.508f, -2.0E-4f);
                l.cubicTo(15.041f, -2.0E-4f, 9.0f, 6.0428f, 9.0f, 13.4978f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a3 = c.a(k, looper);
                l2 = c.l(looper);
                l2.moveTo(37.0f, 22.0f);
                l2.lineTo(37.0f, 21.969f);
                l2.lineTo(9.0f, 21.967f);
                l2.lineTo(9.0f, 22.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(k, looper);
                l2 = c.l(looper);
                l2.moveTo(33.9997f, 19.0003f);
                l2.lineTo(11.9997f, 19.0003f);
                l2.lineTo(11.9997f, 18.9673f);
                l2.lineTo(8.9997f, 18.9673f);
                l2.lineTo(8.9997f, 21.9673f);
                l2.lineTo(36.9997f, 21.9683f);
                l2.lineTo(36.9997f, 18.9673f);
                l2.lineTo(33.9997f, 18.9673f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
