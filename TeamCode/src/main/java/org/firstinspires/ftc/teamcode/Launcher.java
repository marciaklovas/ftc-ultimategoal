/*
//FTC FROGS (#14335) TEAM CODE
//
//  Class:
//      Launcher - launches rings
//
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Launcher {

    private LinearOpMode opMode;
    private DcMotor launcherMotor;
    private double speed;

    public Launcher (LinearOpMode opmode) {
        this.opMode = opmode;
        launcherMotor = opMode.hardwareMap.get(DcMotor.class,"launcher");
        launcherMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void trigger() {
        // used gamepad 1 for intake, gamepad 2 for launcher
        speed = opMode.gamepad2.right_trigger;
        launcherMotor.setPower(speed);
    }
}