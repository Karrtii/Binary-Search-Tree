public class BinaryTreeNode
{
  int element;
  BinaryTreeNode left;
  BinaryTreeNode right;

  BinaryTreeNode(int element)
  {
    this.element = element;
  }

  BinaryTreeNode()
  {

  }

  public int getElement()
  {
    return element;
  }

  public void setElement(int element)
  {
    this.element = element;
  }

  public void addLeftChild(BinaryTreeNode element)
  {
    left = element;
  }

  public void addRightChild(BinaryTreeNode element)
  {
    right = element;
  }

  public BinaryTreeNode getLeftChild()
  {
    return left;
  }

  public BinaryTreeNode getRightChild()
  {
    return right;
  }
}
