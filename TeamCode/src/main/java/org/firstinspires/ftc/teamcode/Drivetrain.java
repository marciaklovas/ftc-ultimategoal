/*
//  FTC FROGS (#14335) TEAM CODE
//
//  Class Drivetrain
//
//  Methods:
//  	constructor
//  	init()
//  	drive()
//      backToLine() - yellow line?
//      fwdToLine() - yellow line?
//      goDistance()
//      turnRight()
//      turnLeft()
//
//  Revisions
//  	09-27-20	Elijah W.   Original
//      10-11-20    Elijah W.   Commented constructor and drive methods to use
//                              m0 and m1 only - prototype drive
//      02-19-21    Elijah W.   Renamed from Normal Drive to Drivetrain,
//                              Added color sensor and IMU methods
//
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;

public class Drivetrain {

    // declare constants
    final static double WHEEL_CIRCUM = 12.2;   // in inches
    final static int TETRIX_MOTOR_1440 = 1440; // 1440 ticks per revolution
    final static double WHITE_THRESHOLD = 400;
    final static boolean FAST = false;
    final static boolean SLOW = true;
    final static boolean FORWARD = false;
    final static boolean BACKWARD = true;

    // declare members
    private DcMotor rightWheel;
    private DcMotor leftWheel;
    private ColorSensor sensor;
    private BNO055IMU imu;
    private LinearOpMode opMode;

    private double leftPower;
    private double rightPower;
    private double drive;
    private double turn;
    private double targetAngle;

    // State used for updating telemetry
    private Orientation angles;
    private Acceleration gravity;

    // constructor method
    public Drivetrain (LinearOpMode opmode) {
        // hardwaremap
        this.opMode = opmode; // 'this' used for clarity
        rightWheel = opMode.hardwareMap.get(DcMotor.class, "m0");
        leftWheel = opMode.hardwareMap.get(DcMotor.class, "m1");
        sensor = opMode.hardwareMap.get(ColorSensor.class, "colorsensor");
        imu = opmode.hardwareMap.get(BNO055IMU.class, "imu");

        // IMU parameters
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        imu.initialize(parameters);
    }

    public void init() {
        // Set initial conditions for the motors
        rightWheel.setDirection(DcMotor.Direction.FORWARD);
        leftWheel.setDirection(DcMotor.Direction.REVERSE);
        rightWheel.setPower(0);
        leftWheel.setPower(0);
    }

    public void drive (boolean cS) {
        rightPower = -opMode.gamepad1.left_stick_y - opMode.gamepad1.left_stick_x;
        leftPower = -opMode.gamepad1.left_stick_y + opMode.gamepad1.left_stick_x;

        //rightWheel.setPower(rightPower);
        //leftWheel.setPower(leftPower);
        // Set the power of motors
        if (cS == FAST) {
            rightWheel.setPower(rightPower);
            leftWheel.setPower(leftPower);
        }
        else { // SLOW
            rightWheel.setPower(rightPower/2);
            leftWheel.setPower(leftPower/2);
        }
    }

    // gamepad1.x = emergency stop
    public void fwdToLine() {
        rightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightWheel.setPower(0.2);
        leftWheel.setPower(0.2);
        while (opMode.opModeIsActive() && (sensor.alpha() <
                WHITE_THRESHOLD) && (!opMode.gamepad1.x)) {
            opMode.telemetry.addData("Light Level",
                    sensor.alpha());
            opMode.telemetry.update();
        }
        rightWheel.setPower(0);
        leftWheel.setPower(0);
    }

    public void backToLine() {
        rightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightWheel.setPower(-0.2);
        leftWheel.setPower(-0.2);
        while (opMode.opModeIsActive() && (sensor.alpha() <
                WHITE_THRESHOLD) && (!opMode.gamepad1.x)) {
            opMode.telemetry.addData("Light Level",
                    sensor.alpha());
            opMode.telemetry.update();
        }
        rightWheel.setPower(0);
        leftWheel.setPower(0);
    }

    // method to go a specified distance (in inches)
    public void goDistance(boolean direction, double inches,
                           double power) {

        rightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // debug display on driver station phone
        opMode.telemetry.addData("leftTicks: ",
                leftWheel.getCurrentPosition());
        opMode.telemetry.addData("rightTicks: ",
                rightWheel.getCurrentPosition());
        opMode.telemetry.update();

        // calculate how many shaft rotations
        // based on wheel circumference
        double rotations=(inches/WHEEL_CIRCUM);

        // torquenado motor encoder has 1440 ticks per revolution
        double ticks=rotations*TETRIX_MOTOR_1440;

        // add minus sign to ticks below to go in reverse
        if (direction == BACKWARD) {
            leftWheel.setTargetPosition((int)-ticks);
            rightWheel.setTargetPosition((int)-ticks);
        }
        else if (direction == FORWARD) {
            leftWheel.setTargetPosition((int)ticks);
            rightWheel.setTargetPosition((int)ticks);
        }

        // setup to go desired distnace
        leftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftWheel.setPower(power);
        rightWheel.setPower(power);

        //while moving, display debug data
        while (leftWheel.isBusy() && rightWheel.isBusy()) {
            opMode.telemetry.addData("leftTicks: ",
                    leftWheel.getCurrentPosition());
            opMode.telemetry.addData("rightTicks: ",
                    leftWheel.getCurrentPosition());
            opMode.telemetry.update();
        }

        // stop
        leftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftWheel.setPower(0);
        rightWheel.setPower(0);

        // reset mode when done
        leftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    // consider combining turnRight and turnLeft into one method
    public void turnRight (int angle) {
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC,
                AxesOrder.ZYX, AngleUnit.DEGREES);

        // counterclockwise is positive direction (in degrees)
        targetAngle = angles.firstAngle - angle;

        opMode.telemetry.addData("Current Angle ",
                (angles.firstAngle));
        opMode.telemetry.addData("Target Angle ", targetAngle);
        opMode.telemetry.update();

        leftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while (angles.firstAngle > targetAngle) {

            leftWheel.setPower(.2);
            rightWheel.setPower(-.2);

            opMode.telemetry.addData("degs ", angles.firstAngle);
            opMode.telemetry.addData("target ", targetAngle);
            opMode.telemetry.update();

            angles =imu.getAngularOrientation(AxesReference.INTRINSIC,
                    AxesOrder.ZYX, AngleUnit.DEGREES);
        }
        leftWheel.setPower(0);
        rightWheel.setPower(0);

        opMode.telemetry.addData("Current Angle ",
                (angles.firstAngle));
        opMode.telemetry.update();

    }

    public void turnLeft (int angle) {
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC,
                AxesOrder.ZYX, AngleUnit.DEGREES);

        // counterclockwise is positive direction (in degrees)
        targetAngle = angles.firstAngle + angle;

        opMode.telemetry.addData("Current Angle ",
                (angles.firstAngle));
        opMode.telemetry.addData("Target Angle ", targetAngle);
        opMode.telemetry.update();

        leftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while (angles.firstAngle < targetAngle) {

            leftWheel.setPower(-.2);
            rightWheel.setPower(.2);

            opMode.telemetry.addData("degs ", angles.firstAngle);
            opMode.telemetry.addData("target ", targetAngle);
            opMode.telemetry.update();

            angles =imu.getAngularOrientation(AxesReference.INTRINSIC,
                    AxesOrder.ZYX, AngleUnit.DEGREES);
        }

        leftWheel.setPower(0);
        rightWheel.setPower(0);

        opMode.telemetry.addData("Current Angle ",
                (angles.firstAngle));
        opMode.telemetry.update();

    }

}
