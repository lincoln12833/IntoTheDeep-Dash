package org.firstinspires.ftc.teamcode.MM;

import static org.firstinspires.ftc.teamcode.MM.MM_OpMode.currentGamepad1;
import static org.firstinspires.ftc.teamcode.MM.MM_OpMode.previousGamepad1;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Config
public class MM_Drivetrain {
    private final MM_OpMode opMode;

    public static double MAX_POWER = 1;
    public static double SLOW_POWER = .5;

    private DcMotorEx flMotor;
    private DcMotorEx frMotor;
    private DcMotorEx blMotor;
    private DcMotorEx brMotor;

    private double flPower;
    private double frPower;
    private double blPower;
    private double brPower;

    private double drivePower;
    private double strafePower;
    private double rotatePower;

    private boolean slow = false;

    MM_Drivetrain(MM_OpMode opMode){
        this.opMode = opMode;
        init();
    }

    public void driveWithSticks(){
        drivePower = -opMode.gamepad1.left_stick_y;
        strafePower = opMode.gamepad1.left_stick_x;
        rotatePower = opMode.gamepad1.right_stick_x;

        flPower = drivePower + strafePower + rotatePower;
        frPower = drivePower - strafePower - rotatePower;
        blPower = drivePower - strafePower + rotatePower;
        brPower = drivePower + strafePower - rotatePower;

        normalize();

        flMotor.setPower(flPower);
        frMotor.setPower(frPower);
        blMotor.setPower(blPower);
        brMotor.setPower(brPower);
    }

    private void normalize(){
        double maxPower = Math.max(flPower, Math.max(frPower, Math.max(blPower, brPower)));

        slow = !previousGamepad1.a && currentGamepad1.a? !slow : slow; //DO NOT CHANGE, ANDROID IS WRONG

        if (maxPower > MAX_POWER){
            flPower /= maxPower;
            frPower /= maxPower;
            blPower /= maxPower;
            brPower /= maxPower;
        }

        if (slow){
            flPower *= SLOW_POWER;
            frPower *= SLOW_POWER;
            blPower *= SLOW_POWER;
            brPower *= SLOW_POWER;
        }
    }

    private void init(){
        flMotor = opMode.hardwareMap.get(DcMotorEx.class, "flMotor");
        frMotor = opMode.hardwareMap.get(DcMotorEx.class, "frMotor");
        blMotor = opMode.hardwareMap.get(DcMotorEx.class, "blMotor");
        brMotor = opMode.hardwareMap.get(DcMotorEx.class, "brMotor");

        flMotor.setDirection(DcMotorEx.Direction.REVERSE);
        blMotor.setDirection(DcMotorEx.Direction.REVERSE);

    }
}
