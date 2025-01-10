import SwiftUI
import Common

@main
struct iOSApp: App {
    
    init(){
        KoinKt.doInitKoinIos()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
