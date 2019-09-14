package com.mellenwood.cache.test.factory

import com.mellenwood.cache.model.Config

object ConfigDataFactory {

    fun makeCachedConfig(): Config {
        return Config(DataFactory.randomLong())
    }

}