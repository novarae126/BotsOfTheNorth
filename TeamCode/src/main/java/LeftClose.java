import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.OwenMadeAuton;

@Autonomous
public class LeftClose extends LinearOpMode {

    private OwenMadeAuton auton = new OwenMadeAuton();

    @Override
    public void runOpMode() throws InterruptedException {
        IMU imu = hardwareMap.get(IMU.class, "imu");

        auton.init(this);
        waitForStart();
        auton.Shoot();
        Thread.sleep(12000);
        auton.intake();
        auton.transfer();
        Thread.sleep(10000);
        auton.left(48, 0.5);
        auton.backward(8, 0.5);
        auton.right(8, 0.5);

        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();


        while (opModeIsActive()) {
            orientation = imu.getRobotYawPitchRollAngles();
            telemetry.addData("orientation", orientation);
            telemetry.update();
            Thread.sleep(10);
        }
    }

}
