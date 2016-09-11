package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.PriorityQueue;

@fi
/* renamed from: com.google.android.gms.b.ab */
public class ab {
    static long m6071a(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    static long m6072a(long j, int i) {
        return i == 0 ? 1 : i != 1 ? i % 2 == 0 ? ab.m6072a((j * j) % 1073807359, i / 2) % 1073807359 : ((ab.m6072a((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    static String m6073a(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            C0099b.m5639b("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    static void m6074a(int i, long j, String str, int i2, PriorityQueue priorityQueue) {
        ac acVar = new ac(j, str, i2);
        if ((priorityQueue.size() != i || ((ac) priorityQueue.peek()).f3384a <= acVar.f3384a) && !priorityQueue.contains(acVar)) {
            priorityQueue.add(acVar);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void m6075a(String[] strArr, int i, int i2, PriorityQueue priorityQueue) {
        if (strArr.length < i2) {
            int i3 = i;
            ab.m6074a(i3, ab.m6076b(strArr, 0, strArr.length), ab.m6073a(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long b = ab.m6076b(strArr, 0, i2);
        ab.m6074a(i, b, ab.m6073a(strArr, 0, i2), i2, priorityQueue);
        long a = ab.m6072a(16785407, i2 - 1);
        int i4 = 1;
        while (i4 < (strArr.length - i2) + 1) {
            long a2 = ab.m6071a(C0222z.m7272a(strArr[i4 - 1]), C0222z.m7272a(strArr[(i4 + i2) - 1]), b, a, 16785407);
            ab.m6074a(i, a2, ab.m6073a(strArr, i4, i2), strArr.length, priorityQueue);
            i4++;
            b = a2;
        }
    }

    private static long m6076b(String[] strArr, int i, int i2) {
        long a = (((long) C0222z.m7272a(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            a = (((a * 16785407) % 1073807359) + ((((long) C0222z.m7272a(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return a;
    }
}
