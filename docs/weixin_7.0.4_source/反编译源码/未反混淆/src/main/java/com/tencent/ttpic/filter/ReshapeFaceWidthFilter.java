package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import java.util.Map;

public class ReshapeFaceWidthFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeFaceWidthVertexShader.dat");
    private static final int XCOORD_NUM = 128;
    private static final int YCOORD_NUM = 128;
    private static List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private float[] angles = new float[]{0.0f, 0.0f, 0.0f};
    private float faceWidth = 1.0f;
    private float[] leftEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
    private float[] leftEyePlainSize = new float[]{0.0f, 0.0f};
    private float[] leftFaceCenter = new float[]{0.0f, 0.0f, 0.0f};
    private float[] leftFacePlainSize = new float[]{0.0f, 0.0f};
    private float[] rightEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
    private float[] rightEyePlainSize = new float[]{0.0f, 0.0f};
    private float[] rightFaceCenter = new float[]{0.0f, 0.0f, 0.0f};
    private float[] rightFacePlainSize = new float[]{0.0f, 0.0f};
    private float[] scaleCenter = new float[]{0.0f, 0.0f, 0.0f};

    static {
        AppMethodBeat.i(82778);
        AppMethodBeat.o(82778);
    }

    public ReshapeFaceWidthFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.i(82773);
        initParams();
        AppMethodBeat.o(82773);
    }

    public void initParams() {
        AppMethodBeat.i(82774);
        addParam(new g("leftEyePlainSize", this.leftEyePlainSize));
        addParam(new g("leftEyeCenter", this.leftEyeCenter));
        addParam(new g("rightEyePlainSize", this.rightEyePlainSize));
        addParam(new g("rightEyeCenter", this.rightEyeCenter));
        addParam(new g("leftFacePlainSize", this.leftFacePlainSize));
        addParam(new g("leftFaceCenter", this.leftFaceCenter));
        addParam(new g("rightFacePlainSize", this.rightFacePlainSize));
        addParam(new g("rightFaceCenter", this.rightFaceCenter));
        addParam(new g("scaleCenter", this.scaleCenter));
        addParam(new f("faceWidth", this.faceWidth));
        addParam(new g("angles", this.angles));
        AppMethodBeat.o(82774);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82775);
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
        setCoordNum(32897);
        AppMethodBeat.o(82775);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82776);
        initParams();
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        AppMethodBeat.o(82776);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.i(82777);
        if (map.containsKey("leftEyePlainSize")) {
            this.leftEyePlainSize = (float[]) map.get("leftEyePlainSize");
        }
        if (map.containsKey("leftEyeCenter")) {
            this.leftEyeCenter = (float[]) map.get("leftEyeCenter");
        }
        if (map.containsKey("rightEyePlainSize")) {
            this.rightEyePlainSize = (float[]) map.get("rightEyePlainSize");
        }
        if (map.containsKey("rightEyeCenter")) {
            this.rightEyeCenter = (float[]) map.get("rightEyeCenter");
        }
        if (map.containsKey("leftFacePlainSize")) {
            this.leftFacePlainSize = (float[]) map.get("leftFacePlainSize");
        }
        if (map.containsKey("leftFaceCenter")) {
            this.leftFaceCenter = (float[]) map.get("leftFaceCenter");
        }
        if (map.containsKey("rightFacePlainSize")) {
            this.rightFacePlainSize = (float[]) map.get("rightFacePlainSize");
        }
        if (map.containsKey("rightFaceCenter")) {
            this.rightFaceCenter = (float[]) map.get("rightFaceCenter");
        }
        if (map.containsKey("scaleCenter")) {
            this.scaleCenter = (float[]) map.get("scaleCenter");
        }
        if (map.containsKey("faceWidth")) {
            this.faceWidth = ((Float) map.get("faceWidth")).floatValue() * 0.0069999998f;
        }
        if (map.containsKey("angles")) {
            this.angles = (float[]) map.get("angles");
        }
        initParams();
        AppMethodBeat.o(82777);
    }
}
