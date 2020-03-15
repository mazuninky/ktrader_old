package xyz.kektech.trading.history

interface HistoryRepositoryFactory<TConfiguration> {
    fun create(configuration: TConfiguration.() -> Unit): HistoryRepository
}
