/*
//  FTC FROGS (#14335) TEAM CODE
//
//  Class I2cDriver - This class contains commands to interface with the
//      LCD device connected to the Rev Expansion Hub
//
//  Methods:
//  	constructor - initialize the device
//      backlight - turn on
//      noBacklight - turn off
//      setCursor - set cursor position
//      clear - clear display
//  	display - print a message
//
//  Revisions
//  	02-05-21	Elijah W. and Marcia L.   Original
//
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;

public class I2cDriver {

    private LinearOpMode opMode;
    private I2cDeviceSynch lcd;

    final byte LCD_I2C_ADDR = 0x3F; // I2c address of the lcd device
    final byte DDRAM = 0x00; // beginning of DDRAM
    final byte IR = 0x10; // Instruction register
    final byte DR = 0x20; // Data register
    //final byte AC; // Address counter?

    // Characters to write
    final byte HASHTAG = 0x23; // LLHL LLHH = #

    public I2cDriver(LinearOpMode opmode)
    {
        this.opMode = opmode;
        lcd = opMode.hardwareMap.get(I2cDeviceSynch.class, "lcd");
    }

    public void backlight() {

    }

    public void noBacklight() {

    }

    public void setCursor() {

    }

    public void clear() {
        //lcd.write(IR, 0x01);
    }

    public void display(String message) {
        lcd.write8(0x00, 0x80 ); // set DDRAM address to 00
        lcd.write8(0x00, 0x23 ); // write hashtag to the first spot in DDRAM
    }

}
