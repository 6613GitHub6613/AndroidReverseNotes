package org.xwalk.core;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Iterator;

public class XWalkDialogManager {
    public static final int DIALOG_ARCHITECTURE_MISMATCH = 4;
    public static final int DIALOG_DECOMPRESSING = 11;
    public static final int DIALOG_DOWNLOADING = 12;
    public static final int DIALOG_DOWNLOAD_ERROR = 6;
    public static final int DIALOG_NEWER_VERSION = 3;
    public static final int DIALOG_NOT_FOUND = 1;
    public static final int DIALOG_OLDER_VERSION = 2;
    public static final int DIALOG_SELECT_STORE = 7;
    public static final int DIALOG_SIGNATURE_CHECK_ERROR = 5;
    public static final int DIALOG_UNSUPPORTED_STORE = 8;
    private static final String TAG = "XWalkLib";
    private Dialog mActiveDialog;
    private AlertDialog mArchitectureMismatchDialog;
    private Context mContext;
    private ProgressDialog mDecompressingDialog;
    private AlertDialog mDownloadErrorDialog;
    private ProgressDialog mDownloadingDialog;
    private AlertDialog mNewerVersionDialog;
    private AlertDialog mNotFoundDialog;
    private AlertDialog mOlderVersionDialog;
    private AlertDialog mSelectStoreDialog;
    private AlertDialog mSignatureCheckErrorDialog;
    private AlertDialog mUnsupportedStoreDialog;

    static class ButtonAction {
        Runnable mClickAction;
        boolean mMandatory;
        int mWhich;

        ButtonAction(int i, Runnable runnable, boolean z) {
            this.mWhich = i;
            this.mClickAction = runnable;
            this.mMandatory = z;
        }
    }

    public XWalkDialogManager(Context context) {
        this.mContext = context;
    }

    public void setAlertDialog(int i, AlertDialog alertDialog) {
        AppMethodBeat.i(85604);
        IllegalArgumentException illegalArgumentException;
        if ((alertDialog instanceof ProgressDialog) || (alertDialog instanceof DatePickerDialog) || (alertDialog instanceof TimePickerDialog)) {
            illegalArgumentException = new IllegalArgumentException("The type of dialog must be AlertDialog");
            AppMethodBeat.o(85604);
            throw illegalArgumentException;
        } else if (i == 1) {
            this.mNotFoundDialog = alertDialog;
            AppMethodBeat.o(85604);
        } else if (i == 2) {
            this.mOlderVersionDialog = alertDialog;
            AppMethodBeat.o(85604);
        } else if (i == 3) {
            this.mNewerVersionDialog = alertDialog;
            AppMethodBeat.o(85604);
        } else if (i == 4) {
            this.mArchitectureMismatchDialog = alertDialog;
            AppMethodBeat.o(85604);
        } else if (i == 5) {
            this.mSignatureCheckErrorDialog = alertDialog;
            AppMethodBeat.o(85604);
        } else if (i == 6) {
            this.mDownloadErrorDialog = alertDialog;
            AppMethodBeat.o(85604);
        } else if (i == 7) {
            this.mSelectStoreDialog = alertDialog;
            AppMethodBeat.o(85604);
        } else if (i == 8) {
            this.mUnsupportedStoreDialog = alertDialog;
            AppMethodBeat.o(85604);
        } else {
            illegalArgumentException = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(i)));
            AppMethodBeat.o(85604);
            throw illegalArgumentException;
        }
    }

    public void setProgressDialog(int i, ProgressDialog progressDialog) {
        AppMethodBeat.i(85605);
        if (i == 11) {
            this.mDecompressingDialog = progressDialog;
            AppMethodBeat.o(85605);
        } else if (i == 12) {
            this.mDownloadingDialog = progressDialog;
            AppMethodBeat.o(85605);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(i)));
            AppMethodBeat.o(85605);
            throw illegalArgumentException;
        }
    }

    public AlertDialog getAlertDialog(int i) {
        AppMethodBeat.i(85606);
        AlertDialog alertDialog;
        if (i == 1) {
            if (this.mNotFoundDialog == null) {
                this.mNotFoundDialog = buildAlertDialog();
                setTitle(this.mNotFoundDialog, R.string.g9m);
                setMessage(this.mNotFoundDialog, (int) R.string.g9l);
                setPositiveButton(this.mNotFoundDialog, R.string.gbl);
                setNegativeButton(this.mNotFoundDialog, R.string.gbj);
            }
            alertDialog = this.mNotFoundDialog;
            AppMethodBeat.o(85606);
            return alertDialog;
        } else if (i == 2) {
            if (this.mOlderVersionDialog == null) {
                this.mOlderVersionDialog = buildAlertDialog();
                setTitle(this.mOlderVersionDialog, R.string.g9o);
                setMessage(this.mOlderVersionDialog, (int) R.string.g9n);
                setPositiveButton(this.mOlderVersionDialog, R.string.gbl);
                setNegativeButton(this.mOlderVersionDialog, R.string.gbj);
            }
            alertDialog = this.mOlderVersionDialog;
            AppMethodBeat.o(85606);
            return alertDialog;
        } else if (i == 3) {
            if (this.mNewerVersionDialog == null) {
                this.mNewerVersionDialog = buildAlertDialog();
                setTitle(this.mNewerVersionDialog, R.string.g9k);
                setMessage(this.mNewerVersionDialog, (int) R.string.g9j);
                setNegativeButton(this.mNewerVersionDialog, R.string.gbj);
            }
            alertDialog = this.mNewerVersionDialog;
            AppMethodBeat.o(85606);
            return alertDialog;
        } else if (i == 4) {
            if (this.mArchitectureMismatchDialog == null) {
                this.mArchitectureMismatchDialog = buildAlertDialog();
                setTitle(this.mArchitectureMismatchDialog, R.string.g9i);
                setMessage(this.mArchitectureMismatchDialog, (int) R.string.g9h);
                setPositiveButton(this.mArchitectureMismatchDialog, R.string.gbl);
                setNegativeButton(this.mArchitectureMismatchDialog, R.string.gbj);
            }
            alertDialog = this.mArchitectureMismatchDialog;
            AppMethodBeat.o(85606);
            return alertDialog;
        } else if (i == 5) {
            if (this.mSignatureCheckErrorDialog == null) {
                this.mSignatureCheckErrorDialog = buildAlertDialog();
                setTitle(this.mSignatureCheckErrorDialog, R.string.g9q);
                setMessage(this.mSignatureCheckErrorDialog, (int) R.string.g9p);
                setNegativeButton(this.mSignatureCheckErrorDialog, R.string.gbj);
            }
            alertDialog = this.mSignatureCheckErrorDialog;
            AppMethodBeat.o(85606);
            return alertDialog;
        } else if (i == 6) {
            if (this.mDownloadErrorDialog == null) {
                this.mDownloadErrorDialog = buildAlertDialog();
                setTitle(this.mDownloadErrorDialog, R.string.g6q);
                setMessage(this.mDownloadErrorDialog, (int) R.string.g70);
                setPositiveButton(this.mDownloadErrorDialog, R.string.gbm);
                setNegativeButton(this.mDownloadErrorDialog, R.string.gbi);
            }
            alertDialog = this.mDownloadErrorDialog;
            AppMethodBeat.o(85606);
            return alertDialog;
        } else if (i == 7) {
            if (this.mSelectStoreDialog == null) {
                this.mSelectStoreDialog = buildAlertDialog();
                setTitle(this.mSelectStoreDialog, R.string.g6q);
                setPositiveButton(this.mSelectStoreDialog, R.string.gbk);
            }
            alertDialog = this.mSelectStoreDialog;
            AppMethodBeat.o(85606);
            return alertDialog;
        } else if (i == 8) {
            if (this.mUnsupportedStoreDialog == null) {
                this.mUnsupportedStoreDialog = buildAlertDialog();
                setTitle(this.mUnsupportedStoreDialog, R.string.g6q);
                setMessage(this.mUnsupportedStoreDialog, (int) R.string.gal);
                setNegativeButton(this.mUnsupportedStoreDialog, R.string.gbj);
            }
            alertDialog = this.mUnsupportedStoreDialog;
            AppMethodBeat.o(85606);
            return alertDialog;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(i)));
            AppMethodBeat.o(85606);
            throw illegalArgumentException;
        }
    }

    public ProgressDialog getProgressDialog(int i) {
        AppMethodBeat.i(85607);
        ProgressDialog progressDialog;
        if (i == 11) {
            if (this.mDecompressingDialog == null) {
                this.mDecompressingDialog = buildProgressDialog();
                setTitle(this.mDecompressingDialog, R.string.g6q);
                setMessage(this.mDecompressingDialog, (int) R.string.g6r);
                setNegativeButton(this.mDecompressingDialog, R.string.gbi);
                this.mDecompressingDialog.setProgressStyle(0);
            }
            progressDialog = this.mDecompressingDialog;
            AppMethodBeat.o(85607);
            return progressDialog;
        } else if (i == 12) {
            if (this.mDownloadingDialog == null) {
                this.mDownloadingDialog = buildProgressDialog();
                setTitle(this.mDownloadingDialog, R.string.g6q);
                setMessage(this.mDownloadingDialog, (int) R.string.g72);
                setNegativeButton(this.mDownloadingDialog, R.string.gbi);
                this.mDownloadingDialog.setProgressStyle(1);
            }
            progressDialog = this.mDownloadingDialog;
            AppMethodBeat.o(85607);
            return progressDialog;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(i)));
            AppMethodBeat.o(85607);
            throw illegalArgumentException;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void showInitializationError(int i, Runnable runnable, Runnable runnable2) {
        AlertDialog alertDialog;
        AppMethodBeat.i(85608);
        ArrayList arrayList = new ArrayList();
        if (i == 2) {
            alertDialog = getAlertDialog(1);
            arrayList.add(new ButtonAction(-1, runnable2, true));
            arrayList.add(new ButtonAction(-2, runnable, false));
        } else if (i == 3) {
            alertDialog = getAlertDialog(2);
            arrayList.add(new ButtonAction(-1, runnable2, true));
            arrayList.add(new ButtonAction(-2, runnable, false));
        } else if (i == 4) {
            alertDialog = getAlertDialog(3);
            arrayList.add(new ButtonAction(-2, runnable, true));
        } else if (i == 6) {
            alertDialog = getAlertDialog(4);
            arrayList.add(new ButtonAction(-1, runnable2, true));
            arrayList.add(new ButtonAction(-2, runnable, false));
        } else if (i == 7) {
            alertDialog = getAlertDialog(5);
            arrayList.add(new ButtonAction(-2, runnable, true));
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid status ".concat(String.valueOf(i)));
            AppMethodBeat.o(85608);
            throw illegalArgumentException;
        }
        showDialog(alertDialog, arrayList);
        AppMethodBeat.o(85608);
    }

    /* Access modifiers changed, original: 0000 */
    public void showDownloadError(Runnable runnable, Runnable runnable2) {
        AppMethodBeat.i(85609);
        AlertDialog alertDialog = getAlertDialog(6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-1, runnable2, true));
        arrayList.add(new ButtonAction(-2, runnable, false));
        showDialog(alertDialog, arrayList);
        AppMethodBeat.o(85609);
    }

    /* Access modifiers changed, original: 0000 */
    public void showSelectStore(Runnable runnable, String str) {
        AppMethodBeat.i(85610);
        AlertDialog alertDialog = getAlertDialog(7);
        setMessage(alertDialog, this.mContext.getString(R.string.g8x).replace("STORE_NAME", str));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-1, runnable, true));
        showDialog(alertDialog, arrayList);
        AppMethodBeat.o(85610);
    }

    /* Access modifiers changed, original: 0000 */
    public void showUnsupportedStore(Runnable runnable) {
        AppMethodBeat.i(85611);
        AlertDialog alertDialog = getAlertDialog(8);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-2, runnable, true));
        showDialog(alertDialog, arrayList);
        AppMethodBeat.o(85611);
    }

    /* Access modifiers changed, original: 0000 */
    public void showDecompressProgress(Runnable runnable) {
        AppMethodBeat.i(85612);
        ProgressDialog progressDialog = getProgressDialog(11);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-2, runnable, false));
        showDialog(progressDialog, arrayList);
        AppMethodBeat.o(85612);
    }

    /* Access modifiers changed, original: 0000 */
    public void showDownloadProgress(Runnable runnable) {
        AppMethodBeat.i(85613);
        ProgressDialog progressDialog = getProgressDialog(12);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonAction(-2, runnable, false));
        showDialog(progressDialog, arrayList);
        AppMethodBeat.o(85613);
    }

    /* Access modifiers changed, original: 0000 */
    public void dismissDialog() {
        AppMethodBeat.i(85614);
        this.mActiveDialog.dismiss();
        this.mActiveDialog = null;
        AppMethodBeat.o(85614);
    }

    /* Access modifiers changed, original: 0000 */
    public void setProgress(int i, int i2) {
        AppMethodBeat.i(85615);
        ProgressDialog progressDialog = (ProgressDialog) this.mActiveDialog;
        progressDialog.setIndeterminate(false);
        progressDialog.setMax(i2);
        progressDialog.setProgress(i);
        AppMethodBeat.o(85615);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isShowingDialog() {
        AppMethodBeat.i(85616);
        if (this.mActiveDialog == null || !this.mActiveDialog.isShowing()) {
            AppMethodBeat.o(85616);
            return false;
        }
        AppMethodBeat.o(85616);
        return true;
    }

    private AlertDialog buildAlertDialog() {
        AppMethodBeat.i(85617);
        AlertDialog create = new Builder(this.mContext).create();
        create.setIcon(17301543);
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(85617);
        return create;
    }

    private ProgressDialog buildProgressDialog() {
        AppMethodBeat.i(85618);
        ProgressDialog progressDialog = new ProgressDialog(this.mContext);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(85618);
        return progressDialog;
    }

    private void setTitle(AlertDialog alertDialog, int i) {
        AppMethodBeat.i(85619);
        alertDialog.setTitle(this.mContext.getString(i));
        AppMethodBeat.o(85619);
    }

    private void setMessage(AlertDialog alertDialog, int i) {
        AppMethodBeat.i(85620);
        setMessage(alertDialog, this.mContext.getString(i));
        AppMethodBeat.o(85620);
    }

    private void setMessage(AlertDialog alertDialog, String str) {
        AppMethodBeat.i(85621);
        CharSequence replaceAll = str.replaceAll("APP_NAME", XWalkEnvironment.getApplicationName());
        if (replaceAll.startsWith("this")) {
            replaceAll = replaceAll.replaceFirst("this", "This");
        }
        alertDialog.setMessage(replaceAll);
        AppMethodBeat.o(85621);
    }

    private void setPositiveButton(AlertDialog alertDialog, int i) {
        AppMethodBeat.i(85622);
        alertDialog.setButton(-1, this.mContext.getString(i), null);
        AppMethodBeat.o(85622);
    }

    private void setNegativeButton(AlertDialog alertDialog, int i) {
        AppMethodBeat.i(85623);
        alertDialog.setButton(-2, this.mContext.getString(i), null);
        AppMethodBeat.o(85623);
    }

    private void showDialog(final AlertDialog alertDialog, final ArrayList<ButtonAction> arrayList) {
        AppMethodBeat.i(85624);
        alertDialog.setOnShowListener(new OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                AppMethodBeat.i(85603);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ButtonAction buttonAction = (ButtonAction) it.next();
                    Button button = alertDialog.getButton(buttonAction.mWhich);
                    if (button == null) {
                        if (buttonAction.mMandatory) {
                            RuntimeException runtimeException = new RuntimeException("Button " + buttonAction.mWhich + " is mandatory");
                            AppMethodBeat.o(85603);
                            throw runtimeException;
                        }
                    } else if (buttonAction.mClickAction != null) {
                        final Runnable runnable = buttonAction.mClickAction;
                        button.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                AppMethodBeat.i(85602);
                                XWalkDialogManager.this.dismissDialog();
                                runnable.run();
                                AppMethodBeat.o(85602);
                            }
                        });
                    }
                }
                AppMethodBeat.o(85603);
            }
        });
        this.mActiveDialog = alertDialog;
        this.mActiveDialog.show();
        AppMethodBeat.o(85624);
    }
}
