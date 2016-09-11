package android.support.v4.p007b;

import android.support.v4.p005e.OperationCanceledException;
import java.util.concurrent.CountDownLatch;

/* renamed from: android.support.v4.b.b */
final class AsyncTaskLoader extends ModernAsyncTask implements Runnable {
    boolean f794a;
    final /* synthetic */ AsyncTaskLoader f795b;
    private final CountDownLatch f796d;

    AsyncTaskLoader(AsyncTaskLoader asyncTaskLoader) {
        this.f795b = asyncTaskLoader;
        this.f796d = new CountDownLatch(1);
    }

    protected Object m1289a(Void... voidArr) {
        try {
            return this.f795b.m1269e();
        } catch (OperationCanceledException e) {
            if (m1287c()) {
                return null;
            }
            throw e;
        }
    }

    protected void m1290a(Object obj) {
        try {
            this.f795b.m1265b(this, obj);
        } finally {
            this.f796d.countDown();
        }
    }

    protected void m1291b(Object obj) {
        try {
            this.f795b.m1262a(this, obj);
        } finally {
            this.f796d.countDown();
        }
    }

    public void run() {
        this.f794a = false;
        this.f795b.m1267c();
    }
}
