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
    private final Activity f5442a;
    private final String[] f5443b;
    private final String[] f5444c;
    private final String[] f5445d;
    private final Integer[] f5446e;

    public fd(Activity activity, String[] strArr, String[] strArr2, Integer[] numArr, String[] strArr3) {
        super(activity, 2130968664, strArr);
        this.f5442a = activity;
        this.f5443b = strArr;
        this.f5444c = strArr2;
        this.f5445d = strArr3;
        this.f5446e = numArr;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.f5442a.getLayoutInflater().inflate(2130968664, null, true);
        TextView textView = (TextView) inflate.findViewById(2131558989);
        ImageView imageView = (ImageView) inflate.findViewById(2131559044);
        TextView textView2 = (TextView) inflate.findViewById(2131559045);
        TextView textView3 = (TextView) inflate.findViewById(2131559046);
        Typeface createFromAsset = Typeface.createFromAsset(this.f5442a.getAssets(), "fonts/HACKED.ttf");
        textView3.setTypeface(createFromAsset);
        textView.setTypeface(createFromAsset);
        textView2.setTypeface(createFromAsset);
        textView.setText(this.f5443b[i]);
        textView2.setText(this.f5444c[i]);
        textView3.setText(this.f5445d[i]);
        imageView.setImageResource(this.f5446e[i].intValue());
        return inflate;
    }
}
