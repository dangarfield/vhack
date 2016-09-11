package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/* compiled from: GameActivity */
class by implements OnClickListener {
    final /* synthetic */ GameActivity f5320a;

    by(GameActivity gameActivity) {
        this.f5320a = gameActivity;
    }

    public void onClick(View view) {
        String obj = ((EditText) this.f5320a.findViewById(2131558761)).getText().toString();
        String obj2 = ((EditText) this.f5320a.findViewById(2131558759)).getText().toString();
        if (!obj2.equals("") && !obj.equals("")) {
            this.f5320a.f5059m = obj;
            this.f5320a.f5060n = obj2;
            Editor edit = this.f5320a.getSharedPreferences("loginData.xml", 0).edit();
            edit.putString("strUser", this.f5320a.f5059m);
            edit.putString("strPass", this.f5320a.f5060n);
            edit.commit();
            new cb(this.f5320a).execute(new String[0]);
        }
    }
}
