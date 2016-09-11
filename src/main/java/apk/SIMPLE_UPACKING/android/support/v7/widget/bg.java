package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.p002h.bu;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.widget.RatingBar;

/* compiled from: AppCompatRatingBar */
public class bg extends RatingBar {
    private be f1930a;
    private ar f1931b;

    public bg(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.ratingBarStyle);
    }

    public bg(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1931b = ar.m3972a();
        this.f1930a = new be(this, this.f1931b);
        this.f1930a.m4015a(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a = this.f1930a.m4014a();
        if (a != null) {
            setMeasuredDimension(bu.m1920a(a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
