//
//  PrimaryButton.swift
//  iosApp
//
//  Created by Anh Trần Sĩ Nguyên on 04/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct PrimaryButton: View {
    var action: (() -> Void)
    var body: some View {
        Button {
            action()
        } label: {
            ZStack {
                Text("Continue")
                    .font(DokapeFonts.getLemonadaFont(DokapeFonts.LemonadaRegular, 18))
            }
            .frame(maxWidth: .infinity, maxHeight: 48)
            .foregroundColor(.white)
            .background(Color.blue)
            .cornerRadius(16)
            .padding(.horizontal, 16)
        }
    }
}

struct PrimaryButton_Previews: PreviewProvider {
    static var previews: some View {
        PrimaryButton {}
    }
}
