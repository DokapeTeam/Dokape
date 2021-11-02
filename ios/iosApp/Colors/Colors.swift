//
//  Colors.swift
//  iosApp
//
//  Created by Anh Trần Sĩ Nguyên on 23/09/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct Colors {
    static let primaryColor = Color(hex: 0xFFFCE4EC)
}

extension Color {
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
