package com.fyber.ads.videos;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.WindowManager.BadTokenException;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.fyber.Fyber;
import com.fyber.Fyber.C0000a;
import com.fyber.Fyber.Settings.UIStringIdentifier;
import com.fyber.ads.videos.p031a.RewardedVideoPlayerView;
import com.fyber.ads.videos.p033b.RewardedVideoMediationJSInterface;
import com.fyber.cache.CacheManager;
import com.fyber.cache.p039a.CacheStatistics;
import com.fyber.p028h.VirtualCurrencyRequester;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.StringUtils;
import com.fyber.utils.ad;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.fyber.ads.videos.d */
public final class RewardedVideoClient implements RewardedVideoPlayerView {
    public static final RewardedVideoClient f2580a;
    private Handler f2581b;
    private Handler f2582c;
    private RewardedVideoActivity f2583d;
    private Context f2584e;
    private WebView f2585f;
    private boolean f2586g;
    private String f2587h;
    private Map f2588i;
    private boolean f2589j;
    private RewardedVideoOffersStatus f2590k;
    private VirtualCurrencyRequester f2591l;
    private RewardedVideoClientStatusListener f2592m;
    private WebViewClient f2593n;
    private RewardedVideoPlayerView f2594o;
    private RewardedVideoMediationJSInterface f2595p;
    private boolean f2596q;

    static {
        f2580a = new RewardedVideoClient();
    }

    private RewardedVideoClient() {
        this.f2586g = false;
        this.f2589j = true;
        this.f2590k = RewardedVideoOffersStatus.MUST_QUERY_SERVER_FOR_OFFERS;
        this.f2596q = false;
        HandlerThread handlerThread = new HandlerThread("RVTimer", 1);
        handlerThread.start();
        this.f2581b = new Handler(handlerThread.getLooper(), new RewardedVideoClient(this));
        this.f2582c = new Handler(Looper.getMainLooper(), new RewardedVideoClient(this));
        this.f2595p = new RewardedVideoMediationJSInterface();
    }

    public final boolean m5001a(RewardedVideoActivity rewardedVideoActivity, boolean z) {
        if (rewardedVideoActivity == null) {
            FyberLogger.m5223b("RewardedVideoClient", "The provided activity is null, RewardedVideoClient cannot start the engagement.");
        } else if (this.f2590k.m5010a()) {
            String str = "";
            if (CacheManager.m5127a().m5134b() != null) {
                str = String.format(Locale.ENGLISH, ", cache_config_id:'%s'", new Object[]{CacheManager.m5127a().m5134b().m5081a()});
            }
            r5 = new Object[3];
            CacheManager.m5127a().m5137d();
            r5[0] = CacheStatistics.m5100d();
            r5[1] = Integer.valueOf(CacheManager.m5127a().m5137d().m5102a());
            r5[2] = str;
            str = String.format(Locale.ENGLISH, "javascript:Sponsorpay.MBE.SDKInterface.do_start({cached_ad_ids:%s, downloaded_videos_count:%d%s})", r5);
            FyberLogger.m5226c("RewardedVideoClient", str);
            m4990b(str);
            CacheManager.m5127a().m5137d().m5104c();
            this.f2583d = rewardedVideoActivity;
            if (!z) {
                Fyber.getConfigs();
                C0000a.m4835a(new RewardedVideoClient(this, rewardedVideoActivity));
            }
            this.f2581b.sendEmptyMessageDelayed(1, 10000);
            return true;
        } else {
            FyberLogger.m5223b("RewardedVideoClient", "RewardedVideoClient is not ready to show offers. Call requestOffers() and wait until your listener is called with the confirmation that offers have been received.");
        }
        return false;
    }

    public final void m5003b() {
        if (!this.f2590k.equals(RewardedVideoOffersStatus.USER_ENGAGED) && !this.f2590k.equals(RewardedVideoOffersStatus.SHOWING_OFFERS)) {
            return;
        }
        if (this.f2590k == RewardedVideoOffersStatus.USER_ENGAGED) {
            m4986a("CLOSE_FINISHED");
        } else {
            m4986a("CLOSE_ABORTED");
        }
    }

    public final boolean m5004c() {
        return this.f2590k.m5010a();
    }

    private void m4986a(String str) {
        if (str.equals("STARTED")) {
            this.f2581b.removeMessages(1);
            if (m4988a(RewardedVideoOffersStatus.SHOWING_OFFERS)) {
                m4985a(RewardedVideoClientStatusListener.STARTED);
            }
        } else if (str.equals("CLOSE_FINISHED")) {
            if (this.f2591l != null) {
                this.f2581b.postDelayed(new RewardedVideoClient(this, (VirtualCurrencyRequester) VirtualCurrencyRequester.m5210a(this.f2591l).m5197b(this.f2587h)), 3000);
            }
            m4997g();
            m4985a(RewardedVideoClientStatusListener.CLOSE_FINISHED);
            if (this.f2589j) {
                Toast.makeText(this.f2584e, ad.m5234a(UIStringIdentifier.RV_REWARD_NOTIFICATION), 1).show();
            }
        } else if (str.equals("CLOSE_ABORTED")) {
            this.f2581b.removeMessages(1);
            m4997g();
            m4985a(RewardedVideoClientStatusListener.CLOSE_ABORTED);
        } else if (str.equals("ERROR")) {
            m4992c(ad.m5234a(UIStringIdentifier.RV_ERROR_DIALOG_MESSAGE_DEFAULT));
        } else if (str.equals("USER_ENGAGED")) {
            m4988a(RewardedVideoOffersStatus.USER_ENGAGED);
        }
    }

    private void m4997g() {
        if (this.f2585f != null) {
            m4990b("about:blank");
        }
        if (this.f2594o != null) {
            this.f2594o.m4977c();
        }
        this.f2591l = null;
        this.f2588i = null;
        this.f2587h = null;
        m4988a(RewardedVideoOffersStatus.MUST_QUERY_SERVER_FOR_OFFERS);
    }

    private void m4990b(String str) {
        if (StringUtils.m5260b(str)) {
            Message obtain = Message.obtain(this.f2582c);
            obtain.what = 123;
            obtain.obj = str;
            obtain.sendToTarget();
        }
    }

    public final boolean m5002a(RewardedVideoClientStatusListener rewardedVideoClientStatusListener) {
        this.f2592m = rewardedVideoClientStatusListener;
        return true;
    }

    private void m4985a(RewardedVideoClientStatusListener rewardedVideoClientStatusListener) {
        if (this.f2592m != null) {
            FyberLogger.m5226c("RewardedVideoClient", "RewardedVideoClientStatus -> " + rewardedVideoClientStatusListener);
            this.f2592m.m4924a(rewardedVideoClientStatusListener);
        }
    }

    public final void m5000a(ValueCallback valueCallback) {
        this.f2595p.m4979a(this.f2585f, valueCallback);
    }

    private void m4992c(String str) {
        if (!this.f2586g && this.f2585f != null) {
            this.f2586g = true;
            Builder builder = new Builder(this.f2583d == null ? this.f2584e : this.f2583d);
            builder.setTitle(ad.m5234a(UIStringIdentifier.RV_ERROR_DIALOG_TITLE)).setMessage(str).setNeutralButton(ad.m5234a(UIStringIdentifier.RV_ERROR_DIALOG_BUTTON_TITLE_DISMISS), new RewardedVideoClient(this));
            try {
                builder.show();
            } catch (BadTokenException e) {
                this.f2586g = false;
                FyberLogger.m5220a("RewardedVideoClient", "Unable to show the dialog window");
            }
        }
    }

    private boolean m4988a(RewardedVideoOffersStatus rewardedVideoOffersStatus) {
        if (this.f2590k == rewardedVideoOffersStatus || rewardedVideoOffersStatus.ordinal() - this.f2590k.ordinal() > 1) {
            return false;
        }
        this.f2590k = rewardedVideoOffersStatus;
        FyberLogger.m5223b("RewardedVideoClient", "RewardedVideoClient mStatus -> " + rewardedVideoOffersStatus.name());
        return true;
    }

    public final void m5005d() {
        Message obtain = Message.obtain(this.f2582c);
        obtain.what = 522;
        obtain.sendToTarget();
    }

    public final void m4999a() {
        this.f2594o = null;
        this.f2596q = true;
    }

    public final void m5006e() {
        if (this.f2596q && this.f2590k == RewardedVideoOffersStatus.MUST_QUERY_SERVER_FOR_OFFERS) {
            m4985a(RewardedVideoClientStatusListener.CLOSE_ABORTED);
        }
    }

    public final void m5007f() {
        if (this.f2590k == RewardedVideoOffersStatus.SHOWING_OFFERS) {
            FyberLogger.m5220a("RewardedVideoClient", "Connection has been lost");
            this.f2581b.post(new RewardedVideoClient(this));
        }
    }

    static /* synthetic */ void m4982a(RewardedVideoClient rewardedVideoClient, int i) {
        rewardedVideoClient.f2581b.removeMessages(2);
        boolean z = i > 0;
        if (z) {
            rewardedVideoClient.m4988a(RewardedVideoOffersStatus.READY_TO_SHOW_OFFERS);
        } else {
            rewardedVideoClient.m4997g();
        }
        if (rewardedVideoClient.f2592m != null) {
            rewardedVideoClient.f2592m.m4925a(z);
        }
    }

    static /* synthetic */ void m4995f(RewardedVideoClient rewardedVideoClient) {
        if (rewardedVideoClient.f2585f != null && rewardedVideoClient.f2594o == null) {
            try {
                Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(rewardedVideoClient.f2585f, null);
            } catch (Exception e) {
                FyberLogger.m5221a("RewardedVideoClient", "onPause error", e);
            }
        }
    }
}
