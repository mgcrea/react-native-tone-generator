import { ToneGenerator } from './module';

export const startTone = async (
  toneType: number,
  durationMs: number = -1
): Promise<null> => {
  return ToneGenerator.startTone(toneType, durationMs);
};

export const stopTone = async (): Promise<null> => {
  return ToneGenerator.stopTone();
};

export const setStreamVolume = async (
  index: number,
  flags: number = 0
): Promise<null> => {
  return ToneGenerator.setStreamVolume(index, flags);
};

export const getStreamMaxVolume = async (): Promise<null> => {
  return ToneGenerator.getStreamMaxVolume();
};
