package xyz.kektech.trading.history

import xyz.kektech.trading.entity.CandleEntity
import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit

interface HistoryRepository {
    fun getHistory(from: ZonedDateTime, to: ZonedDateTime, frequency: TimeUnit): List<CandleEntity>
}
