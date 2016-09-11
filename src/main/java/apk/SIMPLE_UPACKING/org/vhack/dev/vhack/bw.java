package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/* compiled from: GameActivity */
class bw implements OnClickListener {
    final /* synthetic */ GameActivity f5318a;

    bw(GameActivity gameActivity) {
        this.f5318a = gameActivity;
    }

    public void onClick(View view) {
        String str = "";
        str = ((TextView) this.f5318a.findViewById(2131558767)).getText().toString();
        if (str.contains("@") && str.contains(".") && str.length() >= 10) {
            new bz(this.f5318a).execute(new String[]{str});
            return;
        }
        Toast.makeText(this.f5318a.getApplicationContext(), "Please enter a valid E-Mail address.", 0).show();
    }
}
