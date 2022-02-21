package RealTimePRactice;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
    @Test
    public void streamMap(){
        ArrayList<String> names=new ArrayList<String>();
        names.add("Jyoti");
        names.add("Nath");
        names.add("Pnath");

        //print names which has last letter as "a" with uppercase

        Stream.of("Abhijeet","Don","Akilaya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
                .forEach(s->System.out.println(s));

        //print names which have first letter as a with uppercase and sorted
        List<String> name1=Arrays.asList("Abhijeet","Don","Akilaya","Adam","Rama");
        name1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

        //merging 2 different lists
        Stream<String> newStream=Stream.concat(names.stream(),name1.stream());
        boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
        Assert.assertTrue(flag);
        System.out.println(flag);
    }

    @Test
    public void streamCollect(){
        //To get the 1st element from the list
        List<String> ls=Stream.of("Abhijeet","Don","Akilaya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));

        //To print the distinct numbers from the list
        List<Integer> values=Arrays.asList(3,2,2,7,5,1,9,7);
        values.stream().distinct().forEach(s->System.out.println(s));

        List<Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(4));
    }
}
