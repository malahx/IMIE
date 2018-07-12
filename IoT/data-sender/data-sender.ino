#include <time.h>
#include <SPI.h>
#include <WiFi.h>
#include <PubSubClient.h>

char ssid[] = "IMIE-ETUDIANTS";

char server[] = "172.17.0.66";
int port = 1883;
char topic[] = "sensor/thermal";

char mqttUser[] = "mqtt";
char mqttPass[] = "mqtt";

char uuid[] = "3f3ec192-5e1c-409f-9897-e4acc794bf5a";

WiFiClient wifiClient;
PubSubClient client(server, port, 0, wifiClient);

void setup() {
  Serial.begin(115200);

  Serial.print("Attempting to connect to Network named: ");
  Serial.println(ssid);

  WiFi.begin(ssid);
  while ( WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(300);
  }

  Serial.println("\nYou're connected to the network");
  Serial.println("Waiting for an ip address");

  while (WiFi.localIP() == INADDR_NONE) {
    Serial.print(".");
    delay(300);
  }

  Serial.println("\nIP Address obtained");
  printWifiStatus();

  Serial.println("\nConnect to Brocker");
}

void loop() {
  if (!client.connected()) {
    Serial.println("Disconnected. Reconnecting....");
    if (!client.connect("CC3200", mqttUser, mqttPass)) {
      Serial.println("Connection failed");
    } else {
      Serial.println("Connection success");
    }
  }

if (client.connected()) {
    char* message = "2018-07-11T12:27:58.659Z;" << uuid << ";10.10;20.20";
    if (client.publish(topic, message)) {
      Serial.println("Publish success");
    } else {
      Serial.println("Publish failed");
    }
  }

  delay(1000);
}

void printWifiStatus() {
  // print the SSID of the network you're attached to:
  Serial.print("SSID: ");
  Serial.println(WiFi.SSID());

  // print your WiFi IP address:
  IPAddress ip = WiFi.localIP();
  Serial.print("IP Address: ");
  Serial.println(ip);

  // print the received signal strength:
  long rssi = WiFi.RSSI();
  Serial.print("signal strength (RSSI):");
  Serial.print(rssi);
  Serial.println(" dBm");
}
