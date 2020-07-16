import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Grocery
{

    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        ArrayList<String> List= new ArrayList<>();
        String item, s, t;
        int a, i, n;
        boolean flag = true;
//        For text file creation
        FileWriter write=new FileWriter("C:\\Users\\richy\\OneDrive\\Desktop\\Grocery List.txt");
        BufferedWriter bf=new BufferedWriter(write);
        PrintWriter prnt=new PrintWriter(bf);
//        Intro
        System.out.println("Grocer List-\n");
        System.out.println("Choose an option below:\n" +
                "1. add item\t\t\t4. show the list\n2. remove item\t\t5. download list\n3. modify item\t\t0. exit");
//        Choose any option
        while(true)
        {
            System.out.print("\nNext: ");
            a = in.nextInt();
//            Add item
            if (a==1) {
                System.out.print("Add: ");
                List.add(in.next());
                System.out.println("Item enlisted.");
            }
//            Remove item
            if (a==2) {
                System.out.print("Item to be removed: ");
                item = in.next();
//                To check if input is item name or item number
                s="";
                s += item.charAt(item.length()-1);
                for (i=0; i<10; i++) {
                    t = String.valueOf(i);
                    if (s.equals(t)) {
                        i = Integer.parseInt(item);
                        List.remove(i-1);
                        break;
                    }
                }
                List.remove(item);
                System.out.println("Item deleted.");
            }
//            Modify item
            if (a==3) {
                System.out.print("Item to be edited: ");
                item = in.next();
                n = -2;
//                To check if input is item name or item number
                s="";
                s += item.charAt(item.length()-1);
                for (i=0; i<10; i++) {
                    t = String.valueOf(i);
                    if (s.equals(t)) {
                        n = (Integer.parseInt(item))-1;
                        System.out.print("New item: ");
                        List.add(n, in.next());
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    n = List.indexOf(item);
                    System.out.print("New item: ");
                    List.add(n, in.next());
                    flag = false;
                }
                System.out.println(n);
                if (!flag)
                    List.remove(n+1);
                System.out.println("Item modified.");
            }
//            Print list
            if (a==4){
                System.out.println("Your Grocery List: ");
                for (i=0; i<List.size(); i++)
                System.out.println((i+1)+": "+List.get(i));
            }
//            Download the List
            if (a==5){
                prnt.println("Your Grocery List: ");
                for (i=0; i<List.size(); i++)
                    prnt.println((i+1)+": "+List.get(i));
                System.out.println("File Downloaded.");
                prnt.close();
            }
//            Exit
            if (a==0){
                System.out.println("\nGoodbye..");
                break;
            }
        }
    }
}