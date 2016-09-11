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
    private StringBuilder a;
    private Queue b;
    private int c;
    private final Runnable d;

    public DelayedVerticalScrollingTextView(Context context) {
        super(context);
        this.c = 120;
        this.d = new bp(this);
        a();
    }

    public DelayedVerticalScrollingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 120;
        this.d = new bp(this);
        a();
    }

    private void a() {
        this.a = new StringBuilder();
        this.b = new ArrayDeque();
    }

    public void a(String str, String str2) {
        a(new ArrayList(Arrays.asList(str.split(str2))));
    }

    public void setTextToPresent(ArrayList arrayList) {
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        this.b.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.b.add((String) it.next());
        }
    }

    public void a(int i, boolean z) {
        if (z) {
            this.a.setLength(0);
            setText("");
        }
        if (!this.b.isEmpty()) {
            if (this.c != i && i > 0) {
                this.c = i;
            }
            post(this.d);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.d);
    }
}
