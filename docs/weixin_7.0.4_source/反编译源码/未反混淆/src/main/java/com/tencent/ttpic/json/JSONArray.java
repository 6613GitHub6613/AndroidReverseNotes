package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.wav.WavFileHeader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class JSONArray {
    private final ArrayList myArrayList;

    public JSONArray() {
        AppMethodBeat.i(50057);
        this.myArrayList = new ArrayList();
        AppMethodBeat.o(50057);
    }

    public JSONArray(JSONTokener jSONTokener) {
        this();
        AppMethodBeat.i(50058);
        JSONException syntaxError;
        if (jSONTokener.nextClean() != '[') {
            syntaxError = jSONTokener.syntaxError("A JSONArray text must start with '['");
            AppMethodBeat.o(50058);
            throw syntaxError;
        } else if (jSONTokener.nextClean() != ']') {
            jSONTokener.back();
            while (true) {
                if (jSONTokener.nextClean() == ',') {
                    jSONTokener.back();
                    this.myArrayList.add(JSONObject.NULL);
                } else {
                    jSONTokener.back();
                    this.myArrayList.add(jSONTokener.nextValue());
                }
                switch (jSONTokener.nextClean()) {
                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        if (jSONTokener.nextClean() == ']') {
                            AppMethodBeat.o(50058);
                            return;
                        }
                        jSONTokener.back();
                    case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
                        AppMethodBeat.o(50058);
                        return;
                    default:
                        syntaxError = jSONTokener.syntaxError("Expected a ',' or ']'");
                        AppMethodBeat.o(50058);
                        throw syntaxError;
                }
            }
        } else {
            AppMethodBeat.o(50058);
        }
    }

    public JSONArray(String str) {
        this(new JSONTokener(str));
        AppMethodBeat.i(50059);
        AppMethodBeat.o(50059);
    }

    public JSONArray(Collection collection) {
        AppMethodBeat.i(50060);
        this.myArrayList = new ArrayList();
        if (collection != null) {
            for (Object wrap : collection) {
                this.myArrayList.add(JSONObject.wrap(wrap));
            }
        }
        AppMethodBeat.o(50060);
    }

    public JSONArray(Object obj) {
        this();
        AppMethodBeat.i(50061);
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                put(JSONObject.wrap(Array.get(obj, i)));
            }
            AppMethodBeat.o(50061);
            return;
        }
        JSONException jSONException = new JSONException("JSONArray initial value should be a string or collection or array.");
        AppMethodBeat.o(50061);
        throw jSONException;
    }

    public Object get(int i) {
        AppMethodBeat.i(50062);
        Object opt = opt(i);
        if (opt == null) {
            JSONException jSONException = new JSONException("JSONArray[" + i + "] not found.");
            AppMethodBeat.o(50062);
            throw jSONException;
        }
        AppMethodBeat.o(50062);
        return opt;
    }

    public boolean getBoolean(int i) {
        AppMethodBeat.i(50063);
        Object obj = get(i);
        if (obj.equals(Boolean.FALSE) || ((obj instanceof String) && ((String) obj).equalsIgnoreCase("false"))) {
            AppMethodBeat.o(50063);
            return false;
        } else if (obj.equals(Boolean.TRUE) || ((obj instanceof String) && ((String) obj).equalsIgnoreCase("true"))) {
            AppMethodBeat.o(50063);
            return true;
        } else {
            JSONException jSONException = new JSONException("JSONArray[" + i + "] is not a boolean.");
            AppMethodBeat.o(50063);
            throw jSONException;
        }
    }

    public double getDouble(int i) {
        AppMethodBeat.i(50064);
        Object obj = get(i);
        try {
            double doubleValue;
            if (obj instanceof Number) {
                doubleValue = ((Number) obj).doubleValue();
                AppMethodBeat.o(50064);
                return doubleValue;
            }
            doubleValue = Double.parseDouble((String) obj);
            AppMethodBeat.o(50064);
            return doubleValue;
        } catch (Exception e) {
            JSONException jSONException = new JSONException("JSONArray[" + i + "] is not a number.");
            AppMethodBeat.o(50064);
            throw jSONException;
        }
    }

    public int getInt(int i) {
        AppMethodBeat.i(50065);
        Object obj = get(i);
        try {
            int intValue;
            if (obj instanceof Number) {
                intValue = ((Number) obj).intValue();
                AppMethodBeat.o(50065);
                return intValue;
            }
            intValue = Integer.parseInt((String) obj);
            AppMethodBeat.o(50065);
            return intValue;
        } catch (Exception e) {
            JSONException jSONException = new JSONException("JSONArray[" + i + "] is not a number.");
            AppMethodBeat.o(50065);
            throw jSONException;
        }
    }

    public JSONArray getJSONArray(int i) {
        AppMethodBeat.i(50066);
        Object obj = get(i);
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            AppMethodBeat.o(50066);
            return jSONArray;
        }
        JSONException jSONException = new JSONException("JSONArray[" + i + "] is not a JSONArray.");
        AppMethodBeat.o(50066);
        throw jSONException;
    }

    public JSONObject getJSONObject(int i) {
        AppMethodBeat.i(50067);
        Object obj = get(i);
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            AppMethodBeat.o(50067);
            return jSONObject;
        }
        JSONException jSONException = new JSONException("JSONArray[" + i + "] is not a JSONObject.");
        AppMethodBeat.o(50067);
        throw jSONException;
    }

    public long getLong(int i) {
        AppMethodBeat.i(50068);
        Object obj = get(i);
        try {
            long longValue;
            if (obj instanceof Number) {
                longValue = ((Number) obj).longValue();
                AppMethodBeat.o(50068);
                return longValue;
            }
            longValue = Long.parseLong((String) obj);
            AppMethodBeat.o(50068);
            return longValue;
        } catch (Exception e) {
            JSONException jSONException = new JSONException("JSONArray[" + i + "] is not a number.");
            AppMethodBeat.o(50068);
            throw jSONException;
        }
    }

    public String getString(int i) {
        AppMethodBeat.i(50069);
        Object obj = get(i);
        if (obj instanceof String) {
            String str = (String) obj;
            AppMethodBeat.o(50069);
            return str;
        }
        JSONException jSONException = new JSONException("JSONArray[" + i + "] not a string.");
        AppMethodBeat.o(50069);
        throw jSONException;
    }

    public boolean isNull(int i) {
        AppMethodBeat.i(50070);
        boolean equals = JSONObject.NULL.equals(opt(i));
        AppMethodBeat.o(50070);
        return equals;
    }

    public String join(String str) {
        AppMethodBeat.i(50071);
        int length = length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(JSONObject.valueToString(this.myArrayList.get(i)));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(50071);
        return stringBuffer2;
    }

    public int length() {
        AppMethodBeat.i(50072);
        int size = this.myArrayList.size();
        AppMethodBeat.o(50072);
        return size;
    }

    public Object opt(int i) {
        AppMethodBeat.i(50073);
        if (i < 0 || i >= length()) {
            AppMethodBeat.o(50073);
            return null;
        }
        Object obj = this.myArrayList.get(i);
        AppMethodBeat.o(50073);
        return obj;
    }

    public boolean optBoolean(int i) {
        AppMethodBeat.i(50074);
        boolean optBoolean = optBoolean(i, false);
        AppMethodBeat.o(50074);
        return optBoolean;
    }

    public boolean optBoolean(int i, boolean z) {
        AppMethodBeat.i(50075);
        try {
            z = getBoolean(i);
            AppMethodBeat.o(50075);
        } catch (Exception e) {
            AppMethodBeat.o(50075);
        }
        return z;
    }

    public double optDouble(int i) {
        AppMethodBeat.i(50076);
        double optDouble = optDouble(i, Double.NaN);
        AppMethodBeat.o(50076);
        return optDouble;
    }

    public double optDouble(int i, double d) {
        AppMethodBeat.i(50077);
        try {
            d = getDouble(i);
            AppMethodBeat.o(50077);
        } catch (Exception e) {
            AppMethodBeat.o(50077);
        }
        return d;
    }

    public int optInt(int i) {
        AppMethodBeat.i(50078);
        int optInt = optInt(i, 0);
        AppMethodBeat.o(50078);
        return optInt;
    }

    public int optInt(int i, int i2) {
        AppMethodBeat.i(50079);
        try {
            i2 = getInt(i);
            AppMethodBeat.o(50079);
        } catch (Exception e) {
            AppMethodBeat.o(50079);
        }
        return i2;
    }

    public JSONArray optJSONArray(int i) {
        AppMethodBeat.i(50080);
        Object opt = opt(i);
        if (opt instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) opt;
            AppMethodBeat.o(50080);
            return jSONArray;
        }
        AppMethodBeat.o(50080);
        return null;
    }

    public JSONObject optJSONObject(int i) {
        AppMethodBeat.i(50081);
        Object opt = opt(i);
        if (opt instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) opt;
            AppMethodBeat.o(50081);
            return jSONObject;
        }
        AppMethodBeat.o(50081);
        return null;
    }

    public long optLong(int i) {
        AppMethodBeat.i(50082);
        long optLong = optLong(i, 0);
        AppMethodBeat.o(50082);
        return optLong;
    }

    public long optLong(int i, long j) {
        AppMethodBeat.i(50083);
        try {
            j = getLong(i);
            AppMethodBeat.o(50083);
        } catch (Exception e) {
            AppMethodBeat.o(50083);
        }
        return j;
    }

    public String optString(int i) {
        AppMethodBeat.i(50084);
        String optString = optString(i, "");
        AppMethodBeat.o(50084);
        return optString;
    }

    public String optString(int i, String str) {
        AppMethodBeat.i(50085);
        Object opt = opt(i);
        if (JSONObject.NULL.equals(opt)) {
            AppMethodBeat.o(50085);
            return str;
        }
        str = opt.toString();
        AppMethodBeat.o(50085);
        return str;
    }

    public JSONArray put(boolean z) {
        AppMethodBeat.i(50086);
        put(z ? Boolean.TRUE : Boolean.FALSE);
        AppMethodBeat.o(50086);
        return this;
    }

    public JSONArray put(Collection collection) {
        AppMethodBeat.i(50087);
        put(new JSONArray(collection));
        AppMethodBeat.o(50087);
        return this;
    }

    public JSONArray put(double d) {
        AppMethodBeat.i(50088);
        Object valueOf = Double.valueOf(d);
        JSONObject.testValidity(valueOf);
        put(valueOf);
        AppMethodBeat.o(50088);
        return this;
    }

    public JSONArray put(int i) {
        AppMethodBeat.i(50089);
        put(Integer.valueOf(i));
        AppMethodBeat.o(50089);
        return this;
    }

    public JSONArray put(long j) {
        AppMethodBeat.i(50090);
        put(new Long(j));
        AppMethodBeat.o(50090);
        return this;
    }

    public JSONArray put(Map map) {
        AppMethodBeat.i(50091);
        put(new JSONObject(map));
        AppMethodBeat.o(50091);
        return this;
    }

    public JSONArray put(Object obj) {
        AppMethodBeat.i(50092);
        this.myArrayList.add(obj);
        AppMethodBeat.o(50092);
        return this;
    }

    public JSONArray put(int i, boolean z) {
        AppMethodBeat.i(50093);
        put(i, z ? Boolean.TRUE : Boolean.FALSE);
        AppMethodBeat.o(50093);
        return this;
    }

    public JSONArray put(int i, Collection collection) {
        AppMethodBeat.i(50094);
        put(i, new JSONArray(collection));
        AppMethodBeat.o(50094);
        return this;
    }

    public JSONArray put(int i, double d) {
        AppMethodBeat.i(50095);
        put(i, Double.valueOf(d));
        AppMethodBeat.o(50095);
        return this;
    }

    public JSONArray put(int i, int i2) {
        AppMethodBeat.i(50096);
        put(i, Integer.valueOf(i2));
        AppMethodBeat.o(50096);
        return this;
    }

    public JSONArray put(int i, long j) {
        AppMethodBeat.i(50097);
        put(i, new Long(j));
        AppMethodBeat.o(50097);
        return this;
    }

    public JSONArray put(int i, Map map) {
        AppMethodBeat.i(50098);
        put(i, new JSONObject(map));
        AppMethodBeat.o(50098);
        return this;
    }

    public JSONArray put(int i, Object obj) {
        AppMethodBeat.i(50099);
        JSONObject.testValidity(obj);
        if (i < 0) {
            JSONException jSONException = new JSONException("JSONArray[" + i + "] not found.");
            AppMethodBeat.o(50099);
            throw jSONException;
        }
        if (i < length()) {
            this.myArrayList.set(i, obj);
        } else {
            while (i != length()) {
                put(JSONObject.NULL);
            }
            put(obj);
        }
        AppMethodBeat.o(50099);
        return this;
    }

    public Object remove(int i) {
        AppMethodBeat.i(50100);
        Object opt = opt(i);
        this.myArrayList.remove(i);
        AppMethodBeat.o(50100);
        return opt;
    }

    public JSONObject toJSONObject(JSONArray jSONArray) {
        AppMethodBeat.i(50101);
        if (jSONArray == null || jSONArray.length() == 0 || length() == 0) {
            AppMethodBeat.o(50101);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < jSONArray.length(); i++) {
            jSONObject.put(jSONArray.getString(i), opt(i));
        }
        AppMethodBeat.o(50101);
        return jSONObject;
    }

    public String toString() {
        AppMethodBeat.i(50102);
        try {
            String jSONArray = toString(0);
            AppMethodBeat.o(50102);
            return jSONArray;
        } catch (Exception e) {
            AppMethodBeat.o(50102);
            return null;
        }
    }

    public String toString(int i) {
        String obj;
        AppMethodBeat.i(50103);
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            try {
                obj = write(stringWriter, i, 0).toString();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(50103);
            }
        }
        return obj;
    }

    public Writer write(Writer writer) {
        AppMethodBeat.i(50104);
        Writer write = write(writer, 0, 0);
        AppMethodBeat.o(50104);
        return write;
    }

    /* Access modifiers changed, original: 0000 */
    public Writer write(Writer writer, int i, int i2) {
        AppMethodBeat.i(50105);
        try {
            int length = length();
            writer.write(91);
            if (length == 1) {
                JSONObject.writeValue(writer, this.myArrayList.get(0), i, i2);
            } else if (length != 0) {
                int i3 = i2 + i;
                int i4 = 0;
                Object obj = null;
                while (i4 < length) {
                    if (obj != null) {
                        writer.write(44);
                    }
                    if (i > 0) {
                        writer.write(10);
                    }
                    JSONObject.indent(writer, i3);
                    JSONObject.writeValue(writer, this.myArrayList.get(i4), i, i3);
                    i4++;
                    int obj2 = 1;
                }
                if (i > 0) {
                    writer.write(10);
                }
                JSONObject.indent(writer, i2);
            }
            writer.write(93);
            AppMethodBeat.o(50105);
            return writer;
        } catch (IOException e) {
            JSONException jSONException = new JSONException(e);
            AppMethodBeat.o(50105);
            throw jSONException;
        }
    }
}
