package sparkdemo;

import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class App
{

	static final String CSV_PATH = "/home/arta/Project/spark-mlib/sample-code/src/main/resources/aa.csv";
    public static void main( String[] args )
    {

		System.setProperty("hadoop.home.dir", "/");
		SparkSession sparksession = SparkSession
								.builder()
								.appName("Simple Application")
								.config("spark.master", "local")
								.getOrCreate();

		// Dataset<String> logData = spark.read().textFile("sparkdemo/src/main/resources/").cache();

		// long numAs = logData.filter(s -> s.contains("a")).count();
		// long numBs = logData.filter(s -> s.contains("b")).count();

		// System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

		DataFrameReader dataFrameReader = sparksession.read();

		Dataset<Row> pm25data = dataFrameReader.format("csv")
									.option("sep", ",")
									.option("inferSchema", "true")
									.option("header", "true")
									.load(CSV_PATH);
		pm25data.show();
		// LinearRegression lr = new LinearRegression()
		// 					.setMaxIter(10)
		// 					.setRegParam(0.3)
		// 					.setElasticNetParam(0.8);

		// // Fit the model.
		// LinearRegressionModel lrModel = lr.fit(pm25data);


		sparksession.stop();
		//ubah NR -> 0
		// tranpose ke horizontal
		// check input datanya bgmn

    }
}
