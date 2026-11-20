package org.firstinspires.ftc.teamcode;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagClusterDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

public class Aiming {
    OpMode opmode;
    Telemetry telemetry;
    private double bearing;
    boolean detected = false;

    private AprilTagProcessor aprilTag;

    private List<AprilTagDetection> currentDetections = List.of();
    private final org.firstinspires.ftc.robotcore.external.navigation.Position cameraPosition = new Position(DistanceUnit.INCH,
            0, 0, 0, 0);
    private final YawPitchRollAngles cameraOrientation = new YawPitchRollAngles(AngleUnit.DEGREES,
            0, 0, 0, 0);
    private VisionPortal visionPortal;
    HardwareMap hardwareMap;
    public void init(OpMode opMode){
        opmode=opMode;
        telemetry=opmode.telemetry;
        hardwareMap=opmode.hardwareMap;
        aprilTag = new AprilTagProcessor.Builder()
                .setCameraPose(cameraPosition, cameraOrientation)
                .build();

        aprilTag.setDecimation(2);

        visionPortal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .addProcessor(aprilTag)
                //Set lower camera resolution for faster build
                .setCameraResolution(new Size(640,480))
                .build();
    }
    public AprilTags getTag(boolean blue, boolean left){
        if (blue && left){
            return AprilTags.BLUELEFT;
        }else if(blue && !left){
            return AprilTags.BLUERIGHT;
        }else if(!blue && left){
            return AprilTags.REDLEFT;
        }else{
            return AprilTags.REDRIGHT;
        }
    }
    public double getBearing(){
        for(AprilTagDetection detection : currentDetections){
            if (detection.getClass() == AprilTagClusterDetection.class){
                AprilTagClusterDetection cluster = (AprilTagClusterDetection) detection;
                telemetry.addData("detection: ", cluster.metadata.name);
                telemetry.addData("bearing: ", detection.ftcPose.bearing);
//                String searchString = blue ? "BLUE": "RED";
//                if (cluster.metadata.name.contains(searchString)) {
//                    detected = true;
//                }
            }

        }
        return bearing;
    }
}
