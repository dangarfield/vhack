package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.p007b.ContextCompat;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: AppCompatImageHelper */
public class az {
    private final ImageView f1908a;
    private final ar f1909b;

    public az(ImageView imageView, ar arVar) {
        this.f1908a = imageView;
        this.f1909b = arVar;
    }

    public void m4004a(AttributeSet attributeSet, int i) {
        gb a = gb.m4646a(this.f1908a.getContext(), attributeSet, R.AppCompatImageView, i, 0);
        try {
            Drawable b = a.m4653b(R.AppCompatImageView_android_src);
            if (b != null) {
                this.f1908a.setImageDrawable(b);
            }
            int g = a.m4662g(R.AppCompatImageView_srcCompat, -1);
            if (g != -1) {
                b = this.f1909b.m3993a(this.f1908a.getContext(), g);
                if (b != null) {
                    this.f1908a.setImageDrawable(b);
                }
            }
            b = this.f1908a.getDrawable();
            if (b != null) {
                cl.m4238a(b);
            }
            a.m4650a();
        } catch (Throwable th) {
            a.m4650a();
        }
    }

    public void m4003a(int i) {
        if (i != 0) {
            Drawable a = this.f1909b != null ? this.f1909b.m3993a(this.f1908a.getContext(), i) : ContextCompat.m741a(this.f1908a.getContext(), i);
            if (a != null) {
                cl.m4238a(a);
            }
            this.f1908a.setImageDrawable(a);
            return;
        }
        this.f1908a.setImageDrawable(null);
    }
}
