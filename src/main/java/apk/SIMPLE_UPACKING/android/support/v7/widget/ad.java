package android.support.v7.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

/* compiled from: ActivityChooserModel */
public final class ad {
    public final ComponentName f1845a;
    public final long f1846b;
    public final float f1847c;

    public ad(String str, long j, float f) {
        this(ComponentName.unflattenFromString(str), j, f);
    }

    public ad(ComponentName componentName, long j, float f) {
        this.f1845a = componentName;
        this.f1846b = j;
        this.f1847c = f;
    }

    public int hashCode() {
        return (((((this.f1845a == null ? 0 : this.f1845a.hashCode()) + 31) * 31) + ((int) (this.f1846b ^ (this.f1846b >>> 32)))) * 31) + Float.floatToIntBits(this.f1847c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ad adVar = (ad) obj;
        if (this.f1845a == null) {
            if (adVar.f1845a != null) {
                return false;
            }
        } else if (!this.f1845a.equals(adVar.f1845a)) {
            return false;
        }
        if (this.f1846b != adVar.f1846b) {
            return false;
        }
        if (Float.floatToIntBits(this.f1847c) != Float.floatToIntBits(adVar.f1847c)) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("; activity:").append(this.f1845a);
        stringBuilder.append("; time:").append(this.f1846b);
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.f1847c));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
