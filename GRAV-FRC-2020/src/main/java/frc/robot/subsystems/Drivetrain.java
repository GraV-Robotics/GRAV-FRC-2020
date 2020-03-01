/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */

  TalonSRX leftMotor1;
  TalonSRX leftMotor2;
  TalonSRX leftMotor3;
  TalonSRX rightMotor1;
  TalonSRX rightMotor2;
  TalonSRX rightMotor3;

  public Drivetrain() {
    leftMotor1 = new TalonSRX(Constants.leftMotor1);
    leftMotor2 = new TalonSRX(Constants.leftMotor2);
    leftMotor3 = new TalonSRX(Constants.leftMotor3);
    rightMotor1 = new TalonSRX(Constants.rightMotor1);
    rightMotor2 = new TalonSRX(Constants.rightMotor2);
    rightMotor3 = new TalonSRX(Constants.rightMotor3);
  }

  public void ArcadeDrive(double forward, double turn) {
    double leftPower = forward+turn;
    double rightPower = forward-turn;
    
    leftMotor1.set(ControlMode.PercentOutput, leftPower);
    leftMotor2.set(ControlMode.PercentOutput, leftPower);
    leftMotor3.set(ControlMode.PercentOutput, leftPower);
    rightMotor1.set(ControlMode.PercentOutput, rightPower);
    rightMotor2.set(ControlMode.PercentOutput, rightPower);
    rightMotor3.set(ControlMode.PercentOutput, rightPower);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
