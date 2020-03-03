/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.BasicArcadeDrive;
import frc.robot.commands.ClimberHookCommand;
import frc.robot.commands.ClimberWinchCommand;
import frc.robot.commands.IntakeCommandGroup;
import frc.robot.commands.ThrottleShiftingCommand;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pneumatics;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public Joystick driverController = new Joystick(0);
  Pneumatics pneumatics = new Pneumatics();
  Drivetrain drivetrain = new Drivetrain();
  Intake intake = new Intake();
  Climber climber = new Climber();
  BasicArcadeDrive basicArcadeDrive = new BasicArcadeDrive(driverController.getRawAxis(1), driverController.getRawAxis(5), drivetrain);
  IntakeCommandGroup intakeCommandGroup = new IntakeCommandGroup(intake);
  ThrottleShiftingCommand throttleShiftingCommand = new ThrottleShiftingCommand(drivetrain, pneumatics, driverController.getRawAxis(1), driverController.getRawAxis(5));
  ClimberHookCommand climberHookCommand = new ClimberHookCommand(climber, driverController.getRawButton(3), driverController.getRawButton(4));
  ClimberWinchCommand climberWinchCommand = new ClimberWinchCommand(climber);
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  // hello
  private void configureButtonBindings() {
  }

}
