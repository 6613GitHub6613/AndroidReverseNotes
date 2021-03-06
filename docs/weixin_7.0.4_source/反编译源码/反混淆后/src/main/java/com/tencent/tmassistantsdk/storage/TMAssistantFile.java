package com.tencent.tmassistantsdk.storage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidParameterException;

public class TMAssistantFile {
    protected static final int DataBufferMaxLen = 16384;
    protected static final String TAG = "TMAssistantFile";
    protected int mDataBufferDataLen = 0;
    protected long mFileDataLen = 0;
    protected FileOutputStream mFileOutputStream = null;
    protected String mFinalFileName = null;
    protected String mTempFileName = null;
    protected byte[] mWriteDataBuffer = null;

    public TMAssistantFile(String str, String str2) {
        AppMethodBeat.m2504i(76168);
        this.mTempFileName = str;
        this.mFinalFileName = str2;
        this.mFileDataLen = length();
        TMLog.m60588i(TAG, "mFileDataLen = " + this.mFileDataLen);
        AppMethodBeat.m2505o(76168);
    }

    public void deleteTempFile() {
        AppMethodBeat.m2504i(76169);
        String tmpFilePath = getTmpFilePath(this.mTempFileName);
        TMLog.m60588i(TAG, "deleteFile 1 tmpFilePathString: ".concat(String.valueOf(tmpFilePath)));
        if (!TextUtils.isEmpty(tmpFilePath)) {
            File file = new File(tmpFilePath);
            TMLog.m60588i(TAG, "deleteFile 2 file: ".concat(String.valueOf(file)));
            if (file.exists()) {
                TMLog.m60588i(TAG, "deleteFile result:" + file.delete() + ",filename:" + tmpFilePath);
                AppMethodBeat.m2505o(76169);
                return;
            }
            TMLog.m60588i(TAG, "deleteFile 3");
        }
        AppMethodBeat.m2505o(76169);
    }

    public long length() {
        AppMethodBeat.m2504i(76170);
        String saveFilePath = getSaveFilePath(this.mFinalFileName);
        if (saveFilePath != null) {
            File file = new File(saveFilePath);
            if (file.exists()) {
                this.mFileDataLen = file.length();
            } else {
                saveFilePath = getTmpFilePath(this.mTempFileName);
                if (saveFilePath != null) {
                    file = new File(saveFilePath);
                    if (file.exists()) {
                        TMLog.m60588i(TAG, saveFilePath + " exists");
                        this.mFileDataLen = file.length();
                    } else {
                        this.mFileDataLen = 0;
                    }
                }
            }
            long j = this.mFileDataLen;
            AppMethodBeat.m2505o(76170);
            return j;
        }
        AppMethodBeat.m2505o(76170);
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public void ensureFilePath(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(76171);
        InvalidParameterException invalidParameterException;
        if (TextUtils.isEmpty(str)) {
            TMLog.m60588i(TAG, "fileFullPath is null or the filename.size is zero.");
            invalidParameterException = new InvalidParameterException("fileFullPath is null or the filename.size is zero.");
            AppMethodBeat.m2505o(76171);
            throw invalidParameterException;
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1 || str.length() == 1) {
            TMLog.m60588i(TAG, "fileFullPath is not a valid full path. fileName: ".concat(String.valueOf(str)));
            invalidParameterException = new InvalidParameterException("fileFullPath is not a valid full path. fileName: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(76171);
            throw invalidParameterException;
        }
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
        }
        File file = new File(str);
        if (!file.exists()) {
            z = file.mkdirs();
        }
        if (z) {
            AppMethodBeat.m2505o(76171);
            return;
        }
        TMLog.m60588i(TAG, "Failed to create directory. dir: ".concat(String.valueOf(str)));
        IOException iOException = new IOException("Failed to create directory. dir: ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(76171);
        throw iOException;
    }

    public synchronized boolean write(byte[] bArr, int i, int i2, long j, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.m2504i(76172);
            if (this.mFileOutputStream == null) {
                String tmpFilePath = getTmpFilePath(this.mTempFileName);
                if (tmpFilePath != null) {
                    try {
                        ensureFilePath(tmpFilePath);
                        this.mFileOutputStream = new FileOutputStream(tmpFilePath, true);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
                        TMLog.m60590w(TAG, "write failed" + e.getMessage());
                        AppMethodBeat.m2505o(76172);
                    }
                } else {
                    TMLog.m60590w(TAG, "write failed tmpFilePathString is null");
                    AppMethodBeat.m2505o(76172);
                }
            }
            if (this.mWriteDataBuffer == null) {
                this.mWriteDataBuffer = new byte[DataBufferMaxLen];
                this.mDataBufferDataLen = 0;
            }
            z2 = writeData(this.mFileOutputStream, bArr, i, i2, j);
            if (!z2) {
                AppMethodBeat.m2505o(76172);
            } else if (z && flush()) {
                z2 = moveFileFromTmpToSavaPath(getTmpFilePath(this.mTempFileName), getSaveFilePath(this.mFinalFileName));
                AppMethodBeat.m2505o(76172);
            } else {
                AppMethodBeat.m2505o(76172);
                z2 = true;
            }
        }
        return z2;
    }

    public synchronized boolean flush() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(76173);
            if (this.mFileOutputStream != null && this.mDataBufferDataLen > 0) {
                try {
                    this.mFileOutputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
                    this.mDataBufferDataLen = 0;
                    z = true;
                    AppMethodBeat.m2505o(76173);
                } catch (IOException e) {
                    C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
                    TMLog.m60590w(TAG, "flush failed ".concat(String.valueOf(e)));
                }
            }
            AppMethodBeat.m2505o(76173);
        }
        return z;
    }

    public synchronized void close() {
        AppMethodBeat.m2504i(76174);
        flush();
        try {
            if (this.mFileOutputStream != null) {
                this.mFileOutputStream.close();
            }
        } catch (IOException e) {
            C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
        }
        this.mFileOutputStream = null;
        this.mWriteDataBuffer = null;
        this.mFileDataLen = 0;
        AppMethodBeat.m2505o(76174);
        return;
    }

    public static String getSaveFilePath(String str) {
        AppMethodBeat.m2504i(76175);
        if (str == null) {
            AppMethodBeat.m2505o(76175);
            return null;
        }
        String savePathRootDir = getSavePathRootDir();
        if (savePathRootDir == null) {
            AppMethodBeat.m2505o(76175);
            return null;
        }
        String str2 = savePathRootDir + File.separator + str;
        AppMethodBeat.m2505o(76175);
        return str2;
    }

    public String getTmpFilePath(String str) {
        AppMethodBeat.m2504i(76176);
        if (str == null) {
            AppMethodBeat.m2505o(76176);
            return null;
        }
        String savePathRootDir = getSavePathRootDir();
        if (savePathRootDir == null) {
            AppMethodBeat.m2505o(76176);
            return null;
        }
        String str2 = savePathRootDir + "/.tmp/" + str + ".tmp";
        AppMethodBeat.m2505o(76176);
        return str2;
    }

    public static String getSavePathRootDir() {
        AppMethodBeat.m2504i(76177);
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            AppMethodBeat.m2505o(76177);
            return null;
        }
        String str;
        if (isSDCardExistAndCanWrite()) {
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/TMAssistantSDK/Download/".concat(String.valueOf(context.getPackageName()));
        } else {
            str = context.getFilesDir().getAbsolutePath() + "/TMAssistantSDK/Download";
        }
        AppMethodBeat.m2505o(76177);
        return str;
    }

    public void moveFileToSavaPath() {
        AppMethodBeat.m2504i(76178);
        moveFileFromTmpToSavaPath(getTmpFilePath(this.mTempFileName), getSaveFilePath(this.mFinalFileName));
        AppMethodBeat.m2505o(76178);
    }

    public static boolean isSDCardExistAndCanWrite() {
        AppMethodBeat.m2504i(76179);
        if ("mounted".equals(Environment.getExternalStorageState()) && Environment.getExternalStorageDirectory().canWrite()) {
            AppMethodBeat.m2505o(76179);
            return true;
        }
        AppMethodBeat.m2505o(76179);
        return false;
    }

    private boolean writeData(FileOutputStream fileOutputStream, byte[] bArr, int i, int i2, long j) {
        AppMethodBeat.m2504i(76180);
        if (fileOutputStream == null || bArr == null) {
            AppMethodBeat.m2505o(76180);
            return false;
        } else if (j != this.mFileDataLen) {
            TMLog.m60588i(TAG, "writeData0 failed,filelen:" + this.mFileDataLen + ",offset:" + j + ",filename:" + this.mTempFileName);
            AppMethodBeat.m2505o(76180);
            return false;
        } else {
            if (i2 >= DataBufferMaxLen) {
                try {
                    if (this.mDataBufferDataLen > 0) {
                        fileOutputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
                        this.mDataBufferDataLen = 0;
                    }
                    fileOutputStream.write(bArr, i, i2);
                    this.mFileDataLen += (long) i2;
                } catch (IOException e) {
                    C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
                    TMLog.m60590w(TAG, "writeData1 failed " + e.getMessage());
                    AppMethodBeat.m2505o(76180);
                    return false;
                }
            }
            if (this.mDataBufferDataLen + i2 > DataBufferMaxLen && this.mDataBufferDataLen > 0) {
                try {
                    fileOutputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
                    this.mDataBufferDataLen = 0;
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace(TAG, e2, "", new Object[0]);
                    TMLog.m60590w(TAG, "writeData2 failed " + e2.getMessage());
                    AppMethodBeat.m2505o(76180);
                    return false;
                }
            }
            System.arraycopy(bArr, i, this.mWriteDataBuffer, this.mDataBufferDataLen, i2);
            this.mDataBufferDataLen += i2;
            this.mFileDataLen += (long) i2;
            AppMethodBeat.m2505o(76180);
            return true;
        }
    }

    private boolean moveFileFromTmpToSavaPath(String str, String str2) {
        AppMethodBeat.m2504i(76181);
        TMLog.m60588i(TAG, "moveFileFromTmpToSavaPath, tmpFilePath = " + str + ", saveFilePath = " + str2);
        if (!(str == null || str2 == null)) {
            File file = new File(str);
            if (file.exists()) {
                boolean renameTo = file.renameTo(new File(str2));
                if (renameTo) {
                    GlobalUtil.updateFilePathAuthorized(str2);
                }
                AppMethodBeat.m2505o(76181);
                return renameTo;
            }
        }
        TMLog.m60590w(TAG, "moveFileFromTmpToSavaPath failed ");
        AppMethodBeat.m2505o(76181);
        return false;
    }
}
