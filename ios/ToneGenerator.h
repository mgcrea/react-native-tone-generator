
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNToneGeneratorSpec.h"

@interface ToneGenerator : NSObject <NativeToneGeneratorSpec>
#else
#import <React/RCTBridgeModule.h>

@interface ToneGenerator : NSObject <RCTBridgeModule>
#endif

@end
