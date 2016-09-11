package android.support.design.widget;

import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: StateListAnimator */
final class bl {
    private final ArrayList f368a;
    private bn f369b;
    private Animation f370c;
    private WeakReference f371d;
    private AnimationListener f372e;

    bl() {
        this.f368a = new ArrayList();
        this.f369b = null;
        this.f370c = null;
        this.f372e = new bm(this);
    }

    public void m585a(int[] iArr, Animation animation) {
        bn bnVar = new bn(animation, null);
        animation.setAnimationListener(this.f372e);
        this.f368a.add(bnVar);
    }

    View m582a() {
        return this.f371d == null ? null : (View) this.f371d.get();
    }

    void m583a(View view) {
        View a = m582a();
        if (a != view) {
            if (a != null) {
                m580c();
            }
            if (view != null) {
                this.f371d = new WeakReference(view);
            }
        }
    }

    private void m580c() {
        View a = m582a();
        int size = this.f368a.size();
        for (int i = 0; i < size; i++) {
            if (a.getAnimation() == ((bn) this.f368a.get(i)).f375b) {
                a.clearAnimation();
            }
        }
        this.f371d = null;
        this.f369b = null;
        this.f370c = null;
    }

    void m584a(int[] iArr) {
        bn bnVar = null;
        int size = this.f368a.size();
        for (int i = 0; i < size; i++) {
            bn bnVar2 = (bn) this.f368a.get(i);
            if (StateSet.stateSetMatches(bnVar2.f374a, iArr)) {
                bnVar = bnVar2;
                break;
            }
        }
        if (bnVar != this.f369b) {
            if (this.f369b != null) {
                m581d();
            }
            this.f369b = bnVar;
            View view = (View) this.f371d.get();
            if (bnVar != null && view != null && view.getVisibility() == 0) {
                m579a(bnVar);
            }
        }
    }

    private void m579a(bn bnVar) {
        this.f370c = bnVar.f375b;
        View a = m582a();
        if (a != null) {
            a.startAnimation(this.f370c);
        }
    }

    private void m581d() {
        if (this.f370c != null) {
            View a = m582a();
            if (a != null && a.getAnimation() == this.f370c) {
                a.clearAnimation();
            }
            this.f370c = null;
        }
    }

    public void m586b() {
        if (this.f370c != null) {
            View a = m582a();
            if (a != null && a.getAnimation() == this.f370c) {
                a.clearAnimation();
            }
        }
    }
}
