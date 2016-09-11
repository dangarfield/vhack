package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* compiled from: AppCompatSeekBar */
public class bh extends SeekBar {
    private bi f1932a;
    private ar f1933b;

    public bh(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.seekBarStyle);
    }

    public bh(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1933b = ar.m3972a();
        this.f1932a = new bi(this, this.f1933b);
        this.f1932a.m4016a(attributeSet, i);
    }
}
