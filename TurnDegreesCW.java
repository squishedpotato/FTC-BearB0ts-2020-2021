package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;

public class TurnDegreesCW extends HardwareMap{
  private double degrees;
  private double power;
  private DcMotor motorFrontLeft = hardwareMap.get(DcMotor.class,"");
  private DcMotor motorBackRight = hardwareMap.get(DcMotor.class,"");
  private DcMotor motorFrontRight = hardwareMap.get(DcMotor.class,"");
  private DcMotor motorBackLeft = hardwareMap.get(DcMotor.class,"");
  public TurnDegreesCW(double degreesJoystick,double powerMotor, DcMotor m1, DcMotor m2, DcMotor m3, DcMotor m4){
    degrees = degreesJoystick;
    power = powerMotor;
    motorFrontLeft = m1;
    motorBackRight = m2;
    motorFrontRight = m3;
    motorBackLeft = m4;
  }
  
  /*m1.setTargetPosition((int)(-2400.0/90*degrees));
  m2.setTargetPosition((int)(2400.0/90*degrees));
  m3.setTargetPosition((int)(2400.0/90*degrees));
  m4.setTargetPosition((int)(-2400.0/90*degrees));
  m1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
  m2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
  m3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
  m4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
  m1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  m2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  m3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  m4.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  m1.setPower(power);
  m2.setPower(power);
  m3.setPower(power);
  m4.setPower(power);
  while(frontleft.isBusy()){
      telemetry.update();
  }
  frontleft.setPower(0);
  frontright.setPower(0);
  backleft.setPower(0);
  backright.setPower(0); */
}
