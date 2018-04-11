const int buttonPin = PUSH1;
const int gledPin =  GREEN_LED;
const int yledPin =  YELLOW_LED;
const int rledPin =  RED_LED;

int buttonState = 0; 
int last = 0;
int i = 0;

void setup() {
  pinMode(buttonPin, INPUT_PULLUP);     
  pinMode(gledPin, OUTPUT);      
  pinMode(yledPin, OUTPUT);      
  pinMode(rledPin, OUTPUT);      
  digitalWrite(gledPin, LOW);      
  digitalWrite(yledPin, LOW);      
  digitalWrite(rledPin, LOW);
}

void loop(){
  buttonState = digitalRead(buttonPin);
  if (buttonState != last) {
    if (buttonState == HIGH) {     
      i++;
    } 
    digitalWrite(gledPin, i%3 == 0 ? HIGH : LOW);  
    digitalWrite(yledPin, i%3 == 1 ? HIGH : LOW);  
    digitalWrite(rledPin, i%3 == 2 ? HIGH : LOW);  
  }
  last =  buttonState;
}
