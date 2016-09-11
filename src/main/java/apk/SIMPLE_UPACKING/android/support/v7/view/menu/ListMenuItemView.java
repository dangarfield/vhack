package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements aa {
    private MenuItemImpl f1435a;
    private ImageView f1436b;
    private RadioButton f1437c;
    private TextView f1438d;
    private CheckBox f1439e;
    private TextView f1440f;
    private Drawable f1441g;
    private int f1442h;
    private Context f1443i;
    private boolean f1444j;
    private int f1445k;
    private Context f1446l;
    private LayoutInflater f1447m;
    private boolean f1448n;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f1446l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.MenuView, i, 0);
        this.f1441g = obtainStyledAttributes.getDrawable(R.MenuView_android_itemBackground);
        this.f1442h = obtainStyledAttributes.getResourceId(R.MenuView_android_itemTextAppearance, -1);
        this.f1444j = obtainStyledAttributes.getBoolean(R.MenuView_preserveIconSpacing, false);
        this.f1443i = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f1441g);
        this.f1438d = (TextView) findViewById(R.title);
        if (this.f1442h != -1) {
            this.f1438d.setTextAppearance(this.f1443i, this.f1442h);
        }
        this.f1440f = (TextView) findViewById(R.shortcut);
    }

    public void m3187a(MenuItemImpl menuItemImpl, int i) {
        this.f1435a = menuItemImpl;
        this.f1445k = i;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.m3329a((aa) this));
        setCheckable(menuItemImpl.isCheckable());
        m3188a(menuItemImpl.m3342f(), menuItemImpl.m3338d());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
    }

    public void setForceShowIcon(boolean z) {
        this.f1448n = z;
        this.f1444j = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1438d.setText(charSequence);
            if (this.f1438d.getVisibility() != 0) {
                this.f1438d.setVisibility(0);
            }
        } else if (this.f1438d.getVisibility() != 8) {
            this.f1438d.setVisibility(8);
        }
    }

    public MenuItemImpl getItemData() {
        return this.f1435a;
    }

    public void setCheckable(boolean z) {
        if (z || this.f1437c != null || this.f1439e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f1435a.m3343g()) {
                if (this.f1437c == null) {
                    m3185c();
                }
                compoundButton = this.f1437c;
                compoundButton2 = this.f1439e;
            } else {
                if (this.f1439e == null) {
                    m3186d();
                }
                compoundButton = this.f1439e;
                compoundButton2 = this.f1437c;
            }
            if (z) {
                int i;
                compoundButton.setChecked(this.f1435a.isChecked());
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f1439e != null) {
                this.f1439e.setVisibility(8);
            }
            if (this.f1437c != null) {
                this.f1437c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1435a.m3343g()) {
            if (this.f1437c == null) {
                m3185c();
            }
            compoundButton = this.f1437c;
        } else {
            if (this.f1439e == null) {
                m3186d();
            }
            compoundButton = this.f1439e;
        }
        compoundButton.setChecked(z);
    }

    public void m3188a(boolean z, char c) {
        int i = (z && this.f1435a.m3342f()) ? 0 : 8;
        if (i == 0) {
            this.f1440f.setText(this.f1435a.m3340e());
        }
        if (this.f1440f.getVisibility() != i) {
            this.f1440f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f1435a.m3345i() || this.f1448n) ? 1 : 0;
        if (i == 0 && !this.f1444j) {
            return;
        }
        if (this.f1436b != null || drawable != null || this.f1444j) {
            if (this.f1436b == null) {
                m3184b();
            }
            if (drawable != null || this.f1444j) {
                ImageView imageView = this.f1436b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1436b.getVisibility() != 0) {
                    this.f1436b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f1436b.setVisibility(8);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1436b != null && this.f1444j) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1436b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void m3184b() {
        this.f1436b = (ImageView) getInflater().inflate(R.abc_list_menu_item_icon, this, false);
        addView(this.f1436b, 0);
    }

    private void m3185c() {
        this.f1437c = (RadioButton) getInflater().inflate(R.abc_list_menu_item_radio, this, false);
        addView(this.f1437c);
    }

    private void m3186d() {
        this.f1439e = (CheckBox) getInflater().inflate(R.abc_list_menu_item_checkbox, this, false);
        addView(this.f1439e);
    }

    public boolean m3189a() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.f1447m == null) {
            this.f1447m = LayoutInflater.from(this.f1446l);
        }
        return this.f1447m;
    }
}
