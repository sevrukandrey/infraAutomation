package com.playtika.third.lesson;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static com.google.common.collect.ImmutableMap.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {


    @Test
    public void wordFreqAreReturnedForText() {
        Map<String, Integer> frequencies =
                Main.getFrequencies("Hello world hello");
        assertThat(frequencies).isNotEmpty();
        assertThat(frequencies).isNotNull();



    }

    @Test
    public void assertFreqPresent() {
        Map<String, Integer> frequencies =
                Main.getFrequencies("Hello world hello");

        Map<String, Integer> d = new HashMap<>();
      //  HashMap <String, Integer> map2 = Maps.of("1",1,"2","");


        assertThat(frequencies).hasSize(1).containsEntry("1",1).containsEntry("2",1);

        ////1.Подготовитьь мапу ожидаемых результато, и проверить лжидпеиую с аернувшийся

    }


    /*************************************************************************/


   @Test(expected = IllegalArgumentException.class, timeout = 10)
    public void nullTExtCouldNotBeProcess(){
       Main.getFrequencies(null);

   }



   /**************************************************************************************************************/
                                          /*    <GENERICS>

                                           */
   public static void main(String[] args)  {

        Set<String> items = new HashSet<>();

       items.add("a");

       for (String item : items) {
           System.out.println(item);




       }





/******************************************************FILES*******************************************************/

        File file = new File("defaultText.txt");

       System.out.println(file.exists());
       System.out.println(file.canRead());

       try {
           Reader reader = new InputStreamReader(new FileInputStream(file));


           List<String> lines =  Files.readAllLines(file.toPath());
           System.out.println(lines.size());
           for (String line : lines) {
               System.out.println(line);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }


   }

///InputStrem streen read byte
// Reader read character
// Lines for read line



}
