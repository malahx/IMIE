void setup() {
  Serial.begin(9600); 
}
int inited = 0;
void loop() {
  if (inited == 0) {
    itsMeMario();
    inited = 1;
  }
}

void itsMeMario() {
    Serial.println("It's me");
    Serial.println("MARIO");
}
