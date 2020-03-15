package xyz.kektech.trading.entity

import java.time.ZonedDateTime

data class CandleEntity(
    val open: Double,
    val close: Double,
    val low: Double,
    val high: Double,
    val time: ZonedDateTime
)
