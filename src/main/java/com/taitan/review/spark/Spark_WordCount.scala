package com.taitan.review.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 统计文件中每个单词的个数，降序，取前十
  */
object Spark_WordCount {

  def main(args: Array[String]): Unit = {

    val conf: SparkConf = new SparkConf().setAppName("Spark WordCount").setMaster("local[*]")

    val sparkContext = new SparkContext(conf)

    val rdd: RDD[String] = sparkContext.textFile("E:\\video\\Spark_WordCount.txt")

    val wordMapRDD: RDD[(String, Int)] = rdd.flatMap(_.split(" ")).map((_,1))

    val wordReduceRDD: RDD[(String, Int)] = wordMapRDD.reduceByKey(_+_)

    /** 取前十 */
    val result: List[(String, Int)] = wordReduceRDD.collect().toList.sortWith {
      case (left, right) => {
        left._2 > right._2
      }
    }.take(10)

    result.foreach{
      case (key,value) => {
        println(key + "->" + value)
      }
    }

//    wordReduceRDD.saveAsTextFile("E:\\video\\Spark_WordCount_result")

    sparkContext.stop()
  }
}
