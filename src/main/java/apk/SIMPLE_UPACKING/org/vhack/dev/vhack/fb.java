package org.vhack.dev.vhack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: RankingListAdapter */
public class fb extends ArrayAdapter {
    private final Activity f5432a;
    private final String[] f5433b;
    private final String[] f5434c;
    private final String[] f5435d;
    private final String[] f5436e;

    public fb(Activity activity, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        super(activity, 2130968660, strArr);
        this.f5432a = activity;
        this.f5433b = strArr;
        this.f5434c = strArr2;
        this.f5435d = strArr3;
        this.f5436e = strArr4;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.f5432a.getLayoutInflater().inflate(2130968660, null, true);
        TextView textView = (TextView) inflate.findViewById(2131559040);
        TextView textView2 = (TextView) inflate.findViewById(2131559042);
        TextView textView3 = (TextView) inflate.findViewById(2131559041);
        ImageView imageView = (ImageView) inflate.findViewById(2131559043);
        TextView textView4 = (TextView) inflate.findViewById(2131559038);
        ((TextView) inflate.findViewById(2131559039)).setText(this.f5433b[i]);
        textView2.setText("Rep.: " + m9163a(this.f5435d[i]));
        textView3.setText("Score: " + m9163a(this.f5434c[i]));
        textView4.setText((i + 1) + ".");
        if (this.f5436e != null) {
            if (this.f5436e[i].equals("1")) {
                imageView.setBackground(this.f5432a.getResources().getDrawable(2130837608));
            }
            if (this.f5436e[i].equals("2")) {
                imageView.setBackground(this.f5432a.getResources().getDrawable(2130837769));
            }
            if (this.f5436e[i].equals("3")) {
                imageView.setBackground(this.f5432a.getResources().getDrawable(2130837675));
            }
        }
        textView.setText("Overall: " + m9163a((Integer.parseInt(this.f5434c[i]) + Integer.parseInt(this.f5435d[i])) + ""));
        return inflate;
    }

    public String m9163a(String str) {
        return String.format("%,d", new Object[]{Integer.valueOf(Integer.parseInt(str))}).replace(",", ".");
    }
}
