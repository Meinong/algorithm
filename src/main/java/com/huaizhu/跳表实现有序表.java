package com.huaizhu;

import java.util.ArrayList;

public class 跳表实现有序表 {

    public static class SkipListNode<K extends Comparable<K>, V> {
        public K key;
        public V value;
        public ArrayList<SkipListNode<K, V>> nextNodes;

        public SkipListNode(K k, V v) {
            key = k;
            value = v;
            nextNodes = new ArrayList<SkipListNode<K, V>>();
        }


        private boolean isKeyLess(K key) {
            return this.key.compareTo(key) < 0;
        }

        private boolean isKeyEqual(K key) {
            return this.key.compareTo(key) == 0;
        }

    }


    public static class SkipListMap<K extends Comparable<K>, V> {
        private static final double PROBABILITY = 0.5;
        private SkipListNode<K, V> head;
        private int size;
        private int maxLevel;


        public SkipListMap() {
            head = new SkipListNode<K, V>(null, null);
            head.nextNodes.add(null);
            size = 0;
            maxLevel = 0;
        }

        //从最高层开始，一路找下去
        //最终，找到第0层的< key 的最右节点
        private SkipListNode<K, V> mostRightLessNodeInTree(K key) {
            if (key == null) {
                return null;
            }

            int level = maxLevel;
            SkipListNode<K, V> cur = head;
            while (level >= 0) {
                cur = mostRightLessNodeInLevel(key, cur, level--);
            }
            return cur;
        }

        //在level层里，如何往右移动
        //现在来到的节点是cur,来到cur的level层，在level层上，找到< key最后一个节点并返回
        private SkipListNode<K, V> mostRightLessNodeInLevel(K key,
                                                            SkipListNode<K, V> cur,
                                                            int level) {
            SkipListNode<K, V> next = cur.nextNodes.get(level);
            while (next != null && next.isKeyLess(key)) {
                cur = next;
                next = cur.nextNodes.get(level);
            }
            return cur;
        }

        public void put(K key, V value) {
            if (key == null) {
                return;
            }

            SkipListNode<K, V> less = mostRightLessNodeInTree(key); //找到第0层最右边小于key的值
            SkipListNode<K, V> find = less.nextNodes.get(0); //在往右边看一个
            if (find != null && find.isKeyEqual(key)) { //如果相等 则更新
                find.value = value; //更新值
            } else { //新加入的数
                size++;
                int newNodeLevel = 0;
                while (Math.random() < PROBABILITY) {
                    newNodeLevel++;
                }

                while (newNodeLevel > maxLevel) { //如果升高的层数 大于最大层，那么head 节点也升高
                    head.nextNodes.add(null);
                    maxLevel++;
                }
                SkipListNode<K, V> newNode = new SkipListNode<K, V>(key, value);
                for (int i = 0; i <= newNodeLevel; i++) {
                    newNode.nextNodes.add(null);
                }

                int level = maxLevel;
                SkipListNode<K,V> pre = head;
                while (level >= 0){
                    pre = mostRightLessNodeInLevel(key,pre,level);
                    if(level <= newNodeLevel){ //当最大层大于新数据的层数时，不做处理
                        newNode.nextNodes.set(level,pre.nextNodes.get(level));
                        pre.nextNodes.set(level,newNode);
                    }
                    level--;
                }
            }
        }

        public void remove(K key){
            if(containKey(key)){ //存在的时候才删除
                size--;
                int level = maxLevel;
                SkipListNode<K,V> pre = head;
                while (level >= 0){
                    pre = mostRightLessNodeInLevel(key,pre,level);
                    SkipListNode<K, V> next = pre.nextNodes.get(level);
                    if(next != null && next.isKeyEqual(key)){ //相等时 直接将next的nextNodes赋值给前一个数pre
                        pre.nextNodes.set(level,next.nextNodes.get(level));
                    }
                    if(level != 0 && pre == head && pre.nextNodes.get(level) == null){
                        head.nextNodes.remove(level);
                        maxLevel--;
                    }
                    level--;
                }

            }
        }

        public boolean containKey(K key){
            if(key == null){
                return false;
            }
            SkipListNode<K,V> less = mostRightLessNodeInTree(key);
            SkipListNode<K, V> next = less.nextNodes.get(0);
            return next != null && next.isKeyEqual(key);
        }

    }

}
