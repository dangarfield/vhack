package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* compiled from: AppCompatSeekBarHelper */
class bi extends be {
    private static final int[] f1934b;
    private final SeekBar f1935c;

    static {
        f1934b = new int[]{16843074};
    }

    bi(SeekBar seekBar, ar arVar) {
        super(seekBar, arVar);
        this.f1935c = seekBar;
    }

    void m4016a(AttributeSet attributeSet, int i) {
        super.m4015a(attributeSet, i);
        gb a = gb.m4646a(this.f1935c.getContext(), attributeSet, f1934b, i, 0);
        Drawable b = a.m4653b(0);
        if (b != null) {
            this.f1935c.setThumb(b);
        }
        a.m4650a();
    }
}
