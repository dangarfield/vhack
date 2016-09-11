package com.fyber.ads.videos.p031a;

/* renamed from: com.fyber.ads.videos.a.a */
public enum NativeVideoPlayerEvent {
    PlayingEvent("playing"),
    TimeUpdateEvent("timeupdate"),
    EndedEvent("ended"),
    ClickThroughEvent("clickThrough"),
    CancelEvent("cancel");
    
    private final String f2515f;

    private NativeVideoPlayerEvent(String str) {
        this.f2515f = str;
    }

    public final String toString() {
        return this.f2515f;
    }
}
