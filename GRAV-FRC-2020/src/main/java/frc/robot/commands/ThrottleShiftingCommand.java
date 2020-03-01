/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Pneumatics;

public class ThrottleShiftingCommand extends CommandBase {
  /**
   * Creates a new ThrottleShiftingCommand.
   */
  Drivetrain driveTrain;
  Pneumatics pneumatics;
  double forward;
  double turn;
  public ThrottleShiftingCommand(Drivetrain d, Pneumatics p, double f, double t){
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = d;
    pneumatics = p;
    forward = f;
    turn = t;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public double throttleCheck(){
    return Math.abs(forward*100);
  }

  public void throttleShift(){
    double encoder1Rate, encoder2Rate;
    if(throttleCheck() >= Constants.thresholdPercentLowGearFPS && !pneumatics.getShiftState()){

      pneumatics.shiftDrive(true);


    }
  }
}
