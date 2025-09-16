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

struct AboutListView: View {
    private struct RowItems:Hashable{
        let title:String
        let subTitle:String
    }

    private let items: [RowItems] = {
        let platfrom = Platform()
        platfrom.logSystem()
        var result: [RowItems] = [
            .init(title: "Operating System", subTitle: "\(platfrom.osName) \(platfrom.osVersion)"),
            .init(title: "Device", subTitle: platfrom.deviseModel),
            .init(title: "Density", subTitle: "\(platfrom.density)x")
        ]
        return result
    }()

    
    var body: some View {
        List{
            ForEach(items,id: \.self){item in
                VStack(alignment:.leading){
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.subTitle)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
            
                }.padding(.vertical,4)
            }
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
                .font(.footnote)
                .foregroundColor(.primary)
            Text(subTitle)
                .font(.body)
                .foregroundColor(.gray)
            Divider()
        }
        .padding(8)
        .background(Color.white) // Optional: mimic Compose background
    }
}

// Dummy Platform struct to simulate your data source


#Preview {
    AboutListView()
}
