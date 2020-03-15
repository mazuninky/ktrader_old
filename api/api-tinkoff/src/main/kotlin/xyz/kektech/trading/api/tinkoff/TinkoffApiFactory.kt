package xyz.kektech.trading.api.tinkoff

import xyz.kektech.trading.TradingEngine
import xyz.kektech.trading.api.ExchangeApi
import xyz.kektech.trading.api.ExchangeApiFactory

class TinkoffConfiguration {
    lateinit var token: String
    var inSandbox = false
}

object Tinkoff : ExchangeApiFactory<TinkoffConfiguration> {
    override fun create(configuration: TinkoffConfiguration.() -> Unit): ExchangeApi {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
