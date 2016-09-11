package org.vhack.dev.vhack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: MailListAdapter */
public class cf extends ArrayAdapter {
    private final Activity f5337a;
    private final String[] f5338b;
    private final String[] f5339c;
    private final String[] f5340d;

    public cf(Activity activity, String[] strArr, String[] strArr2, String[] strArr3) {
        super(activity, 2130968642, strArr);
        this.f5337a = activity;
        this.f5338b = strArr;
        this.f5339c = strArr2;
        this.f5340d = strArr3;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.f5337a.getLayoutInflater().inflate(2130968642, null, true);
        ImageView imageView = (ImageView) inflate.findViewById(2131558998);
        TextView textView = (TextView) inflate.findViewById(2131559000);
        ((TextView) inflate.findViewById(2131558999)).setText(this.f5338b[i]);
        if (Integer.parseInt(this.f5340d[i]) == 0) {
            imageView.setImageResource(2130837713);
        } else {
            imageView.setImageResource(2130837714);
        }
        textView.setText(this.f5337a.getString(2131165351) + " " + this.f5339c[i]);
        return inflate;
    }
}
