package com.fyber.p046i;

import android.location.Location;
import android.location.LocationManager;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.fyber.Fyber;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.HostInfo;
import com.fyber.utils.StringUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.fyber.i.a */
public final class User extends HashMap {
    private static final User f2766g;
    private String f2767a;
    private boolean f2768b;
    private Set f2769c;
    private Location f2770d;
    private Location f2771e;
    private Calendar f2772f;

    public final /* synthetic */ Object put(Object obj, Object obj2) {
        return m5218a((String) obj, obj2);
    }

    static {
        f2766g = new User();
    }

    private User() {
        this.f2768b = false;
        this.f2769c = new HashSet();
        this.f2769c.add("age");
        this.f2769c.add("birthdate");
        this.f2769c.add("gender");
        this.f2769c.add("sexual_orientation");
        this.f2769c.add("ethnicity");
        this.f2769c.add("lat");
        this.f2769c.add("longt");
        this.f2769c.add("marital_status");
        this.f2769c.add("children");
        this.f2769c.add("annual_household_income");
        this.f2769c.add("education");
        this.f2769c.add("zipcode");
        this.f2769c.add("interests");
        this.f2769c.add("iap");
        this.f2769c.add("iap_amount");
        this.f2769c.add("number_of_sessions");
        this.f2769c.add("ps_time");
        this.f2769c.add("last_session");
        this.f2769c.add("connection");
        this.f2769c.add("device");
        this.f2769c.add("app_version");
    }

    public static String m5216a() {
        if (f2766g.f2768b) {
            String str;
            FyberLogger.m5223b("User", "User data has changed, recreating...");
            User user = f2766g;
            HostInfo a = Fyber.getConfigs().m4838a();
            if (a != null) {
                LocationManager f = a.m5301f();
                if (user.f2770d == null && f != null) {
                    Calendar instance = Calendar.getInstance();
                    if (user.f2772f == null || instance.after(user.f2772f)) {
                        for (String str2 : a.m5302g()) {
                            Location lastKnownLocation = f.getLastKnownLocation(str2);
                            if (lastKnownLocation != null) {
                                if (user.f2771e == null) {
                                    user.f2771e = lastKnownLocation;
                                }
                                if (user.f2771e != null && user.f2771e.getTime() < lastKnownLocation.getTime()) {
                                    user.f2771e = lastKnownLocation;
                                }
                            }
                        }
                        if (user.f2771e != null) {
                            Calendar instance2 = Calendar.getInstance();
                            instance2.add(5, -1);
                            if (user.f2771e.getTime() > instance2.getTimeInMillis()) {
                                user.m5217a(user.f2771e);
                                user.f2772f = instance;
                                user.f2772f.add(12, 10);
                            }
                        }
                    }
                }
            }
            Builder builder = new Builder();
            for (Entry entry : f2766g.entrySet()) {
                String format;
                str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Date) {
                    format = String.format(Locale.ENGLISH, "%tY/%tm/%td", new Object[]{value, value, value});
                } else if (value instanceof String[]) {
                    format = TextUtils.join(",", (String[]) value);
                } else if (value instanceof Location) {
                    Location location = (Location) value;
                    format = "latitude:" + Location.convert(location.getLatitude(), 0) + ",longitude:" + Location.convert(location.getLongitude(), 0) + ",accuracy:" + location.getAccuracy();
                } else {
                    format = value.toString();
                }
                builder.appendQueryParameter(str2, format);
            }
            str2 = builder.build().toString();
            f2766g.f2767a = str2.substring(1, str2.length());
            FyberLogger.m5223b("User", "FybUSer data - " + f2766g.f2767a);
            f2766g.f2768b = false;
        }
        return f2766g.f2767a;
    }

    public final Object m5218a(String str, Object obj) {
        if (!StringUtils.m5260b(str) || obj == null) {
            return null;
        }
        if (!this.f2768b) {
            Object obj2 = get(str);
            boolean z = obj2 == null || !obj2.equals(obj);
            this.f2768b = z;
        }
        return super.put(str, obj);
    }

    public final Object remove(Object obj) {
        Object remove = super.remove(obj);
        this.f2768b = remove != null;
        return remove;
    }

    private void m5217a(Location location) {
        if (location != null) {
            m5218a("lat", Location.convert(location.getLatitude(), 0));
            m5218a("longt", Location.convert(location.getLongitude(), 0));
            return;
        }
        remove("lat");
        remove("longt");
    }
}
