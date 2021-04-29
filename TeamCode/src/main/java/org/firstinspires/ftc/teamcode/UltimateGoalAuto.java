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
//      04-29-21    Elijah W.   Added code to drop off wobble stick
//
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="UltimateGoalAuto", group="Linear Opmode")

public class UltimateGoalAuto extends LinearOpMode {

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
        //UltGoal.lowerArm();
        //sleep(200);

        // tested- this works!
        //if (UltGoal.getRings() == 0) // if 0, drive to A square
        /*{
            UltGoal.driveDistance(OurRobot.GO_FORWARD, 40, 0.5); sleep(200);
            UltGoal.turnLeft(30); sleep(200);
            UltGoal.driveDistance(OurRobot.GO_FORWARD, 3, 0.3); sleep(200);
            //UltGoal.raiseArm(); sleep(200);
            UltGoal.driveDistance(OurRobot.GO_BACKWARD, 3, 0.5); sleep(200);

        }
        else if (UltGoal.getRings() == 1) // if 1, drive to B square
        {
            UltGoal.driveDistance(OurRobot.GO_FORWARD, 60, 0.5); sleep(200);
            UltGoal.fwdToLine(); sleep(200);
            UltGoal.turnRight(45); sleep(200);
            UltGoal.driveDistance(OurRobot.GO_FORWARD, 3, 0.3); sleep(200);
            //UltGoal.raiseArm(); sleep(200);
            UltGoal.driveDistance(OurRobot.GO_BACKWARD, 3, 0.5); sleep(200);
        }
        else if (UltGoal.getRings() == 4) // if 4, drive to C square
        {*/
            UltGoal.driveDistance(OurRobot.GO_FORWARD, 60, 0.5); sleep(200);
            UltGoal.fwdToLine(); sleep(200);
            UltGoal.driveDistance(OurRobot.GO_FORWARD, 20, 0.5); sleep(200);
            UltGoal.turnLeft(30); sleep(200);
            UltGoal.driveDistance(OurRobot.GO_FORWARD, 6, 0.3); sleep(200);
            //UltGoal.raiseArm(); sleep(200);
            UltGoal.driveDistance(OurRobot.GO_BACKWARD, 6, 0.5); sleep(200);
        /*}
        else
        {
            // skip this part of the challenge - cv failed
            UltGoal.raiseArm(); sleep(200);
            UltGoal.driveDistance(OurRobot.GO_FORWARD, 60, 0.5); sleep(200);
            UltGoal.fwdToLine(); sleep(200);
        } */

        // launch rings into low goal

        //drive back to launch line and park - avoiding obstacles
        //UltGoal.driveDistance(OurRobot.GO_BACKWARD, 60, 0.2); //sleep(200);
        //UltGoal.backToLine();
    }
}
