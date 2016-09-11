package org.vhack.dev.vhack;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.google.android.gms.R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: BuyActivity */
class an implements OnItemClickListener {
    final /* synthetic */ BuyActivity a;

    an(BuyActivity buyActivity) {
        this.a = buyActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = this.a.m[i];
        int i2 = -1;
        switch (str.hashCode()) {
            case -1931131166:
                if (str.equals("10,000 NetCoins")) {
                    i2 = 4;
                    break;
                }
                break;
            case -1019551604:
                if (str.equals("5,000 NetCoins")) {
                    i2 = 3;
                    break;
                }
                break;
            case -423579357:
                if (str.equals("20,000 NetCoins")) {
                    i2 = 5;
                    break;
                }
                break;
            case -195891226:
                if (str.equals("50,000 NetCoins")) {
                    i2 = 6;
                    break;
                }
                break;
            case 675495760:
                if (str.equals("500 NetCoins")) {
                    i2 = 0;
                    break;
                }
                break;
            case 1002682896:
                if (str.equals("1,000 NetCoins")) {
                    i2 = 1;
                    break;
                }
                break;
            case 1142537866:
                if (str.equals("2,500 NetCoins")) {
                    i2 = 2;
                    break;
                }
                break;
        }
        switch (i2) {
            case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                this.a.G = 1;
                this.a.A.a(this.a, BuyActivity.l[this.a.G - 1], 10001, this.a.I, "amktokenvhack");
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.a.G = 2;
                this.a.A.a(this.a, BuyActivity.l[this.a.G - 1], 10001, this.a.I, "amktokenvhack");
            case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.a.G = 3;
                this.a.A.a(this.a, BuyActivity.l[this.a.G - 1], 10001, this.a.I, "amktokenvhack");
            case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                this.a.G = 4;
                this.a.A.a(this.a, BuyActivity.l[this.a.G - 1], 10001, this.a.I, "amktokenvhack");
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                this.a.G = 5;
                this.a.A.a(this.a, BuyActivity.l[this.a.G - 1], 10001, this.a.I, "amktokenvhack");
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                this.a.G = 12;
                this.a.A.a(this.a, BuyActivity.l[this.a.G - 1], 10001, this.a.I, "amktokenvhack");
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                this.a.G = 14;
                this.a.A.a(this.a, BuyActivity.l[this.a.G - 1], 10001, this.a.I, "amktokenvhack");
            default:
        }
    }
}
