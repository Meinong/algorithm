package com.huaizhu;

public class SizeBalanceTree实现有序表 {
    public static class SBTNode<K extends Comparable<K>,V>{
        public K key;
        public V value;
        public SBTNode<K,V> l;
        public SBTNode<K,V> r;
        public int size;// 不同key的数量


        public SBTNode(K key,V value){
            this.key = key;
            this.value = value;
            size = 1;
        }
    }

    public static class SizeBalanceTreeMap<K extends Comparable<K>,V>{
        private SBTNode<K,V> root;

        private SBTNode<K,V> rightRotate(SBTNode<K,V> cur){
            SBTNode<K,V> left = cur.l;
            cur.l = left.r;
            left.r = cur;
            left.size = cur.size;
            cur.size = (cur.l != null ? cur.l.size : 0) + (cur.r != null ? cur.r.size : 0) + 1;
            return left;
        }


        private SBTNode<K,V> leftRotate(SBTNode<K,V> cur){
            SBTNode<K,V> right = cur.r;
            cur.r = right.l;
            right.l = cur;
            right.size = cur.size;
            cur.size = (cur.l != null ? cur.l.size : 0) + (cur.r != null ? cur.r.size : 0) + 1;
            return right;
        }


        private SBTNode<K,V> maintain(SBTNode<K,V> cur){
            if(cur == null){
                return null;
            }

            int leftSize = cur.l != null ? cur.l.size : 0;
            int leftLeftSize = cur.l.l != null ? cur.l.l.size : 0;
            int leftRightSize = cur.l.r != null ? cur.l.r.size : 0;

            int rightSize = cur.r != null ? cur.r.size : 0;
            int rightLeftSize = cur.r.l != null ? cur.r.l.size : 0;
            int rightRightSize = cur.r.r != null ? cur.r.r.size : 0;

            if(leftLeftSize > rightSize){
                //LL
                cur = rightRotate(cur);
                cur.r = maintain(cur.r);
                cur = maintain(cur);
            }else if(leftRightSize > rightSize){
                //LR
                cur.l= leftRotate(cur.l);
                cur = rightRotate(cur);
                cur.l = maintain(cur.l);
                cur.r = maintain(cur.r);
                cur = maintain(cur);
            }else if(rightLeftSize > leftSize){
                //RL
                cur.r = rightRotate(cur.r);
                cur = leftRotate(cur);
                cur.l = maintain(cur.l);
                cur.r = maintain(cur.r);
                cur = maintain(cur);
            }else if(rightRightSize > leftSize){
                //RR
                cur= leftRotate(cur);
                cur.l = maintain(cur.l);
                cur = maintain(cur);
            }

            return cur;
        }

        private SBTNode<K,V> add(SBTNode<K,V> cur,K key,V value){
            if(cur == null){
                return new SBTNode<>(key,value);
            }else{
                cur.size ++;
                if(key.compareTo(cur.key) < 0){
                    cur.l = add(cur.l,key,value);
                }else{
                    cur.r = add(cur.r,key,value);
                }
            }
            return maintain(cur);
        }


        private SBTNode<K,V> delete(SBTNode<K,V> cur,K key){
            cur.size --;
            if(key.compareTo(cur.key) < 0){
                cur.l = delete(cur.l,key);
            }else if (key.compareTo(cur.key) > 0){
                cur.r = delete(cur.r,key);
            }else{
                if(cur.l ==null && cur.r ==null){
                    cur = null;
                }else if(cur.l != null && cur.r == null){
                    cur = cur.l;
                }else if(cur.r != null && cur.l == null){
                    cur = cur.r;
                }else{
                    SBTNode<K,V> pre = null;
                    SBTNode<K,V> des = cur.r;
                    des.size--;
                    while (des.l != null){
                        pre = des;
                        des = des.l;
                        des.size--;
                    }
                    if(pre != null){
                        pre.l = des.r;
                        des.r = cur.r;
                    }
                    des.l = cur.l;
                    des.size = des.l.size + (des.r == null ? 0 : des.r.size) + 1;
                    cur = des;
                }
            }
            return cur;
        }
    }

}
