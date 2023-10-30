package exercises;

import java.util.HashMap;

public class exercises9 {

    /**
     * 已知一个消息流会不断地吐出整数1～N
     * 但不一定按照顺序依次吐出
     * 如果上次打印的序号为i,那么当i+1出现时
     * 请打印i+1及其之后接受过的并且连续的所有数
     * 直到1～N全部接受并打印完
     * 请设计这种接受并打印的结构
     */

    public static class Node {
        private String info;
        private Node next;

        public Node(String str) {
            info = str;
        }
    }

    public static class MessageBox {
        private final HashMap<Integer, Node> headMap;
        private final HashMap<Integer, Node> tailMap;
        private int waitPoint;

        public MessageBox() {
            headMap = new HashMap<>();
            tailMap = new HashMap<>();
            waitPoint = 1;
        }

        //num 消息的编号
        //info 消息体
        public void receive(int num,String info){
            if(num < 1){
                return;
            }
            Node cur = new Node(info);
            headMap.put(num,cur);
            tailMap.put(num,cur);

            if(tailMap.containsKey(num-1)){
                Node pre = tailMap.get(num - 1);
                pre.next = cur;
                tailMap.remove(num-1);
                headMap.remove(num);
            }

            if(headMap.containsKey(num+1)){
                cur.next = headMap.get(num+1);
                headMap.remove(num+1);
                tailMap.remove(num);
            }

            if(num == waitPoint){
                print();
            }
        }

        public  void print(){
            Node node = headMap.get(waitPoint);
            headMap.remove(waitPoint);
            while (node != null){
                System.out.print(node.info);
                node = node.next;
                waitPoint ++;
            }
            tailMap.remove(waitPoint-1);
            System.out.println();
        }
    }

}
