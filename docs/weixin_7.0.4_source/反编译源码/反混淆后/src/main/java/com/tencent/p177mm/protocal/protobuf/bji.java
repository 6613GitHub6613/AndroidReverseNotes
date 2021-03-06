package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bji */
public final class bji extends btd {
    public int luT;
    public String luU;
    public bjj wME;
    public bix wMF;
    public LinkedList<biw> wMG = new LinkedList();
    public int wMH;

    public bji() {
        AppMethodBeat.m2504i(56896);
        AppMethodBeat.m2505o(56896);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56897);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56897);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.luT);
            if (this.luU != null) {
                c6093a.mo13475e(3, this.luU);
            }
            if (this.wME != null) {
                c6093a.mo13479iy(4, this.wME.computeSize());
                this.wME.writeFields(c6093a);
            }
            if (this.wMF != null) {
                c6093a.mo13479iy(5, this.wMF.computeSize());
                this.wMF.writeFields(c6093a);
            }
            c6093a.mo13474e(6, 8, this.wMG);
            c6093a.mo13480iz(7, this.wMH);
            AppMethodBeat.m2505o(56897);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.luT);
            if (this.luU != null) {
                ix += C6091a.m9575f(3, this.luU);
            }
            if (this.wME != null) {
                ix += C6087a.m9557ix(4, this.wME.computeSize());
            }
            if (this.wMF != null) {
                ix += C6087a.m9557ix(5, this.wMF.computeSize());
            }
            int c = (ix + C6087a.m9552c(6, 8, this.wMG)) + C6091a.m9572bs(7, this.wMH);
            AppMethodBeat.m2505o(56897);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wMG.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56897);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56897);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bji bji = (bji) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bji.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56897);
                    return 0;
                case 2:
                    bji.luT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56897);
                    return 0;
                case 3:
                    bji.luU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56897);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bjj bjj = new bjj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bjj.populateBuilderWithField(c6086a3, bjj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bji.wME = bjj;
                    }
                    AppMethodBeat.m2505o(56897);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bix bix = new bix();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bix.populateBuilderWithField(c6086a3, bix, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bji.wMF = bix;
                    }
                    AppMethodBeat.m2505o(56897);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        biw biw = new biw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = biw.populateBuilderWithField(c6086a3, biw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bji.wMG.add(biw);
                    }
                    AppMethodBeat.m2505o(56897);
                    return 0;
                case 7:
                    bji.wMH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56897);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56897);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56897);
            return -1;
        }
    }
}
