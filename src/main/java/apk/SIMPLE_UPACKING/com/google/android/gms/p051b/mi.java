package com.google.android.gms.p051b;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* renamed from: com.google.android.gms.b.mi */
public final class mi {
    private final ByteBuffer f4050a;

    private mi(ByteBuffer byteBuffer) {
        this.f4050a = byteBuffer;
        this.f4050a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private mi(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int m7131a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < '\u0080') {
            i++;
        }
        int i2 = i;
        i = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= '\u0800') {
                i += mi.m7132a(charSequence, i2);
                break;
            }
            i2++;
            i = ((127 - charAt) >>> 31) + i;
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    private static int m7132a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < '\u0800') {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if ('\ud800' <= charAt && charAt <= '\udfff') {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int m7133a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '\u0080') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '\u0080' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < '\u0800' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < '\ud800' || '\udfff' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else if ('\ud800' > charAt2 || charAt2 > '\udfff' || (i3 + 1 != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3 + 1)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            } else {
                throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    public static mi m7134a(byte[] bArr) {
        return mi.m7135a(bArr, 0, bArr.length);
    }

    public static mi m7135a(byte[] bArr, int i, int i2) {
        return new mi(bArr, i, i2);
    }

    private static void m7136a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(mi.m7133a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            mi.m7147b(charSequence, byteBuffer);
        }
    }

    public static int m7137b(float f) {
        return 4;
    }

    public static int m7138b(int i) {
        return i >= 0 ? mi.m7152f(i) : 10;
    }

    public static int m7139b(int i, float f) {
        return mi.m7150d(i) + mi.m7137b(f);
    }

    public static int m7140b(int i, int i2) {
        return mi.m7150d(i) + mi.m7138b(i2);
    }

    public static int m7141b(int i, mm mmVar) {
        return mi.m7150d(i) + mi.m7144b(mmVar);
    }

    public static int m7142b(int i, String str) {
        return mi.m7150d(i) + mi.m7145b(str);
    }

    public static int m7143b(int i, boolean z) {
        return mi.m7150d(i) + mi.m7146b(z);
    }

    public static int m7144b(mm mmVar) {
        int e = mmVar.m6966e();
        return e + mi.m7152f(e);
    }

    public static int m7145b(String str) {
        int a = mi.m7131a((CharSequence) str);
        return a + mi.m7152f(a);
    }

    public static int m7146b(boolean z) {
        return 1;
    }

    private static void m7147b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '\u0080') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < '\u0800') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else if (charAt < '\ud800' || '\udfff' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int m7148c(int i, long j) {
        return mi.m7150d(i) + mi.m7151d(j);
    }

    public static int m7149c(long j) {
        return mi.m7153f(j);
    }

    public static int m7150d(int i) {
        return mi.m7152f(mo.m7194a(i, 0));
    }

    public static int m7151d(long j) {
        return mi.m7153f(j);
    }

    public static int m7152f(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int m7153f(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public int m7154a() {
        return this.f4050a.remaining();
    }

    public void m7155a(byte b) {
        if (this.f4050a.hasRemaining()) {
            this.f4050a.put(b);
            return;
        }
        throw new mj(this.f4050a.position(), this.f4050a.limit());
    }

    public void m7156a(float f) {
        m7175g(Float.floatToIntBits(f));
    }

    public void m7157a(int i) {
        if (i >= 0) {
            m7173e(i);
        } else {
            m7174e((long) i);
        }
    }

    public void m7158a(int i, float f) {
        m7172c(i, 5);
        m7156a(f);
    }

    public void m7159a(int i, int i2) {
        m7172c(i, 0);
        m7157a(i2);
    }

    public void m7160a(int i, long j) {
        m7172c(i, 0);
        m7164a(j);
    }

    public void m7161a(int i, mm mmVar) {
        m7172c(i, 2);
        m7165a(mmVar);
    }

    public void m7162a(int i, String str) {
        m7172c(i, 2);
        m7166a(str);
    }

    public void m7163a(int i, boolean z) {
        m7172c(i, 0);
        m7167a(z);
    }

    public void m7164a(long j) {
        m7174e(j);
    }

    public void m7165a(mm mmVar) {
        m7173e(mmVar.m6965d());
        mmVar.m6962a(this);
    }

    public void m7166a(String str) {
        try {
            int f = mi.m7152f(str.length());
            if (f == mi.m7152f(str.length() * 3)) {
                int position = this.f4050a.position();
                if (this.f4050a.remaining() < f) {
                    throw new mj(f + position, this.f4050a.limit());
                }
                this.f4050a.position(position + f);
                mi.m7136a((CharSequence) str, this.f4050a);
                int position2 = this.f4050a.position();
                this.f4050a.position(position);
                m7173e((position2 - position) - f);
                this.f4050a.position(position2);
                return;
            }
            m7173e(mi.m7131a((CharSequence) str));
            mi.m7136a((CharSequence) str, this.f4050a);
        } catch (Throwable e) {
            mj mjVar = new mj(this.f4050a.position(), this.f4050a.limit());
            mjVar.initCause(e);
            throw mjVar;
        }
    }

    public void m7167a(boolean z) {
        m7171c(z ? 1 : 0);
    }

    public void m7168b() {
        if (m7154a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void m7169b(int i, long j) {
        m7172c(i, 0);
        m7170b(j);
    }

    public void m7170b(long j) {
        m7174e(j);
    }

    public void m7171c(int i) {
        m7155a((byte) i);
    }

    public void m7172c(int i, int i2) {
        m7173e(mo.m7194a(i, i2));
    }

    public void m7173e(int i) {
        while ((i & -128) != 0) {
            m7171c((i & 127) | 128);
            i >>>= 7;
        }
        m7171c(i);
    }

    public void m7174e(long j) {
        while ((-128 & j) != 0) {
            m7171c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m7171c((int) j);
    }

    public void m7175g(int i) {
        if (this.f4050a.remaining() < 4) {
            throw new mj(this.f4050a.position(), this.f4050a.limit());
        }
        this.f4050a.putInt(i);
    }
}
