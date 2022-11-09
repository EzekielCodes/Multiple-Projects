/*
   bluetooth + afstand
*/
// pinnen voor de afstand sensoren
int Lecho1 = 40;//links echo
int Ltrig1 = 41;//links trig
int Fecho2 = 43;//forward echo
int Ftrig2 = 42;//forward trig
int Recho3 = 44;//rechts echo
int Rtrig3 = 45;//rechts trig
int Becho4 = 38;// niet meer nodig want ik gebruik geen achterste meer
int Btrig4 = 39;// niet meer nodig want ik gebruik geen achterste meer


int L_Distance = 0;// in deze varaible wordt de waarde van de afstand  opgeslaan
int F_Distance = 0;// in deze varaible wordt de waarde van de afstand  opgeslaan
int R_Distance = 0;// in deze varaible wordt de waarde van de afstand  opgeslaan
int B_Distance = 0;// in deze varaible wordt de waarde van de afstand  opgeslaan

#include <SoftwareSerial.h>
SoftwareSerial BTserial(19, 18); // RX | TX

/*
   vuur sensoor
*/
#include <Wire.h>
#include <Adafruit_MLX90614.h>

#define IR1 0x5B // dit is de adres van een van de temperatuur sensoor // ze zitten in zelfde pin maar hebben verschillende adres
#define IR2 0x55
#define IR3 0x5A
Adafruit_MLX90614 mlx;// dit is een arduino functie

/*
   motor + ps2
*/
#define enA 53
#define in1 47
#define in2 49
#define in3 35
#define in4 37
#define enB 51
int LX = 0;
int LY = 0;
int RX = 0;
int RY = 0;
int len = 0;
#include <PS2X_lib.h>


int count = 1;
int error = 0;
byte type = 0;
byte vibrate = 0;

int check = 0;
PS2X ps2x;

/*
   stepper motor
*/
#include <Stepper.h>
const int stepsPerRevolution = 200;//change this to fit the number of steps per revolution
Stepper myStepper(stepsPerRevolution, 22, 23, 24, 25);//initialize the stepper library on pins 8 through 11:
const int enAStepper = 46;
const int enBStepper = 46;


/*
   water pomp
*/

#include <AFMotor.h>
AF_DCMotor pump(2);



void setup() {
  /*
     stepper motor
  */

  analogWrite(enAStepper, 255);
  analogWrite(enBStepper, 255);
  myStepper.setSpeed(60);

  /*
     ps2
  */
  Serial.begin(9600);

  error = ps2x.config_gamepad(31, 32, 33, 34, true, true); //setup pins and settings:  GamePad(clock, command, attention, data, Pressures?, Rumble?) check for error
  type = ps2x.readType();

  if (error == 0) {
    Serial.println("Found Controller, configured successful");
  }

  else if (error == 1)
    Serial.println("No controller found, check wiring or reset the Arduino");

  else if (error == 2)
    Serial.println("Controller found but not accepting commands");

  else if (error == 3)
    Serial.println("Controller refusing to enter Pressures mode, may not support it.");

  // Check for the type of controller
  type = ps2x.readType();
  switch (type) {
    case 0:
      Serial.println("Unknown Controller type");
      break;
    case 1:
      Serial.println("DualShock Controller Found");
      break;
    case 2:
      Serial.println("GuitarHero Controller Found");
      break;
  }

  /*
     afstand
  */
  //obstacle sensor
  pinMode(Ltrig1, OUTPUT);
  pinMode(Lecho1, INPUT);
  pinMode(Ftrig2, OUTPUT);
  pinMode(Fecho2, INPUT);
  pinMode(Rtrig3, OUTPUT);
  pinMode(Recho3, INPUT);

  //erial.begin(9600);
  BTserial.begin(9600);
  pinMode(Btrig4, OUTPUT);
  pinMode(Becho4, INPUT);

  /*
     motoren
  */
  pinMode(enA, OUTPUT);
  pinMode(in1, OUTPUT);
  pinMode(in2, OUTPUT);
  pinMode(in3, OUTPUT);
  pinMode(in4, OUTPUT);

  /*
     vuur
  */
  mlx.begin(); //de functie beginnen
}
/****
   Methode voor afstandsensoren
*/
int L_Distance_test() {// methode voor de linkse afstand te berekenen
  digitalWrite(Ltrig1, LOW);
  delayMicroseconds(2);
  digitalWrite(Ltrig1, HIGH);
  delayMicroseconds(10);
  digitalWrite(Ltrig1, LOW);
  float Ldistance = pulseIn(Lecho1, HIGH);
  delay(10);

  Ldistance = Ldistance  * 0.034 / 2; 2;
  return (int)Ldistance;
}

int F_Distance_test() {// methode voor de forward afstand te berekenen
  digitalWrite(Ftrig2, LOW);
  delayMicroseconds(2);
  digitalWrite(Ftrig2, HIGH);
  delayMicroseconds(10);
  digitalWrite(Ftrig2, LOW);
  float Fdistance = pulseIn(Fecho2, HIGH);
  delay(10);

  Fdistance = Fdistance  * 0.034 / 2;;
  return (int)Fdistance;
}

int B_Distance_test() {// methode voor de rechtse afstand te berekenen
  digitalWrite(Btrig4, LOW);
  delayMicroseconds(2);
  digitalWrite(Btrig4, HIGH);
  delayMicroseconds(10);
  digitalWrite(Btrig4, LOW);
  float Bdistance = pulseIn(Becho4, HIGH);
  delay(10);

  Bdistance = Bdistance  * 0.034 / 2;/// 29 / 2;
  return (int)Bdistance;
}


int R_Distance_test() {// methode voor de rechtse afstand te berekenen
  digitalWrite(Rtrig3, LOW);
  delayMicroseconds(2);
  digitalWrite(Rtrig3, HIGH);
  delayMicroseconds(10);
  digitalWrite(Rtrig3, LOW);
  float Rdistance = pulseIn(Recho3, HIGH);
  delay(10);

  Rdistance = Rdistance  * 0.034 / 2;/// 29 / 2;
  return (int)Rdistance;
}

/*
   methode voor motoren
*/

void forward()
{
  analogWrite(enA, 200);
  analogWrite(enB, 200);
  digitalWrite(in1, HIGH);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW);
  digitalWrite(in4, HIGH);
}

void backward()
{
  analogWrite(enA, 200);
  analogWrite(enB, 200);
  digitalWrite(in1, LOW);
  digitalWrite(in2, HIGH);
  digitalWrite(in3, HIGH);
  digitalWrite(in4, LOW);
}

void right()
{
  analogWrite(enA, 255);
  analogWrite(enB, 80);
  digitalWrite(in1, HIGH);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW);
  digitalWrite(in4, HIGH);
}

void left()
{
  analogWrite(enA, 80);
  analogWrite(enB, 255);
  digitalWrite(in1, HIGH);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW);
  digitalWrite(in4, HIGH);
}

void stopm() {
  analogWrite(enA, 0);
  analogWrite(enB, 0);
  digitalWrite(in1, LOW);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW);
  digitalWrite(in4, LOW);

}

/*
   Methode stepper motor
*/
void setStepperIdle() {
  digitalWrite(50, LOW);
  digitalWrite(51, LOW);
  digitalWrite(52, LOW);
  digitalWrite(53, LOW);
}

void StepperPwmOff() {
  analogWrite(enAStepper, 0);
  analogWrite(enBStepper, 0);
}

void StepperPwmOn() {
  analogWrite(enAStepper, 255);
  analogWrite(enBStepper, 255);
}

void pumpstart() {
  pump.setSpeed(150);
  pump.run(FORWARD);
}
void pumpstop() {
  pump.setSpeed(0);
  pump.run(RELEASE);
}

void loop()
{

  if (error == 1) {
    //skip loop if no controller found

  }


  else {


    ps2x.read_gamepad(false, vibrate);
    delay(50);



    LY = ps2x.Analog(PSS_LY);                     //receive values from p22 joystick
    LX = ps2x.Analog(PSS_LX);
    //}
    //  if (ps2x.Button(PSB_R1))
    // {
    RY = ps2x.Analog(PSS_RY);
    RX = ps2x.Analog(PSS_RX);

    stopm();
    setStepperIdle();


    if (LY > 200)                      //check if the joystick pushed up side
    {

      backward();
      Serial.println("Back");

    }

    if ((LY < 100 ) && (LX != 0))
    {
      forward();
      Serial.println("for");
      Serial.println(LY);
    }

    if ((LX < 100 ) && (LY != 0))
    {
      left();
      Serial.println("left");

      Serial.println(LX);
    }
    if (LX > 200 )
    {


      right();
      Serial.println("right");

    }
    if (RX > 200) {
      StepperPwmOn();
      myStepper.step(-5);
      StepperPwmOff();
      setStepperIdle();
      Serial.println("turn leftt");
    }
    if ((RX < 100)  && (LY != 0))
    {
      StepperPwmOn();
      myStepper.step(5);
      StepperPwmOff();
      setStepperIdle();
      Serial.println("turn right");
      Serial.println(RX);
    }
    if (ps2x.ButtonPressed(PSB_R1)) {
      //pomp aan
      //lcd.print("    X");
      Serial.println("pump_start");
      pumpstart();
    }
    if (ps2x.ButtonPressed(PSB_R2)) {
      //pomp aan
      //lcd.print("    X");
      Serial.println("pump_stop");
      pumpstop();
    }


    if (ps2x.ButtonPressed(PSB_L1))
    {
      Serial.println("press");
      count = 1;
      while (count < 10)
      {
        count++;
        Serial.println(count);
        /*
          bluetooth
        */

        R_Distance = R_Distance_test();//hier wordt de afstand bepaald
        L_Distance = L_Distance_test();//hier wordt de afstand bepaald
        B_Distance = B_Distance_test();//hier wordt de afstand bepaald
        F_Distance = F_Distance_test();//hier wordt de afstand bepaald
        //
        //  /*
        //     vuur sensoor
        //  */
        //
        mlx.AddrSet(IR1); //de adres zetten dat we de eerste sensoor kunnen lezen
        mlx.temp1 = mlx.readObjectTempC();// hier wordt de temperatuur gelezen

        mlx.AddrSet(IR2); //de adres zetten dat we de eerste sensoor kunnen lezen
        mlx.temp2 = mlx.readObjectTempC();// hier wordt de temperatuur gelezen

        mlx.AddrSet(IR3); //de adres zetten dat we de eerste sensoor kunnen lezen
        mlx.temp3 = mlx.readObjectTempC();// hier wordt de temperatuur gelezen
        //
        BTserial.print(F_Distance);
        BTserial.print("cm");
        BTserial.print("|");

        //Serial.println("Back:");
        //Serial.println(B_Distance);
        BTserial.print(B_Distance);
        BTserial.print("cm");
        BTserial.print("|");


        //Serial.println("left:");
        //Serial.println(L_Distance);
        BTserial.print(L_Distance);
        BTserial.print("cm");
        BTserial.print("|");

        //Serial.println("right:");
        //Serial.println(R_Distance);
        BTserial.print(R_Distance);
        BTserial.print("cm");
        BTserial.print("|");




        BTserial.print(mlx.temp1);
        BTserial.print("*C");
        BTserial.print("|");

        BTserial.print(mlx.temp2);
        BTserial.print("*C");
        BTserial.print("|");

        BTserial.print(mlx.temp3);
        BTserial.print("*C");
        BTserial.print("|");

        delay(400);
        
      }
      //





      LY = LX = 128;         //return to default vlaues
      RY = RX = 128;         //return to default values




    }

    /*
       controle motoren + ps2
    */

  }
}
