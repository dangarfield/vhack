package org.vhack.dev.vhack;

import android.app.Activity;
import android.support.v7.b.g;
import android.support.v7.b.l;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: CustomListAdapter */
public class bn extends ArrayAdapter {
    private final Activity a;
    private final String[] b;
    private final Integer[] c;
    private final String[] d;

    public bn(Activity activity, String[] strArr, Integer[] numArr, String[] strArr2) {
        super(activity, 2130968665, strArr);
        this.a = activity;
        this.b = strArr;
        this.c = numArr;
        this.d = strArr2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.a.getLayoutInflater().inflate(2130968665, null, true);
        ImageView imageView = (ImageView) inflate.findViewById(g.icon);
        TextView textView = (TextView) inflate.findViewById(2131559048);
        String str = "";
        ((TextView) inflate.findViewById(2131559047)).setText(this.b[i]);
        imageView.setImageResource(this.c[i].intValue());
        if (this.b[i].equals("CPU") || this.b[i].equals("RAM") || this.b[i].equals("HDD") || this.b[i].equals("Internet")) {
            String str2;
            boolean z;
            CharSequence charSequence;
            String str3;
            boolean z2;
            if (this.b[i].equals("CPU")) {
                str2 = this.d[i];
                switch (str2.hashCode()) {
                    case l.AppCompatTheme_actionButtonStyle /*49*/:
                        if (str2.equals("1")) {
                            z = false;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarStyle /*50*/:
                        if (str2.equals("2")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarButtonStyle /*51*/:
                        if (str2.equals("3")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_selectableItemBackground /*52*/:
                        if (str2.equals("4")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                        if (str2.equals("5")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_borderlessButtonStyle /*54*/:
                        if (str2.equals("6")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_dividerVertical /*55*/:
                        if (str2.equals("7")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_dividerHorizontal /*56*/:
                        if (str2.equals("8")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_activityChooserViewStyle /*57*/:
                        if (str2.equals("9")) {
                            z = true;
                            break;
                        }
                    case 1567:
                        if (str2.equals("10")) {
                            z = true;
                            break;
                        }
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        textView.setText("1.2 Ghz");
                        break;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        textView.setText("1.6 Ghz");
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        textView.setText("2.1 Ghz");
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        textView.setText("1.6 Ghz Dualcore");
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        textView.setText("2.1 Ghz Dualcore");
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        textView.setText("1.8 Ghz Quadcore");
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        textView.setText("2.4 Ghz Quadcore");
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        textView.setText("1.8 Ghz Hexacore");
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                        textView.setText("2.2 Ghz Hexacore");
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                        textView.setText("2.8 Ghz Hexacore");
                        break;
                }
            }
            if (this.b[i].equals("RAM")) {
                str2 = this.d[i];
                switch (str2.hashCode()) {
                    case l.AppCompatTheme_actionButtonStyle /*49*/:
                        if (str2.equals("1")) {
                            z = false;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarStyle /*50*/:
                        if (str2.equals("2")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarButtonStyle /*51*/:
                        if (str2.equals("3")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_selectableItemBackground /*52*/:
                        if (str2.equals("4")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                        if (str2.equals("5")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_borderlessButtonStyle /*54*/:
                        if (str2.equals("6")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_dividerVertical /*55*/:
                        if (str2.equals("7")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_dividerHorizontal /*56*/:
                        if (str2.equals("8")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_activityChooserViewStyle /*57*/:
                        if (str2.equals("9")) {
                            z = true;
                            break;
                        }
                    case 1567:
                        if (str2.equals("10")) {
                            z = true;
                            break;
                        }
                    case 1568:
                        if (str2.equals("11")) {
                            z = true;
                            break;
                        }
                    case 1569:
                        if (str2.equals("12")) {
                            z = true;
                            break;
                        }
                    case 1570:
                        if (str2.equals("13")) {
                            z = true;
                            break;
                        }
                    case 1571:
                        if (str2.equals("14")) {
                            z = true;
                            break;
                        }
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        charSequence = "256MB DDR1 333mhz";
                        break;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        charSequence = "512MB DDR1 333mhz";
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        charSequence = "1GB DDR1 333mhz";
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        charSequence = "2GB DDR1 333mhz";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        charSequence = "512MB DDR2 666mhz";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        charSequence = "1GB DDR2 666mhz";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        charSequence = "2GB DDR2 666mhz";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        charSequence = "4GB DDR2 666mhz";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                        charSequence = "8GB DDR2 666mhz";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                        charSequence = "2GB DDR3 1066mhz";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                        charSequence = "4GB DDR3 1066mhz";
                        break;
                    case R.styleable.MapAttrs_uiZoomControls /*11*/:
                        charSequence = "8GB DDR3 1066mhz";
                        break;
                    case R.styleable.MapAttrs_uiZoomGestures /*12*/:
                        charSequence = "16GB DDR3 1066mhz";
                        break;
                    case R.styleable.MapAttrs_useViewLifecycle /*13*/:
                        charSequence = "32GB DDR3 1066mhz";
                        break;
                    default:
                        charSequence = str;
                        break;
                }
                textView.setText(charSequence);
            } else {
                Object obj = str;
            }
            if (this.b[i].equals("HDD")) {
                str3 = this.d[i];
                switch (str3.hashCode()) {
                    case l.AppCompatTheme_actionButtonStyle /*49*/:
                        if (str3.equals("1")) {
                            z2 = false;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarStyle /*50*/:
                        if (str3.equals("2")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarButtonStyle /*51*/:
                        if (str3.equals("3")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_selectableItemBackground /*52*/:
                        if (str3.equals("4")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                        if (str3.equals("5")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_borderlessButtonStyle /*54*/:
                        if (str3.equals("6")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_dividerVertical /*55*/:
                        if (str3.equals("7")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_dividerHorizontal /*56*/:
                        if (str3.equals("8")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_activityChooserViewStyle /*57*/:
                        if (str3.equals("9")) {
                            z2 = true;
                            break;
                        }
                    case 1567:
                        if (str3.equals("10")) {
                            z2 = true;
                            break;
                        }
                    default:
                        z2 = true;
                        break;
                }
                switch (z2) {
                    case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        charSequence = "60GB";
                        break;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        charSequence = "120GB";
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        charSequence = "240GB";
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        charSequence = "320GB";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        charSequence = "500GB";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        charSequence = "1TB";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        charSequence = "2TB";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        charSequence = "4TB";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                        charSequence = "8TB";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                        charSequence = "16TB";
                        break;
                }
                textView.setText(charSequence);
            }
            if (this.b[i].equals("Internet")) {
                str3 = this.d[i];
                switch (str3.hashCode()) {
                    case l.AppCompatTheme_actionButtonStyle /*49*/:
                        if (str3.equals("1")) {
                            z2 = false;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarStyle /*50*/:
                        if (str3.equals("2")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarButtonStyle /*51*/:
                        if (str3.equals("3")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_selectableItemBackground /*52*/:
                        if (str3.equals("4")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                        if (str3.equals("5")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_borderlessButtonStyle /*54*/:
                        if (str3.equals("6")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_dividerVertical /*55*/:
                        if (str3.equals("7")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_dividerHorizontal /*56*/:
                        if (str3.equals("8")) {
                            z2 = true;
                            break;
                        }
                    case l.AppCompatTheme_activityChooserViewStyle /*57*/:
                        if (str3.equals("9")) {
                            z2 = true;
                            break;
                        }
                    case 1567:
                        if (str3.equals("10")) {
                            z2 = true;
                            break;
                        }
                    default:
                        z2 = true;
                        break;
                }
                switch (z2) {
                    case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        charSequence = "DSL 1.000";
                        break;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        charSequence = "DSL 2.000";
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        charSequence = "DSL 6.000";
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        charSequence = "DSL 16.000";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        charSequence = "vDSL 50.000";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        charSequence = "vDSL 100.000";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        charSequence = "vDSL 200.000";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        charSequence = "0.5 Gbit";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                        charSequence = "1.0 Gbit";
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                        charSequence = "1.5 Gbit";
                        break;
                }
                textView.setText(charSequence);
            }
        } else {
            textView.setText("Level: " + this.d[i]);
        }
        return inflate;
    }
}
