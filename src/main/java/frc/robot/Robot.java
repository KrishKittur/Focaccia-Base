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
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  /* Initialize the motors */
  WPI_TalonSRX motorRight = new WPI_TalonSRX(1);
  WPI_TalonSRX motorLeft = new WPI_TalonSRX(4);

  /* Initalize the Xbox controller */
  XboxController controller = new XboxController(1);

  @Override
  public void teleopInit() {
    motorRight.set(0);
    motorLeft.set(0);
  }



  @Override
  public void teleopPeriodic() {
    if (controller.getAButton()) {
      motorLeft.set(1);
      motorRight.set(1);
    } else if (controller.getBButton()) {
      motorLeft.set(-1);
      motorRight.set(-2);
    } else {
      motorLeft.set(0);
      motorRight.set(0);
    }
  }

}
