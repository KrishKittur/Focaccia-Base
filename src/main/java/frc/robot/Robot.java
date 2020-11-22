/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
This arcade drive is powered using only the left analog stick 
Movements on the y-axis of the analog stick will move the robot forwards/backwards
Movements on the x-axis of the analog stick will turn the robot 
 */
public class Robot extends TimedRobot {

  /* Initialize the motors and differential drive */
  WPI_TalonSRX motorRight = new WPI_TalonSRX(1);
  WPI_TalonSRX motorLeft = new WPI_TalonSRX(4);
  DifferentialDrive motorDrive = new DifferentialDrive(motorLeft, motorRight);

  /* Initalize the Xbox controller */
  XboxController controller = new XboxController(1);

  /* In the robot init function, set the motors equal to 0 just to "reset" the robot */
  @Override
  public void teleopInit() {
    motorRight.set(0);
    motorLeft.set(0);
  }

  /* In the teleopPeriodic loop get controller inputs and input them into the arcade drive function */
  @Override
  public void teleopPeriodic() {
    motorDrive.arcadeDrive(controller.getY(Hand.kLeft), controller.getX(Hand.kLeft));
  }
}
