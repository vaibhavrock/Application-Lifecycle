package harisuman.applicationlifecycle;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;

import java.util.List;

/**
 * Created by Vaibhav Upadhyay on 23,January,2018
 * Noida, Uttar Pradesh 201301.
 */

public class Utils {

    /**
     *
     * @param context
     * @return
     *
     *
    //TODO: application life cycle status
    TITLE: Process status
    TITLE: Description
    TITLE: Priority

    VALUE1: Foreground
    VALUE1: An application in which the user is interacting with an activity, or which has an service which is bound to such an activity. Also if a service is executing one of its lifecycle methods or a broadcast receiver which runs its onReceive() method.
    VALUE1: 1

    VALUE2: Visible
    VALUE2: User is not interacting with the activity, but the activity is still (partially) visible or the application has a service which is used by a inactive but visible activity.
    VALUE2: 2

    VALUE3: Service
    VALUE3: Application with a running service which does not qualify for 1 or 2.
    VALUE3: 3

    VALUE4: Background
    VALUE4: Application with only stopped activities and without a service or executing receiver. Android keeps them in a least recent used (LRU) list and if requires terminates the one which was least used.
    VALUE4: 4

    VALUE5: Empty
    VALUE5: Application without any active components.
    VALUE5: 5
     */

    //TODO: use for

    public static boolean isAppIsInBackground(Context context) {
        boolean isInBackground = true;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
                if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    for (String activeProcess : processInfo.pkgList) {
                        if (activeProcess.equals(context.getPackageName())) {
                            isInBackground = false;
                        }
                    }
                }
            }
        } else {
            List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
            ComponentName componentInfo = taskInfo.get(0).topActivity;
            if (componentInfo.getPackageName().equals(context.getPackageName())) {
                isInBackground = false;
            }
        }

        return isInBackground;
    }
}
