// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;


public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  TalonSRX mytalon = new TalonSRX(Constants.INTAKE_ID);

  boolean fModeIsCalled = false;
  boolean bModeIsCalled = false;
  

  private DoubleSolenoid IntakePiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1); //Creates double soleniod
  private Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM); //Air compressor

  public void extendPiston() {
    IntakePiston.set(Constants.INTAKE_PISTON_OPEN);
    fModeIsCalled = true;
  }

  public void retractPiston() {
    IntakePiston.set(Constants.INTAKE_PISTON_CLOSED);
    bModeIsCalled = true;
  }

    //First function called in commands
  public void enableCompressor() {
    compressor.enableDigital();
  }

  //Second function called in commands
  public void intakeBall() {
    mytalon.set(ControlMode.PercentOutput, 0.75);
    extendPiston();
  }
  //Third function called in commands
  public void retractIntake() {
    mytalon.set(ControlMode.PercentOutput, -0.75);
    retractPiston();
  }

  public void Outtake(){
    mytalon.set(ControlMode.PercentOutput, 0.75);
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