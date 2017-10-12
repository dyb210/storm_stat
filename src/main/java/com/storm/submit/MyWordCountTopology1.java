    package com.storm.submit;

import com.storm.bolt.CountBolt;
import com.storm.bolt.SplitBolt;
import com.storm.spout.Myspout;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;
import org.apache.storm.utils.Utils;


    public class MyWordCountTopology1 {
    public static void main(String[] args) {
        String DATASOURCE_SPOUT = Myspout.class.getSimpleName();
        String SPLIT_BOLD = SplitBolt.class.getSimpleName();
        String COUNT_BOLT = CountBolt.class.getSimpleName();

        final TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout(DATASOURCE_SPOUT, new Myspout());
        builder.setBolt(SPLIT_BOLD,  new SplitBolt()).shuffleGrouping(DATASOURCE_SPOUT);
        builder.setBolt(COUNT_BOLT, new CountBolt(),1).fieldsGrouping(SPLIT_BOLD,new Fields("word"));
       // builder.setBolt("Finsh",new SumAllBolt(),1).shuffleGrouping(COUNT_BOLT);

        final LocalCluster localCluster = new LocalCluster();
        final Config config = new Config();
        localCluster.submitTopology("MYWORDTOPOLOGY", config, builder.createTopology());
        Utils.sleep(999999911);
        localCluster.shutdown();

//        Config conf = new Config();
//        conf.put(Config.TOPOLOGY_DEBUG, false);
//        conf.put(Config.TOPOLOGY_ACKER_EXECUTORS, 1);
//        conf.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 1000);
//        conf.put("kafkaTopic","vdn_pc_phone_flush_mongodb");
//        conf.setNumWorkers(1);
//        conf.setNumAckers(1);
//        try {
//            StormSubmitter.submitTopology("TESTDYB", conf, builder.createTopology());
//        } catch (AlreadyAliveException e) {
//            e.printStackTrace();
//        } catch (InvalidTopologyException e) {
//            e.printStackTrace();
//        } catch (AuthorizationException e) {
//            e.printStackTrace();
//        }

    }
}
