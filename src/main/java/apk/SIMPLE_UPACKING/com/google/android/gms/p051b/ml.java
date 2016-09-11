package com.google.android.gms.p051b;

import java.io.IOException;

/* renamed from: com.google.android.gms.b.ml */
public class ml extends IOException {
    public ml(String str) {
        super(str);
    }

    static ml m7180a() {
        return new ml("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static ml m7181b() {
        return new ml("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static ml m7182c() {
        return new ml("CodedInputStream encountered a malformed varint.");
    }

    static ml m7183d() {
        return new ml("Protocol message contained an invalid tag (zero).");
    }

    static ml m7184e() {
        return new ml("Protocol message end-group tag did not match expected tag.");
    }

    static ml m7185f() {
        return new ml("Protocol message tag had invalid wire type.");
    }

    static ml m7186g() {
        return new ml("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
