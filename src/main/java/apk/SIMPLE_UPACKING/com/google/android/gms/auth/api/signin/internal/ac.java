package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.internal.bf;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class ac {
    private static final Lock f3315a;
    private static ac f3316b;
    private final Lock f3317c;
    private final SharedPreferences f3318d;

    static {
        f3315a = new ReentrantLock();
    }

    ac(Context context) {
        this.f3317c = new ReentrantLock();
        this.f3318d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static ac m5929a(Context context) {
        bf.m7873a((Object) context);
        f3315a.lock();
        try {
            if (f3316b == null) {
                f3316b = new ac(context.getApplicationContext());
            }
            ac acVar = f3316b;
            return acVar;
        } finally {
            f3315a.unlock();
        }
    }

    private String m5930b(String str, String str2) {
        return str + ":" + str2;
    }

    public GoogleSignInAccount m5931a() {
        return m5936b(m5942d("defaultGoogleSignInAccount"));
    }

    SignInAccount m5932a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String d = m5942d(m5930b("signInAccount", str));
        if (TextUtils.isEmpty(d)) {
            return null;
        }
        try {
            SignInAccount a = SignInAccount.m5863a(d);
            if (a.m5871f() != null) {
                GoogleSignInAccount b = m5936b(a.m5871f().m5842h());
                if (b != null) {
                    a.m5865a(b);
                }
            }
            return a;
        } catch (JSONException e) {
            return null;
        }
    }

    void m5933a(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        bf.m7873a((Object) googleSignInAccount);
        bf.m7873a((Object) googleSignInOptions);
        String h = googleSignInAccount.m5842h();
        m5935a(m5930b("googleSignInAccount", h), googleSignInAccount.m5844j());
        m5935a(m5930b("googleSignInOptions", h), googleSignInOptions.m5861h());
    }

    void m5934a(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        bf.m7873a((Object) signInAccount);
        bf.m7873a((Object) signInConfiguration);
        String g = signInAccount.m5872g();
        SignInAccount a = m5932a(g);
        if (!(a == null || a.m5871f() == null)) {
            m5945f(a.m5871f().m5842h());
        }
        m5935a(m5930b("signInConfiguration", g), signInConfiguration.m5906f());
        m5935a(m5930b("signInAccount", g), signInAccount.m5874i());
        if (signInAccount.m5871f() != null) {
            m5933a(signInAccount.m5871f(), signInConfiguration.m5904d());
        }
    }

    protected void m5935a(String str, String str2) {
        this.f3317c.lock();
        try {
            this.f3318d.edit().putString(str, str2).apply();
        } finally {
            this.f3317c.unlock();
        }
    }

    GoogleSignInAccount m5936b(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String d = m5942d(m5930b("googleSignInAccount", str));
            if (d != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.m5831a(d);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    public GoogleSignInOptions m5937b() {
        return m5940c(m5942d("defaultGoogleSignInAccount"));
    }

    public void m5938b(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        bf.m7873a((Object) googleSignInAccount);
        bf.m7873a((Object) googleSignInOptions);
        m5935a("defaultGoogleSignInAccount", googleSignInAccount.m5842h());
        m5933a(googleSignInAccount, googleSignInOptions);
    }

    public void m5939b(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        bf.m7873a((Object) signInAccount);
        bf.m7873a((Object) signInConfiguration);
        m5941c();
        m5935a("defaultSignInAccount", signInAccount.m5872g());
        if (signInAccount.m5871f() != null) {
            m5935a("defaultGoogleSignInAccount", signInAccount.m5871f().m5842h());
        }
        m5934a(signInAccount, signInConfiguration);
    }

    GoogleSignInOptions m5940c(String str) {
        GoogleSignInOptions googleSignInOptions = null;
        if (!TextUtils.isEmpty(str)) {
            String d = m5942d(m5930b("googleSignInOptions", str));
            if (d != null) {
                try {
                    googleSignInOptions = GoogleSignInOptions.m5845a(d);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInOptions;
    }

    public void m5941c() {
        String d = m5942d("defaultSignInAccount");
        m5946g("defaultSignInAccount");
        m5943d();
        m5944e(d);
    }

    protected String m5942d(String str) {
        this.f3317c.lock();
        try {
            String string = this.f3318d.getString(str, null);
            return string;
        } finally {
            this.f3317c.unlock();
        }
    }

    public void m5943d() {
        String d = m5942d("defaultGoogleSignInAccount");
        m5946g("defaultGoogleSignInAccount");
        m5945f(d);
    }

    void m5944e(String str) {
        if (!TextUtils.isEmpty(str)) {
            SignInAccount a = m5932a(str);
            m5946g(m5930b("signInAccount", str));
            m5946g(m5930b("signInConfiguration", str));
            if (a != null && a.m5871f() != null) {
                m5945f(a.m5871f().m5842h());
            }
        }
    }

    void m5945f(String str) {
        if (!TextUtils.isEmpty(str)) {
            m5946g(m5930b("googleSignInAccount", str));
            m5946g(m5930b("googleSignInOptions", str));
        }
    }

    protected void m5946g(String str) {
        this.f3317c.lock();
        try {
            this.f3318d.edit().remove(str).apply();
        } finally {
            this.f3317c.unlock();
        }
    }
}
