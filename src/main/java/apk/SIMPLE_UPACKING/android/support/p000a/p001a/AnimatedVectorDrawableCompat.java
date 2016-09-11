package android.support.p000a.p001a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.p009c.p010a.DrawableCompat;
import android.support.v4.p014g.ArrayMap;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
/* renamed from: android.support.a.a.b */
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable {
    private AnimatedVectorDrawableCompat f7b;
    private Context f8c;
    private ArgbEvaluator f9d;
    private final Callback f10e;

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context) {
        this(context, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context, AnimatedVectorDrawableCompat animatedVectorDrawableCompat, Resources resources) {
        this.f9d = null;
        this.f10e = new AnimatedVectorDrawableCompat(this);
        this.f8c = context;
        if (animatedVectorDrawableCompat != null) {
            this.f7b = animatedVectorDrawableCompat;
        } else {
            this.f7b = new AnimatedVectorDrawableCompat(context, animatedVectorDrawableCompat, this.f10e, resources);
        }
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    public static AnimatedVectorDrawableCompat m3a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    public ConstantState getConstantState() {
        if (this.a != null) {
            return new AnimatedVectorDrawableCompat(this.a.getConstantState());
        }
        return null;
    }

    public int getChangingConfigurations() {
        if (this.a != null) {
            return this.a.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f7b.f12a;
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        this.f7b.f13b.draw(canvas);
        if (m6a()) {
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        } else {
            this.f7b.f13b.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        return this.f7b.f13b.setState(iArr);
    }

    protected boolean onLevelChange(int i) {
        if (this.a != null) {
            return this.a.setLevel(i);
        }
        return this.f7b.f13b.setLevel(i);
    }

    public int getAlpha() {
        if (this.a != null) {
            return DrawableCompat.m1316c(this.a);
        }
        return this.f7b.f13b.getAlpha();
    }

    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else {
            this.f7b.f13b.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
        } else {
            this.f7b.f13b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i) {
        if (this.a != null) {
            DrawableCompat.m1307a(this.a, i);
        } else {
            this.f7b.f13b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            DrawableCompat.m1309a(this.a, colorStateList);
        } else {
            this.f7b.f13b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.a != null) {
            DrawableCompat.m1312a(this.a, mode);
        } else {
            this.f7b.f13b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.a != null) {
            return this.a.setVisible(z, z2);
        }
        this.f7b.f13b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public boolean isStateful() {
        if (this.a != null) {
            return this.a.isStateful();
        }
        return this.f7b.f13b.isStateful();
    }

    public int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return this.f7b.f13b.getOpacity();
    }

    public int getIntrinsicWidth() {
        if (this.a != null) {
            return this.a.getIntrinsicWidth();
        }
        return this.f7b.f13b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.a != null) {
            return this.a.getIntrinsicHeight();
        }
        return this.f7b.f13b.getIntrinsicHeight();
    }

    static TypedArray m1a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.a != null) {
            DrawableCompat.m1311a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray a;
                if ("animated-vector".equals(name)) {
                    a = AnimatedVectorDrawableCompat.m1a(resources, theme, attributeSet, AndroidResources.f4e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat a2 = VectorDrawableCompat.m26a(resources, resourceId, theme);
                        a2.m34a(false);
                        a2.setCallback(this.f10e);
                        if (this.f7b.f13b != null) {
                            this.f7b.f13b.setCallback(null);
                        }
                        this.f7b.f13b = a2;
                    }
                    a.recycle();
                } else if ("target".equals(name)) {
                    a = resources.obtainAttributes(attributeSet, AndroidResources.f5f);
                    String string = a.getString(0);
                    int resourceId2 = a.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f8c != null) {
                            m5a(string, AnimatorInflater.loadAnimator(this.f8c, resourceId2));
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void applyTheme(Theme theme) {
        if (this.a != null) {
            DrawableCompat.m1310a(this.a, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            return DrawableCompat.m1317d(this.a);
        }
        return false;
    }

    private void m4a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m4a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f9d == null) {
                    this.f9d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f9d);
            }
        }
    }

    private void m5a(String str, Animator animator) {
        animator.setTarget(this.f7b.f13b.m33a(str));
        if (VERSION.SDK_INT < 21) {
            m4a(animator);
        }
        if (this.f7b.f14c == null) {
            this.f7b.f14c = new ArrayList();
            this.f7b.f15d = new ArrayMap();
        }
        this.f7b.f14c.add(animator);
        this.f7b.f15d.put(animator, str);
    }

    public boolean isRunning() {
        if (this.a != null) {
            return ((AnimatedVectorDrawable) this.a).isRunning();
        }
        ArrayList arrayList = this.f7b.f14c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean m6a() {
        ArrayList arrayList = this.f7b.f14c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).start();
        } else if (!m6a()) {
            ArrayList arrayList = this.f7b.f14c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).stop();
            return;
        }
        ArrayList arrayList = this.f7b.f14c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
