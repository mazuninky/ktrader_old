package xyz.kektech.trading.data.influx

import xyz.kektech.trading.history.HistoryRepository
import xyz.kektech.trading.history.HistoryRepositoryFactory

class InfluxConfiguration

object Influx : HistoryRepositoryFactory<InfluxConfiguration> {
    override fun create(configuration: InfluxConfiguration.() -> Unit): HistoryRepository {
        TODO("not implemented")
    }
}
