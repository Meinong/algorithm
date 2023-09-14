package com.huaizhu;

public class LazySignle {

    private LazySignle(){};



    private static class LazyLoader{
        public static LazySignle lazySignle = new LazySignle();
    }

    public static LazySignle getSignle(){
        return LazyLoader.lazySignle;
    }



}
