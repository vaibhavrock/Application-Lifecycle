package harisuman.applicationlifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Toast.makeText(getApplicationContext(), "activity create!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
       // Toast.makeText(getApplicationContext(), "activity start!", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onResume() {
      //  Toast.makeText(getApplicationContext(), "activity resume!", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onPause() {

      //  Toast.makeText(getApplicationContext(), "activity pause!", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onStop() {

       // Toast.makeText(getApplicationContext(), "activity stop!", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
       // Toast.makeText(getApplicationContext(), "activity destroy!", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
