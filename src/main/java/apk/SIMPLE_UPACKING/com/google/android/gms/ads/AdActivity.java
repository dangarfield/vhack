package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.p051b.eh;
import com.google.android.gms.p051b.ej;

public class AdActivity extends Activity {
    private ej f2863a;

    private void m5327a() {
        if (this.f2863a != null) {
            try {
                this.f2863a.m5472l();
            } catch (Throwable e) {
                C0099b.m5642c("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.f2863a != null) {
                z = this.f2863a.m5465e();
            }
        } catch (Throwable e) {
            C0099b.m5642c("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2863a = eh.m6439a((Activity) this);
        if (this.f2863a == null) {
            C0099b.m5643d("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.f2863a.m5462a(bundle);
        } catch (Throwable e) {
            C0099b.m5642c("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.f2863a != null) {
                this.f2863a.m5471k();
            }
        } catch (Throwable e) {
            C0099b.m5642c("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.f2863a != null) {
                this.f2863a.m5469i();
            }
        } catch (Throwable e) {
            C0099b.m5642c("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.f2863a != null) {
                this.f2863a.m5466f();
            }
        } catch (Throwable e) {
            C0099b.m5642c("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.f2863a != null) {
                this.f2863a.m5468h();
            }
        } catch (Throwable e) {
            C0099b.m5642c("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.f2863a != null) {
                this.f2863a.m5463b(bundle);
            }
        } catch (Throwable e) {
            C0099b.m5642c("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.f2863a != null) {
                this.f2863a.m5467g();
            }
        } catch (Throwable e) {
            C0099b.m5642c("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.f2863a != null) {
                this.f2863a.m5470j();
            }
        } catch (Throwable e) {
            C0099b.m5642c("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        m5327a();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        m5327a();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        m5327a();
    }
}
