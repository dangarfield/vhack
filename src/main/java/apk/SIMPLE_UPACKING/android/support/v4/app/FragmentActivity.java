package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.p014g.SimpleArrayMap;
import android.support.v4.p014g.SparseArrayCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.C0001R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.app.w */
public class FragmentActivity extends BaseFragmentActivityHoneycomb {
    final Handler f754a;
    final ab f755b;
    boolean f756c;
    boolean f757d;
    boolean f758e;
    boolean f759f;
    boolean f760g;
    boolean f761h;
    int f762i;
    boolean f763j;
    SparseArrayCompat f764k;

    public FragmentActivity() {
        this.f754a = new FragmentActivity(this);
        this.f755b = ab.m750a(new FragmentActivity(this));
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f755b.m768d();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.f764k.m1530a(i4);
            this.f764k.m1536c(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.f755b.m752a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.m1139a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f755b.m751a().m815c()) {
            a_();
        }
    }

    public void a_() {
        ActivityCompat.m747b(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f755b.m755a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.f755b.m757a(null);
        super.onCreate(bundle);
        FragmentActivity fragmentActivity = (FragmentActivity) getLastNonConfigurationInstance();
        if (fragmentActivity != null) {
            this.f755b.m758a(fragmentActivity.f769c);
        }
        if (bundle != null) {
            this.f755b.m756a(bundle.getParcelable("android:support:fragments"), fragmentActivity != null ? fragmentActivity.f768b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f762i = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f764k = new SparseArrayCompat(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.f764k.m1534b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.f764k == null) {
            this.f764k = new SparseArrayCompat();
            this.f762i = 0;
        }
        this.f755b.m771g();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.f755b.m762a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View m1217a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f755b.m753a(view, str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        m1220a(false);
        this.f755b.m778n();
        this.f755b.m782r();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f755b.m779o();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                return this.f755b.m763a(menuItem);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return this.f755b.m766b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                this.f755b.m765b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f757d = false;
        if (this.f754a.hasMessages(2)) {
            this.f754a.removeMessages(2);
            m1222b();
        }
        this.f755b.m775k();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f755b.m768d();
    }

    public void onStateNotSaved() {
        this.f755b.m768d();
    }

    protected void onResume() {
        super.onResume();
        this.f754a.sendEmptyMessage(2);
        this.f757d = true;
        this.f755b.m780p();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f754a.removeMessages(2);
        m1222b();
        this.f755b.m780p();
    }

    protected void m1222b() {
        this.f755b.m774j();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f761h) {
            this.f761h = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return m1221a(view, menu) | this.f755b.m761a(menu);
    }

    protected boolean m1221a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f758e) {
            m1220a(true);
        }
        Object c = m1223c();
        List f = this.f755b.m770f();
        SimpleArrayMap t = this.f755b.m784t();
        if (f == null && t == null && c == null) {
            return null;
        }
        Object fragmentActivity = new FragmentActivity();
        fragmentActivity.f767a = c;
        fragmentActivity.f768b = f;
        fragmentActivity.f769c = t;
        return fragmentActivity;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable e = this.f755b.m769e();
        if (e != null) {
            bundle.putParcelable("android:support:fragments", e);
        }
        if (this.f764k.m1532b() > 0) {
            bundle.putInt("android:support:next_request_index", this.f762i);
            int[] iArr = new int[this.f764k.m1532b()];
            String[] strArr = new String[this.f764k.m1532b()];
            for (int i = 0; i < this.f764k.m1532b(); i++) {
                iArr[i] = this.f764k.m1537d(i);
                strArr[i] = (String) this.f764k.m1538e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f758e = false;
        this.f759f = false;
        this.f754a.removeMessages(1);
        if (!this.f756c) {
            this.f756c = true;
            this.f755b.m772h();
        }
        this.f755b.m768d();
        this.f755b.m780p();
        this.f755b.m781q();
        this.f755b.m773i();
        this.f755b.m783s();
    }

    protected void onStop() {
        super.onStop();
        this.f758e = true;
        this.f754a.sendEmptyMessage(1);
        this.f755b.m776l();
    }

    public Object m1223c() {
        return null;
    }

    public void m1224d() {
        if (VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.m1021a(this);
        } else {
            this.f761h = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f756c);
            printWriter.print("mResumed=");
            printWriter.print(this.f757d);
            printWriter.print(" mStopped=");
            printWriter.print(this.f758e);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f759f);
            this.f755b.m759a(str2, fileDescriptor, printWriter, strArr);
            this.f755b.m751a().m813a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m1215a(str + "  ", printWriter, getWindow().getDecorView());
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f756c);
            printWriter.print("mResumed=");
            printWriter.print(this.f757d);
            printWriter.print(" mStopped=");
            printWriter.print(this.f758e);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f759f);
            this.f755b.m759a(str2, fileDescriptor, printWriter, strArr);
            this.f755b.m751a().m813a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m1215a(str + "  ", printWriter, getWindow().getDecorView());
        }
    }

    private static String m1214a(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                stringBuilder.append('V');
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                stringBuilder.append('I');
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m1215a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(FragmentActivity.m1214a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m1215a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    void m1220a(boolean z) {
        if (!this.f759f) {
            this.f759f = true;
            this.f760g = z;
            this.f754a.removeMessages(1);
            m1225e();
        }
    }

    void m1225e() {
        this.f755b.m760a(this.f760g);
        this.f755b.m777m();
    }

    public void m1218a(Fragment fragment) {
    }

    public ad m1226f() {
        return this.f755b.m751a();
    }

    public ax m1227g() {
        return this.f755b.m764b();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.f763j || i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 8) & 255;
        if (i2 != 0) {
            i2--;
            int c = this.f755b.m767c();
            if (c == 0 || i2 < 0 || i2 >= c) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = (Fragment) this.f755b.m754a(new ArrayList(c)).get(i2);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            } else {
                fragment.m1141a(i & 255, strArr, iArr);
            }
        }
    }

    public void m1219a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.f763j = true;
        if (i == -1) {
            try {
                ActivityCompat.m746a(this, intent, -1, bundle);
            } finally {
                this.f763j = false;
            }
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            ActivityCompat.m746a(this, intent, ((m1216b(fragment) + 1) << 16) + (65535 & i), bundle);
            this.f763j = false;
        }
    }

    private int m1216b(Fragment fragment) {
        if (this.f764k.m1532b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.f764k.m1539f(this.f762i) >= 0) {
            this.f762i = (this.f762i + 1) % 65534;
        }
        int i = this.f762i;
        this.f764k.m1534b(i, fragment.f734q);
        this.f762i = (this.f762i + 1) % 65534;
        return i;
    }
}
