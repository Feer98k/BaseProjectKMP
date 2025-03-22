//
//  RemoteConfigBridgeIos.swift
//  iosApp
//
//  Created by Fernando Menezes on 22/03/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import FirebaseRemoteConfig

@objc(RemoteConfigBridgeIos)
class RemoteConfigBridgeIos: NSObject {

    @objc func fetchRemoteConfigJsonWithKey(
        _ key: String,
        completion: @escaping (String?, NSError?) -> Void
    ) {
        let remoteConfig = RemoteConfig.remoteConfig()
        remoteConfig.fetchAndActivate { _, error in
            if let error = error {
                completion(nil, error as NSError)
            } else {
                let jsonValue = remoteConfig.configValue(forKey: key).stringValue
                completion(jsonValue, nil)
            }
        }
    }
}
