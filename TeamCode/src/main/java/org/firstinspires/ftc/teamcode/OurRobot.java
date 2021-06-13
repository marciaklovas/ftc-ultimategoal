/*
//  FTC FROGS (#14335) TEAM CODE
//
//  Class:
//      OurRobot - initializes subsystems
//
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


public class OurRobot {

    static final public boolean GO_BACKWARD = true;
    static final public boolean GO_FORWARD = false;

    public Drivetrain drivetrain;
    public Intake intake;
    public Launcher launcher;
    public CVUnit cv;
    public Arm arm; // to pick up or drag wobble stick

    public OurRobot(LinearOpMode opmode)
    {
        drivetrain = new Drivetrain(opmode);
        intake = new Intake(opmode);
        launcher = new Launcher(opmode);
        cv = new CVUnit(opmode);
        arm = new Arm(opmode);
    }

    public void init() {
        drivetrain.init();
        cv.init();
    }
}
