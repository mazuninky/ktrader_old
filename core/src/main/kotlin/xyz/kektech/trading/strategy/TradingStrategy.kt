package xyz.kektech.trading.strategy

import xyz.kektech.trading.entity.CandleEntity

abstract class TradingStrategy {
    abstract fun onInit()
    abstract fun onShutdown()

    fun handle(candle: CandleEntity) {

    }

    fun buy() {

    }

    fun sell() {

    }
}
