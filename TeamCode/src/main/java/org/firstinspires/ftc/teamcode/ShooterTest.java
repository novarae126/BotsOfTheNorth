package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ShooterTest {
        OpMode opmode;
        Telemetry telemetry;
    HardwareMap hardwareMap;

    double velocity;
    boolean last = false;
    private DcMotorEx shooter;

    public void init(OpMode opMode){
        opmode = opMode;
        telemetry=opmode.telemetry;
        hardwareMap = opmode . hardwareMap;
        shooter = hardwareMap . get(DcMotorEx.class,"shooter");

    }
    public void shoot(boolean up, boolean down){
        if (up && !last){
            velocity += 10;
            last = true;
        }
        if (down&& !last) {
            velocity -= 10;
            last = true;
        } else {last = false;}
        shooter.setPower(velocity);
    }
}
