#include <ChainableLED.h>
#include <time.h>
#define NUM_LEDS  1

const int TouchPin=5;
const int ledPin=12;

ChainableLED leds(7, 8, NUM_LEDS);

void setup()
{
  leds.init();
  pinMode(TouchPin, INPUT);
  pinMode(ledPin,OUTPUT);
}

float hue = 0.0;
boolean up = true;

void loop()
{

  int sensorValue = digitalRead(TouchPin);
  if(sensorValue==1) {    
  
  for (byte i=0; i<NUM_LEDS; i++) {
    leds.setColorHSB(i, hue, 1.0, 0.5);
  }
    if (up) {
      hue+= 0.025;
    } else {
      hue-= 0.025;
    }
  }
  
    
  if (hue>=1.0 && up) {
    up = false;
  } else if (hue<=0.0 && !up) {
    up = true;
  }
  delay(50);
}