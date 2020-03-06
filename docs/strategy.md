# Стратегии

Изначально для бота необходимо задать промежуток времени, через которое он будет принимать решение(частота бота). Одним из ограничений для торговли на фондовом рынке: время работы биржы, поэтому необходимо добавить время работы бота.


```kotlin
strategy(name = "Short bot", frequency = minute(1)) {
    time(from hour(9) to hour(18))
    history(day 12)
    onUpdate { update ->
        if(update.price > 5)
            context.buy(1)
        else
            contex.sellAll()
    }
}
```