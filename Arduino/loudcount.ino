#include <ChainableLED.h>
#include "TM1637.h"

#define NUM_LEDS  1

#define CLK 2//pins definitions for TM1637 and can be changed to other ports    
#define DIO 3
TM1637 tm1637(CLK,DIO);

ChainableLED leds(7, 8, NUM_LEDS);
int8_t ListDisp[4];
int8_t count = 0;

void setup() {
  leds.init();
  tm1637.set();
  tm1637.init();
  
}

void loop() {
  int val = analogRead(0);
  leds.setColorRGB(0, 255 * val/1023, 0, 0);

    
  if(val>150){
    count ++;
    ListDisp[3] = count;
     tm1637.display(0,ListDisp[0]);
    tm1637.display(1,ListDisp[1]); 
    tm1637.display(2,ListDisp[2]);
    tm1637.display(3,ListDisp[3]);
    delay(500);
  }
}