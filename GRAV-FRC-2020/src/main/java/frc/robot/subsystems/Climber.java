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

public class Climber extends SubsystemBase {
  /**
   * Creates a new Climber.
   */
  TalonSRX hookMotor1, hookMotor2, winchMotor1, winchMotor2;
  public Climber() {
    hookMotor1 = new TalonSRX(Constants.hookMotor1);
    hookMotor2 = new TalonSRX(Constants.hookMotor2);
    winchMotor1 = new TalonSRX(Constants.winchMotor1);
    winchMotor2 = new TalonSRX(Constants.winchMotor2);
    hookMotor1.setInverted(true);
    winchMotor1.setInverted(true);
  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }

  public void hookDrive(boolean hookUp, boolean hookDown){
    if(hookUp && !hookDown){
      hookMotor1.set(ControlMode.PercentOutput, 0.75);
      hookMotor2.set(ControlMode.PercentOutput, 0.75);
    }
    else if(hookDown && !hookUp){
      hookMotor1.set(ControlMode.PercentOutput, -0.75);
      hookMotor2.set(ControlMode.PercentOutput, -0.75);
    }
    else{
      hookMotor1.set(ControlMode.PercentOutput, 0);
      hookMotor2.set(ControlMode.PercentOutput, 0);
    }
  } 

  public void winchDrive(boolean winchUp){
    if(winchUp){
      winchMotor1.set(ControlMode.PercentOutput, 0.75);
      winchMotor2.set(ControlMode.PercentOutput, 0.75);
    }
    else{
      winchMotor1.set(ControlMode.PercentOutput, 0);
      winchMotor2.set(ControlMode.PercentOutput, 0);
    }
  }
}
