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
  DigitalInput limitSwitch1;
  DigitalInput limitSwitch2;

   

  public Intake() {
    intakeDriveMotor = new VictorSPX(Constants.intakeDriveMotor);
    intakePivotMotor = new VictorSPX(Constants.intakePivotMotor);
    limitSwitch1 = new DigitalInput(Constants.limitSwitch1);
    limitSwitch2 = new DigitalInput(Constants.limitSwitch2);
    

  }

  public void IntakeDrive(boolean intakeBall){
    if(intakeBall == true){
      intakeDriveMotor.set(ControlMode.PercentOutput, 1);
    }
    else{
      intakeDriveMotor.set(ControlMode.PercentOutput, 0);
    }    
  }

  public void IntakePivotUp(boolean up){
    if(up == true && limitSwitch1.get() == false){
      intakePivotMotor.set(ControlMode.PercentOutput, 0.5);
    }
    else{
      intakePivotMotor.set(ControlMode.PercentOutput, 0);
    }    
  }

  public void IntakePivotDown(boolean down){
    if(down == true && limitSwitch2.get() == false){
      intakePivotMotor.set(ControlMode.PercentOutput, -0.5);
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
