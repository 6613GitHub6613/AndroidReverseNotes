package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j {
    OK,
    ERR_OP_FAIL,
    ERR_FS_NOT_MOUNTED,
    ERR_PARENT_DIR_NOT_EXISTS,
    ERR_PERMISSION_DENIED,
    RET_ALREADY_EXISTS,
    RET_NOT_EXISTS,
    ERR_DIR_NOT_EMPTY,
    ERR_IS_FILE,
    ERR_IS_DIRECTORY,
    ERR_SYMLINK,
    ERR_BAD_ZIP_FILE,
    ERR_WRITE_ZIP_ENTRY,
    ERR_EXCEED_DIRECTORY_MAX_SIZE,
    ERR_NOT_SUPPORTED;

    static {
        AppMethodBeat.o(90979);
    }
}
