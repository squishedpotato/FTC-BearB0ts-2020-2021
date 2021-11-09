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
  private String frontLeftN;
  private String backRightN;
  private String frontRightN;
  private String backLeftN;
  private DcMotor motorFrontLeft = hardwareMap.get(DcMotor.class,n1);
  private DcMotor motorBackRight = hardwareMap.get(DcMotor.class,n2);
  private DcMotor motorFrontRight = hardwareMap.get(DcMotor.class,n3);
  private DcMotor motorBackLeft = hardwareMap.get(DcMotor.class,n4);
  public TurnDegreesCW(DcMotor m1, String n1, DcMotor m2, String n2, DcMotor m3, String n3, DcMotor m4, String n4){
    motorFrontLeft = m1;
    motorBackRight = m2;
    motorFrontRight = m3;
    motorBackLeft = m4;
    frontLeftN = n1;
    backRightN = n2;
    frontRightN = n3;
    backLeftN = n4;
  }
  public void TurnCW(double degreesJoystick,double powerMotor){
    m1.setTargetPosition((int)(-2400.0/90*degrees));
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
    m1.setPower(powerMotor);
    m2.setPower(powerMotor);
    m3.setPower(powerMotor);
    m4.setPower(powerMotor);
    while(frontleft.isBusy()){
        telemetry.update();
    }
    frontleft.setPower(0);
    frontright.setPower(0);
    backleft.setPower(0);
    backright.setPower(0); 
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
