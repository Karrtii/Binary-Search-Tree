import java.util.ArrayList;

public class Main
{
  public static void main(String[] args)
  {

    BinarySearchTree binarySearchTree = new BinarySearchTree();

    binarySearchTree.insert(4);
    binarySearchTree.insert(3);
    binarySearchTree.insert(5);
    binarySearchTree.insert(2);
    binarySearchTree.insert(6);
    binarySearchTree.insert(1);
    binarySearchTree.insert(7);



    ArrayList elements = binarySearchTree.levelOrder();
    for (var e : elements)
    {
      System.out.println(e);
    }

    binarySearchTree.rebalance();
    System.out.println("-------------------------");
    ArrayList elements1 = binarySearchTree.levelOrder();

    for (var b : elements1)
    {
      System.out.println(b);
    }

  }
}
