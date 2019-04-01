package com.taitan.review.hadoop.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author 邹德翔
 * @date 2019/3/31 21:00
 */
public class WordCountReducer extends Reducer<Text,IntWritable,Text,IntWritable> {

    IntWritable total = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        int sum = 0;

        for (IntWritable value : values) {
            sum += value.get();
        }

        total.set(sum);

        context.write(new Text(key),total);
    }
}
