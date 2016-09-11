package android.support.v7.widget;

import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* compiled from: AppCompatSpinner */
class bl implements ListAdapter, SpinnerAdapter {
    private SpinnerAdapter f1950a;
    private ListAdapter f1951b;

    public bl(SpinnerAdapter spinnerAdapter, Theme theme) {
        this.f1950a = spinnerAdapter;
        if (spinnerAdapter instanceof ListAdapter) {
            this.f1951b = (ListAdapter) spinnerAdapter;
        }
        if (theme == null) {
            return;
        }
        if (bj.f1936a && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
            ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
            if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        } else if (spinnerAdapter instanceof fx) {
            fx fxVar = (fx) spinnerAdapter;
            if (fxVar.m4639a() == null) {
                fxVar.m4640a(theme);
            }
        }
    }

    public int getCount() {
        return this.f1950a == null ? 0 : this.f1950a.getCount();
    }

    public Object getItem(int i) {
        return this.f1950a == null ? null : this.f1950a.getItem(i);
    }

    public long getItemId(int i) {
        return this.f1950a == null ? -1 : this.f1950a.getItemId(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return getDropDownView(i, view, viewGroup);
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return this.f1950a == null ? null : this.f1950a.getDropDownView(i, view, viewGroup);
    }

    public boolean hasStableIds() {
        return this.f1950a != null && this.f1950a.hasStableIds();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f1950a != null) {
            this.f1950a.registerDataSetObserver(dataSetObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f1950a != null) {
            this.f1950a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f1951b;
        if (listAdapter != null) {
            return listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public boolean isEnabled(int i) {
        ListAdapter listAdapter = this.f1951b;
        if (listAdapter != null) {
            return listAdapter.isEnabled(i);
        }
        return true;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }
}
