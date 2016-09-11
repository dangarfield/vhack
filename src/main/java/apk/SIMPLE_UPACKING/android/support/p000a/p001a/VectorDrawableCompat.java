package android.support.p000a.p001a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Region.Op;
import android.support.v4.p014g.ArrayMap;

/* renamed from: android.support.a.a.r */
class VectorDrawableCompat {
    private static final Matrix f60j;
    float f61a;
    float f62b;
    float f63c;
    float f64d;
    int f65e;
    String f66f;
    final ArrayMap f67g;
    private final Path f68h;
    private final Path f69i;
    private final Matrix f70k;
    private Paint f71l;
    private Paint f72m;
    private PathMeasure f73n;
    private int f74o;
    private final VectorDrawableCompat f75p;

    static {
        f60j = new Matrix();
    }

    public VectorDrawableCompat() {
        this.f70k = new Matrix();
        this.f61a = 0.0f;
        this.f62b = 0.0f;
        this.f63c = 0.0f;
        this.f64d = 0.0f;
        this.f65e = 255;
        this.f66f = null;
        this.f67g = new ArrayMap();
        this.f75p = new VectorDrawableCompat();
        this.f68h = new Path();
        this.f69i = new Path();
    }

    public void m63a(int i) {
        this.f65e = i;
    }

    public int m61a() {
        return this.f65e;
    }

    public void m62a(float f) {
        m63a((int) (255.0f * f));
    }

    public float m65b() {
        return ((float) m61a()) / 255.0f;
    }

    public VectorDrawableCompat(VectorDrawableCompat vectorDrawableCompat) {
        this.f70k = new Matrix();
        this.f61a = 0.0f;
        this.f62b = 0.0f;
        this.f63c = 0.0f;
        this.f64d = 0.0f;
        this.f65e = 255;
        this.f66f = null;
        this.f67g = new ArrayMap();
        this.f75p = new VectorDrawableCompat(vectorDrawableCompat.f75p, this.f67g);
        this.f68h = new Path(vectorDrawableCompat.f68h);
        this.f69i = new Path(vectorDrawableCompat.f69i);
        this.f61a = vectorDrawableCompat.f61a;
        this.f62b = vectorDrawableCompat.f62b;
        this.f63c = vectorDrawableCompat.f63c;
        this.f64d = vectorDrawableCompat.f64d;
        this.f74o = vectorDrawableCompat.f74o;
        this.f65e = vectorDrawableCompat.f65e;
        this.f66f = vectorDrawableCompat.f66f;
        if (vectorDrawableCompat.f66f != null) {
            this.f67g.put(vectorDrawableCompat.f66f, this);
        }
    }

    private void m56a(VectorDrawableCompat vectorDrawableCompat, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        vectorDrawableCompat.f48b.set(matrix);
        vectorDrawableCompat.f48b.preConcat(vectorDrawableCompat.f56j);
        for (int i3 = 0; i3 < vectorDrawableCompat.f47a.size(); i3++) {
            Object obj = vectorDrawableCompat.f47a.get(i3);
            if (obj instanceof VectorDrawableCompat) {
                m56a((VectorDrawableCompat) obj, vectorDrawableCompat.f48b, canvas, i, i2, colorFilter);
            } else if (obj instanceof VectorDrawableCompat) {
                m57a(vectorDrawableCompat, (VectorDrawableCompat) obj, canvas, i, i2, colorFilter);
            }
        }
    }

    public void m64a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        m56a(this.f75p, f60j, canvas, i, i2, colorFilter);
    }

    private void m57a(VectorDrawableCompat vectorDrawableCompat, VectorDrawableCompat vectorDrawableCompat2, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        float f = ((float) i) / this.f63c;
        float f2 = ((float) i2) / this.f64d;
        float min = Math.min(f, f2);
        Matrix b = vectorDrawableCompat.f48b;
        this.f70k.set(b);
        this.f70k.postScale(f, f2);
        f = m53a(b);
        if (f != 0.0f) {
            vectorDrawableCompat2.m35a(this.f68h);
            Path path = this.f68h;
            this.f69i.reset();
            if (vectorDrawableCompat2.m36a()) {
                this.f69i.addPath(path, this.f70k);
                canvas.clipPath(this.f69i, Op.REPLACE);
                return;
            }
            Paint paint;
            VectorDrawableCompat vectorDrawableCompat3 = (VectorDrawableCompat) vectorDrawableCompat2;
            if (!(vectorDrawableCompat3.f40g == 0.0f && vectorDrawableCompat3.f41h == 1.0f)) {
                float f3 = (vectorDrawableCompat3.f40g + vectorDrawableCompat3.f42i) % 1.0f;
                float f4 = (vectorDrawableCompat3.f41h + vectorDrawableCompat3.f42i) % 1.0f;
                if (this.f73n == null) {
                    this.f73n = new PathMeasure();
                }
                this.f73n.setPath(this.f68h, false);
                float length = this.f73n.getLength();
                f3 *= length;
                f4 *= length;
                path.reset();
                if (f3 > f4) {
                    this.f73n.getSegment(f3, length, path, true);
                    this.f73n.getSegment(0.0f, f4, path, true);
                } else {
                    this.f73n.getSegment(f3, f4, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f69i.addPath(path, this.f70k);
            if (vectorDrawableCompat3.f36c != 0) {
                if (this.f72m == null) {
                    this.f72m = new Paint();
                    this.f72m.setStyle(Style.FILL);
                    this.f72m.setAntiAlias(true);
                }
                paint = this.f72m;
                paint.setColor(VectorDrawableCompat.m30b(vectorDrawableCompat3.f36c, vectorDrawableCompat3.f39f));
                paint.setColorFilter(colorFilter);
                canvas.drawPath(this.f69i, paint);
            }
            if (vectorDrawableCompat3.f34a != 0) {
                if (this.f71l == null) {
                    this.f71l = new Paint();
                    this.f71l.setStyle(Style.STROKE);
                    this.f71l.setAntiAlias(true);
                }
                paint = this.f71l;
                if (vectorDrawableCompat3.f44k != null) {
                    paint.setStrokeJoin(vectorDrawableCompat3.f44k);
                }
                if (vectorDrawableCompat3.f43j != null) {
                    paint.setStrokeCap(vectorDrawableCompat3.f43j);
                }
                paint.setStrokeMiter(vectorDrawableCompat3.f45l);
                paint.setColor(VectorDrawableCompat.m30b(vectorDrawableCompat3.f34a, vectorDrawableCompat3.f37d));
                paint.setColorFilter(colorFilter);
                paint.setStrokeWidth((f * min) * vectorDrawableCompat3.f35b);
                canvas.drawPath(this.f69i, paint);
            }
        }
    }

    private static float m52a(float f, float f2, float f3, float f4) {
        return (f * f4) - (f2 * f3);
    }

    private float m53a(Matrix matrix) {
        float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
        matrix.mapVectors(fArr);
        float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
        float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
        float a = VectorDrawableCompat.m52a(fArr[0], fArr[1], fArr[2], fArr[3]);
        hypot = Math.max(hypot, hypot2);
        if (hypot > 0.0f) {
            return Math.abs(a) / hypot;
        }
        return 0.0f;
    }
}
