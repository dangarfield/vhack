package org.vhack.dev.vhack;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.google.android.gms.R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: SoftwareActivity */
class ff implements OnItemClickListener {
    final /* synthetic */ SoftwareActivity a;

    ff(SoftwareActivity softwareActivity) {
        this.a = softwareActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.m.start();
        this.a.q = this.a.getSharedPreferences("loginData.xml", 0);
        this.a.r = this.a.q.getString("strUser", "");
        this.a.s = this.a.q.getString("strPass", "");
        String str = this.a.E[i];
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
            case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                this.a.t = "inet";
                this.a.u = 0;
                break;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.a.t = "fw";
                this.a.u = 1;
                break;
            case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.a.t = "av";
                this.a.u = 2;
                break;
            case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                this.a.t = "sdk";
                this.a.u = 3;
                break;
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                this.a.t = "ipsp";
                this.a.u = 4;
                break;
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                this.a.t = "spam";
                this.a.u = 5;
                break;
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                this.a.t = "scan";
                this.a.u = 6;
                break;
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                this.a.t = "adw";
                this.a.u = 7;
                break;
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                this.a.t = "cpu";
                this.a.u = 8;
                break;
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                this.a.t = "hdd";
                this.a.u = 9;
                break;
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                this.a.t = "ram";
                this.a.u = 10;
                break;
        }
        ((TextView) this.a.findViewById(2131558931)).setText(str);
        new fh(this.a).execute(new String[]{this.a.t});
    }
}
