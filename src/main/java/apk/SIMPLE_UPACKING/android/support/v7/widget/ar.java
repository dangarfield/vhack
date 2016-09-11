package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.p007b.ContextCompat;
import android.support.v4.p009c.ColorUtils;
import android.support.v4.p009c.p010a.DrawableCompat;
import android.support.v4.p014g.ArrayMap;
import android.support.v4.p014g.LongSparseArray;
import android.support.v7.p018b.R;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: AppCompatDrawableManager */
public final class ar {
    private static final Mode f1888a;
    private static ar f1889b;
    private static final au f1890c;
    private static final int[] f1891d;
    private static final int[] f1892e;
    private static final int[] f1893f;
    private static final int[] f1894g;
    private static final int[] f1895h;
    private static final int[] f1896i;
    private WeakHashMap f1897j;
    private ArrayMap f1898k;
    private SparseArray f1899l;
    private final Object f1900m;
    private final WeakHashMap f1901n;
    private TypedValue f1902o;

    public ar() {
        this.f1900m = new Object();
        this.f1901n = new WeakHashMap(0);
    }

    static {
        f1888a = Mode.SRC_IN;
        f1890c = new au(6);
        f1891d = new int[]{R.abc_textfield_search_default_mtrl_alpha, R.abc_textfield_default_mtrl_alpha, R.abc_ab_share_pack_mtrl_alpha};
        f1892e = new int[]{R.abc_ic_ab_back_mtrl_am_alpha, R.abc_ic_go_search_api_mtrl_alpha, R.abc_ic_search_api_mtrl_alpha, R.abc_ic_commit_search_api_mtrl_alpha, R.abc_ic_clear_mtrl_alpha, R.abc_ic_menu_share_mtrl_alpha, R.abc_ic_menu_copy_mtrl_am_alpha, R.abc_ic_menu_cut_mtrl_alpha, R.abc_ic_menu_selectall_mtrl_alpha, R.abc_ic_menu_paste_mtrl_am_alpha, R.abc_ic_menu_moreoverflow_mtrl_alpha, R.abc_ic_voice_search_api_mtrl_alpha};
        f1893f = new int[]{R.abc_textfield_activated_mtrl_alpha, R.abc_textfield_search_activated_mtrl_alpha, R.abc_cab_background_top_mtrl_alpha, R.abc_text_cursor_material};
        f1894g = new int[]{R.abc_popup_background_mtrl_mult, R.abc_cab_background_internal_bg, R.abc_menu_hardkey_panel_mtrl_mult};
        f1895h = new int[]{R.abc_edit_text_material, R.abc_tab_indicator_material, R.abc_textfield_search_material, R.abc_spinner_mtrl_am_alpha, R.abc_spinner_textfield_background_material, R.abc_ratingbar_full_material, R.abc_switch_track_mtrl_alpha, R.abc_switch_thumb_material, R.abc_btn_default_mtrl_shape, R.abc_btn_borderless_material};
        f1896i = new int[]{R.abc_btn_check_material, R.abc_btn_radio_material};
    }

    public static ar m3972a() {
        if (f1889b == null) {
            f1889b = new ar();
            m3976a(f1889b);
        }
        return f1889b;
    }

    private static void m3976a(ar arVar) {
        int i = VERSION.SDK_INT;
        if (i < 21) {
            arVar.m3977a("vector", new aw());
            if (i >= 11) {
                arVar.m3977a("animated-vector", new at());
            }
        }
    }

    public Drawable m3993a(Context context, int i) {
        return m3994a(context, i, false);
    }

    public Drawable m3994a(Context context, int i, boolean z) {
        Drawable c = m3983c(context, i);
        if (c == null) {
            c = ContextCompat.m741a(context, i);
        }
        if (c != null) {
            c = m3970a(context, i, z, c);
        }
        if (c != null) {
            cl.m4238a(c);
        }
        return c;
    }

    private Drawable m3970a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = m3996b(context, i);
        if (b != null) {
            if (cl.m4239b(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = DrawableCompat.m1319f(drawable);
            DrawableCompat.m1309a(drawable, b);
            Mode a = m3992a(i);
            if (a == null) {
                return drawable;
            }
            DrawableCompat.m1312a(drawable, a);
            return drawable;
        } else if (i == R.abc_cab_background_top_material) {
            return new LayerDrawable(new Drawable[]{m3993a(context, R.abc_cab_background_internal_bg), m3993a(context, R.abc_cab_background_top_mtrl_alpha)});
        } else if (i == R.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            m3974a(r0.findDrawableByLayerId(16908288), fw.m4634a(context, R.colorControlNormal), f1888a);
            m3974a(r0.findDrawableByLayerId(16908303), fw.m4634a(context, R.colorControlNormal), f1888a);
            m3974a(r0.findDrawableByLayerId(16908301), fw.m4634a(context, R.colorControlActivated), f1888a);
            return drawable;
        } else if (i == R.abc_ratingbar_indicator_material || i == R.abc_ratingbar_small_material) {
            r0 = (LayerDrawable) drawable;
            m3974a(r0.findDrawableByLayerId(16908288), fw.m4638c(context, R.colorControlNormal), f1888a);
            m3974a(r0.findDrawableByLayerId(16908303), fw.m4634a(context, R.colorControlActivated), f1888a);
            m3974a(r0.findDrawableByLayerId(16908301), fw.m4634a(context, R.colorControlActivated), f1888a);
            return drawable;
        } else if (m3978a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m3983c(android.content.Context r11, int r12) {
        /*
        r10 = this;
        r1 = 0;
        r9 = 2;
        r8 = 1;
        r0 = r10.f1898k;
        if (r0 == 0) goto L_0x00c5;
    L_0x0007:
        r0 = r10.f1898k;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00c5;
    L_0x000f:
        r0 = r10.f1899l;
        if (r0 == 0) goto L_0x002f;
    L_0x0013:
        r0 = r10.f1899l;
        r0 = r0.get(r12);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002d;
    L_0x0023:
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r2 = r10.f1898k;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0036;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = new android.util.SparseArray;
        r0.<init>();
        r10.f1899l = r0;
    L_0x0036:
        r0 = r10.f1902o;
        if (r0 != 0) goto L_0x0041;
    L_0x003a:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r10.f1902o = r0;
    L_0x0041:
        r2 = r10.f1902o;
        r0 = r11.getResources();
        r0.getValue(r12, r2, r8);
        r1 = r2.assetCookie;
        r4 = (long) r1;
        r1 = 32;
        r4 = r4 << r1;
        r1 = r2.data;
        r6 = (long) r1;
        r4 = r4 | r6;
        r1 = r10.m3971a(r11, r4);
        if (r1 == 0) goto L_0x005c;
    L_0x005a:
        r0 = r1;
        goto L_0x002e;
    L_0x005c:
        r3 = r2.string;
        if (r3 == 0) goto L_0x0090;
    L_0x0060:
        r3 = r2.string;
        r3 = r3.toString();
        r6 = ".xml";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x0090;
    L_0x006e:
        r3 = r0.getXml(r12);	 Catch:{ Exception -> 0x0088 }
        r6 = android.util.Xml.asAttributeSet(r3);	 Catch:{ Exception -> 0x0088 }
    L_0x0076:
        r0 = r3.next();	 Catch:{ Exception -> 0x0088 }
        if (r0 == r9) goto L_0x007e;
    L_0x007c:
        if (r0 != r8) goto L_0x0076;
    L_0x007e:
        if (r0 == r9) goto L_0x009b;
    L_0x0080:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x0088 }
        r2 = "No start tag found";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0088 }
        throw r0;	 Catch:{ Exception -> 0x0088 }
    L_0x0088:
        r0 = move-exception;
        r2 = "AppCompatDrawableManager";
        r3 = "Exception while inflating drawable";
        android.util.Log.e(r2, r3, r0);
    L_0x0090:
        r0 = r1;
    L_0x0091:
        if (r0 != 0) goto L_0x002e;
    L_0x0093:
        r1 = r10.f1899l;
        r2 = "appcompat_skip_skip";
        r1.append(r12, r2);
        goto L_0x002e;
    L_0x009b:
        r0 = r3.getName();	 Catch:{ Exception -> 0x0088 }
        r7 = r10.f1899l;	 Catch:{ Exception -> 0x0088 }
        r7.append(r12, r0);	 Catch:{ Exception -> 0x0088 }
        r7 = r10.f1898k;	 Catch:{ Exception -> 0x0088 }
        r0 = r7.get(r0);	 Catch:{ Exception -> 0x0088 }
        r0 = (android.support.v7.widget.av) r0;	 Catch:{ Exception -> 0x0088 }
        if (r0 == 0) goto L_0x00b6;
    L_0x00ae:
        r7 = r11.getTheme();	 Catch:{ Exception -> 0x0088 }
        r1 = r0.m3997a(r11, r3, r6, r7);	 Catch:{ Exception -> 0x0088 }
    L_0x00b6:
        if (r1 == 0) goto L_0x00c3;
    L_0x00b8:
        r0 = r2.changingConfigurations;	 Catch:{ Exception -> 0x0088 }
        r1.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x0088 }
        r0 = r10.m3979a(r11, r4, r1);	 Catch:{ Exception -> 0x0088 }
        if (r0 == 0) goto L_0x00c3;
    L_0x00c3:
        r0 = r1;
        goto L_0x0091;
    L_0x00c5:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ar.c(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private Drawable m3971a(Context context, long j) {
        synchronized (this.f1900m) {
            LongSparseArray longSparseArray = (LongSparseArray) this.f1901n.get(context);
            if (longSparseArray == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) longSparseArray.m1505a(j);
            if (weakReference != null) {
                ConstantState constantState = (ConstantState) weakReference.get();
                if (constantState != null) {
                    Drawable newDrawable = constantState.newDrawable(context.getResources());
                    return newDrawable;
                }
                longSparseArray.m1510b(j);
            }
            return null;
        }
    }

    private boolean m3979a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.f1900m) {
            LongSparseArray longSparseArray = (LongSparseArray) this.f1901n.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray();
                this.f1901n.put(context, longSparseArray);
            }
            longSparseArray.m1511b(j, new WeakReference(constantState));
        }
        return true;
    }

    public final Drawable m3995a(Context context, ga gaVar, int i) {
        Drawable c = m3983c(context, i);
        if (c == null) {
            c = gaVar.m4644a(i);
        }
        if (c != null) {
            return m3970a(context, i, false, c);
        }
        return null;
    }

    private static boolean m3978a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = f1888a;
        if (m3980a(f1891d, i)) {
            i2 = R.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (m3980a(f1893f, i)) {
            i2 = R.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (m3980a(f1894g, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == R.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (cl.m4239b(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(m3968a(fw.m4634a(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private void m3977a(String str, av avVar) {
        if (this.f1898k == null) {
            this.f1898k = new ArrayMap();
        }
        this.f1898k.put(str, avVar);
    }

    private static boolean m3980a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    final Mode m3992a(int i) {
        if (i == R.abc_switch_thumb_material) {
            return Mode.MULTIPLY;
        }
        return null;
    }

    public final ColorStateList m3996b(Context context, int i) {
        ColorStateList d = m3985d(context, i);
        if (d == null) {
            if (i == R.abc_edit_text_material) {
                d = m3986e(context);
            } else if (i == R.abc_switch_track_mtrl_alpha) {
                d = m3982c(context);
            } else if (i == R.abc_switch_thumb_material) {
                d = m3984d(context);
            } else if (i == R.abc_btn_default_mtrl_shape || i == R.abc_btn_borderless_material) {
                d = m3988f(context);
            } else if (i == R.abc_btn_colored_material) {
                d = m3989g(context);
            } else if (i == R.abc_spinner_mtrl_am_alpha || i == R.abc_spinner_textfield_background_material) {
                d = m3990h(context);
            } else if (m3980a(f1892e, i)) {
                d = fw.m4637b(context, R.colorControlNormal);
            } else if (m3980a(f1895h, i)) {
                d = m3967a(context);
            } else if (m3980a(f1896i, i)) {
                d = m3981b(context);
            } else if (i == R.abc_seekbar_thumb_material) {
                d = m3991i(context);
            }
            if (d != null) {
                m3973a(context, i, d);
            }
        }
        return d;
    }

    private ColorStateList m3985d(Context context, int i) {
        if (this.f1897j == null) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.f1897j.get(context);
        if (sparseArray != null) {
            return (ColorStateList) sparseArray.get(i);
        }
        return null;
    }

    private void m3973a(Context context, int i, ColorStateList colorStateList) {
        if (this.f1897j == null) {
            this.f1897j = new WeakHashMap();
        }
        SparseArray sparseArray = (SparseArray) this.f1897j.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.f1897j.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    private ColorStateList m3967a(Context context) {
        int a = fw.m4634a(context, R.colorControlNormal);
        int a2 = fw.m4634a(context, R.colorControlActivated);
        r2 = new int[7][];
        int[] iArr = new int[]{fw.f2281a, fw.m4638c(context, R.colorControlNormal), fw.f2282b, a2, fw.f2283c, a2, fw.f2284d};
        iArr[3] = a2;
        r2[4] = fw.f2285e;
        iArr[4] = a2;
        r2[5] = fw.f2286f;
        iArr[5] = a2;
        r2[6] = fw.f2288h;
        iArr[6] = a;
        return new ColorStateList(r2, iArr);
    }

    private ColorStateList m3981b(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{fw.f2281a, fw.m4638c(context, R.colorControlNormal), fw.f2285e};
        iArr[1] = fw.m4634a(context, R.colorControlActivated);
        r0[2] = fw.f2288h;
        iArr[2] = fw.m4634a(context, R.colorControlNormal);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m3982c(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{fw.f2281a, fw.m4635a(context, 16842800, 0.1f), fw.f2285e};
        iArr[1] = fw.m4635a(context, R.colorControlActivated, 0.3f);
        r0[2] = fw.f2288h;
        iArr[2] = fw.m4635a(context, 16842800, 0.3f);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m3984d(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = fw.m4637b(context, R.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = fw.f2281a;
            iArr2[0] = fw.m4638c(context, R.colorSwitchThumbNormal);
            iArr[1] = fw.f2285e;
            iArr2[1] = fw.m4634a(context, R.colorControlActivated);
            iArr[2] = fw.f2288h;
            iArr2[2] = fw.m4634a(context, R.colorSwitchThumbNormal);
        } else {
            iArr[0] = fw.f2281a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = fw.f2285e;
            iArr2[1] = fw.m4634a(context, R.colorControlActivated);
            iArr[2] = fw.f2288h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList m3986e(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{fw.f2281a, fw.m4638c(context, R.colorControlNormal), fw.f2287g};
        iArr[1] = fw.m4634a(context, R.colorControlNormal);
        r0[2] = fw.f2288h;
        iArr[2] = fw.m4634a(context, R.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m3988f(Context context) {
        return m3987e(context, R.colorButtonNormal);
    }

    private ColorStateList m3989g(Context context) {
        return m3987e(context, R.colorAccent);
    }

    private ColorStateList m3987e(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = fw.m4634a(context, i);
        int a2 = fw.m4634a(context, R.colorControlHighlight);
        r0[0] = fw.f2281a;
        r1[0] = fw.m4638c(context, R.colorButtonNormal);
        r0[1] = fw.f2284d;
        r1[1] = ColorUtils.m1423a(a2, a);
        r0[2] = fw.f2282b;
        r1[2] = ColorUtils.m1423a(a2, a);
        r0[3] = fw.f2288h;
        r1[3] = a;
        return new ColorStateList(r0, r1);
    }

    private ColorStateList m3990h(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{fw.f2281a, fw.m4638c(context, R.colorControlNormal), fw.f2287g};
        iArr[1] = fw.m4634a(context, R.colorControlNormal);
        r0[2] = fw.f2288h;
        iArr[2] = fw.m4634a(context, R.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m3991i(Context context) {
        r0 = new int[2][];
        int[] iArr = new int[]{fw.f2281a, fw.m4638c(context, R.colorControlActivated)};
        r0[1] = fw.f2288h;
        iArr[1] = fw.m4634a(context, R.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    public static void m3975a(Drawable drawable, fz fzVar, int[] iArr) {
        if (!cl.m4239b(drawable) || drawable.mutate() == drawable) {
            if (fzVar.f2297d || fzVar.f2296c) {
                drawable.setColorFilter(m3969a(fzVar.f2297d ? fzVar.f2294a : null, fzVar.f2296c ? fzVar.f2295b : f1888a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    private static PorterDuffColorFilter m3969a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m3968a(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static PorterDuffColorFilter m3968a(int i, Mode mode) {
        PorterDuffColorFilter a = f1890c.m4000a(i, mode);
        if (a != null) {
            return a;
        }
        a = new PorterDuffColorFilter(i, mode);
        f1890c.m4001a(i, mode, a);
        return a;
    }

    private static void m3974a(Drawable drawable, int i, Mode mode) {
        if (cl.m4239b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f1888a;
        }
        drawable.setColorFilter(m3968a(i, mode));
    }
}
