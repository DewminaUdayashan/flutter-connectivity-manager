package lk.dewapps.flutter_connectivity_manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.HashMap;

public class ConnectivityManagerHelper {
    private static final String TAG = "APP RUNNING :";
    @RequiresApi(api = Build.VERSION_CODES.M)
    public ConnectivityManagerHelper(Context context){
        this.context = context;
        this.connectivityManager = context.getSystemService(ConnectivityManager.class);
    }
    private final Context context;
    ConnectivityManager connectivityManager;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public Network getActiveNetwork(){
        Network currentNetwork = connectivityManager.getActiveNetwork();
        Log.d(TAG,currentNetwork.toString());
        return currentNetwork;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void getNetworkCapabilities(){
        NetworkCapabilities caps = connectivityManager.getNetworkCapabilities(getActiveNetwork());
        Log.d(TAG, "getNetworkCapabilities: "+caps);
        
    }

}
