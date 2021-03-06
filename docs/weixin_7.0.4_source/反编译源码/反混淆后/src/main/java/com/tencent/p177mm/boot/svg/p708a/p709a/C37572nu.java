package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.nu */
public final class C37572nu extends C5163c {
    private final int height = 17;
    private final int width = 20;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 20;
            case 1:
                return 17;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
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
                k = C5163c.m7876a(k, looper);
                k.setColor(-15683841);
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(14.0f, 0.0f);
                l.lineTo(14.0f, 3.0f);
                l.lineTo(0.0f, 3.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 14.0f);
                l.lineTo(14.0f, 14.0f);
                l.lineTo(14.0f, 17.0f);
                l.lineTo(0.0f, 17.0f);
                l.lineTo(0.0f, 14.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(6.0f, 7.0f);
                l2.lineTo(20.0f, 7.0f);
                l2.lineTo(20.0f, 10.0f);
                l2.lineTo(6.0f, 10.0f);
                l2.lineTo(6.0f, 7.0f);
                l2.close();
                canvas.drawPath(l2, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
