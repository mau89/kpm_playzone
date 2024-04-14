//
//  CommonTextField.swift
//  iosApp
//
//  Created by amikhaylishin on 13.04.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct CommonTextField: View {
    
    
    @State private var value: String = ""
    private let hint: String
    private let enabled: Bool
    private let isSecure: Bool
    private let onValueChanged: (String) -> Void
    
    init(hint: String, enabled: Bool = true, isSecure: Bool = false, onValueChanged: @escaping (String) -> Void) {
        self.hint = hint
        self.enabled = enabled
        self.isSecure = isSecure
        self.onValueChanged = onValueChanged
    }
    
    var body: some View {
        ZStack(alignment: .leading) {
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(.secondaryBackgroundColor)
            
            if(value.isEmpty) {
                Text(hint)
                    .foregroundColor(.primaryTextColor.opacity(0.5))
                    .padding(EdgeInsets(top: 0, leading: 20, bottom: 0, trailing: 20))
                    .font(.system(size: 16))
            }
            
            if(isSecure){
                SecureField ("", text: $value)
                    .foregroundColor(.primaryTextColor)
                    .font(.system(size: 16))
                    .autocapitalization(/*@START_MENU_TOKEN@*/.none/*@END_MENU_TOKEN@*/)
                    .disabled(!enabled)
                    .disableAutocorrection(true)
                    .padding(EdgeInsets(top: 0, leading: 20, bottom: 0, trailing: 20))
                    .onChange(of: value) { newValue in
                        onValueChanged(newValue)
                    }
            } else {
                TextField ("", text: $value)
                    .foregroundColor(.primaryTextColor)
                    .font(.system(size: 16))
                    .autocapitalization(/*@START_MENU_TOKEN@*/.none/*@END_MENU_TOKEN@*/)
                    .disabled(!enabled)
                    .disableAutocorrection(true)
                    .padding(EdgeInsets(top: 0, leading: 20, bottom: 0, trailing: 20))
                    .onChange(of: value) { newValue in
                        onValueChanged(newValue)
                    }
            }
            
            
        }
        .frame(height: 56)
        .padding(EdgeInsets(top: 0, leading: 24, bottom: 0, trailing: 24))
    }
}

#Preview {
    CommonTextField(hint: "String", enabled: true, isSecure: true, onValueChanged:
                        {newValue in
        print(newValue)
    })
}
