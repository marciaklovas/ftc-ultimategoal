/*
//  FTC FROGS (#14335) TEAM CODE
//
//  Class OurRobot
//
//  Revisions
//  	09-27-20	Coach M.   Original
//      02-19-21    Elijah W.  Renamed methods and objects to more meaningful
//                             Added I2C MCP23017 to robot
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


public class OurRobot {

    static final public boolean GO_BACKWARD = true;
    static final public boolean GO_FORWARD = false;

    public Drivetrain drivetrain;
    public Intake intake;
    public Launcher launcher;
    //public I2c mcp;
    public CVUnit cv;
    public Arm arm; // to pick up or drag wobble stick

    public OurRobot(LinearOpMode opmode)
    {
        drivetrain = new Drivetrain(opmode);
        intake = new Intake(opmode);
        launcher = new Launcher(opmode);
        //mcp = new I2c(opmode);
        cv = new CVUnit(opmode);
        arm = new Arm(opmode);
    }

    public void init() {
        drivetrain.init();
        cv.init();
    }
}
