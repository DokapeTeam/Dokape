//
//  DokapeFonts.swift
//  iosApp
//
//  Created by Anh Trần Sĩ Nguyên on 03/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct DokapeFonts {
    static let LemonadaRegular = "Lemonada-Regular"
    static let LemonadaLight = "Lemonada-Light"
    static let LemonadaSemiBold = "Lemonada-SemiBold"
    static let LemonadaMedium = "Lemonada-Medium"
    static let LemonadaBold = "Lemonada-Bold"
    
    static func getLemonadaFont(_ font: String, _ fontSize: CGFloat) -> Font {
        return Font.custom(font, size: fontSize)
    }
}
