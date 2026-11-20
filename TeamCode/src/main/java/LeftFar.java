import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.OwenMadeAuton;

@Autonomous
public class LeftFar extends LinearOpMode {

    private OwenMadeAuton auton = new OwenMadeAuton();

    @Override
    public void runOpMode() throws InterruptedException {
        IMU imu = hardwareMap.get(IMU.class, "imu");

        auton.init(this);
        waitForStart();
        auton.Shoot();
        auton.backward(2, 0.5);
        Thread.sleep(12000);
        auton.transfer();
        auton.intake();
        Thread.sleep(10000);
        auton.backward(4, 1);
        auton.left(72, 1);

        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();


        while (opModeIsActive()) {
            orientation = imu.getRobotYawPitchRollAngles();
            telemetry.addData("orientation", orientation);
            telemetry.update();
            Thread.sleep(10);
        }
    }

}
