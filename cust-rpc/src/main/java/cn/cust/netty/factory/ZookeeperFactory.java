package cn.cust.netty.factory;

/**
 * Created by zhangbing on 2018/4/10.
 */

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ZookeeperFactory {

    public static CuratorFramework client;


    public static CuratorFramework create(){
        if(client==null){
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
            client = CuratorFrameworkFactory.newClient("47.93.23.61:2181", retryPolicy);
            client.start();
        }
        return client;
    }

    public static void main(String[] args) throws Exception {
        CuratorFramework client = create();
        client.create().forPath("/netty");
    }

}
