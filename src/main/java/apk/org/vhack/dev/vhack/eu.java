package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.support.v7.b.l;
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

/* compiled from: NetworkActivity */
class eu extends AsyncTask {
    final /* synthetic */ NetworkActivity a;

    eu(NetworkActivity networkActivity) {
        this.a = networkActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.a.findViewById(2131558689).setEnabled(false);
        this.a.findViewById(2131558690).setEnabled(false);
        this.a.findViewById(2131558689).setEnabled(false);
        this.a.findViewById(2131558903).setEnabled(false);
        this.a.findViewById(2131558866).setEnabled(false);
        this.a.findViewById(2131558870).setEnabled(false);
        this.a.findViewById(2131558874).setEnabled(false);
        this.a.findViewById(2131558878).setEnabled(false);
        this.a.findViewById(2131558882).setEnabled(false);
        this.a.findViewById(2131558886).setEnabled(false);
        this.a.findViewById(2131558890).setEnabled(false);
        this.a.findViewById(2131558894).setEnabled(false);
        this.a.findViewById(2131558898).setEnabled(false);
    }

    protected String a(String... strArr) {
        String str = strArr[0];
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "target", strArr[0], "vh_trTransfer.php")).openConnection();
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void a(String str) {
        JSONException e;
        boolean z;
        JSONException jSONException;
        String str2 = "4";
        String str3 = "0";
        String str4 = "0";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.getString("result");
            if (str2.equals("0")) {
                str3 = jSONObject.getString("amount");
                str5 = jSONObject.getString("eloch");
                str6 = jSONObject.getString("elo");
                String string = jSONObject.getString("newmoney");
                Editor edit = this.a.n.edit();
                edit.putString("elo", str6);
                edit.putString("money", string);
                edit.commit();
            }
            str6 = str5;
            try {
                if (str2.equals("1")) {
                    str5 = jSONObject.getString("time");
                } else {
                    str5 = str4;
                }
                try {
                    if (str2.equals("2")) {
                        str6 = jSONObject.getString("eloch");
                        str4 = jSONObject.getString("elo");
                        Editor edit2 = this.a.n.edit();
                        edit2.putString("elo", str4);
                        edit2.commit();
                    }
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    switch (str2.hashCode()) {
                        case l.AppCompatTheme_homeAsUpIndicator /*48*/:
                            if (str2.equals("0")) {
                                z = false;
                                break;
                            }
                        case l.AppCompatTheme_actionButtonStyle /*49*/:
                            if (str2.equals("1")) {
                                z = true;
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
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                            if (Integer.parseInt(str6) > 0) {
                                str6 = "+" + str6;
                            }
                            str6 = this.a.getString(2131165425).replace("{TARGET}", this.a.r).replace("{GOT}", this.a.b(str3)) + ("Reputation " + str6);
                            break;
                        case ModuleDescriptor.MODULE_VERSION /*1*/:
                            str6 = this.a.getString(2131165426).replace("{LEFT}", this.a.a(str5));
                            break;
                        case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                            if (Integer.parseInt(str6) > 0) {
                                str6 = "+" + str6;
                            }
                            str6 = this.a.getString(2131165422) + ("Reputation " + str6);
                            break;
                        case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                            str6 = this.a.getString(2131165421);
                            break;
                        case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                            str6 = this.a.getString(2131165423);
                            break;
                        default:
                            str6 = str7;
                            break;
                    }
                    this.a.w = this.a.getString(2131165427) + str6;
                    this.a.s.a(this.a.getString(2131165427) + str6, "\n");
                    this.a.s.a(120, true);
                    new Thread(new ev(this)).start();
                }
            } catch (JSONException e3) {
                jSONException = e3;
                str5 = str4;
                e = jSONException;
                e.printStackTrace();
                switch (str2.hashCode()) {
                    case l.AppCompatTheme_homeAsUpIndicator /*48*/:
                        if (str2.equals("0")) {
                            z = false;
                            break;
                        }
                    case l.AppCompatTheme_actionButtonStyle /*49*/:
                        if (str2.equals("1")) {
                            z = true;
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
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        if (Integer.parseInt(str6) > 0) {
                            str6 = "+" + str6;
                        }
                        str6 = this.a.getString(2131165425).replace("{TARGET}", this.a.r).replace("{GOT}", this.a.b(str3)) + ("Reputation " + str6);
                        break;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        str6 = this.a.getString(2131165426).replace("{LEFT}", this.a.a(str5));
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        if (Integer.parseInt(str6) > 0) {
                            str6 = "+" + str6;
                        }
                        str6 = this.a.getString(2131165422) + ("Reputation " + str6);
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        str6 = this.a.getString(2131165421);
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        str6 = this.a.getString(2131165423);
                        break;
                    default:
                        str6 = str7;
                        break;
                }
                this.a.w = this.a.getString(2131165427) + str6;
                this.a.s.a(this.a.getString(2131165427) + str6, "\n");
                this.a.s.a(120, true);
                new Thread(new ev(this)).start();
            }
        } catch (JSONException e4) {
            jSONException = e4;
            str6 = str5;
            str5 = str4;
            e = jSONException;
            e.printStackTrace();
            switch (str2.hashCode()) {
                case l.AppCompatTheme_homeAsUpIndicator /*48*/:
                    if (str2.equals("0")) {
                        z = false;
                        break;
                    }
                case l.AppCompatTheme_actionButtonStyle /*49*/:
                    if (str2.equals("1")) {
                        z = true;
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
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    if (Integer.parseInt(str6) > 0) {
                        str6 = "+" + str6;
                    }
                    str6 = this.a.getString(2131165425).replace("{TARGET}", this.a.r).replace("{GOT}", this.a.b(str3)) + ("Reputation " + str6);
                    break;
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    str6 = this.a.getString(2131165426).replace("{LEFT}", this.a.a(str5));
                    break;
                case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    if (Integer.parseInt(str6) > 0) {
                        str6 = "+" + str6;
                    }
                    str6 = this.a.getString(2131165422) + ("Reputation " + str6);
                    break;
                case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str6 = this.a.getString(2131165421);
                    break;
                case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    str6 = this.a.getString(2131165423);
                    break;
                default:
                    str6 = str7;
                    break;
            }
            this.a.w = this.a.getString(2131165427) + str6;
            this.a.s.a(this.a.getString(2131165427) + str6, "\n");
            this.a.s.a(120, true);
            new Thread(new ev(this)).start();
        }
        switch (str2.hashCode()) {
            case l.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (str2.equals("0")) {
                    z = false;
                    break;
                }
            case l.AppCompatTheme_actionButtonStyle /*49*/:
                if (str2.equals("1")) {
                    z = true;
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
            default:
                z = true;
                break;
        }
        switch (z) {
            case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                if (Integer.parseInt(str6) > 0) {
                    str6 = "+" + str6;
                }
                str6 = this.a.getString(2131165425).replace("{TARGET}", this.a.r).replace("{GOT}", this.a.b(str3)) + ("Reputation " + str6);
                break;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                str6 = this.a.getString(2131165426).replace("{LEFT}", this.a.a(str5));
                break;
            case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                if (Integer.parseInt(str6) > 0) {
                    str6 = "+" + str6;
                }
                str6 = this.a.getString(2131165422) + ("Reputation " + str6);
                break;
            case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                str6 = this.a.getString(2131165421);
                break;
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                str6 = this.a.getString(2131165423);
                break;
            default:
                str6 = str7;
                break;
        }
        this.a.w = this.a.getString(2131165427) + str6;
        this.a.s.a(this.a.getString(2131165427) + str6, "\n");
        this.a.s.a(120, true);
        new Thread(new ev(this)).start();
    }
}
