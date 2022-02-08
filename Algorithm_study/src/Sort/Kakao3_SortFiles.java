package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Kakao3_SortFiles {
// 1 2 3 18 통과, 나머지 런타임 에러
//    https://programmers.co.kr/learn/courses/30/lessons/17686
    class File{
        String head ="";
        String number ="";
        String tail = "";
        int index=0;

        public File(String f,int index) {
            this.index = index;
//            f = f.substring(0,f.length()-4);  //.txt 제거
            f = f.toLowerCase(Locale.ROOT);
            char[]arr = f.toCharArray();
            for(int i=0;i<f.length();i++){
                if(f.charAt(i) >=97 && f.charAt(i)  <= 122 || f.charAt(i) ==45){
                    head += arr[i];
                }else{
                    f = f.substring(i,f.length());
                    break;
                }
            }
            //숫자
            for(int i=0;i<f.length();i++){
               if( f.charAt(i) >=48 && f.charAt(i) <=57){
                   number += f.charAt(i);
               }
               else{
                   if(f.charAt(i) == 46) break;
                   tail = f.substring(i,f.length());
                   break;
               }
            }
            //완성된 number에서 앞에 0이 있으면 제거
            if(number.charAt(0) == '0') number = number.substring(1);
            number = number.trim();
        }

    }
    public List<String> solution(String[] files) {
        List<String> answer = new ArrayList<>();
        List<File> list = new ArrayList<>();
//        System.out.println('-'-0 + "++");
        System.out.println('.'-0);

        for(int i=0;i<files.length;i++){
//            System.out.println("~~~ " +);
            File f =new File(files[i],i );
            list.add(f);
            System.out.println(f.index + "  " + f.head + " "+ f.number + "  " + f.tail);
        }

        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if(o1.head.compareTo(o2.head) == 0) {
                    if(o1.number.compareTo(o2.number) == 0){
                        if(o1.tail == o2.tail){
                            return o1.index - o2.index;
                        }
                        return o1.tail.compareTo(o2.tail);
                    }
                    return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
                }
               return o1.head.compareTo(o2.head);
            }
        });
        for(File f : list){
//            System.out.println(f.index + "  " + f.head + " "+ f.number + "  " + f.tail);
//            answer.add(files[f.index]);
            System.out.println(files[f.index]);
        }

        return answer;
    }


}


