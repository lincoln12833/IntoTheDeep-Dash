package org.firstinspires.ftc.teamcode.MM;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.message.redux.ReceiveGamepadState;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class MM_OpMode extends LinearOpMode {
    MM_Robot robot = null;

    public static Gamepad currentGamepad1 = new Gamepad();
    public static Gamepad previousGamepad1 = new Gamepad();

    MultipleTelemetry multipleTelemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());


    @Override
    public void runOpMode(){
        initMM();

        waitForStart(); //TODO init options

        runProcedures();
    }

    public void runProcedures(){}

    public void initMM(){
        robot = new MM_Robot(this);
        robot.init();
    }
}
