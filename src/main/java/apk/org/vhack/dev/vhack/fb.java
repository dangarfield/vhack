package org.vhack.dev.vhack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: RankingListAdapter */
public class fb extends ArrayAdapter {
    private final Activity a;
    private final String[] b;
    private final String[] c;
    private final String[] d;
    private final String[] e;

    public fb(Activity activity, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        super(activity, 2130968660, strArr);
        this.a = activity;
        this.b = strArr;
        this.c = strArr2;
        this.d = strArr3;
        this.e = strArr4;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.a.getLayoutInflater().inflate(2130968660, null, true);
        TextView textView = (TextView) inflate.findViewById(2131559040);
        TextView textView2 = (TextView) inflate.findViewById(2131559042);
        TextView textView3 = (TextView) inflate.findViewById(2131559041);
        ImageView imageView = (ImageView) inflate.findViewById(2131559043);
        TextView textView4 = (TextView) inflate.findViewById(2131559038);
        ((TextView) inflate.findViewById(2131559039)).setText(this.b[i]);
        textView2.setText("Rep.: " + a(this.d[i]));
        textView3.setText("Score: " + a(this.c[i]));
        textView4.setText((i + 1) + ".");
        if (this.e != null) {
            if (this.e[i].equals("1")) {
                imageView.setBackground(this.a.getResources().getDrawable(2130837608));
            }
            if (this.e[i].equals("2")) {
                imageView.setBackground(this.a.getResources().getDrawable(2130837769));
            }
            if (this.e[i].equals("3")) {
                imageView.setBackground(this.a.getResources().getDrawable(2130837675));
            }
        }
        textView.setText("Overall: " + a((Integer.parseInt(this.c[i]) + Integer.parseInt(this.d[i])) + ""));
        return inflate;
    }

    public String a(String str) {
        return String.format("%,d", new Object[]{Integer.valueOf(Integer.parseInt(str))}).replace(",", ".");
    }
}
