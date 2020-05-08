package xyz.kektech.trading.data.influx;
/*
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;*/
import org.jetbrains.annotations.NotNull;
/*
import org.influxdb.InfluxDB;
import xyz.kektech.trading.entity.CandleEntity;
import xyz.kektech.trading.history.HistoryRepository;
*/
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HistoryRepositoryImpl {

    String db; // InfluxDB
    String measurement;

    public HistoryRepositoryImpl(String db, String measurement){
        this.db = db;
        this.measurement = measurement;
    }


    public void save(@NotNull String candle) {
        // TODO : add writing to db
        /*Point point = Point.measurement(measurement)
                .time(ValueMapper.zonedToLong(candle.getTime()), TimeUnit.MILLISECONDS)
                .addField("open", candle.getOpen())
                .addField("close", candle.getClose())
                .addField("low", candle.getHigh())
                .addField("high", candle.getHigh())
                .build();
        // db.write(point);*/
    }



    // String = CandleEntity
    //@Override
    public List<String> getHistory(@NotNull ZonedDateTime from,
                                         @NotNull ZonedDateTime to,
                                         @NotNull TimeUnit frequency) {
        /*
        List<CandleEntity> candleEntities = new ArrayList<>();
        QueryResult queryResult = db.query(
                new Query("Select * from " + measurement
                        + " where time >= " + ValueMapper.zonedToTimestamp(from)
                        + " and time <= " + ValueMapper.zonedToTimestamp(to),
                        "ktradingDB"));
        // TODO : fix data
        for (int i = 0; i < queryResult.getResults().get(0).getSeries().size(); i++){
            ValueMapper.mapEntity(queryResult.getResults().get(0).getSeries().get(i), i);
        }
        return candleEntities;
        */
        return new ArrayList<>();
    }

    private static class ValueMapper {
        // TODO : fix data
        /*
        private static CandleEntity mapEntity(QueryResult.Series result, int counter) {
            return new CandleEntity(Double.parseDouble(result.getTags().get(counter)),
                                    Double.parseDouble(result.getTags().get(counter)),
                                    Double.parseDouble(result.getTags().get(counter)),
                                    Double.parseDouble(result.getTags().get(counter)),
                                    ZonedDateTime.parse(result.getTags().get(counter)));
        }

        private static Timestamp zonedToTimestamp(ZonedDateTime time) {
            return Timestamp.from(time.toInstant());
        }

        private static long zonedToLong(ZonedDateTime time) {
            return time.toInstant().toEpochMilli();
        }
        */
    }
}
