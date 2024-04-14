import SwiftUI

struct ContentView: View {
    
	var body: some View {
        LoginScreen()
            .background(Color.backgroundPrimaryColor)
            .background(ignoresSafeAreaEdges: [.top, .bottom])
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
