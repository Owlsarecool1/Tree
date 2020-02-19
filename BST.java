import java.util.ArrayList;
import java.util.Scanner;
public class BST {
    private class Node{
        private int value;
        private Node left;
        private Node right;
        public Node (int x)
        {
            value=x;
            left=null;
            right=null;
        }
        public int getValue()
        {
            return value;
        }
        public Node getLeft()
        {
            return left;
        }
        public Node getRight()
        {
            return right;
        }
    }
    private Node root;

    public BST()
    {
        root=null;
    }
    public int getRoot()
    {
        if(root==null)
            return 0;
        else
            return root.getValue();
    }
    public int getCount()
    {
        return getCount(root);
    }
    private int getCount(Node N)
    {
        if (N==null)
        {
            return 0;
        }
        else
        {
            return 1 + (getCount(N.left)+getCount(N.right));
        }
    }
    //public int findLevel(int x)
    //{
        //if(root==null)
            //return -1;
        //else
           // return findLevel

        //return
    //}
    //private int findlevel(Node N,int x,int level)
    //{

        //return
    //}

    public boolean add(int x)
    {
        if (root==null)
        {
            root=new Node(x);
            return true;
        }
        else
        {
            add(root,x);
        }
        return false;

    }
    private boolean add(Node N,int x)
    {
        if(x==N.value)
        {
            return false;
        }
        else
        {
            if(x<N.value)
            {
                if(N.left==null)
                {
                    N.left=new Node(x);
                    return true;
                }
                else
                {
                    add(N.left,x);
                }
            }
            else
            {
                if(N.right==null)
                {
                    N.right=new Node(x);
                    return true;
                }
                else
                {
                    add(N.right,x);
                }
            }
        }
        return false;

    }
    public  void print ()
    {
        if(root==null)
            System.out.println("Empty List");
        else
            print(root);

    }
    private void print(Node N)
    {
        if(N==null)
        {
            return;
        }
        else
        {
            print(N.left);
            System.out.print(N.value+",");
            print(N.right);
        }

    }
    public int getHeight()
    {
        return getHeight(root);
    }
    private int getHeight(Node N)
    {
        if (N==null)
            return 0;
        else
            return 1+((getHeight(N.left)>getHeight(N.right))?getHeight(N.left):getHeight(N.right));
    }

    public boolean remove(int x)
    {

        return remove(root,x);
    }
    public Node minimumKey(Node curr)
    {
        while(curr.left != null){
            curr=curr.left;
        }
        return curr;
    }
    private boolean remove(Node root,int key) {
        Node parent = null;
        Node curr = root;
        while (curr != null && curr.value != key) {
            parent = curr;
            if (key < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (curr == null) {
            return false;
        }
        if (curr.left == null && curr.right == null) {
            if (curr != root) {
                if (parent.left == curr) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else {
                root = null;
            }

        } else if (curr.left != null && curr.right != null) {
            Node successor = minimumKey(curr.right);
            int val = successor.value;
            remove(root, successor.value);
            curr.value = val;
        } else {
            Node child = (curr.left != null) ? curr.left : curr.right;
            if (curr != root) {
                if (curr == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            } else {
                root = child;
            }
        }
        return true;
    }
    public void display () {
        String[] A = new String[32];
        for (int i = 0; i < 32; i++)
            A[i] = ".";
        String temp;
        if (root == null)
            temp = ".";
        else
            temp = Integer.toString(root.value);
        A[1] = temp;

        buildArray(root, A, 1);
        //System.out.println("  1   2 3 4 5 7 8 9 0");
        //System.out.println("1234567890123456789012345678901234567890123456789012345678901234567" +
                //"89012345678901234567890");
        System.out.println("                                                                                          " +
                "   ");
        System.out.println("                                                 " + A[1] + " " +
                "   ");
        System.out.println("                                                |                      " +
                "");
        System.out.println("                       " + A[2] + "-------------------------^-----------------" +
                "------" + A[3]);
        System.out.println("                       |           " +
                "                                      |");
        System.out.println("           " + A[4] + "-----------^-----------" + A[5] + "" +
                "                         " + A[6] + "-----------^-----------" + A[7]);
        System.out.println("           |                       |                         |" +
                "                       |");
        System.out.println("    " + A[8] + "----^----" + A[9] + "               " + A[10] + "----^----" + A[11] + "               " +
                A[12] + "----^----" + A[13] + "             " + A[14] + "----^----" + A[15]);
        System.out.println("    |         |               |         |               |         |" +
                "             |         |");
        System.out.println("  "+A[16] + "-^-" + A[17] + "     " + A[18] + "-^-" + A[19] + "         " + A[20] + "-^-" + A[21] +"       "+A[22]+ "-^-" + A[23] + "           " +
                A[24] + "-^-" + A[25] + "     " + A[26] + "-^-"+A[27] + "         " + A[28] + "-^-" + A[29] + "     " + A[30] + "-^-" + A[31]);

        System.out.println("                                                                                " +
                "");
    }






    private void buildArray(Node n,String[] strArray,int parentIndex)
    {
        if (parentIndex * 2+1>strArray.length)
            return;
        if(n==null)
            return;
        else
        {
            String temp;
            if(n.left==null)
                temp = " . ";
            else

                temp=Integer.toString(n.left.value);
            strArray[parentIndex*2]=String.format("%3s",temp);
            buildArray(n.left,strArray,parentIndex*2);
            if (n.right==null)
                temp=" . ";
            else
                temp=Integer.toString(n.right.value);
            strArray[parentIndex*2+1] = String.format("%3s",temp);
            buildArray(n.right,strArray,parentIndex*2+1);

        }
    }
    public static void main(String[]args)
    {
        Scanner in=new Scanner(System.in);
        BST word=new BST();
        while(true) {
            word.display();
            word.print();
            System.out.println("\n Tree height:" + word.getHeight());
            if (word.getRoot() == 0)
                System.out.println("No root: Tree is empty");
            else
                System.out.println("Tree root:" + word.getRoot());
            System.out.println("Tree count:" + word.getCount());
            System.out.println("(A)dd item (R)emove item (E)mpty tree (D)efault tree (Q)uit");
            System.out.print("Enter choice:");
            String letter = in.next();
            if (letter.compareTo("A") == 0) {
                System.out.println("Enter integer to add to tree:");
                int number = in.nextInt();
                word.add(number);
            } else if (letter.compareTo("R") == 0) {
                System.out.println("Enter integer to remove:");
                int number = in.nextInt();
                System.out.println(number + "was removed from tree");
                word.remove(number);
            } else if (letter.compareTo("E") == 0) {
                word = new BST();
            } else if (letter.compareTo("D") == 0) {
                int List[] = {500, 205, 150, 120, 102, 134, 187, 169, 201, 250, 230, 210, 235, 402, 263, 410, 750, 604, 570, 562, 583, 691, 621, 699, 834, 794, 775, 799, 925, 852, 960};
                for (int i = 0; i < List.length; i++) {
                    word.add(List[i]);
                }
            }
            else if (letter.compareTo("Q")==0)
            {
                break;
            }


        }
    }
}
