#include "Wire.h"
#include "I2Cdev.h"
#include "ADXL345.h"
#include "ITG3200.h"
#include "HMC5883L.h"

ADXL345 accel;
ITG3200 gyro;
HMC5883L mag;

int16_t ax, ay, az;
int16_t gx, gy, gz;
int16_t mx, my, mz;

void setup() {
  Wire.begin();
  Serial.begin(38400);
  Serial.println("Initializing I2C devices...");
  accel.initialize();
  gyro.initialize();
  mag.initialize();
  Serial.println("Testing device connections...");
  Serial.println(accel.testConnection() ? "ADXL345 connection successful" : "ADXL345 connection failed");
  Serial.println(gyro.testConnection() ? "ITG3200 connection successful" : "ITG3200 connection failed");
  Serial.println(mag.testConnection() ? "HMC5883L connection successful" : "HMC5883L connection failed");
}

void loop() {
  printAccel();
  //printGyro();
  //printMag();
  delay(100);
}

void printGyro() {
  gyro.getRotation(&gx, &gy, &gz);
  Serial.print("gyro:\t");
  Serial.print(gx); Serial.print("\t");
  Serial.print(gy); Serial.print("\t");
  Serial.println(gz);
}
void printAccel() {
  accel.getAcceleration(&ax, &ay, &az);
  Serial.print("accel:\t");
  Serial.print(ax / 256.0); Serial.print("\t");
  Serial.print(ay / 256.0); Serial.print("\t");
  Serial.println(az / 256.0);
}
void printMag() {
    mag.getHeading(&mx, &my, &mz);
    Serial.print("mag:\t");
    Serial.print(mx); Serial.print("\t");
    Serial.print(my); Serial.print("\t");
    Serial.print(mz); Serial.print("\t");
    float heading = atan2(my, mx);
    if(heading < 0)
      heading += 2 * M_PI;
    Serial.print("heading:\t");
    Serial.println(heading * 180/M_PI);
}

