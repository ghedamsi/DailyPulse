//
//  AboutScreen.swift
//  iosApp
//
//  Created by Mac on 16/09/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct AboutScreen: View {
    @Environment(\.dismiss)
    private var dismiss
    
    var body: some View {
        NavigationStack{
            AboutListView().navigationTitle("About Device")
                .toolbar{
                    ToolbarItem(placement: .primaryAction){
                        Button{
                            dismiss()
                        }label: {
                            Text("Done")
                                .bold()
                        }
                        
                    }
                
            }
        }
    }
}

#Preview {
    AboutScreen()
}
