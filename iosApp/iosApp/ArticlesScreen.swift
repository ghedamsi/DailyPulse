//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by Mac on 17/09/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

extension ArticlesScreen{
    @MainActor
    class ArticlesViewModelWrapper:ObservableObject{
        let articlesViewModel:ArticlesViewModel
        @Published var articleState : ArticlesStates
        init() {
            articlesViewModel = ArticlesViewModel()
            articleState=articlesViewModel.articleState.value
        }
        func startObserving(){
            Task{
                for await articlesS in articlesViewModel.articleState{
                    self.articleState=articlesS
                }
            }
        }
         
    }
}
struct ArticlesScreen: View {
    @ObservedObject private(set) var viewModel:ArticlesViewModelWrapper
    var body: some View {
        VStack{
            Appbar()
            if(viewModel.articleState.loading){
                Loader()
            }
            if let error = viewModel.articleState.error {
                ErrorMessage(message:error)
            }
            if(!viewModel.articleState.articles.isEmpty){
                ScrollView {
                    LazyVStack(spacing: 10) {
                    ForEach(viewModel.articleState.articles, id: \.self) {article in
                                                                            
                    ArticleltenView(article: article)
                                                                            }
                                                                            
                                                                            }
                }
            }
                                                                            
            
        }.onAppear{
            self.viewModel.startObserving()
        }
    }
}
struct Appbar:View {
    var body: some View {
        Text("Articles")
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}

struct ArticleltenView: View {
var article: Article
var body: some View {
    VStack(alignment: .leading, spacing: 8) {
        AsyncImage (url: URL(string: article.imageUrl)) { phase in
            if phase.image != nil {
                phase.image!
                    .resizable()
                    .aspectRatio (contentMode: .fit)
            }
            else if phase.error != nil {
                Text ("Image Load Error")
            }
            else{
                ProgressView()
            }
        }
        
        Text(article.title).font(.title).fontWeight(.bold)
        Text(article.desc)
        Text(article.date).frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
    }.padding(16)
}
}
struct Loader:View {
    var body: some View {
        ProgressView()
    }
}
struct ErrorMessage:View {
    var message:String
    
    var body: some View {
        Text(message).font(/*@START_MENU_TOKEN@*/.title/*@END_MENU_TOKEN@*/)
    }
}
#Preview {
    ArticlesScreen(viewModel: .init())
}
