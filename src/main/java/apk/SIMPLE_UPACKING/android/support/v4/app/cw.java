package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;

/* compiled from: RemoteInputCompatApi20 */
class cw {
    static RemoteInput[] m1056a(cy[] cyVarArr) {
        if (cyVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[cyVarArr.length];
        for (int i = 0; i < cyVarArr.length; i++) {
            cy cyVar = cyVarArr[i];
            remoteInputArr[i] = new Builder(cyVar.m1046a()).setLabel(cyVar.m1047b()).setChoices(cyVar.m1048c()).setAllowFreeFormInput(cyVar.m1049d()).addExtras(cyVar.m1050e()).build();
        }
        return remoteInputArr;
    }
}
