package android.support.v7.widget;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: ActivityChooserView */
class ah implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
    final /* synthetic */ ActivityChooserView f1855a;

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (((ag) adapterView.getAdapter()).getItemViewType(i)) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                this.f1855a.m3476b();
                if (!this.f1855a.f1668m) {
                    if (!this.f1855a.f1657b.m3913e()) {
                        i++;
                    }
                    Intent b = this.f1855a.f1657b.m3912d().m4815b(i);
                    if (b != null) {
                        b.addFlags(524288);
                        this.f1855a.getContext().startActivity(b);
                    }
                } else if (i > 0) {
                    this.f1855a.f1657b.m3912d().m4817c(i);
                }
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.f1855a.m3466a(Integer.MAX_VALUE);
            default:
                throw new IllegalArgumentException();
        }
    }

    public void onClick(View view) {
        if (view == this.f1855a.f1662g) {
            this.f1855a.m3476b();
            Intent b = this.f1855a.f1657b.m3912d().m4815b(this.f1855a.f1657b.m3912d().m4813a(this.f1855a.f1657b.m3910b()));
            if (b != null) {
                b.addFlags(524288);
                this.f1855a.getContext().startActivity(b);
            }
        } else if (view == this.f1855a.f1660e) {
            this.f1855a.f1668m = false;
            this.f1855a.m3466a(this.f1855a.f1669n);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean onLongClick(View view) {
        if (view == this.f1855a.f1662g) {
            if (this.f1855a.f1657b.getCount() > 0) {
                this.f1855a.f1668m = true;
                this.f1855a.m3466a(this.f1855a.f1669n);
            }
            return true;
        }
        throw new IllegalArgumentException();
    }

    public void onDismiss() {
        m3914a();
        if (this.f1855a.f1656a != null) {
            this.f1855a.f1656a.m2399a(false);
        }
    }

    private void m3914a() {
        if (this.f1855a.f1667l != null) {
            this.f1855a.f1667l.onDismiss();
        }
    }
}
