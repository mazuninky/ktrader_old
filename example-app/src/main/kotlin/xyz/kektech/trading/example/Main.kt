package xyz.kektech.trading.example

import xyz.kektech.trading.api.tinkoff.Tinkoff
import xyz.kektech.trading.data.influx.Influx
import xyz.kektech.trading.tradingBot

suspend fun main() {
    val bot = tradingBot(Tinkoff, Influx) {
        api {
            token = "12345"
        }
        history {

        }
    }.start()
}
