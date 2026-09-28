package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ShooterTest {
        OpMode opmode;
        Telemetry telemetry;
    HardwareMap hardwareMap;
    private DcMotor shooter;

    public void init(OpMode opMode){
        opmode = opMode;
        telemetry=opmode.telemetry;
        hardwareMap = opmode . hardwareMap;
        shooter = hardwareMap . get(DcMotor.class,"shooter");

    }
    public void shoot(boolean pressed){
        if (pressed){
            shooter.setPower(1);
        }
        else{
            shooter.setPower(0);
        }

    }
}
