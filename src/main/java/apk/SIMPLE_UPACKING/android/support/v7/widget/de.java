package android.support.v7.widget;

/* compiled from: ListPopupWindow */
class de implements Runnable {
    final /* synthetic */ dd f2120a;

    private de(dd ddVar) {
        this.f2120a = ddVar;
    }

    public void run() {
        this.f2120a.f1497d.getParent().requestDisallowInterceptTouchEvent(true);
    }
}
