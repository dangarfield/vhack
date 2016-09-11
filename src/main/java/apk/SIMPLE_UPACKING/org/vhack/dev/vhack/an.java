package org.vhack.dev.vhack;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: BuyActivity */
class an implements OnItemClickListener {
    final /* synthetic */ BuyActivity f5273a;

    an(BuyActivity buyActivity) {
        this.f5273a = buyActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = this.f5273a.f5015m[i];
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
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                this.f5273a.f5011G = 1;
                this.f5273a.f5005A.m9043a(this.f5273a, BuyActivity.f5004l[this.f5273a.f5011G - 1], 10001, this.f5273a.f5013I, "amktokenvhack");
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.f5273a.f5011G = 2;
                this.f5273a.f5005A.m9043a(this.f5273a, BuyActivity.f5004l[this.f5273a.f5011G - 1], 10001, this.f5273a.f5013I, "amktokenvhack");
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.f5273a.f5011G = 3;
                this.f5273a.f5005A.m9043a(this.f5273a, BuyActivity.f5004l[this.f5273a.f5011G - 1], 10001, this.f5273a.f5013I, "amktokenvhack");
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                this.f5273a.f5011G = 4;
                this.f5273a.f5005A.m9043a(this.f5273a, BuyActivity.f5004l[this.f5273a.f5011G - 1], 10001, this.f5273a.f5013I, "amktokenvhack");
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                this.f5273a.f5011G = 5;
                this.f5273a.f5005A.m9043a(this.f5273a, BuyActivity.f5004l[this.f5273a.f5011G - 1], 10001, this.f5273a.f5013I, "amktokenvhack");
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                this.f5273a.f5011G = 12;
                this.f5273a.f5005A.m9043a(this.f5273a, BuyActivity.f5004l[this.f5273a.f5011G - 1], 10001, this.f5273a.f5013I, "amktokenvhack");
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                this.f5273a.f5011G = 14;
                this.f5273a.f5005A.m9043a(this.f5273a, BuyActivity.f5004l[this.f5273a.f5011G - 1], 10001, this.f5273a.f5013I, "amktokenvhack");
            default:
        }
    }
}
