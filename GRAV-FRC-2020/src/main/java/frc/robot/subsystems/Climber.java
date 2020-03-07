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
  VictorSPX hookMotor1, hookMotor2, winchMotor1, winchMotor2;
  AnalogInput analogUltraSonicSensor1;
  public Climber() {
    hookMotor1 = new VictorSPX(Constants.hookMotor1);
    hookMotor2 = new VictorSPX(Constants.hookMotor2);
    winchMotor1 = new VictorSPX(Constants.winchMotor1);
    winchMotor2 = new VictorSPX(Constants.winchMotor2);
    hookMotor1.setInverted(true);
    winchMotor1.setInverted(true);
    analogUltraSonicSensor1 = new AnalogInput(Constants.analogUltraSonicSensor1);
  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }

  public void hookDriveUp(boolean hookUp){
    if(hookUp){
      hookMotor1.set(ControlMode.PercentOutput, 0.75);
      hookMotor2.set(ControlMode.PercentOutput, 0.75);
    }    
    else{
      hookMotor1.set(ControlMode.PercentOutput, 0);
      hookMotor2.set(ControlMode.PercentOutput, 0);
    }
  }
  
  public void hookDriveDown(boolean hookDown){
    if(hookDown){
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

  public double getUltraSonic1Voltage(){
    return analogUltraSonicSensor1.getVoltage();
  } 
}
