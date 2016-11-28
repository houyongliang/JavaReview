package com.hyl.java_reciew;

import android.media.SoundPool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. 作用
 * 2. 作者 侯永亮
 * 3. 时间 2016/11/28.
 */

public class JavaTest {
    static int  count=0;

    public static void main(String[] args) {
       File file = new File("G:\\");
        List<File> list=new ArrayList<>();
        IOStreamDemo.search(file,".mp3",list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getAbsolutePath());
        }

        /*通过二分法获取角标*/
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};/**/
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(searchLoop(array,7)+"____________________________________________________");
        System.out.println(count);

    }
    public static int searchLoop(int[] array,int findValue){

        if(array==null){
            return  -1;
        }

        int start=0;
        int end=array.length-1;
        /*创建循环*/
        while(start<=end){
            count++;
            int middle=(start+end)/2;//获取中间位置
            int middleValue=array[middle];/*获取中间值*/
            if(findValue==middleValue){
                System.out.println(middle);
                return  middle;
            }else if(findValue<middleValue){
                end=middle-1;
            }else{
                start=middle+1;
            }
        }
        return -1;/*查找失败*/
    }
}
