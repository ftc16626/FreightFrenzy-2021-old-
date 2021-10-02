package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {


    private final DriveSubsystem driveSubsystem;
    private final double y, x, rx;

    public DriveCommand(DriveSubsystem subsystem, double y, double x, double rx) {
        driveSubsystem = subsystem;
        this.y = y;
        this.x = x;
        this.rx = rx;
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        driveSubsystem.drive(y, x, rx);
    }


}
