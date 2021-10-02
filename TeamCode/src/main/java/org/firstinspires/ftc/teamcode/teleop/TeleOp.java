package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp (name = "Teleop", group = "Teleop")
public class TeleOp extends CommandOpMode {


    private DriveSubsystem driveSubsystem;
    private DriveCommand driveCommand;
    private GamepadEx gamepadOne;

    @Override
    public void initialize() {

        driveSubsystem = new DriveSubsystem(hardwareMap, "backLeft", "backRight", "frontLeft", "frontRight");

        gamepadOne = new GamepadEx(gamepad1);
        driveCommand = new DriveCommand(driveSubsystem, gamepadOne.getLeftY(), gamepadOne.getLeftX(), gamepadOne.getRightX());


        register(driveSubsystem);
        driveSubsystem.setDefaultCommand(driveCommand);
    }

}