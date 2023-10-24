package com.huaizhu;

public class 布隆过滤器 {

    /**
     * 布隆过滤器重要的三个公式：
     * 1.假设数据量为n,预期的失误率为p(布隆过滤器大小与每个样本的大小无关)
     * 2.根本n和p,算出bloom Filter 一共需要多少个bit位，向上取整 记为 m
     *  ==>m= -（n*lnp）/(ln2)^2
     * 3.根据m 和 n 算出 bloom Filter 需要多少个哈希函数，向上取整 记为k
     *  ==> k= ln2 * (m/n) = 0.7 * (m/n)
     * 4.根据修正公式，算出真实的失误率p
     */
}
