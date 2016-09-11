package org.vhack.dev.vhack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/* compiled from: ClusterMemberAdapter */
public class bg extends ArrayAdapter {
    private final Activity f5293a;
    private final String[] f5294b;
    private final String[] f5295c;
    private final String[] f5296d;

    public bg(Activity activity, String[] strArr, String[] strArr2, String[] strArr3) {
        super(activity, 2130968627, strArr);
        this.f5293a = activity;
        this.f5294b = strArr;
        this.f5295c = strArr2;
        this.f5296d = strArr3;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.f5293a.getLayoutInflater().inflate(2130968627, null, true);
        TextView textView = (TextView) inflate.findViewById(2131558976);
        TextView textView2 = (TextView) inflate.findViewById(2131558975);
        ((TextView) inflate.findViewById(2131558974)).setText(this.f5294b[i]);
        textView.setText("Rep.: " + m9092a(this.f5296d[i]));
        textView2.setText("Score: " + m9092a(this.f5295c[i]));
        return inflate;
    }

    public String m9092a(String str) {
        return String.format("%,d", new Object[]{Integer.valueOf(Integer.parseInt(str))}).replace(",", ".");
    }
}
