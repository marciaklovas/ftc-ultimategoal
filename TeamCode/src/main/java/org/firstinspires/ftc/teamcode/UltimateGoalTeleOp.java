/*
//  FTC FROGS (#14335) TEAM CODE
//
//  TELEOP
//
//  Class UltimateGoalTeleOp
//
//  Revisions
//      09-27-20    Elijah W. and Coach M.   Original
//      02-24-21    Elijah W.                Added gamepad1 controls to drive,
//                                           turn, and find lines
//      02-25-21    Elijah W.                Added gamepad2 servo arm controls
//
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="UltimateGoalTeleOp", group="Linear Opmode")
public class UltimateGoalTeleOp extends LinearOpMode {

    // declare constants
    static final boolean FAST = false;
    static final boolean SLOW = true;

    // declare members
    private OurRobot UltGoal;
    private ElapsedTime runtime;

    private boolean controlSpeed;

    @Override
    public void runOpMode() {
        // 'this' used because opmode is needed to setup hardware
        UltGoal = new OurRobot(this);
        runtime = new ElapsedTime(); // not sure how to use this yet

        UltGoal.init();

        controlSpeed = SLOW;
        sleep(2000);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            UltGoal.drive(controlSpeed);
            UltGoal.triggerIntake();
            UltGoal.triggerLauncher();
            UltGoal.look();
            UltGoal.controlArm();
            UltGoal.trackTarget();

            //////////////// GAMEPAD 1 (A) ///////////////////
            // Driving, turning, finding lines, and collecting rings

            // press gamepad1.x to stop finding a line (fwd or back)
            if (gamepad1.y) {
                UltGoal.fwdToLine();
            }

            if (gamepad1.a) {
                UltGoal.backToLine();
            }

            if (gamepad1.b) {
                controlSpeed = !controlSpeed;
            }

            if (gamepad1.right_bumper) {
                UltGoal.turnRight(90);
            }

            if (gamepad1.left_bumper) {
                UltGoal.turnLeft(90);
            }

            if (gamepad1.dpad_up) {
                UltGoal.driveDistance(OurRobot.GO_FORWARD, 24, 0.3);
            }

            if (gamepad1.dpad_down) {
                UltGoal.driveDistance(OurRobot.GO_BACKWARD, 24, 0.3);
            }

            // use some control (?) to UltGoal.signalDriver();

            //////////////// GAMEPAD 2 (B) ///////////////////
            // Launching rings, controlling the arm, and doing computer vision

            // Arm controls
            if (gamepad2.x) {
                UltGoal.initializeArm();
            }
            if (gamepad2.a) {
                UltGoal.lowerArm();
            }
            if (gamepad2.y) {
                UltGoal.raiseArm();
            }
        }
    }
}


