package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/* compiled from: GameActivity */
class bx implements OnClickListener {
    final /* synthetic */ GameActivity a;

    bx(GameActivity gameActivity) {
        this.a = gameActivity;
    }

    public void onClick(View view) {
        this.a.m = this.a.t.getText().toString();
        this.a.n = this.a.u.getText().toString();
        this.a.o = this.a.v.getText().toString();
        if (this.a.m.equals("") || this.a.m.equals("Username") || this.a.m.length() < 6 || this.a.m.length() >= 15) {
            Toast.makeText(this.a, 2131165330, 1).show();
        } else if (this.a.n.equals("") || this.a.n.equals("Password") || this.a.n.length() < 6 || this.a.n.length() >= 15) {
            Toast.makeText(this.a, 2131165329, 1).show();
        } else if (this.a.o.equals("") || this.a.o.equals("EMail") || this.a.o.length() < 10 || !this.a.o.contains("@") || !this.a.o.contains(".")) {
            Toast.makeText(this.a, 2131165328, 1).show();
        } else {
            new ca(this.a).execute(new String[]{this.a.m, this.a.n, this.a.o});
        }
    }
}
