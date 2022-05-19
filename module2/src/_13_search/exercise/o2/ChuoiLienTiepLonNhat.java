package _13_search.exercise.o2;

import java.util.LinkedList;
import java.util.Scanner;

public class ChuoiLienTiepLonNhat {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Input your string: ");
        String input= scanner.nextLine();
        LinkedList<Character> res= new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            LinkedList<Character> list= new LinkedList<>();
            list.add(input.charAt(i));

            for (int j = i+1; j < input.length(); j++) {
                if(input.charAt(j) == list.getLast()+ 1)
                    list.add(input.charAt(j));
                else
                    break;
            }

            if(list.size() > res.size()){
                res.clear();
                res.addAll(list);
            }
            list.clear();
        }

        res.forEach(System.out::print);
    }
}
