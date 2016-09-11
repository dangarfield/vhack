package com.fyber.p028h;

import android.content.Context;
import com.fyber.Fyber;
import com.fyber.p025a.Credentials;
import com.fyber.p034b.VirtualCurrencyNetworkOperation;
import com.fyber.utils.FyberBaseUrlProvider;
import com.fyber.utils.StringUtils;
import com.fyber.utils.ae;
import java.util.Map;

/* renamed from: com.fyber.h.g */
public class VirtualCurrencyRequester extends Requester {
    protected final /* bridge */ /* synthetic */ Object m5213b() {
        return this;
    }

    public static VirtualCurrencyRequester m5210a(Requester requester) {
        return new VirtualCurrencyRequester(requester);
    }

    public void m5211a(Context context) {
        if (m5198b(context)) {
            Credentials e = Fyber.getConfigs().m4845e();
            String c = e.m4849c();
            if (StringUtils.m5259a(c)) {
                m5193a(RequestError.SECURITY_TOKEN_NOT_PROVIDED);
                return;
            }
            VirtualCurrencyCallback virtualCurrencyCallback = (VirtualCurrencyCallback) this.a;
            String c2 = m5199c("CURRENCY_ID");
            Map e2 = m5202e("CUSTOM_PARAMS_KEY");
            String c3 = m5199c("TRANSACTION_ID");
            Fyber.getConfigs().m4840a(new VirtualCurrencyNetworkOperation(ae.m5235a(FyberBaseUrlProvider.m5274a("vcs"), e).m5238a().m5243b(), virtualCurrencyCallback, c, context).m5047a(m5201d("NOTIFY_USER_ON_REWARD").booleanValue()).m5046a(e2).m5056d(c3).m5045a(this.c).m5053b(c2).m5055c(m5199c("PLACEMENT_ID_KEY")));
        }
    }

    private VirtualCurrencyRequester(Requester requester) {
        super(requester);
    }

    protected final boolean m5212a() {
        return this.a instanceof VirtualCurrencyCallback;
    }
}
