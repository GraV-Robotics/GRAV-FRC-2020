package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ColorWheel extends SubsystemBase {
TalonSRX colorWheelMotorPivot;
VictorSPX colorWheelMotorRight;
VictorSPX colorWheelMotorLeft;
Encoder colorWheelEncoder;

  public ColorWheel() {
    colorWheelMotorPivot = new TalonSRX(Constants.colorWheelMotorPivot);
    colorWheelMotorLeft = new VictorSPX(Constants.colorWheelMotorLeft);
    colorWheelMotorRight = new VictorSPX(Constants.colorwheelMotorRight);
    colorWheelEncoder = new Encoder(Constants.colorWheelEncoder[0], Constants.colorWheelEncoder[1], true);
  }

  public void ColorWheelPivot(double speed) {
    colorWheelMotorPivot.set(ControlMode.PercentOutput, speed);
  }

  public void ColorWheelSpin(double speed) {
    colorWheelMotorLeft.set(ControlMode.PercentOutput, speed);
    colorWheelMotorRight.set(ControlMode.PercentOutput, speed);
  }

  public int ColorWheelEncoder() {
    return colorWheelEncoder.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
