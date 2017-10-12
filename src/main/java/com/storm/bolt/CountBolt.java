package com.storm.bolt;



import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.HashMap;
import java.util.Map;

public class CountBolt extends BaseRichBolt {
  
    private Map stormConf;
    private TopologyContext context;
    private OutputCollector collector;
    public void prepare(Map stormConf, TopologyContext context,OutputCollector collector) {  
        this.stormConf = stormConf;  
        this.context = context;  
        this.collector = collector;  
    }

    private HashMap<String, Integer> map = new  HashMap<String, Integer>();
    public void execute(Tuple input) {
        String word = input.getStringByField("word");  
        Integer value = map.get(word);
        if(value==null){  
            value = 0;  
        }  
        value++;  
        map.put(word, value);

        System.out.println(word+":"+value);
        collector.emit(new Values(word,value));
    }  
  
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

        declarer.declare(new Fields("word","count"));
    }

}