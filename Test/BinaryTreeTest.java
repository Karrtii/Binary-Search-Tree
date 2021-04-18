import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest
{
  BinaryTree binaryTree;
  @BeforeEach
  public void SetUp()
  {
    binaryTree = new BinaryTree();
  }

  @Test
  public void setRoot()
  {
    binaryTree.setRoot(new BinaryTreeNode(5));
    assertEquals(binaryTree.getRoot().element,5);
  }

  @Test
  public void isEmptyTrue()
  {
    assertEquals(binaryTree.isEmpty(),true);
  }

  @Test
  public void isEmptyFalse()
  {
    binaryTree.setRoot(new BinaryTreeNode(5));
    assertEquals(binaryTree.isEmpty(),false);
  }

  @Test
  public void sizeZero()
  {
    assertEquals(binaryTree.size(),0);
  }

  @Test
  public void sizeOne()
  {
    binaryTree.setRoot(new BinaryTreeNode(1));
    assertEquals(binaryTree.size(),1);
  }

  @Test
  public void sizeMany()
  {
    BinaryTreeNode one = new BinaryTreeNode(1);
    BinaryTreeNode two = new BinaryTreeNode(2);
    BinaryTreeNode three = new BinaryTreeNode(3);
    one.left = two;
    one.right = three;
    binaryTree.setRoot(one);
    assertEquals(binaryTree.size(),3);
  }

  @Test
  public void heightZero()
  {
    assertEquals(binaryTree.height(),-1);
  }

  @Test
  public void heightOne()
  {
    binaryTree.setRoot(new BinaryTreeNode(1));
    assertEquals(binaryTree.height(),0);
  }

  @Test
  public void heightMany()
  {
    BinaryTreeNode one = new BinaryTreeNode(1);
    BinaryTreeNode two = new BinaryTreeNode(2);
    BinaryTreeNode three = new BinaryTreeNode(3);
    one.right = two;
    one.left = three;
    binaryTree.setRoot(one);
    assertEquals(binaryTree.height(),1);
  }

  @Test
  public void containsFalse()
  {
    assertEquals(binaryTree.contains(5),false);
  }

  @Test
  public void containsTrue()
  {
    binaryTree.setRoot(new BinaryTreeNode(5));
    assertEquals(binaryTree.contains(5),true);
  }

  @Test
  public void inOrder()
  {
    BinaryTreeNode one = new BinaryTreeNode(1);
    BinaryTreeNode two = new BinaryTreeNode(2);
    BinaryTreeNode three = new BinaryTreeNode(3);
    BinaryTreeNode four = new BinaryTreeNode(4);
    BinaryTreeNode five = new BinaryTreeNode(5);

    one.right = three;
    one.left = two;
    two.right = five;
    two.left = four;

    binaryTree.setRoot(one);
    assertEquals(binaryTree.inOrder(),new ArrayList<Integer>(List.of(4,2,5,1,3)));
  }

  @Test
  public void preOrder()
  {
    BinaryTreeNode one = new BinaryTreeNode(1);
    BinaryTreeNode two = new BinaryTreeNode(2);
    BinaryTreeNode three = new BinaryTreeNode(3);
    BinaryTreeNode four = new BinaryTreeNode(4);
    BinaryTreeNode five = new BinaryTreeNode(5);

    one.right = three;
    one.left = two;
    two.right = five;
    two.left = four;

    binaryTree.setRoot(one);
    assertEquals(binaryTree.preOrder(),new ArrayList<Integer>(List.of(1,2,4,5,3)));
  }

  @Test
  public void postOrder()
  {
    BinaryTreeNode one = new BinaryTreeNode(1);
    BinaryTreeNode two = new BinaryTreeNode(2);
    BinaryTreeNode three = new BinaryTreeNode(3);
    BinaryTreeNode four = new BinaryTreeNode(4);
    BinaryTreeNode five = new BinaryTreeNode(5);

    one.right = three;
    one.left = two;
    two.right = five;
    two.left = four;

    binaryTree.setRoot(one);
    assertEquals(binaryTree.postOrder(),new ArrayList<Integer>(List.of(4,5,2,3,1)));
  }

  @Test
  public void levelOrder()
  {
    BinaryTreeNode one = new BinaryTreeNode(1);
    BinaryTreeNode two = new BinaryTreeNode(2);
    BinaryTreeNode three = new BinaryTreeNode(3);
    BinaryTreeNode four = new BinaryTreeNode(4);
    BinaryTreeNode five = new BinaryTreeNode(5);

    one.right = three;
    one.left = two;
    two.right = five;
    two.left = four;

    binaryTree.setRoot(one);
    ArrayList list = new ArrayList();
    ArrayList oneA = new ArrayList(List.of(1));
    ArrayList twoA = new ArrayList(List.of(2,3));
    ArrayList threeA = new ArrayList(List.of(4,5));

    list.add(oneA);
    list.add(twoA);
    list.add(threeA);

    assertEquals(binaryTree.levelOrder(),list);
  }

}
