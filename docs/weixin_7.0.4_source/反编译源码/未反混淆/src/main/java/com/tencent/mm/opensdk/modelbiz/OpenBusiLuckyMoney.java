package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class OpenBusiLuckyMoney {

    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String appId;
        public String nonceStr;
        public String packageExt;
        public String signType;
        public String signature;
        public String timeStamp;

        public boolean checkArgs() {
            AppMethodBeat.i(128155);
            if (this.appId == null || this.appId.length() <= 0) {
                AppMethodBeat.o(128155);
                return false;
            } else if (this.timeStamp == null || this.timeStamp.length() <= 0) {
                AppMethodBeat.o(128155);
                return false;
            } else if (this.nonceStr == null || this.nonceStr.length() <= 0) {
                AppMethodBeat.o(128155);
                return false;
            } else if (this.signType == null || this.signType.length() <= 0) {
                AppMethodBeat.o(128155);
                return false;
            } else if (this.signature == null || this.signature.length() <= 0) {
                AppMethodBeat.o(128155);
                return false;
            } else {
                AppMethodBeat.o(128155);
                return true;
            }
        }

        public int getType() {
            return 13;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128156);
            super.toBundle(bundle);
            bundle.putString("_wxapi_open_busi_lucky_money_appid", this.appId);
            bundle.putString("_wxapi_open_busi_lucky_money_timeStamp", this.timeStamp);
            bundle.putString("_wxapi_open_busi_lucky_money_nonceStr", this.nonceStr);
            bundle.putString("_wxapi_open_busi_lucky_money_signType", this.signType);
            bundle.putString("_wxapi_open_busi_lucky_money_signature", this.signature);
            bundle.putString("_wxapi_open_busi_lucky_money_package", this.packageExt);
            AppMethodBeat.o(128156);
        }
    }
}
