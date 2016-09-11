package org.vhack.dev.vhack;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ShopListAdapter */
public class fd extends ArrayAdapter {
    private final Activity a;
    private final String[] b;
    private final String[] c;
    private final String[] d;
    private final Integer[] e;

    public fd(Activity activity, String[] strArr, String[] strArr2, Integer[] numArr, String[] strArr3) {
        super(activity, 2130968664, strArr);
        this.a = activity;
        this.b = strArr;
        this.c = strArr2;
        this.d = strArr3;
        this.e = numArr;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.a.getLayoutInflater().inflate(2130968664, null, true);
        TextView textView = (TextView) inflate.findViewById(2131558989);
        ImageView imageView = (ImageView) inflate.findViewById(2131559044);
        TextView textView2 = (TextView) inflate.findViewById(2131559045);
        TextView textView3 = (TextView) inflate.findViewById(2131559046);
        Typeface createFromAsset = Typeface.createFromAsset(this.a.getAssets(), "fonts/HACKED.ttf");
        textView3.setTypeface(createFromAsset);
        textView.setTypeface(createFromAsset);
        textView2.setTypeface(createFromAsset);
        textView.setText(this.b[i]);
        textView2.setText(this.c[i]);
        textView3.setText(this.d[i]);
        imageView.setImageResource(this.e[i].intValue());
        return inflate;
    }
}
