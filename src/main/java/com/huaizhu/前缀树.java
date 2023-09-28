package com.huaizhu;

/**
 *
 */
public class 前缀树 {

    public static class Node1{
        public int pass; //经过的次数
        public int end;//是否此路径结尾
        public Node1[] next;

        public Node1() {
            this.pass = 0;
            this.end = 0;
            //0---->a
            //1---->b
            //....
            // next == null 没有路径
            // next != null 有路径
            this.next = new Node1[26];//有26个字符
        }
    }

    public static class Trie{
        public Node1 root;
        public Trie(Node1 node1) {
            this.root = node1;
        }

        public void insert(String word){
            if(word == null){
                return;
            }
            char[] str = word.toCharArray();
            Node1 node = root;
            node.pass ++;
            int path = 0;
            for (char c : str) {
                path = c - 'a'; //走哪条路径
                if (node.next[path] == null) {
                    node.next[path] = new Node1();
                }
                node = node.next[path];
                node.pass++;
            }
            node.end++;
        }

        public int search(String  word){
            if(word == null){
                return 0;
            }
            char[] str = word.toCharArray();
            Node1 node = root;
            int path = 0;
            for (char c : str) {
                path = c - 'a';
                if (node.next[path] == null) {
                    return 0;
                }
                node = node.next[path];
            }
            return node.end;
        }

        public int prfixSearch(String pre){
            if(pre == null){
                return 0;
            }
            char[] str = pre.toCharArray();
            Node1 node = root;
            int path = 0;
            for (char c : str) {
                path = c - 'a';
                if (node.next[path] == null) {
                    return 0;
                }
                node = node.next[path];
            }
            return node.pass;
        }

        public void delete(String word){
            if(word == null){
                return;
            }
            if(search(word) != 0){
                char[] str = word.toCharArray();
                Node1 node = root;
                node.pass--;
                int path = 0;
                for(char c:str){
                    path = c- 'a';
                    if(--node.next[path].pass == 0){
                        node.next[path] = null;
                        return;
                    }
                    node = node.next[path];
                }
                node.end--;
            }

        }

    }
}
