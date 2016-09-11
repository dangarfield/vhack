package org.vhack.dev.vhack;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: BuyActivity */
class ao implements OnItemClickListener {
    final /* synthetic */ BuyActivity f5274a;

    ao(BuyActivity buyActivity) {
        this.f5274a = buyActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = this.f5274a.f5016n[i];
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
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                this.f5274a.f5011G = 6;
                this.f5274a.f5005A.m9043a(this.f5274a, BuyActivity.f5004l[this.f5274a.f5011G - 1], 10001, this.f5274a.f5013I, "amktokenvhack");
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.f5274a.f5011G = 7;
                this.f5274a.f5005A.m9043a(this.f5274a, BuyActivity.f5004l[this.f5274a.f5011G - 1], 10001, this.f5274a.f5013I, "amktokenvhack");
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.f5274a.f5011G = 8;
                this.f5274a.f5005A.m9043a(this.f5274a, BuyActivity.f5004l[this.f5274a.f5011G - 1], 10001, this.f5274a.f5013I, "amktokenvhack");
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                this.f5274a.f5011G = 9;
                this.f5274a.f5005A.m9043a(this.f5274a, BuyActivity.f5004l[this.f5274a.f5011G - 1], 10001, this.f5274a.f5013I, "amktokenvhack");
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                this.f5274a.f5011G = 10;
                this.f5274a.f5005A.m9043a(this.f5274a, BuyActivity.f5004l[this.f5274a.f5011G - 1], 10001, this.f5274a.f5013I, "amktokenvhack");
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                this.f5274a.f5011G = 11;
                this.f5274a.f5005A.m9043a(this.f5274a, BuyActivity.f5004l[this.f5274a.f5011G - 1], 10001, this.f5274a.f5013I, "amktokenvhack");
            default:
        }
    }
}
