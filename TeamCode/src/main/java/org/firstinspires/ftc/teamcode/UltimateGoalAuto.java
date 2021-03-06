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

        // detect 0, 1 or 4 rings

        // lower arm around wobble stick
        UltGoal.lowerArm();

        // if 0, drive to A square
        // if 1, drive to B square
        // if 4, drive to C square
        if (UltGoal.getRings() == 0)
        {
            UltGoal.driveDistance(FORWARD, 60, 0.3);
            UltGoal.fwdToLine();
            UltGoal.turnRight(15);

            // use CV to drive to low goal
        }
        else if (UltGoal.getRings() == 1)
        {
            // use CV to drive to low goal
        }
        else if (UltGoal.getRings() == 4)
        {
            // use CV to drive to low goal
        }
        else
        {
            // skip this part of the challenge - cv failed
        }

        // dump 3 rings passively into low goal

        //drive back to launch line and park - avoiding obstacles
        UltGoal.driveDistance(BACKWARD, 60, 0.2);
        sleep(200);
        UltGoal.backToLine();
    }
}
