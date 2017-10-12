package com.storm.spout;



import org.apache.storm.kafka.KafkaSpout;
import org.apache.storm.kafka.SpoutConfig;


public class KafkaBaseSpout extends KafkaSpout {

    public KafkaBaseSpout(SpoutConfig spoutConf) {
        super(spoutConf);
    }

//    public KafkaBaseSpout(String confKey) {
//
//        // super(spoutConf);
//        String zks = "h1:2181,h2:2181,h3:2181";
//        String topic = "my-replicated-topic5";
//        String zkRoot = "/storm"; // default zookeeper root configuration for storm
//        String id = "word";
//        BrokerHosts brokerHosts = new ZkHosts(zks);
//        SpoutConfig spoutConf = new SpoutConfig(brokerHosts, topic, zkRoot, id);
//        spoutConf.scheme = new SchemeAsMultiScheme(new StringScheme());
////      spoutConf.bufferSizeBytes = false;
//        spoutConf.zkServers = Arrays.asList(new String[]{"h1", "h2", "h3"});
//        spoutConf.zkPort = 2181;
//        super(spoutConf );
////        super();
////        comConf = new ComponentConfiguration("kafka.properties");
////        spoutConf = new KafkaSpoutConfig();
////
////        Map map = comConf.load().get(confKey).getContext();
////        Map in = comConf.load().get("consumer").getContext();
////        map.putAll(in);
////        spoutConf.configure(comConf.load().get(confKey).getContext());
////        spoutConf.setScheme(new StringScheme());
////        super.configurate(spoutConf);
//    }


    //TopologyBuilder builder = new TopologyBuilder();

    //builder.setSpout("kafka-reader", new KafkaSpout(spoutConf), 5); // Kafka我们创建了一个5分区的Topic，这里并行度设置为5

}
