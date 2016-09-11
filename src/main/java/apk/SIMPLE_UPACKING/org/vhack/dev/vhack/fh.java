package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.widget.TextView;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SoftwareActivity */
class fh extends AsyncTask {
    final /* synthetic */ SoftwareActivity f5450a;

    fh(SoftwareActivity softwareActivity) {
        this.f5450a = softwareActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9171a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9172a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5450a.findViewById(2131558941).setVisibility(0);
    }

    protected String m9171a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5450a.getApplicationContext(), "utype", strArr[0], "vh_updateInfo.php")).openConnection();
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    if (responseCode != 200) {
                        return "Request failed!";
                    }
                    try {
                        InputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        try {
                            for (int read = bufferedInputStream.read(); read != -1; read = bufferedInputStream.read()) {
                                byteArrayOutputStream.write(read);
                            }
                            return byteArrayOutputStream.toString();
                        } catch (IOException e) {
                            return "Failed to read Response";
                        }
                    } catch (IOException e2) {
                        return "Failed to get API Response";
                    }
                } catch (IOException e3) {
                    return "Failed to get Response Code";
                }
            } catch (IOException e4) {
                return "Failed to open Connection";
            }
        } catch (MalformedURLException e5) {
            return "URL isn't valid";
        }
    }

    protected void m9172a(String str) {
        int i = 1;
        this.f5450a.findViewById(2131558941).setVisibility(8);
        this.f5450a.findViewById(2131558932).setVisibility(0);
        if (str.length() > 10) {
            try {
                CharSequence charSequence;
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("costs");
                String string2 = jSONObject.getString("type");
                String string3 = jSONObject.getString("money");
                String string4 = jSONObject.getString("new");
                String str2 = "";
                if (string2.equals("cpu")) {
                    str2 = this.f5450a.f5162A[Integer.parseInt(string4) - 2];
                }
                if (string2.equals("ram")) {
                    str2 = this.f5450a.f5163B[Integer.parseInt(string4) - 2];
                }
                if (string2.equals("hdd")) {
                    str2 = this.f5450a.f5164C[Integer.parseInt(string4) - 2];
                }
                int i2 = -1;
                switch (string2.hashCode()) {
                    case 3125:
                        if (string2.equals("av")) {
                            i2 = 2;
                            break;
                        }
                        break;
                    case 3281:
                        if (string2.equals("fw")) {
                            i2 = 1;
                            break;
                        }
                        break;
                    case 96436:
                        if (string2.equals("adw")) {
                            i2 = 7;
                            break;
                        }
                        break;
                    case 98728:
                        if (string2.equals("cpu")) {
                            i2 = 8;
                            break;
                        }
                        break;
                    case 103144:
                        if (string2.equals("hdd")) {
                            i2 = 10;
                            break;
                        }
                        break;
                    case 112670:
                        if (string2.equals("ram")) {
                            i2 = 9;
                            break;
                        }
                        break;
                    case 113722:
                        if (string2.equals("sdk")) {
                            i2 = 3;
                            break;
                        }
                        break;
                    case 3237012:
                        if (string2.equals("inet")) {
                            i2 = 0;
                            break;
                        }
                        break;
                    case 3239364:
                        if (string2.equals("ipsp")) {
                            i2 = 4;
                            break;
                        }
                        break;
                    case 3524221:
                        if (string2.equals("scan")) {
                            i2 = 6;
                            break;
                        }
                        break;
                    case 3536713:
                        if (string2.equals("spam")) {
                            i2 = 5;
                            break;
                        }
                        break;
                }
                switch (i2) {
                    case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        i = 0;
                        break;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        break;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        i = 2;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        i = 3;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        i = 4;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        i = 5;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        i = 6;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        i = 7;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                        i = 8;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                        i = 9;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                        i = 10;
                        break;
                    default:
                        i = 0;
                        break;
                }
                if (i <= 7) {
                    charSequence = this.f5450a.f5183z[i];
                } else {
                    Object obj = str2;
                }
                if (string.equals("")) {
                    string = "0";
                }
                CharSequence charSequence2 = this.f5450a.f5165D[i];
                Long valueOf = Long.valueOf(Long.parseLong(string3));
                int parseInt = Integer.parseInt(string);
                ((TextView) this.f5450a.findViewById(2131558933)).setText(charSequence2);
                TextView textView = (TextView) this.f5450a.findViewById(2131558934);
                ((TextView) this.f5450a.findViewById(2131558937)).setText("$" + this.f5450a.m9030a(string3));
                textView.setText(charSequence);
                if (string2.equals("hdd") || string2.equals("cpu") || string2.equals("ram") || string2.equals("inet")) {
                    if (string2.equals("ram")) {
                        if (Integer.parseInt(string4) >= 15) {
                            this.f5450a.f5179v.setClickable(false);
                            this.f5450a.f5179v.setText("-");
                            textView.setText(2131165260);
                        } else if (valueOf.longValue() >= ((long) parseInt)) {
                            this.f5450a.f5179v.setText(this.f5450a.getString(2131165280).replace("{PRICE}", this.f5450a.m9030a(parseInt + "")));
                            this.f5450a.f5179v.setClickable(true);
                        } else {
                            this.f5450a.f5179v.setClickable(false);
                            this.f5450a.f5179v.setText(this.f5450a.getString(2131165374).replace("{PRICE}", this.f5450a.m9030a(parseInt + "")));
                        }
                    } else if (Integer.parseInt(string4) >= 11) {
                        this.f5450a.f5179v.setClickable(false);
                        this.f5450a.f5179v.setText("-");
                        textView.setText(2131165260);
                    } else if (valueOf.longValue() >= ((long) parseInt)) {
                        this.f5450a.f5179v.setText(this.f5450a.getString(2131165280).replace("{PRICE}", this.f5450a.m9030a(parseInt + "")));
                        this.f5450a.f5179v.setClickable(true);
                    } else {
                        this.f5450a.f5179v.setClickable(false);
                        this.f5450a.f5179v.setText(this.f5450a.getString(2131165374).replace("{PRICE}", this.f5450a.m9030a(parseInt + "")));
                    }
                } else if (valueOf.longValue() >= ((long) parseInt)) {
                    this.f5450a.f5179v.setText(this.f5450a.getString(2131165280).replace("{PRICE}", this.f5450a.m9030a(parseInt + "")));
                    this.f5450a.f5179v.setClickable(true);
                } else {
                    this.f5450a.f5179v.setClickable(false);
                    this.f5450a.f5179v.setText(this.f5450a.getString(2131165374).replace("{PRICE}", this.f5450a.m9030a(parseInt + "")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
