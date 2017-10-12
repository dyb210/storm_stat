package com.storm.bolt;


import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class SplitBolt extends BaseRichBolt {
    private final static Logger logger = LoggerFactory.getLogger(BaseRichBolt.class);
    private Map conf;
    private TopologyContext context;
    private OutputCollector collector;
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector=outputCollector;
        this.conf =map;
        this.context =topologyContext;
    }
    public void execute(Tuple tuple) {
        try{
            String line = tuple.getStringByField("line");
            String[] words = line.split("\\s");
            for(String word : words){ // 发送每一个单词
                collector.emit(new Values(word));
            }
            collector.ack(tuple);
        }catch (Exception e){
            logger.error(e.getMessage());

        }

    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
                outputFieldsDeclarer.declare(new Fields("word"));
    }
}
