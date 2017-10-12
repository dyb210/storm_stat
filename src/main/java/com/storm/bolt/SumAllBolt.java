//package com.storm.bolt;
//
//
//
//import org.apache.storm.task.OutputCollector;
//import org.apache.storm.task.TopologyContext;
//import org.apache.storm.topology.OutputFieldsDeclarer;
//import org.apache.storm.topology.base.BaseRichBolt;
//import org.apache.storm.tuple.Tuple;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class SumAllBolt extends BaseRichBolt {
//
//
//    private Map stormConf;
//    private TopologyContext context;
//    private OutputCollector collector;
//
//    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
//        this.stormConf = stormConf;
//        this.context = context;
//        this.collector = collector;
//
//    }
//
//    Map<String,Integer> countsMap = new HashMap<String, Integer>();
//    public void execute(Tuple tuple) {
//      //Map<String, Integer> map = (Map<String, Integer>) tuple.getValue(0);
//
//        if(tuple!=null){
//            String word = tuple.getStringByField("word");
//            Integer  count = tuple.getIntegerByField("count");
//            String key =word;
//            Integer sum=0;
//            try{
//
//                sum = countsMap.get(key);
//                if(sum ==null){
//                    sum=0;
//                }
//                sum ++;
//                countsMap.put(word,sum);
//
//                for (Map.Entry<String,Integer> e:countsMap.entrySet()){
//                    System.out.println(e.getKey()+"   "+e.getValue());
//
//                }
//
//
//            }catch (Exception e){
//
//            }
//
//
//
//        }
//        //把结果写出去
//
////        for (Map.Entry<String, Integer> entry : map.entrySet()) {
////            System.out.println(entry);
////        }
//
//
//    }
//
//    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
//
//    }
//}
