import React, { useEffect } from 'react';
import { StyleSheet, View, Text, Button } from 'react-native';
import {
  getStreamMaxVolume,
  setStreamVolume,
  startTone,
  // TONE_CDMA_ALERT_CALL_GUARD,
  // TONE_CDMA_ONE_MIN_BEEP,
} from '@mgcrea/react-native-tone-generator';

export default function App() {
  const [tone, setToneType] = React.useState<number>(1);
  const [volume, setVolume] = React.useState<number>(0);

  useEffect(() => {
    getStreamMaxVolume().then((maxVolume) => {
      console.warn(maxVolume);
    });
  }, []);

  return (
    <View style={styles.container}>
      <Text>Tone: {tone}</Text>
      <Text>Volume: {volume}</Text>
      <Button
        onPress={() => {
          startTone(tone, 400);
        }}
        title="Play Tone"
        color="#841584"
      />
      <Button
        onPress={() => {
          setToneType((value) => value - 1);
          startTone(tone - 1, 400);
        }}
        title="Previous Tone"
        color="#841584"
      />
      <Button
        onPress={() => {
          setToneType((value) => value + 1);
          startTone(tone + 1, 400);
        }}
        title="Next Tone"
        color="#841584"
      />
      <Button
        onPress={() => {
          setVolume((value) => value + 1);
          setStreamVolume(volume);
        }}
        title="Set Volume"
        color="#841584"
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
