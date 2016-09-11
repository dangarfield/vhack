package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

/* compiled from: SearchView */
class fi {
    private Method f2243a;
    private Method f2244b;
    private Method f2245c;
    private Method f2246d;

    fi() {
        try {
            this.f2243a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.f2243a.setAccessible(true);
        } catch (NoSuchMethodException e) {
        }
        try {
            this.f2244b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.f2244b.setAccessible(true);
        } catch (NoSuchMethodException e2) {
        }
        try {
            this.f2245c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
            this.f2245c.setAccessible(true);
        } catch (NoSuchMethodException e3) {
        }
        try {
            this.f2246d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
            this.f2246d.setAccessible(true);
        } catch (NoSuchMethodException e4) {
        }
    }

    void m4576a(AutoCompleteTextView autoCompleteTextView) {
        if (this.f2243a != null) {
            try {
                this.f2243a.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    void m4578b(AutoCompleteTextView autoCompleteTextView) {
        if (this.f2244b != null) {
            try {
                this.f2244b.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    void m4577a(AutoCompleteTextView autoCompleteTextView, boolean z) {
        if (this.f2245c != null) {
            try {
                this.f2245c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
            }
        }
    }
}
