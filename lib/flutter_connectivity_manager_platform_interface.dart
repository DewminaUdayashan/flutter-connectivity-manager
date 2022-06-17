import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'flutter_connectivity_manager_method_channel.dart';

abstract class FlutterConnectivityManagerPlatform extends PlatformInterface {
  /// Constructs a FlutterConnectivityManagerPlatform.
  FlutterConnectivityManagerPlatform() : super(token: _token);

  static final Object _token = Object();

  static FlutterConnectivityManagerPlatform _instance = MethodChannelFlutterConnectivityManager();

  /// The default instance of [FlutterConnectivityManagerPlatform] to use.
  ///
  /// Defaults to [MethodChannelFlutterConnectivityManager].
  static FlutterConnectivityManagerPlatform get instance => _instance;
  
  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [FlutterConnectivityManagerPlatform] when
  /// they register themselves.
  static set instance(FlutterConnectivityManagerPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }

  Future<void> initialize()async{
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
