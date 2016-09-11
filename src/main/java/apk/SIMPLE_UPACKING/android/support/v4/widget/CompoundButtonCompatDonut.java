package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.k */
class CompoundButtonCompatDonut {
    private static Field f1069a;
    private static boolean f1070b;

    static void m2673a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof bi) {
            ((bi) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    static void m2674a(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof bi) {
            ((bi) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    static Drawable m2672a(CompoundButton compoundButton) {
        if (!f1070b) {
            try {
                f1069a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f1069a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", e);
            }
            f1070b = true;
        }
        if (f1069a != null) {
            try {
                return (Drawable) f1069a.get(compoundButton);
            } catch (Throwable e2) {
                Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", e2);
                f1069a = null;
            }
        }
        return null;
    }
}
