package com.tencent.p177mm.storage.emotion;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37837bd;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.emotion.g */
public final class C44223g extends C37837bd {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return null;
    }

    static {
        AppMethodBeat.m2504i(62849);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "designerIDAndType";
        c4924a.xDd.put("designerIDAndType", "TEXT PRIMARY KEY ");
        stringBuilder.append(" designerIDAndType TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "designerIDAndType";
        c4924a.columns[1] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "BLOB default '' ");
        stringBuilder.append(" content BLOB default '' ");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(62849);
    }
}
