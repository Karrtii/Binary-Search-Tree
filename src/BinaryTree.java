import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree
{
  BinaryTreeNode root;

  public BinaryTreeNode getRoot()
  {
    return root;
  }

  public void setRoot(BinaryTreeNode root)
  {
    this.root = root;
  }

  public boolean isEmpty()
  {
    if(root == null)
      return true;

      return false;
  }

  public int size()
  {
    return size(root);
  }

  private int size(BinaryTreeNode node)
  {
    if (node == null)
      return 0;

    return (size(node.left) + 1 + size(node.right));
  }

  public int height()
  {
      return heightOfNode(root);
  }

  private int heightOfNode(BinaryTreeNode node)
  {
    if(node == null)
      return -1;

    int leftChild = heightOfNode(node.left);
    int rightChild = heightOfNode(node.right);

    if(leftChild > rightChild)
    {
      return leftChild + 1;
    }
    else
    {
      return rightChild + 1;
    }
  }

  public boolean contains(int element) {
    return containsNode(root, element);
  }

  private boolean containsNode(BinaryTreeNode current, int value) {
    if (current == null) {
      return false;
    }
    if (value == current.element) {
      return true;
    }

    if (value < current.element)
    {
      return containsNode(current.left,value);
    }
    else
      {
        return containsNode(current.right,value);
      }
  }

  public ArrayList<Integer> inOrder()
  {
    ArrayList<Integer> result = new ArrayList<>();
    Stack<BinaryTreeNode> stack = new Stack<>();

    BinaryTreeNode element = root;

    while (element != null)
    {
      stack.push(element);
      element = element.left;
    }

    while (!stack.isEmpty())
    {
      BinaryTreeNode t = stack.pop();
      result.add(t.getElement());

      t = t.right;
      while (t != null)
      {
        stack.push(t);
        t = t.left;
      }
    }
    return result;
  }

  public ArrayList<Integer> preOrder()
  {
    ArrayList<Integer> result = new ArrayList<>();

    if(root == null)
    {
      return result;
    }

    Stack<BinaryTreeNode> stack = new Stack<>();
    stack.push(root);

    while(!stack.isEmpty())
    {
      BinaryTreeNode t = stack.pop();
      result.add(t.getElement());

      if (t.right != null)
      {
        stack.push(t.right);
      }

      if(t.left != null)
      {
        stack.push(t.left);
      }
    }
    return result;
  }

  public ArrayList<Integer> postOrder()
  {
    ArrayList<Integer> inOrderList = new ArrayList<>();

    if(root == null)
    {
      return inOrderList;
    }

    Stack<BinaryTreeNode> stack = new Stack<>();
    stack.push(root);

    BinaryTreeNode previous = null;

    while(!stack.isEmpty())
    {
      BinaryTreeNode current = stack.peek();

      if(previous == null || previous.left == current || previous.right == current)
      {
        if(current.left != null)
        {
          stack.push(current.left);
        }
        else if(current.right != null)
        {
          stack.push(current.right);
        }
      }
      else if(current.left == previous)
    {
      if(current.right != null)
      {
        stack.push(current.right);
      }
    }
    else
    {
      inOrderList.add(current.getElement());
      stack.pop();
    }
      previous=current;
    }
    return inOrderList;
  }

  public ArrayList<ArrayList<Integer>> levelOrder()
  {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    if (root == null)
    {
      return result;
    }

    ArrayList<BinaryTreeNode> list = new ArrayList<>();

    list.add(root);

    while(!list.isEmpty())
    {
      ArrayList<BinaryTreeNode> list2 = new ArrayList<>();
      ArrayList<Integer> level = new ArrayList<>();

      while(!list.isEmpty())
      {
        BinaryTreeNode node = list.remove(0);
        level.add(node.getElement());
        if(node.left!=null)
        {
          list2.add((node.left));
        }
        if(node.right!=null)
        {
          list2.add(node.right);
        }
      }
      result.add(level);
      list = list2;
    }
    return result;
  }

}
