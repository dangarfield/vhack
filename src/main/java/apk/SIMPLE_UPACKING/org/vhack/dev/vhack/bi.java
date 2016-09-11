package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/* compiled from: ConsoleActivity */
class bi implements OnClickListener {
    final /* synthetic */ ConsoleActivity f5298a;

    bi(ConsoleActivity consoleActivity) {
        this.f5298a = consoleActivity;
    }

    public void onClick(View view) {
        String charSequence = ((TextView) this.f5298a.findViewById(2131558688)).getText().toString();
        TextView textView = (TextView) this.f5298a.findViewById(2131558686);
        textView.setText("vHack XT [Version 1.15]\n\n");
        if (charSequence.length() <= 5 || !charSequence.contains(".")) {
            textView.append(this.f5298a.getString(2131165424));
            return;
        }
        this.f5298a.f5047t = charSequence;
        new bl(this.f5298a).execute(new String[]{charSequence});
    }
}
