package net.mbiz.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

/**
 * Navigation
 */
public class MainActivity extends AppCompatActivity {

    private  AppBarConfiguration appBarConfiguration ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("DEV", "onCreate");


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        appBarConfiguration =  new AppBarConfiguration.Builder(navController.getGraph()).build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d("DEV", "onSupportNavigateUp");

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d("DEV", "onBackPressed");

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.navigateUp(navController, appBarConfiguration);
    }
}
