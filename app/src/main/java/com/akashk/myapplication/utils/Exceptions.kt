package com.akashk.myapplication.utils

import java.io.IOException

class AuthException:IOException(){
    override val message: String?
        get() = "You are an unauthorized person"
}

class NoInternetException:IOException(){
    override val message: String?
        get() = "No internet connection from Akash class"
}