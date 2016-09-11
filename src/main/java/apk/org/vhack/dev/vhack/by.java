package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/* compiled from: GameActivity */
class by implements OnClickListener {
    final /* synthetic */ GameActivity a;

    by(GameActivity gameActivity) {
        this.a = gameActivity;
    }

    public void onClick(View view) {
        String obj = ((EditText) this.a.findViewById(2131558761)).getText().toString();
        String obj2 = ((EditText) this.a.findViewById(2131558759)).getText().toString();
        if (!obj2.equals("") && !obj.equals("")) {
            this.a.m = obj;
            this.a.n = obj2;
            Editor edit = this.a.getSharedPreferences("loginData.xml", 0).edit();
            edit.putString("strUser", this.a.m);
            edit.putString("strPass", this.a.n);
            edit.commit();
            new cb(this.a).execute(new String[0]);
        }
    }
}
