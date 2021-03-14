/*
//  FTC FROGS (#14335) TEAM CODE
//
//  Class Arm
//
//  Methods:
//      constructor
//      init()
//
//  Revisions
//      02-21-21    Elijah W.       Original
//      02-25-21    Elijah W.       Changed arm from Tetrix motor to Servo
//
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {

    private Servo arm;
    //private TouchSensor digitalTouch;
    private LinearOpMode opmode;

    private double armPower;
    private double angle;

    // constructor
    public Arm(LinearOpMode opmode) {
        this.opmode = opmode; // 'this' used for clarity
        arm       = opmode.hardwareMap.get(Servo.class, "armlift");
        //lift       = opmode.hardwareMap.get(DcMotor.class, "armlift");
        //digitalTouch = opmode.hardwareMap.get(TouchSensor.class, "touch");
    }

    // initialize  arm to up position
    public void init() {
     // initialize claw arm to up position
        angle = 0.4;
        arm.setPosition(angle);
        while (arm.getPosition() != 0.4)
        {
            // wait
        }
    }

    public void adjustArm() { arm.setPosition((opmode.gamepad2.right_stick_y/2)+.5);
    }

    public void up(){
        angle = 0.4; // ??
        arm.setPosition(angle);
    }

    public void down() {
        angle = 0.8; // ??
        arm.setPosition(angle);
    }

}
