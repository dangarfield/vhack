package org.vhack.dev.vhack;

import android.app.Activity;
import android.widget.ArrayAdapter;

/* compiled from: CustomListAdapter */
public class bn extends ArrayAdapter {
    private final Activity f5303a;
    private final String[] f5304b;
    private final Integer[] f5305c;
    private final String[] f5306d;

    public bn(Activity activity, String[] strArr, Integer[] numArr, String[] strArr2) {
        super(activity, 2130968665, strArr);
        this.f5303a = activity;
        this.f5304b = strArr;
        this.f5305c = numArr;
        this.f5306d = strArr2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
        r11 = this;
        r8 = 3;
        r7 = 2;
        r4 = 0;
        r5 = -1;
        r6 = 1;
        r0 = r11.f5303a;
        r0 = r0.getLayoutInflater();
        r1 = 2130968665; // 0x7f040059 float:1.754599E38 double:1.0528384097E-314;
        r2 = 0;
        r9 = r0.inflate(r1, r2, r6);
        r0 = 2131559047; // 0x7f0d0287 float:1.8743427E38 double:1.053130097E-314;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1 = 2131558505; // 0x7f0d0069 float:1.8742328E38 double:1.0531298294E-314;
        r1 = r9.findViewById(r1);
        r1 = (android.widget.ImageView) r1;
        r2 = 2131559048; // 0x7f0d0288 float:1.874343E38 double:1.0531300977E-314;
        r2 = r9.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r3 = "";
        r10 = r11.f5304b;
        r10 = r10[r12];
        r0.setText(r10);
        r0 = r11.f5305c;
        r0 = r0[r12];
        r0 = r0.intValue();
        r1.setImageResource(r0);
        r0 = r11.f5304b;
        r0 = r0[r12];
        r1 = "CPU";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0072;
    L_0x004e:
        r0 = r11.f5304b;
        r0 = r0[r12];
        r1 = "RAM";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0072;
    L_0x005a:
        r0 = r11.f5304b;
        r0 = r0[r12];
        r1 = "HDD";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0072;
    L_0x0066:
        r0 = r11.f5304b;
        r0 = r0[r12];
        r1 = "Internet";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x03a4;
    L_0x0072:
        r0 = r11.f5304b;
        r0 = r0[r12];
        r1 = "CPU";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x008d;
    L_0x007e:
        r0 = r11.f5306d;
        r0 = r0[r12];
        r1 = r0.hashCode();
        switch(r1) {
            case 49: goto L_0x00e9;
            case 50: goto L_0x00f3;
            case 51: goto L_0x00fd;
            case 52: goto L_0x0107;
            case 53: goto L_0x0112;
            case 54: goto L_0x011d;
            case 55: goto L_0x0128;
            case 56: goto L_0x0133;
            case 57: goto L_0x013e;
            case 1567: goto L_0x014a;
            default: goto L_0x0089;
        };
    L_0x0089:
        r0 = r5;
    L_0x008a:
        switch(r0) {
            case 0: goto L_0x0156;
            case 1: goto L_0x015d;
            case 2: goto L_0x0164;
            case 3: goto L_0x016b;
            case 4: goto L_0x0172;
            case 5: goto L_0x0179;
            case 6: goto L_0x0180;
            case 7: goto L_0x0187;
            case 8: goto L_0x018e;
            case 9: goto L_0x0195;
            default: goto L_0x008d;
        };
    L_0x008d:
        r0 = r11.f5304b;
        r0 = r0[r12];
        r1 = "RAM";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x03c0;
    L_0x0099:
        r0 = r11.f5306d;
        r0 = r0[r12];
        r1 = r0.hashCode();
        switch(r1) {
            case 49: goto L_0x019c;
            case 50: goto L_0x01a7;
            case 51: goto L_0x01b2;
            case 52: goto L_0x01bd;
            case 53: goto L_0x01c8;
            case 54: goto L_0x01d3;
            case 55: goto L_0x01de;
            case 56: goto L_0x01e9;
            case 57: goto L_0x01f4;
            case 1567: goto L_0x0200;
            case 1568: goto L_0x020c;
            case 1569: goto L_0x0218;
            case 1570: goto L_0x0224;
            case 1571: goto L_0x0230;
            default: goto L_0x00a4;
        };
    L_0x00a4:
        r0 = r5;
    L_0x00a5:
        switch(r0) {
            case 0: goto L_0x023c;
            case 1: goto L_0x0240;
            case 2: goto L_0x0244;
            case 3: goto L_0x0248;
            case 4: goto L_0x024c;
            case 5: goto L_0x0250;
            case 6: goto L_0x0254;
            case 7: goto L_0x0258;
            case 8: goto L_0x025c;
            case 9: goto L_0x0260;
            case 10: goto L_0x0264;
            case 11: goto L_0x0268;
            case 12: goto L_0x026c;
            case 13: goto L_0x0270;
            default: goto L_0x00a8;
        };
    L_0x00a8:
        r0 = r3;
    L_0x00a9:
        r2.setText(r0);
    L_0x00ac:
        r1 = r11.f5304b;
        r1 = r1[r12];
        r3 = "HDD";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00ca;
    L_0x00b8:
        r1 = r11.f5306d;
        r1 = r1[r12];
        r3 = r1.hashCode();
        switch(r3) {
            case 49: goto L_0x0274;
            case 50: goto L_0x027f;
            case 51: goto L_0x028a;
            case 52: goto L_0x0295;
            case 53: goto L_0x02a0;
            case 54: goto L_0x02ab;
            case 55: goto L_0x02b6;
            case 56: goto L_0x02c1;
            case 57: goto L_0x02cc;
            case 1567: goto L_0x02d8;
            default: goto L_0x00c3;
        };
    L_0x00c3:
        r1 = r5;
    L_0x00c4:
        switch(r1) {
            case 0: goto L_0x02e4;
            case 1: goto L_0x02e8;
            case 2: goto L_0x02ec;
            case 3: goto L_0x02f0;
            case 4: goto L_0x02f4;
            case 5: goto L_0x02f8;
            case 6: goto L_0x02fc;
            case 7: goto L_0x0300;
            case 8: goto L_0x0304;
            case 9: goto L_0x0308;
            default: goto L_0x00c7;
        };
    L_0x00c7:
        r2.setText(r0);
    L_0x00ca:
        r1 = r11.f5304b;
        r1 = r1[r12];
        r3 = "Internet";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00e8;
    L_0x00d6:
        r1 = r11.f5306d;
        r1 = r1[r12];
        r3 = r1.hashCode();
        switch(r3) {
            case 49: goto L_0x030c;
            case 50: goto L_0x0317;
            case 51: goto L_0x0322;
            case 52: goto L_0x032d;
            case 53: goto L_0x0338;
            case 54: goto L_0x0343;
            case 55: goto L_0x034e;
            case 56: goto L_0x0359;
            case 57: goto L_0x0364;
            case 1567: goto L_0x0370;
            default: goto L_0x00e1;
        };
    L_0x00e1:
        r1 = r5;
    L_0x00e2:
        switch(r1) {
            case 0: goto L_0x037c;
            case 1: goto L_0x0380;
            case 2: goto L_0x0384;
            case 3: goto L_0x0388;
            case 4: goto L_0x038c;
            case 5: goto L_0x0390;
            case 6: goto L_0x0394;
            case 7: goto L_0x0398;
            case 8: goto L_0x039c;
            case 9: goto L_0x03a0;
            default: goto L_0x00e5;
        };
    L_0x00e5:
        r2.setText(r0);
    L_0x00e8:
        return r9;
    L_0x00e9:
        r1 = "1";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0089;
    L_0x00f1:
        r0 = r4;
        goto L_0x008a;
    L_0x00f3:
        r1 = "2";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0089;
    L_0x00fb:
        r0 = r6;
        goto L_0x008a;
    L_0x00fd:
        r1 = "3";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0089;
    L_0x0105:
        r0 = r7;
        goto L_0x008a;
    L_0x0107:
        r1 = "4";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0089;
    L_0x010f:
        r0 = r8;
        goto L_0x008a;
    L_0x0112:
        r1 = "5";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0089;
    L_0x011a:
        r0 = 4;
        goto L_0x008a;
    L_0x011d:
        r1 = "6";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0089;
    L_0x0125:
        r0 = 5;
        goto L_0x008a;
    L_0x0128:
        r1 = "7";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0089;
    L_0x0130:
        r0 = 6;
        goto L_0x008a;
    L_0x0133:
        r1 = "8";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0089;
    L_0x013b:
        r0 = 7;
        goto L_0x008a;
    L_0x013e:
        r1 = "9";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0089;
    L_0x0146:
        r0 = 8;
        goto L_0x008a;
    L_0x014a:
        r1 = "10";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0089;
    L_0x0152:
        r0 = 9;
        goto L_0x008a;
    L_0x0156:
        r0 = "1.2 Ghz";
        r2.setText(r0);
        goto L_0x008d;
    L_0x015d:
        r0 = "1.6 Ghz";
        r2.setText(r0);
        goto L_0x008d;
    L_0x0164:
        r0 = "2.1 Ghz";
        r2.setText(r0);
        goto L_0x008d;
    L_0x016b:
        r0 = "1.6 Ghz Dualcore";
        r2.setText(r0);
        goto L_0x008d;
    L_0x0172:
        r0 = "2.1 Ghz Dualcore";
        r2.setText(r0);
        goto L_0x008d;
    L_0x0179:
        r0 = "1.8 Ghz Quadcore";
        r2.setText(r0);
        goto L_0x008d;
    L_0x0180:
        r0 = "2.4 Ghz Quadcore";
        r2.setText(r0);
        goto L_0x008d;
    L_0x0187:
        r0 = "1.8 Ghz Hexacore";
        r2.setText(r0);
        goto L_0x008d;
    L_0x018e:
        r0 = "2.2 Ghz Hexacore";
        r2.setText(r0);
        goto L_0x008d;
    L_0x0195:
        r0 = "2.8 Ghz Hexacore";
        r2.setText(r0);
        goto L_0x008d;
    L_0x019c:
        r1 = "1";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x01a4:
        r0 = r4;
        goto L_0x00a5;
    L_0x01a7:
        r1 = "2";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x01af:
        r0 = r6;
        goto L_0x00a5;
    L_0x01b2:
        r1 = "3";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x01ba:
        r0 = r7;
        goto L_0x00a5;
    L_0x01bd:
        r1 = "4";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x01c5:
        r0 = r8;
        goto L_0x00a5;
    L_0x01c8:
        r1 = "5";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x01d0:
        r0 = 4;
        goto L_0x00a5;
    L_0x01d3:
        r1 = "6";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x01db:
        r0 = 5;
        goto L_0x00a5;
    L_0x01de:
        r1 = "7";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x01e6:
        r0 = 6;
        goto L_0x00a5;
    L_0x01e9:
        r1 = "8";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x01f1:
        r0 = 7;
        goto L_0x00a5;
    L_0x01f4:
        r1 = "9";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x01fc:
        r0 = 8;
        goto L_0x00a5;
    L_0x0200:
        r1 = "10";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x0208:
        r0 = 9;
        goto L_0x00a5;
    L_0x020c:
        r1 = "11";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x0214:
        r0 = 10;
        goto L_0x00a5;
    L_0x0218:
        r1 = "12";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x0220:
        r0 = 11;
        goto L_0x00a5;
    L_0x0224:
        r1 = "13";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x022c:
        r0 = 12;
        goto L_0x00a5;
    L_0x0230:
        r1 = "14";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x0238:
        r0 = 13;
        goto L_0x00a5;
    L_0x023c:
        r0 = "256MB DDR1 333mhz";
        goto L_0x00a9;
    L_0x0240:
        r0 = "512MB DDR1 333mhz";
        goto L_0x00a9;
    L_0x0244:
        r0 = "1GB DDR1 333mhz";
        goto L_0x00a9;
    L_0x0248:
        r0 = "2GB DDR1 333mhz";
        goto L_0x00a9;
    L_0x024c:
        r0 = "512MB DDR2 666mhz";
        goto L_0x00a9;
    L_0x0250:
        r0 = "1GB DDR2 666mhz";
        goto L_0x00a9;
    L_0x0254:
        r0 = "2GB DDR2 666mhz";
        goto L_0x00a9;
    L_0x0258:
        r0 = "4GB DDR2 666mhz";
        goto L_0x00a9;
    L_0x025c:
        r0 = "8GB DDR2 666mhz";
        goto L_0x00a9;
    L_0x0260:
        r0 = "2GB DDR3 1066mhz";
        goto L_0x00a9;
    L_0x0264:
        r0 = "4GB DDR3 1066mhz";
        goto L_0x00a9;
    L_0x0268:
        r0 = "8GB DDR3 1066mhz";
        goto L_0x00a9;
    L_0x026c:
        r0 = "16GB DDR3 1066mhz";
        goto L_0x00a9;
    L_0x0270:
        r0 = "32GB DDR3 1066mhz";
        goto L_0x00a9;
    L_0x0274:
        r3 = "1";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00c3;
    L_0x027c:
        r1 = r4;
        goto L_0x00c4;
    L_0x027f:
        r3 = "2";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00c3;
    L_0x0287:
        r1 = r6;
        goto L_0x00c4;
    L_0x028a:
        r3 = "3";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00c3;
    L_0x0292:
        r1 = r7;
        goto L_0x00c4;
    L_0x0295:
        r3 = "4";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00c3;
    L_0x029d:
        r1 = r8;
        goto L_0x00c4;
    L_0x02a0:
        r3 = "5";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00c3;
    L_0x02a8:
        r1 = 4;
        goto L_0x00c4;
    L_0x02ab:
        r3 = "6";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00c3;
    L_0x02b3:
        r1 = 5;
        goto L_0x00c4;
    L_0x02b6:
        r3 = "7";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00c3;
    L_0x02be:
        r1 = 6;
        goto L_0x00c4;
    L_0x02c1:
        r3 = "8";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00c3;
    L_0x02c9:
        r1 = 7;
        goto L_0x00c4;
    L_0x02cc:
        r3 = "9";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00c3;
    L_0x02d4:
        r1 = 8;
        goto L_0x00c4;
    L_0x02d8:
        r3 = "10";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00c3;
    L_0x02e0:
        r1 = 9;
        goto L_0x00c4;
    L_0x02e4:
        r0 = "60GB";
        goto L_0x00c7;
    L_0x02e8:
        r0 = "120GB";
        goto L_0x00c7;
    L_0x02ec:
        r0 = "240GB";
        goto L_0x00c7;
    L_0x02f0:
        r0 = "320GB";
        goto L_0x00c7;
    L_0x02f4:
        r0 = "500GB";
        goto L_0x00c7;
    L_0x02f8:
        r0 = "1TB";
        goto L_0x00c7;
    L_0x02fc:
        r0 = "2TB";
        goto L_0x00c7;
    L_0x0300:
        r0 = "4TB";
        goto L_0x00c7;
    L_0x0304:
        r0 = "8TB";
        goto L_0x00c7;
    L_0x0308:
        r0 = "16TB";
        goto L_0x00c7;
    L_0x030c:
        r3 = "1";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00e1;
    L_0x0314:
        r1 = r4;
        goto L_0x00e2;
    L_0x0317:
        r3 = "2";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00e1;
    L_0x031f:
        r1 = r6;
        goto L_0x00e2;
    L_0x0322:
        r3 = "3";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00e1;
    L_0x032a:
        r1 = r7;
        goto L_0x00e2;
    L_0x032d:
        r3 = "4";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00e1;
    L_0x0335:
        r1 = r8;
        goto L_0x00e2;
    L_0x0338:
        r3 = "5";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00e1;
    L_0x0340:
        r1 = 4;
        goto L_0x00e2;
    L_0x0343:
        r3 = "6";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00e1;
    L_0x034b:
        r1 = 5;
        goto L_0x00e2;
    L_0x034e:
        r3 = "7";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00e1;
    L_0x0356:
        r1 = 6;
        goto L_0x00e2;
    L_0x0359:
        r3 = "8";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00e1;
    L_0x0361:
        r1 = 7;
        goto L_0x00e2;
    L_0x0364:
        r3 = "9";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00e1;
    L_0x036c:
        r1 = 8;
        goto L_0x00e2;
    L_0x0370:
        r3 = "10";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00e1;
    L_0x0378:
        r1 = 9;
        goto L_0x00e2;
    L_0x037c:
        r0 = "DSL 1.000";
        goto L_0x00e5;
    L_0x0380:
        r0 = "DSL 2.000";
        goto L_0x00e5;
    L_0x0384:
        r0 = "DSL 6.000";
        goto L_0x00e5;
    L_0x0388:
        r0 = "DSL 16.000";
        goto L_0x00e5;
    L_0x038c:
        r0 = "vDSL 50.000";
        goto L_0x00e5;
    L_0x0390:
        r0 = "vDSL 100.000";
        goto L_0x00e5;
    L_0x0394:
        r0 = "vDSL 200.000";
        goto L_0x00e5;
    L_0x0398:
        r0 = "0.5 Gbit";
        goto L_0x00e5;
    L_0x039c:
        r0 = "1.0 Gbit";
        goto L_0x00e5;
    L_0x03a0:
        r0 = "1.5 Gbit";
        goto L_0x00e5;
    L_0x03a4:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Level: ";
        r0 = r0.append(r1);
        r1 = r11.f5306d;
        r1 = r1[r12];
        r0 = r0.append(r1);
        r0 = r0.toString();
        r2.setText(r0);
        goto L_0x00e8;
    L_0x03c0:
        r0 = r3;
        goto L_0x00ac;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.vhack.dev.vhack.bn.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
