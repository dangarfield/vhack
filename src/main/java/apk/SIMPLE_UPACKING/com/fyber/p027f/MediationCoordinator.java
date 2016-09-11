package com.fyber.p027f;

import android.app.Activity;
import com.fyber.Fyber;
import com.fyber.p025a.Credentials;
import com.fyber.p027f.p043a.ExchangeAdapter;
import com.fyber.p034b.MediationConfigurationNetworkOperation;
import com.fyber.utils.Dispatchable;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.StringUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.Future;

/* renamed from: com.fyber.f.g */
final class MediationCoordinator extends Dispatchable {
    final /* synthetic */ Activity f2743a;
    final /* synthetic */ MediationCoordinator f2744b;

    MediationCoordinator(MediationCoordinator mediationCoordinator, Activity activity) {
        this.f2744b = mediationCoordinator;
        this.f2743a = activity;
    }

    public final void m5174a() {
        Exception e;
        try {
            Class cls = Class.forName("com.fyber.mediation.MediationAdapterStarter");
            if (((Integer) cls.getMethod("getAdaptersCount", new Class[0]).invoke(null, new Object[0])).intValue() > 0) {
                Future a;
                Credentials e2 = Fyber.getConfigs().m4845e();
                if (StringUtils.m5260b(e2.m4849c())) {
                    a = MediationConfigurationNetworkOperation.m5027a(e2, this.f2743a);
                } else {
                    a = null;
                }
                this.f2744b.f2741c.putAll((Map) cls.getMethod("startAdapters", new Class[]{Activity.class, Future.class}).invoke(null, new Object[]{this.f2743a, a}));
            } else {
                FyberLogger.m5223b("MediationCoordinator", "No mediation adapters to start");
            }
        } catch (ClassNotFoundException e3) {
            FyberLogger.m5223b("MediationCoordinator", "There was an issue starting mediation for this session");
            FyberLogger.m5223b("MediationCoordinator", "MediationAdapterStarter class was not found. (if you're currently not using mediation, disregard this message)\nIt could mean that there's a proguard entry missing - \"-keep class com.fyber.mediation.MediationAdapterStarter { *;}\"\nOr the annotation processor did not run at compile time.");
        } catch (NoSuchMethodException e4) {
            e = e4;
            FyberLogger.m5223b("MediationCoordinator", "There was an issue starting mediation for this session - " + e.getMessage());
            FyberLogger.m5223b("MediationCoordinator", "Make sure you're currently using 'fyber-annotations-compiler' 1.1.+ \nand that you have following proguard entry - \"-keep class com.fyber.mediation.MediationAdapterStarter { *;}\"");
        } catch (IllegalAccessException e5) {
            e = e5;
            FyberLogger.m5223b("MediationCoordinator", "There was an issue starting mediation for this session - " + e.getMessage());
            FyberLogger.m5223b("MediationCoordinator", "Make sure you're currently using 'fyber-annotations-compiler' 1.1.+ \nand that you have following proguard entry - \"-keep class com.fyber.mediation.MediationAdapterStarter { *;}\"");
        } catch (InvocationTargetException e6) {
            e = e6;
            FyberLogger.m5223b("MediationCoordinator", "There was an issue starting mediation for this session - " + e.getMessage());
            FyberLogger.m5223b("MediationCoordinator", "Make sure you're currently using 'fyber-annotations-compiler' 1.1.+ \nand that you have following proguard entry - \"-keep class com.fyber.mediation.MediationAdapterStarter { *;}\"");
        }
        this.f2744b.f2741c.put("Fyber", new ExchangeAdapter());
    }
}
