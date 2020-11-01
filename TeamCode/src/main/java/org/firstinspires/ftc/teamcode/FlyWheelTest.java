/*
//FTC FROGS (#14335) TEAM CODE
//
//  Class:
//      FlyWheelTest
//
//  Methods:
//      wheelTrigger
//
//
//  Revisions:
//      10/18/20    Original    Kai P + Elijah E: Original
//      10/25/20    (hopefully) added a button trigger for the fly wheel    Kai P
 */


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class FlyWheelTest {
//declare members
    private DcMotor flywheel1;
    private LinearOpMode opMode;
//sets name of variable, dependent on the pressure placed on the trigger
    private double speed;
    private boolean buttonspeed;

    public FlyWheelTest (LinearOpMode opmode) {
        this.opMode = opmode;
        flywheel1 = opMode.hardwareMap.get(DcMotor.class,"launcher");
        flywheel1.setDirection(DcMotor.Direction.REVERSE);
    }
//sets the gamepad button trigger for the fly wheel
    public void wheelTrigger(){
        speed = opMode.gamepad1.right_trigger;
        flywheel1.setPower(speed);
    }

    public void wheelButton(){
        flywheel1.setPower(1);
    }
}