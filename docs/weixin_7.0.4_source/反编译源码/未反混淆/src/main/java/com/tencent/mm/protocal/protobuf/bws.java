package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bws extends btd {
    public LinkedList<bte> wXe = new LinkedList();

    public bws() {
        AppMethodBeat.i(51004);
        AppMethodBeat.o(51004);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51005);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(51005);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.wXe);
            AppMethodBeat.o(51005);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = ix + e.a.a.a.c(2, 8, this.wXe);
            AppMethodBeat.o(51005);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wXe.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(51005);
                throw bVar;
            }
            AppMethodBeat.o(51005);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bws bws = (bws) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bws.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(51005);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bte bte = new bte();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bte.populateBuilderWithField(aVar4, bte, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bws.wXe.add(bte);
                    }
                    AppMethodBeat.o(51005);
                    return 0;
                default:
                    AppMethodBeat.o(51005);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51005);
            return -1;
        }
    }
}
