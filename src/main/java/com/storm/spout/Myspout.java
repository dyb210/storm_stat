package com.storm.spout;

import org.apache.commons.io.FileUtils;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;



import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Myspout extends BaseRichSpout {

    private Map conf;
    private TopologyContext context;
    private SpoutOutputCollector collector;

    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {

        this.collector = spoutOutputCollector;
        this.context = topologyContext;
        this.conf = map;
    }

    public void nextTuple() {
        Collection<File> files = FileUtils.listFiles(new File("/Users/admin/Documents/dyb/"), new String[]{"txt"}, true);
        if(files != null && files.size() > 0){
            for(File file : files){
                try {// 将文件每一行都发射到 bolt内
                    List<String> lines = FileUtils.readLines(file,"utf-8");
                    for(String line : lines){
                        collector.emit(new Values(line));
                    }
                    //修改操作完的文件（这里是修改后缀） 这样nextTuple方法就不会再重新处理该文件
                    FileUtils.moveFile(file, new File(file.getAbsolutePath() + "." + System.currentTimeMillis()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("line"));

    }
}
