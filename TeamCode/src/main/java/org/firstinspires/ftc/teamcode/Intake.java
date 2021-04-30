/*
//FTC FROGS (#14335) TEAM CODE
//
//  Class:
//      Intake - collects rings
//
//  Revisions:
//      10/18/20    Original    Kai P + Elijah E: Original
//      10/25/20    Kai P.      Added a button trigger to ramp up the fly wheel
//      02/19/21    Elijah W.   Renamed from FlywheelTest to Intake
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Intake {
    //declare members
    private DcMotor flywheel1;
    private LinearOpMode opMode;

    //sets name of variable, dependent on the pressure placed on the trigger
    private double speed;
    private boolean buttonspeed;

    public Intake(LinearOpMode opmode) {
        this.opMode = opmode;
        flywheel1 = opMode.hardwareMap.get(DcMotor.class,"intake");
        flywheel1.setDirection(DcMotor.Direction.FORWARD);
    }

    //sets the gamepad button trigger for the fly wheel
    public void trigger(){
        speed = opMode.gamepad1.left_trigger - opMode.gamepad1.right_trigger;
        flywheel1.setPower(speed);
    }
}
