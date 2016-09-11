package android.support.v7.widget;

import android.support.v7.view.ActionMode;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: android.support.v7.widget.e */
class ActionBarContextView implements OnClickListener {
    final /* synthetic */ ActionMode f2138a;
    final /* synthetic */ ActionBarContextView f2139b;

    ActionBarContextView(ActionBarContextView actionBarContextView, ActionMode actionMode) {
        this.f2139b = actionBarContextView;
        this.f2138a = actionMode;
    }

    public void onClick(View view) {
        this.f2138a.m3003c();
    }
}
