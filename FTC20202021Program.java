package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "FTC20202021Program (Blocks to Java)", group = "")
public class FTC20202021Program extends LinearOpMode {
  /* Error Codes:
  1: calcFRBLPower Method error
  2: calcFLBRPower Method error 
  */
  double horizontalLock = 1;
  double verticalLock = 1;
  double leftStickAngle = 0;
  double leftStickX = 0;
  double leftStickY = 0;
  double leftStickMagnitude = 0;
  double rightStickAngle = 0;
  double rightStickX = 0;
  double rightStickY = 0;
  double rightStickMagnitude = 0;
  boolean debugBoolean = false;
  int error = 0;
  
  private double calcFRBLPower(double angle) {
      //easierDouble keeps code more readable: turns 1/4 pi into units of 1
      double easierDouble = 4*angle/Math.PI;
      //Because I am starting to become tired typing out Math.PI 
      double pi = Math.PI;
      //All axis cases 
      if(angle == 0){
        return (-1)*leftStickMagnitude;
      }
      if(angle == pi/2){
        return (1)*leftStickMagnitude;
      }
      if(angle == pi){
        return (1)*leftStickMagnitude;
      }
      if(angle == 3*pi/2){
        return (-1)*leftStickMagnitude;
      }
      if(angle == 2*pi){
        return (-1)*leftStickMagnitude;
      }
      //All non-axis cases
      if(angle > 0 && angle < pi/2) {
        return (easierDouble-1)*leftStickMagnitude;
      }
      else if(angle > pi/2 && angle < pi){
        return (1)*leftStickMagnitude;
      }
      else if(angle > pi && angle < 3 * pi/2){
        return (-easierDouble + 5)*leftStickMagnitude;
      }
      else if(angle > 3*pi/2 && angle < 2 * pi){
        return (-1);
      }
      else{
        //error code if this somehow breaks???
        error = 1;
        return 0;
      }
  }
  private double calcFLBRPower(double angle) {
      //easierDouble keeps code more readable: turns 1/4 pi into units of 1
      double easierDouble = 4*angle/Math.PI;
      //Because I need to redefine variables in new methods (functions in javascript) 
      double pi = Math.PI;
      //All axis cases 
      if(angle == 0){
        return (1)*leftStickMagnitude;
      }
      if(angle == pi/2){
        return (1)*leftStickMagnitude;
      }
      if(angle == pi){
        return (-1)*leftStickMagnitude;
      }
      if(angle == 3*pi/2){
        return (-1)*leftStickMagnitude;
      }
      if(angle == 2*pi){
        return (1)*leftStickMagnitude;
      }
      
      //All non-axis cases
      if(angle > 0 && angle < pi/2){
        return (1)*leftStickMagnitude;
      }
      else if(angle > pi/2 && angle < pi){
        return (-easierDouble+3)*leftStickMagnitude;
      }
      else if(angle > pi && angle < 3*pi/2){
        return (-1)*leftStickMagnitude;
      }
      else if(angle > 3*pi/2 && angle < 2*pi){
        return (easierDouble-7)*leftStickMagnitude;
      }
      else {
        //error code maybe
        //turns out error codes are EXTREMELY useful tools
        error = 2;
        return 0;
      }
  }
  private DcMotor frontleft;
  private DcMotor frontright;
  private DcMotor backleft;
  private DcMotor backright;
  private DcMotor clawMotor;
  private Servo claw;
  private DcMotor intakeMotor;
  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    frontleft = hardwareMap.get(DcMotor.class, "frontleft");
    frontright = hardwareMap.get(DcMotor.class, "frontright");
    backleft = hardwareMap.get(DcMotor.class, "backleft");
    backright = hardwareMap.get(DcMotor.class, "backright");
    clawMotor = hardwareMap.get(DcMotor.class, "clawMotor");
    claw = hardwareMap.get(Servo.class, "claw");
    intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
    
    //Reverses right motors so all spin in same direction.
    frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    backleft.setDirection(DcMotorSimple.Direction.REVERSE);
    backright.setDirection(DcMotorSimple.Direction.FORWARD);
    clawMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      horizontalLock = 1;
      verticalLock = 1;
    }
    while (opModeIsActive()) {
      // Use left stick to drive and right stick to turn
      // Note: DO NOT PRESS MODE BUTTON
      // Bottom If "Locks" Direction
      debugBoolean = false;
      leftStickX = gamepad1.left_stick_x;
      leftStickY = -gamepad1.left_stick_y;
      if(leftStickX == 0 && leftStickY == 0) {
        leftStickAngle = 0;
        leftStickMagnitude = 0;
      }
      else if(leftStickX < 0 && leftStickY >= 0) {
        leftStickAngle = Math.atan(leftStickY/leftStickX) + Math.PI;
        leftStickMagnitude = Math.sqrt(Math.pow(leftStickX,2) + Math.pow(leftStickY,2));
        //debugBoolean = true;
      }
      else if(leftStickX < 0 && leftStickY <= 0) {
        leftStickAngle = Math.atan(leftStickY/leftStickX) + Math.PI;
        leftStickMagnitude = Math.sqrt(Math.pow(leftStickX,2) + Math.pow(leftStickY,2));
        //debugBoolean = true;
      }
      else if(leftStickX >= 0 && leftStickY <= 0) {
        leftStickAngle = Math.atan(leftStickY/leftStickX) + 2*Math.PI;
        leftStickMagnitude = Math.sqrt(Math.pow(leftStickX,2) + Math.pow(leftStickY,2));
        //debugBoolean = true;
      }
      else {
        leftStickAngle = Math.atan(leftStickY/leftStickX);
        leftStickMagnitude = Math.sqrt(Math.pow(leftStickX,2) + Math.pow(leftStickY,2));
      }
      frontleft.setPower(calcFLBRPower(leftStickAngle) + gamepad1.right_stick_x);
      frontright.setPower(calcFRBLPower(leftStickAngle) - gamepad1.right_stick_x);
      backleft.setPower(calcFRBLPower(leftStickAngle) + gamepad1.right_stick_x);
      backright.setPower(calcFLBRPower(leftStickAngle) - gamepad1.right_stick_x);
      clawMotor.setPower(gamepad2.right_stick_y);
      if (gamepad2.b) {
          claw.setPosition(1);
        }
      if (gamepad2.a) {
          claw.setPosition(0);
        }
      intakeMotor.setPower(gamepad1.left_trigger);
      //turning controls modified from bumpers to right stick don't mind useless if statements
      /*if(gamepad1.right_stick_x != 0){
        frontleft.setPower(gamepad1.right_stick_x); backleft.setPower(gamepad1.right_stick_x);
        frontright.setPower(-gamepad1.right_stick_x); backright.setPower(-gamepad1.right_stick_x);
      } else if(gamepad1.right_stick_x != 0){
        frontleft.setPower(-gamepad1.right_stick_x); backleft.setPower(-gamepad1.right_stick_x);
        frontright.setPower(gamepad1.right_stick_x); backright.setPower(gamepad1.right_stick_x);
      }*/
      //some old useless code \/\/\/
      
      /*
      //Power Calculation
      if(rightStickAngle < 3*Math.PI/4 && rightStickAngle >= 0){
        FRBLMotorsPower = -Math.cos(2*rightStickAngle)*rightStickMagnitude;
      }
      else if (rightStickAngle == 3*Math.PI/4){
        FRBLMotorsPower = 0;
      }
      else{
        FRBLMotorsPower = Math.cos(2*rightStickAngle)*rightStickMagnitude;
      }
      
      if(rightStickAngle < Math.PI/4 && rightStickAngle >= 0){
        FLBRMotorsPower = -Math.cos(2*(rightStickAngle + Math.PI/2))*rightStickMagnitude;
      }
      else if(rightStickAngle == Math.PI/4){
        FLBRMotorsPower = 0;
      }
      else if(rightStickAngle > Math.PI/4 && rightStickAngle < 5*Math.PI/4){
        FLBRMotorsPower = Math.cos(2*(rightStickAngle + Math.PI/2))*rightStickMagnitude;
      }
      else{
        FLBRMotorsPower = -Math.cos(2*(rightStickAngle + Math.PI/2))*rightStickMagnitude;
      }
      */
      //some old useless code /\/\/\
      
      //backup code \/\/\/
      /*if (gamepad1.right_bumper == true) {
        frontleft.setPower((-(gamepad1.right_stick_y * horizontalLock) + gamepad1.right_stick_x * verticalLock) - gamepad1.left_stick_x);
        frontright.setPower((-(gamepad1.right_stick_y * horizontalLock) - gamepad1.right_stick_x * verticalLock) + gamepad1.left_stick_x);
        backleft.setPower((-(gamepad1.right_stick_y * horizontalLock) - gamepad1.right_stick_x * verticalLock) - gamepad1.left_stick_x);
        backright.setPower(-(gamepad1.right_stick_y * horizontalLock) + gamepad1.right_stick_x * verticalLock + gamepad1.left_stick_x);
      } else {
        frontleft.setPower((gamepad1.right_stick_y * horizontalLock - gamepad1.right_stick_x * verticalLock) - gamepad1.left_stick_x);
        frontright.setPower(gamepad1.right_stick_y * horizontalLock + gamepad1.right_stick_x * verticalLock + gamepad1.left_stick_x);
        backleft.setPower((gamepad1.right_stick_y * horizontalLock + gamepad1.right_stick_x * verticalLock) - gamepad1.left_stick_x);
        backright.setPower((gamepad1.right_stick_y * horizontalLock - gamepad1.right_stick_x * verticalLock) + gamepad1.left_stick_x);
      }*/
      //backup code /\/\/\
      
      
    telemetry.addData("frontleft pow", frontleft.getPower());
    telemetry.addData("frontright pow", frontright.getPower());
    telemetry.addData("backleft pow", backleft.getPower());
    telemetry.addData("backright pow", backright.getPower());
    telemetry.addData("right stick x axis", rightStickX);
    telemetry.addData("right stick y axis", rightStickY);
    telemetry.addData("RightStickAngleDegrees", rightStickAngle / Math.PI * 180);
    telemetry.addData("RightStickMagnitude", rightStickMagnitude);
    telemetry.addData("Trigger", gamepad1.left_trigger);
    telemetry.addData("Debug", debugBoolean);
    telemetry.addData("Error Code", error);
    telemetry.update();
    }
    
  }
}