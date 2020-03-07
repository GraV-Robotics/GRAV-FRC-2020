/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private RobotContainer robotContainer;
  AnalogInput pressureSensorLow, pressureSensorHigh, ultraSonicSensor1;
  Encoder encoder1, encoder2;
  DigitalInput limitSwitchDown, limitSwitchUp; 

  

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    robotContainer = new RobotContainer();
    encoder1 = new Encoder(Constants.encoder1[0], Constants.encoder1[1], true);
    encoder2 = new Encoder(Constants.encoder2[0], Constants.encoder2[1], true);
    pressureSensorLow = new AnalogInput(Constants.analogPressureSensor1);
    pressureSensorHigh = new AnalogInput(Constants.analogPressureSensor2);
    limitSwitchDown = new DigitalInput(Constants.limitSwitchDown);
    limitSwitchUp = new DigitalInput(Constants.limitSwitchUp);
    ultraSonicSensor1 = new AnalogInput(Constants.analogUltraSonicSensor1);

    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("Encoder 1 Rate", encoder1.getRate());
    SmartDashboard.putNumber("Encoder 2 Rate", encoder2.getRate());
    SmartDashboard.putNumber("Pressure Sensor Low Average Voltage", pressureSensorLow.getAverageVoltage());
    SmartDashboard.putNumber("Pressure Sensor Low PSI", (int) Math.round((pressureSensorLow.getAverageVoltage() - 0.5) * 50));
    SmartDashboard.putNumber("Pressure Sensor High Average Voltage", pressureSensorHigh.getAverageVoltage());
    SmartDashboard.putNumber("Pressure Sensor High PSI", (int) Math.round((pressureSensorHigh.getAverageVoltage() - 0.5) * 50));
    SmartDashboard.putBoolean("Limit Switch Down", limitSwitchDown.get());
    SmartDashboard.putBoolean("Limit Switch Up", limitSwitchUp.get());
    SmartDashboard.putNumber("Ultra Sonic Sensor 1 Voltage", ultraSonicSensor1.getVoltage());
    SmartDashboard.putNumber("Ultra Sonic Sensor 1 Distance",(ultraSonicSensor1.getVoltage()*0.997)/25.4);



    
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
