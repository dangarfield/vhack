package com.fyber.ads.videos.p031a;

import android.os.Handler;
import android.os.Message;
import com.fyber.Fyber.Settings.UIStringIdentifier;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.ad;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.lang.ref.WeakReference;

/* renamed from: com.fyber.ads.videos.a.i */
final class RewardedVideoPlayerView extends Handler {
    private final WeakReference f2569a;

    public final void handleMessage(Message message) {
        int i = NativeVideoPlayerUIThreadActions.m4947a()[message.what];
        RewardedVideoPlayerView rewardedVideoPlayerView = (RewardedVideoPlayerView) this.f2569a.get();
        if (rewardedVideoPlayerView != null) {
            switch (RewardedVideoPlayerView.f2572b[i - 1]) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    rewardedVideoPlayerView.removeView(rewardedVideoPlayerView.f2542H);
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    RewardedVideoPlayerView.m4956c(rewardedVideoPlayerView);
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    rewardedVideoPlayerView.m4967i();
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    if (rewardedVideoPlayerView.f2552j != null) {
                        rewardedVideoPlayerView.f2552j.m5066a(rewardedVideoPlayerView.f2558p);
                    }
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    rewardedVideoPlayerView.f2566x = true;
                    rewardedVideoPlayerView.m4963g();
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    RewardedVideoPlayerView.m4968i(rewardedVideoPlayerView);
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    rewardedVideoPlayerView.m4967i();
                    rewardedVideoPlayerView.m4954a(ad.m5234a(UIStringIdentifier.RV_ALERT_DIALOG_TITLE), ad.m5234a(UIStringIdentifier.RV_ERROR_DIALOG_MESSAGE_DEFAULT), "OK", null);
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    FyberLogger.m5226c("RewardedVideoPlayerView", "displayErrorLoadingDialog(): Error Loading video");
                    rewardedVideoPlayerView.f2557o = true;
                    rewardedVideoPlayerView.m4954a(ad.m5234a(UIStringIdentifier.RV_ALERT_DIALOG_TITLE), ad.m5234a(UIStringIdentifier.RV_ALERT_DIALOG_MESSAGE), "OK", null);
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    rewardedVideoPlayerView.m4962f();
                default:
            }
        }
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    rientation) {
            this.f2535A++;
            if (this.f2535A == 6) {
                this.f2535A = 0;
                this.f2536B = orientation;
            }
        } else if (!this.f2541G) {
            if (this.f2546d.isPlaying() || VERSION.SDK_INT >= 21) {
                if (this.f2558p > this.f2547e + 500) {
                    onCompletion(null);
                }
                this.f2558p = (long) this.f2545c.getCurrentPosition();
                if (((Boolean) this.f2542H.getTag()).booleanValue() && this.f2558p > 120) {
                    this.f2542H.setTag(Boolean.valueOf(false));
                    m4950a(NativeVideoPlayerUIThreadActions.f2532h);
                }
                this.f2562t++;
                if (this.f2562t == 20) {
                    this.f2562t = 0;
                }
                if ((this.f2562t != 0 && this.f2562t != 10) || !this.f2537C.m4936a(this.f2558p, this.f2539E, m4973l())) {
                    m4950a(NativeVideoPlayerUIThreadActions.f2527c);
                    if (this.f2562t == 0) {
                        this.f2564v.m4938a(m4949a(NativeVideoPlayerEvent.TimeUpdateEvent, this.f2558p, this.f2544b));
                    }
                    if (this.f2556n != null && ((Boolean) this.f2556n.getTag()).booleanValue() && this.f2558p > this.f2553k) {
                        m4950a(NativeVideoPlayerUIThreadActions.f2529e);
                    }
                    if (this.f2550h != null && ((Boolean) this.f2550h.getTag()).booleanValue() && this.f2558p > ((long) this.f2551i.intValue())) {
                        m4950a(NativeVideoPlayerUIThreadActions.f2528d);
                    }
                }
            }
        }
    }

    public final void m4977c() {
        m4953a("forceClose");
    }

    private void m4953a(String str) {
        if (!this.f2567y) {
            String a = m4949a(NativeVideoPlayerEvent.CancelEvent, -1, this.f2544b);
            FyberLogger.m5223b("RewardedVideoPlayerView", str);
            this.f2564v.m4938a(a);
            m4971k();
            m4957d();
            m4960e();
        }
    }

    private void m4960e() {
        this.f2568z = true;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m4962f();
        } else {
            m4950a(NativeVideoPlayerUIThreadActions.f2533i);
        }
        this.f2545c = null;
        this.f2556n = null;
        this.f2550h = null;
        this.f2552j = null;
        this.f2546d = null;
        this.f2549g = null;
        if (this.f2561s != null) {
            this.f2561s.m4942a();
            this.f2561s = null;
        }
        if (this.f2538D != null) {
            this.f2538D.m4978a();
            this.f2538D = null;
        }
        this.f2543a = null;
    }

    private void m4962f() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        if (this.f2549g != null) {
            this.f2549g.m5067a();
        }
    }

    private String m4949a(NativeVideoPlayerEvent nativeVideoPlayerEvent, long j, String str) {
        switch (RewardedVideoPlayerView.f2571a[nativeVideoPlayerEvent.ordinal()]) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return String.format(Locale.ENGLISH, "%s('play', {tpn:'%s', result:'%s', duration:'%.2f', id:'%s'})", new Object[]{"javascript:Sponsorpay.MBE.SDKInterface.notify", "local", nativeVideoPlayerEvent, Double.valueOf(this.f2548f), Uri.parse(str).toString()});
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                double toSeconds = (double) TimeUnit.MILLISECONDS.toSeconds(j);
                return String.format(Locale.ENGLISH, "%s('play', {tpn:'%s', result:'%s', currentTime:'%.3f', duration:'%.2f', id:'%s'})", new Object[]{"javascript:Sponsorpay.MBE.SDKInterface.notify", "local", nativeVideoPlayerEvent, Double.valueOf(toSeconds), Double.valueOf(this.f2548f), Uri.parse(str).toString()});
            default:
                return String.format("%s('play', {tpn:'%s', result:'%s', id:'%s'})", new Object[]{"javascript:Sponsorpay.MBE.SDKInterface.notify", "local", nativeVideoPlayerEvent, Uri.parse(str).toString()});
        }
    }

    private void m4963g() {
        this.f2550h.setTag(Boolean.valueOf(false));
        addView(this.f2550h);
    }

    private int m4965h() {
        Exception e;
        try {
            int i = this.f2543a.getPackageManager().getApplicationInfo(this.f2543a.getPackageName(), 128).metaData.getInt("FYBVideoPlayerOptionCloseButtonDelay", 0) * 1000;
            FyberLogger.m5223b("RewardedVideoPlayerView", "Delay for close button - " + i + "ms");
            if (i >= 0) {
                return i;
            }
            return 0;
        } catch (NameNotFoundException e2) {
            e = e2;
            FyberLogger.m5220a("RewardedVideoPlayerView", "Failed to load meta-data from Manifest: " + e.getMessage());
            return 0;
        } catch (NullPointerException e3) {
            e = e3;
            FyberLogger.m5220a("RewardedVideoPlayerView", "Failed to load meta-data from Manifest: " + e.getMessage());
            return 0;
        }
    }

    private void m4967i() {
        if (this.f2549g != null) {
            this.f2549g.setVisibility(8);
        }
    }

    private void m4969j() {
        if (this.f2559q) {
            this.f2546d.pause();
            this.f2540F = true;
            m4954a(ad.m5234a(UIStringIdentifier.RV_ALERT_DIALOG_EXIT_VIDEO_TEXT), this.f2560r, ad.m5234a(UIStringIdentifier.RV_ALERT_DIALOG_CLOSE_VIDEO_TEXT), ad.m5234a(UIStringIdentifier.RV_ALERT_DIALOG_RESUME_VIDEO_TEXT));
            return;
        }
        m4953a("displayCloseAlertDialog without alert");
    }

    public final void m4974a(boolean z) {
        FyberLogger.m5226c("RewardedVideoPlayerView", "onBufferingStateChanged - state = " + z);
        if (z) {
            m4950a(NativeVideoPlayerUIThreadActions.f2526b);
            if (VERSION.SDK_INT >= 21) {
                this.f2546d.pause();
                this.f2539E = false;
                return;
            }
            return;
        }
        m4950a(NativeVideoPlayerUIThreadActions.f2525a);
        if (!m4973l()) {
            this.f2546d.start();
        }
        if (VERSION.SDK_INT >= 21) {
            this.f2539E = true;
        }
    }

    private void m4954a(String str, String str2, String str3, String str4) {
        if (!this.f2543a.isFinishing()) {
            Builder builder = new Builder(this.f2543a);
            if (StringUtils.m5260b(str4)) {
                builder.setPositiveButton(str4, this);
            }
            builder.setTitle(str).setMessage(str2).setCancelable(false).setNegativeButton(str3, this).create().show();
        }
    }

    private void m4971k() {
        this.f2565w.removeMessages(NativeVideoPlayerUIThreadActions.f2531g - 1);
    }

    private void m4950a(int i) {
        this.f2565w.sendEmptyMessage(i - 1);
    }

    private boolean m4973l() {
        return this.f2554l || this.f2540F;
    }

    private static void m4951a(View view, boolean z) {
        if (view != null) {
            view.setClickable(z);
        }
    }

    static /* synthetic */ void m4956c(RewardedVideoPlayerView rewardedVideoPlayerView) {
        if (rewardedVideoPlayerView.f2549g != null) {
            rewardedVideoPlayerView.f2549g.setVisibility(0);
        }
    }

    static /* synthetic */ void m4968i(RewardedVideoPlayerView rewardedVideoPlayerView) {
        rewardedVideoPlayerView.f2556n.setTag(Boolean.valueOf(false));
        Animation alphaAnimation = new AlphaAnimation(0.7f, 0.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setAnimationListener(new RewardedVideoPlayerView(rewardedVideoPlayerView));
        rewardedVideoPlayerView.f2556n.startAnimation(alphaAnimation);
    }
}
