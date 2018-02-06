#include <ChainableLED.h>
#define NUM_LEDS  1
ChainableLED leds(7, 8, NUM_LEDS);
void setup() {
  leds.init();
}

void loop() {

  int val = analogRead(0);
   leds.setColorRGB(0, 255 * val/1023, 0, 0);
}