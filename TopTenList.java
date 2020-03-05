import java.io.*;
import java.util.*;

public class TopTenList {
    public final static int MAX = 10;
    private LinkNode front = null;
    LinkNode current = null;
    LinkNode nextr = null;
    int count = 0;

    public TopTenList() {
        front = null;
    }

    public TopTenList(String fileName) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        while (file.hasNextLine()) {
            count++;
            String name = file.nextLine().trim();
            LinkNode element = new LinkNode(count, name);
            // System.out.println(name);
            if (front == null) {
                front = element;
                current = element;
            } else {
                current.setNext(element);
            }
            current = element;
            // System.out.println(current.getSong());
        }
    }

    void printChart() {
        System.out.println("\n***** TOP TEN CHART **********\n");
        current = front;
        for (int i = 1; i <= count; i++) {
            System.out.printf("%4d%26s\n", current.getPosition(), current.getSong());
            current = current.getNext();
        }
    }

    String getSong(int position) {
        String name = "ERROR";
        LinkNode t = front;
        if (position < 1 || position > count)
            return name;
        else {
            for (int i = 1; i < position; i++)
                t = t.getNext();
            name = t.getSong();
            return name;
        }
    }

    int getPosition(String song) {
        current = front;
        int pos = 0;
        while (current != null) {
            if (current.getSong().equalsIgnoreCase(song))
                pos = current.getPosition();
            current = current.getNext();
        }

        return pos;
    }

    void adjustPosition(LinkNode e, int position) {
        if (e != null)
            while (e != null) {
                e.setPosition(e.getPosition() + position);
                e = e.getNext();
            }
    }

    boolean deleteSong(int position) {
        current = front;
        if(position == count)
        {
            current = front;
            if(count == 1)
            {
                front = null;
                count = 0;
            }
            else
            {
                while(current != null)
                {
                    if(current.next.getPosition() == position)
                    {
                        current.next = null;
                        count--;
                    }
                    else if(front.next == null)
                    {
                        front = null;
                        count--;
                    }
                    current = current.next;
                }
            }
        }
        else if(position == 1)
        {
            front = current.next;
            count--;
        }
        else
        {
            current = front;
            while (current.next != null) {
                if (current.next.getPosition() == position) {
                    current.next = current.next.next;
                    count--;
                    //System.out.println("hahahahahahaha" +current.getSong());
                }
                current = current.next;
            }
        }
        current = front;
        int counter = 1;
        while(current != null)
        {
            current.setPosition(counter);
            counter++;
            current = current.next;
        }
        return true;
    }

    boolean insertSong(int position, String song) {
        if(count == 10)
        {
            System.out.println("Already 10 songs in list.");
        }
        else if(position == 1)
        {
            current = front;
            if(count == 0)
            {
                LinkNode temp = new LinkNode(position, song);
                front = temp;
                front.next = null;
                count++;
            }
            else
            {
                while(current.next != null)
                {
                    if(current.getPosition() == position)
                    {
                        LinkNode temp = new LinkNode(position, song);
                        temp.next = current;
                        front = temp;
                        current = current.next;
                        count++;
                    }
                    current = current.next;
                }
            }
        }
        else if(position == count+1)
        {
            int maxCount = 0;
            current = front;
            while(current != null)
            {
                if(current.next == null  && maxCount < 1)
                {
                    LinkNode temp = new LinkNode(position, song);
                    current.next = temp;
                    temp.next = null;
                    count++;
                    maxCount++;
                }
                current = current.next;
            }
        }
        else
        {
            current = front;
            while (current.next != null)
            {
                if (current.next.getPosition() == position)
                {
                    LinkNode nextr = current.next;
                    LinkNode temp = new LinkNode(position, song);
                    temp.next = nextr;
                    current.next = temp;
                    count++;
                    current = current.next;
                }
                current = current.next;
            }
        }
        current = front;
        int counter = 1;
        while(current != null)
        {
            current.setPosition(counter);
            counter++;
            current = current.next;
        }
        return true;
    }

    boolean moveSong(int oldPosition, int newPosition) {
        String theSong = getSong(oldPosition);
        deleteSong(oldPosition);
        insertSong(newPosition, theSong);
        return true;
    }
}