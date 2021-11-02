//
//  LoginScreen.swift
//  iosApp
//
//  Created by Anh Trần Sĩ Nguyên on 23/09/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LoginScreen: View {
    let greet = Greeting().greeting()
    var body: some View {
        NavigationView {
            ZStack {
                Colors.primaryColor
                    .ignoresSafeArea()
                VStack {
                    Spacer()
                }
                .navigationTitle("Login")
                ScrollView {
                    
                }
            }
        }
    }
}

fileprivate struct LoginToolbar : View {
    var body: some View {
        Text("Hello Toolbar")
    }
}

struct LoginScreen_Previews: PreviewProvider {
    static var previews: some View {
        LoginScreen()
            .preferredColorScheme(.dark)
    }
}
