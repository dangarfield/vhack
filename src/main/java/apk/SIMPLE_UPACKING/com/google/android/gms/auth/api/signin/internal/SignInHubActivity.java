package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.C0155h;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.p051b.iz;
import com.google.android.gms.p051b.ja;
import com.google.android.gms.p051b.jc;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@KeepName
public class SignInHubActivity extends FragmentActivity {
    private ac f3303l;
    private C0181u f3304m;
    private SignInConfiguration f3305n;
    private boolean f3306o;
    private String f3307p;
    private String f3308q;
    private boolean f3309r;
    private int f3310s;
    private Intent f3311t;

    private ja m5908a(String str) {
        return new C0157a(this, str);
    }

    private void m5909a(int i) {
        Intent intent = new Intent();
        intent.putExtra("errorCode", i);
        setResult(0, intent);
        finish();
    }

    private void m5910a(int i, int i2, Intent intent) {
        for (iz a : this.f3304m.m6046a()) {
            if (a.m6838a(i, i2, intent, m5908a(this.f3308q))) {
                break;
            }
        }
        if (i2 == 0) {
            finish();
        }
    }

    private void m5911a(int i, Intent intent) {
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.m5871f() != null) {
                GoogleSignInAccount f = signInAccount.m5871f();
                this.f3303l.m5938b(f, this.f3305n.m5904d());
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", f);
                this.f3309r = true;
                this.f3310s = i;
                this.f3311t = intent;
                m5919d(i, intent);
                return;
            } else if (intent.hasExtra("errorCode")) {
                m5916b(intent.getIntExtra("errorCode", 8));
                return;
            }
        }
        m5916b(8);
    }

    private void m5912a(Intent intent) {
        intent.setPackage("com.google.android.gms");
        intent.putExtra("config", this.f3305n);
        try {
            startActivityForResult(intent, this.f3306o ? 40962 : 40961);
        } catch (ActivityNotFoundException e) {
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            if (this.f3306o) {
                m5916b(8);
            } else {
                m5909a(2);
            }
        }
    }

    private void m5916b(int i) {
        Parcelable status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
    }

    private void m5917b(int i, Intent intent) {
        if (i == -1) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null) {
                this.f3303l.m5939b(signInAccount, this.f3305n);
                Object stringExtra = intent.getStringExtra("accessToken");
                if (!(TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(this.f3308q))) {
                    C0183w.m6050a(signInAccount.m5872g()).m6051a(new HashSet(Arrays.asList(TextUtils.split(this.f3308q, " "))), new C0184x(stringExtra, intent.getLongExtra("accessTokenExpiresAtSecs", 0)));
                    intent.removeExtra("accessTokenExpiresAtSecs");
                }
                setResult(-1, intent);
                finish();
                return;
            }
            Log.w("AuthSignInClient", "[SignInHubActivity] SignInAccount is null.");
            m5909a(2);
        } else if (intent == null) {
            finish();
        } else {
            Object stringExtra2 = intent.getStringExtra("email");
            C0155h a = C0155h.m5892a(intent.getStringExtra("idProvider"));
            if (a == null) {
                setResult(i, intent);
                finish();
                return;
            }
            this.f3307p = intent.getStringExtra("pendingToken");
            iz a2 = this.f3304m.m6045a(a);
            if (a2 == null) {
                Log.w("AuthSignInClient", a.m5893a((Context) this) + " is not supported. Please check your configuration");
                m5909a(1);
                return;
            }
            int intExtra = intent.getIntExtra("idpAction", -1);
            if (intExtra == 0) {
                if (TextUtils.isEmpty(stringExtra2)) {
                    a2.m6835a(m5908a(this.f3308q));
                } else {
                    a2.m6836a(stringExtra2, m5908a(this.f3308q));
                }
            } else if (intExtra != 1 || TextUtils.isEmpty(this.f3307p) || TextUtils.isEmpty(stringExtra2)) {
                Log.w("AuthSignInClient", "Internal error!");
                m5909a(2);
            } else {
                a2.m6837a(stringExtra2, this.f3307p, m5908a(this.f3308q));
            }
        }
    }

    private void m5918c(int i, Intent intent) {
        if (i == 0) {
            setResult(0, intent);
            finish();
            return;
        }
        Intent intent2 = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent2.putExtra("idpTokenType", IdpTokenType.f3293a);
        intent2.putExtra("idpToken", intent.getStringExtra("idpToken"));
        intent2.putExtra("pendingToken", this.f3307p);
        intent2.putExtra("idProvider", C0155h.FACEBOOK.m5894a());
        m5912a(intent2);
    }

    private void m5919d(int i, Intent intent) {
        m1227g().m922a(0, null, new C0158b());
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        setResult(0);
        switch (i) {
            case 40961:
                m5917b(i2, intent);
            case 40962:
                m5911a(i2, intent);
            case 45057:
                m5918c(i2, intent);
            default:
                m5910a(i, i2, intent);
        }
    }

    protected void onCreate(Bundle bundle) {
        Object obj;
        jc jcVar = null;
        super.onCreate(bundle);
        this.f3303l = ac.m5929a((Context) this);
        Intent intent = getIntent();
        this.f3305n = (SignInConfiguration) intent.getParcelableExtra("config");
        this.f3306o = "com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(intent.getAction());
        this.f3308q = intent.getStringExtra("scopes");
        if (this.f3305n == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        List linkedList = new LinkedList();
        Map hashMap = new HashMap();
        C0179s.m6040a(this.f3305n, linkedList, hashMap);
        this.f3304m = new C0181u(this, linkedList, hashMap);
        if (bundle == null) {
            Intent intent2;
            SignInAccount signInAccount;
            if (this.f3306o) {
                intent2 = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
                signInAccount = jcVar;
            } else {
                intent2 = new Intent("com.google.android.gms.auth.LOGIN_PICKER");
                if ("com.google.android.gms.auth.RESOLVE_CREDENTIAL".equals(intent.getAction())) {
                    intent2.fillIn(intent, 3);
                    signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                } else {
                    this.f3303l.m5941c();
                    if (jcVar != null) {
                        try {
                            jc.m6853a((Context) this);
                            obj = jcVar;
                        } catch (IllegalStateException e) {
                            obj = jcVar;
                        }
                    } else {
                        obj = jcVar;
                    }
                }
            }
            if (signInAccount == null || signInAccount.m5870e() != C0155h.FACEBOOK) {
                m5912a(intent2);
                return;
            } else {
                jcVar.m6858a(m5908a(this.f3308q));
                return;
            }
        }
        this.f3307p = bundle.getString("pendingToken");
        this.f3309r = bundle.getBoolean("signingInGoogleApiClients");
        if (this.f3309r) {
            this.f3310s = bundle.getInt("signInResultCode");
            this.f3311t = (Intent) bundle.getParcelable("signInResultData");
            m5919d(this.f3310s, this.f3311t);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("pendingToken", this.f3307p);
        bundle.putBoolean("signingInGoogleApiClients", this.f3309r);
        if (this.f3309r) {
            bundle.putInt("signInResultCode", this.f3310s);
            bundle.putParcelable("signInResultData", this.f3311t);
        }
    }
}
