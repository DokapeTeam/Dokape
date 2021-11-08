//
//  Tutorial.swift
//  iosApp
//
//  Created by Anh Trần Sĩ Nguyên on 03/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct Tutorial: View {
    @State private var selectedTab = 0
    var body: some View {
        TabView(selection: $selectedTab) {
            TutorialPageWelcome(selectedTab: $selectedTab)
                .tag(0)
            TutorialPagePermission(selectedTab: $selectedTab)
                .tag(1)
            TutorialPageComplete()
                .tag(2)
        }
        .tabViewStyle(PageTabViewStyle(indexDisplayMode: .never))
        .animation(Animation.linear(duration: 200))
    }
}
