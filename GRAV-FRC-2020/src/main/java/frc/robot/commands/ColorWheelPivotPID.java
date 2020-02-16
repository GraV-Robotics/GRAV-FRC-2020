package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;

public class ColorWheelPivotPID extends CommandBase {
  /**
   * Creates a new ColorWheelPivotPID.
   */
  double setPoint;
  ColorWheel colorwheel;
  int P, I, D = 1;
  int integral, previous_error, setpoint = 0;
  error = setpoint - Encoder.get();
  integral = += (error*.02);
  derivative = (error - this.previous_error) / .02;
 

  public ColorWheelPivotPID(double setPoint, ColorWheel cw) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(cw);

    colorwheel = cw;
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
}
