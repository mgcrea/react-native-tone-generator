import { STREAM_MUSIC } from './config';
import { ToneGenerator } from './module';

// Tone

export const configureTone = async (
  streamType: number,
  volume: number = 100
): Promise<null> => {
  return ToneGenerator.configureTone(streamType, volume);
};

export const startTone = async (
  toneType: number,
  durationMs: number = -1
): Promise<null> => {
  return ToneGenerator.startTone(toneType, durationMs);
};

export const stopTone = async (): Promise<null> => {
  return ToneGenerator.stopTone();
};

// Volume

export const getStreamVolume = async (
  streamType = STREAM_MUSIC
): Promise<number> => {
  return ToneGenerator.getStreamVolume(streamType);
};

export const setStreamVolume = async (
  index: number,
  streamType = STREAM_MUSIC,
  flags = 0
): Promise<null> => {
  return ToneGenerator.setStreamVolume(streamType, index, flags);
};

export const getStreamMinVolume = async (
  streamType = STREAM_MUSIC
): Promise<number | null> => {
  return (ToneGenerator.getStreamMinVolume(streamType) as number) || null;
};

export const getStreamMaxVolume = async (
  streamType = STREAM_MUSIC
): Promise<number> => {
  return ToneGenerator.getStreamMaxVolume(streamType) as number;
};
