//
//  MainScreen.swift
//  iosApp
//
//  Created by amikhaylishin on 13.04.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct MainView: View {
    var body: some View {
        TabView{
            HomeScreen()
                .tabItem{
                    Label("Home", systemImage: "house")
                }
            SearchScreen()
                .tabItem{
                    Label("Search", systemImage: "magnifyingglass")
                }
            EventsScreen()
                .tabItem{
                    Label("Events", systemImage: "calendar.badge.clock")
                }
            VideosScreen()
                .tabItem{
                    Label("Videos", systemImage: "video")
                }
        }
    }
}

#Preview {
    MainView()
}
