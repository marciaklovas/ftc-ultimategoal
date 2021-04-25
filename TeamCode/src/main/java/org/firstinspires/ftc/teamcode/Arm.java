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
//      03-21-21    Kai P.          add adjust arm procedure
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {

    private Servo arm;
    private Servo clamp;
    //private TouchSensor digitalTouch;
    private LinearOpMode opmode;
    private boolean isClosed = false;

    private double armPower;
    private double angle;

    // constructor
    public Arm(LinearOpMode opmode) {
        this.opmode = opmode; // 'this' used for clarity
        arm       = opmode.hardwareMap.get(Servo.class, "armlift");
        clamp       = opmode.hardwareMap.get(Servo.class, "clamp");
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

    public void adjustArm()
    {
        if (opmode.gamepad2.right_stick_y <= 0) {


            arm.setPosition(((-opmode.gamepad2.right_stick_y / (1 / .55))) + .25);
        }

        //arm.setPosition(opmode.gamepad2.right_stick_y);
            opmode.telemetry.addData("armposition: ",
                    arm.getPosition());
            //opmode.telemetry.update();

        //clamp.setPosition(0.5 - (opmode.gamepad2.left_trigger/2));
        //opmode.telemetry.addData("clamp: ",
              //  clamp.getPosition());
        opmode.telemetry.update();
    }

    public void openClamp() {

            clamp.setPosition(0.5);
    }

    public void closeClamp() {
        clamp.setPosition(0);
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
