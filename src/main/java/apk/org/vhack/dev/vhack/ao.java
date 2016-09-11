package org.vhack.dev.vhack;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.google.android.gms.R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: BuyActivity */
class ao implements OnItemClickListener {
    final /* synthetic */ BuyActivity a;

    ao(BuyActivity buyActivity) {
        this.a = buyActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = this.a.n[i];
        Object obj = -1;
        switch (str.hashCode()) {
            case -536071476:
                if (str.equals("1mio v$")) {
                    obj = null;
                    break;
                }
                break;
            case -393520367:
                if (str.equals("6mio v$")) {
                    obj = 2;
                    break;
                }
                break;
            case -121173711:
                if (str.equals("30mio (+10) v$")) {
                    obj = 4;
                    break;
                }
                break;
            case 512926419:
                if (str.equals("2.4mio v$")) {
                    obj = 1;
                    break;
                }
                break;
            case 1515828917:
                if (str.equals("64mio (+24) v$")) {
                    obj = 5;
                    break;
                }
                break;
            case 1624800062:
                if (str.equals("14mio v$")) {
                    obj = 3;
                    break;
                }
                break;
        }
        switch (obj) {
            case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                this.a.G = 6;
                this.a.A.a(this.a, BuyActivity.l[this.a.G - 1], 10001, this.a.I, "amktokenvhack");
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.a.G = 7;
                this.a.A.a(this.a, BuyActivity.l[this.a.G - 1], 10001, this.a.I, "amktokenvhack");
            case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.a.G = 8;
                this.a.A.a(this.a, BuyActivity.l[this.a.G - 1], 10001, this.a.I, "amktokenvhack");
            case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                this.a.G = 9;
                this.a.A.a(this.a, BuyActivity.l[this.a.G - 1], 10001, this.a.I, "amktokenvhack");
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                this.a.G = 10;
                this.a.A.a(this.a, BuyActivity.l[this.a.G - 1], 10001, this.a.I, "amktokenvhack");
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                this.a.G = 11;
                this.a.A.a(this.a, BuyActivity.l[this.a.G - 1], 10001, this.a.I, "amktokenvhack");
            default:
        }
    }
}
