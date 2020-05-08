package xyz.kektech.trading

import kotlinx.coroutines.CoroutineScope
import xyz.kektech.trading.api.ExchangeApi
import xyz.kektech.trading.api.ExchangeApiFactory
import xyz.kektech.trading.history.HistoryRepository
import xyz.kektech.trading.history.HistoryRepositoryFactory
import xyz.kektech.trading.strategy.TradingStrategy
import kotlin.coroutines.CoroutineContext

class TradingEngine(
    private val strategies: List<TradingStrategy>,
    private val api: ExchangeApi,
    private val history: HistoryRepository
) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = TODO("not implemented")

    suspend fun start(wait: Boolean = true): TradingEngine {
        strategies.forEach {

        }
    }

    suspend fun stop() {
        TODO("not implemented")
    }
}

class TradingEngineBuilder<ApiConfiguration, HistoryConfiguration> internal constructor() {
    private val strategies: MutableList<TradingStrategy> = mutableListOf()
    private var apiConfiguration: ApiConfiguration.() -> Unit = {}
    private var historyConfiguration: HistoryConfiguration.() -> Unit = {}

    fun api(configuration: ApiConfiguration.() -> Unit) {
        apiConfiguration = configuration
    }

    fun history(configuration: HistoryConfiguration.() -> Unit) {
        historyConfiguration = configuration
    }

    internal fun build(
        apiFactory: ExchangeApiFactory<ApiConfiguration>,
        historyFactory: HistoryRepositoryFactory<HistoryConfiguration>
    ): TradingEngine {
        val api = apiFactory.create(apiConfiguration)
        val history = historyFactory.create(historyConfiguration)

        return TradingEngine(strategies, api, history)
    }
}


fun <ApiConfiguration, HistoryConfiguration> tradingBot(
    apiFactory: ExchangeApiFactory<ApiConfiguration>,
    historyFactory: HistoryRepositoryFactory<HistoryConfiguration>,
    block: TradingEngineBuilder<ApiConfiguration, HistoryConfiguration>.() -> Unit
): TradingEngine {
    val builder = TradingEngineBuilder<ApiConfiguration, HistoryConfiguration>().apply(block)
    return builder.build(apiFactory, historyFactory)
}
