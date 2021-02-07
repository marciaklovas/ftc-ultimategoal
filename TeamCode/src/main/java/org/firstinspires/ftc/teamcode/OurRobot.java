/*
//  FTC FROGS (#14335) TEAM CODE
//
//  Class OurRobot
//
//  Methods:
//  	constructor - instantiates a normalDrive
//  	init()
//
//  Revisions
//  	09-27-20	Coach M.   Original
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.I2cDevice;

public class OurRobot {

    private NormalDrive normalDrive;

    private FlyWheelTest flyWheelTest;

    private Launcher launcher;

    private I2cDriver LCD;

    public OurRobot(LinearOpMode opmode)
    {
        normalDrive = new NormalDrive(opmode);
        flyWheelTest = new FlyWheelTest(opmode);
        launcher = new Launcher(opmode);
    }

    public void init() {
        normalDrive.init();
    }

    public void drive() {
        normalDrive.drive();
    }

    public void wheelTrigger(){flyWheelTest.wheelTrigger();}

    public void wheelButton() {flyWheelTest.wheelButton();}

    public void launcher() {launcher.wheelTrigger(); }

    public void displayLCD() {LCD.display("Hello");}
}
