package org.vhack.dev.vhack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: TaskListAdapter */
public class fj extends ArrayAdapter {
    private final Activity a;
    private final String[] b;
    private final String[] c;
    private final String[] d;
    private final String[] e;
    private final String[] f;
    private final String[] g;
    private final String[] h;
    private Integer i;

    public fj(Activity activity, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        super(activity, 2130968667, strArr);
        this.a = activity;
        this.b = strArr;
        this.c = strArr2;
        this.d = strArr3;
        this.h = strArr7;
        this.e = strArr5;
        this.f = strArr4;
        this.g = strArr6;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        String[] strArr = new String[12];
        View inflate = this.a.getLayoutInflater().inflate(2130968667, null, true);
        TextView textView = (TextView) inflate.findViewById(2131559052);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(2131559051);
        TextView textView2 = (TextView) inflate.findViewById(2131559049);
        TextView textView3 = (TextView) inflate.findViewById(2131559050);
        ((TextView) inflate.findViewById(2131559053)).setText(this.f[i] + "%");
        progressBar.setProgress(Integer.parseInt(this.f[i]));
        textView3.setText("Level " + this.d[i]);
        textView2.setText(a(this.b[i]));
        textView.setText(b(this.g[i]));
        this.i = Integer.valueOf(i);
        return inflate;
    }

    public String a(String str) {
        String str2 = "";
        Object obj = -1;
        switch (str.hashCode()) {
            case 3125:
                if (str.equals("av")) {
                    obj = 2;
                    break;
                }
                break;
            case 3281:
                if (str.equals("fw")) {
                    obj = 1;
                    break;
                }
                break;
            case 3556:
                if (str.equals("os")) {
                    obj = null;
                    break;
                }
                break;
            case 96436:
                if (str.equals("adw")) {
                    obj = 7;
                    break;
                }
                break;
            case 113722:
                if (str.equals("sdk")) {
                    obj = 3;
                    break;
                }
                break;
            case 3239364:
                if (str.equals("ipsp")) {
                    obj = 4;
                    break;
                }
                break;
            case 3524221:
                if (str.equals("scan")) {
                    obj = 6;
                    break;
                }
                break;
            case 3536713:
                if (str.equals("spam")) {
                    obj = 5;
                    break;
                }
                break;
        }
        switch (obj) {
            case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                return "Internet";
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return "Firewall";
            case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return "Antivirus";
            case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return "SDK";
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                return "IP-Spoofing";
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return "Spam";
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return "Scan";
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                return "AdWare";
            default:
                return str2;
        }
    }

    public String b(String str) {
        long j;
        long j2;
        String str2;
        long parseLong = Long.parseLong(str);
        if (parseLong >= 3600) {
            j = parseLong % 3600;
            j2 = (parseLong - j) / 3600;
        } else {
            j = parseLong;
            j2 = 0;
        }
        if (j >= 60) {
            parseLong = j % 60;
            j = (j - parseLong) / 60;
        } else {
            parseLong = j;
            j = 0;
        }
        String str3 = "";
        if (j2 > 0) {
            str3 = str3 + Long.toString(j2) + "h ";
        }
        if (j > 0) {
            str2 = str3 + Long.toString(j) + "m ";
        } else {
            str2 = str3;
        }
        if (parseLong > 0) {
            return str2 + Long.toString(parseLong) + "s.";
        }
        return str2;
    }
}
