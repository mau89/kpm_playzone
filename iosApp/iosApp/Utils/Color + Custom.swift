//
//  Color + Custom.swift
//  iosApp
//
//  Created by amikhaylishin on 13.04.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

extension Color {
    static let backgroundPrimaryColor = Color("backgroundPrimaryColor")
    static let actionTextColor = Color("actionTextColor")
    static let primaryTextColor = Color("primaryTextColor")
    static let secondaryBackgroundColor = Color("secondaryBackgroundColor")
    static let secondaryTextColor = Color("secondaryTextColor")
    static let tintColor = Color("tintColor")
    
    init(hex: UInt, alpha: Double = 1) {
        self.init(
            .sRGB,
            red: Double((hex >> 16) & 0xff) / 255,
            green: Double((hex >> 08) & 0xff) / 255,
            blue: Double((hex >> 00) & 0xff) / 255,
            opacity: alpha
        )
    }
}
