package com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C26255ur;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1058ui.FingerprintWalletLockUI;
import com.tencent.p177mm.plugin.walletlock.p1319c.C29711d;
import com.tencent.p177mm.plugin.walletlock.p1319c.C40171g;
import com.tencent.p177mm.plugin.walletlock.p1319c.C46387a;
import com.tencent.p177mm.plugin.walletlock.p1418a.C29709a;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b.C40168a;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b.C40169b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.b */
public final class C29712b extends C46387a {
    public final void init() {
        AppMethodBeat.m2504i(51463);
        C40171g c40171g = C40171g.tWY;
        C40171g.cTW();
        C40171g.tWY.mo63507HG(2);
        AppMethodBeat.m2505o(51463);
    }

    /* renamed from: a */
    public final void mo38286a(Activity activity, C40169b c40169b) {
        AppMethodBeat.m2504i(51464);
        if (!C1720g.m3532RL().mo5213J(C29709a.class)) {
            C4990ab.m7410d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
            AppMethodBeat.m2505o(51464);
        } else if (c40169b == null || c40169b.mo47948ae(activity)) {
            C26255ur c26255ur = new C26255ur();
            c26255ur.cRv.cRx = 0;
            c26255ur.cRv.activity = activity;
            C4879a.xxA.mo10055m(c26255ur);
            switch (((Integer) c26255ur.cRw.data).intValue()) {
                case 17:
                    activity.finish();
                    Intent intent = new Intent(activity, FingerprintWalletLockUI.class);
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", C46387a.m87240af(activity));
                    intent.setPackage(C4996ah.getPackageName());
                    activity.startActivity(intent);
                    break;
            }
            AppMethodBeat.m2505o(51464);
        } else {
            C4990ab.m7410d("MicroMsg.FingerprintLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
            AppMethodBeat.m2505o(51464);
        }
    }

    /* renamed from: a */
    public final void mo38287a(Activity activity, C40169b c40169b, C40168a c40168a) {
        AppMethodBeat.m2504i(51465);
        if (C1720g.m3532RL().mo5213J(C29709a.class)) {
            C26255ur c26255ur = new C26255ur();
            c26255ur.cRv.cRx = 1;
            c26255ur.cRv.activity = activity;
            C4879a.xxA.mo10055m(c26255ur);
            switch (((Integer) c26255ur.cRw.data).intValue()) {
                case 17:
                    if (c40169b != null && !c40169b.mo47948ae(activity)) {
                        C4990ab.m7410d("MicroMsg.FingerprintLockImpl", "protectMeOnResume: still in filter range, do not activate protection.");
                        break;
                    }
                    Intent intent = new Intent(activity, FingerprintWalletLockUI.class);
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", C46387a.m87240af(activity));
                    intent.setPackage(C4996ah.getPackageName());
                    activity.startActivity(intent);
                    AppMethodBeat.m2505o(51465);
                    return;
                    break;
            }
            AppMethodBeat.m2505o(51465);
            return;
        }
        C4990ab.m7410d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
        AppMethodBeat.m2505o(51465);
    }

    /* renamed from: h */
    public final void mo38295h(Activity activity, int i) {
        AppMethodBeat.m2504i(51466);
        if (i != 2) {
            AppMethodBeat.m2505o(51466);
        } else if (C1720g.m3532RL().mo5213J(C29709a.class)) {
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_paypwd");
            intent.putExtra("next_action", "next_action.switch_on_pattern");
            intent.putExtra("key_wallet_lock_type", 2);
            C25985d.m41467b((Context) activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent);
            AppMethodBeat.m2505o(51466);
        } else {
            C4990ab.m7410d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
            AppMethodBeat.m2505o(51466);
        }
    }

    /* renamed from: b */
    public final void mo38289b(Activity activity, int i, int i2) {
        AppMethodBeat.m2504i(51467);
        if (i != 2) {
            AppMethodBeat.m2505o(51467);
        } else if (C1720g.m3532RL().mo5213J(C29709a.class)) {
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_paypwd");
            intent.putExtra("next_action", "next_action.switch_on_pattern");
            intent.putExtra("key_wallet_lock_type", 2);
            C4990ab.m7417i("MicroMsg.FingerprintLockImpl", "alvinluo enterNewWalletLockProcessForResult start check pwd ui, wallet lock type: %d", Integer.valueOf(i));
            C25985d.m41468b((Context) activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i2);
            AppMethodBeat.m2505o(51467);
        } else {
            C4990ab.m7410d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
            AppMethodBeat.m2505o(51467);
        }
    }

    /* renamed from: ad */
    public final void mo38288ad(Activity activity) {
    }

    /* renamed from: i */
    public final void mo38296i(Activity activity, int i) {
    }

    public final C40169b cTi() {
        AppMethodBeat.m2504i(51468);
        C29711d cTU = C29711d.cTU();
        AppMethodBeat.m2505o(51468);
        return cTU;
    }

    public final boolean cTj() {
        AppMethodBeat.m2504i(51469);
        C40171g c40171g = C40171g.tWY;
        boolean cTn = C40171g.cTn();
        AppMethodBeat.m2505o(51469);
        return cTn;
    }

    public final boolean cTk() {
        return false;
    }
}
