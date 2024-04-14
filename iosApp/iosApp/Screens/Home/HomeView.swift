//
//  HomeView.swift
//  iosApp
//
//  Created by amikhaylishin on 14.04.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct HomeView: View {
    
    let viewState: HomeViewState
    let eventHandler: (HomeEvent) -> Void
    
    var body: some View {
        ZStack {
            VStack {
                Spacer().frame(height: 16)
                
                HStack{
                    Spacer().frame(width: 16)
                    
                    AsyncImage(url: URL(string: viewState.avatarUrl), content: {image in
                        image
                            .resizable()
                            .aspectRatio(contentMode: .fill)
                            .frame(width: 56, height: 56)
                    }, placeholder: {
                        ProgressView()
                    })
                    .clipShape(Circle())
                    .frame(width: 56, height: 56)
                    
                    Spacer().frame(width: 20)
                    
                    VStack(alignment: .leading){
                        Text(viewState.status)
                            .foregroundColor(.primaryTextColor.opacity(0.5))
                            .font(.system(size: 12))
                        
                        Spacer().frame(height: 4)
                        
                        Text(viewState.userName)
                            .foregroundColor(.primaryTextColor)
                            .fontWeight(.bold)
                            .font(.system(size:12))
                    }
                    
                    Spacer()
                }
                .onTapGesture{
                    eventHandler(HomeEvent.UserProfileClicked())
                }
                Spacer()
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.backgroundPrimaryColor)
    }
}

