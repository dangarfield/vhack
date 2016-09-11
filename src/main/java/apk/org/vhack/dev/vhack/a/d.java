package org.vhack.dev.vhack.a;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.a.a.a.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* compiled from: IabHelper */
public class d {
    boolean a;
    String b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    String g;
    Context h;
    a i;
    ServiceConnection j;
    int k;
    String l;
    String m;
    k n;

    public d(Context context, String str) {
        this.a = false;
        this.b = "IabHelper";
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = "";
        this.m = null;
        this.h = context.getApplicationContext();
        this.m = str;
        c("IAB helper created.");
    }

    public void a(boolean z, String str) {
        c();
        this.a = z;
        this.b = str;
    }

    public void a(l lVar) {
        c();
        if (this.c) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        c("Starting in-app billing setup.");
        this.j = new e(this, lVar);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        if (!this.h.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
            this.h.bindService(intent, this.j, 1);
        } else if (lVar != null) {
            lVar.a(new n(3, "Billing service unavailable on device."));
        }
    }

    public void a() {
        c("Disposing.");
        this.c = false;
        if (this.j != null) {
            c("Unbinding from service.");
            if (this.h != null) {
                this.h.unbindService(this.j);
            }
        }
        this.d = true;
        this.h = null;
        this.j = null;
        this.i = null;
        this.n = null;
    }

    private void c() {
        if (this.d) {
            throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
        }
    }

    public void a(Activity activity, String str, int i, k kVar, String str2) {
        a(activity, str, "inapp", i, kVar, str2);
    }

    public void a(Activity activity, String str, String str2, int i, k kVar, String str3) {
        c();
        a("launchPurchaseFlow");
        b("launchPurchaseFlow");
        n nVar;
        if (!str2.equals("subs") || this.e) {
            try {
                c("Constructing buy intent for " + str + ", item type: " + str2);
                Bundle a = this.i.a(3, this.h.getPackageName(), str, str2, str3);
                int a2 = a(a);
                if (a2 != 0) {
                    d("Unable to buy item, Error response: " + a(a2));
                    b();
                    nVar = new n(a2, "Unable to buy item");
                    if (kVar != null) {
                        kVar.a(nVar, null);
                        return;
                    }
                    return;
                }
                PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
                c("Launching buy intent for " + str + ". Request code: " + i);
                this.k = i;
                this.n = kVar;
                this.l = str2;
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
                return;
            } catch (SendIntentException e) {
                d("SendIntentException while launching purchase flow for sku " + str);
                e.printStackTrace();
                b();
                nVar = new n(-1004, "Failed to send intent.");
                if (kVar != null) {
                    kVar.a(nVar, null);
                    return;
                }
                return;
            } catch (RemoteException e2) {
                d("RemoteException while launching purchase flow for sku " + str);
                e2.printStackTrace();
                b();
                nVar = new n(-1001, "Remote exception while starting purchase flow");
                if (kVar != null) {
                    kVar.a(nVar, null);
                    return;
                }
                return;
            }
        }
        nVar = new n(-1009, "Subscriptions are not available.");
        b();
        if (kVar != null) {
            kVar.a(nVar, null);
        }
    }

    public boolean a(int i, int i2, Intent intent) {
        if (i != this.k) {
            return false;
        }
        c();
        a("handleActivityResult");
        b();
        n nVar;
        if (intent == null) {
            d("Null data in IAB activity result.");
            nVar = new n(-1002, "Null data in IAB result");
            if (this.n != null) {
                this.n.a(nVar, null);
            }
            return true;
        }
        int a = a(intent);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (i2 == -1 && a == 0) {
            c("Successful resultcode from purchase activity.");
            c("Purchase data: " + stringExtra);
            c("Data signature: " + stringExtra2);
            c("Extras: " + intent.getExtras());
            c("Expected item type: " + this.l);
            if (stringExtra == null || stringExtra2 == null) {
                d("BUG: either purchaseData or dataSignature is null.");
                c("Extras: " + intent.getExtras().toString());
                nVar = new n(-1008, "IAB returned null purchaseData or dataSignature");
                if (this.n != null) {
                    this.n.a(nVar, null);
                }
                return true;
            }
            try {
                o oVar = new o(this.l, stringExtra, stringExtra2);
                String a2 = oVar.a();
                if (p.getUpdate(this.m, stringExtra, stringExtra2)) {
                    c("Purchase signature successfully verified.");
                    if (this.n != null) {
                        this.n.a(new n(0, "Success"), oVar);
                    }
                } else {
                    d("Purchase signature verification FAILED for sku " + a2);
                    nVar = new n(-1003, "Signature verification failed for sku " + a2);
                    if (this.n != null) {
                        this.n.a(nVar, oVar);
                    }
                    return true;
                }
            } catch (JSONException e) {
                d("Failed to parse purchase data.");
                e.printStackTrace();
                nVar = new n(-1002, "Failed to parse purchase data.");
                if (this.n != null) {
                    this.n.a(nVar, null);
                }
                return true;
            }
        } else if (i2 == -1) {
            c("Result code was OK but in-app billing response was not OK: " + a(a));
            if (this.n != null) {
                this.n.a(new n(a, "Problem purchashing item."), null);
            }
        } else if (i2 == 0) {
            c("Purchase canceled - Response: " + a(a));
            nVar = new n(-1005, "User canceled.");
            if (this.n != null) {
                this.n.a(nVar, null);
            }
        } else {
            d("Purchase failed. Result code: " + Integer.toString(i2) + ". Response: " + a(a));
            nVar = new n(-1006, "Unknown purchase response.");
            if (this.n != null) {
                this.n.a(nVar, null);
            }
        }
        return true;
    }

    void a(o oVar) {
        c();
        a("consume");
        if (oVar.a.equals("inapp")) {
            try {
                String b = oVar.b();
                String a = oVar.a();
                if (b == null || b.equals("")) {
                    d("Can't consume " + a + ". No token.");
                    throw new c(-1007, "PurchaseInfo is missing token for sku: " + a + " " + oVar);
                }
                c("Consuming sku: " + a + ", token: " + b);
                int b2 = this.i.b(3, this.h.getPackageName(), b);
                if (b2 == 0) {
                    c("Successfully consumed sku: " + a);
                    return;
                } else {
                    c("Error consuming consuming sku " + a + ". " + a(b2));
                    throw new c(b2, "Error consuming sku " + a);
                }
            } catch (Exception e) {
                throw new c(-1001, "Remote exception while consuming. PurchaseInfo: " + oVar, e);
            }
        }
        throw new c(-1010, "Items of type '" + oVar.a + "' can't be consumed.");
    }

    public void a(o oVar, i iVar) {
        c();
        a("consume");
        List arrayList = new ArrayList();
        arrayList.add(oVar);
        getUpdate(arrayList, iVar, null);
    }

    public static String a(int i) {
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i <= -1000) {
            int i2 = -1000 - i;
            if (i2 < 0 || i2 >= split2.length) {
                return String.valueOf(i) + ":Unknown IAB Helper Error";
            }
            return split2[i2];
        } else if (i < 0 || i >= split.length) {
            return String.valueOf(i) + ":Unknown";
        } else {
            return split[i];
        }
    }

    void a(String str) {
        if (!this.c) {
            d("Illegal state for operation (" + str + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
        }
    }

    int a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            c("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            d("Unexpected type for bundle response code.");
            d(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
        }
    }

    int a(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            d("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            d("Unexpected type for intent response code.");
            d(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
        }
    }

    void b(String str) {
        if (this.f) {
            throw new IllegalStateException("Can't start async operation (" + str + ") because another async operation(" + this.g + ") is in progress.");
        }
        this.g = str;
        this.f = true;
        c("Starting async operation: " + str);
    }

    void b() {
        c("Ending async operation: " + this.g);
        this.g = "";
        this.f = false;
    }

    void a(List list, i iVar, j jVar) {
        Handler handler = new Handler();
        b("consume");
        new Thread(new f(this, list, iVar, handler, jVar)).start();
    }

    void c(String str) {
        if (this.a) {
            Log.d(this.b, str);
        }
    }

    void d(String str) {
        Log.e(this.b, "In-app billing error: " + str);
    }
}
