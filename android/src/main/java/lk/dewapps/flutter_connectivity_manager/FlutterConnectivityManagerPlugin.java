package lk.dewapps.flutter_connectivity_manager;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** FlutterConnectivityManagerPlugin */
public class FlutterConnectivityManagerPlugin implements FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private static final String TAG = "FlutterConnectivityMana";
  private MethodChannel channel;
  private Context context;
  private ConnectivityManagerHelper connectivityManagerHelper;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flutter_connectivity_manager");
    channel.setMethodCallHandler(this);
    context = flutterPluginBinding.getApplicationContext();
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      connectivityManagerHelper = new ConnectivityManagerHelper(context);
    }
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("initialize")) {
      Log.d(TAG, "onMethodCall: APP RUNNING");
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        connectivityManagerHelper.getNetworkCapabilities();
      }
    }
    else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
