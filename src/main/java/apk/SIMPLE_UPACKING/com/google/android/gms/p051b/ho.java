package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.C0001R;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.overlay.C0060c;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

@fi
@TargetApi(11)
/* renamed from: com.google.android.gms.b.ho */
public class ho extends WebChromeClient {
    private final hb f3798a;

    public ho(hb hbVar) {
        this.f3798a = hbVar;
    }

    private final Context m6789a(WebView webView) {
        if (!(webView instanceof hb)) {
            return webView.getContext();
        }
        hb hbVar = (hb) webView;
        Context e = hbVar.m6646e();
        return e == null ? hbVar.getContext() : e;
    }

    private static void m6790a(Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new hr(jsResult)).setNegativeButton(17039360, new hq(jsResult)).setOnCancelListener(new hp(jsResult)).create().show();
    }

    private static void m6791a(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new hu(jsPromptResult, editText)).setNegativeButton(17039360, new ht(jsPromptResult)).setOnCancelListener(new hs(jsPromptResult)).create().show();
    }

    private final boolean m6792a() {
        return C0056g.m5439c().m6542a(this.f3798a.getContext().getPackageManager(), this.f3798a.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION") || C0056g.m5439c().m6542a(this.f3798a.getContext().getPackageManager(), this.f3798a.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION");
    }

    protected final void m6793a(View view, int i, CustomViewCallback customViewCallback) {
        C0060c h = this.f3798a.m6649h();
        if (h == null) {
            C0099b.m5643d("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        h.m5479a(view, customViewCallback);
        h.m5477a(i);
    }

    protected boolean m6794a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            if (z) {
                ho.m6791a(context, builder, str2, str3, jsPromptResult);
            } else {
                ho.m6790a(builder, str2, jsResult);
            }
        } catch (Throwable e) {
            C0099b.m5642c("Fail to display Dialog.", e);
        }
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof hb) {
            C0060c h = ((hb) webView).m6649h();
            if (h == null) {
                C0099b.m5643d("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                h.m5476a();
                return;
            }
        }
        C0099b.m5643d("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (hv.f3806a[consoleMessage.messageLevel().ordinal()]) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                C0099b.m5639b(str);
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                C0099b.m5643d(str);
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                C0099b.m5641c(str);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                C0099b.m5636a(str);
                break;
            default:
                C0099b.m5641c(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.f3798a.m6652k());
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > 1048576) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(Math.min(131072, j4) + j, 1048576);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (callback != null) {
            callback.invoke(str, m6792a(), true);
        }
    }

    public final void onHideCustomView() {
        C0060c h = this.f3798a.m6649h();
        if (h == null) {
            C0099b.m5643d("Could not get ad overlay when hiding custom view.");
        } else {
            h.m5483b();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return m6794a(m6789a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return m6794a(m6789a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return m6794a(m6789a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return m6794a(m6789a(webView), str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        long j3 = 131072 + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        m6793a(view, -1, customViewCallback);
    }
}
