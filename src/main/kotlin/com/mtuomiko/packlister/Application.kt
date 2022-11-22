package com.mtuomiko.packlister

import io.micronaut.runtime.Micronaut.*
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

@OpenAPIDefinition(
    info = Info(
        title = "packlister",
        version = "0.0"
    )
)
object Api {
}

fun main(args: Array<String>) {
    run(*args)
}

