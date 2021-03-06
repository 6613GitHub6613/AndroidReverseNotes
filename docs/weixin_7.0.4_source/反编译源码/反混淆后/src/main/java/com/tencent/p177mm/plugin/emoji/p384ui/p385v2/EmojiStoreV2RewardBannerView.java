package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.gif.MMAnimateView;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardBannerView */
public class EmojiStoreV2RewardBannerView extends MMAnimateView {
    private float mScale = 0.75f;

    public EmojiStoreV2RewardBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmojiStoreV2RewardBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setScale(float f) {
        this.mScale = f;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(53668);
        int right = ((getRight() - getLeft()) - getPaddingRight()) - getPaddingLeft();
        int i3 = (int) (((float) right) * this.mScale);
        if (right == 0 || i3 == 0) {
            right = getContext().getResources().getDisplayMetrics().widthPixels;
            i3 = (int) (((float) right) * this.mScale);
        }
        setMeasuredDimension(right, i3);
        AppMethodBeat.m2505o(53668);
    }
}
