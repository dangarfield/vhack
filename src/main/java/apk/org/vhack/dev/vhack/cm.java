package org.vhack.dev.vhack;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Process;

/* compiled from: MainActivity */
class cm implements OnClickListener {
    final /* synthetic */ MainActivity a;

    cm(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.S = false;
        this.a.finish();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        this.a.startActivity(intent);
        Process.killProcess(Process.myPid());
    }
}
