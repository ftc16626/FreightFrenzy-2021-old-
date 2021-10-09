package org.firstinspires.ftc.teamcode.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

import org.firstinspires.ftc.teamcode.subsystems.DriveBase;

@TeleOp(name = "Teleop", group = "Teleop")
@Config

public class MainTeleop extends LinearOpMode {

    private DriveBase driveBase = new DriveBase();


    @Override
    public void runOpMode() {

        //Init phase of opmode before START is pressed
        driveBase.init(hardwareMap);

        waitForStart();


        //Code to run after START is pressed
        while (!isStopRequested()) {
            driveBase.setDrivePower(gamepad1.left_stick_y, -gamepad1.left_stick_x * 1.5, gamepad1.right_stick_x);
        }


    }
}
