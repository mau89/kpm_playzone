//
//  ViewModel + View.swift
//  iosApp
//
//  Created by amikhaylishin on 13.04.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Combine

private class ObservableModel<StateObserved>: ObservableObject {
    @Published var stateObserved: StateObserved?
    
    init(statePublisher: AnyPublisher<StateObserved, Never>) {
        statePublisher
            .compactMap{$0}
            .receive(on: DispatchQueue.main)
            .assign(to: &$stateObserved)
    }
}

public struct ObservingView<stateObserved, Content>: View where Content: View {
    @ObservedObject private var model: ObservableModel<stateObserved>
    
    private let content: (stateObserved) -> Content
    
    public init(statePublisher: AnyPublisher<stateObserved, Never>, @ViewBuilder content: @escaping (stateObserved) ->Content) {
        self.model = ObservableModel(statePublisher: statePublisher)
        self.content = content
    }
    
    public var body: some View {
        let view: AnyView
        if let viewState = self.model.stateObserved {
            view = AnyView(content(viewState))
        } else {
            view = AnyView(EmptyView())
        }
        
        return view
    }
}
