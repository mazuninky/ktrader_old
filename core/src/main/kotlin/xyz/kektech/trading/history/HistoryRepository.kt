package xyz.kektech.trading.history

import java.time.ZonedDateTime
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

interface HistoryRepository {
    @ExperimentalTime
    fun getHistory(from: ZonedDateTime, to: ZonedDateTime, frequency: DurationUnit)
}
