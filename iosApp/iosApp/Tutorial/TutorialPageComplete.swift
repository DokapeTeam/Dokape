//
//  TutorialPageComplete.swift
//  iosApp
//
//  Created by Anh Trần Sĩ Nguyên on 04/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct TutorialPageComplete: View {
    var body: some View {
        ZStack {
            Color.init(hex: 0xFFe5e5e5)
                .ignoresSafeArea()
            VStack() {
                Text("Dokape")
                    .font(DokapeFonts.getLemonadaFont(DokapeFonts.LemonadaBold, 48))
                    .foregroundColor(.blue)
                    .padding(.top, 64)
                Spacer()
                Image("clouds-tutorial")
                Spacer()
            }
        }
    }
}

struct TutorialPageComplete_Previews: PreviewProvider {
    static var previews: some View {
        TutorialPageComplete()
    }
}
