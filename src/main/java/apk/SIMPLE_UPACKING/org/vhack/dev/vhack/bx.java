package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/* compiled from: GameActivity */
class bx implements OnClickListener {
    final /* synthetic */ GameActivity f5319a;

    bx(GameActivity gameActivity) {
        this.f5319a = gameActivity;
    }

    public void onClick(View view) {
        this.f5319a.f5059m = this.f5319a.f5066t.getText().toString();
        this.f5319a.f5060n = this.f5319a.f5067u.getText().toString();
        this.f5319a.f5061o = this.f5319a.f5068v.getText().toString();
        if (this.f5319a.f5059m.equals("") || this.f5319a.f5059m.equals("Username") || this.f5319a.f5059m.length() < 6 || this.f5319a.f5059m.length() >= 15) {
            Toast.makeText(this.f5319a, 2131165330, 1).show();
        } else if (this.f5319a.f5060n.equals("") || this.f5319a.f5060n.equals("Password") || this.f5319a.f5060n.length() < 6 || this.f5319a.f5060n.length() >= 15) {
            Toast.makeText(this.f5319a, 2131165329, 1).show();
        } else if (this.f5319a.f5061o.equals("") || this.f5319a.f5061o.equals("EMail") || this.f5319a.f5061o.length() < 10 || !this.f5319a.f5061o.contains("@") || !this.f5319a.f5061o.contains(".")) {
            Toast.makeText(this.f5319a, 2131165328, 1).show();
        } else {
            new ca(this.f5319a).execute(new String[]{this.f5319a.f5059m, this.f5319a.f5060n, this.f5319a.f5061o});
        }
    }
}
