package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: android.support.v4.app.s */
public class DialogFragment extends Fragment implements OnCancelListener, OnDismissListener {
    int f744a;
    int f745b;
    boolean f746c;
    boolean f747d;
    int f748e;
    Dialog f749f;
    boolean f750g;
    boolean f751h;
    boolean f752i;

    public DialogFragment() {
        this.f744a = 0;
        this.f745b = 0;
        this.f746c = true;
        this.f747d = true;
        this.f748e = -1;
    }

    public void m1201a(ad adVar, String str) {
        this.f751h = false;
        this.f752i = true;
        ap a = adVar.m810a();
        a.m896a(this, str);
        a.m894a();
    }

    void m1202a(boolean z) {
        if (!this.f751h) {
            this.f751h = true;
            this.f752i = false;
            if (this.f749f != null) {
                this.f749f.dismiss();
                this.f749f = null;
            }
            this.f750g = true;
            if (this.f748e >= 0) {
                m1177i().m812a(this.f748e, 1);
                this.f748e = -1;
                return;
            }
            ap a = m1177i().m810a();
            a.m895a(this);
            if (z) {
                a.m897b();
            } else {
                a.m894a();
            }
        }
    }

    public int m1197a() {
        return this.f745b;
    }

    public void m1205b(boolean z) {
        this.f747d = z;
    }

    public void m1198a(Activity activity) {
        super.m1142a(activity);
        if (!this.f752i) {
            this.f751h = false;
        }
    }

    public void m1204b() {
        super.m1157b();
        if (!this.f752i && !this.f751h) {
            this.f751h = true;
        }
    }

    public void m1200a(Bundle bundle) {
        super.m1149a(bundle);
        this.f747d = this.G == 0;
        if (bundle != null) {
            this.f744a = bundle.getInt("android:style", 0);
            this.f745b = bundle.getInt("android:theme", 0);
            this.f746c = bundle.getBoolean("android:cancelable", true);
            this.f747d = bundle.getBoolean("android:showsDialog", this.f747d);
            this.f748e = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater m1203b(Bundle bundle) {
        if (!this.f747d) {
            return super.m1155b(bundle);
        }
        this.f749f = m1206c(bundle);
        if (this.f749f == null) {
            return (LayoutInflater) this.C.m801g().getSystemService("layout_inflater");
        }
        m1199a(this.f749f, this.f744a);
        return (LayoutInflater) this.f749f.getContext().getSystemService("layout_inflater");
    }

    public void m1199a(Dialog dialog, int i) {
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog m1206c(Bundle bundle) {
        return new Dialog(m1173g(), m1197a());
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f750g) {
            m1202a(true);
        }
    }

    public void m1209d(Bundle bundle) {
        super.m1166d(bundle);
        if (this.f747d) {
            View n = m1184n();
            if (n != null) {
                if (n.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f749f.setContentView(n);
            }
            this.f749f.setOwnerActivity(m1173g());
            this.f749f.setCancelable(this.f746c);
            this.f749f.setOnCancelListener(this);
            this.f749f.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f749f.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void m1207c() {
        super.m1161c();
        if (this.f749f != null) {
            this.f750g = false;
            this.f749f.show();
        }
    }

    public void m1211e(Bundle bundle) {
        super.m1170e(bundle);
        if (this.f749f != null) {
            Bundle onSaveInstanceState = this.f749f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.f744a != 0) {
            bundle.putInt("android:style", this.f744a);
        }
        if (this.f745b != 0) {
            bundle.putInt("android:theme", this.f745b);
        }
        if (!this.f746c) {
            bundle.putBoolean("android:cancelable", this.f746c);
        }
        if (!this.f747d) {
            bundle.putBoolean("android:showsDialog", this.f747d);
        }
        if (this.f748e != -1) {
            bundle.putInt("android:backStackId", this.f748e);
        }
    }

    public void m1208d() {
        super.m1165d();
        if (this.f749f != null) {
            this.f749f.hide();
        }
    }

    public void m1210e() {
        super.m1169e();
        if (this.f749f != null) {
            this.f750g = true;
            this.f749f.dismiss();
            this.f749f = null;
        }
    }
}
