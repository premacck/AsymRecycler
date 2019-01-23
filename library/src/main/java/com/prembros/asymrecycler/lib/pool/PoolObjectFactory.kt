package com.prembros.asymrecycler.lib.pool

interface PoolObjectFactory<T> {
    fun createObject(): T
}
