
#include <SoftwareSerial.h> 

SoftwareSerial MyBlue(2, 3); // RX | TX //Bluetooth connection
const int ledPin = 8;
String msg;

void setup() {

  pinMode(ledPin, OUTPUT);
  digitalWrite(ledPin, LOW);
  
  MyBlue.begin(9600); 
  Serial.begin(9600);
  
  msg = "";
}

void loop() {

//  Serial.println(Serial.available());
  
  if (MyBlue.available() > 0){ // Check if any data is waiting
    msg = MyBlue.readString();
    //Serial.println("Tablet: " + msg);
  }

  if (msg == "<turn on>"){
    digitalWrite(ledPin, HIGH); 
    Serial.println(msg); 
    MyBlue.println("Arduino: Hello from Arduino"); //send to Android
    delay(1000); 
    msg = ""; // reset command
    
  } else {
    if (msg == "<turn off>"){
      digitalWrite(ledPin, LOW); 
      //Serial.println("LED is off\n"); 
      msg = ""; 
    }
  }
}
