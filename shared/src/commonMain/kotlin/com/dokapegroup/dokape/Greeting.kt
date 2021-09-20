package com.dokapegroup.dokape

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}