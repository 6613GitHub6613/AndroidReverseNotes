package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzxg extends WeakReference<Throwable> {
    private final int zzboc;

    public zzxg(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, null);
        AppMethodBeat.i(3541);
        if (th == null) {
            NullPointerException nullPointerException = new NullPointerException("The referent cannot be null");
            AppMethodBeat.o(3541);
            throw nullPointerException;
        }
        this.zzboc = System.identityHashCode(th);
        AppMethodBeat.o(3541);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(3542);
        if (obj == null || obj.getClass() != getClass()) {
            AppMethodBeat.o(3542);
            return false;
        } else if (this == obj) {
            AppMethodBeat.o(3542);
            return true;
        } else {
            zzxg zzxg = (zzxg) obj;
            if (this.zzboc == zzxg.zzboc && get() == zzxg.get()) {
                AppMethodBeat.o(3542);
                return true;
            }
            AppMethodBeat.o(3542);
            return false;
        }
    }

    public final int hashCode() {
        return this.zzboc;
    }
}
