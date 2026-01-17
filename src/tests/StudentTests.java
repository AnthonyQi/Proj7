package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import systemImp.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class StudentTests {
	
	@Test
	public void testAddAndToString() {
	    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
	    //testing add with null
	    try {
	    	bst.add(null);
	    } catch(Exception e) {
	    	String err1 = "No null values";
	    	assertEquals(err1, e.getMessage());
	    }
	    //testing when empty
	    String ans1 = "Empty Tree";
	    String res1 = bst.toString();
	    assertEquals(ans1, res1);
	    assertTrue(bst.add(4));
	    //testing duplicate element
	    assertFalse(bst.add(4));
	    assertTrue(bst.add(2));
	    assertTrue(bst.add(6));
	    assertTrue(bst.add(1));
	    bst.add(3);
	    bst.add(5);
	    bst.add(7);
	    //testing with perfect list
	    String ans2 = 
	        "Level 0   4 \n" +
	        "Level 1   2 6 \n" +
	        "Level 2   1 3 5 7 \n";
	    String res2 = bst.toString();
	    assertEquals(ans2, res2);
	    
	    //testing single node
	    BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
	    tree.add(5);
	    String ans3 = "Level 0   5 \n";
	    String res3 = tree.toString();
	    assertEquals(ans3, res3);
	    
	    //testing with nodes at the edge
	    tree.add(3);
	    tree.add(7);
	    tree.add(2);
	    tree.add(8);
	    String ans4 = 
	        "Level 0   5 \n" +
	        "Level 1   3 7 \n" +
	        "Level 2   2 null null 8 \n";
	    System.out.println(tree.toString());
	    String res4 = tree.toString();
	    assertEquals(ans4, res4);
	}
	
	//overall for both inOrder and inorderNonRecursive the output should be the
	//same
	@Test
    public void testInOrder() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        //testing empty
        String ans1 = "";
        String res1 = bst.inOrder();
        assertEquals(ans1, res1);
        bst.add(4);
        bst.add(2);
        bst.add(6);
        bst.add(1);
        bst.add(3);
        bst.add(5);
        bst.add(7);
        //testing with perfect list
        String ans2 = "1 2 3 4 5 6 7 ";
        String res2 = bst.inOrder();
        assertEquals(ans2, res2);
        //testing one node
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(5);
        String ans3 = "5 ";
        String res3 = tree.inOrder();
        assertEquals(ans3, res3);
        //testing with one branch
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        String ans4 = "1 2 3 4 5 ";
        String res4 = tree.inOrder();
        assertEquals(ans4, res4);
        BinarySearchTree<Integer> right = new BinarySearchTree<Integer>();
        right.add(5);
        right.add(6);
        right.add(7);
        right.add(8);
        right.add(9);
        right.add(10);
        String ans5 = "5 6 7 8 9 10 ";
        String res5 = right.inOrder();
        assertEquals(ans5, res5);
        //testing if both non-recursive and recursive output the same thing
        String inOrder = bst.inOrder();
        String inOrderNR = bst.inorderNonRecursive();
        assertEquals(inOrder, inOrderNR);
    }
	
	@Test
    public void testInorderNonRecursive() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        //testing empty
        String ans1 = "";
        String res1 = bst.inorderNonRecursive();
        assertEquals(ans1, res1);
        bst.add(4);
        bst.add(2);
        bst.add(6);
        bst.add(1);
        bst.add(3);
        bst.add(5);
        bst.add(7);
        //testing with perfect list
        String ans2 = "1 2 3 4 5 6 7 ";
        String res2 = bst.inorderNonRecursive();
        assertEquals(ans2, res2);
        //testing one node
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(5);
        String ans3 = "5 ";
        String res3 = tree.inorderNonRecursive();
        assertEquals(ans3, res3);
        //testing with one branch
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        String ans4 = "1 2 3 4 5 ";
        String res4 = tree.inorderNonRecursive();
        assertEquals(ans4, res4);
        //testing with right branch only
        BinarySearchTree<Integer> right = new BinarySearchTree<Integer>();
        right.add(5);
        right.add(6);
        right.add(7);
        right.add(8);
        right.add(9);
        right.add(10);
        String ans5 = "5 6 7 8 9 10 ";
        String res5 = right.inorderNonRecursive();
        assertEquals(ans5, res5);
    }
	
	//overall for both inOrder and inorderNonRecursive the output should be the
	//same
	@Test
	public void testPreOrder() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		//testing empty
		String ans1 = "";
		String res1 = bst.preOrder();
		assertEquals(ans1, res1);
		bst.add(4);
		bst.add(2);
		bst.add(6);
		bst.add(1);
		bst.add(3);
		bst.add(5);
		bst.add(7);
		//testing with perfect list
		String ans2 = "4 2 1 3 6 5 7 ";
		String res2 = bst.preOrder();
    	assertEquals(ans2, res2);
    	//testing one node
    	BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
    	tree.add(5);
    	String ans3 = "5 ";
    	String res3 = tree.preOrder();
    	assertEquals(ans3, res3);
    	//testing with one branch
    	tree.add(4);
    	tree.add(3);
    	tree.add(2);
    	tree.add(1);
    	String ans4 = "5 4 3 2 1 ";
    	String res4 = tree.preOrder();
    	assertEquals(ans4, res4);
    	BinarySearchTree<Integer> right = new BinarySearchTree<Integer>();
    	right.add(5);
    	right.add(6);
    	right.add(7);
    	right.add(8);
    	right.add(9);
    	right.add(10);
    	//for preOrder the insertion order should be the order of the 
    	//numbers
    	String ans5 = "5 6 7 8 9 10 ";
    	String res5 = right.preOrder();
    	assertEquals(ans5, res5);
    	//testing if both non-recursive and recursive output the same thing
    	String preOrder = bst.preOrder();
    	String preOrderNR = bst.preorderNonRecursive();
    	assertEquals(preOrder, preOrderNR);
	}
				
	@Test
	public void testPreorderNonRecursive() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		//testing empty
		String ans1 = "";
		String res1 = bst.preorderNonRecursive();
		assertEquals(ans1, res1);
		bst.add(4);
		bst.add(2);
		bst.add(6);
		bst.add(1);
		bst.add(3);
		bst.add(5);
		bst.add(7);
		//testing with perfect list
		String ans2 = "4 2 1 3 6 5 7 ";
		String res2 = bst.preorderNonRecursive();
		assertEquals(ans2, res2);
		//testing one node
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(5);
		String ans3 = "5 ";
		String res3 = tree.preorderNonRecursive();
		assertEquals(ans3, res3);
		//testing with one branch
		tree.add(4);
		tree.add(3);
		tree.add(2);
		tree.add(1);
		String ans4 = "5 4 3 2 1 ";
		String res4 = tree.preorderNonRecursive();
		assertEquals(ans4, res4);
		//testing with right branch only
		BinarySearchTree<Integer> right = new BinarySearchTree<Integer>();
		right.add(5);
		right.add(6);
		right.add(7);
		right.add(8);
		right.add(9);
		right.add(10);
		//should be same order as inOrder
		String ans5 = "5 6 7 8 9 10 ";
		String res5 = right.preorderNonRecursive();
		assertEquals(ans5, res5);
	}
	
	@Test
	public void testPostOrder() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		//testing empty
		String ans1 = "";
		String res1 = bst.postOrder();
		assertEquals(ans1, res1);
		bst.add(4);
		bst.add(2);
		bst.add(6);
		bst.add(1);
		bst.add(3);
		bst.add(5);
		bst.add(7);
		//testing with perfect list
		String ans2 = "1 3 2 5 7 6 4 ";
		String res2 = bst.postOrder();
    	assertEquals(ans2, res2);
    	//testing one node
    	BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
    	tree.add(5);
    	String ans3 = "5 ";
    	String res3 = tree.postOrder();
    	assertEquals(ans3, res3);
    	//testing with one branch
    	tree.add(4);
    	tree.add(3);
    	tree.add(2);
    	tree.add(1);
    	String ans4 = "1 2 3 4 5 ";
    	String res4 = tree.postOrder();
    	assertEquals(ans4, res4);
    	BinarySearchTree<Integer> right = new BinarySearchTree<Integer>();
    	right.add(5);
    	right.add(6);
    	right.add(7);
    	right.add(8);
    	right.add(9);
    	right.add(10);
    	//for preOrder the insertion order should be the order of the 
    	//numbers
    	String ans5 = "10 9 8 7 6 5 ";
    	String res5 = right.postOrder();
    	assertEquals(ans5, res5);
    	//testing if both non-recursive and recursive output the same thing
    	String preOrder = bst.postOrder();
    	String preOrderNR = bst.postorderNonRecursive();
    	assertEquals(preOrder, preOrderNR);
	}
				
	@Test
	public void testPostorderNonRecursive() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		//testing empty
		String ans1 = "";
		String res1 = bst.postorderNonRecursive();
		assertEquals(ans1, res1);
		bst.add(4);
		bst.add(2);
		bst.add(6);
		bst.add(1);
		bst.add(3);
		bst.add(5);
		bst.add(7);
		//testing with perfect list
		String ans2 = "1 3 2 5 7 6 4 ";
		String res2 = bst.postorderNonRecursive();
		assertEquals(ans2, res2);
		//testing one node
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(5);
		String ans3 = "5 ";
		String res3 = tree.postorderNonRecursive();
		assertEquals(ans3, res3);
		//testing with one branch
		tree.add(4);
		tree.add(3);
		tree.add(2);
		tree.add(1);
		String ans4 = "1 2 3 4 5 ";
		String res4 = tree.postorderNonRecursive();
		assertEquals(ans4, res4);
		//testing with right branch only
		BinarySearchTree<Integer> right = new BinarySearchTree<Integer>();
		right.add(5);
		right.add(6);
		right.add(7);
		right.add(8);
		right.add(9);
		right.add(10);
		//should be same order as inOrder
		String ans5 = "10 9 8 7 6 5 ";
		String res5 = right.postorderNonRecursive();
		assertEquals(ans5, res5);
	}
	
	@Test
	public void testMinMax() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		//testing when empty
		assertNull(bst.min());
		assertNull(bst.max());
		//testing with a valid list
		bst.add(3);
		//testing with just root
		Integer min1 = 3;
		Integer max1 = 3;
		assertEquals(min1, bst.min());
		assertEquals(max1, bst.max());
		assertEquals(min1, max1);
		bst.add(2);
		bst.add(6);
		bst.add(1);
		bst.add(4);
		bst.add(5);
		bst.add(7);
		Integer min2 = 1;
		Integer max2 = 7;
		assertEquals(min2, bst.min());
		assertEquals(max2, bst.max());
	}
	
	@Test
	public void testRemove() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		//testing with empty list
		//the preferLeft boolean shouldn't matter here
		assertFalse(bst.remove(null, false));
		assertFalse(bst.remove(0, false));
		bst.add(0);
		//testing with one node
		//first with wrong key
		assertFalse(bst.remove(5, false));
		//removing the root node
		assertTrue(bst.remove(0, false));
		bst.add(0);
		bst.add(-10);
		//testing with only a left branch
		//preferLeft set to false so it should try to move the right subtree to
		//the root
		assertTrue(bst.remove(0, false));
		//preferLeft set to true. should remove accordingly
		bst.add(-15);
		bst.add(-20);
		assertTrue(bst.remove(-15, true));
		String res1 = bst.toString();
		String ans1 = "Level 0   -10 \n"
					+ "Level 1   -20 null \n";
		assertEquals(ans1, res1);
		//testing leftPrefers boolean
		assertTrue(bst.remove(-10, false));
		String res2 = bst.toString();
		String ans2 = "Level 0   -20 \n";
		assertEquals(ans2, res2);
		bst.add(-10);
		//testing if it removes regardless of whether or not it has any sub
		//trees
		assertTrue(bst.remove(-20, true));
		String res3 = bst.toString();
		String ans3 = "Level 0   -10 \n";
		assertEquals(ans3, res3);
		System.out.println(bst.toString());
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(10);
		tree.add(5);
		tree.add(15);
		tree.add(12);
		tree.add(18);
		assertTrue(tree.remove(10, true));
		String res4 = tree.toString();
		String ans4 = "Level 0   5 \n"
				+ "Level 1   null 15 \n"
				+ "Level 2   null null 12 18 \n";
		assertEquals(ans4, res4);
		//testing remove with a leaf node
		BinarySearchTree<Integer> list = new BinarySearchTree<Integer>();
		list.add(10);
		list.add(5);
		list.add(15);
		assertTrue(list.remove(5, true));
		//testing when there is only the right subtree
		assertTrue(list.remove(10, true));
		String res5 = list.toString();
		String ans5 = "Level 0   15 \n";
		assertEquals(ans5, res5);
		//testing with  internal node with one child
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		test.add(20);
		test.add(10);
		test.add(30);
		test.add(5);
		assertTrue(test.remove(10, false));
	}
	
	@Test
	public void testPerfectTree() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		//this should be a perfect tree
		assertTrue(bst.isPerfect());
		bst.add(5);
		//testing with one element
		assertTrue(bst.isPerfect());
		//missing one child
		bst.add(2);
		assertFalse(bst.isPerfect());
		bst.add(7);
		assertTrue(bst.isPerfect());
		bst.add(1);
		bst.add(3);
		bst.add(6);
		bst.add(9);
		assertTrue(bst.isPerfect());
		//testing inside branches as well as adding another level
		bst.add(4);
		assertFalse(bst.isPerfect());
		//adding 3 more elements that creates one more branch in one direction
		//but then 2 more levels that are greater than -5
		bst.add(-5);
		bst.add(-4);
		bst.add(-3);
		assertFalse(bst.isPerfect());
		//testing odd case
		BinarySearchTree<Integer> bin = new BinarySearchTree<Integer>();
		bin.add(5);
		bin.add(4);
		bin.add(3);
		bin.add(2);
		bin.add(1);
		bin.add(0);
		assertFalse(bin.isPerfect());
		//removing right internal node
		BinarySearchTree<Integer> ary = new BinarySearchTree<Integer>();
		ary.add(0);
		ary.add(-10);
		ary.add(10);
		ary.add(-15);
		ary.add(5);
		ary.add(15);
		ary.add(12);
		ary.add(17);
		//false for preferLeft
		assertTrue(ary.remove(15, false));
		String ans6 = "Level 0   0 \n"
				+ "Level 1   -10 10 \n"
				+ "Level 2   -15 null 5 17 \n"
				+ "Level 3   null null null null null null 12 null \n";
		//should move the 17 up
		String res6 = ary.toString();
		System.out.println(res6);
		assertEquals(ans6, res6);
		//removing the 17 with preferLeft set to true
		assertTrue(ary.remove(17, true));
		String ans7 = "Level 0   0 \n"
				+ "Level 1   -10 10 \n"
				+ "Level 2   -15 null 5 12 \n";
		String res7 = ary.toString();
		System.out.println(res7);
		assertEquals(ans7, res7);
		//testing preferLeft with a null left node
		assertTrue(ary.add(14));
		System.out.println(ary.toString());
		assertTrue(ary.remove(12, true));
		String ans8 = "Level 0   0 \n"
				+ "Level 1   -10 10 \n"
				+ "Level 2   -15 null 5 14 \n";
		String res8 = ary.toString();
		System.out.println(ary.toString());
		assertEquals(ans8, res8);
	}
	
	@Test
	public void testCompleteTree() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		//this should be a perfect tree
		assertTrue(bst.isComplete());
		bst.add(5);
		assertTrue(bst.isComplete());
		//adding one element, should still return regardless of all children
		bst.add(0);
		assertTrue(bst.isComplete());
		bst.add(10);
		assertTrue(bst.isComplete());
		//adding another level without completing the current level
		bst.add(-5);
		bst.add(-2);
		assertFalse(bst.isComplete());
		/*
		 * to complete, need to get rid of all the nulls
		 * where -5 is currently sitting on
		 * wont be complete until all null nodes are set to integers
		 * last row is completed from left to right
		 * no null elements in between
		 */
		bst.add(2);
		bst.add(7);
		bst.add(15);
		bst.add(1);
		bst.add(6);
		bst.add(-10);
		bst.add(4);
		System.out.println(bst.toString());
		assertTrue(bst.isComplete());
		//adding one element with null in between elements
		bst.add(20);
		System.out.println(bst.toString());
		assertFalse(bst.isComplete());
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		//testing when there is a value in one of the middle levels on the 
		//rightmost side that is null
		tree.add(0);
		tree.add(-10);
		tree.add(10);
		tree.add(-15);
		tree.add(-5);
		tree.add(5);
		tree.add(-17);
		tree.add(-12);
		tree.add(-7);
		tree.add(-3);
		tree.add(3);
		tree.add(8);
		System.out.println(tree.toString());
		assertFalse(tree.isComplete());
	}
	
	@Test
	public void testIsFull() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		//testing when empty
		assertTrue(bst.isFull());
		bst.add(0);
		assertTrue(bst.isFull());
		//adding one branch
		bst.add(-10);
		assertFalse(bst.isFull());
		//adding another branch
		bst.add(10);
		assertTrue(bst.isFull());
		//unbalanced tree
		bst.add(-15);
		bst.add(-5);
		//should still be full
		assertTrue(bst.isFull());
	}
}