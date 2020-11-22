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

public class OurRobot {

    private NormalDrive normalDrive;

    private FlyWheelTest flyWheelTest;

    public OurRobot(LinearOpMode opmode)
    {
        normalDrive = new NormalDrive(opmode);
        flyWheelTest = new FlyWheelTest(opmode);
    }

    public void init() {
        normalDrive.init();
    }

    public void drive() {
        normalDrive.drive();
    }

    public void wheelTrigger(){flyWheelTest.wheelTrigger();}

}
