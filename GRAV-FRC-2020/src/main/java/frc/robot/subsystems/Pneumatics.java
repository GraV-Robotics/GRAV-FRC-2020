/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pneumatics extends SubsystemBase {
  /**
   * Creates a new Pneumatics.
   */
  Compressor compressor;
  Solenoid shiftingSolenoid;
  Solenoid solenoid2;
  Solenoid solenoid3;
  AnalogInput pressureSensorLow, pressureSensorHigh;

   public Pneumatics() {
     compressor = new Compressor(0);
     shiftingSolenoid = new Solenoid(Constants.shiftingSolenoid);
     solenoid2 = new Solenoid(Constants.solenoid2port);
     solenoid3 = new Solenoid(Constants.solenoid3port);
     pressureSensorLow = new AnalogInput(Constants.analogPressureSensor1);
     pressureSensorHigh = new AnalogInput(Constants.analogPressureSensor2);

    compressor.start();
  }

  public int pressureCheck(){
    double voltage = pressureSensorLow.getAverageVoltage();
    int psi = (int) Math.round((voltage - 0.5) * 50);
    return psi;
  }

  public void shiftDrive(boolean state){
    if(state && pressureCheck() >= 30){      
        shiftingSolenoid.set(true);            
    }
    else{
      shiftingSolenoid.set(false);
    }

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
