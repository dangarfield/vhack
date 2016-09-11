package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.p007b.ContextCompat;
import android.support.v4.widget.ar;
import android.support.v7.p018b.R;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: SuggestionsAdapter */
class fu extends ar implements OnClickListener {
    private final SearchManager f2261j;
    private final SearchView f2262k;
    private final SearchableInfo f2263l;
    private final Context f2264m;
    private final WeakHashMap f2265n;
    private final int f2266o;
    private boolean f2267p;
    private int f2268q;
    private ColorStateList f2269r;
    private int f2270s;
    private int f2271t;
    private int f2272u;
    private int f2273v;
    private int f2274w;
    private int f2275x;

    public fu(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f2267p = false;
        this.f2268q = 1;
        this.f2270s = -1;
        this.f2271t = -1;
        this.f2272u = -1;
        this.f2273v = -1;
        this.f2274w = -1;
        this.f2275x = -1;
        this.f2261j = (SearchManager) this.d.getSystemService("search");
        this.f2262k = searchView;
        this.f2263l = searchableInfo;
        this.f2266o = searchView.getSuggestionCommitIconResId();
        this.f2264m = context;
        this.f2265n = weakHashMap;
    }

    public void m4630a(int i) {
        this.f2268q = i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public Cursor m4627a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f2262k.getVisibility() != 0 || this.f2262k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m4626a(this.f2263l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m4622d(m2520a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m4622d(m2520a());
    }

    private void m4622d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    public void m4631a(Cursor cursor) {
        if (this.f2267p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.m2524a(cursor);
            if (cursor != null) {
                this.f2270s = cursor.getColumnIndex("suggest_text_1");
                this.f2271t = cursor.getColumnIndex("suggest_text_2");
                this.f2272u = cursor.getColumnIndex("suggest_text_2_url");
                this.f2273v = cursor.getColumnIndex("suggest_icon_1");
                this.f2274w = cursor.getColumnIndex("suggest_icon_2");
                this.f2275x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public View m4629a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.m2530a(context, cursor, viewGroup);
        a.setTag(new fv(a));
        ((ImageView) a.findViewById(R.edit_query)).setImageResource(this.f2266o);
        return a;
    }

    public void m4632a(View view, Context context, Cursor cursor) {
        fv fvVar = (fv) view.getTag();
        int i;
        if (this.f2275x != -1) {
            i = cursor.getInt(this.f2275x);
        } else {
            i = 0;
        }
        if (fvVar.f2276a != null) {
            m4616a(fvVar.f2276a, m4613a(cursor, this.f2270s));
        }
        if (fvVar.f2277b != null) {
            CharSequence a = m4613a(cursor, this.f2272u);
            if (a != null) {
                a = m4621b(a);
            } else {
                a = m4613a(cursor, this.f2271t);
            }
            if (TextUtils.isEmpty(a)) {
                if (fvVar.f2276a != null) {
                    fvVar.f2276a.setSingleLine(false);
                    fvVar.f2276a.setMaxLines(2);
                }
            } else if (fvVar.f2276a != null) {
                fvVar.f2276a.setSingleLine(true);
                fvVar.f2276a.setMaxLines(1);
            }
            m4616a(fvVar.f2277b, a);
        }
        if (fvVar.f2278c != null) {
            m4615a(fvVar.f2278c, m4623e(cursor), 4);
        }
        if (fvVar.f2279d != null) {
            m4615a(fvVar.f2279d, m4624f(cursor), 8);
        }
        if (this.f2268q == 2 || (this.f2268q == 1 && (r1 & 1) != 0)) {
            fvVar.f2280e.setVisibility(0);
            fvVar.f2280e.setTag(fvVar.f2276a.getText());
            fvVar.f2280e.setOnClickListener(this);
            return;
        }
        fvVar.f2280e.setVisibility(8);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f2262k.m3739a((CharSequence) tag);
        }
    }

    private CharSequence m4621b(CharSequence charSequence) {
        if (this.f2269r == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(R.textColorSearchUrl, typedValue, true);
            this.f2269r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f2269r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void m4616a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private Drawable m4623e(Cursor cursor) {
        if (this.f2273v == -1) {
            return null;
        }
        Drawable a = m4612a(cursor.getString(this.f2273v));
        return a == null ? m4625g(cursor) : a;
    }

    private Drawable m4624f(Cursor cursor) {
        if (this.f2274w == -1) {
            return null;
        }
        return m4612a(cursor.getString(this.f2274w));
    }

    private void m4615a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public CharSequence m4633c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m4614a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f2263l.shouldRewriteQueryFromData()) {
            a = m4614a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.f2263l.shouldRewriteQueryFromText()) {
            return null;
        }
        a = m4614a(cursor, "suggest_text_1");
        if (a != null) {
            return a;
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = m4629a(this.d, this.c, viewGroup);
            if (a != null) {
                ((fv) a.getTag()).f2276a.setText(e.toString());
            }
            return a;
        }
    }

    private Drawable m4612a(String str) {
        Drawable b;
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f2264m.getPackageName() + "/" + parseInt;
            b = m4620b(str2);
            if (b != null) {
                return b;
            }
            b = ContextCompat.m741a(this.f2264m, parseInt);
            m4617a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = m4620b(str);
            if (b != null) {
                return b;
            }
            b = m4619b(Uri.parse(str));
            m4617a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable m4619b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m4628a(uri);
            }
            openInputStream = this.f2264m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable m4620b(String str) {
        ConstantState constantState = (ConstantState) this.f2265n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void m4617a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f2265n.put(str, drawable.getConstantState());
        }
    }

    private Drawable m4625g(Cursor cursor) {
        Drawable a = m4611a(this.f2263l.getSearchActivity());
        return a != null ? a : this.d.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable m4611a(ComponentName componentName) {
        Object obj = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f2265n.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.f2265n.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.f2264m.getResources());
        } else {
            Drawable b = m4618b(componentName);
            if (b != null) {
                obj = b.getConstantState();
            }
            this.f2265n.put(flattenToShortString, obj);
            return b;
        }
    }

    private Drawable m4618b(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    public static String m4614a(Cursor cursor, String str) {
        return m4613a(cursor, cursor.getColumnIndex(str));
    }

    private static String m4613a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    Drawable m4628a(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor m4626a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }
}
