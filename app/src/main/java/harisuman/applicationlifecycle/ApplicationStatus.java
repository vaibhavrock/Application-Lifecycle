package harisuman.applicationlifecycle;

/**
 * Created by Vaibhav Upadhyay on 23,January,2018
 * Noida, Uttar Pradesh 201301.
 */

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//reference: https://gist.github.com/steveliles/11116937
public class ApplicationStatus implements Application.ActivityLifecycleCallbacks {

    private static ApplicationStatus instance;
    private List<Listener> listeners = new CopyOnWriteArrayList<Listener>();

    public interface Listener {
        public void onBecameForeground();
        public void onBecameBackground();
    }

    public static ApplicationStatus init(Application application){
        if (instance == null) {
            instance = new ApplicationStatus();
            application.registerActivityLifecycleCallbacks(instance);
        }
        return instance;
    }

    public static ApplicationStatus get(Application application){
        if (instance == null) {
            init(application);
        }
        return instance;
    }

    public void addListener(Listener listener){
        listeners.add(listener);
    }

    public void removeListener(Listener listener){
        listeners.remove(listener);
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Toast.makeText(activity, "Application Resumed", Toast.LENGTH_SHORT).show();
        Log.e("Application:","Application Resumed");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Toast.makeText(activity, "Application Paused", Toast.LENGTH_SHORT).show();
        Log.e("Application:","Application Paused");
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.e("Application:","Application Created");
        Toast.makeText(activity, "Application Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.e("Application:","Application Started");
        Toast.makeText(activity, "Application Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.e("Application:","Application Stopped");
        Toast.makeText(activity, "Application Stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.e("Application:","Application Destroyed");
        Toast.makeText(activity, "Application Destroyed", Toast.LENGTH_SHORT).show();
    }
}
