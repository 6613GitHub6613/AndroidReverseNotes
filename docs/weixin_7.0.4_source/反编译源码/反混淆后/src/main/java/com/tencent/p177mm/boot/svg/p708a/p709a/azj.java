package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.azj */
public final class azj extends C5163c {
    private final int height = 150;
    private final int width = 24;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 150;
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
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-1644826);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(24.0f, 0.0f);
                l.lineTo(24.0f, 150.0f);
                l.lineTo(0.0f, 150.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(7.0f, 66.0f);
                l2.lineTo(10.0f, 66.0f);
                l2.lineTo(10.0f, 84.0f);
                l2.lineTo(7.0f, 84.0f);
                l2.lineTo(7.0f, 66.0f);
                l2.close();
                l2.moveTo(14.0f, 66.0f);
                l2.lineTo(17.0f, 66.0f);
                l2.lineTo(17.0f, 84.0f);
                l2.lineTo(14.0f, 84.0f);
                l2.lineTo(14.0f, 66.0f);
                l2.close();
                canvas.saveLayerAlpha(null, 51, 4);
                k = C5163c.m7876a(k, looper);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
