package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am {
    int bJt = -1;
    String gwA = "";
    String gwB = "";
    int gwu = 0;
    int gwv = 0;
    int gww = 0;
    int gwx = 0;
    int gwy = 0;
    int gwz = 0;

    public am() {
        AppMethodBeat.i(108493);
        AppMethodBeat.o(108493);
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(108494);
        this.gwu = cursor.getInt(0);
        this.gwv = cursor.getInt(1);
        this.gww = cursor.getInt(2);
        this.gwx = cursor.getInt(3);
        this.gwy = cursor.getInt(4);
        this.gwz = cursor.getInt(5);
        this.gwA = cursor.getString(6);
        this.gwB = cursor.getString(7);
        AppMethodBeat.o(108494);
    }

    public final ContentValues aqk() {
        AppMethodBeat.i(108495);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 1) != 0) {
            contentValues.put("grouopid", Integer.valueOf(this.gwu));
        }
        if ((this.bJt & 2) != 0) {
            contentValues.put("membernum", Integer.valueOf(this.gwv));
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("weixinnum", Integer.valueOf(this.gww));
        }
        if ((this.bJt & 8) != 0) {
            contentValues.put("insert_time", Integer.valueOf(this.gwx));
        }
        if ((this.bJt & 16) != 0) {
            contentValues.put("lastupdate_time", Integer.valueOf(this.gwy));
        }
        if ((this.bJt & 32) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.gwz));
        }
        if ((this.bJt & 64) != 0) {
            contentValues.put("updatekey", aql());
        }
        if ((this.bJt & 128) != 0) {
            contentValues.put("groupname", aqm());
        }
        AppMethodBeat.o(108495);
        return contentValues;
    }

    public final String aql() {
        return this.gwA == null ? "" : this.gwA;
    }

    public final String aqm() {
        return this.gwB == null ? "" : this.gwB;
    }
}
