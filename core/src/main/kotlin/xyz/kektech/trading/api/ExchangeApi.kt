package xyz.kektech.trading.api

import kotlinx.coroutines.flow.Flow
import xyz.kektech.trading.entity.CandleEntity
import java.time.ZonedDateTime
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

interface ExchangeApi {
    @ExperimentalTime
    suspend fun getInstrumentCandleFlow(id: String, frequency: DurationUnit): Flow<CandleEntity>
    suspend fun getHistoryCandle(id: String, from: ZonedDateTime, to: ZonedDateTime): List<CandleEntity>
}
