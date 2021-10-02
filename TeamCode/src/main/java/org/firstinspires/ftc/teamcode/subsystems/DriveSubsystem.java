package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem extends SubsystemBase {

    private final MotorEx backLeft;
    private final MotorEx backRight;
    private final MotorEx frontLeft;
    private final MotorEx frontRight;

    /*
    public DriveSubsystem(final HardwareMap hMap) {
        backLeft = hMap.get(DcMotor.class, "backLeft");
        backRight = hMap.get(DcMotor.class, "backRight");
        frontLeft = hMap.get(DcMotor.class, "frontLeft");
        frontRight = hMap.get(DcMotor.class, "frontRight");
    }
*/
    public DriveSubsystem(HardwareMap hMap, final String bL, String bR, String fL, String fR) {
        backLeft = new MotorEx(hMap, bL);
        backRight = new MotorEx(hMap, bR);
        frontLeft = new MotorEx(hMap, fL);
        frontRight = new MotorEx(hMap, fR);
    }

    public void drive(double y, double x, double rx) {
        double frontLeftPower = y + x + rx;
        double backLeftPower = y - x + rx;
        double frontRightPower = y - x - rx;
        double backRightPower = y + x - rx;

        if (Math.abs(frontLeftPower) > 1 || Math.abs(backLeftPower) > 1 ||
                Math.abs(frontRightPower) > 1 || Math.abs(backRightPower) > 1) {
            // Find the largest power
            double max = 0;
            max = Math.max(Math.abs(frontLeftPower), Math.abs(backLeftPower));
            max = Math.max(Math.abs(frontRightPower), max);
            max = Math.max(Math.abs(backRightPower), max);

            // Divide everything by max (it's positive so we don't need to worry
            // about signs)
            frontLeftPower /= max;
            backLeftPower /= max;
            frontRightPower /= max;
            backRightPower /= max;


        }
        frontLeft.setVelocity(frontLeftPower);
        backLeft.setVelocity(backLeftPower);
        frontRight.setVelocity(frontRightPower);
        backRight.setVelocity(backRightPower);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}