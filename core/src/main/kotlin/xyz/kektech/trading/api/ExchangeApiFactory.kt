package xyz.kektech.trading.api


interface ExchangeApiFactory<TConfiguration> {
    fun create(configuration: TConfiguration.() -> Unit): ExchangeApi
}
