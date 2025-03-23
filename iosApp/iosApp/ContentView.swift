import UIKit
import SwiftUI
import shared
import FirebaseCore


struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
       return MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    
    init() {
        print("inicializando o compose")
        RemoteConfigBridgeIos.configureRemoteConfigService()
        FirebaseApp.configure()
       }
    
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}
