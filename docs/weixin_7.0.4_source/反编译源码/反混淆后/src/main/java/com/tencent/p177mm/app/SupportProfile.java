package com.tencent.p177mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.C1326d;
import com.tencent.p177mm.booter.C24658t;
import com.tencent.p177mm.compatible.loader.C1439e;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p229f.C1523a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.report.p498a.C3730c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.C15418a;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5013ao.C5011c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C15430ab;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.app.SupportProfile */
public class SupportProfile extends C1439e {
    protected static String bWa = "";

    /* renamed from: com.tencent.mm.app.SupportProfile$1 */
    class C257871 implements C5011c {
        C257871() {
        }

        /* renamed from: b */
        public final void mo4564b(String str, Throwable th) {
            AppMethodBeat.m2504i(15400);
            C7060h.pYm.mo8378a(637, 0, 1, false);
            KVCommCrossProcessReceiver.cgo();
            AppMethodBeat.m2505o(15400);
        }
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(15401);
        bWa = C4996ah.getProcessName();
        ClassLoader classLoader = SupportProfile.class.getClassLoader();
        C1523a.m3164bk(C4996ah.getContext());
        C25794l.m41013a(new C257871());
        C24658t c24658t = new C24658t(C1326d.m2839bo(this.app.getBaseContext()));
        c24658t.mo33553jE("SUPPORT");
        C1947ae.ghN = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.display_errcode"), false);
        C1947ae.ghO = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.display_msgstate"), false);
        C1947ae.ghP = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        C1947ae.ghQ = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.network.force_touch"), false);
        C1947ae.ghR = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        C1947ae.ghS = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.crashIsExit"), false);
        C1947ae.ghW = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.album_show_info"), false);
        C1947ae.ghX = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.location_help"), false);
        C1947ae.gia = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.force_soso"), false);
        C1947ae.gib = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        C1947ae.gic = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        C1947ae.gid = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        C1947ae.gig = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.filterfpnp"), false);
        C1947ae.gih = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.testForPull"), false);
        int a = C5046bo.m7512a(c24658t.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        C1947ae.gie = a;
        if (a != 4 && C1947ae.gie > 0) {
            C15430ab.xIC = C1947ae.gie;
            C4990ab.m7412e("SetupSupportDebugger", "cdn thread num " + C1947ae.gie);
        }
        C1947ae.gif = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        C1947ae.gix = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.forcex5webview"), false);
        C1947ae.giu = C5046bo.m7532bc(c24658t.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        C4990ab.m7410d("SetupSupportDebugger", "Test.jsapiPermission = " + C1947ae.giu);
        try {
            a = Integer.decode(c24658t.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            C7243d.m12106Lw(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            C4990ab.m7416i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            String string = c24658t.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!C5046bo.isNullOrNil(string)) {
                C7243d.eSg = "android-".concat(String.valueOf(string));
                C7243d.vxk = "android-".concat(String.valueOf(string));
                C7243d.vxm = String.valueOf(string);
                C4872b.amf(string);
                new StringBuilder("set up test protocal apilevel = ").append(C7243d.eSg).append(" ").append(C4872b.dnP());
            }
        } catch (Exception e2) {
            C4990ab.m7416i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(c24658t.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(C7243d.vxn).append(" new: ").append(a);
            C7243d.vxn = (long) a;
        } catch (Exception e3) {
            C4990ab.m7416i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            c24658t.ecL.ebO = Integer.decode(c24658t.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            C4990ab.m7416i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            boolean a2 = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = C5046bo.m7517a(c24658t.mo33554jF(".com.tencent.mm.debug.report.useraction"), false);
            C3730c.m6036a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            C4990ab.m7416i("SetupSupportDebugger", "no debugger was got");
        }
        C25794l.m41016cT(bWa);
        C32258a.m52649cP(bWa);
        C1449k.m3079a("wcdb", classLoader);
        C1449k.m3079a("commonimgdec", classLoader);
        C1449k.m3079a("wechatcommon", classLoader);
        C1449k.m3079a(C15418a.xxo, classLoader);
        C1449k.m3079a("FFmpeg", classLoader);
        C1449k.m3079a("wechatpack", classLoader);
        int Lw = C45290m.m83509Lw();
        if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            C4990ab.m7417i("MicroMsg.SupportProfile", "load wechatsight_v7a, core number: %d", Integer.valueOf(Lw >> 12));
            C1449k.m3079a("wechatsight_v7a", classLoader);
            if ((Lw >> 12) >= 4) {
                C29014b.qwW = 3;
                C29014b.qwY = 3;
                C29014b.qwZ = 544000;
            } else {
                C29014b.qwW = 1;
                C29014b.qwY = 1;
                C29014b.qwZ = 640000;
            }
        } else {
            C4990ab.m7416i("MicroMsg.SupportProfile", "load wechatsight");
            C1449k.m3079a("wechatsight", classLoader);
            Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
            C29014b.qwW = 1;
            C29014b.qwY = 1;
            C29014b.qwZ = 640000;
        }
        C1523a.m3164bk(C4996ah.getContext());
        C1266q.m2719Bz();
        MMActivity.initLanguage(this.app.getBaseContext());
        AppMethodBeat.m2505o(15401);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onTrimMemory(int i) {
        AppMethodBeat.m2504i(15402);
        super.onTrimMemory(i);
        C4990ab.m7419v("MicroMsg.SupportProfile", "onTrimMemory(l : %d)", Integer.valueOf(i));
        AppMethodBeat.m2505o(15402);
    }
}
