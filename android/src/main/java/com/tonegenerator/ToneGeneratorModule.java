package com.tonegenerator;

import androidx.annotation.NonNull;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.content.Context;
import android.os.Build;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = ToneGeneratorModule.NAME)
public class ToneGeneratorModule extends ReactContextBaseJavaModule {
  public static final String NAME = "ToneGenerator";
  private final ReactApplicationContext reactContext;
  private ToneGenerator toneGenerator = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);

  public ToneGeneratorModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void configureTone(int streamType, int volume, Promise promise) {
    toneGenerator = new ToneGenerator(streamType, volume);
    promise.resolve(null);
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
  public void getStreamMinVolume(int streamType, Promise promise) {
    AudioManager audioManager = (AudioManager) reactContext.getSystemService(Context.AUDIO_SERVICE);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
      promise.resolve(audioManager.getStreamMinVolume(streamType));
    } else {
      promise.resolve(null);
    }
  }

  @ReactMethod
  public void getStreamMaxVolume(int streamType, Promise promise) {
    AudioManager audioManager = (AudioManager) reactContext.getSystemService(Context.AUDIO_SERVICE);
    promise.resolve(audioManager.getStreamMaxVolume(streamType));
  }

  @ReactMethod
  public void getStreamVolume(int streamType, Promise promise) {
    AudioManager audioManager = (AudioManager) reactContext.getSystemService(Context.AUDIO_SERVICE);
    promise.resolve(audioManager.getStreamVolume(streamType));
  }

  @ReactMethod
  public void setStreamVolume(int streamType, int index, int flags, Promise promise) {
    AudioManager audioManager = (AudioManager) reactContext.getSystemService(Context.AUDIO_SERVICE);
    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, index, flags);
    promise.resolve(null);
  }
}
