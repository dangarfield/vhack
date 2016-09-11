package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p017a.ActionBar;
import android.support.v7.p018b.R;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/* compiled from: ScrollingTabContainerView */
class fh extends cs implements OnLongClickListener {
    final /* synthetic */ fd f2237a;
    private final int[] f2238b;
    private ActionBar f2239c;
    private TextView f2240d;
    private ImageView f2241e;
    private View f2242f;

    public fh(fd fdVar, Context context, ActionBar actionBar, boolean z) {
        this.f2237a = fdVar;
        super(context, null, R.actionBarTabStyle);
        this.f2238b = new int[]{16842964};
        this.f2239c = actionBar;
        gb a = gb.m4646a(context, null, this.f2238b, R.actionBarTabStyle, 0);
        if (a.m4661f(0)) {
            setBackgroundDrawable(a.m4649a(0));
        }
        a.m4650a();
        if (z) {
            setGravity(8388627);
        }
        m4573a();
    }

    public void m4574a(ActionBar actionBar) {
        this.f2239c = actionBar;
        m4573a();
    }

    public void setSelected(boolean z) {
        Object obj = isSelected() != z ? 1 : null;
        super.setSelected(z);
        if (obj != null && z) {
            sendAccessibilityEvent(4);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ActionBar.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName(ActionBar.class.getName());
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2237a.f2225b > 0 && getMeasuredWidth() > this.f2237a.f2225b) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(this.f2237a.f2225b, 1073741824), i2);
        }
    }

    public void m4573a() {
        ActionBar actionBar = this.f2239c;
        View c = actionBar.m3031c();
        if (c != null) {
            fh parent = c.getParent();
            if (parent != this) {
                if (parent != null) {
                    parent.removeView(c);
                }
                addView(c);
            }
            this.f2242f = c;
            if (this.f2240d != null) {
                this.f2240d.setVisibility(8);
            }
            if (this.f2241e != null) {
                this.f2241e.setVisibility(8);
                this.f2241e.setImageDrawable(null);
                return;
            }
            return;
        }
        boolean z;
        if (this.f2242f != null) {
            removeView(this.f2242f);
            this.f2242f = null;
        }
        Drawable a = actionBar.m3029a();
        CharSequence b = actionBar.m3030b();
        if (a != null) {
            if (this.f2241e == null) {
                View imageView = new ImageView(getContext());
                LayoutParams ctVar = new ct(-2, -2);
                ctVar.f2082h = 16;
                imageView.setLayoutParams(ctVar);
                addView(imageView, 0);
                this.f2241e = imageView;
            }
            this.f2241e.setImageDrawable(a);
            this.f2241e.setVisibility(0);
        } else if (this.f2241e != null) {
            this.f2241e.setVisibility(8);
            this.f2241e.setImageDrawable(null);
        }
        if (TextUtils.isEmpty(b)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.f2240d == null) {
                imageView = new bs(getContext(), null, R.actionBarTabTextStyle);
                imageView.setEllipsize(TruncateAt.END);
                ctVar = new ct(-2, -2);
                ctVar.f2082h = 16;
                imageView.setLayoutParams(ctVar);
                addView(imageView);
                this.f2240d = imageView;
            }
            this.f2240d.setText(b);
            this.f2240d.setVisibility(0);
        } else if (this.f2240d != null) {
            this.f2240d.setVisibility(8);
            this.f2240d.setText(null);
        }
        if (this.f2241e != null) {
            this.f2241e.setContentDescription(actionBar.m3033e());
        }
        if (z || TextUtils.isEmpty(actionBar.m3033e())) {
            setOnLongClickListener(null);
            setLongClickable(false);
            return;
        }
        setOnLongClickListener(this);
    }

    public boolean onLongClick(View view) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = context.getResources().getDisplayMetrics().widthPixels;
        Toast makeText = Toast.makeText(context, this.f2239c.m3033e(), 0);
        makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
        makeText.show();
        return true;
    }

    public ActionBar m4575b() {
        return this.f2239c;
    }
}
