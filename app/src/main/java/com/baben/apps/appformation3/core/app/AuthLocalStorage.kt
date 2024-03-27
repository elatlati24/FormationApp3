package com.baben.apps.appformation3.core.app

open class AuthLocalStorage {
    private var token: String? = null

    fun estConnecte(): Boolean {
        return token != null
    }

    fun rendreToken(): String? {
        return token
    }

    fun enregistrerToken(token: String?) {
        this.token = token
    }
}
