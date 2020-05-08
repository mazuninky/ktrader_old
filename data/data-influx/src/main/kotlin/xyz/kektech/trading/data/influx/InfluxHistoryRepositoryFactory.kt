package xyz.kektech.trading.data.influx

import org.influxdb.InfluxDB
import org.influxdb.InfluxDBFactory
import xyz.kektech.trading.history.HistoryRepository
import xyz.kektech.trading.history.HistoryRepositoryFactory
import java.util.concurrent.TimeUnit


class InfluxConfiguration

object Influx : HistoryRepositoryFactory<InfluxConfiguration> {

    /*
        TODO : 1) remove all defined String params and take them from config
               2) batch on/off
               3) remove comments
    */
    override fun create(configuration: InfluxConfiguration.() -> Unit): HistoryRepository {

        val influxDB: InfluxDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root")
        influxDB.enableBatch(100, 500, TimeUnit.MILLISECONDS)

        var isExist: Boolean = false;
        for (dbName in influxDB.describeDatabases()){
            if (dbName.equals("ktradingDB")) {
                isExist = true;
                break;
            }
        }
        if (!isExist) influxDB.createDatabase("ktradingDB");

        val instrument: String = "stocks";

        val historyRepository: HistoryRepository = HistoryRepositoryImpl(influxDB, instrument)
        /*var historyRepository : HistoryRepository? = null;
        try {

            val historyRepository = HistoryRepository();
            val response: Pong = influxDB.ping()
            if (response.version.equals("unknown", ignoreCase = true)) {
                println("Error")
            }
            else {
                println("Good")
            }
        }
        catch (ex: Exception) {
            println("Bad")
            println(ex.message)
        }*/
        return historyRepository
    }
}
