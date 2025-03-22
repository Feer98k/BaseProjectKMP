//
//  RemoteConfigBridge.swift
//  iosApp
//
//  Created by Fernando Menezes on 22/03/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import FirebaseRemoteConfig
import FirebaseCore
import shared

@objc(RemoteConfigBridge)
public class RemoteConfigBridge: NSObject {
    @objc public static let shared = RemoteConfigBridge()

    private override init() {
        FirebaseApp.configure()
    }

    @objc public func fetchRemoteConfigJson(_ key: String, completion: @escaping (String?, NSError?) -> Void) {
        let remoteConfig = RemoteConfig.remoteConfig()
        remoteConfig.fetchAndActivate { status, error in
            if let error = error {
                completion(nil, error as NSError)
            } else {
                let json = remoteConfig.configValue(forKey: key).stringValue ?? ""
                completion(json, nil)
            }
        }
    }
}
