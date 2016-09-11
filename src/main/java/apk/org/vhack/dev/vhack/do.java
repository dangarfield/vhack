package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/* compiled from: MainActivity */
class do implements OnClickListener {
    final /* synthetic */ MainActivity a;

    do(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(View view) {
        this.a.m.start();
        Editor edit = this.a.getSharedPreferences("ChatData.xml", 0).edit();
        EditText editText = (EditText) this.a.findViewById(2131558850);
        edit.putString("msg", editText.getText().toString().replace("<", "").replace(">", "").replace("'", ""));
        edit.commit();
        editText.setText("");
    }
}
