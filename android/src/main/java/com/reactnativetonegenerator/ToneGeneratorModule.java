package com.reactnativetonegenerator;

import android.content.Context;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = ToneGeneratorModule.NAME)
public class ToneGeneratorModule extends ReactContextBaseJavaModule {
    public static final String NAME = "ToneGenerator";
    private final ReactApplicationContext reactContext;
    private final ToneGenerator toneGenerator = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);

    public ToneGeneratorModule(ReactApplicationContext reactContext) {
      super(reactContext);
      this.reactContext = reactContext;
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void startTone(int toneType, int durationMs, Promise promise) {
      toneGenerator.stopTone();
      toneGenerator.startTone(toneType, durationMs);
      promise.resolve(null);
    }

    @ReactMethod
    public void stopTone(Promise promise) {
      toneGenerator.stopTone();
      promise.resolve(null);
    }

    @ReactMethod
    public void setStreamVolume(int index, int flags, Promise promise) {
      AudioManager audioManager = (AudioManager) reactContext.getSystemService(Context.AUDIO_SERVICE);
      audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, index, flags);
      promise.resolve(null);
    }

    @ReactMethod
    public void getStreamMaxVolume(Promise promise) {
      AudioManager audioManager = (AudioManager) reactContext.getSystemService(Context.AUDIO_SERVICE);
      promise.resolve(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
    }

    public static native int nativeStartTone(int toneType, int durationMs);
    public static native int nativeStopTone();
    public static native int nativeSetStreamVolume(int toneType, int durationMs);
    public static native int nativeGetStreamMaxVolume(int toneType, int durationMs);

}
