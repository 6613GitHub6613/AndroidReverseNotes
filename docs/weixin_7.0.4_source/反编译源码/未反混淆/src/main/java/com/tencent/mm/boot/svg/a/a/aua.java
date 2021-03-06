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
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;

public final class aua extends c {
    private final int height = ErrorCode.STARTDOWNLOAD_3;
    private final int width = 210;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 210;
            case 1:
                return ErrorCode.STARTDOWNLOAD_3;
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
                k2 = c.a(k, looper);
                k2.setColor(-4284563);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(139.15747f, 1.3074749f);
                l.cubicTo(138.74416f, 0.58537644f, 137.73692f, 0.0f, 136.90393f, 0.0f);
                l.lineTo(73.09608f, 0.0f);
                l.cubicTo(72.26479f, 0.0f, 71.25955f, 0.5789027f, 70.84252f, 1.3074749f);
                l.lineTo(53.248386f, 32.045467f);
                l.cubicTo(52.835064f, 32.767567f, 51.836205f, 33.35294f, 50.9994f, 33.35294f);
                l.lineTo(4.498816f, 33.35294f);
                l.cubicTo(2.0141885f, 33.35294f, 0.0f, 35.37368f, 0.0f, 37.856125f);
                l.lineTo(0.0f, 157.49681f);
                l.cubicTo(0.0f, 159.98386f, 2.0111012f, 162.0f, 4.5077453f, 162.0f);
                l.lineTo(205.49225f, 162.0f);
                l.cubicTo(207.98181f, 162.0f, 210.0f, 159.97926f, 210.0f, 157.49681f);
                l.lineTo(210.0f, 37.856125f);
                l.cubicTo(210.0f, 35.369087f, 207.99011f, 33.35294f, 205.50119f, 33.35294f);
                l.lineTo(159.0006f, 33.35294f);
                l.cubicTo(158.17184f, 33.35294f, 157.16864f, 32.77404f, 156.75162f, 32.045467f);
                l.lineTo(139.15747f, 1.3074749f);
                l.close();
                l.moveTo(105.0f, 147.70589f);
                l.cubicTo(136.63086f, 147.70589f, 162.27272f, 122.1071f, 162.27272f, 90.52941f);
                l.cubicTo(162.27272f, 58.951717f, 136.63086f, 33.35294f, 105.0f, 33.35294f);
                l.cubicTo(73.36915f, 33.35294f, 47.727272f, 58.951717f, 47.727272f, 90.52941f);
                l.cubicTo(47.727272f, 122.1071f, 73.36915f, 147.70589f, 105.0f, 147.70589f);
                l.close();
                l.moveTo(105.0f, 133.41176f);
                l.cubicTo(128.72314f, 133.41176f, 147.95454f, 114.212685f, 147.95454f, 90.52941f);
                l.cubicTo(147.95454f, 66.846146f, 128.72314f, 47.64706f, 105.0f, 47.64706f);
                l.cubicTo(81.27686f, 47.64706f, 62.045456f, 66.846146f, 62.045456f, 90.52941f);
                l.cubicTo(62.045456f, 114.212685f, 81.27686f, 133.41176f, 105.0f, 133.41176f);
                l.close();
                l.moveTo(14.318182f, 14.294118f);
                l.lineTo(14.318182f, 23.82353f);
                l.lineTo(42.954544f, 23.82353f);
                l.lineTo(42.954544f, 14.294118f);
                l.lineTo(14.318182f, 14.294118f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(139.15747f, 1.3074749f);
                l.cubicTo(138.74416f, 0.58537644f, 137.73692f, 0.0f, 136.90393f, 0.0f);
                l.lineTo(73.09608f, 0.0f);
                l.cubicTo(72.26479f, 0.0f, 71.25955f, 0.5789027f, 70.84252f, 1.3074749f);
                l.lineTo(53.248386f, 32.045467f);
                l.cubicTo(52.835064f, 32.767567f, 51.836205f, 33.35294f, 50.9994f, 33.35294f);
                l.lineTo(4.498816f, 33.35294f);
                l.cubicTo(2.0141885f, 33.35294f, 0.0f, 35.37368f, 0.0f, 37.856125f);
                l.lineTo(0.0f, 157.49681f);
                l.cubicTo(0.0f, 159.98386f, 2.0111012f, 162.0f, 4.5077453f, 162.0f);
                l.lineTo(205.49225f, 162.0f);
                l.cubicTo(207.98181f, 162.0f, 210.0f, 159.97926f, 210.0f, 157.49681f);
                l.lineTo(210.0f, 37.856125f);
                l.cubicTo(210.0f, 35.369087f, 207.99011f, 33.35294f, 205.50119f, 33.35294f);
                l.lineTo(159.0006f, 33.35294f);
                l.cubicTo(158.17184f, 33.35294f, 157.16864f, 32.77404f, 156.75162f, 32.045467f);
                l.lineTo(139.15747f, 1.3074749f);
                l.close();
                l.moveTo(105.0f, 147.70589f);
                l.cubicTo(136.63086f, 147.70589f, 162.27272f, 122.1071f, 162.27272f, 90.52941f);
                l.cubicTo(162.27272f, 58.951717f, 136.63086f, 33.35294f, 105.0f, 33.35294f);
                l.cubicTo(73.36915f, 33.35294f, 47.727272f, 58.951717f, 47.727272f, 90.52941f);
                l.cubicTo(47.727272f, 122.1071f, 73.36915f, 147.70589f, 105.0f, 147.70589f);
                l.close();
                l.moveTo(105.0f, 133.41176f);
                l.cubicTo(128.72314f, 133.41176f, 147.95454f, 114.212685f, 147.95454f, 90.52941f);
                l.cubicTo(147.95454f, 66.846146f, 128.72314f, 47.64706f, 105.0f, 47.64706f);
                l.cubicTo(81.27686f, 47.64706f, 62.045456f, 66.846146f, 62.045456f, 90.52941f);
                l.cubicTo(62.045456f, 114.212685f, 81.27686f, 133.41176f, 105.0f, 133.41176f);
                l.close();
                l.moveTo(14.318182f, 14.294118f);
                l.lineTo(14.318182f, 23.82353f);
                l.lineTo(42.954544f, 23.82353f);
                l.lineTo(42.954544f, 14.294118f);
                l.lineTo(14.318182f, 14.294118f);
                l.close();
                Paint k3 = c.k(looper);
                k3.setFlags(385);
                k3.setStyle(Style.FILL);
                Paint k4 = c.k(looper);
                k4.setFlags(385);
                k4.setStyle(Style.STROKE);
                k3.setColor(WebView.NIGHT_MODE_COLOR);
                k4.setStrokeWidth(1.0f);
                k4.setStrokeCap(Cap.BUTT);
                k4.setStrokeJoin(Join.MITER);
                k4.setStrokeMiter(4.0f);
                k4.setPathEffect(null);
                float[] a2 = c.a(g, 210.0f, 0.0f, 0.0f, 0.0f, 162.0f, 0.0f);
                h.reset();
                h.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.7940693f, 0.8090447f, 0.08431214f, 0.07970222f, new int[]{-4284307, -3429513}, new float[]{0.0f, 1.0f}, h, 0);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
