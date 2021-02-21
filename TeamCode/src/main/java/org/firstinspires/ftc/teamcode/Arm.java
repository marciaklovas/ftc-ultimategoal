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
//
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Arm {

    //private Servo servo1;
    //private Servo servo0;
    private DcMotor lift;
    //private TouchSensor digitalTouch;
    private LinearOpMode opmode;

    private double armPower;

    // constructor
    public Arm(LinearOpMode opmode) {
        this.opmode = opmode; // 'this' used for clarity
        //servo0     = opmode.hardwareMap.get(Servo.class, "servo0");
        //c
        lift       = opmode.hardwareMap.get(DcMotor.class, "armlift");
        //digitalTouch = opmode.hardwareMap.get(TouchSensor.class, "sensor_digital");
    }

    public void move() {
        armPower = -opmode.gamepad2.right_stick_y;

        /*
        if (digitalTouch.getValue() == 1) {
            if (armPower < 0) {
                lift.setPower(-armPower/3);
            }
            else {
                lift.setPower(armPower/3);
            }
        }
        else { */
            lift.setPower(armPower/3);
        //}
    }

    /*
    // initialize claw arm to up position
    public void init() {
        armPower   = 0;
        while (digitalTouch.getValue() == 0) {
            lift.setPower(-.2);
        }
        lift.setPower(armPower);
    }

    // open claw and move claw down in position to grab ball
    public void down(){
        openClaw();
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // trial and error to get 720
        lift.setTargetPosition((int)720);

        // setup to go desired distnace
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lift.setPower(.2);

        //while moving
        while (lift.isBusy()) {
            // wait til move finishes
        }

        // stop
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift.setPower(0);

        // reset mode when done
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    // closes claw and goes up dumping ball in hopper
    public void up(){

        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // add minus sign to ticks below to go in reverse
        lift.setTargetPosition((int)-720);

        // setup to go desired distnace
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lift.setPower(.4);

        //while moving
        while (lift.isBusy()) {
            // wait til move finishes
        }

        // stop
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift.setPower(0);

        // reset mode when done
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void openClaw() {
        servo0.setPosition(0.5);
        servo1.setPosition(0.5);
    }

    public void closeClaw() {
        servo0.setPosition(0);
        servo1.setPosition(1);
    }
    */
}
