package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.p009c.p010a.DrawableWrapper;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* compiled from: AppCompatProgressBarHelper */
class be {
    private static final int[] f1924b;
    final ar f1925a;
    private final ProgressBar f1926c;
    private Bitmap f1927d;

    static {
        f1924b = new int[]{16843067, 16843068};
    }

    be(ProgressBar progressBar, ar arVar) {
        this.f1926c = progressBar;
        this.f1925a = arVar;
    }

    void m4015a(AttributeSet attributeSet, int i) {
        gb a = gb.m4646a(this.f1926c.getContext(), attributeSet, f1924b, i, 0);
        Drawable b = a.m4653b(0);
        if (b != null) {
            this.f1926c.setIndeterminateDrawable(m4011a(b));
        }
        b = a.m4653b(1);
        if (b != null) {
            this.f1926c.setProgressDrawable(m4012a(b, false));
        }
        a.m4650a();
    }

    private Drawable m4012a(Drawable drawable, boolean z) {
        int i = 0;
        Drawable a;
        if (drawable instanceof DrawableWrapper) {
            a = ((DrawableWrapper) drawable).m1321a();
            if (a != null) {
                ((DrawableWrapper) drawable).m1325a(m4012a(a, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                boolean z2;
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                if (id == 16908301 || id == 16908303) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawableArr[i2] = m4012a(drawable2, z2);
            }
            a = new LayerDrawable(drawableArr);
            while (i < numberOfLayers) {
                a.setId(i, layerDrawable.getId(i));
                i++;
            }
            return a;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f1927d == null) {
                this.f1927d = bitmap;
            }
            Drawable shapeDrawable = new ShapeDrawable(m4013b());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    private Drawable m4011a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        Drawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable a = m4012a(animationDrawable.getFrame(i), true);
            a.setLevel(10000);
            animationDrawable2.addFrame(a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    private Shape m4013b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    Bitmap m4014a() {
        return this.f1927d;
    }
}
