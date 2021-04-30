/*
//  FTC FROGS (#14335) TEAM CODE
//
//  Class:
//      Arm - picks up rings and puts them on a wobble stick
//
//  Revisions
//      02-21-21    Elijah W.       Original
//      02-25-21    Elijah W.       Changed arm from Tetrix motor to Servo
//      03-21-21    Kai P.          add adjust arm procedure
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {

    private Servo arm;
    private Servo clamp;
    private LinearOpMode opmode;
    private boolean isClosed = false;

    private double armPower;
    private double angle;

    // constructor
    public Arm(LinearOpMode opmode) {
        this.opmode = opmode; // 'this' used for clarity
        arm       = opmode.hardwareMap.get(Servo.class, "armlift");
        clamp       = opmode.hardwareMap.get(Servo.class, "clamp");
    }

    // initialize  arm to up position
    public void init() {
        angle = 0.4;
        arm.setPosition(angle);
        while (arm.getPosition() != 0.4)
        {
            // wait
        }
    }

    // move arm up and down
    public void adjustArm()
    {
        if (opmode.gamepad2.right_stick_y <= 0) {
            arm.setPosition(((-opmode.gamepad2.right_stick_y / (1 / .55))) + .25);
        }

        //arm.setPosition(opmode.gamepad2.right_stick_y);
        opmode.telemetry.addData("armposition: ", arm.getPosition());

        //clamp.setPosition(0.5 - (opmode.gamepad2.left_trigger/2));
        //opmode.telemetry.addData("clamp: ", clamp.getPosition());
        opmode.telemetry.update();
    }

    // move arm to up position
    public void up(){
        angle = 0.4; // ??
        arm.setPosition(angle);
    }

    // move arm to down position
    public void down() {
        angle = 0.8; // ??
        arm.setPosition(angle);
    }

    public void openClamp() {

        clamp.setPosition(0.5);
    }

    // grab a ring
    public void closeClamp() {

        clamp.setPosition(0);
    }
}
