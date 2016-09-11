package android.support.v7.p017a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.p007b.PermissionChecker;
import android.util.Log;
import java.util.Calendar;

/* compiled from: TwilightManager */
/* renamed from: android.support.v7.a.ba */
class ba {
    private static final bc f1190a;
    private final Context f1191b;
    private final LocationManager f1192c;

    static {
        f1190a = new bc();
    }

    ba(Context context) {
        this.f1191b = context;
        this.f1192c = (LocationManager) context.getSystemService("location");
    }

    boolean m2937a() {
        bc bcVar = f1190a;
        if (m2935a(bcVar)) {
            return bcVar.f1193a;
        }
        Location b = m2936b();
        if (b != null) {
            m2934a(b);
            return bcVar.f1193a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    private Location m2936b() {
        Location a;
        Location location = null;
        if (PermissionChecker.m1301a(this.f1191b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            a = m2933a("network");
        } else {
            a = null;
        }
        if (PermissionChecker.m1301a(this.f1191b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m2933a("gps");
        }
        if (location == null || a == null) {
            if (location == null) {
                location = a;
            }
            return location;
        } else if (location.getTime() > a.getTime()) {
            return location;
        } else {
            return a;
        }
    }

    private Location m2933a(String str) {
        if (this.f1192c != null) {
            try {
                if (this.f1192c.isProviderEnabled(str)) {
                    return this.f1192c.getLastKnownLocation(str);
                }
            } catch (Throwable e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    private boolean m2935a(bc bcVar) {
        return bcVar != null && bcVar.f1198f > System.currentTimeMillis();
    }

    private void m2934a(Location location) {
        long j;
        bc bcVar = f1190a;
        long currentTimeMillis = System.currentTimeMillis();
        az a = az.m2931a();
        a.m2932a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f1186a;
        a.m2932a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f1188c == 1;
        long j3 = a.f1187b;
        long j4 = a.f1186a;
        a.m2932a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a.f1187b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j4) {
                j = 0 + j5;
            } else if (currentTimeMillis > j3) {
                j = 0 + j4;
            } else {
                j = 0 + j3;
            }
            j += 60000;
        }
        bcVar.f1193a = z;
        bcVar.f1194b = j2;
        bcVar.f1195c = j3;
        bcVar.f1196d = j4;
        bcVar.f1197e = j5;
        bcVar.f1198f = j;
    }
}
