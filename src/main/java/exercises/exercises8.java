package exercises;

import java.util.HashMap;

public class exercises8 {

    private static long setAllTime = Long.MAX_VALUE;
    private static int setAll = 0;
    private static long putTime = 0;

    public static class ValueHodler {
        public void setVal(int val) {
            this.val = val;
        }

        public void setPutTime(long putTime) {
            this.putTime = putTime;
        }

        private int val;
        private long putTime;

        public ValueHodler(int _val, long _putTime) {
            val = _val;
            putTime = _putTime;
        }


    }

    /**
     * 时间复杂度为O(1) 情况下 setAll(7) 将hash表中所有的数据变为7
     */
    public static void add(HashMap<Integer, ValueHodler> h1, int key, int value) {
        ValueHodler valueHodler;
        if (h1.containsKey(key)) {
            valueHodler = h1.get(key);
            valueHodler.setVal(value);
            valueHodler.setPutTime(putTime);
        } else {
            valueHodler = new ValueHodler(value, putTime);
        }
        h1.put(key, valueHodler);
        putTime++;
    }

    public static void setAll(int value){
        setAllTime = putTime;
        setAll = value;
        putTime++;
    }

    public static int get(HashMap<Integer, ValueHodler> h1,int key){
        if(h1.containsKey(key)){
            ValueHodler valueHodler = h1.get(key);
            if(valueHodler.putTime < setAllTime){
                return setAll;
            }
            return valueHodler.val;
        }
        return 0;
    }


}
