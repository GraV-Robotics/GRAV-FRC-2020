/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  VictorSPX intakeDriveMotor;
  VictorSPX intakePivotMotor;
  DigitalInput limitSwitchDown;
  DigitalInput limitSwitchUp;

   

  public Intake() {
    intakeDriveMotor = new VictorSPX(Constants.intakeDriveMotor);
    intakePivotMotor = new VictorSPX(Constants.intakePivotMotor);
    limitSwitchDown = new DigitalInput(Constants.limitSwitchDown);
    limitSwitchUp = new DigitalInput(Constants.limitSwitchUp);
    

  }

  public void IntakeDrive(boolean intakeBall){
    if(intakeBall == true){
      intakeDriveMotor.set(ControlMode.PercentOutput, 1);
    }
    else{
      intakeDriveMotor.set(ControlMode.PercentOutput, 0);
    }    
  }

  public void IntakePivotState(boolean state){
    if(state == true && limitSwitchDown.get() == false){
      intakePivotMotor.set(ControlMode.PercentOutput, 0.5);
    }
    else if(state == false && limitSwitchUp.get() == false){
      intakePivotMotor.set(ControlMode.PercentOutput, - 0.5);
    }
    else{
      intakePivotMotor.set(ControlMode.PercentOutput, 0);
    }    
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
