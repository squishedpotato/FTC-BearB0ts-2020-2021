package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.CRServo;

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

    // Put initialization blocks here.
    frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    frontright.setDirection(DcMotorSimple.Direction.FORWARD);
    backleft.setDirection(DcMotorSimple.Direction.REVERSE);
    backright.setDirection(DcMotorSimple.Direction.FORWARD);
    clawMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    wobbleLift.setDirection(DcMotorSimple.Direction.FORWARD);
    ringMotor.setDirection(DcMotorSimple.Direction.FORWARD);
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
    }
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
  }*/
}



