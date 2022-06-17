
import 'flutter_connectivity_manager_platform_interface.dart';

class FlutterConnectivityManager {
  Future<String?> getPlatformVersion() {
    return FlutterConnectivityManagerPlatform.instance.getPlatformVersion();
  }
}
