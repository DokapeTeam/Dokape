//
//  PrimaryOutlineButton.swift
//  iosApp
//
//  Created by Anh Trần Sĩ Nguyên on 04/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct PrimaryOutlineButton: View {
    var action: (() -> Void)
    var body: some View {
        Button {
            action()
        } label: {
            ZStack {
                Text("Skip")
                    .font(DokapeFonts.getLemonadaFont(DokapeFonts.LemonadaRegular, 18))
            }
            .frame(maxWidth: .infinity, maxHeight: 48)
            .foregroundColor(.blue)
            .background(Color.white)
            .cornerRadius(16)
            .overlay(
                RoundedRectangle(cornerRadius: 16)
                    .stroke(Color.blue, lineWidth: 1)
            )
            .padding(.horizontal, 16)
        }
    }
}

struct PrimaryOutlineButton_Previews: PreviewProvider {
    static var previews: some View {
        PrimaryOutlineButton {}
    }
}
