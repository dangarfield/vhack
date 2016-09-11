package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.R;
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
class fg extends AsyncTask {
    final /* synthetic */ SoftwareActivity a;

    fg(SoftwareActivity softwareActivity) {
        this.a = softwareActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.a.findViewById(2131558941).setVisibility(0);
    }

    protected String a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "utype", strArr[0], "vh_addUpdate.php")).openConnection();
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

    protected void a(String str) {
        int i = 8;
        this.a.findViewById(2131558941).setVisibility(8);
        if (str.length() > 10) {
            try {
                CharSequence charSequence;
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("result");
                String string2 = jSONObject.getString("costs");
                String string3 = jSONObject.getString("type");
                String string4 = jSONObject.getString("money");
                String string5 = jSONObject.getString("new");
                this.a.G[0] = jSONObject.getString("inet");
                this.a.G[1] = jSONObject.getString("fw");
                this.a.G[2] = jSONObject.getString("av");
                this.a.G[3] = jSONObject.getString("sdk");
                this.a.G[4] = jSONObject.getString("ipsp");
                this.a.G[5] = jSONObject.getString("spam");
                this.a.G[6] = jSONObject.getString("scan");
                this.a.G[7] = jSONObject.getString("adw");
                this.a.G[8] = jSONObject.getString("cpu");
                this.a.G[9] = jSONObject.getString("ram");
                this.a.G[10] = jSONObject.getString("hdd");
                this.a.G[11] = string4;
                this.a.x.notifyDataSetChanged();
                Editor edit = this.a.getSharedPreferences("loginData.xml", 0).edit();
                edit.putString("inet", this.a.G[0]);
                edit.putString("fw", this.a.G[1]);
                edit.putString("av", this.a.G[2]);
                edit.putString("sdk", this.a.G[3]);
                edit.putString("ipsp", this.a.G[4]);
                edit.putString("spam", this.a.G[5]);
                edit.putString("scan", this.a.G[6]);
                edit.putString("adw", this.a.G[7]);
                edit.putString("cpu", this.a.G[8]);
                edit.putString("ram", this.a.G[9]);
                edit.putString("hdd", this.a.G[10]);
                edit.putString("money", string4);
                edit.commit();
                if (string.equals("0")) {
                    if (string3.equals("cpu") || string3.equals("hdd") || string3.equals("inet") || string3.equals("ram")) {
                        Toast.makeText(this.a, 2131165429, 0).show();
                    } else {
                        Toast.makeText(this.a, 2131165412, 0).show();
                    }
                }
                if (string.equals("1")) {
                    Toast.makeText(this.a, 2131165375, 0).show();
                }
                if (string.equals("2")) {
                    Toast.makeText(this.a, 2131165365, 0).show();
                }
                if (string.equals("3")) {
                    Toast.makeText(this.a, 2131165366, 0).show();
                }
                String str2 = "";
                if (string3.equals("cpu")) {
                    str2 = this.a.A[Integer.parseInt(string5) - 1];
                }
                if (string3.equals("ram")) {
                    str2 = this.a.B[Integer.parseInt(string5) - 1];
                }
                if (string3.equals("hdd")) {
                    str2 = this.a.C[Integer.parseInt(string5) - 1];
                }
                boolean z = true;
                switch (string3.hashCode()) {
                    case 3125:
                        if (string3.equals("av")) {
                            z = true;
                            break;
                        }
                        break;
                    case 3281:
                        if (string3.equals("fw")) {
                            z = true;
                            break;
                        }
                        break;
                    case 96436:
                        if (string3.equals("adw")) {
                            z = true;
                            break;
                        }
                        break;
                    case 98728:
                        if (string3.equals("cpu")) {
                            z = true;
                            break;
                        }
                        break;
                    case 103144:
                        if (string3.equals("hdd")) {
                            z = true;
                            break;
                        }
                        break;
                    case 112670:
                        if (string3.equals("ram")) {
                            z = true;
                            break;
                        }
                        break;
                    case 113722:
                        if (string3.equals("sdk")) {
                            z = true;
                            break;
                        }
                        break;
                    case 3237012:
                        if (string3.equals("inet")) {
                            z = false;
                            break;
                        }
                        break;
                    case 3239364:
                        if (string3.equals("ipsp")) {
                            z = true;
                            break;
                        }
                        break;
                    case 3524221:
                        if (string3.equals("scan")) {
                            z = true;
                            break;
                        }
                        break;
                    case 3536713:
                        if (string3.equals("spam")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        i = 0;
                        break;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        i = 1;
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        i = 2;
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        i = 3;
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        i = 4;
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        i = 5;
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        i = 6;
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        i = 7;
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                        i = 9;
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                        i = 10;
                        break;
                    default:
                        i = 0;
                        break;
                }
                if (i <= 7) {
                    charSequence = this.a.z[i];
                } else {
                    Object obj = str2;
                }
                if (string2.equals("")) {
                    string2 = "0";
                }
                CharSequence charSequence2 = this.a.D[i];
                Long valueOf = Long.valueOf(Long.parseLong(string4));
                int parseInt = Integer.parseInt(string2);
                ((TextView) this.a.findViewById(2131558933)).setText(charSequence2);
                TextView textView = (TextView) this.a.findViewById(2131558934);
                ((TextView) this.a.findViewById(2131558937)).setText("$" + this.a.a(string4));
                textView.setText(charSequence);
                if (string3.equals("hdd") || string3.equals("cpu") || string3.equals("ram") || string3.equals("inet")) {
                    if (string3.equals("ram")) {
                        if (Integer.parseInt(string5) >= 15) {
                            this.a.v.setClickable(false);
                            this.a.v.setText("-");
                            textView.setText(2131165260);
                        } else if (valueOf.longValue() >= ((long) parseInt)) {
                            this.a.v.setText(this.a.getString(2131165280).replace("{PRICE}", this.a.a(parseInt + "")));
                            this.a.v.setClickable(true);
                        } else {
                            this.a.v.setClickable(false);
                            this.a.v.setText(this.a.getString(2131165374).replace("{PRICE}", this.a.a(parseInt + "")));
                        }
                    } else if (Integer.parseInt(string5) >= 11) {
                        this.a.v.setClickable(false);
                        this.a.v.setText("-");
                        textView.setText(2131165260);
                    } else if (valueOf.longValue() >= ((long) parseInt)) {
                        this.a.v.setText(this.a.getString(2131165280).replace("{PRICE}", this.a.a(parseInt + "")));
                        this.a.v.setClickable(true);
                    } else {
                        this.a.v.setClickable(false);
                        this.a.v.setText(this.a.getString(2131165374).replace("{PRICE}", this.a.a(parseInt + "")));
                    }
                } else if (valueOf.longValue() >= ((long) parseInt)) {
                    this.a.v.setText(this.a.getString(2131165280).replace("{PRICE}", this.a.a(parseInt + "")));
                    this.a.v.setClickable(true);
                } else {
                    this.a.v.setClickable(false);
                    this.a.v.setText(this.a.getString(2131165374).replace("{PRICE}", this.a.a(parseInt + "")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.a.v.setClickable(true);
    }
}
