package com.taitan.review.hadoop.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author 邹德翔
 * @date 2019/3/31 20:54
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    Text word = new Text();

    IntWritable value = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] words = value.toString().split(" ");

        for (String word : words) {
            this.word.set(word);
            context.write(this.word,this.value);
        }
    }
}
