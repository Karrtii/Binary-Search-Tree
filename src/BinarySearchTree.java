import java.util.List;
import java.util.Vector;

public class BinarySearchTree extends BinaryTree
{
  public void removeElement(int element)
  {
    root = deleteFromNode(root,element);
  }

  private BinaryTreeNode deleteFromNode(BinaryTreeNode node, int element)
  {
    if(node == null)
      return null;

    if (element < node.element)
    {
      node.left = deleteFromNode(node.left,element);
    }
    else if(element > node.element)
    {
      node.right = deleteFromNode(node.right,element);
    }
    else
    {
      if (node.left == null)
        return node.right;

      else if (node.right == null)
        return  node.left;

      node.element = minValueNode(node.right);

      node.right = deleteFromNode(node.right,node.element);
    }
    return node;
  }

  public void insert(int element)
  {
    root = insertNode(root,element);
  }

  private BinaryTreeNode insertNode(BinaryTreeNode node, int element)
  {
    if (node == null)
    {
      node = new BinaryTreeNode(element);
      return node;
    }

    if (element < node.element)
      node.left = insertNode(node.left,element);
    else if (element > node.element)
      node.right = insertNode(node.right,element);

    return node;
  }

  private int minValueNode(BinaryTreeNode root)  {
    int minval = root.element;

    while (root.left != null)  {
      minval = root.left.element;
      root = root.left;
    }
    return minval;
  }

  public int findMin()
  {
    return minValueNode(root);
  }

  private int maxValue(BinaryTreeNode node)
  {
    BinaryTreeNode current = node;
    while (current.right != null)
      current = current.right;

    return (current.element);
  }

  public int findMax()
  {
    return maxValue(root);
  }

  public void rebalance() {
    if (2 >= size()) return;

    root = build(inOrder(), 0, size() - 1);
  }

  private BinaryTreeNode build(List<Integer> elements, int low, int high) {
    if (low > high) return null;

    int mid = (high - low) / 2 + low;
    BinaryTreeNode curr = new BinaryTreeNode(elements.get(mid));
    curr.left = build(elements, low, mid - 1);
    curr.right = build(elements, mid + 1, high);
    return curr;
  }

}
