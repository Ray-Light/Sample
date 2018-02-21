/*
 *  Java Program to Implement Sorted Doubly Linked List
 *  This program takes Integer values as input from the user and then stores them as a Sorted Doubly Linked List in ascending order
 *  It also deletes an element in a mentioned position and calculates the size of the Sorted List
 *  Moreover, it also checks if the List is empty
 */


import org.checkerframework.checker.nullness.qual.Nullable;    //Importing package for adding type annotation
import java.util.Scanner;    //Importing package for using Scanner class
 
/*  Class Node  */
class Node
{
    protected int data;

    @Nullable protected Node next;    //next can have null value
    @Nullable protected Node prev;    //prev can have null value

 
    /* Default Constructor to initialize the values */
    public Node()
    {
        next = null;
        prev = null;
        data = 0;
    }

    /* Parameterized Constructor to initialize the values; here both n and p can have null value */
    public Node(int d, @Nullable Node n, @Nullable Node p)   
    {
        data = d;
        next = n;
        prev = p;
    }

    /* Function to set link to next node; Here n can be null */
    public void setLinkNext(@Nullable Node n)
    {
        next = n;
    }

    /* Function to set link to previous node; Here p can be null */
    public void setLinkPrev(@Nullable Node p)
    {
        prev = p;
    }

    /* Funtion to get link to next node; this function can return null value */
    public @Nullable Node getLinkNext()
    {
        return next;
    }

    /* Function to get link to previous node; this function can return null value */
    public @Nullable Node getLinkPrev()
    {
        return prev;
    }

    /* Function to set data to node */
    public void setData(int d)
    {
        data = d;
    }

    /* Function to get data from node */
    public int getData()
    {
        return data;
    }
}
 
/* Class linkedList */
class linkedList
{
    @Nullable protected Node start;    //start can have null value
    public int size;
 
    /* Default Constructor to initialize the values */
    public linkedList()
    {
        start = null;
        size = 0;
    }

    /* Function to check if list is empty */
    public boolean isEmpty()
    {
        return start == null;
    }

    /* Function to get size of list */
    public int getSize()
    {
        return size;
    }

    /* Function to insert element */
    public void insert(int val)
    {
        //Creating a temporary node with entered value
        Node nptr = new Node(val, null, null);   
        @Nullable Node tmp;    //tmp can have null value
        @Nullable Node ptr;    //ptr can have null value   
        boolean ins = false;

        
        if(start == null)    //If the list is empty
        {
            start = nptr;
        }
        else if (val <= start.getData())    //If the entered value is less than the first element in the sorted list   
        {
            nptr.setLinkNext(start);
            if(start != null)    //start can have null value which should be checked
            {
                start.setLinkPrev(nptr);
            }
            start = nptr;
        }
        else    //For other cases
        {
            tmp = start;
            ptr = start.getLinkNext();
            while(ptr != null)
            {
                if(val >= tmp.getData() && val <= ptr.getData())
                {
                    tmp.setLinkNext(nptr);
                    nptr.setLinkPrev(tmp);
                    nptr.setLinkNext(ptr);
                    ptr.setLinkPrev(nptr);
                    ins = true;
                    break;
                }
                else
                {
                    tmp = ptr;
                    ptr = ptr.getLinkNext();
                }
            }
            if(!ins)
            {
                tmp.setLinkNext(nptr);
                nptr.setLinkPrev(tmp);
 
            }
        }
        size++;    //Increasing the size of the list
    }

    /* Function to delete node at mentioned position */
    public void deleteAtPos(int pos)
    {   
        //Condition when pos = 1 i.e. for deleting the first element 
        if (pos == 1) 
        {
            if (size == 1)
            {
                start = null;
                size = 0;
                return; 
            }
            if(start != null)
            {
                start = start.getLinkNext();
                if(start != null)    //start can again have null value which should be checked
                {
                    start.setLinkPrev(null);
                }
                size--;
            } 
            return ;
        }

        //Condition when pos = size i.e. for deleting the last element
        if (pos == size) 
        {
            //Temporary node
            @Nullable Node ptr = start;    //ptr can have null value
 
            for (int i = 1; i < size - 1; i++)
            {
                if(ptr != null)    //ptr can have null value which needs to be checked
                {
                    ptr = ptr.getLinkNext();
                }
            }
            if(ptr != null)    //ptr can have null value which needs to be checked
            {
                ptr.setLinkNext(null);            
            }
            size --;
            return;
        }
        
        //For other cases
        if(start != null)    //start can have null value which needs to be checked
        {
            //Temporary node
            Node ptr = start.getLinkNext();

            for (int i = 2; i <= size; i++)
            {
                if (i == pos && ptr != null)
                {
                    //Temporary nodes
                    Node p = ptr.getLinkPrev();
                    Node n = ptr.getLinkNext();
                    if(p != null)    //p can have null value which needs to be checked
                    {
                        p.setLinkNext(n);
                    }
                    if(n != null)    //n can have null value which needs to be checked
                    {
                        n.setLinkPrev(p);
                    }
                    size-- ;
                    return;
                }

                if(ptr != null)    //ptr can have null value which needs to be checked
                {
                    ptr = ptr.getLinkNext();
                }
            }
        }        
    }

    /* Function to display status of list */
    public void display()
    {
        System.out.print("Doubly Linked List = ");

        //Check if the List is empty
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }

        //Check and print if there is only one element in the array
        if (start != null && start.getLinkNext() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        
        //For other cases
        //Temporary node
        @Nullable Node ptr = start;    //ptr can have null value which needs to be checked
        
        if(start != null)
        { 
            System.out.print(start.getData()+ " <-> ");
        }
        if(start != null)
        {
            ptr = start.getLinkNext();
        }

        while (ptr != null && ptr.getLinkNext() != null)    //ptr can have null value which needs to be checked
        {
            System.out.print(ptr.getData()+ " <-> ");
            ptr = ptr.getLinkNext();
        }
        
        if(ptr != null)    //ptr can have null value which needs to be checked
        {
            System.out.print(ptr.getData()+ "\n");
        }
    }
}
 
/* Class SortedDoublyLinkedList */
public class SortedDoublyLinkedList
{
    public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        linkedList list = new linkedList(); 
        System.out.println("Sorted Doubly Linked List Test\n");          
        char ch;
        /*  Perform list operations  */
        do
        {
            System.out.println("\nSorted Doubly Linked List Operations\n");
            System.out.println("1. insert");
            System.out.println("2. delete at position");
            System.out.println("3. check empty");
            System.out.println("4. get size");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.insert( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtPos(p);
                break;
            case 3 : 
                System.out.println("Empty status = "+ list.isEmpty()+"\n");
                break;                   
            case 4 : 
                System.out.println("Size = "+ list.getSize() +" \n");
                break;                         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            list.display();
            System.out.println("\nDo you want to continue (Type y to continue) \n");
            ch = scan.next().charAt(0);            
        } while (ch == 'Y'|| ch == 'y');               
    }    
}