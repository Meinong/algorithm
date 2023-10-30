package exercises;

import java.io.File;
import java.util.Stack;

public class exercises2 {

    /**
     * 题目：
     * 给定一个文件夹目录的路径
     * 写一个函数统计这个目录下所有的文件数量并返回
     * 隐藏文件也算，但是文件夹不算
     */
    public static int getFileNumber(String folderPath){
        File root = new File(folderPath);
        if(!root.isFile() && !root.isDirectory()){
            return 0;
        }
        if(root.isFile()){
            return 1;
        }
        Stack<File> stack = new Stack<>();
        stack.add(root);
        int files = 0;
        while (!stack.isEmpty()){
            File file = stack.pop();
            for (File next : file.listFiles()){
                if(next.isFile()){
                    files++;
                }else if (next.isDirectory()){
                    stack.push(next);
                }
            }
        }
        return files;
    }
}
