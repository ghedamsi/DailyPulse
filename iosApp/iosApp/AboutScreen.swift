//
//  AboutScreen.swift
//  iosApp
//
//  Created by Mac on 16/09/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
        NavigationStack{
            AboutListView().navigationTitle("About Device")
        }
    }
}

#Preview {
    AboutScreen()
}
