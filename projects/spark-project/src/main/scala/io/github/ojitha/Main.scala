import org.apache.spark.sql.SparkSession
import java.time.LocalDate
import org.apache.spark.sql.types._

object Main extends App {
    // 1. Create a SparkSession
    // This is the entry point to programming Spark with the Dataset and DataFrame API.
    val spark = SparkSession.builder
      .appName("SimpleSparkApp")
      .master("local[*]") // Use local mode with all available cores
      .getOrCreate()

    val schema = StructType(
      Seq(
        StructField("AirportCode", StringType, false),
        StructField("Date", DateType, false),
        StructField("TempHighF", IntegerType, false),
        StructField("TempLowF", IntegerType, false)
      )
    )

    val data = Seq(
      ( "BLI", LocalDate.of(2021, 4, 3), 52, 43 ),
      ( "BLI", LocalDate.of(2021, 4, 2), 50, 38),
      ( "BLI", LocalDate.of(2021, 4, 1), 52, 41),
      ( "PDX", LocalDate.of(2021, 4, 3), 64, 45),
      ( "PDX", LocalDate.of(2021, 4, 2), 61, 41),
      ( "PDX", LocalDate.of(2021, 4, 1), 66, 39),
      ( "SEA", LocalDate.of(2021, 4, 3), 57, 43),
      ( "SEA", LocalDate.of(2021, 4, 2), 54, 39),
      ( "SEA", LocalDate.of(2021, 4, 1), 56, 41)
    )

    val temps = spark.createDataFrame(data).toDF(schema.fieldNames: _*)
    temps.show()


    // 6. Stop the SparkSession
    spark.stop()
}