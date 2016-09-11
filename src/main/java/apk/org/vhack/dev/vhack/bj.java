package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/* compiled from: ConsoleActivity */
class bj implements OnClickListener {
    final /* synthetic */ ConsoleActivity a;

    bj(ConsoleActivity consoleActivity) {
        this.a = consoleActivity;
    }

    public void onClick(View view) {
        String charSequence = ((TextView) this.a.findViewById(2131558688)).getText().toString();
        TextView textView = (TextView) this.a.findViewById(2131558686);
        textView.setText("vHack XT [Version 1.15]\n\n");
        if (charSequence.length() <= 5 || !charSequence.contains(".")) {
            textView.append(this.a.getString(2131165405));
            return;
        }
        new bk(this.a).execute(new String[]{charSequence});
        String str = "";
    }
}
