package RealTimePRactice;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Filter_Map_Collect {

    @Test
    public void countNumber(){
        ArrayList<String> names=new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Akilaya");
        names.add("Adam");
        names.add("Ram");
        int count=0;
        for (int i=0; i<names.size();i++){

            String actual=names.get(i);
            if(actual.startsWith("A")){
                count++;
            }

        }
        System.out.println(count);

    }

    @Test
    public void streamFilter(){
        ArrayList<String> names=new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Akilaya");
        names.add("Adam");
        names.add("Ram");

        long c=names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);

        long d=Stream.of("Abhijeet","Don","Akilaya","Adam","Ram").filter(s->
        {
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(d);

        //print all the names which has greater that 4 in arrayList wh
        names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
        System.out.println("================");
        //print the 1st name which is having greater than 4
        names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));




    }
}
