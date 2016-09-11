package android.support.v7.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

/* compiled from: RecyclerView */
public class eo {
    private SparseArray f2149a;
    private SparseIntArray f2150b;
    private int f2151c;

    public eo() {
        this.f2149a = new SparseArray();
        this.f2150b = new SparseIntArray();
        this.f2151c = 0;
    }

    public void m4404a() {
        this.f2149a.clear();
    }

    public ey m4403a(int i) {
        ArrayList arrayList = (ArrayList) this.f2149a.get(i);
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size() - 1;
        ey eyVar = (ey) arrayList.get(size);
        arrayList.remove(size);
        return eyVar;
    }

    public void m4407a(ey eyVar) {
        int h = eyVar.m4528h();
        ArrayList b = m4402b(h);
        if (this.f2150b.get(h) > b.size()) {
            eyVar.m4542v();
            b.add(eyVar);
        }
    }

    void m4405a(dy dyVar) {
        this.f2151c++;
    }

    void m4408b() {
        this.f2151c--;
    }

    void m4406a(dy dyVar, dy dyVar2, boolean z) {
        if (dyVar != null) {
            m4408b();
        }
        if (!z && this.f2151c == 0) {
            m4404a();
        }
        if (dyVar2 != null) {
            m4405a(dyVar2);
        }
    }

    private ArrayList m4402b(int i) {
        ArrayList arrayList = (ArrayList) this.f2149a.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f2149a.put(i, arrayList);
            if (this.f2150b.indexOfKey(i) < 0) {
                this.f2150b.put(i, 5);
            }
        }
        return arrayList;
    }
}
