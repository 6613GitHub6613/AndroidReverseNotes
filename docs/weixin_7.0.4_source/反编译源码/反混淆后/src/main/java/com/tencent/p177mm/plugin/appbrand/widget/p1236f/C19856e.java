package com.tencent.p177mm.plugin.appbrand.widget.p1236f;

import android.text.Spannable;
import android.text.Spannable.Factory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.p916h.C10981a;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/prompt/FixedLineHeightSpannableFactory;", "Landroid/text/Spannable$Factory;", "height", "", "(I)V", "getHeight", "()I", "newSpannable", "Landroid/text/Spannable;", "source", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.f.e */
final class C19856e extends Factory {
    private final int height;

    public C19856e(int i) {
        this.height = i;
    }

    public final Spannable newSpannable(CharSequence charSequence) {
        AppMethodBeat.m2504i(135268);
        Spannable newSpannable = super.newSpannable(charSequence);
        if (newSpannable != null) {
            newSpannable.setSpan(new C10981a((float) this.height), 0, newSpannable.length(), 18);
            AppMethodBeat.m2505o(135268);
            return newSpannable;
        }
        AppMethodBeat.m2505o(135268);
        return null;
    }
}
