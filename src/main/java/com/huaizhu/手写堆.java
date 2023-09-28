package com.huaizhu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

/**
 * 加强堆
 */
public class 手写堆<T> {



    public ArrayList<T> heap;
    public HashMap<T,Integer> indexMap = new HashMap<>();
    public Integer heapSize;
    public Comparator<T> comparator;

    public 手写堆(ArrayList<T> heap, HashMap<T, Integer> indexMap, Integer heapSize, Comparator<T> comparator) {
        this.heap = heap;
        this.indexMap = indexMap;
        this.heapSize = heapSize;
        this.comparator = comparator;
    }

    public Integer size(){
        return heapSize;
    }

    public void push(T obj){
        heapSize ++;
        heapInsert(indexMap.get(obj));
    }

    public T pop(){
        T obj = heap.get(0);
        swap(0,heapSize-1);
        indexMap.remove(obj);
        heap.remove(--heapSize);
        heapify(0);
        return obj;
    }

    public void remove(T obj){
        Integer objIndex = indexMap.get(obj);
        T replace = heap.get(heapSize-1);
        indexMap.remove(obj);
        heap.remove(--heapSize);
        if(obj != replace){
            heap.set(objIndex,replace);
            indexMap.put(replace,objIndex);
            resign(obj);
        }
    }

    public void resign(T obj){
        Integer index = indexMap.get(obj);
        heapInsert(index);
        heapify(index);
    }

    public void heapInsert(int index){
        while (comparator.compare(heap.get(index),heap.get((index-1)/2)) < 0){
            swap(index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public void heapify(int index){
        int left = index *2 +1;
        while (left < heapSize){
            int lagest = left+1 < heapSize && comparator.compare(heap.get(left+1),heap.get(left)) < 0 ? left+1 : left;
            lagest = comparator.compare(heap.get(lagest),heap.get(index)) < 0 ? lagest : index;
            if (lagest == index){
                break;
            }
            index = lagest;
            left = index * 2 + 1;
        }
    }




    public void swap(int i,int j){
        T iobj = heap.get(i);
        T jobj = heap.get(j);
        heap.set(i,jobj);
        heap.set(j,iobj);
        indexMap.put(iobj,j);
        indexMap.put(jobj,i);
    }


}
