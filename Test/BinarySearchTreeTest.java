import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest
{
  BinarySearchTree binarySearchTree;

  @BeforeEach
  public void SetUp()
  {
    binarySearchTree = new BinarySearchTree();
  }

  @Test
  public void insert()
  {
    binarySearchTree.insert(5);
    assertEquals(binarySearchTree.getRoot().element,5);
  }

  @Test
  public void removeElement()
  {
    binarySearchTree.insert(5);
    binarySearchTree.removeElement(5);
    assertEquals(binarySearchTree.isEmpty(),true);
  }

  @Test
  public void findMin()
  {
    binarySearchTree.insert(90);
    binarySearchTree.insert(80);
    binarySearchTree.insert(70);
    assertEquals(binarySearchTree.findMin(),70);
  }

  @Test
  public void findMax()
  {
    binarySearchTree.insert(90);
    binarySearchTree.insert(80);
    binarySearchTree.insert(70);
    assertEquals(binarySearchTree.findMax(),90);
  }

  @Test
  public void rebalance()
  {
    binarySearchTree.insert(4);
    binarySearchTree.insert(3);
    binarySearchTree.insert(5);
    binarySearchTree.insert(2);
    binarySearchTree.insert(6);
    binarySearchTree.insert(1);
    binarySearchTree.insert(7);

    binarySearchTree.rebalance();

    assertEquals(binarySearchTree.levelOrder(),new ArrayList(List.of(new ArrayList(List.of(4)), new ArrayList(List.of(2,6)), new ArrayList(List.of(1,3,5,7)))));

  }
}