package com.skd.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: virgosnail
 * @Date: 2020/4/12 19:48
 */
public class CreateCode {

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("E:\\project\\SpringBootDemo\\basic\\src\\main\\resource\\key.txt"));
        String temp = "";
        Set<String> set = new HashSet();
        try {
            while(true){
                String s = br.readLine();
                temp =s;
                String[] s1 = s.split(" ");

                String[] split = s1[0].split("\\.");
                int len = split.length;
                StringBuilder sb = new StringBuilder();
                for(int i =len-1;i>0;i--){
                    if(i <(len-1)){
                        sb.append(split[i].toString().toUpperCase()).append("_");
                    }else{
                        sb.append(split[i]);
                    }

                }
                String key1 = split[len-3].toString().toUpperCase();
                String key2 = split[len-2].toString().toUpperCase();
                String key3 = split[len-1].toString().toUpperCase();
                String key = key1+ "_" + key2 + "_" + key3;
                System.out.println("// " + s1[1]);
                System.out.println( "public static String " + key + " = \"" + s +"\";" );
            }
        }catch(Exception e){
            System.out.println(temp);
        }
    }
}
