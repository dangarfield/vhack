package org.vhack.dev.vhack;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: LogListAdapter */
public class ce extends ArrayAdapter {
    private static SharedPreferences j;
    private final Activity a;
    private final String[] b;
    private final String[] c;
    private final String[] d;
    private final String[] e;
    private final Integer[] f;
    private final String[] g;
    private final String[] h;
    private final String[] i;

    public ce(Activity activity, String[] strArr, String[] strArr2, Integer[] numArr, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        super(activity, 2130968641, strArr3);
        this.a = activity;
        this.b = strArr;
        this.c = strArr2;
        this.d = strArr3;
        this.e = strArr4;
        this.f = numArr;
        this.g = strArr5;
        this.h = strArr6;
        this.i = strArr7;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.a.getLayoutInflater().inflate(2130968641, null, true);
        j = this.a.getSharedPreferences("loginData.xml", 0);
        String string = j.getString("id", "");
        TextView textView = (TextView) inflate.findViewById(2131558989);
        TextView textView2 = (TextView) inflate.findViewById(2131558991);
        TextView textView3 = (TextView) inflate.findViewById(2131558993);
        TextView textView4 = (TextView) inflate.findViewById(2131558996);
        TextView textView5 = (TextView) inflate.findViewById(2131558994);
        TextView textView6 = (TextView) inflate.findViewById(2131558997);
        CharSequence charSequence = "TRANSFER";
        if (this.f[i].intValue() > 100000) {
            charSequence = a((long) this.f[i].intValue()) + " TRANSFER";
        }
        if (this.b[i].equals("1")) {
            if (this.h[i].equals(string)) {
                textView5.setText("SUCCESS");
                textView6.setTextColor(-16711936);
                textView6.setText("$" + a(this.i[i]));
                textView4.setTextColor(-16711936);
                textView4.setText("+" + this.c[i]);
                textView2.setText(this.d[i]);
                textView3.setText("YOU");
            } else {
                textView5.setText("LOSS");
                textView6.setTextColor(-65536);
                textView6.setText("-$" + a(this.i[i]));
                textView4.setTextColor(-65536);
                textView4.setText("-" + this.c[i]);
                textView2.setText("YOU");
                textView3.setText(this.e[i]);
            }
        } else if (this.h[i].equals(string)) {
            textView5.setText("FAILED");
            textView6.setTextColor(-65536);
            textView6.setText("-");
            textView4.setTextColor(-65536);
            textView4.setText("-" + this.c[i]);
            textView2.setText(this.d[i]);
            textView3.setText("YOU");
        } else {
            textView5.setText("BLOCKED");
            textView6.setTextColor(-16711936);
            textView6.setText("-");
            textView4.setTextColor(-16711936);
            textView4.setText("+" + this.c[i]);
            textView2.setText("YOU");
            textView3.setText(this.e[i]);
        }
        textView.setText(charSequence);
        return inflate;
    }

    public String a(String str) {
        return String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(str))}).replace(",", ".");
    }

    public String a(long j) {
        try {
            Calendar instance = Calendar.getInstance();
            TimeZone timeZone = TimeZone.getDefault();
            instance.setTimeInMillis(1000 * j);
            instance.add(14, timeZone.getOffset(instance.getTimeInMillis()));
            return new SimpleDateFormat("[dd-MM HH:mm]").format(instance.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
