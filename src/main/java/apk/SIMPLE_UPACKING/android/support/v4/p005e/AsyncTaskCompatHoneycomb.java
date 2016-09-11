package android.support.v4.p005e;

import android.os.AsyncTask;

/* renamed from: android.support.v4.e.b */
class AsyncTaskCompatHoneycomb {
    static void m1431a(AsyncTask asyncTask, Object... objArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
    }
}
