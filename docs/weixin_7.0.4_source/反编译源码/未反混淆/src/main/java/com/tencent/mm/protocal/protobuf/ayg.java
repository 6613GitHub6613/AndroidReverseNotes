package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ayg extends bsr {
    public int cKJ;
    public String fha;
    public String lCH;
    public String username;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28539);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.username == null) {
                bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(28539);
                throw bVar;
            } else if (this.lCH == null) {
                bVar = new b("Not all required fields were included: appusername");
                AppMethodBeat.o(28539);
                throw bVar;
            } else if (this.fha == null) {
                bVar = new b("Not all required fields were included: rankid");
                AppMethodBeat.o(28539);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.username != null) {
                    aVar.e(2, this.username);
                }
                if (this.lCH != null) {
                    aVar.e(3, this.lCH);
                }
                aVar.iz(4, this.cKJ);
                if (this.fha != null) {
                    aVar.e(5, this.fha);
                }
                AppMethodBeat.o(28539);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.username != null) {
                ix += e.a.a.b.b.a.f(2, this.username);
            }
            if (this.lCH != null) {
                ix += e.a.a.b.b.a.f(3, this.lCH);
            }
            ix += e.a.a.b.b.a.bs(4, this.cKJ);
            if (this.fha != null) {
                ix += e.a.a.b.b.a.f(5, this.fha);
            }
            AppMethodBeat.o(28539);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.username == null) {
                bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(28539);
                throw bVar;
            } else if (this.lCH == null) {
                bVar = new b("Not all required fields were included: appusername");
                AppMethodBeat.o(28539);
                throw bVar;
            } else if (this.fha == null) {
                bVar = new b("Not all required fields were included: rankid");
                AppMethodBeat.o(28539);
                throw bVar;
            } else {
                AppMethodBeat.o(28539);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ayg ayg = (ayg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayg.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28539);
                    return 0;
                case 2:
                    ayg.username = aVar3.BTU.readString();
                    AppMethodBeat.o(28539);
                    return 0;
                case 3:
                    ayg.lCH = aVar3.BTU.readString();
                    AppMethodBeat.o(28539);
                    return 0;
                case 4:
                    ayg.cKJ = aVar3.BTU.vd();
                    AppMethodBeat.o(28539);
                    return 0;
                case 5:
                    ayg.fha = aVar3.BTU.readString();
                    AppMethodBeat.o(28539);
                    return 0;
                default:
                    AppMethodBeat.o(28539);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28539);
            return -1;
        }
    }
}
