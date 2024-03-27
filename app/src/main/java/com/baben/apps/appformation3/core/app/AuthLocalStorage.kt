package com.baben.apps.appformation3.core.app

class AuthLocalStorage {
    private var token: String? = null

    fun enregistrerToken(token: String) {
        this.token = token
    }

    fun rendreToken(): String? {
        return token
    }

    fun estConnecte(): Boolean {
        return token != null
    }
}
