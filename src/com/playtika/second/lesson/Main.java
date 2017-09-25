package com.playtika.second.lesson;

import com.sun.deploy.util.ArrayUtil;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ////////////////////////////////////print
        System.out.println("start\"\'\t\n\rend");
        System.out.println("________________________________________________________-");
        ///////////////////////////////compere

        String token = null;
        if ("HTML".equals(token)){
            System.out.println("ok");
        }
        System.out.println("________________________________________________________-");

        ////////////////////////////compose
        String location = "Kiev";
        String name = "Andrew";
        double money = 10.6;
        String fullName = String.format("%s Sevruk : from %S has %f", name, location, money);

        String allInfo = new StringBuilder()
                .append(name)
                .append("Sevruk")
                .append(money).toString();


        System.out.println(fullName);

        System.out.println("________________________________________________________");

        //////////////////////find
        String text = "I have 5 dollars";

        System.out.printf("Found in : %s", + text.indexOf("have"));
        System.out.println();
        System.out.printf("Found in : %s", + text.indexOf("has"));
        System.out.println();
        System.out.println(text.matches(".*5.*"));

        System.out.println("________________________________________________________");
        /////////////////////////////////split
        System.out.println(Arrays.toString(text.split(" ")));

        System.out.println("________________________________________________________");


        StringTokenizer tokenizer = new StringTokenizer(text, " ", false);
        System.out.println(tokenizer.countTokens());

        while (tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }

        System.out.println("________________________________________________________");
        //1.String
        //2.Apache Commons Lang  - String Utils
        //3.Strings - Guava



        ////////////////////////////////Collections////////////////////////////////

        //array
        int[] numbers = new int[] {10,2,3,4,5};
        String[] str1 = new String[6];
        System.out.println(numbers.length);
        System.out.println(str1.length);

        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));

        Arrays.fill(numbers,4);

        System.out.println(Arrays.toString(numbers));

        System.out.println("__________________________________________");

        //List --- has a order, has all values

        List<String> list= new ArrayList<>(10);
        System.out.println(list.size());

        list.add("1");
        System.out.println(list.get(0));
        //list.set(3,"2");
        list.clear();
        System.out.println(list.size());

        Object[] o = list.toArray();

        String[] st2 = list.toArray(new String[list.size()]);

        //Set --- does not has a order, and does not contains dublicate, can not garanted the order

        Set<String> set  = new HashSet<>();

        set.add("a");
        set.add("b");
        set.add("a");
        System.out.println(set.size());
        //iter
        for (String s : set) {
            System.out.println(s);
        }

        //Map
        Map<String,Integer> stats = new HashMap<>();
        stats.put("have" , 5);
        stats.put("has" , 2);

        System.out.println(stats);
        System.out.println(stats.size());

        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }

        for (Integer integer : stats.values()) {
            System.out.println(integer+1);
        }

        //queue

        Queue<String> q = new ArrayDeque<>();

        q.add("I");
        q.add("He");

        System.out.println(q.poll());
        System.out.println(q.poll());

        System.out.println("__________________________________________");
        System.out.println("__________________________________________");
        System.out.println("__________________________________________");

        //exception

        try {
            int result = prinHello("Andrew");
            prinHello(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } finally {
            System.out.println("close important resurses");
        }


    }

    public  static int prinHello(String name)  {
        if (name == null) {
            throw new RuntimeException("name is requared");
        }
        System.out.println("Hello " + name);
        return name.length();
    }

    public  int countOfWords(String test){
        if (test == null) {
            throw new RuntimeException("text can`t be null");
        }
        if (test == "") {
            return 0;
        }
        return  test.split(" ").length;
    }
}
