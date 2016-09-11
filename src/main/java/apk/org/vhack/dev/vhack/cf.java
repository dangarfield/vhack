package org.vhack.dev.vhack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: MailListAdapter */
public class cf extends ArrayAdapter {
    private final Activity a;
    private final String[] b;
    private final String[] c;
    private final String[] d;

    public cf(Activity activity, String[] strArr, String[] strArr2, String[] strArr3) {
        super(activity, 2130968642, strArr);
        this.a = activity;
        this.b = strArr;
        this.c = strArr2;
        this.d = strArr3;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.a.getLayoutInflater().inflate(2130968642, null, true);
        ImageView imageView = (ImageView) inflate.findViewById(2131558998);
        TextView textView = (TextView) inflate.findViewById(2131559000);
        ((TextView) inflate.findViewById(2131558999)).setText(this.b[i]);
        if (Integer.parseInt(this.d[i]) == 0) {
            imageView.setImageResource(2130837713);
        } else {
            imageView.setImageResource(2130837714);
        }
        textView.setText(this.a.getString(2131165351) + " " + this.c[i]);
        return inflate;
    }
}
