package org.vhack.dev.vhack;

import android.widget.TextView;

/* compiled from: TasksActivity */
class fl implements Runnable {
    final /* synthetic */ fk a;

    fl(fk fkVar) {
        this.a = fkVar;
    }

    public void run() {
        if (this.a.a.E) {
            this.a.a.E = false;
        }
        String l = Long.toString(System.currentTimeMillis());
        ((TextView) this.a.a.findViewById(2131558946)).setText(this.a.a.q);
        long parseLong = Long.parseLong(l.substring(0, 10));
        if (this.a.a.z != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.a.a.z.length; i2++) {
                String str = this.a.a.x[i2];
                String str2 = this.a.a.y[i2];
                long parseLong2 = Long.parseLong(str.substring(0, 10)) - parseLong;
                long parseLong3 = Long.parseLong(str.substring(0, 10)) - Long.parseLong(str2.substring(0, 10));
                if (Math.round((float) ((100 * (parseLong - Long.parseLong(str2.substring(0, 10)))) / parseLong3)) > 100) {
                    this.a.a.s[i2] = "100";
                } else {
                    this.a.a.s[i2] = Math.round((float) ((100 * (parseLong - Long.parseLong(str2.substring(0, 10)))) / parseLong3)) + "";
                    i++;
                }
                str = str.substring(0, 10);
                this.a.a.t[i2] = parseLong2 + "";
                this.a.a.u[i2] = parseLong2 + "";
                if (parseLong > Long.parseLong(str)) {
                    this.a.a.E = false;
                }
            }
            ((TextView) this.a.a.findViewById(2131558948)).setText(i + this.a.a.getString(2131165415));
            if (this.a.a.C != null) {
                this.a.a.C.notifyDataSetChanged();
                return;
            }
            return;
        }
        ((TextView) this.a.a.findViewById(2131558948)).setText("");
    }
}
