//
//  Tutorial.swift
//  iosApp
//
//  Created by Anh Trần Sĩ Nguyên on 03/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct TutorialPageWelcome: View {
    @Binding var selectedTab: Int
    var body: some View {
        ZStack {
            Color.init(hex: 0xFFe5e5e5)
                .ignoresSafeArea()
        VStack() {
            Text("Dokape")
                .font(DokapeFonts.getLemonadaFont(DokapeFonts.LemonadaBold, 48))
                .foregroundColor(.blue)
                .padding(.top, 64)
            Text("Pets Adoption")
                .font(DokapeFonts.getLemonadaFont(DokapeFonts.LemonadaLight, 24))
            Spacer()
            ZStack {
                Image("paw-tutorial")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .padding(.horizontal, 8)
                Image("f-cat")
                    .resizable()
                    .frame(width: 183, height: 272, alignment: .center)
                    .padding(.horizontal, 8)
            }
            Spacer()
            PrimaryButton {
                self.selectedTab += 1
            }
        }
    }
}
