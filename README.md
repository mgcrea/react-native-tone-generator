# react-native-tone-generator

React Native plugin to play generated tones using [ToneGenerator](https://developer.android.com/reference/android/media/ToneGenerator)

## Installation

```sh
npm install react-native-tone-generator
```

## Usage

```ts
import {
  TONE_CDMA_ALERT_CALL_GUARD,
  startTone,
  stopTone,
  getStreamMaxVolume,
  setStreamVolume,
} from 'react-native-tone-generator';

startTone(TONE_CDMA_ALERT_CALL_GUARD, 125);
stopTone();
const maxVolume = await getStreamMaxVolume();
setStreamVolume(maxVolume);
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
