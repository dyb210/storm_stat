//package com.storm.bolt;
//
//import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
//import backtype.storm.task.OutputCollector;
//import backtype.storm.task.TopologyContext;
//import backtype.storm.topology.OutputFieldsDeclarer;
//import backtype.storm.topology.base.BaseWindowedBolt;
//import backtype.storm.tuple.Tuple;
//import backtype.storm.windowing.TupleWindow;
//import scala.Int;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class SlidingWindowBolt extends BaseWindowedBolt {
//
//
//    private OutputCollector collector;
//
//    Map<String,Integer> map = new HashMap<String, Integer>();
//
//    public void execute(TupleWindow tupleWindow) {
//
//
//        //int sum =0;
//        for(Tuple tuple:tupleWindow.get()){
//            String word = tuple.getStringByField("word");
//            Integer str =  tuple.getIntegerByField("count");
//            Integer sum = map.get(word);
//            if(sum==null){
//                sum =0;
//            }
//            sum+=str;
//            map.put(word,sum);
//        }
//
//        for(Map.Entry<String, Integer> map:map.entrySet()){
//            System.out.println(map.getKey()+"  "+map.getValue());
//        }
//
//    }
//
//    @Override
//    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
//        super.prepare(stormConf, context, collector);
//        this.collector = collector;
//    }
//
//    @Override
//    public void declareOutputFields(OutputFieldsDeclarer declarer) {
//        super.declareOutputFields(declarer);
//    }
//}
