package com.huaizhu;


/**
 * ^(异或 表示 无进位相加)
 */
public class 位图 {


    public static class 位运算{

        public static int add(int a,int b){
            int sum = a;
            //只能当b(进位信息为0时终止)
            while (b != 0){
                sum = a ^ b;
                b = (a & b) << 1;
                a = sum;
            }
            return sum;
        }

        //相反数
        public static int negNum(int num){
            return add(~num,1);
        }

        //相减
        public static int minus(int a,int b){
            return add(a,negNum(b));
        }

        //相乘
        public static int multi(int a,int b){
            int res = 0;
            while(b !=0){
                if(( b & 1) != 0){
                    res = add(res,a);
                }
                a <<= 1;
                b >>>= 1;
            }
            return res;
        }

        public static boolean isNeg(int n){
            return n > 0;
        }

        public static int div(int a,int b){
            int x = isNeg(a) ? a : negNum(a);
            int y = isNeg(b) ? b : negNum(b);

            int res = 0;
            for (int i = 30;i >= 0; i = minus(i,1)){
                if((x >> i) >= y){
                    res |= (1 << i);
                    x = minus(x,y << i);
                }
            }
            return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
        }


        //系统最小 相反数 还是系统最小
        public static int divide(int a,int b){
            if(a == Integer.MIN_VALUE && b == Integer.MIN_VALUE){
                return 1;
            }
            else if(b == Integer.MIN_VALUE){
                return 0;
            }else if(a == Integer.MIN_VALUE){
                if(b == -1){
                    return Integer.MAX_VALUE;
                }else {
                    //a /b
                    // (a+1) /b == c
                    //a- (b*c) =e;
                    //c + (a/e) == a/b


                    int ans = div(add(a, 1), b);
                    return add( ans,div( minus(a,multi(b,ans)), b) );
                }
            }else{
                return div(a,b);
            }

        }
    }





    public static class BitMap{
        private final long[] bits;

        public BitMap(int max){
            //   >>6 --> /64
            bits = new long[ (max+64) >> 6];
        }

        public void add(int num){
            bits[num >> 6] |= (1L<<(num & 63));
        }

        public void delete(int num){
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean search(int num){
           return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }
}
