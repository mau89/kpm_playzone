//
//  SearchScreen.swift
//  iosApp
//
//  Created by amikhaylishin on 13.04.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct SearchScreen: View {
    
    private let viewModel = SearchViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())) { viewState in
            SearchView(viewState: viewState) { event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }
    }
}

#Preview {
    SearchScreen()
}
