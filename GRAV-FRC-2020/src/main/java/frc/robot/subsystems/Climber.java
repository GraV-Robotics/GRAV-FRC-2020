/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  /**
   * Creates a new Climber.
   */
  VictorSPX hookMotorLeft, hookMotorRight, winchMotor1, winchMotor2;
  AnalogInput analogUltraSonicSensor1;
  public Climber() {
    hookMotorLeft = new VictorSPX(Constants.hookMotorLeft);
    hookMotorRight = new VictorSPX(Constants.hookMotorRight);
    winchMotor1 = new VictorSPX(Constants.winchMotor);
    hookMotorLeft.setInverted(true);
    winchMotor1.setInverted(true);
    analogUltraSonicSensor1 = new AnalogInput(Constants.analogUltraSonicSensor);
  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }

  public void hookDriveUp(boolean hookUp){
    if(hookUp){
      hookMotorLeft.set(ControlMode.PercentOutput, 0.75);
      hookMotorRight.set(ControlMode.PercentOutput, 0.75);
    }    
    else{
      hookMotorLeft.set(ControlMode.PercentOutput, 0);
      hookMotorRight.set(ControlMode.PercentOutput, 0);
    }
  }
  
  public void hookDriveDown(boolean hookDown){
    if(hookDown){
      hookMotorLeft.set(ControlMode.PercentOutput, -0.75);
      hookMotorRight.set(ControlMode.PercentOutput, -0.75);
    }
    else{
      hookMotorLeft.set(ControlMode.PercentOutput, 0);
      hookMotorRight.set(ControlMode.PercentOutput, 0);
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

  public double getUltraSonic1Voltage(){
    return analogUltraSonicSensor1.getVoltage();
  } 
}
