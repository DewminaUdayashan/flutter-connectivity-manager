package lk.dewapps.flutter_connectivity_manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;

public class ConnectivityManagerHelper {
    @RequiresApi(api = Build.VERSION_CODES.M)
    public ConnectivityManagerHelper(Context context){
        this.context = context;
        this.connectivityManager = context.getSystemService(ConnectivityManager.class);
    }
    private final Context context;
    ConnectivityManager connectivityManager;



}
