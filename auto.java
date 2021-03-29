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

@Autonomous(name = "simpleAuto", group = "")

public class FTC20202021ProgramAuto extends LinearOpMode{
    private Blinker expansion_Hub_2;
    private Blinker expansion_Hub_3;
    private Servo armRingClaw;
    private DcMotor backleft;
    private DcMotor backright;
    private Servo claw;
    private DcMotor clawMotor;
    private Servo foldClaw;
    private DcMotor frontleft;
    private DcMotor frontright;
    private Gyroscope imu;
    private DcMotor intakeMotor;
    private Servo ringClaw;
    private Servo ringClawTwo;
    private DcMotor ringMotor;
    private CRServo wobbleLift;
    private ColorSensor colorA_REV_ColorRangeSensor;
    private ColorSensor colorB_REV_ColorRangeSensor;
    double colorMaxA = 0;
    double colorMaxB = 0;

   @Override
  public void runOpMode() {
    frontleft = hardwareMap.get(DcMotor.class, "frontleft");
    frontright = hardwareMap.get(DcMotor.class, "frontright");
    backleft = hardwareMap.get(DcMotor.class, "backleft");
    backright = hardwareMap.get(DcMotor.class, "backright");
    clawMotor = hardwareMap.get(DcMotor.class, "clawMotor");
    ringMotor = hardwareMap.get(DcMotor.class, "ringMotor");
    claw = hardwareMap.get(Servo.class, "claw");
    foldClaw = hardwareMap.get(Servo.class, "foldClaw");
    intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
    ringClaw = hardwareMap.get(Servo.class, "ringClaw");
    armRingClaw = hardwareMap.get(Servo.class, "armRingClaw");
    ringClawTwo = hardwareMap.get(Servo.class, "ringClawTwo");
    wobbleLift = hardwareMap.get(CRServo.class, "wobbleLift");
    colorA_REV_ColorRangeSensor = hardwareMap.get(ColorSensor.class, "colorA");
    colorB_REV_ColorRangeSensor = hardwareMap.get(ColorSensor.class, "colorB");

    // Put initialization blocks here.
    frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    backleft.setDirection(DcMotorSimple.Direction.REVERSE);
    backright.setDirection(DcMotorSimple.Direction.FORWARD);
    clawMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    wobbleLift.setDirection(DcMotorSimple.Direction.FORWARD);
    ringMotor.setDirection(DcMotorSimple.Direction.FORWARD);    
    
    frontleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    frontright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    backleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    backright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    telemetry.addData("colorA", colorA_REV_ColorRangeSensor.red());
    telemetry.addData("colorB", colorB_REV_ColorRangeSensor.red());
    telemetry.addData("colorMaxA", colorMaxA);
    telemetry.addData("colorMaxB", colorMaxB);
    
    // ORDER MATTERS W/ REVERSE
    // 1440 = full rotation
    waitForStart();
    if (opModeIsActive()) {
      /*
      // Put run blocks here.
      backlefts.setPosition(1);
      backrights.setPosition(0);
      moveFWDin(30);
      frontleft.setPower(0.5);
      frontright.setPower(0.5);
      backleft.setPower(0.5);
      backright.setPower(0.5);
      while (frontleft.isBusy()) {
      }
      backlefts.setPosition(0);
      backrights.setPosition(1);
      sleep(1000);
      moveFWDin(-30);
      // about -12 inches off
      while (frontleft.isBusy()) {
      }
      turn90CCW();
      while (frontleft.isBusy()) {
      }
      backlefts.setPosition(1);
      backrights.setPosition(0);
      sleep(1000);
      moveFWDin(-25);
      telemetry.update();
      while (opModeIsActive()) {
        // Put loop blocks here.
      }
      */
      
      moveVertical(-26.5);
      //turn90CCW();
      //ringSensor();
      scanRings();

    intakeMotor.setPower(0.2);
    sleep(7000);
    }
  }
  private void ringSensor(){
    if(colorMaxA > 200 && colorMaxB > 200){
      //Go to C
      moveVertical(-80);
      turn90CCW();
      telemetry.addData("C", "yes");
    }
    else if(colorMaxA > 200){
      //Go to B
      moveVertical(-50);
      turn90CCW();
      telemetry.addData("B", "yes");
    }
    else {
      //Go to A
      moveVertical(-30);
      turn90CCW();
      telemetry.addData("A", "yes");
    }
    telemetry.update();
  }
  private void moveVertical(double inch){
    frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontleft.setTargetPosition(calcTicks(inch));
    frontright.setTargetPosition(calcTicks(inch));
    backleft.setTargetPosition(calcTicks(inch));
    backright.setTargetPosition(calcTicks(inch));
    frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontleft.setPower(1);
    frontright.setPower(1);
    backleft.setPower(1);
    backright.setPower(1);
    while(frontleft.isBusy()){
       telemetry.update();
    }
    frontleft.setPower(0);
    frontright.setPower(0);
    backleft.setPower(0);
    backright.setPower(0);
    telemetry.update();
  }
  private void moveHorizontal(double inch){
    //in progress
    frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontleft.setTargetPosition((int)(inch*0.00659722));
    frontright.setTargetPosition((int)(inch*0.00659722));
    backleft.setTargetPosition((int)(inch*0.00659722));
    backright.setTargetPosition((int)(inch*0.00659722));
    
    //frontleft.setTargetPosition(1440);
    //frontright.setTargetPosition(-1440);
    //backleft.setTargetPosition(-1440);
    //backright.setTargetPosition(1440);
    
    frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontleft.setPower(1);
    frontright.setPower(1);
    backleft.setPower(1);
    backright.setPower(1);
    while(frontleft.isBusy()){
      maxColor();
      telemetry.update();
    }
    frontleft.setPower(0);
    frontright.setPower(0);
    backleft.setPower(0);
    backright.setPower(0);
    telemetry.update();
  }
  private int calcTicks(double input){
    int round = (int)(155.223 * input);
    //155.223 is 1440 ticks/inches in circumference of wheel
    //"Dimensional analysis"
    telemetry.update();
    return round;
  }
  private void maxColor(){
  	if(colorMaxA < colorA_REV_ColorRangeSensor.red()){
  		colorMaxA = colorA_REV_ColorRangeSensor.red();
  	}
  	if(colorMaxB < colorB_REV_ColorRangeSensor.red()){
  		colorMaxB = colorB_REV_ColorRangeSensor.red();
  	}
  	telemetry.update();
  }
  private void scanRings(){
  	moveHorizontal(-10);
  	moveHorizontal(15);
  	ringSensor();
  	telemetry.update();
  }
  /*
  private void moveFWDin(double inch) {
    frontleft.setTargetPosition((inch * 1440) / (2.5 * Math.PI));
    frontright.setTargetPosition((inch * 1440) / (2.5 * Math.PI));
    backleft.setTargetPosition((inch * 1440) / (2.5 * Math.PI));
    backright.setTargetPosition((inch * 1440) / (2.5 * Math.PI));
    frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    telemetry.addData("key", 123);
  }
  */
  private void turn90CCW() {
    frontleft.setTargetPosition(2400);
    backright.setTargetPosition(-2400);
    frontright.setTargetPosition(-2400);
    backleft.setTargetPosition(2400);
    frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontleft.setPower(1);
    frontright.setPower(1);
    backleft.setPower(1);
    backright.setPower(1);
    while(frontleft.isBusy()){
      telemetry.update();
    }
    frontleft.setPower(0);
    frontright.setPower(0);
    backleft.setPower(0);
    backright.setPower(0);
  }

  private void turn90CW() {
    frontleft.setTargetPosition(-2400);
    backright.setTargetPosition(2400);
    frontright.setTargetPosition(2400);
    backleft.setTargetPosition(-2400);
    frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontleft.setPower(1);
    frontright.setPower(1);
    backleft.setPower(1);
    backright.setPower(1);
    while(frontleft.isBusy()){
      telemetry.update();
    }
    frontleft.setPower(0);
    frontright.setPower(0);
    backleft.setPower(0);
    backright.setPower(0);
  }
}



