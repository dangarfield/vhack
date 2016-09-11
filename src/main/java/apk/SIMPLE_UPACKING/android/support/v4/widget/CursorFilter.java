package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* renamed from: android.support.v4.widget.q */
class CursorFilter extends Filter {
    CursorFilter f1073a;

    CursorFilter(CursorFilter cursorFilter) {
        this.f1073a = cursorFilter;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f1073a.m2519c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f1073a.m2517a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f1073a.m2516a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f1073a.m2518a((Cursor) filterResults.values);
        }
    }
}
