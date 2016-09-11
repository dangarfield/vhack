package com.fyber.p034b;

import android.content.Context;
import android.os.Handler;
import com.fyber.Fyber;
import com.fyber.Fyber.C0000a;
import com.fyber.Fyber.Settings.UIStringIdentifier;
import com.fyber.p028h.VirtualCurrencyCallback;
import com.fyber.p040d.VirtualCurrencyErrorResponse;
import com.fyber.p040d.VirtualCurrencyResponse;
import com.fyber.p040d.p041a.VirtualCurrencyCache;
import com.fyber.p040d.p041a.VirtualCurrencyPrefManager;
import com.fyber.utils.Dispatchable;
import com.fyber.utils.FyberLogger;
import com.fyber.utils.StringUtils;
import com.fyber.utils.ad;
import com.fyber.utils.ae;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.fyber.b.j */
public final class VirtualCurrencyNetworkOperation extends SignedResponseNetworkOperation {
    private static final VirtualCurrencyCache f2627c;
    private final VirtualCurrencyCallback f2628d;
    private boolean f2629e;
    private String f2630f;
    private String f2631g;
    private String f2632h;
    private Context f2633i;
    private Handler f2634j;
    private boolean f2635k;

    protected final /* synthetic */ Object m5050a(Object obj) {
        VirtualCurrencyNetworkOperation virtualCurrencyNetworkOperation = (VirtualCurrencyNetworkOperation) obj;
        if (virtualCurrencyNetworkOperation instanceof VirtualCurrencyResponse) {
            int i;
            VirtualCurrencyResponse virtualCurrencyResponse = (VirtualCurrencyResponse) virtualCurrencyNetworkOperation;
            VirtualCurrencyPrefManager a = VirtualCurrencyPrefManager.m5153a(this.f2633i);
            String a2 = a.m5155a();
            String c = virtualCurrencyResponse.m5161c();
            if (StringUtils.m5259a(this.f2630f) && StringUtils.m5260b(a2) && !a2.equalsIgnoreCase(c)) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                a.m5157a(c);
                a2 = a.m5158b(c);
                Callable virtualCurrencyNetworkOperation2 = new VirtualCurrencyNetworkOperation(this);
                virtualCurrencyNetworkOperation2.m5056d(a2);
                virtualCurrencyNetworkOperation2.a.m5240a("currency_id", this.f2630f);
                Fyber.getConfigs().m4840a(virtualCurrencyNetworkOperation2);
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                a2 = VirtualCurrencyPrefManager.m5153a(this.f2633i).m5155a();
                String c2 = virtualCurrencyResponse.m5161c();
                f2627c.m5148a(new VirtualCurrencyResponse(0.0d, virtualCurrencyResponse.m5160b(), c2, virtualCurrencyResponse.m5162d(), virtualCurrencyResponse.m5163e()), c2, a2);
                VirtualCurrencyPrefManager.m5153a(this.f2633i).m5156a(virtualCurrencyResponse);
                if (virtualCurrencyResponse.m5159a() > 0.0d && this.f2629e) {
                    a2 = virtualCurrencyResponse.m5162d();
                    if (!StringUtils.m5260b(a2)) {
                        a2 = ad.m5234a(UIStringIdentifier.VCS_DEFAULT_CURRENCY);
                    }
                    m5041a(new VirtualCurrencyNetworkOperation(this, String.format(Locale.ENGLISH, ad.m5234a(UIStringIdentifier.VCS_COINS_NOTIFICATION), new Object[]{Double.valueOf(virtualCurrencyResponse.m5159a()), a2})));
                }
                m5040a(virtualCurrencyResponse);
            }
        } else {
            VirtualCurrencyErrorResponse virtualCurrencyErrorResponse = (VirtualCurrencyErrorResponse) virtualCurrencyNetworkOperation;
            String a3 = VirtualCurrencyPrefManager.m5153a(this.f2633i).m5155a();
            f2627c.m5148a(virtualCurrencyErrorResponse, StringUtils.m5259a(this.f2630f) ? a3 : this.f2630f, a3);
            m5039a(virtualCurrencyErrorResponse);
        }
        return null;
    }

    protected final /* synthetic */ Object m5051a(String str) {
        return VirtualCurrencyNetworkOperation.m5043e(str);
    }

    static {
        f2627c = new VirtualCurrencyCache();
    }

    private VirtualCurrencyNetworkOperation(VirtualCurrencyNetworkOperation virtualCurrencyNetworkOperation) {
        super(virtualCurrencyNetworkOperation.a, virtualCurrencyNetworkOperation.b);
        this.f2635k = true;
        this.f2628d = virtualCurrencyNetworkOperation.f2628d;
        this.f2633i = virtualCurrencyNetworkOperation.f2633i;
        this.f2629e = virtualCurrencyNetworkOperation.f2629e;
        this.f2630f = virtualCurrencyNetworkOperation.f2630f;
        this.f2631g = virtualCurrencyNetworkOperation.f2631g;
        this.f2632h = virtualCurrencyNetworkOperation.f2632h;
        this.f2634j = virtualCurrencyNetworkOperation.f2634j;
        this.f2635k = false;
    }

    public VirtualCurrencyNetworkOperation(ae aeVar, VirtualCurrencyCallback virtualCurrencyCallback, String str, Context context) {
        super(aeVar, str);
        this.f2635k = true;
        this.f2628d = virtualCurrencyCallback;
        this.f2633i = context.getApplicationContext();
    }

    public final VirtualCurrencyNetworkOperation m5047a(boolean z) {
        this.f2629e = z;
        return this;
    }

    public final VirtualCurrencyNetworkOperation m5046a(Map map) {
        this.a.m5241a(map);
        return this;
    }

    public final VirtualCurrencyNetworkOperation m5053b(String str) {
        if (StringUtils.m5260b(str)) {
            this.f2630f = str;
            this.a.m5240a("currency_id", str);
        }
        return this;
    }

    public final VirtualCurrencyNetworkOperation m5055c(String str) {
        this.f2631g = str;
        this.a.m5239a(str);
        return this;
    }

    public final VirtualCurrencyNetworkOperation m5056d(String str) {
        this.f2632h = str;
        this.a.m5240a("ltid", str);
        return this;
    }

    public final VirtualCurrencyNetworkOperation m5045a(Handler handler) {
        this.f2634j = handler;
        return this;
    }

    private void m5041a(Dispatchable dispatchable) {
        if (this.f2634j != null) {
            this.f2634j.post(dispatchable);
            return;
        }
        Fyber.getConfigs();
        C0000a.m4835a(dispatchable);
    }

    private static VirtualCurrencyNetworkOperation m5043e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new VirtualCurrencyResponse(jSONObject.getDouble("delta_of_coins"), jSONObject.getString("latest_transaction_id"), jSONObject.getString("currency_id"), jSONObject.getString("currency_name"), jSONObject.getBoolean("is_default"));
        } catch (Exception e) {
            return new VirtualCurrencyErrorResponse(VirtualCurrencyErrorResponse.ERROR_INVALID_RESPONSE, null, e.getMessage());
        }
    }

    private static VirtualCurrencyErrorResponse m5044f(String str) {
        String string;
        String string2;
        VirtualCurrencyErrorResponse virtualCurrencyErrorResponse;
        Exception exception;
        try {
            JSONObject jSONObject = new JSONObject(str);
            string = jSONObject.getString("code");
            try {
                string2 = jSONObject.getString("message");
                virtualCurrencyErrorResponse = VirtualCurrencyErrorResponse.SERVER_RETURNED_ERROR;
            } catch (Exception e) {
                exception = e;
                FyberLogger.m5224b("VirtualCurrencyNetworkOperation", "An exception was triggered while parsing error response", exception);
                virtualCurrencyErrorResponse = VirtualCurrencyErrorResponse.ERROR_OTHER;
                string2 = exception.getMessage();
                return new VirtualCurrencyErrorResponse(virtualCurrencyErrorResponse, string, string2);
            }
        } catch (Exception e2) {
            exception = e2;
            string = null;
            FyberLogger.m5224b("VirtualCurrencyNetworkOperation", "An exception was triggered while parsing error response", exception);
            virtualCurrencyErrorResponse = VirtualCurrencyErrorResponse.ERROR_OTHER;
            string2 = exception.getMessage();
            return new VirtualCurrencyErrorResponse(virtualCurrencyErrorResponse, string, string2);
        }
        return new VirtualCurrencyErrorResponse(virtualCurrencyErrorResponse, string, string2);
    }

    protected final boolean m5052a() {
        if (this.f2635k) {
            VirtualCurrencyPrefManager a = VirtualCurrencyPrefManager.m5153a(this.f2633i);
            VirtualCurrencyNetworkOperation a2 = f2627c.m5147a(this.f2630f, a.m5155a());
            if (a2 == null || a2.equals(VirtualCurrencyCache.f2713a)) {
                String str = this.f2632h;
                if (StringUtils.m5259a(str)) {
                    str = a.m5158b(this.f2630f);
                }
                this.a.m5240a("ltid", str);
            } else {
                if (a2 instanceof VirtualCurrencyResponse) {
                    m5040a((VirtualCurrencyResponse) a2);
                } else {
                    m5039a((VirtualCurrencyErrorResponse) a2);
                }
                return false;
            }
        }
        return true;
    }

    protected final String m5054b() {
        return "VirtualCurrencyNetworkOperation";
    }

    private void m5039a(VirtualCurrencyErrorResponse virtualCurrencyErrorResponse) {
        m5041a(new VirtualCurrencyNetworkOperation(this, virtualCurrencyErrorResponse));
    }

    private void m5040a(VirtualCurrencyResponse virtualCurrencyResponse) {
        m5041a(new VirtualCurrencyNetworkOperation(this, virtualCurrencyResponse));
    }

    protected final /* synthetic */ Object m5048a(int i, String str, String str2) {
        if (SignedResponseNetworkOperation.m5021a(i)) {
            return VirtualCurrencyNetworkOperation.m5044f(str);
        }
        return new VirtualCurrencyErrorResponse(VirtualCurrencyErrorResponse.ERROR_INVALID_RESPONSE_SIGNATURE, null, "The signature received in the request did not match the expected one");
    }

    protected final /* synthetic */ Object m5049a(IOException iOException) {
        m5041a(new VirtualCurrencyNetworkOperation(this));
        return null;
    }
}
