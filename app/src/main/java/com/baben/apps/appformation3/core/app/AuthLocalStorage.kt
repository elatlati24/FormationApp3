package com.baben.apps.appformation3.core.app

class AuthLocalStorage {


    private var token: String? = null

    fun setToken(token: String) {
        this.token = token
    }

    fun getToken(): String? {
        return token
    }

    fun isLoggedIn(): Boolean {
        return token != null
    }
}


