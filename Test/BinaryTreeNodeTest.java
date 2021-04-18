import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest
{
  @Test
  public void nodeSetElementNumber() {
    int element = 5;
    BinaryTreeNode node = new BinaryTreeNode();
    node.setElement(element);
    assertEquals(element, node.getElement());
  }

  @Test
  public void addLeftChild() {
    BinaryTreeNode node = new BinaryTreeNode(5);
    BinaryTreeNode left = new BinaryTreeNode(4);
    node.addLeftChild(left);

    assertEquals(left, node.getLeftChild());
    assertEquals(left.getElement(), node.getLeftChild().getElement());
  }

  @Test
  public void addRightChild() {
    BinaryTreeNode node = new BinaryTreeNode(5);
    BinaryTreeNode right = new BinaryTreeNode(4);
    node.addRightChild(right);

    assertEquals(right, node.getRightChild());
    assertEquals(right.getElement(), node.getRightChild().getElement());
  }

}