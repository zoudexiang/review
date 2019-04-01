package com.taitan.review.hadoop.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;

/**
 * @author 邹德翔
 * @date 2019/3/31 21:04
 */
//public class WordCountDriver extends Configuration implements Tool {
public class WordCountDriver{

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        Job job = null;
        try {
            job = Job.getInstance(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }

        job.setJarByClass(WordCountDriver.class);

        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        try {
            FileInputFormat.setInputPaths(job,new Path("E:\\input\\input.txt"));
            FileOutputFormat.setOutputPath(job,new Path("E:\\input\\output"));
            boolean result = job.waitForCompletion(true);
            System.out.println(result ? 0 : 1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (configuration != null){
                configuration.clear();
            }
        }
//        try {
//            int run = ToolRunner.run(configuration, new WordCountDriver(), args);
//            System.exit(run);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            if (configuration != null){
//                configuration.clear();
//            }
//        }
    }

//    private Configuration configuration;
//
//    public int run(String[] args) throws Exception {
//
//        Job job = Job.getInstance(configuration);
//
//        job.setJarByClass(WordCountDriver.class);
//
//        job.setMapperClass(WordCountMapper.class);
//        job.setReducerClass(WordCountReducer.class);
//
//        job.setMapOutputKeyClass(Text.class);
//        job.setMapOutputValueClass(IntWritable.class);
//
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(IntWritable.class);
//
//        FileInputFormat.setInputPaths(job,new Path("E:\\input\\input.txt"));
//        FileOutputFormat.setOutputPath(job,new Path("E:\\input\\output"));
//
//        boolean result = job.waitForCompletion(true);
//        return result ? 0 : 1;
//    }
//
//    public void setConf(Configuration conf) {
//        configuration = conf;
//    }
//
//    public Configuration getConf() {
//        return configuration;
//    }
}
