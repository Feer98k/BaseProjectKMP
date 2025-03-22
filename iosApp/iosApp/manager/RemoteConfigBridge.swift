//
//  RemoteConfigBridge.swift
//  iosApp
//
//  Created by Fernando Menezes on 22/03/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import FirebaseRemoteConfig
import shared

// Aqui criamos e fornecemos a implementação Kotlin esperada (via injeção)
class RemoteConfigBridgeIos {
    
    static func configureRemoteConfigService() {
        RemoteConfigServiceProvider.shared.remoteConfigService = IosRemoteConfigService { key, completion in
            let remoteConfig = RemoteConfig.remoteConfig()
            remoteConfig.fetchAndActivate { _, error in
                if let error = error {
                    completion(nil)
                    print("RemoteConfig error: \(error.localizedDescription)")
                } else {
                    let json = remoteConfig.configValue(forKey: key).stringValue
                    completion(json)
                    print(json)
                }
            }
        }
    }
}
