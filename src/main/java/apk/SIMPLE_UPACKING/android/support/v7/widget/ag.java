package android.support.v7.widget;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.p002h.bu;
import android.support.v7.p018b.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: ActivityChooserView */
class ag extends BaseAdapter {
    final /* synthetic */ ActivityChooserView f1849a;
    private ActivityChooserModel f1850b;
    private int f1851c;
    private boolean f1852d;
    private boolean f1853e;
    private boolean f1854f;

    public void m3907a(ActivityChooserModel activityChooserModel) {
        ActivityChooserModel d = this.f1849a.f1657b.m3912d();
        if (d != null && this.f1849a.isShown()) {
            d.unregisterObserver(this.f1849a.f1664i);
        }
        this.f1850b = activityChooserModel;
        if (activityChooserModel != null && this.f1849a.isShown()) {
            activityChooserModel.registerObserver(this.f1849a.f1664i);
        }
        notifyDataSetChanged();
    }

    public int getItemViewType(int i) {
        if (this.f1854f && i == getCount() - 1) {
            return 1;
        }
        return 0;
    }

    public int getViewTypeCount() {
        return 3;
    }

    public int getCount() {
        int a = this.f1850b.m4812a();
        if (!(this.f1852d || this.f1850b.m4816b() == null)) {
            a--;
        }
        a = Math.min(a, this.f1851c);
        if (this.f1854f) {
            return a + 1;
        }
        return a;
    }

    public Object getItem(int i) {
        switch (getItemViewType(i)) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                if (!(this.f1852d || this.f1850b.m4816b() == null)) {
                    i++;
                }
                return this.f1850b.m4814a(i);
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                if (view == null || view.getId() != R.list_item) {
                    view = LayoutInflater.from(this.f1849a.getContext()).inflate(R.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = this.f1849a.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(R.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(R.title)).setText(resolveInfo.loadLabel(packageManager));
                if (this.f1852d && i == 0 && this.f1853e) {
                    bu.m1941c(view, true);
                    return view;
                }
                bu.m1941c(view, false);
                return view;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                if (view != null && view.getId() == 1) {
                    return view;
                }
                view = LayoutInflater.from(this.f1849a.getContext()).inflate(R.abc_activity_chooser_view_list_item, viewGroup, false);
                view.setId(1);
                ((TextView) view.findViewById(R.title)).setText(this.f1849a.getContext().getString(R.abc_activity_chooser_view_see_all));
                return view;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int m3905a() {
        int i = 0;
        int i2 = this.f1851c;
        this.f1851c = Integer.MAX_VALUE;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = getCount();
        View view = null;
        int i3 = 0;
        while (i < count) {
            view = getView(i, view, null);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
        }
        this.f1851c = i2;
        return i3;
    }

    public void m3906a(int i) {
        if (this.f1851c != i) {
            this.f1851c = i;
            notifyDataSetChanged();
        }
    }

    public ResolveInfo m3910b() {
        return this.f1850b.m4816b();
    }

    public void m3908a(boolean z) {
        if (this.f1854f != z) {
            this.f1854f = z;
            notifyDataSetChanged();
        }
    }

    public int m3911c() {
        return this.f1850b.m4812a();
    }

    public ActivityChooserModel m3912d() {
        return this.f1850b;
    }

    public void m3909a(boolean z, boolean z2) {
        if (this.f1852d != z || this.f1853e != z2) {
            this.f1852d = z;
            this.f1853e = z2;
            notifyDataSetChanged();
        }
    }

    public boolean m3913e() {
        return this.f1852d;
    }
}
