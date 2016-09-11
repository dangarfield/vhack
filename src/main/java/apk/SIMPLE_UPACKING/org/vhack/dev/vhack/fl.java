package org.vhack.dev.vhack;

import android.widget.TextView;

/* compiled from: TasksActivity */
class fl implements Runnable {
    final /* synthetic */ fk f5462a;

    fl(fk fkVar) {
        this.f5462a = fkVar;
    }

    public void run() {
        if (this.f5462a.f5461a.f5193E) {
            this.f5462a.f5461a.f5193E = false;
        }
        String l = Long.toString(System.currentTimeMillis());
        ((TextView) this.f5462a.f5461a.findViewById(2131558946)).setText(this.f5462a.f5461a.f5201q);
        long parseLong = Long.parseLong(l.substring(0, 10));
        if (this.f5462a.f5461a.f5210z != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.f5462a.f5461a.f5210z.length; i2++) {
                String str = this.f5462a.f5461a.f5208x[i2];
                String str2 = this.f5462a.f5461a.f5209y[i2];
                long parseLong2 = Long.parseLong(str.substring(0, 10)) - parseLong;
                long parseLong3 = Long.parseLong(str.substring(0, 10)) - Long.parseLong(str2.substring(0, 10));
                if (Math.round((float) ((100 * (parseLong - Long.parseLong(str2.substring(0, 10)))) / parseLong3)) > 100) {
                    this.f5462a.f5461a.f5203s[i2] = "100";
                } else {
                    this.f5462a.f5461a.f5203s[i2] = Math.round((float) ((100 * (parseLong - Long.parseLong(str2.substring(0, 10)))) / parseLong3)) + "";
                    i++;
                }
                str = str.substring(0, 10);
                this.f5462a.f5461a.f5204t[i2] = parseLong2 + "";
                this.f5462a.f5461a.f5205u[i2] = parseLong2 + "";
                if (parseLong > Long.parseLong(str)) {
                    this.f5462a.f5461a.f5193E = false;
                }
            }
            ((TextView) this.f5462a.f5461a.findViewById(2131558948)).setText(i + this.f5462a.f5461a.getString(2131165415));
            if (this.f5462a.f5461a.f5191C != null) {
                this.f5462a.f5461a.f5191C.notifyDataSetChanged();
                return;
            }
            return;
        }
        ((TextView) this.f5462a.f5461a.findViewById(2131558948)).setText("");
    }
}
