package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.R;
import android.support.v4.p009c.p010a.DrawableCompat;
import android.support.v4.widget.az;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.aa;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends ForegroundLinearLayout implements aa {
    private static final int[] f111c;
    private final int f112d;
    private final CheckedTextView f113e;
    private FrameLayout f114f;
    private MenuItemImpl f115g;
    private ColorStateList f116h;

    static {
        f111c = new int[]{16842912};
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.design_navigation_menu_item, this, true);
        this.f112d = context.getResources().getDimensionPixelSize(R.design_navigation_icon_size);
        this.f113e = (CheckedTextView) findViewById(R.design_menu_item_text);
        this.f113e.setDuplicateParentStateEnabled(true);
    }

    public void m98a(MenuItemImpl menuItemImpl, int i) {
        this.f115g = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            setBackgroundDrawable(m97b());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
    }

    private void setActionView(View view) {
        if (this.f114f == null) {
            this.f114f = (FrameLayout) ((ViewStub) findViewById(R.design_menu_item_action_area_stub)).inflate();
        }
        this.f114f.removeAllViews();
        if (view != null) {
            this.f114f.addView(view);
        }
    }

    private StateListDrawable m97b() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f111c, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public MenuItemImpl getItemData() {
        return this.f115g;
    }

    public void setTitle(CharSequence charSequence) {
        this.f113e.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f113e.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.m1319f(drawable).mutate();
            drawable.setBounds(0, 0, this.f112d, this.f112d);
            DrawableCompat.m1309a(drawable, this.f116h);
        }
        az.m2604a(this.f113e, drawable, null, null, null);
    }

    public boolean m99a() {
        return false;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f115g != null && this.f115g.isCheckable() && this.f115g.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f111c);
        }
        return onCreateDrawableState;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f116h = colorStateList;
        if (this.f115g != null) {
            setIcon(this.f115g.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f113e.setTextColor(colorStateList);
    }
}
