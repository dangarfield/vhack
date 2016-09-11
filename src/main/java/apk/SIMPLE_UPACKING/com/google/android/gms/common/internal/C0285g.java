package com.google.android.gms.common.internal;

import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.Arrays;

/* renamed from: com.google.android.gms.common.internal.g */
public abstract class C0285g {
    public static final C0285g f4421a;
    public static final C0285g f4422b;
    public static final C0285g f4423c;
    public static final C0285g f4424d;
    public static final C0285g f4425e;
    public static final C0285g f4426f;
    public static final C0285g f4427g;
    public static final C0285g f4428h;
    public static final C0285g f4429i;
    public static final C0285g f4430j;
    public static final C0285g f4431k;
    public static final C0285g f4432l;
    public static final C0285g f4433m;
    public static final C0285g f4434n;
    public static final C0285g f4435o;

    static {
        f4421a = C0285g.m7900a((CharSequence) "\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000\u00a0\u180e\u202f").m7901a(C0285g.m7899a('\u2000', '\u200a'));
        f4422b = C0285g.m7900a((CharSequence) "\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").m7901a(C0285g.m7899a('\u2000', '\u2006')).m7901a(C0285g.m7899a('\u2008', '\u200a'));
        f4423c = C0285g.m7899a('\u0000', '\u007f');
        C0285g a = C0285g.m7899a('0', '9');
        C0285g c0285g = a;
        for (char c : "\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".toCharArray()) {
            c0285g = c0285g.m7901a(C0285g.m7899a(c, (char) (c + 9)));
        }
        f4424d = c0285g;
        f4425e = C0285g.m7899a('\t', '\r').m7901a(C0285g.m7899a('\u001c', ' ')).m7901a(C0285g.m7898a('\u1680')).m7901a(C0285g.m7898a('\u180e')).m7901a(C0285g.m7899a('\u2000', '\u2006')).m7901a(C0285g.m7899a('\u2008', '\u200b')).m7901a(C0285g.m7899a('\u2028', '\u2029')).m7901a(C0285g.m7898a('\u205f')).m7901a(C0285g.m7898a('\u3000'));
        f4426f = new C0286h();
        f4427g = new C0292n();
        f4428h = new C0293o();
        f4429i = new C0294p();
        f4430j = new C0295q();
        f4431k = C0285g.m7899a('\u0000', '\u001f').m7901a(C0285g.m7899a('\u007f', '\u009f'));
        f4432l = C0285g.m7899a('\u0000', ' ').m7901a(C0285g.m7899a('\u007f', '\u00a0')).m7901a(C0285g.m7898a('\u00ad')).m7901a(C0285g.m7899a('\u0600', '\u0603')).m7901a(C0285g.m7900a((CharSequence) "\u06dd\u070f\u1680\u17b4\u17b5\u180e")).m7901a(C0285g.m7899a('\u2000', '\u200f')).m7901a(C0285g.m7899a('\u2028', '\u202f')).m7901a(C0285g.m7899a('\u205f', '\u2064')).m7901a(C0285g.m7899a('\u206a', '\u206f')).m7901a(C0285g.m7898a('\u3000')).m7901a(C0285g.m7899a('\ud800', '\uf8ff')).m7901a(C0285g.m7900a((CharSequence) "\ufeff\ufff9\ufffa\ufffb"));
        f4433m = C0285g.m7899a('\u0000', '\u04f9').m7901a(C0285g.m7898a('\u05be')).m7901a(C0285g.m7899a('\u05d0', '\u05ea')).m7901a(C0285g.m7898a('\u05f3')).m7901a(C0285g.m7898a('\u05f4')).m7901a(C0285g.m7899a('\u0600', '\u06ff')).m7901a(C0285g.m7899a('\u0750', '\u077f')).m7901a(C0285g.m7899a('\u0e00', '\u0e7f')).m7901a(C0285g.m7899a('\u1e00', '\u20af')).m7901a(C0285g.m7899a('\u2100', '\u213a')).m7901a(C0285g.m7899a('\ufb50', '\ufdff')).m7901a(C0285g.m7899a('\ufe70', '\ufeff')).m7901a(C0285g.m7899a('\uff61', '\uffdc'));
        f4434n = new C0296r();
        f4435o = new C0287i();
    }

    public static C0285g m7898a(char c) {
        return new C0288j(c);
    }

    public static C0285g m7899a(char c, char c2) {
        bf.m7881b(c2 >= c);
        return new C0291m(c, c2);
    }

    public static C0285g m7900a(CharSequence charSequence) {
        switch (charSequence.length()) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                return f4435o;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return C0285g.m7898a(charSequence.charAt(0));
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return new C0289k(charSequence.charAt(0), charSequence.charAt(1));
            default:
                char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new C0290l(toCharArray);
        }
    }

    public C0285g m7901a(C0285g c0285g) {
        return new C0297s(Arrays.asList(new C0285g[]{this, (C0285g) bf.m7873a((Object) c0285g)}));
    }

    public abstract boolean m7902b(char c);

    public boolean m7903b(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!m7902b(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
