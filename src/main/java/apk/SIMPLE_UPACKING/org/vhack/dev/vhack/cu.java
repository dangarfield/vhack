package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/* compiled from: MainActivity */
class cu implements OnClickListener {
    final /* synthetic */ MainActivity f5357a;

    cu(MainActivity mainActivity) {
        this.f5357a = mainActivity;
    }

    public void onClick(View view) {
        this.f5357a.f5124m.start();
        String obj = this.f5357a.f5105I.getText().toString();
        Editor edit = this.f5357a.getSharedPreferences("loginData.xml", 0).edit();
        edit.putString("notepad", obj);
        edit.commit();
        Toast.makeText(this.f5357a, "Saved.", 1).show();
        this.f5357a.m9019a(this.f5357a.f5105I);
    }
}
