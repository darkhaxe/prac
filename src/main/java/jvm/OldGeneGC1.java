package jvm;

/**
 * @author haze
 * @date created at 2020/2/22 1:01 上午
 */
public class OldGeneGC1 {
    /*
     -XX:NewSize=10485760
     -XX:MaxNewSize=10485760
     -XX:InitialHeapSize=20971520
     -XX:MaxHeapSize=20971520
     -XX:SurvivorRatio=8
     -XX:MaxTenuringThreshold=15
     -XX:PretenureSizeThreshold=10485760
     -XX:+UseParNewGC
     -XX:+UseConcMarkSweepGC
     -XX:+PrintGCDetails
     -XX:+PrintGCTimeStamps
     -Xloggc:gc.log
     */
    public static void main(String[] args) {
        byte[] arr1 = new byte[2 * 1024 * 1024];
        arr1 = new byte[2 * 1024 * 1024];
        arr1 = new byte[2 * 1024 * 1024];

        arr1 = null;
        byte[] arr2 = new byte[128 * 1024];

        byte[] arr3 = new byte[2 * 1024 * 1024];

    }
}


