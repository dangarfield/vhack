package android.support.v7.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

/* compiled from: ActivityChooserModel */
public final class ab implements Comparable {
    public final ResolveInfo f1842a;
    public float f1843b;
    final /* synthetic */ ActivityChooserModel f1844c;

    public /* synthetic */ int compareTo(Object obj) {
        return m3901a((ab) obj);
    }

    public ab(ActivityChooserModel activityChooserModel, ResolveInfo resolveInfo) {
        this.f1844c = activityChooserModel;
        this.f1842a = resolveInfo;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f1843b) + 31;
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
        if (Float.floatToIntBits(this.f1843b) != Float.floatToIntBits(((ab) obj).f1843b)) {
            return false;
        }
        return true;
    }

    public int m3901a(ab abVar) {
        return Float.floatToIntBits(abVar.f1843b) - Float.floatToIntBits(this.f1843b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("resolveInfo:").append(this.f1842a.toString());
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.f1843b));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
