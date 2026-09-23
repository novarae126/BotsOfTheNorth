package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Marcus_Mecanum_Drive  {
    OpMode opmode;
    Telemetry telemetry;
    HardwareMap hardwaremap;
    private DcMotor frontLeft, frontRight, backLeft, backRight;
    private double x,y,z,max,frontRightCommand,frontLeftCommand, backRightCommand, backLeftCommand;

    public void init(OpMode opMode) {
        opmode = opMode;
        telemetry = opmode . telemetry;
        hardwaremap = opmode . hardwareMap;
        frontRight = hardwaremap.get(DcMotor.class, "frontRight");
        frontLeft = hardwaremap.get(DcMotor.class, "frontLeft");
        backRight = hardwaremap.get(DcMotor.class, "backRight");
        backLeft = hardwaremap.get(DcMotor.class, "backLeft");
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }


    public void loop() {
        x=gamepad1.left_stick_x;
        y=gamepad1.left_stick_y;
        z=gamepad1.right_stick_x;

        frontLeftCommand = y+x+z;
        backLeftCommand = y-x+z;
        frontRightCommand = y-x-z;
        backRightCommand = y+x-z;
    max=Math.max(1,frontRightCommand);
    max=Math.max(max, frontLeftCommand);
    max=Math.max(max,backRightCommand);
    max=Math.max(max,backLeftCommand);

    frontRightCommand = frontRightCommand/max;
    frontLeftCommand = frontLeftCommand/max;
    backRightCommand = backRightCommand/max;
    backLeftCommand = backLeftCommand/max;
    frontRight.setPower(frontRightCommand);
    backRight.setPower(backRightCommand);
    frontLeft.setPower(frontLeftCommand);
    backLeft.setPower(backLeftCommand);
    }
}
