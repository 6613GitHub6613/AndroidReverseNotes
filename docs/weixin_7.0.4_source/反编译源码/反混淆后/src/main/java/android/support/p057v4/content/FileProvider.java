package android.support.p057v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v4.content.FileProvider */
public class FileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = new String[]{"_display_name", "_size"};
    private static final File DEVICE_ROOT = new File("/");
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static HashMap<String, C8381a> sCache = new HashMap();
    private C8381a mStrategy;

    /* renamed from: android.support.v4.content.FileProvider$a */
    interface C8381a {
        /* renamed from: c */
        File mo18305c(Uri uri);

        /* renamed from: i */
        Uri mo18306i(File file);
    }

    /* renamed from: android.support.v4.content.FileProvider$b */
    static class C8382b implements C8381a {
        /* renamed from: Gl */
        private final String f2341Gl;
        /* renamed from: Gm */
        final HashMap<String, File> f2342Gm = new HashMap();

        C8382b(String str) {
            this.f2341Gl = str;
        }

        /* renamed from: i */
        public final Uri mo18306i(File file) {
            try {
                String path;
                String canonicalPath = file.getCanonicalPath();
                Entry entry = null;
                for (Entry entry2 : this.f2342Gm.entrySet()) {
                    Entry entry22;
                    path = ((File) entry22.getValue()).getPath();
                    if (!canonicalPath.startsWith(path) || (entry != null && path.length() <= ((File) entry.getValue()).getPath().length())) {
                        entry22 = entry;
                    }
                    entry = entry22;
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains ".concat(String.valueOf(canonicalPath)));
                }
                String path2 = ((File) entry.getValue()).getPath();
                if (path2.endsWith("/")) {
                    path = canonicalPath.substring(path2.length());
                } else {
                    path = canonicalPath.substring(path2.length() + 1);
                }
                return new Builder().scheme(C8741b.CONTENT).authority(this.f2341Gl).encodedPath(Uri.encode((String) entry.getKey()) + IOUtils.DIR_SEPARATOR_UNIX + Uri.encode(path, "/")).build();
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)));
            }
        }

        /* renamed from: c */
        public final File mo18305c(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = (File) this.f2342Gm.get(decode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for ".concat(String.valueOf(uri)));
            }
            File file2 = new File(file, decode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file2)));
            }
        }
    }

    public boolean onCreate() {
        return true;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            this.mStrategy = FileProvider.getPathStrategy(context, providerInfo.authority);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        return FileProvider.getPathStrategy(context, str).mo18306i(file);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        File c = this.mStrategy.mo18305c(uri);
        if (strArr == null) {
            strArr = COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            Object obj = strArr[i];
            if ("_display_name".equals(obj)) {
                strArr3[i2] = "_display_name";
                i3 = i2 + 1;
                objArr[i2] = c.getName();
            } else if ("_size".equals(obj)) {
                strArr3[i2] = "_size";
                i3 = i2 + 1;
                objArr[i2] = Long.valueOf(c.length());
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        String[] copyOf = FileProvider.copyOf(strArr3, i2);
        Object[] copyOf2 = FileProvider.copyOf(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(copyOf, 1);
        matrixCursor.addRow(copyOf2);
        return matrixCursor;
    }

    public String getType(Uri uri) {
        File c = this.mStrategy.mo18305c(uri);
        int lastIndexOf = c.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(c.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.mStrategy.mo18305c(uri).delete() ? 1 : 0;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(this.mStrategy.mo18305c(uri), FileProvider.modeToMode(str));
    }

    private static C8381a getPathStrategy(Context context, String str) {
        C8381a c8381a;
        synchronized (sCache) {
            c8381a = (C8381a) sCache.get(str);
            if (c8381a == null) {
                try {
                    c8381a = FileProvider.parsePathStrategy(context, str);
                    sCache.put(str, c8381a);
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return c8381a;
    }

    private static C8381a parsePathStrategy(Context context, String str) {
        C8382b c8382b = new C8382b(str);
        XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (loadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = loadXmlMetaData.next();
            if (next == 1) {
                return c8382b;
            }
            if (next == 2) {
                File file;
                String name = loadXmlMetaData.getName();
                String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                String attributeValue2 = loadXmlMetaData.getAttributeValue(null, ATTR_PATH);
                if (TAG_ROOT_PATH.equals(name)) {
                    file = DEVICE_ROOT;
                } else if (TAG_FILES_PATH.equals(name)) {
                    file = context.getFilesDir();
                } else if (TAG_CACHE_PATH.equals(name)) {
                    file = context.getCacheDir();
                } else if (TAG_EXTERNAL.equals(name)) {
                    file = Environment.getExternalStorageDirectory();
                } else {
                    File[] O;
                    if (TAG_EXTERNAL_FILES.equals(name)) {
                        O = C0380b.m644O(context);
                        if (O.length > 0) {
                            file = O[0];
                        }
                    } else if (TAG_EXTERNAL_CACHE.equals(name)) {
                        O = C0380b.m645P(context);
                        if (O.length > 0) {
                            file = O[0];
                        }
                    } else if (VERSION.SDK_INT >= 21 && TAG_EXTERNAL_MEDIA.equals(name)) {
                        O = context.getExternalMediaDirs();
                        if (O.length > 0) {
                            file = O[0];
                        }
                    }
                    file = null;
                }
                if (file != null) {
                    Object buildPath = FileProvider.buildPath(file, attributeValue2);
                    if (TextUtils.isEmpty(attributeValue)) {
                        throw new IllegalArgumentException("Name must not be empty");
                    }
                    try {
                        c8382b.f2342Gm.put(attributeValue, buildPath.getCanonicalFile());
                    } catch (IOException e) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(buildPath)), e);
                    }
                }
                continue;
            }
        }
    }

    private static int modeToMode(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: ".concat(String.valueOf(str)));
    }

    private static File buildPath(File file, String... strArr) {
        int length = strArr.length;
        int i = 0;
        File file2 = file;
        while (i < length) {
            File file3;
            String str = strArr[i];
            if (str != null) {
                file3 = new File(file2, str);
            } else {
                file3 = file2;
            }
            i++;
            file2 = file3;
        }
        return file2;
    }

    private static String[] copyOf(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    private static Object[] copyOf(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }
}
