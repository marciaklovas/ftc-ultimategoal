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

    private Drivetrain drivetrain;
    private Intake intake;
    private Launcher launcher;
    private I2c mcp;
    private CVUnit cv;
    private Claw claw; // to pick up or drag wobble stick

    public OurRobot(LinearOpMode opmode)
    {
        drivetrain = new Drivetrain(opmode);
        intake = new Intake(opmode);
        launcher = new Launcher(opmode);
        mcp = new I2c(opmode);
        cv = new CVUnit(opmode);
        claw = new Claw(opmode);
    }

    public void init() {
        drivetrain.init();
        cv.init();
    }
    public void drive() {
        drivetrain.drive();
    }
    public void triggerIntake(){intake.trigger();}
    public void triggerLauncher() {launcher.trigger(); }
    public void signalDriver() {mcp.ledOn();}

    public void driveDistance(boolean direction, double inches, double power)
    { drivetrain.goDistance(direction, inches, power);}
    public void backToLine() {drivetrain.backToLine();}
    public void fwdToLine() {drivetrain.fwdToLine();}
    public void turnRight(int angle) {drivetrain.turnRight(angle);}
    public void turnLeft(int angle) {drivetrain.turnLeft(angle);}
}
