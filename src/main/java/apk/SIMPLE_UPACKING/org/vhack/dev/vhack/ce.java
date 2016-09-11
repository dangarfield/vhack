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
    private static SharedPreferences f5327j;
    private final Activity f5328a;
    private final String[] f5329b;
    private final String[] f5330c;
    private final String[] f5331d;
    private final String[] f5332e;
    private final Integer[] f5333f;
    private final String[] f5334g;
    private final String[] f5335h;
    private final String[] f5336i;

    public ce(Activity activity, String[] strArr, String[] strArr2, Integer[] numArr, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        super(activity, 2130968641, strArr3);
        this.f5328a = activity;
        this.f5329b = strArr;
        this.f5330c = strArr2;
        this.f5331d = strArr3;
        this.f5332e = strArr4;
        this.f5333f = numArr;
        this.f5334g = strArr5;
        this.f5335h = strArr6;
        this.f5336i = strArr7;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.f5328a.getLayoutInflater().inflate(2130968641, null, true);
        f5327j = this.f5328a.getSharedPreferences("loginData.xml", 0);
        String string = f5327j.getString("id", "");
        TextView textView = (TextView) inflate.findViewById(2131558989);
        TextView textView2 = (TextView) inflate.findViewById(2131558991);
        TextView textView3 = (TextView) inflate.findViewById(2131558993);
        TextView textView4 = (TextView) inflate.findViewById(2131558996);
        TextView textView5 = (TextView) inflate.findViewById(2131558994);
        TextView textView6 = (TextView) inflate.findViewById(2131558997);
        CharSequence charSequence = "TRANSFER";
        if (this.f5333f[i].intValue() > 100000) {
            charSequence = m9131a((long) this.f5333f[i].intValue()) + " TRANSFER";
        }
        if (this.f5329b[i].equals("1")) {
            if (this.f5335h[i].equals(string)) {
                textView5.setText("SUCCESS");
                textView6.setTextColor(-16711936);
                textView6.setText("$" + m9132a(this.f5336i[i]));
                textView4.setTextColor(-16711936);
                textView4.setText("+" + this.f5330c[i]);
                textView2.setText(this.f5331d[i]);
                textView3.setText("YOU");
            } else {
                textView5.setText("LOSS");
                textView6.setTextColor(-65536);
                textView6.setText("-$" + m9132a(this.f5336i[i]));
                textView4.setTextColor(-65536);
                textView4.setText("-" + this.f5330c[i]);
                textView2.setText("YOU");
                textView3.setText(this.f5332e[i]);
            }
        } else if (this.f5335h[i].equals(string)) {
            textView5.setText("FAILED");
            textView6.setTextColor(-65536);
            textView6.setText("-");
            textView4.setTextColor(-65536);
            textView4.setText("-" + this.f5330c[i]);
            textView2.setText(this.f5331d[i]);
            textView3.setText("YOU");
        } else {
            textView5.setText("BLOCKED");
            textView6.setTextColor(-16711936);
            textView6.setText("-");
            textView4.setTextColor(-16711936);
            textView4.setText("+" + this.f5330c[i]);
            textView2.setText("YOU");
            textView3.setText(this.f5332e[i]);
        }
        textView.setText(charSequence);
        return inflate;
    }

    public String m9132a(String str) {
        return String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(str))}).replace(",", ".");
    }

    public String m9131a(long j) {
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
