package org.timecrafters.engine;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by t420 on 9/29/2016.
 */


public abstract class State extends RobotPrefs implements Runnable  {

    public DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:ms");
    public Date date = new Date();
    public volatile boolean isFinished = false;
    public byte layer = 0;
    public static String TAG = "PROGRAM.STATE";
    public OpMode opMode;



    public abstract void init();

    public abstract void exec();

    @Override
    public void run(){
        while(!isFinished){
            exec();
        }
    }



    public void setFinished(boolean value){
        isFinished = value;
    }
}