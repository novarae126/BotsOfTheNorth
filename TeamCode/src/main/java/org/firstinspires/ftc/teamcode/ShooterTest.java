package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ShooterTest {
        OpMode opmode;
        Telemetry telemetry;
    HardwareMap hardwareMap;

    double velocity;
    boolean last = false;
    private DcMotorEx shooter;
    private CRServo transfer;

    public void init(OpMode opMode){
        opmode = opMode;
        telemetry=opmode.telemetry;
        hardwareMap = opmode . hardwareMap;
        shooter = hardwareMap . get(DcMotorEx.class,"shooter");
        transfer = hardwareMap.get(CRServo.class, "transfer");
        shooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    public void runTransfer(boolean pressed){
        if (pressed) {
            transfer.setPower(1);
        }
        else{
            transfer.setPower(0);
        }
    }

    public void shoot1speed(boolean pressed){
        if (pressed) {
            shooter.setVelocity(1205);
        }
        else{
            shooter.setPower(0);
        }
        telemetry.addData("SHOOT", pressed);
        telemetry.addData("velocity",velocity);
   }
    //public void shoot1speed(boolean up, boolean down){
   //     if (up && !last){
     //       velocity += 10;
       //     last = true;
       // }else if (down&& !last) {
        //    velocity -= 10;
          //  last = true;
        //}else {last = false;}
        //shooter.setVelocity(velocity);
       // telemetry.addData("velocity",velocity);
    //}
}
