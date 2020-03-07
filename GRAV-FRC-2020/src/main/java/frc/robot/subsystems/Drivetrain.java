/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */

  VictorSPX leftMotor1;
  VictorSPX leftMotor2;
  VictorSPX leftMotor3;
  VictorSPX rightMotor1;
  VictorSPX rightMotor2;
  VictorSPX rightMotor3;
  Encoder encoder1, encoder2;
  AHRS navx;

  public Drivetrain() {
    leftMotor1 = new VictorSPX(Constants.leftMotor1);
    leftMotor2 = new VictorSPX(Constants.leftMotor2);
    leftMotor3 = new VictorSPX(Constants.leftMotor3);
    rightMotor1 = new VictorSPX(Constants.rightMotor1);
    rightMotor2 = new VictorSPX(Constants.rightMotor2);
    rightMotor3 = new VictorSPX(Constants.rightMotor3);
    encoder1 = new Encoder(Constants.encoder1[0], Constants.encoder1[1], true);
    encoder2 = new Encoder(Constants.encoder2[0], Constants.encoder2[1], true);
    navx = new AHRS(Port.kMXP);

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

  public double getEncoder1Rate(){
    return encoder1.getRate();
  } 
  
  public double getEncoder2Rate(){
    return encoder2.getRate();
  }

  public double getEncoder1Position(){
    return encoder1.get();
  }

  public double getEncoder2Position(){
    return encoder2.get();
  }

  public void navxCalibrate(){
  
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
