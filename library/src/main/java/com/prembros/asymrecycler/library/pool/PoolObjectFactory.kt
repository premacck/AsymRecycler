package com.prembros.asymrecycler.library.pool

interface PoolObjectFactory<T> {
    fun createObject(): T
}
