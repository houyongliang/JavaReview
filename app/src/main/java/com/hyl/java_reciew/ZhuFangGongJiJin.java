package com.hyl.java_reciew;

/**
 * 1. 作用  税前月工资×10％至12％×2（单位＋个人），例：税前月工资5000，公积金率10％，则月公积金=5000×10％×2＝1000，其中单位和个人各500。
 税前月工资×10％至12％×2（单位＋个人），例：税前月工资5000，公积金率10％，则月公积金=5000×10％×2＝1000，其中单位和个人各500。
 *
* 2. 作者 侯永亮
 * 3. 时间 2016/11/28.
 */

public class ZhuFangGongJiJin {
    public static int getMoney(int salary,int rate){/*salary 工资  rate 税率*100*/
              return  (int)salary*rate*2/100/2;
    }

    public static void main(String[] args) {
        System.out.println("月薪15000所交公积金为"+getMoney(15000,12));
    }
}
