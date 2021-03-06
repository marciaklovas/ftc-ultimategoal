/*
//  FTC FROGS (#14335) TEAM CODE
//
//  Class:
//      UltimateGoalTeleOp (TELEOP) - take in and launch rings, place rings on wobble stick
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

            UltGoal.drivetrain.drive(controlSpeed);
            UltGoal.intake.trigger();
            UltGoal.launcher.trigger();
            UltGoal.cv.look();
            UltGoal.arm.adjustArm();

            //////////////// GAMEPAD 1 (A) ///////////////////
            // Driving, turning, and finding lines

            // press gamepad1.x to stop finding a line (fwd or back)
            if (gamepad1.y) {
                UltGoal.drivetrain.fwdToLine();
            }
            if (gamepad1.a) {
                UltGoal.drivetrain.backToLine();
            }
            if (gamepad1.b) {
                controlSpeed = !controlSpeed;
            }
            if (gamepad1.right_bumper) {
                UltGoal.drivetrain.turnRight(90);
            }
            if (gamepad1.left_bumper) {
                UltGoal.drivetrain.turnLeft(90);
            }
            if (gamepad1.dpad_up) {
                UltGoal.drivetrain.goDistance(OurRobot.GO_FORWARD, 24, 0.3);
            }
            if (gamepad1.dpad_down) {
                UltGoal.drivetrain.goDistance(OurRobot.GO_BACKWARD, 24, 0.3);
            }


            //////////////// GAMEPAD 2 (B) ///////////////////
            // Arm controls
            if (gamepad2.left_bumper) {
                UltGoal.arm.openClamp();
            }
            if (gamepad2.right_bumper) {
                UltGoal.arm.closeClamp();
            }
            if (gamepad2.x) {
                UltGoal.arm.init();
            }
            if (gamepad2.a) {
                UltGoal.arm.down();
            }
            if (gamepad2.y) {
                UltGoal.arm.up();
            }

        }
    }
}


