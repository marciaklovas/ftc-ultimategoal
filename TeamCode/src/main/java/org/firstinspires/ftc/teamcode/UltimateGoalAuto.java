/*
//  FTC FROGS (#14335) TEAM CODE
//
//  AUTONOMOUS
//
//  Class UltimateGoalAuto
//
//  Revisions
//      12-01-18    Elijah W.   Original
//      02-19-21    Elijah W.   Updated for Ultimate Goal
//
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="UltimateGoalAuto", group="Linear Opmode")

public class UltimateGoalAuto extends LinearOpMode {

    // Declare constants
    final static boolean BACKWARD = true;
    final static boolean FORWARD = false;

    // Declare members
    private OurRobot UltGoal;
    private ElapsedTime runtime; // not sure how to use this yet

    @Override
    public void runOpMode() {
        // 'this' needed for opmode to setup hardware in OurRobot
        UltGoal = new OurRobot(this);
        runtime = new ElapsedTime();

        UltGoal.init();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // test drive
        UltGoal.driveDistance(FORWARD, 24, 0.2);
        sleep(200);
        UltGoal.turnRight(90);
        sleep(200);
        UltGoal.backToLine();
    }
}
