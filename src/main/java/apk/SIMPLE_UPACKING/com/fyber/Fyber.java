package com.fyber;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.fyber.cache.CacheManager;
import com.fyber.mediation.annotations.MediationAPI;
import com.fyber.p025a.Credentials;
import com.fyber.p027f.MediationCoordinator;
import com.fyber.p034b.ExecutorService;
import com.fyber.p042e.IdException;
import com.fyber.p044g.p045a.AppStartReporter;
import com.fyber.utils.AbstractHttpConnection;
import com.fyber.utils.Dispatchable;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.FyberPersistence;
import com.fyber.utils.HostInfo;
import com.fyber.utils.MapUtils;
import com.fyber.utils.StringUtils;
import com.fyber.utils.ag;
import com.fyber.utils.cookies.PersistentHttpCookieStore;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.lang.ref.WeakReference;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@MediationAPI(3)
public class Fyber {
    public static final String RELEASE_VERSION_STRING;
    private static Fyber f2410a;
    private final Context f2411b;
    private final WeakReference f2412c;
    private C0000a f2413d;
    private boolean f2414e;

    public class Settings {
        public static Settings f2397a;
        private Map f2398b;
        private boolean f2399c;
        private boolean f2400d;
        private boolean f2401e;
        private EnumMap f2402f;

        public enum UIStringIdentifier {
            ERROR_DIALOG_TITLE,
            DISMISS_ERROR_DIALOG,
            GENERIC_ERROR,
            ERROR_LOADING_OFFERWALL,
            ERROR_LOADING_OFFERWALL_NO_INTERNET_CONNECTION,
            LOADING_INTERSTITIAL,
            LOADING_OFFERWALL,
            ERROR_PLAY_STORE_UNAVAILABLE,
            RV_REWARD_NOTIFICATION,
            VCS_COINS_NOTIFICATION,
            VCS_DEFAULT_CURRENCY,
            RV_ERROR_DIALOG_TITLE,
            RV_ERROR_DIALOG_MESSAGE_DEFAULT,
            RV_ERROR_DIALOG_MESSAGE_OFFLINE,
            RV_ERROR_DIALOG_BUTTON_TITLE_DISMISS,
            RV_FORFEIT_DIALOG_TITLE,
            RV_CLICKTHROUGH_HINT,
            RV_ALERT_DIALOG_EXIT_VIDEO_TEXT,
            RV_ALERT_DIALOG_CLOSE_VIDEO_TEXT,
            RV_ALERT_DIALOG_RESUME_VIDEO_TEXT,
            RV_ALERT_DIALOG_TITLE,
            RV_ALERT_DIALOG_MESSAGE,
            RV_LOADING_MESSAGE
        }

        static {
            f2397a = new Settings();
        }

        private Settings() {
            this.f2399c = true;
            this.f2400d = true;
            this.f2401e = false;
            this.f2402f = new EnumMap(UIStringIdentifier.class);
            this.f2402f.put(UIStringIdentifier.ERROR_DIALOG_TITLE, "Error");
            this.f2402f.put(UIStringIdentifier.DISMISS_ERROR_DIALOG, "Dismiss");
            this.f2402f.put(UIStringIdentifier.GENERIC_ERROR, "An error happened when performing this operation");
            this.f2402f.put(UIStringIdentifier.ERROR_LOADING_OFFERWALL, "An error happened when loading the offer wall");
            this.f2402f.put(UIStringIdentifier.ERROR_LOADING_OFFERWALL_NO_INTERNET_CONNECTION, "An error happened when loading the offer wall (no internet connection)");
            this.f2402f.put(UIStringIdentifier.LOADING_INTERSTITIAL, "Loading...");
            this.f2402f.put(UIStringIdentifier.LOADING_OFFERWALL, "Loading...");
            this.f2402f.put(UIStringIdentifier.ERROR_PLAY_STORE_UNAVAILABLE, "You don't have the Google Play Store application on your device to complete App Install offers.");
            this.f2402f.put(UIStringIdentifier.RV_REWARD_NOTIFICATION, "Thanks! Your reward will be paid out shortly");
            this.f2402f.put(UIStringIdentifier.VCS_COINS_NOTIFICATION, "Congratulations! You've earned %.0f %s!");
            this.f2402f.put(UIStringIdentifier.VCS_DEFAULT_CURRENCY, "coins");
            this.f2402f.put(UIStringIdentifier.RV_ERROR_DIALOG_TITLE, "Error");
            this.f2402f.put(UIStringIdentifier.RV_ERROR_DIALOG_MESSAGE_DEFAULT, "We're sorry, something went wrong. Please try again.");
            this.f2402f.put(UIStringIdentifier.RV_ERROR_DIALOG_MESSAGE_OFFLINE, "Your Internet connection has been lost. Please try again later.");
            this.f2402f.put(UIStringIdentifier.RV_ERROR_DIALOG_BUTTON_TITLE_DISMISS, "Dismiss");
            this.f2402f.put(UIStringIdentifier.RV_FORFEIT_DIALOG_TITLE, "");
            this.f2402f.put(UIStringIdentifier.RV_CLICKTHROUGH_HINT, "Tap anywhere to discover more about this ad");
            this.f2402f.put(UIStringIdentifier.RV_ALERT_DIALOG_EXIT_VIDEO_TEXT, "Exit Video");
            this.f2402f.put(UIStringIdentifier.RV_ALERT_DIALOG_CLOSE_VIDEO_TEXT, "Close Video");
            this.f2402f.put(UIStringIdentifier.RV_ALERT_DIALOG_RESUME_VIDEO_TEXT, "Resume Video");
            this.f2402f.put(UIStringIdentifier.RV_ALERT_DIALOG_TITLE, "Error");
            this.f2402f.put(UIStringIdentifier.RV_ALERT_DIALOG_MESSAGE, "An error has occurred while trying to load the video");
            this.f2402f.put(UIStringIdentifier.RV_LOADING_MESSAGE, "Loading...");
        }

        public String getUserId() {
            return Fyber.getConfigs().m4845e().m4848b();
        }

        public Settings notifyUserOnCompletion(boolean z) {
            this.f2399c = z;
            return this;
        }

        public Settings notifyUserOnReward(boolean z) {
            this.f2400d = z;
            return this;
        }

        public Settings closeOfferWallOnRedirect(boolean z) {
            this.f2401e = z;
            return this;
        }

        public Settings addParameters(Map map) {
            if (MapUtils.m5321b(map)) {
                if (this.f2398b == null) {
                    this.f2398b = new HashMap();
                }
                this.f2398b.putAll(map);
            }
            return this;
        }

        public Settings addParameter(String str, String str2) {
            if (this.f2398b == null) {
                this.f2398b = new HashMap();
            }
            this.f2398b.put(str, str2);
            return this;
        }

        public Settings clearParameters() {
            if (this.f2398b != null) {
                this.f2398b.clear();
            }
            return this;
        }

        public Settings removeParameter(String str) {
            if (this.f2398b != null) {
                this.f2398b.remove(str);
            }
            return this;
        }

        public String getUIString(UIStringIdentifier uIStringIdentifier) {
            return (String) this.f2402f.get(uIStringIdentifier);
        }

        public Settings setCustomUIString(UIStringIdentifier uIStringIdentifier, String str) {
            this.f2402f.put(uIStringIdentifier, str);
            return this;
        }

        public Settings setCustomUIStrings(EnumMap enumMap) {
            for (Entry entry : enumMap.entrySet()) {
                setCustomUIString((UIStringIdentifier) entry.getKey(), (String) entry.getValue());
            }
            return this;
        }

        public Settings setCustomUIStrings(EnumMap enumMap, Context context) {
            for (Entry entry : enumMap.entrySet()) {
                setCustomUIString((UIStringIdentifier) entry.getKey(), ((Integer) entry.getValue()).intValue(), context);
            }
            return this;
        }

        public Settings setCustomUIString(UIStringIdentifier uIStringIdentifier, int i, Context context) {
            setCustomUIString(uIStringIdentifier, context.getString(i));
            return this;
        }
    }

    /* renamed from: com.fyber.Fyber.a */
    public final class C0000a {
        public static C0000a f2403a;
        static final Handler f2404b;
        private final Settings f2405c;
        private final HostInfo f2406d;
        private final ExecutorService f2407e;
        private Credentials f2408f;
        private Credentials f2409g;

        static {
            f2403a = new C0000a();
            f2404b = new Handler(Looper.getMainLooper(), new Fyber());
        }

        private C0000a() {
            this.f2405c = Settings.f2397a;
            this.f2406d = null;
            this.f2407e = null;
            this.f2408f = Credentials.f2415a;
        }

        private C0000a(String str, Context context) {
            if (HostInfo.m5287e()) {
                FyberPersistence.m5276a(context);
                this.f2405c = new Settings();
                this.f2407e = new ExecutorService();
                if (VERSION.SDK_INT < 21) {
                    CookieSyncManager.createInstance(context);
                }
                AbstractHttpConnection.m5262a(new PersistentHttpCookieStore(context));
            } else {
                if (FyberLogger.m5222a()) {
                    FyberLogger.m5226c("Fyber", "Only devices running Android API level 10 and above are supported");
                } else {
                    Log.i("Fyber", "Only devices running Android API level 10 and above are supported");
                }
                this.f2405c = Settings.f2397a;
                this.f2407e = null;
            }
            this.f2408f = Credentials.f2415a;
            this.f2409g = new Credentials(str).m4855b(ag.m5248a(context));
            this.f2406d = HostInfo.m5280a(context);
        }

        public final HostInfo m4838a() {
            return this.f2406d;
        }

        public final Settings m4842b() {
            return this.f2405c;
        }

        public final Map m4843c() {
            return this.f2405c.f2398b;
        }

        public final Future m4840a(Callable callable) {
            return this.f2407e.submit(callable);
        }

        public final void m4841a(Runnable runnable) {
            this.f2407e.execute(runnable);
        }

        public final boolean m4844d() {
            return this.f2408f != Credentials.f2415a;
        }

        public final Credentials m4845e() {
            return this.f2408f;
        }

        public final Object m4839a(String str) {
            Object obj = -1;
            switch (str.hashCode()) {
                case -1806042539:
                    if (str.equals("CLOSE_ON_REDIRECT")) {
                        obj = null;
                        break;
                    }
                    break;
                case -1153623547:
                    if (str.equals("SHOULD_NOTIFY_ON_USER_ENGAGED")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 87151057:
                    if (str.equals("NOTIFY_USER_ON_REWARD")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    return Boolean.valueOf(this.f2405c.f2401e);
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    return Boolean.valueOf(this.f2405c.f2400d);
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    return Boolean.valueOf(this.f2405c.f2399c);
                default:
                    return null;
            }
        }

        public static void m4835a(Dispatchable dispatchable) {
            f2404b.obtainMessage(10, dispatchable).sendToTarget();
        }
    }

    static {
        RELEASE_VERSION_STRING = String.format(Locale.ENGLISH, "%s", new Object[]{"8.1.3"});
    }

    private Fyber(String str, Activity activity) {
        this.f2414e = false;
        this.f2413d = new C0000a(activity.getApplicationContext(), (byte) 0);
        this.f2411b = activity.getApplicationContext();
        this.f2412c = new WeakReference(activity);
    }

    public static Fyber with(String str, Activity activity) {
        if (f2410a == null) {
            if (activity == null) {
                throw new IllegalArgumentException("Activity cannot be null.");
            } else if (StringUtils.m5259a(str)) {
                throw new IllegalArgumentException("App id cannot be null nor empty.");
            } else if (Credentials.m4846a(str)) {
                throw new IllegalArgumentException("Advertisers cannot start the sdk");
            } else {
                synchronized (Fyber.class) {
                    if (f2410a == null) {
                        f2410a = new Fyber(str, activity);
                    }
                }
            }
        } else if (!f2410a.f2414e) {
            f2410a.f2413d.f2409g.m4854a(str);
        }
        return f2410a;
    }

    public Fyber withUserId(String str) {
        if (!this.f2414e && StringUtils.m5260b(str)) {
            this.f2413d.f2409g.m4855b(str);
        }
        return this;
    }

    public Fyber withManualPrecaching() {
        if (!this.f2414e) {
            CacheManager.m5128b(this.f2411b);
        }
        return this;
    }

    public Fyber withSecurityToken(String str) {
        if (!this.f2414e) {
            this.f2413d.f2409g.m4856c(str);
        }
        return this;
    }

    public Fyber withParameters(Map map) {
        if (!this.f2414e) {
            this.f2413d.f2405c.addParameters(map);
        }
        return this;
    }

    public Settings start() {
        if (!this.f2414e && HostInfo.m5287e()) {
            this.f2413d.f2408f = this.f2413d.f2409g.m4853a();
            Credentials c = this.f2413d.f2408f;
            Activity activity = (Activity) this.f2412c.get();
            if (activity != null) {
                MediationCoordinator.f2739a.m5171a(activity);
            } else {
                FyberLogger.m5223b("Fyber", "There was an issue starting the adapters - the activity might have been closed.");
            }
            CacheManager.m5127a().m5131a(this.f2411b);
            try {
                AppStartReporter.m5181a(c.m4847a()).m5177a(this.f2411b);
            } catch (IdException e) {
            }
            this.f2414e = true;
        }
        return this.f2413d.f2405c;
    }

    public static C0000a getConfigs() {
        if (f2410a != null) {
            return f2410a.f2413d;
        }
        return C0000a.f2403a;
    }
}
