/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ClimberWinchCommand extends CommandBase {
  /**
   * Creates a new ClimberWinchCommand.
   */
  Climber climber;
  boolean climberToggle;
  double ultraSonicDistance;
  double climberHeight = (climber.getUltraSonic1Voltage()*0.997)/25.4;
  public ClimberWinchCommand(Climber c) {
    // Use addRequirements() here to declare subsystem dependencies.
    climber = c;   
    
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climber.winchDrive(true);
    climberWinchToggle(climberHeight);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climber.winchDrive(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return climberToggle;
  }

  public boolean climberWinchToggle(double distance){
    if(distance >= 20){
      climberToggle = true;
      return climberToggle; 
    }
    else{
      climberToggle = false;
      return climberToggle;
    }
  }
}
