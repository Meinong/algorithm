package com.huaizhu;


/**
 * 首先是一颗搜索二叉树
 * 其次 左旋右旋 （head 左旋右旋）
 */
public class AVL树实现有序表 {

    //搜索二叉树的加：顺这左树分支 或者 右树分支 往下加
    /**
     * 搜索二叉树的减：
     * 情况1: 当删除的节点 既没有左也没有右时 直接删除
     * 情况2: 当删除的节点 有左没有右时，用左子节点替换
     * 情况3: 当删除的节点 无左有右时，用右子节点替换
     * 情况4: 当删除的节点 既有左也有右时，用右子节点中最下方的左子节点的节点替换  也可以 用左子节点中最下方的右节点替换
     */

    //AVL树(平衡二叉树)：任何一个节点 ｜左高-右高｜< 2
    //加减节点和搜索二叉树一样，之后最后会通过左右炫达到平衡
    /**
     * LL 型： 只做一次右炫        LR型：   先左炫(左节点中 最右边的非子节点(需要将1左炫 之后在将3右旋))后右旋            RR型： 只做一次左炫        RL型
     *                       3
     *    3                 / \
     *   /                 1   4
     *  2                 /  \
     * /                 0   2
      1                     / \
                         1.5  1.6
     */
    //当LL型和LR型同时存在时，那么选择LL型旋转
    //当RR型和RL型同时存在时，那么选择RR型旋转
    //当是加入节点的时候，都要依次去看父节点是否平衡
    //当是减去节点的时候，以下前三种情况时，只需要替换好之后 依次去看父节点是否平衡
    //最后一种情况时: 替换好之后，原来所在的位置所有的父节点依次查询是否平衡

    public static class AVLNode<K extends Comparable<K>,V>{
        public K k;
        public V v;
        public AVLNode<K,V> l;
        public AVLNode<K,V> r;
        public int h; //整棵树高度

        public AVLNode(K key,V value){
            k = key;
            v = value;
            h = 1;
        }
    }

    //AVL 实现的有序表
    public static class AVLTreeMap<K extends Comparable<K>,V>{
        private AVLNode<K,V> root;
        private int size; //一共加了几个key

        public AVLTreeMap(){
            root = null;
            size = 0;
        }

        //右炫cur节点
        private AVLNode<K,V> rightRotate(AVLNode<K,V> cur){
            AVLNode<K,V> left = cur.l; //先记录下当前几点的左孩子
            cur.l = left.r;
            left.r = cur;
            //以下已经调整好，接下来调整 cur he left 的高度
            cur.h = Math.max(cur.l != null ? cur.l.h :0,cur.r != null ? cur.r.h :0) + 1;// cur 当前左孩子的高度和右孩子的高度取最大值 + 自己
            left.h = Math.max(left.l != null ? left.l.h :0,left.r != null ? left.r.h :0) + 1;
            return left;// 返回新头部
        }


        //左炫cur节点
        private AVLNode<K,V> leftRotate(AVLNode<K,V> cur){
            AVLNode<K,V> right = cur.r; //先记录下当前几点的左孩子
            cur.r = right.l;
            right.l = cur;
            //以下已经调整好，接下来调整 cur he left 的高度
            cur.h = Math.max(cur.l != null ? cur.l.h :0,cur.r != null ? cur.r.h :0) + 1;// cur 当前左孩子的高度和右孩子的高度取最大值 + 自己
            right.h = Math.max(right.l != null ? right.l.h :0,right.r != null ? right.r.h :0) + 1;
            return right;// 返回新头部
        }

        //添加原始
        //cur 当前来到的元素
        //K,V 你要加的数
        private AVLNode<K,V> add(AVLNode<K,V> cur,K key,V value){
            if(cur == null){
                return new AVLNode<>(key,value);
            }else{
                if(key.compareTo(cur.k) < 0){
                    cur.l = add(cur.l,key,value); //有返回值的原因是 有可能换头(平横之后)
                }else{
                    cur.r = add(cur.r,key,value);
                }
                cur.h = Math.max(cur.l != null ? cur.l.h :0,cur.r != null ? cur.r.h :0) + 1;// cur 当前左孩子的高度和右孩子的高度取最大值 + 自己
                return maintain(cur);
            }
        }

        //删除节点
        public AVLNode<K,V> delete(AVLNode<K,V> cur,K key){
            if(key.compareTo(cur.k) > 0){
                cur.r = delete(cur.r,key);
            }else if(key.compareTo(cur.k) < 0){
                cur.l = delete(cur.l,key);
            }else{ //就删除自己时，需要考虑4中情况
                if(cur.l == null && cur.r == null){
                    cur = null;
                }else if(cur.l == null && cur.r != null){
                    cur = cur.r;
                }else if(cur.l != null && cur.r == null){
                    cur = cur.l;
                }else{
                    AVLNode<K,V> des = cur.r;
                    while (des.l != null){
                        des = des.l;
                    }
                    //先将右数上最左孩子删除
                    cur.r = delete(cur.r,des.k);
                    des.l = cur.l;
                    des.r = cur.r;
                    cur = des;
                }
            }
            if(cur != null){
                cur.h = Math.max(cur.l != null ? cur.l.h :0,cur.r != null ? cur.r.h :0) + 1;// cur 当前左孩子的高度和右孩子的高度取最大值 + 自己
            }
            return maintain(cur);
        }


        //平衡调整
        private AVLNode<K,V> maintain(AVLNode<K,V> cur){
            if(cur == null){
                return null;
            }
            int leftHeight = cur.l != null ? cur.l.h : 0;
            int rightHeight = cur.r != null ? cur.r.h : 0;

            //破坏平衡了
            if(Math.abs(leftHeight - rightHeight) > 1){
                //左数高
                if(leftHeight > rightHeight){
                    int leftLeftHeight = cur.l != null && cur.l.l != null ? cur.l.l.h : 0;
                    int leftRightHeight = cur.l != null && cur.l.r != null ? cur.l.r.h : 0;
                    if(leftLeftHeight >= leftRightHeight){
                        cur = rightRotate(cur); // LL 型
                    }else{ //LR 型
                        cur.l = leftRotate(cur.l);
                        cur = rightRotate(cur);
                    }
                }else{
                    //右数高
                    int rightLeftHeight = cur.r != null && cur.r.l != null ? cur.r.l.h : 0;
                    int rightRightHeight = cur.r != null && cur.r.r != null ? cur.r.r.h : 0;
                    if(rightLeftHeight > rightRightHeight){
                        cur.r = rightRotate(cur.r);
                        cur = leftRotate(cur); // RL 型
                    }else{ //RR 型
                        cur = leftRotate(cur);
                    }
                }
            }
            return cur;
        }
    }

}
