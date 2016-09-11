package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/* compiled from: GameActivity */
class bw implements OnClickListener {
    final /* synthetic */ GameActivity a;

    bw(GameActivity gameActivity) {
        this.a = gameActivity;
    }

    public void onClick(View view) {
        String str = "";
        str = ((TextView) this.a.findViewById(2131558767)).getText().toString();
        if (str.contains("@") && str.contains(".") && str.length() >= 10) {
            new bz(this.a).execute(new String[]{str});
            return;
        }
        Toast.makeText(this.a.getApplicationContext(), "Please enter a valid E-Mail address.", 0).show();
    }
}
