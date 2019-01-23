package com.prembros.asymrecycler.lib.pool

import android.os.Parcelable
import kotlinx.android.parcel.*
import java.util.*

@Parcelize
internal class ObjectPool<T>(
        private var stack: Stack<T> = Stack(),
        var factory: @RawValue PoolObjectFactory<T>? = null,
        private var stats: PoolStats = PoolStats()
) : Parcelable {

    constructor(factory: PoolObjectFactory<T>) : this() {
        this.factory = factory
    }

    @Parcelize
    data class PoolStats(
            var size: Int = 0,
            var hits: Int = 0,
            var misses: Int = 0,
            var created: Int = 0
    ) : Parcelable {
        fun getStats(name: String): String {
            return String.format("%s: size %d, hits %d, misses %d, created %d", name, size, hits,
                    misses, created)
        }
    }

    fun get(): T? {
        if (!stack.isEmpty()) {
            stats.hits++
            stats.size--
            return stack.pop()
        }

        stats.misses++

        val `object` = factory?.createObject()

        if (`object` != null) {
            stats.created++
        }

        return `object`
    }

    fun put(`object`: T) {
        stack.push(`object`)
        stats.size++
    }

    fun clear() {
        stats = PoolStats()
        stack.clear()
    }

    fun getStats(name: String): String {
        return stats.getStats(name)
    }
}
