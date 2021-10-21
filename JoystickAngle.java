public class JoystickAngle{
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
}
