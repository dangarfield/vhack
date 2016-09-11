package org.vhack.dev.vhack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/* renamed from: org.vhack.dev.vhack.k */
public class AdWareListAdapter extends ArrayAdapter {
    private final Activity f5473a;
    private final String[] f5474b;
    private final String[] f5475c;
    private final String[] f5476d;
    private final String[] f5477e;

    public AdWareListAdapter(Activity activity, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        super(activity, 2130968624, strArr);
        this.f5473a = activity;
        this.f5474b = strArr;
        this.f5475c = strArr2;
        this.f5476d = strArr3;
        this.f5477e = strArr4;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.f5473a.getLayoutInflater().inflate(2130968624, null, true);
        TextView textView = (TextView) inflate.findViewById(2131558962);
        TextView textView2 = (TextView) inflate.findViewById(2131558963);
        TextView textView3 = (TextView) inflate.findViewById(2131558964);
        ((TextView) inflate.findViewById(2131558961)).setText(this.f5474b[i]);
        textView.setText(this.f5475c[i]);
        textView2.setText(this.f5477e[i]);
        textView3.setText(m9184a(this.f5476d[i]));
        return inflate;
    }

    public String m9184a(String str) {
        return String.format("%,d", new Object[]{Integer.valueOf(Integer.parseInt(str))}).replace(",", ".");
    }
}
