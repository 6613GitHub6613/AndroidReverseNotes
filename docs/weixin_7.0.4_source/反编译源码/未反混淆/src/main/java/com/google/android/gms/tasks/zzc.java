package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class zzc<TResult, TContinuationResult> implements zzq<TResult> {
    private final Executor zzafk;
    private final Continuation<TResult, TContinuationResult> zzafl;
    private final zzu<TContinuationResult> zzafm;

    public zzc(Executor executor, Continuation<TResult, TContinuationResult> continuation, zzu<TContinuationResult> zzu) {
        this.zzafk = executor;
        this.zzafl = continuation;
        this.zzafm = zzu;
    }

    public final void cancel() {
        AppMethodBeat.i(57382);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(57382);
        throw unsupportedOperationException;
    }

    public final void onComplete(Task<TResult> task) {
        AppMethodBeat.i(57381);
        this.zzafk.execute(new zzd(this, task));
        AppMethodBeat.o(57381);
    }
}
