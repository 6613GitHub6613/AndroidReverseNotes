package com.tencent.mm.plugin.voip.video;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.voip.video.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class OpenGlRender implements Renderer {
    public static int FLAG_Angle270 = 12;
    public static int FLAG_Angle90 = 4;
    public static int FLAG_Mirror = 16;
    public static int FLAG_NV12 = 2;
    public static int FLAG_NV21 = 3;
    public static int FLAG_RGBA = 0;
    public static int FLAG_RGBAClip = 1;
    public static int FLAG_YV12 = 0;
    public static int FLAG_YV12Edge = 1;
    public static int MSG_FLUSH = 1;
    public static int MSG_RENDER = 0;
    public static int MSG_RESET = 2;
    public static int RenderLocal = 0;
    public static int RenderRemote = 1;
    public static String TAG = "OpenGlRender";
    public static int taQ = 0;
    static boolean taX = false;
    public float mBrightness = 1.2f;
    public float mContrast = 1.93f;
    int mRenderMode = RenderLocal;
    public float mSaturation = 1.05f;
    public boolean taA = false;
    boolean taB = false;
    boolean taC = false;
    boolean taD = false;
    int taE = 0;
    int taF = 0;
    WeakReference<OpenGlView> taG;
    public boolean taH = false;
    public Bitmap taI = null;
    private int taJ = 0;
    private int taK = 0;
    private byte[] taL = null;
    private int[] taM = null;
    private int taN;
    private int taO;
    private int taP;
    b taR;
    private boolean taS;
    private int taT;
    private volatile boolean taU = false;
    public volatile boolean taV = false;
    WeakReference<Object> taW;
    boolean tat = false;
    int tau = 0;
    long tav = 0;
    long taw = 0;
    int tax = 0;
    a tay;
    boolean taz = false;

    class a extends ak {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(5070);
            OpenGlRender.this.requestRender();
            AppMethodBeat.o(5070);
        }
    }

    private native void render32(int[] iArr, int i, int i2, int i3, int i4);

    private native void render8(byte[] bArr, int i, int i2, int i3, int i4);

    public final native void Init(int i, Object obj, int i2);

    public final native void Uninit(int i);

    public final native void setMode(int i, int i2, int i3, int i4);

    public final native void setParam(float f, float f2, float f3, int i);

    public static int getGLVersion() {
        int i;
        AppMethodBeat.i(5071);
        if (taQ == 0) {
            if (d.iW(21)) {
                taQ = 2;
            } else {
                if (((ActivityManager) ah.getContext().getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    i = 2;
                } else {
                    i = 1;
                }
                taQ = i;
                if (Build.MODEL.equals("Nexus 6")) {
                    taQ = 2;
                }
            }
            ab.i(TAG, "init gl version: %s", Integer.valueOf(taQ));
        }
        i = taQ;
        AppMethodBeat.o(5071);
        return i;
    }

    public OpenGlRender(OpenGlView openGlView, int i) {
        AppMethodBeat.i(5072);
        if (!taX) {
            k.a("mm_gl_disp", OpenGlRender.class.getClassLoader());
            taX = true;
        }
        this.mRenderMode = i;
        this.taG = new WeakReference(openGlView);
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.tay = new a(myLooper);
        } else {
            myLooper = Looper.getMainLooper();
            if (myLooper != null) {
                this.tay = new a(myLooper);
            } else {
                this.tay = null;
            }
        }
        this.taW = null;
        if (getGLVersion() == 2) {
            this.taR = new b();
        }
        this.taT = 0;
        AppMethodBeat.o(5072);
    }

    public final void onDrawFrame(GL10 gl10) {
        AppMethodBeat.i(5073);
        if (this.taA && this.taz && this.taG.get() != null) {
            if (this.taL != null) {
                int i = (this.taP & FLAG_Mirror) != 0 ? 1 : 0;
                if (this.taR == null || ((!this.taS || this.taT == 0) && !this.taV)) {
                    render8(this.taL, this.taN, this.taO, this.taP, this.mRenderMode);
                } else {
                    ab.d(TAG, "steve:doing voip beauty!beautyParam:%d", Integer.valueOf(this.taT));
                    b bVar = this.taR;
                    int i2 = this.taT;
                    if (!bVar.eNa) {
                        bVar.eZO = b.U("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
                        if (bVar.eZO == 0) {
                            ab.e("MicroMsg.FilterRenderer", "checkInit, load program failed!");
                        }
                        bVar.eZQ = GLES20.glGetAttribLocation(bVar.eZO, "a_position");
                        bVar.eZP = GLES20.glGetAttribLocation(bVar.eZO, "a_texCoord");
                        bVar.eZR = GLES20.glGetUniformLocation(bVar.eZO, "y_texture");
                        bVar.eZS = GLES20.glGetUniformLocation(bVar.eZO, "uv_texture");
                        bVar.eZT = GLES20.glGetUniformLocation(bVar.eZO, "uMatrix");
                        bVar.eZM = b.Vh();
                        bVar.eZN = b.Vh();
                        bVar.tbR = b.U("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D texture;                       \nvoid main (void) {                                 \n   gl_FragColor = vec4(texture2D(texture, v_texCoord).rgb, 1.0); \n}");
                        bVar.lpE = GLES20.glGetAttribLocation(bVar.tbR, "a_position");
                        bVar.lpD = GLES20.glGetAttribLocation(bVar.tbR, "a_texCoord");
                        bVar.lpF = GLES20.glGetUniformLocation(bVar.tbR, "texture");
                        bVar.lpG = GLES20.glGetUniformLocation(bVar.tbR, "uMatrix");
                        bVar.lpC = b.Vh();
                        bVar.lpS = b.Vh();
                        float[] fArr = b.eZY;
                        bVar.gLB = Arrays.copyOf(fArr, fArr.length);
                        bVar.eZi = ByteBuffer.allocateDirect(bVar.gLB.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                        bVar.eZi.put(bVar.gLB);
                        bVar.eZi.position(0);
                        bVar.eZh = ByteBuffer.allocateDirect(b.eZZ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                        bVar.eZh.put(b.eZZ);
                        bVar.eZh.position(0);
                        fArr = b.tbQ;
                        bVar.lpP = Arrays.copyOf(fArr, fArr.length);
                        bVar.lpK = ByteBuffer.allocateDirect(bVar.lpP.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                        bVar.lpK.put(bVar.lpP);
                        bVar.lpK.position(0);
                        fArr = b.eZY;
                        bVar.lpO = Arrays.copyOf(fArr, fArr.length);
                        bVar.lpL = ByteBuffer.allocateDirect(bVar.lpO.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                        bVar.lpL.put(bVar.lpO);
                        bVar.lpL.position(0);
                        bVar.lpQ = b.Vi();
                        bVar.sWh = null;
                        bVar.lpR = b.Vi();
                        bVar.lpU = b.Vh();
                        if (i2 != 0) {
                            bVar.tbV = new com.tencent.mm.plugin.voip.video.a.a();
                            bVar.tbV.initial(bVar.lpS, bVar.lpU);
                        }
                        ab.i("MicroMsg.FilterRenderer", "%s checkInit, finish init", Integer.valueOf(bVar.hashCode()));
                        bVar.eNa = true;
                    }
                    this.taR.updateSize(this.taE, this.taF);
                    if (i == 0) {
                        this.taR.c(this.taL, this.taN, this.taO, this.taP, 0);
                    } else {
                        this.taR.c(this.taL, this.taN, this.taO, this.taP, this.taT);
                    }
                }
                this.taL = null;
            }
            if (this.taM != null) {
                if (this.taR != null) {
                    this.taR.reset();
                }
                render32(this.taM, this.taN, this.taO, this.taP, this.mRenderMode);
                this.taM = null;
            }
            if (this.taU && getGLVersion() == 2) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16640);
            }
            AppMethodBeat.o(5073);
            return;
        }
        this.taL = null;
        this.taM = null;
        AppMethodBeat.o(5073);
    }

    public final void mD(boolean z) {
        AppMethodBeat.i(5074);
        ab.i(TAG, "drawTransparent: %s", Boolean.valueOf(z));
        this.taU = z;
        requestRender();
        AppMethodBeat.o(5074);
    }

    public final void c(byte[] bArr, int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(5075);
        if (this.taz && this.taL == null) {
            this.taN = i;
            this.taO = i2;
            this.taP = i3;
            this.taL = bArr;
            this.taS = z;
            requestRender();
        }
        AppMethodBeat.o(5075);
    }

    public final void a(int[] iArr, int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(5076);
        if (this.taz && this.taM == null) {
            this.taN = i;
            this.taO = i2;
            this.taP = i3;
            this.taM = iArr;
            this.taS = z;
            requestRender();
        }
        AppMethodBeat.o(5076);
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        AppMethodBeat.i(5077);
        ab.i(TAG, "%s onSurfaceChanged, width: %s, height: %s, self:%b, UI:%dx%d,mode:%d", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.taS), Integer.valueOf(this.taE), Integer.valueOf(this.taF), Integer.valueOf(this.mRenderMode));
        if (!(this.taE == i && this.taF == i2)) {
            gl10.glViewport(0, 0, i, i2);
            this.taE = i;
            this.taF = i2;
            if (VERSION.SDK_INT >= 23) {
                setMode(this.taE, this.taF, 1, this.mRenderMode);
            }
        }
        if (this.taR != null) {
            this.taR.updateSize(i, i2);
        }
        AppMethodBeat.o(5077);
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
    }

    public final void cLI() {
        AppMethodBeat.i(5078);
        ab.i(TAG, "%s onStop, renderMode: %s", Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode));
        this.taA = false;
        this.taD = false;
        AppMethodBeat.o(5078);
    }

    public final void cLJ() {
        AppMethodBeat.i(5079);
        ab.i(TAG, "%s steve: try to reset GLRender mode=%d, inited:%b, started:%b", Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode), Boolean.valueOf(this.taz), Boolean.valueOf(this.taA));
        if (this.taz && this.taA) {
            ab.i(TAG, "%s steve: Reset GLRender first! mode=%d", Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode));
            this.taz = false;
            this.taA = false;
            Uninit(this.mRenderMode);
            if (this.taR != null) {
                if (this.taG != null && this.taG.get() != null) {
                    ((OpenGlView) this.taG.get()).queueEvent(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(5069);
                            if (OpenGlRender.this.taR != null) {
                                OpenGlRender.this.taR.destroy();
                            }
                            AppMethodBeat.o(5069);
                        }
                    });
                    AppMethodBeat.o(5079);
                    return;
                } else if (this.taR != null) {
                    this.taR.destroy();
                }
            }
        }
        AppMethodBeat.o(5079);
    }

    public final void setVoipBeauty(int i) {
        AppMethodBeat.i(5080);
        ab.i(TAG, "steve: isDrawingSelf:%b, set voipbeauty:%d, beautyParam:%d", Boolean.valueOf(this.taS), Integer.valueOf(i), Integer.valueOf(this.taT));
        this.taT = i;
        AppMethodBeat.o(5080);
    }

    public final void requestRender() {
        AppMethodBeat.i(5081);
        if (this.taz) {
            if (!this.taD) {
                setMode(((OpenGlView) this.taG.get()).getWidth(), ((OpenGlView) this.taG.get()).getHeight(), 0, this.mRenderMode);
                this.taD = true;
            }
            if (this.taG.get() != null) {
                ((OpenGlView) this.taG.get()).cLK();
            }
            AppMethodBeat.o(5081);
            return;
        }
        AppMethodBeat.o(5081);
    }

    public final void a(com.tencent.mm.plugin.voip.video.a.d dVar) {
        AppMethodBeat.i(5082);
        if (!(this.taR == null || this.taR.cLS() == null)) {
            dVar.bu(this.taR.cLS());
        }
        AppMethodBeat.o(5082);
    }
}
