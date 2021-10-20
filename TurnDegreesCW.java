package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
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

public class TurnDegreesCW(double degrees,double power){
  frontleft.setTargetPosition((int)(-2400.0/90*degrees));
  backright.setTargetPosition((int)(2400.0/90*degrees));
  frontright.setTargetPosition((int)(2400.0/90*degrees));
  backleft.setTargetPosition((int)(-2400.0/90*degrees));
  frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
  backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
  frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
  backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
  frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  frontleft.setPower(power);
  frontright.setPower(power);
  backleft.setPower(power);
  backright.setPower(power);
  while(frontleft.isBusy()){
      telemetry.update();
  }
  frontleft.setPower(0);
  frontright.setPower(0);
  backleft.setPower(0);
  backright.setPower(0); 
}
