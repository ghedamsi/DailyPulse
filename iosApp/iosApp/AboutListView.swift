//
//  AboutListView.swift
//  iosApp
//
//  Created by Mac on 15/09/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

import SwiftUI

struct AboutScreen: View {
    var body: some View {
        NavigationView {
            VStack {
                ContentViews()
            }
            .navigationTitle("Android Device")
        }
    }
}

struct ContentViews: View {
    let items = makeItems()
    
    var body: some View {
        List {
            ForEach(items, id: \.0) { row in
                RowView(title: row.0, subTitle: row.1)
            }
        }
        .listStyle(.insetGrouped)
    }
}

func makeItems() -> [(String, String)] {
    let platform = Platform()
    return [
        ("Operation System", "\(platform.osName) \(platform.osVersion)"),
        ("Device", "\(platform.deviseModel)"),
        ("Density", "\(platform.density)")
    ]
}

struct RowView: View {
    var title: String
    var subTitle: String
    
    var body: some View {
        VStack(alignment: .leading, spacing: 4) {
            Text(title)
                .font(.subheadline)
                .foregroundColor(.gray)
            Text(subTitle)
                .font(.subheadline)
                .foregroundColor(.gray)
            Divider()
        }
        .padding(8)
        .background(Color.white) // Optional: mimic Compose background
    }
}

// Dummy Platform struct to simulate your data source


struct AboutScreen_Previews: PreviewProvider {
    static var previews: some View {
        AboutScreen()
    }
}
