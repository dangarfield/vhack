package org.vhack.dev.vhack;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;

public class DelayedVerticalScrollingTextView extends TextView {
    private StringBuilder f5050a;
    private Queue f5051b;
    private int f5052c;
    private final Runnable f5053d;

    public DelayedVerticalScrollingTextView(Context context) {
        super(context);
        this.f5052c = 120;
        this.f5053d = new bp(this);
        m9013a();
    }

    public DelayedVerticalScrollingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5052c = 120;
        this.f5053d = new bp(this);
        m9013a();
    }

    private void m9013a() {
        this.f5050a = new StringBuilder();
        this.f5051b = new ArrayDeque();
    }

    public void m9018a(String str, String str2) {
        m9014a(new ArrayList(Arrays.asList(str.split(str2))));
    }

    public void setTextToPresent(ArrayList arrayList) {
        m9014a(arrayList);
    }

    private void m9014a(ArrayList arrayList) {
        this.f5051b.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f5051b.add((String) it.next());
        }
    }

    public void m9017a(int i, boolean z) {
        if (z) {
            this.f5050a.setLength(0);
            setText("");
        }
        if (!this.f5051b.isEmpty()) {
            if (this.f5052c != i && i > 0) {
                this.f5052c = i;
            }
            post(this.f5053d);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f5053d);
    }
}
