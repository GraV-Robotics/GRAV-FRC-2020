/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //pneumatics
    public static final int shiftingSolenoid = 0;
    public static final int solenoid2port = 1;
    public static final int solenoid3port = 3;
    public static final int analogPressureSensorLow = 0;
    public static final int analogPressureSensorHigh = 1;

    // drivetrain
    public static final int leftMotor1 = 0;
    public static final int leftMotor2 = 1;
    public static final int leftMotor3 = 2;
    public static final int rightMotor1 = 3;
    public static final int rightMotor2 = 4;
    public static final int rightMotor3 = 5;
    public static final int leftEncoder[] = {0,1};
    public static final int rightEncoder[] = {2,3};
    public static final double encoderRate80Percent = 0.0;
    public static final double lowGearMaxFPS = 9.86;
    public static final double highGearMaxFPS = 25.34; 
    public static final double thresholdPercentLowGearFPS = lowGearMaxFPS * 0.8;
    public static final double thresholdPercentHighGear = thresholdPercentLowGearFPS/highGearMaxFPS;

    //Intake
    public static final int intakeDriveMotor = 6;
    public static final int intakePivotMotor = 7;     
    public static final int limitSwitchUp = 4;
    public static final int limitSwitchDown = 5;

    //Climber
    public static final int hookMotorLeft = 8;
    public static final int hookMotorRight = 9;
    public static final int winchMotor = 10;
    public static final int analogUltraSonicSensor = 2;

    //Feeder
    public static int feederMotor = 11;


    
}
