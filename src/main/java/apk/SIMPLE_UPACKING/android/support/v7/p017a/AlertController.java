package android.support.v7.p017a;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/* renamed from: android.support.v7.a.k */
public class AlertController {
    public int f1297A;
    public boolean f1298B;
    public boolean[] f1299C;
    public boolean f1300D;
    public boolean f1301E;
    public int f1302F;
    public OnMultiChoiceClickListener f1303G;
    public Cursor f1304H;
    public String f1305I;
    public String f1306J;
    public OnItemSelectedListener f1307K;
    public AlertController f1308L;
    public boolean f1309M;
    public final Context f1310a;
    public final LayoutInflater f1311b;
    public int f1312c;
    public Drawable f1313d;
    public int f1314e;
    public CharSequence f1315f;
    public View f1316g;
    public CharSequence f1317h;
    public CharSequence f1318i;
    public OnClickListener f1319j;
    public CharSequence f1320k;
    public OnClickListener f1321l;
    public CharSequence f1322m;
    public OnClickListener f1323n;
    public boolean f1324o;
    public OnCancelListener f1325p;
    public OnDismissListener f1326q;
    public OnKeyListener f1327r;
    public CharSequence[] f1328s;
    public ListAdapter f1329t;
    public OnClickListener f1330u;
    public int f1331v;
    public View f1332w;
    public int f1333x;
    public int f1334y;
    public int f1335z;

    public AlertController(Context context) {
        this.f1312c = 0;
        this.f1314e = 0;
        this.f1298B = false;
        this.f1302F = -1;
        this.f1309M = true;
        this.f1310a = context;
        this.f1324o = true;
        this.f1311b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void m3077a(AlertController alertController) {
        if (this.f1316g != null) {
            alertController.m3070b(this.f1316g);
        } else {
            if (this.f1315f != null) {
                alertController.m3067a(this.f1315f);
            }
            if (this.f1313d != null) {
                alertController.m3065a(this.f1313d);
            }
            if (this.f1312c != 0) {
                alertController.m3069b(this.f1312c);
            }
            if (this.f1314e != 0) {
                alertController.m3069b(alertController.m3073c(this.f1314e));
            }
        }
        if (this.f1317h != null) {
            alertController.m3071b(this.f1317h);
        }
        if (this.f1318i != null) {
            alertController.m3064a(-1, this.f1318i, this.f1319j, null);
        }
        if (this.f1320k != null) {
            alertController.m3064a(-2, this.f1320k, this.f1321l, null);
        }
        if (this.f1322m != null) {
            alertController.m3064a(-3, this.f1322m, this.f1323n, null);
        }
        if (!(this.f1328s == null && this.f1304H == null && this.f1329t == null)) {
            m3076b(alertController);
        }
        if (this.f1332w != null) {
            if (this.f1298B) {
                alertController.m3066a(this.f1332w, this.f1333x, this.f1334y, this.f1335z, this.f1297A);
                return;
            }
            alertController.m3074c(this.f1332w);
        } else if (this.f1331v != 0) {
            alertController.m3063a(this.f1331v);
        }
    }

    private void m3076b(AlertController alertController) {
        ListAdapter simpleCursorAdapter;
        ListView listView = (ListView) this.f1311b.inflate(alertController.f1251H, null);
        if (!this.f1300D) {
            int m;
            if (this.f1301E) {
                m = alertController.f1253J;
            } else {
                m = alertController.f1254K;
            }
            if (this.f1304H != null) {
                simpleCursorAdapter = new SimpleCursorAdapter(this.f1310a, m, this.f1304H, new String[]{this.f1305I}, new int[]{16908308});
            } else if (this.f1329t != null) {
                simpleCursorAdapter = this.f1329t;
            } else {
                simpleCursorAdapter = new AlertController(this.f1310a, m, 16908308, this.f1328s);
            }
        } else if (this.f1304H == null) {
            simpleCursorAdapter = new AlertController(this, this.f1310a, alertController.f1252I, 16908308, this.f1328s, listView);
        } else {
            Object alertController2 = new AlertController(this, this.f1310a, this.f1304H, false, listView, alertController);
        }
        if (this.f1308L != null) {
            this.f1308L.m3078a(listView);
        }
        alertController.f1247D = simpleCursorAdapter;
        alertController.f1248E = this.f1302F;
        if (this.f1330u != null) {
            listView.setOnItemClickListener(new AlertController(this, alertController));
        } else if (this.f1303G != null) {
            listView.setOnItemClickListener(new AlertController(this, listView, alertController));
        }
        if (this.f1307K != null) {
            listView.setOnItemSelectedListener(this.f1307K);
        }
        if (this.f1301E) {
            listView.setChoiceMode(1);
        } else if (this.f1300D) {
            listView.setChoiceMode(2);
        }
        alertController.f1263f = listView;
    }
}
