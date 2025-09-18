import SwiftUI

struct ContentView: View {
    @State private var showOpenAbout=false

	var body: some View {
        NavigationStack{
            ArticlesScreen(viewModel: .init())
        .toolbar{
            ToolbarItem{
                Button{
                    showOpenAbout=true
                } label: {
                    Label("About", systemImage: "info.circle")
                        .labelStyle(.titleAndIcon)
                }.popover(isPresented: $showOpenAbout){
                    AboutScreen()
                    
                }
            }
        }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
