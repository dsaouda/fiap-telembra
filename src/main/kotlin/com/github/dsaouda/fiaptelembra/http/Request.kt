package com.github.dsaouda.fiaptelembra.http

import java.util.HashMap

class Request : HashMap<String, Any>() {

    operator fun <T> get(key: String, clazz: Class<T>): T {
        return get(key) as T
    }

    fun getString(key: String): String {
        return get(key, String::class.java)
    }
}