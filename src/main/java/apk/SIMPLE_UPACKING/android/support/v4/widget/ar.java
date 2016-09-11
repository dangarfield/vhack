package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter */
public abstract class ar extends CursorAdapter {
    private int f1026j;
    private int f1027k;
    private LayoutInflater f1028l;

    public ar(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f1027k = i;
        this.f1026j = i;
        this.f1028l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View m2530a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1028l.inflate(this.f1026j, viewGroup, false);
    }

    public View m2531b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1028l.inflate(this.f1027k, viewGroup, false);
    }
}
