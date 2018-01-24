package harisuman.applicationlifecycle;

import android.app.Application;

/**
 * Created by Vaibhav Upadhyay on 23,January,2018
 * Noida, Uttar Pradesh 201301.
 */

public class ApplicationFile extends Application {

    private ApplicationStatus.Listener mCallbacks;

    @Override
    public void onCreate() {

        ApplicationStatus.get(this).addListener(mCallbacks);
        super.onCreate();
    }
}