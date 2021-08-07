import java.util.ArrayList;
import java.util.List;

public class dummy {


    public static void main(String[] args) {

        List<Integer> appleList = new ArrayList<>();
        appleList.add(-2);
        appleList.add(2);
        appleList.add(1);

        List<Integer> orangeList = new ArrayList<>();
        orangeList.add(5);
        orangeList.add(-6);


        countApplesAndOranges(7,11, 5,15, appleList, orangeList);
    }

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        List<Integer> newApplesList = new ArrayList<>();
        List<Integer> newOrangesList = new ArrayList<>();
        int appleCounter = 0;
        int orangeCounter = 0;

        for (int apple: apples) {
            newApplesList.add(apple+a);
        }

        for (int orange: oranges) {
            newOrangesList.add(orange+b);
        }

        for(int newApple: newApplesList){
            if(newApple>=s && newApple<=t){
                appleCounter++;
            }
        }

        for(int newOrange: newOrangesList){
            if(newOrange>=s && newOrange<=t){
                orangeCounter++;
            }
        }

        System.out.println(appleCounter);
        System.out.println(orangeCounter);
    }
}
