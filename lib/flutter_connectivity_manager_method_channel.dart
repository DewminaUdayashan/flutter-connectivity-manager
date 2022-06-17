import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'flutter_connectivity_manager_platform_interface.dart';

/// An implementation of [FlutterConnectivityManagerPlatform] that uses method channels.
class MethodChannelFlutterConnectivityManager extends FlutterConnectivityManagerPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('flutter_connectivity_manager');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }


  @override
  Future<void> initialize()async{
    await methodChannel.invokeMethod('initialize');
  }

}
