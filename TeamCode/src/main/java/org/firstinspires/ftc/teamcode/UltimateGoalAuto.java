/*
//  FTC FROGS (#14335) TEAM CODE
//
//  Class:
//      UltimateGoalAuto (AUTONOMOUS) - scans ring stack, delivers wobble stick and parks
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
    private String stack = "None";

    @Override
    public void runOpMode() {
        // 'this' needed for opmode to setup hardware in OurRobot
        UltGoal = new OurRobot(this);
        runtime = new ElapsedTime();

        UltGoal.init();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        long start = System.currentTimeMillis();

        // detect 0, 1 or 4 rings for 10 seconds
        while ((stack.equals("None")) && ((System.currentTimeMillis()-start) < 10000)) {
            // keep scanning
            stack = UltGoal.cv.detectRings();
        }

        // lower arm around wobble stick
        //UltGoal.arm.down(); sleep(200);

        if (stack.equals("Single")) // if 1 ring, drive to B square
        {
            UltGoal.drivetrain.goDistance(OurRobot.GO_FORWARD, 60, 0.7); sleep(200);
            UltGoal.drivetrain.fwdToLine(); sleep(200);
            UltGoal.drivetrain.turnRight(45); sleep(200);
            UltGoal.drivetrain.goDistance(OurRobot.GO_FORWARD, 3, 0.3); sleep(200);
            //UltGoal.arm.up(); sleep(200);

            //drive back to launch line and park
            UltGoal.drivetrain.goDistance(OurRobot.GO_BACKWARD, 5, 0.7); sleep(200);
            UltGoal.drivetrain.turnLeft(45); sleep(200);
            UltGoal.drivetrain.backToLine();
        }
        else if (stack.equals("Quad")) // if 4 rings, drive to C square
        {
            UltGoal.drivetrain.goDistance(OurRobot.GO_FORWARD, 60, 0.7); sleep(200);
            UltGoal.drivetrain.fwdToLine(); sleep(200);
            UltGoal.drivetrain.goDistance(OurRobot.GO_FORWARD, 20, 0.7); sleep(200);
            UltGoal.drivetrain.turnLeft(30); sleep(200);
            UltGoal.drivetrain.goDistance(OurRobot.GO_FORWARD, 6, 0.3); sleep(200);
            //UltGoal.arm.up(); sleep(200);

            //drive back to launch line and park
            UltGoal.drivetrain.goDistance(OurRobot.GO_BACKWARD, 10, 0.7); sleep(200);
            UltGoal.drivetrain.turnRight(30); sleep(200);
            UltGoal.drivetrain.goDistance(OurRobot.GO_BACKWARD, 15, 0.7); sleep(200);
            UltGoal.drivetrain.backToLine();
        }
        else // stack is zero or scan failed, drive to A
        {
            UltGoal.drivetrain.goDistance(OurRobot.GO_FORWARD, 40, 0.7); sleep(200);
            UltGoal.drivetrain.turnLeft(30); sleep(200);
            UltGoal.drivetrain.goDistance(OurRobot.GO_FORWARD, 3, 0.3); sleep(200);
            //UltGoal.arm.up(); sleep(200);

            //drive back to launch line and park
            UltGoal.drivetrain.goDistance(OurRobot.GO_BACKWARD, 6, 0.7); sleep(200);
            UltGoal.drivetrain.turnRight(60); sleep(200);
            UltGoal.drivetrain.goDistance(OurRobot.GO_FORWARD, 10, 0.7); sleep(200);
            UltGoal.drivetrain.fwdToLine();

        }
    }
}
