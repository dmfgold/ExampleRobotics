// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// im the og chad broski not jordan yes david - yes

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/* 
 mainMotor // main motor (clockwise)
 ccwMotor // counter-clock wise motor
 cwMotor // clock wise motor
*/

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import stuff, inclduing TalonFx
import frc.robot.Constants;

// add values 
// - motor.set...  (speed),(jotstick,values), getcoder[current position] 
// e.g: given the start and end position how can you make it always go to one point and stay at one point?
// You can make the speed decrease while applying the fact the distance from the start and end is also decreasing
 //Creates a new ExampleSubsystem.//
public class ShooterSubsystem extends SubsystemBase {

  private final TalonSRX shooterMotor1 = new TalonSRX(Constants.SHOOTER_ID_1);
  private final TalonSRX shooterMotor2 = new TalonSRX(Constants.SHOOTER_ID_2);
  private double speed = 0;
  
  public ShooterSubsystem() {
    shooterMotor2.follow(shooterMotor1);
  }

  // public void getShooterSpeed(currentShooterSpeed, double speed) {
  //   int currentSpeed = 50;
  //   if (currentShooterSpeed < speed) {
  //     float differentialSpeed = (speed - currentShooterSpeed)/100;
  //     //make difference a percentage
  //     //increase current speed by difference
  //     shooterMotor1.set(ControlMode.PercentOutput, differentialSpeed)
  //     shooterMotor2.set(ControlMode.PercentOutput, differentialSpeed)
  //   }
  // }

  public void shoot(double speed) {

    this.speed = speed;

    shooterMotor1.set(ControlMode.PercentOutput, speed);

  }
  
   public void stop(){
      //set motor to 0
      shooterMotor1.set(ControlMode.PercentOutput, 0.0);
      speed = 0;
       
   }

  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}

//Elizabeth and Jordan