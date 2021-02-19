/*
//  FTC FROGS (#14335) TEAM CODE
//
//  TELEOP
//
//  Class UltimateGoalTeleOp
//
//  Revisions
//      09-27-20    Elijah W. and Coach M.   Original
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="UltimateGoalTeleOp", group="Linear Opmode")
public class UltimateGoalTeleOp extends LinearOpMode {

    // declare members
    private OurRobot UltGoal;
    private ElapsedTime runtime;

    @Override
    public void runOpMode() {
        // 'this' used because opmode is needed to setup hardware
        UltGoal = new OurRobot(this);
        runtime = new ElapsedTime(); // not sure how to use this yet

        UltGoal.init();

        sleep(2000);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            UltGoal.drive();
            UltGoal.triggerIntake();
            UltGoal.triggerLauncher();

            //////////////// GAMEPAD 1 (A) ///////////////////
            // use some control (?) to UltGoal.signalDriver();

            //////////////// GAMEPAD 2 (B) ///////////////////

        }
    }
}


