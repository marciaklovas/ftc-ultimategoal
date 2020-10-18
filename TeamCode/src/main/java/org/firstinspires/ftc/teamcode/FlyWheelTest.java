package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class FlyWheelTest {

    private DcMotor flywheel1;
    private LinearOpMode opMode;

    private double speed;

    public FlyWheelTest (LinearOpMode opmode) {
        this.opMode = opmode;
        flywheel1 = opMode.hardwareMap.get(DcMotor.class,"launcher");
        flywheel1.setDirection(DcMotor.Direction.REVERSE);
    }

    public void wheelTrigger(){
        speed = opMode.gamepad1.right_trigger;
        flywheel1.setPower(speed);
    }

}
