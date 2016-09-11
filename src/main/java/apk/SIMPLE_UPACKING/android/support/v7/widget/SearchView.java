package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.p018b.R;
import android.support.v7.view.CollapsibleActionView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.google.android.gms.C0001R;
import java.util.WeakHashMap;

public class SearchView extends cs implements CollapsibleActionView {
    static final fi f1717a;
    private static final boolean f1718b;
    private boolean f1719A;
    private boolean f1720B;
    private int f1721C;
    private boolean f1722D;
    private CharSequence f1723E;
    private boolean f1724F;
    private int f1725G;
    private SearchableInfo f1726H;
    private Bundle f1727I;
    private Runnable f1728J;
    private final Runnable f1729K;
    private Runnable f1730L;
    private final WeakHashMap f1731M;
    private final SearchAutoComplete f1732c;
    private final View f1733d;
    private final View f1734e;
    private final ImageView f1735f;
    private final ImageView f1736g;
    private final ImageView f1737h;
    private final ImageView f1738i;
    private final ImageView f1739j;
    private final Drawable f1740k;
    private final int f1741l;
    private final int f1742m;
    private final Intent f1743n;
    private final Intent f1744o;
    private final CharSequence f1745p;
    private fk f1746q;
    private fj f1747r;
    private OnFocusChangeListener f1748s;
    private fl f1749t;
    private OnClickListener f1750u;
    private boolean f1751v;
    private boolean f1752w;
    private CursorAdapter f1753x;
    private boolean f1754y;
    private CharSequence f1755z;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        boolean f1710a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1710a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1710a));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1710a + "}";
        }

        static {
            CREATOR = new fm();
        }
    }

    public class SearchAutoComplete extends al {
        private int f1715a;
        private SearchView f1716b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1715a = getThreshold();
        }

        void setSearchView(SearchView searchView) {
            this.f1716b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1715a = i;
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1716b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m3722a(getContext())) {
                    SearchView.f1717a.m4577a(this, true);
                }
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1716b.m3743d();
        }

        public boolean enoughToFilter() {
            return this.f1715a <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1716b.clearFocus();
                        this.f1716b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 8) {
            z = true;
        } else {
            z = false;
        }
        f1718b = z;
        f1717a = new fi();
    }

    int getSuggestionRowLayout() {
        return this.f1741l;
    }

    int getSuggestionCommitIconResId() {
        return this.f1742m;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1726H = searchableInfo;
        if (this.f1726H != null) {
            if (f1718b) {
                m3732l();
            }
            m3731k();
        }
        boolean z = f1718b && m3726e();
        this.f1722D = z;
        if (this.f1722D) {
            this.f1732c.setPrivateImeOptions("nm");
        }
        m3721a(m3742c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1727I = bundle;
    }

    public void setImeOptions(int i) {
        this.f1732c.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.f1732c.getImeOptions();
    }

    public void setInputType(int i) {
        this.f1732c.setInputType(i);
    }

    public int getInputType() {
        return this.f1732c.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f1720B || !isFocusable()) {
            return false;
        }
        if (m3742c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f1732c.requestFocus(i, rect);
        if (requestFocus) {
            m3721a(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.f1720B = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f1732c.clearFocus();
        this.f1720B = false;
    }

    public void setOnQueryTextListener(fk fkVar) {
        this.f1746q = fkVar;
    }

    public void setOnCloseListener(fj fjVar) {
        this.f1747r = fjVar;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f1748s = onFocusChangeListener;
    }

    public void setOnSuggestionListener(fl flVar) {
        this.f1749t = flVar;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f1750u = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f1732c.getText();
    }

    public void m3740a(CharSequence charSequence, boolean z) {
        this.f1732c.setText(charSequence);
        if (charSequence != null) {
            this.f1732c.setSelection(this.f1732c.length());
            this.f1723E = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m3733m();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1755z = charSequence;
        m3731k();
    }

    public CharSequence getQueryHint() {
        if (this.f1755z != null) {
            return this.f1755z;
        }
        if (!f1718b || this.f1726H == null || this.f1726H.getHintId() == 0) {
            return this.f1745p;
        }
        return getContext().getText(this.f1726H.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1751v != z) {
            this.f1751v = z;
            m3721a(z);
            m3731k();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            m3735o();
        } else {
            m3736p();
        }
    }

    public boolean m3742c() {
        return this.f1752w;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1754y = z;
        m3721a(m3742c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1719A = z;
        if (this.f1753x instanceof fu) {
            ((fu) this.f1753x).m4630a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.f1753x = cursorAdapter;
        this.f1732c.setAdapter(this.f1753x);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.f1753x;
    }

    public void setMaxWidth(int i) {
        this.f1721C = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f1721C;
    }

    protected void onMeasure(int i, int i2) {
        if (m3742c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.f1721C <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f1721C, size);
                    break;
                }
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                if (this.f1721C <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f1721C;
                    break;
                }
            case 1073741824:
                if (this.f1721C > 0) {
                    size = Math.min(this.f1721C, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.abc_search_view_preferred_width);
    }

    private void m3721a(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.f1752w = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.f1732c.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f1735f.setVisibility(i2);
        m3724b(z2);
        View view = this.f1733d;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (!(this.f1739j.getDrawable() == null || this.f1751v)) {
            i = 0;
        }
        this.f1739j.setVisibility(i);
        m3729h();
        if (z2) {
            z3 = false;
        }
        m3725c(z3);
        m3728g();
    }

    @TargetApi(8)
    private boolean m3726e() {
        if (this.f1726H == null || !this.f1726H.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1726H.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1743n;
        } else if (this.f1726H.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1744o;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    private boolean m3727f() {
        return (this.f1754y || this.f1722D) && !m3742c();
    }

    private void m3724b(boolean z) {
        int i = 8;
        if (this.f1754y && m3727f() && hasFocus() && (z || !this.f1722D)) {
            i = 0;
        }
        this.f1736g.setVisibility(i);
    }

    private void m3728g() {
        int i = 8;
        if (m3727f() && (this.f1736g.getVisibility() == 0 || this.f1738i.getVisibility() == 0)) {
            i = 0;
        }
        this.f1734e.setVisibility(i);
    }

    private void m3729h() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.f1732c.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.f1751v || this.f1724F)) {
            i = 0;
        }
        ImageView imageView = this.f1737h;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f1737h.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void m3730i() {
        post(this.f1729K);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.f1729K);
        post(this.f1730L);
        super.onDetachedFromWindow();
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.f1728J);
            return;
        }
        removeCallbacks(this.f1728J);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    void m3739a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    private CharSequence m3723b(CharSequence charSequence) {
        if (!this.f1751v || this.f1740k == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1732c.getTextSize()) * 1.25d);
        this.f1740k.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1740k), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void m3731k() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1732c;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m3723b(queryHint));
    }

    @TargetApi(8)
    private void m3732l() {
        int i = 1;
        this.f1732c.setThreshold(this.f1726H.getSuggestThreshold());
        this.f1732c.setImeOptions(this.f1726H.getImeOptions());
        int inputType = this.f1726H.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1726H.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.f1732c.setInputType(inputType);
        if (this.f1753x != null) {
            this.f1753x.m2524a(null);
        }
        if (this.f1726H.getSuggestAuthority() != null) {
            this.f1753x = new fu(getContext(), this, this.f1726H, this.f1731M);
            this.f1732c.setAdapter(this.f1753x);
            fu fuVar = (fu) this.f1753x;
            if (this.f1719A) {
                i = 2;
            }
            fuVar.m4630a(i);
        }
    }

    private void m3725c(boolean z) {
        int i;
        if (this.f1722D && !m3742c() && z) {
            i = 0;
            this.f1736g.setVisibility(8);
        } else {
            i = 8;
        }
        this.f1738i.setVisibility(i);
    }

    private void m3733m() {
        CharSequence text = this.f1732c.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f1746q == null || !this.f1746q.m4580a(text.toString())) {
                if (this.f1726H != null) {
                    m3719a(0, null, text.toString());
                }
                setImeVisibility(false);
                m3734n();
            }
        }
    }

    private void m3734n() {
        this.f1732c.dismissDropDown();
    }

    private void m3735o() {
        if (!TextUtils.isEmpty(this.f1732c.getText())) {
            this.f1732c.setText("");
            this.f1732c.requestFocus();
            setImeVisibility(true);
        } else if (!this.f1751v) {
        } else {
            if (this.f1747r == null || !this.f1747r.m4579a()) {
                clearFocus();
                m3721a(true);
            }
        }
    }

    private void m3736p() {
        m3721a(false);
        this.f1732c.requestFocus();
        setImeVisibility(true);
        if (this.f1750u != null) {
            this.f1750u.onClick(this);
        }
    }

    void m3743d() {
        m3721a(m3742c());
        m3730i();
        if (this.f1732c.hasFocus()) {
            m3737q();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m3730i();
    }

    public void m3741b() {
        m3740a((CharSequence) "", false);
        clearFocus();
        m3721a(true);
        this.f1732c.setImeOptions(this.f1725G);
        this.f1724F = false;
    }

    public void m3738a() {
        if (!this.f1724F) {
            this.f1724F = true;
            this.f1725G = this.f1732c.getImeOptions();
            this.f1732c.setImeOptions(this.f1725G | 33554432);
            this.f1732c.setText("");
            setIconified(false);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1710a = m3742c();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m3721a(savedState.f1710a);
        requestLayout();
    }

    private void setQuery(CharSequence charSequence) {
        this.f1732c.setText(charSequence);
        this.f1732c.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void m3719a(int i, String str, String str2) {
        getContext().startActivity(m3718a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private Intent m3718a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1723E);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f1727I != null) {
            intent.putExtra("app_data", this.f1727I);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (f1718b) {
            intent.setComponent(this.f1726H.getSearchActivity());
        }
        return intent;
    }

    private void m3737q() {
        f1717a.m4576a(this.f1732c);
        f1717a.m4578b(this.f1732c);
    }

    static boolean m3722a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
