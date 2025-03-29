//
//  RemoteConfigBridgeIos.swift
//  iosApp
//
//  Created by Fernando Menezes on 22/03/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import FirebaseRemoteConfig
import shared

@objc(RemoteConfigBridgeIos)
class RemoteConfigBridgeIos: NSObject {
    
    @objc public static func configureRemoteConfigService() {
        RemoteConfigServiceProvider.shared.remoteConfigService = IosRemoteConfigService { key, completion in
            let remoteConfig = RemoteConfig.remoteConfig()
            let settings = RemoteConfigSettings()
                settings.minimumFetchInterval = 0
                settings.fetchTimeout = 10
            remoteConfig.configSettings = settings
            remoteConfig.fetchAndActivate { _, error in
                if let error = error {
                    completion("errorGetFile")
                } else {
                    let json = remoteConfig.configValue(forKey: key).stringValue
                    completion(json)
                }
            }
        }
    }
    
}
