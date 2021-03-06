package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@VisibleForTesting
public class UnicodeUtils {
    private static final Pattern zzaal = Pattern.compile("\\\\u[0-9a-fA-F]{4}");

    static {
        AppMethodBeat.i(90279);
        AppMethodBeat.o(90279);
    }

    public static String unescape(String str) {
        AppMethodBeat.i(90278);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90278);
            return str;
        }
        Matcher matcher = zzaal.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            matcher.appendReplacement(stringBuffer, new String(Character.toChars(Integer.parseInt(matcher.group().substring(2), 16))));
        }
        if (stringBuffer == null) {
            AppMethodBeat.o(90278);
            return str;
        }
        matcher.appendTail(stringBuffer);
        str = stringBuffer.toString();
        AppMethodBeat.o(90278);
        return str;
    }
}
