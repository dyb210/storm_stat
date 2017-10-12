//package com.storm.submit;
//
//import com.storm.bolt.CountBolt;
//import com.storm.bolt.SlidingWindowBolt;
//import com.storm.bolt.SplitBolt;
//import com.storm.spout.Myspout;
//import org.apache.storm.Config;
//import org.apache.storm.LocalCluster;
//import org.apache.storm.topology.TopologyBuilder;
//import org.apache.storm.topology.base.BaseWindowedBolt;
//import org.apache.storm.tuple.Fields;
//
//import java.util.concurrent.TimeUnit;
//
//public class WindowsTopology {
//
//    public static void main(String[] args) {
//        try {
//            TopologyBuilder builder = new TopologyBuilder();
//            builder.setSpout("SPOUT", new Myspout());
//            builder.setBolt("FIRSTBOLT", new SplitBolt()).shuffleGrouping("SPOUT");
//            builder.setBolt("SECONDBOLT", new CountBolt(),1).fieldsGrouping("FIRSTBOLT",new Fields("word"));
//            builder.setBolt("SLIDINGWINDOWBOLT", new SlidingWindowBolt().withWindow(new BaseWindowedBolt.Duration(6, TimeUnit.SECONDS), new BaseWindowedBolt.Duration(2, TimeUnit.SECONDS)), 1)
//                    .shuffleGrouping("SECONDBOLT");
//            Config conf = new Config();
//            conf.setNumWorkers(1);
//            LocalCluster cluster = new LocalCluster();
//            cluster.submitTopology("WORDCOUNT", conf, builder.createTopology());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
