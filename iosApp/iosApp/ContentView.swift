import SwiftUI
import shared

struct ContentView: View {

	var body: some View {
        ZStack {
            Color.init(hex: 0xFFE5E5E5)
                .ignoresSafeArea()
            Tutorial()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
