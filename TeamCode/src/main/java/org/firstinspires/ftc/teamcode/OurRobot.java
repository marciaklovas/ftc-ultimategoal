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

    private Drivetrain drivetrain;
    private Intake intake;
    private Launcher launcher;
    //private I2c mcp;
    private CVUnit cv;
    private Arm arm; // to pick up or drag wobble stick

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
    public void drive(boolean cS) {
        drivetrain.drive(cS);
    }
    public void triggerIntake(){intake.trigger();}
    public void triggerLauncher() {launcher.trigger(); }
    //public void signalDriver() {mcp.ledOn();}
    public void look() {cv.look();};
    public void controlArm() {arm.adjustArm();};

    public void driveDistance(boolean direction, double inches, double power)
        { drivetrain.goDistance(direction, inches, power);}
    public void backToLine() {drivetrain.backToLine();}
    public void fwdToLine() {drivetrain.fwdToLine();}
    public void turnRight(int angle) {drivetrain.turnRight(angle);}
    public void turnLeft(int angle) {drivetrain.turnLeft(angle);}
    public void initializeArm() {arm.init();}
    public void raiseArm() {arm.up();}
    public void lowerArm() {arm.down();}
    public void trackTarget() {cv.track();};

    public int getRings() {return cv.detectNumberOfRings();}
}
