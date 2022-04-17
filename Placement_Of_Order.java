import java.util.*;
import java.lang.Thread;

interface Queue {
    public void add(Object obj);

    public Object first();

    public Object remove();

    public int size();

}

public class Placement_Of_Order extends Thread implements Queue {

    private static class Node {
        Object object;
        Node prev = this, next = this;

        Node(Object obj) {
            this.object = obj;
        }

        Node(Object obj, Node prev, Node next) {
            this.object = obj;
            this.prev = prev;
            this.next = next;
        }

    }

    private int size;
    private Node head = new Node(null);

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Object first() {
        if (size == 0)
            throw new IllegalStateException("No any Order Placed");
        // System.out.println("nno any order placed");
        return head.next.object;
    }

    public void add(Object obj) {
        head.prev.next = new Node(obj, head.prev, head);
        head.prev = head.prev.next;
        size++;
    }

    public Object remove() {
        if (size == 0)
            throw new IllegalStateException("No any Order Placed");
        Object obj = head.next.object;
        head.next = head.next.next;
        head.next.prev = head;
        --size;
        return obj;
    }

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        Placement_Of_Order lq = new Placement_Of_Order();
        String s = " ",q=" ", frame = " "; // s=yes/no,food=french fries, etc;
        int i = 0;
        int quant = 0; // quant= food quantity, i= order no. , totalmoney= money of complete order.
        long totalmoney = 1;
        System.out.println("\n\n\t\t\t\t^-^     ^-^     ^-^     ^-^     ^-^     ^-^     ^-^     ^-^     ^-^     ^-^     ^-^     ");
        System.out.println("\n\n\t\t | \t^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^           MENU           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ \t | \n\t\t ^  \t\t\t\t\t\t\t\t\t\t\t\t\t\t ^ ");
        System.out.println(
                "\n\n\t\t | \t\t\t\t\tShadow Box Frame= 40 pkr  \t\t\t\t\t\t | \n\n\t\t | \t\t\t\t\t\tDecorative Frame= 80 pkr \t\t\t\t\t | \n\n\t\t | \t\t\t\t\tStandard Frame= 60 pkr \t\t\t\t\t\t\t | \n\n\t\t | \t\t\t\t\t\tFloating Frame= 50 pkr \t\t\t\t\t\t | \n\n\t\t | \t\t\t\t\tCollage Frame= 70 pkr \t\t\t\t\t\t\t | \n\n\t\t | \t\t\t\t\t\tPoster Frame= 40 pkr \t\t\t\t\t\t | \n\n\t\t | \t\t\t\t\tTable Top Frame= 40 pkr \t\t\t\t\t\t | \n\n\t\t | \t\t\t\t\t\tDocument Frame= 40 pkr \t\t\t\t\t\t | \n\n\t\t | \t\t\t\t\tCrystal Frame= 40 pkr \t\t\t\t\t\t\t | \n\n");
                System.out.println("\n\t\t | \t^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ \t | \n\t\t ^  \t\t\t\t\t\t\t\t\t\t\t\t\t\t ^ ");

                System.out.println("\n\n\t\t\t\t ^-^     ^-^     ^-^     ^-^     ^-^     ^-^     ^-^     ^-^     ^-^     ^-^     ^-^     \n\n\n\n");

        do {


            do {
                
            System.out.println("\t\tPlease Place your Order!\n\n");

                System.out.println("\t\tWhat do you want to order?");
                frame = obj.next();
                obj.nextLine();

                System.out.println("\n\t\tHow many?");
                quant = obj.nextInt();
                if (frame.equalsIgnoreCase("Shadow Box ")) {
                    int k = 40;
                    totalmoney = k * quant;
                } else if (frame.equalsIgnoreCase("Decorative")) {
                    int k = 80;
                    totalmoney = k * quant;
                } else if (frame.equalsIgnoreCase("Standard")) {
                    int k = 60;
                    totalmoney = k * quant;
                } else if (frame.equalsIgnoreCase("Floating")) {
                    int k = 50;
                    totalmoney = k * quant;
                } else if (frame.equalsIgnoreCase("Collage")) {
                    int k = 70;
                    totalmoney = k * quant;
                }else if (frame.equalsIgnoreCase("Poster")) {
                    int k = 70;
                    totalmoney = k * quant;
                }
                else if (frame.equalsIgnoreCase("Table Top")) {
                    int k = 70;
                    totalmoney = k * quant;
                }
                else if (frame.equalsIgnoreCase("Document")) {
                    int k = 70;
                    totalmoney = k * quant;
                }
                else if (frame.equalsIgnoreCase("Crystal")) {
                    int k = 70;
                    totalmoney = k * quant;
                }

                System.out.println("\t\t\t\t\n\t\tDo you want to order more(yes/no)?");
                s = obj.next();

            } while (s.equalsIgnoreCase("yes"));

            System.out.println("\n\n\n\t\tYour Order no is " + (++i) + ". Please pay " + totalmoney
                    + "  pkr at the counter, Please wait a few minutes for receiving your order.  ");
            lq.add("Order no: " + (i));
            System.out.println("\n\n\n\t\t\t\t\t\t^-^  ^-^  ^-^  ^-^  ^-^  ^-^  ^-^  ^-^  ^-^  ^-^  ^-^     ");

          System.out.println("\n\t\t\t\t\t\t\t\t HAVE A NICE DAY  >_<\n\t\t\t");
          System.out.println("\n\t\t\t\t\t\t^-^  ^-^  ^-^  ^-^  ^-^  ^-^  ^-^  ^-^  ^-^  ^-^  ^-^   \n\n  ");

            System.out.println("\n\t\tAre there any more orders to take(yes/no)?");
            q = obj.next();

        } while (q.equalsIgnoreCase("yes"));

        if (lq.size == 1) {
            System.out.println(lq.size + " Order is being prepared");
        } else {
            System.out.println(lq.size + " Orders are being prepared");
        }

        try {
            for (int j = 1; j <= i; j++) {

                sleep(5000);
                System.out.println("\n\n");
                System.out.println(lq.remove() + " is prepared, please collect it from the counter!\n");
            }
        } catch (Exception e) {
        }

    }

}
