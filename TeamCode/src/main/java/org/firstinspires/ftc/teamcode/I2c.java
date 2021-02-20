/*
//  FTC FROGS (#14335) TEAM CODE
//
//  Class I2c - This class contains commands to interface with the
//      LCD and the MCP23017 devices connected to the Rev Expansion Hub
//
//  Methods:
//  	constructor - initialize the devices
//
//      LCD methods:
//      backlight - turn on
//      noBacklight - turn off
//      setCursor - set cursor position
//      clear - clear display
//  	display - print a message
//
//      MCP methods:
//      writeMode - set up to write
//      ledOn, ledOff
//
//  Revisions
//  	02-05-21	Elijah W. and Marcia L.   Original
//      02-13-21    Elijah W. and Marcia L.   Added MCP23017 methods
//
*/

package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.hardware.HardwareDevice;
        import com.qualcomm.robotcore.hardware.I2cDeviceSynch;

public class I2c {

    private LinearOpMode opMode;
    private I2cDeviceSynch lcd, mcp; // two I2C devices

    final byte LCD = 0x3F; // I2c address of LCD
    final byte MCP = 0x20; // I2C address of MCP23017

    // Note that a Java byte holds -128 to 127, stored in 8-bit two's complement form

    // LCD
    final byte DDRAM = 0x00; // beginning of DDRAM
    final byte IR = 0x10; // Instruction register
    final byte DR = 0x20; // Data register
    //final byte AC; // Address counter?
    final byte HASHTAG = 0x23; // Character to write: LLHL LLHH = #

    // MCP23017
    final byte IODIRA = 0x00; // IO direction A address
    final int WRITE = 0xFE; // last bit is 0 setting GPIO0 to write 11111110
    final byte OLATA = 0x14; // Output latch A register address
    final byte LED_ON = 0x01; // last bit turns the  LED on
    final byte LED_OFF = 0x00; // last bit turns LED off

    public I2c(LinearOpMode opmode)
    {
        this.opMode = opmode;
        //lcd = opMode.hardwareMap.get(I2cDeviceSynch.class, "lcd");
        mcp = opMode.hardwareMap.get(I2cDeviceSynch.class, "mcp");
    }

    // MCP methods -------------------------
    public void writeMode() {
        mcp.write8(IODIRA, WRITE);
    }

    public void ledOn() {
        mcp.write8(OLATA, LED_ON);
    }

    public void ledOff() {
        mcp.write8(OLATA, LED_OFF);
    }

    // LCD methods -------------------------
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
        //lcd.write8(0x00, 0x80 ); // set DDRAM address to 00
        //lcd.write8(0x00, 0x23 ); // write hashtag to the first spot in DDRAM
    }

}
