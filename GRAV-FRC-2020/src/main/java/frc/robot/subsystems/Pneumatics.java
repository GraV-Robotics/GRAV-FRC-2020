/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pneumatics extends SubsystemBase {
  /**
   * Creates a new Pneumatics.
   */
  Compressor compressor;
  Solenoid solenoid1;
  Solenoid solenoid2;
  Solenoid solenoid3;

   public Pneumatics() {
     compressor = new Compressor(0);
     solenoid1 = new Solenoid(Constants.solenoid1port);
     solenoid2 = new Solenoid(Constants.solenoid2port);
     solenoid3 = new Solenoid(Constants.solenoid3port);

    compressor.start();

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
