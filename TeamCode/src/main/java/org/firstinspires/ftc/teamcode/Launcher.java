/*
//FTC FROGS (#14335) TEAM CODE
//
//  Class:
//      Launcher
//
//  Methods:
//      Launcher
//
//
//  Revisions:
//      12/6/20    Original    Kai P + Elijah E: Original
 */



package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Launcher {

    private LinearOpMode opMode;
    private DcMotor launcherMotor;
    private double speed2;
    private boolean buttonspeed2;


     private Launcher (LinearOpMode opmode) {
        this.opMode = opmode;
     launcherMotor = opMode.hardwareMap.get(DcMotor.class,"launcher");
      launcherMotor.setDirection(DcMotor.Direction.FORWARD);

      }

    public void wheelTrigger() {
       speed2 = opMode.gamepad1.right_trigger;
         launcherMotor.setPower(speed2);
     }

     public void wheelButton() {
    buttonspeed2 = opMode.gamepad1.right_bumper;
    //flywheel1.setPower(speed);
         launcherMotor.setPower(1);
     }

}

