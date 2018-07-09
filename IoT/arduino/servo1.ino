#include <Servo.h>

Servo myservo;  // create servo object to control a servo
// twelve servo objects can be created on most boards

int lastSensorValue = 0;
int enable = 0;
int pos = 0;    // variable to store the servo position
const int TouchPin=7;

void setup() {
  myservo.attach(2);  // attaches the servo on pin 9 to the servo object
  pinMode(TouchPin, INPUT);
}

void loop() {
  //attachInterrupt(digitalPinToInterrupt(TouchPin), toogle, HIGH);
  int sensorValue = digitalRead(TouchPin);
  if (sensorValue && lastSensorValue != sensorValue) {
    enable++;
  }
  int mod = enable % 4;
  if(mod == 1) {
    pos++;
    mvt();
  } else if (mod == 3) {
    pos--;
    mvt();
  }
  lastSensorValue = sensorValue;
  delay(15);
}

void mvt() {
  if (pos >= 180) {
    pos = 180;
  } else if (pos <= 0) {
    pos = 0;
  } else {
    myservo.write(pos);
  }
}
