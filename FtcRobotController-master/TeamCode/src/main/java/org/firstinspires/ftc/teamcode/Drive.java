package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

public class Drive {

    DcMotor frontLeft, frontRight, rearLeft, rearRight;

    double drive, turn, strafe, frontLeftPower, frontRightPower, rearLeftPower, rearRightPower;

    double power = 1;

    public Drive(DcMotor frontLeft, DcMotor frontRight, DcMotor rearLeft, DcMotor rearRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.rearLeft = rearLeft;
        this.rearRight = rearRight;
        //TODO: Reverse the directions of the motors as required (Lollback)
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }


    public void driver(Gamepad gamepad1) {
        drive = gamepad1.left_stick_y * -1;
        turn = gamepad1.right_stick_x;
        strafe = gamepad1.left_stick_x * -1.1; // TODO: This coefficient will likely need to be tuned to fix imperfect strafing.

        frontLeftPower = Range.clip(drive + turn + strafe, -1, 1);
        rearLeftPower = Range.clip(drive + turn - strafe, -1, 1);
        frontRightPower = Range.clip(drive - turn - strafe, -1, 1);
        rearRightPower = Range.clip(drive - turn + strafe, -1, 1);

        frontLeft.setPower(frontLeftPower);
        rearLeft.setPower(rearLeftPower);
        frontRight.setPower(frontRightPower);
        rearRight.setPower(rearRightPower);


    }
    public void slowDriver(Gamepad gamepad2) {
        drive = gamepad2.left_stick_y * -1;
        turn = gamepad2.right_stick_x;
        strafe = gamepad2.left_stick_x * -1.1; // TODO: This coefficient will likely need to be tuned to fix imperfect strafing.

        frontLeftPower = Range.clip(drive + turn + strafe, -0.5, 0.5);
        rearLeftPower = Range.clip(drive + turn - strafe, -0.5, 0.5);
        frontRightPower = Range.clip(drive - turn - strafe, -0.5, 0.5);
        rearRightPower = Range.clip(drive - turn + strafe, -0.5, 0.5);

        frontLeft.setPower(frontLeftPower);
        rearLeft.setPower(rearLeftPower);
        frontRight.setPower(frontRightPower);
        rearRight.setPower(rearRightPower);


    }

    public void driveForward() {
        frontRight.setPower(power);
        frontLeft.setPower(power);
        rearRight.setPower(power);
        rearLeft.setPower(power);
    }

    public void driveBack() {
        frontRight.setPower(-power);
        frontLeft.setPower(-power);
        rearRight.setPower(-power);
        rearLeft.setPower(-power);
    }

    public void stop() {
        frontRight.setPower(0);
        frontLeft.setPower(0);
        rearRight.setPower(0);
        rearLeft.setPower(0);
    }
}
