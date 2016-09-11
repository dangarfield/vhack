package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.support.v7.b.l;
import android.widget.TextView;
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

/* compiled from: ConsoleActivity */
class bl extends AsyncTask {
    final /* synthetic */ ConsoleActivity a;

    bl(ConsoleActivity consoleActivity) {
        this.a = consoleActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.a.findViewById(2131558696).setVisibility(0);
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
        JSONException jSONException;
        JSONException jSONException2;
        int i;
        Object obj;
        CharSequence charSequence;
        this.a.findViewById(2131558696).setVisibility(8);
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
                Editor edit = this.a.m.edit();
                edit.putString("elo", str6);
                edit.commit();
            }
            str6 = str5;
            try {
                if (str2.equals("1")) {
                    str5 = jSONObject.getString("time");
                } else {
                    str5 = str4;
                }
            } catch (JSONException e) {
                jSONException = e;
                str5 = str4;
                jSONException2 = jSONException;
                jSONException2.printStackTrace();
                switch (str2.hashCode()) {
                    case l.AppCompatTheme_homeAsUpIndicator /*48*/:
                        if (str2.equals("0")) {
                            i = 0;
                            break;
                        }
                    case l.AppCompatTheme_actionButtonStyle /*49*/:
                        if (str2.equals("1")) {
                            i = 1;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarStyle /*50*/:
                        if (str2.equals("2")) {
                            i = 2;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarButtonStyle /*51*/:
                        if (str2.equals("3")) {
                            i = 3;
                            break;
                        }
                    case l.AppCompatTheme_selectableItemBackground /*52*/:
                        if (str2.equals("4")) {
                            i = 4;
                            break;
                        }
                    default:
                        i = -1;
                        break;
                }
                switch (i) {
                    case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        if (Integer.parseInt(str6) > 0) {
                            str6 = "+" + str6;
                        }
                        str6 = this.a.getString(2131165425).replace("{TARGET}", this.a.t).replace("{GOT}", this.a.b(str3)) + ("Reputation " + str6);
                        new bm(this.a).execute(new String[]{this.a.o, this.a.p});
                        obj = str6;
                        break;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        obj = this.a.getString(2131165426).replace("{LEFT}", this.a.a(str5));
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        if (Integer.parseInt(str6) > 0) {
                            str6 = "+" + str6;
                        }
                        obj = this.a.getString(2131165422) + ("Reputation " + str6);
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        obj = this.a.getString(2131165421);
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        obj = this.a.getString(2131165423);
                        break;
                    default:
                        charSequence = str7;
                        break;
                }
                ((TextView) this.a.findViewById(2131558686)).append(charSequence);
            }
            try {
                if (str2.equals("2")) {
                    str6 = jSONObject.getString("eloch");
                    str4 = jSONObject.getString("elo");
                    Editor edit2 = this.a.m.edit();
                    edit2.putString("elo", str4);
                    edit2.commit();
                }
            } catch (JSONException e2) {
                jSONException2 = e2;
                jSONException2.printStackTrace();
                switch (str2.hashCode()) {
                    case l.AppCompatTheme_homeAsUpIndicator /*48*/:
                        if (str2.equals("0")) {
                            i = 0;
                            break;
                        }
                    case l.AppCompatTheme_actionButtonStyle /*49*/:
                        if (str2.equals("1")) {
                            i = 1;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarStyle /*50*/:
                        if (str2.equals("2")) {
                            i = 2;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarButtonStyle /*51*/:
                        if (str2.equals("3")) {
                            i = 3;
                            break;
                        }
                    case l.AppCompatTheme_selectableItemBackground /*52*/:
                        if (str2.equals("4")) {
                            i = 4;
                            break;
                        }
                    default:
                        i = -1;
                        break;
                }
                switch (i) {
                    case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        if (Integer.parseInt(str6) > 0) {
                            str6 = "+" + str6;
                        }
                        str6 = this.a.getString(2131165425).replace("{TARGET}", this.a.t).replace("{GOT}", this.a.b(str3)) + ("Reputation " + str6);
                        new bm(this.a).execute(new String[]{this.a.o, this.a.p});
                        obj = str6;
                        break;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        obj = this.a.getString(2131165426).replace("{LEFT}", this.a.a(str5));
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        if (Integer.parseInt(str6) > 0) {
                            str6 = "+" + str6;
                        }
                        obj = this.a.getString(2131165422) + ("Reputation " + str6);
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        obj = this.a.getString(2131165421);
                        break;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        obj = this.a.getString(2131165423);
                        break;
                    default:
                        charSequence = str7;
                        break;
                }
                ((TextView) this.a.findViewById(2131558686)).append(charSequence);
            }
        } catch (JSONException e3) {
            jSONException = e3;
            str6 = str5;
            str5 = str4;
            jSONException2 = jSONException;
            jSONException2.printStackTrace();
            switch (str2.hashCode()) {
                case l.AppCompatTheme_homeAsUpIndicator /*48*/:
                    if (str2.equals("0")) {
                        i = 0;
                        break;
                    }
                case l.AppCompatTheme_actionButtonStyle /*49*/:
                    if (str2.equals("1")) {
                        i = 1;
                        break;
                    }
                case l.AppCompatTheme_buttonBarStyle /*50*/:
                    if (str2.equals("2")) {
                        i = 2;
                        break;
                    }
                case l.AppCompatTheme_buttonBarButtonStyle /*51*/:
                    if (str2.equals("3")) {
                        i = 3;
                        break;
                    }
                case l.AppCompatTheme_selectableItemBackground /*52*/:
                    if (str2.equals("4")) {
                        i = 4;
                        break;
                    }
                default:
                    i = -1;
                    break;
            }
            switch (i) {
                case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    if (Integer.parseInt(str6) > 0) {
                        str6 = "+" + str6;
                    }
                    str6 = this.a.getString(2131165425).replace("{TARGET}", this.a.t).replace("{GOT}", this.a.b(str3)) + ("Reputation " + str6);
                    new bm(this.a).execute(new String[]{this.a.o, this.a.p});
                    obj = str6;
                    break;
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    obj = this.a.getString(2131165426).replace("{LEFT}", this.a.a(str5));
                    break;
                case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    if (Integer.parseInt(str6) > 0) {
                        str6 = "+" + str6;
                    }
                    obj = this.a.getString(2131165422) + ("Reputation " + str6);
                    break;
                case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    obj = this.a.getString(2131165421);
                    break;
                case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    obj = this.a.getString(2131165423);
                    break;
                default:
                    charSequence = str7;
                    break;
            }
            ((TextView) this.a.findViewById(2131558686)).append(charSequence);
        }
        switch (str2.hashCode()) {
            case l.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (str2.equals("0")) {
                    i = 0;
                    break;
                }
            case l.AppCompatTheme_actionButtonStyle /*49*/:
                if (str2.equals("1")) {
                    i = 1;
                    break;
                }
            case l.AppCompatTheme_buttonBarStyle /*50*/:
                if (str2.equals("2")) {
                    i = 2;
                    break;
                }
            case l.AppCompatTheme_buttonBarButtonStyle /*51*/:
                if (str2.equals("3")) {
                    i = 3;
                    break;
                }
            case l.AppCompatTheme_selectableItemBackground /*52*/:
                if (str2.equals("4")) {
                    i = 4;
                    break;
                }
            default:
                i = -1;
                break;
        }
        switch (i) {
            case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                if (Integer.parseInt(str6) > 0) {
                    str6 = "+" + str6;
                }
                str6 = this.a.getString(2131165425).replace("{TARGET}", this.a.t).replace("{GOT}", this.a.b(str3)) + ("Reputation " + str6);
                new bm(this.a).execute(new String[]{this.a.o, this.a.p});
                obj = str6;
                break;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                obj = this.a.getString(2131165426).replace("{LEFT}", this.a.a(str5));
                break;
            case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                if (Integer.parseInt(str6) > 0) {
                    str6 = "+" + str6;
                }
                obj = this.a.getString(2131165422) + ("Reputation " + str6);
                break;
            case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                obj = this.a.getString(2131165421);
                break;
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                obj = this.a.getString(2131165423);
                break;
            default:
                charSequence = str7;
                break;
        }
        ((TextView) this.a.findViewById(2131558686)).append(charSequence);
    }
}
