package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bot;
import com.tencent.p177mm.protocal.protobuf.bou;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.aj.a.v */
public final class C41742v extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C41742v(String str, String str2, int i) {
        AppMethodBeat.m2504i(11636);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bot();
        c1196a.fsK = new bou();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/qymsgstatenotify";
        this.ehh = c1196a.acD();
        bot bot = (bot) this.ehh.fsG.fsP;
        bot.vNb = str;
        bot.vMV = str2;
        bot.time_stamp = i;
        AppMethodBeat.m2505o(11636);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11637);
        C4990ab.m7411d("MicroMsg.NetSceneQyMsgStateNotify", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11637);
    }

    public final int getType() {
        return 1361;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11638);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.NetSceneQyMsgStateNotify", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11638);
        return a;
    }
}
