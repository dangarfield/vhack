package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.p014g.SimpleArrayMap;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FragmentController */
public class ab {
    private final ac f480a;

    public static final ab m750a(ac acVar) {
        return new ab(acVar);
    }

    private ab(ac acVar) {
        this.f480a = acVar;
    }

    public ad m751a() {
        return this.f480a.m803i();
    }

    public ax m764b() {
        return this.f480a.m804j();
    }

    Fragment m752a(String str) {
        return this.f480a.f484d.m854b(str);
    }

    public int m767c() {
        List list = this.f480a.f484d.f501f;
        return list == null ? 0 : list.size();
    }

    public List m754a(List list) {
        if (this.f480a.f484d.f501f == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList(m767c());
        }
        list.addAll(this.f480a.f484d.f501f);
        return list;
    }

    public void m757a(Fragment fragment) {
        this.f480a.f484d.m843a(this.f480a, this.f480a, fragment);
    }

    public View m753a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f480a.f484d.m834a(view, str, context, attributeSet);
    }

    public void m768d() {
        this.f480a.f484d.m877k();
    }

    public Parcelable m769e() {
        return this.f480a.f484d.m876j();
    }

    public void m756a(Parcelable parcelable, List list) {
        this.f480a.f484d.m842a(parcelable, list);
    }

    public List m770f() {
        return this.f480a.f484d.m875i();
    }

    public void m771g() {
        this.f480a.f484d.m878l();
    }

    public void m772h() {
        this.f480a.f484d.m879m();
    }

    public void m773i() {
        this.f480a.f484d.m880n();
    }

    public void m774j() {
        this.f480a.f484d.m881o();
    }

    public void m775k() {
        this.f480a.f484d.m882p();
    }

    public void m776l() {
        this.f480a.f484d.m883q();
    }

    public void m777m() {
        this.f480a.f484d.m884r();
    }

    public void m778n() {
        this.f480a.f484d.m886t();
    }

    public void m755a(Configuration configuration) {
        this.f480a.f484d.m840a(configuration);
    }

    public void m779o() {
        this.f480a.f484d.m887u();
    }

    public boolean m762a(Menu menu, MenuInflater menuInflater) {
        return this.f480a.f484d.m852a(menu, menuInflater);
    }

    public boolean m761a(Menu menu) {
        return this.f480a.f484d.m851a(menu);
    }

    public boolean m763a(MenuItem menuItem) {
        return this.f480a.f484d.m853a(menuItem);
    }

    public boolean m766b(MenuItem menuItem) {
        return this.f480a.f484d.m861b(menuItem);
    }

    public void m765b(Menu menu) {
        this.f480a.f484d.m859b(menu);
    }

    public boolean m780p() {
        return this.f480a.f484d.m873g();
    }

    public void m781q() {
        this.f480a.m806l();
    }

    public void m760a(boolean z) {
        this.f480a.m791a(z);
    }

    public void m782r() {
        this.f480a.m807m();
    }

    public void m783s() {
        this.f480a.m808n();
    }

    public SimpleArrayMap m784t() {
        return this.f480a.m809o();
    }

    public void m758a(SimpleArrayMap simpleArrayMap) {
        this.f480a.m788a(simpleArrayMap);
    }

    public void m759a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f480a.m796b(str, fileDescriptor, printWriter, strArr);
    }
}
