/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends CommandBase {
  /**
   * Creates a new IntakeCommand.
   */

   boolean up, down, intakeBall;
   Intake intake;

  public IntakeCommand(boolean u, boolean d, boolean iB, Intake i) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(i);
    intake = i;
    up = u;
    down = d;
    intakeBall = iB;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.IntakeDrive(intakeBall);
    intake.IntakePivotUp(up);
    intake.IntakePivotDown(down);
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
}
