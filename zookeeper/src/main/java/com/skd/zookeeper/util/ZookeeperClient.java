package com.skd.zookeeper.util;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.zookeeper.data.Stat;

/**
 * @Description:
 * @Author: virgosnail
 * @Date: 2019/9/7 17:32
 */
public class ZookeeperClient {

    public static String zkServerInfo = "39.107.227.146";
    public static String zNode = "/skd";
    private static int sessionTimeoutMs = 2000;
    private static int connectionTimeoutMs = 2000;

    public static void main(String[] args) throws Exception {
        CuratorFramework client = getInstance();
        client.start();

        Stat stat = client.checkExists().forPath(zNode);
        if (null == stat){
            client.create().forPath(zNode,zNode.getBytes("UTF-8"));

        }
        System.out.println(stat);
    }

    public static CuratorFramework getInstance(){
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();
        CuratorFramework client = builder.connectString(zkServerInfo)
                .sessionTimeoutMs(sessionTimeoutMs)
                .connectionTimeoutMs(connectionTimeoutMs)
                .build();
        return client;
    }
}
