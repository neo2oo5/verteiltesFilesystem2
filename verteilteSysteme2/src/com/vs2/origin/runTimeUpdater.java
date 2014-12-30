package com.vs2.origin;


import java.util.Timer;
import java.util.TimerTask;
import com.vs2.network.PostWebservice.PostWallClient;


/**
 * Fuehrt zu festgelegten Zeiten Aktionen aus.
 *
 * @author Kevin Bonner  - kevin.bonner@gmx.de
 */
public class runTimeUpdater
{

    private static Output out = Output.getInstance();

    /**
     *
     */
    public runTimeUpdater()
    {
        Timer timer = new Timer();

        // Start in one second then drain every 30 seconds
        // Update CrudPostList structure
        timer.schedule(new PostSync(), 1000, 30000);


        out.print("runTimeUpdater started");
    }

    class PostSync extends TimerTask
    {

        @Override
        public void run()
        {

            PostWallClient.doSync();
        }
    }

}
