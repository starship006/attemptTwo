/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;



import frc.robot.RobotMap;
import frc.robot.commands.DriveForward;


/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  TalonSRX leftFrontTalon = null;
  TalonSRX rightFrontTalon = null;
  VictorSPX leftBackVictor = null;
  VictorSPX rightBackVictor = null;
  DifferentialDrive differentialDrive = null;

  public DriveTrain() {
    leftFrontTalon = new TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
    rightFrontTalon = new TalonSRX(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
    leftBackVictor = new VictorSPX(RobotMap.DRIVETRAIN_LEFT_BACK_VICTOR);
    rightBackVictor = new VictorSPX(RobotMap.DRIVETRAIN_RIGHT_BACK_VICTOR);
    
    leftBackVictor.set(ControlMode.Follower, leftFrontTalon.getDeviceID()); //setting leftBackVictor to follow leftFrontTalon
    rightBackVictor.set(ControlMode.Follower, rightFrontTalon.getDeviceID()); //setting rightBackVictor to follow rightFrontTalon

    


  }
  public void moveForward(double moveSpeed) {
    leftFrontTalon.set(ControlMode.PercentOutput,moveSpeed);
    rightFrontTalon.set(ControlMode.PercentOutput, moveSpeed);


  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveForward());
  }


}
