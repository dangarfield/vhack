package org.vhack.dev.vhack;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: SoftwareActivity */
class ff implements OnItemClickListener {
    final /* synthetic */ SoftwareActivity f5448a;

    ff(SoftwareActivity softwareActivity) {
        this.f5448a = softwareActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f5448a.f5170m.start();
        this.f5448a.f5174q = this.f5448a.getSharedPreferences("loginData.xml", 0);
        this.f5448a.f5175r = this.f5448a.f5174q.getString("strUser", "");
        this.f5448a.f5176s = this.f5448a.f5174q.getString("strPass", "");
        String str = this.f5448a.f5166E[i];
        int i2 = -1;
        switch (str.hashCode()) {
            case -498081504:
                if (str.equals("Firewall")) {
                    i2 = 1;
                    break;
                }
                break;
            case -95324997:
                if (str.equals("Antivirus")) {
                    i2 = 2;
                    break;
                }
                break;
            case 66952:
                if (str.equals("CPU")) {
                    i2 = 8;
                    break;
                }
                break;
            case 71368:
                if (str.equals("HDD")) {
                    i2 = 9;
                    break;
                }
                break;
            case 80894:
                if (str.equals("RAM")) {
                    i2 = 10;
                    break;
                }
                break;
            case 81946:
                if (str.equals("SDK")) {
                    i2 = 3;
                    break;
                }
                break;
            case 2570909:
                if (str.equals("Scan")) {
                    i2 = 6;
                    break;
                }
                break;
            case 2583401:
                if (str.equals("Spam")) {
                    i2 = 5;
                    break;
                }
                break;
            case 635054945:
                if (str.equals("Internet")) {
                    i2 = 0;
                    break;
                }
                break;
            case 1923310143:
                if (str.equals("IP-Spoofing")) {
                    i2 = 4;
                    break;
                }
                break;
            case 1955935584:
                if (str.equals("AdWare")) {
                    i2 = 7;
                    break;
                }
                break;
        }
        switch (i2) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                this.f5448a.f5177t = "inet";
                this.f5448a.f5178u = 0;
                break;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.f5448a.f5177t = "fw";
                this.f5448a.f5178u = 1;
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.f5448a.f5177t = "av";
                this.f5448a.f5178u = 2;
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                this.f5448a.f5177t = "sdk";
                this.f5448a.f5178u = 3;
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                this.f5448a.f5177t = "ipsp";
                this.f5448a.f5178u = 4;
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                this.f5448a.f5177t = "spam";
                this.f5448a.f5178u = 5;
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                this.f5448a.f5177t = "scan";
                this.f5448a.f5178u = 6;
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                this.f5448a.f5177t = "adw";
                this.f5448a.f5178u = 7;
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                this.f5448a.f5177t = "cpu";
                this.f5448a.f5178u = 8;
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                this.f5448a.f5177t = "hdd";
                this.f5448a.f5178u = 9;
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                this.f5448a.f5177t = "ram";
                this.f5448a.f5178u = 10;
                break;
        }
        ((TextView) this.f5448a.findViewById(2131558931)).setText(str);
        new fh(this.f5448a).execute(new String[]{this.f5448a.f5177t});
    }
}
