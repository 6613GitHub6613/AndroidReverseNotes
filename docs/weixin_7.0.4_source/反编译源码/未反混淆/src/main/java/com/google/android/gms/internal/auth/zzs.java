package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzs implements Result {
    private final Status mStatus;

    public zzs(Status status) {
        this.mStatus = status;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
