package org.firstinspires.ftc.teamcode;

import static com.qualcomm.hardware.rev.RevHubOrientationOnRobot.xyzOrientation;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class OwenMadeAuton {
    LinearOpMode opmode;
    Telemetry telemetry;
    private DcMotor frontRight, frontLeft, backRight, backLeft;
    private double tpi = 162.15 / (Math.PI * 4);
    IMU imu;
    HardwareMap HardwareMap;
    public void init(LinearOpMode opMode){
        opmode = opMode;
        telemetry = opmode.telemetry;
        HardwareMap = opmode.hardwareMap;

        frontRight=HardwareMap.get(DcMotor.class, "frontRight");
        backRight=HardwareMap.get(DcMotor.class, "backRight");
        frontLeft=HardwareMap.get(DcMotor.class,"frontLeft");
        backLeft=HardwareMap.get(DcMotor.class, "backLeft");
        imu = HardwareMap.get(IMU.class, "imu");

        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.RIGHT);
        imu.initialize(new IMU.Parameters(orientationOnRobot));
    }


    public void forward(double distance, double speed){
        int position_fr = frontRight.getCurrentPosition() + (int) (distance * tpi);
        int position_br = backRight.getCurrentPosition() + (int) (distance * tpi);
        int position_fl = frontLeft.getCurrentPosition() + (int) (distance * tpi);
        int position_bl = backLeft.getCurrentPosition() + (int) (distance * tpi);

        frontRight.setTargetPosition(position_fr);
        frontLeft.setTargetPosition(position_fl);
        backLeft.setTargetPosition(position_bl);
        backRight.setTargetPosition(position_br);

        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backRight.setPower((Math.abs(speed)));
        frontLeft.setPower((Math.abs(speed)));
        frontRight.setPower(Math.abs(speed));
        backLeft.setPower(Math.abs(speed));

        while (opmode.opModeIsActive() &&
                (backLeft.isBusy() || backRight.isBusy() || frontRight.isBusy() || frontLeft.isBusy())){
            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("frontLeft:", frontLeft.getCurrentPosition());
            telemetry.addData("frontRight:", frontRight.getCurrentPosition());
            telemetry.update();
        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
    }

    public void backward(double distance, double speed){
        int position_fr = frontRight.getCurrentPosition() - (int) (distance * tpi);
        int position_fl = frontLeft.getCurrentPosition() - (int) (distance * tpi);
        int position_br = backRight.getCurrentPosition() - (int) (distance * tpi);
        int position_bl = backLeft.getCurrentPosition() - (int) (distance * tpi);

        frontRight.setTargetPosition(position_fr);
        frontLeft.setTargetPosition(position_fl);
        backRight.setTargetPosition(position_br);
        backLeft.setTargetPosition(position_bl);

        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backRight.setPower(-(Math.abs(speed)));
        frontLeft.setPower(-(Math.abs(speed)));
        frontRight.setPower(-(Math.abs(speed)));
        backLeft.setPower(-(Math.abs(speed)));

        while (opmode.opModeIsActive() &&
                (backLeft.isBusy() || backRight.isBusy() || frontRight.isBusy() || frontLeft.isBusy())){
            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("frontLeft:", frontLeft.getCurrentPosition());
            telemetry.addData("frontRight:", frontRight.getCurrentPosition());
            telemetry.update();
        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void left(double distance, double speed){
        int position_fr = frontRight.getCurrentPosition() + (int) (distance * tpi);
        int position_fl = frontLeft.getCurrentPosition() - (int) (distance * tpi);
        int position_br = backRight.getCurrentPosition() - (int) (distance * tpi);
        int position_bl = backLeft.getCurrentPosition() + (int) (distance * tpi);

        frontRight.setTargetPosition(position_fr);
        frontLeft.setTargetPosition(position_fl);
        backRight.setTargetPosition(position_br);
        backLeft.setTargetPosition(position_bl);

        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setPower((Math.abs(speed)));
        frontLeft.setPower(-(Math.abs(speed)));
        backRight.setPower(-(Math.abs(speed)));
        backLeft.setPower((Math.abs(speed)));

        while (opmode.opModeIsActive() &&
                (backLeft.isBusy() || backRight.isBusy() || frontRight.isBusy() || frontLeft.isBusy())){
            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("frontLeft:", frontLeft.getCurrentPosition());
            telemetry.addData("frontRight:", frontRight.getCurrentPosition());
            telemetry.update();
        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void right(double distance, double speed){
        int position_fr = frontRight.getCurrentPosition() - (int) (distance * tpi);
        int position_fl = frontLeft.getCurrentPosition() + (int) (distance * tpi);
        int position_br = backRight.getCurrentPosition() + (int) (distance * tpi);
        int position_bl = backLeft.getCurrentPosition() - (int) (distance * tpi);

        frontRight.setTargetPosition(position_fr);
        frontLeft.setTargetPosition(position_fl);
        backRight.setTargetPosition(position_br);
        backLeft.setTargetPosition(position_bl);

        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setPower(-(Math.abs(speed)));
        frontLeft.setPower((Math.abs(speed)));
        backRight.setPower((Math.abs(speed)));
        backLeft.setPower(-(Math.abs(speed)));

        while (opmode.opModeIsActive() &&
                (backLeft.isBusy() || backRight.isBusy() || frontRight.isBusy() || frontLeft.isBusy())){
            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("frontLeft:", frontLeft.getCurrentPosition());
            telemetry.addData("frontRight:", frontRight.getCurrentPosition());
            telemetry.update();
        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void turnRight(double degrees,double speed){

        imu.resetYaw();

        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();

        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while (orientation.getYaw(AngleUnit.DEGREES)  > -degrees){

            telemetry.addData("angle",orientation.getYaw(AngleUnit.DEGREES));
            orientation = imu.getRobotYawPitchRollAngles();

            backRight.setPower(-(Math.abs(speed)));
            frontLeft.setPower((Math.abs(speed)));
            frontRight.setPower(-(Math.abs(speed)));
            backLeft.setPower((Math.abs(speed)));

            telemetry.addData("backRight:",backRight.getCurrentPosition());
            telemetry.addData("backLeft:",backLeft.getCurrentPosition());
            telemetry.addData("frontLeft",frontLeft.getCurrentPosition());
            telemetry.addData("frontright",frontRight.getCurrentPosition());
            telemetry.addData("orientation", orientation);
            telemetry.update();
        }

        backLeft.setPower(0);
        backRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
    }

    public void turnLeft(double degrees,double speed){

        imu.resetYaw();

        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();

        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while (orientation.getYaw(AngleUnit.DEGREES)  < degrees){

            telemetry.addData("angle",orientation.getYaw(AngleUnit.DEGREES));
            orientation = imu.getRobotYawPitchRollAngles();

            backRight.setPower((Math.abs(speed)));
            frontLeft.setPower(-(Math.abs(speed)));
            frontRight.setPower((Math.abs(speed)));
            backLeft.setPower(-(Math.abs(speed)));

            telemetry.addData("backRight:",backRight.getCurrentPosition());
            telemetry.addData("backLeft:",backLeft.getCurrentPosition());
            telemetry.addData("frontLeft",frontLeft.getCurrentPosition());
            telemetry.addData("frontright",frontRight.getCurrentPosition());
            telemetry.addData("orientation", orientation);
            telemetry.update();
        }

        backLeft.setPower(0);
        backRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
    }
}
