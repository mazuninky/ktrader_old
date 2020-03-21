package xyz.kektech.trading.api

import kotlinx.coroutines.flow.Flow
import xyz.kektech.trading.entity.CandleEntity
import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

interface ExchangeApi {
    suspend fun getInstrumentCandleFlow(id: String, frequency: TimeUnit): Flow<CandleEntity>
    suspend fun getHistoryCandle(id: String, from: ZonedDateTime, to: ZonedDateTime): List<CandleEntity>
}
