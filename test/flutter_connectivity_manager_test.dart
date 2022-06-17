import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_connectivity_manager/flutter_connectivity_manager.dart';
import 'package:flutter_connectivity_manager/flutter_connectivity_manager_platform_interface.dart';
import 'package:flutter_connectivity_manager/flutter_connectivity_manager_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockFlutterConnectivityManagerPlatform 
    with MockPlatformInterfaceMixin
    implements FlutterConnectivityManagerPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final FlutterConnectivityManagerPlatform initialPlatform = FlutterConnectivityManagerPlatform.instance;

  test('$MethodChannelFlutterConnectivityManager is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelFlutterConnectivityManager>());
  });

  test('getPlatformVersion', () async {
    FlutterConnectivityManager flutterConnectivityManagerPlugin = FlutterConnectivityManager();
    MockFlutterConnectivityManagerPlatform fakePlatform = MockFlutterConnectivityManagerPlatform();
    FlutterConnectivityManagerPlatform.instance = fakePlatform;
  
    expect(await flutterConnectivityManagerPlugin.getPlatformVersion(), '42');
  });
}
