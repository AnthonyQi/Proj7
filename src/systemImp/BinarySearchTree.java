package systemImp;


import java.util.Stack;

import java.util.LinkedList;  //only use this if you assign to a Queue variable
import java.util.Queue;

/**
 * A simple generic Binary Search Tree (BST) implementation
 * that supports basic insertion, traversal operations, etc.
 * This version models a Set: nodes store keys only.
 *
 * @param <K> the key type, which must be Comparable
 */
public class BinarySearchTree<K extends Comparable<K>> {
    
    /**
     * Inner class representing a node in the BST.
     */
    private class Node {
        private K key;
        private Node left, right;

        private Node(K key) {
            this.key = key;
        }
    }

    private Node root;

    public boolean add(K key) {
    	if(key == null) {
    		throw new NullPointerException("No null values");
    	}
    	if (root == null) {
            root = new Node(key);
            return true;
        } else {
            return addAux(key, root);
        }
    }
    
    private boolean addAux(K key, Node root) {
    	int comp = key.compareTo(root.key);
        if(comp == 0) {
            root.key = key;
            return false;
        } 
        else if(comp < 0) {
            if(root.left == null) {
                root.left = new Node(key);
                return true;
            } 
            else {
                return addAux(key, root.left);
            }
        } 
        else {
            if(root.right == null) {
                root.right = new Node(key);
                return true;
            } 
            else {
                return addAux(key, root.right);
            }
        }
    }
    
    //BFS: breadth first search
    public String toString() {
    	if (root == null) {
    		return "Empty Tree";
    	}
        StringBuilder log = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean hasChild = false;
            log.append("Level ").append(level).append("   ");
            for(int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if(curr != null) {
                    log.append(curr.key).append(" ");
                    if(curr.left != null) {
                        queue.add(curr.left);
                        hasChild = true;
                    } 
                    else {
                        queue.add(null);
                    }
                    if(curr.right != null) {
                        queue.add(curr.right);
                        hasChild = true;
                    } 
                    else {
                        queue.add(null);
                    }
                } 
                else {
                    log.append("null ");
                    queue.add(null);
                    queue.add(null);
                }
            }
            if(!hasChild) { 
                break;
            }
            log.append("\n");
            level++;
        }
        return log.append("\n").toString(); 
    }
    
    //just calls the auxiliary method to return the string
    public String inOrder() {
    	return inOrderAux(root);
    }
    
    //should return the left nodes, then the root, and then the right nodes
    private String inOrderAux(Node root) {
        return root == null ? ""
        		: inOrderAux(root.left)
        		+ root.key + " "
        		+ inOrderAux(root.right);
    }
    
    public String inorderNonRecursive() {
    	StringBuilder log = new StringBuilder();
    	if(root == null) {
    		return "";
    	}
    	//stack is LIFO
    	Stack<Node> st = new Stack<Node>();
    	Node curr = root;
    	while(curr != null || !st.isEmpty()) {
    		//goes to the leftmost node
    		//will attempt this every time it goes up in the tree.
    		while(curr != null) {
    			st.push(curr);
    			curr = curr.left;
    		}
    		curr = st.pop();
    		log.append(curr.key + " ");
    		//tries to see if there is a right child node
    		curr = curr.right;
    	}
    	return log.toString();
    }
    
    //just calls the auxiliary method to return the string
    public String preOrder() {
    	return preOrderAux(root);
    }
    
    //helper method that uses ternary operators to correctly recursively loop
    //through the tree
    //should return the root, then left nodes and finally the right nodes
    private String preOrderAux(Node root) {
        return root == null ? ""
        		: root.key + " "
        		+ preOrderAux(root.left)
        		+ preOrderAux(root.right);
    }
    
    public String preorderNonRecursive() {
    	StringBuilder log = new StringBuilder();
    	if(root == null) {
    		return "";
    	}
    	//stack is LIFO
    	Stack<Node> st = new Stack<Node>();
    	//push the root onto the stack
        st.push(root);
    	while(!st.isEmpty()) {
    		//get the latest node
    		Node curr = st.pop();
    		//add the current element
    		//unlike inOrder, preOrder adds parent nodes first then children
            log.append(curr.key + " ");
    		if (curr.right != null) {
                st.push(curr.right);
            }
            if (curr.left != null) {
                st.push(curr.left);
            }
    	}
    	return log.toString();    
    }

    //just calls the auxiliary method method and returns the string
    public String postOrder() {
    	return postOrderAux(root);
    }
    
    //helper method that uses ternary operators to correctly recursively loop
    //through the tree
    //should return all left nodes first then right nodes and finally the root
    private String postOrderAux(Node root) {
    	return root == null ? ""
    			: postOrderAux(root.left)
    			+ postOrderAux(root.right)
    			+ root.key + " ";
    }
    
    public String postorderNonRecursive() {
    	StringBuilder log = new StringBuilder();
        if(root == null) {
        	return "";
        }
    	//stack is LIFO
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
    	//push the root onto the stack
        st1.push(root);
        while(!st1.isEmpty()) {
    		//get the latest node
            Node curr = st1.pop();
            //adds current node to the second stack in order to add in 
    		//post order
            st2.push(curr);

            if(curr.left != null) {
            	st1.push(curr.left);
            }
            if(curr.right != null) {
            	st1.push(curr.right);
            }
        }
        //second while loop to add everything in the correct order
    	//post order adds children first before the parent node like in order
    	//but adds the root node last
        while(!st2.isEmpty()) {
            log.append(st2.pop().key + " ");
        }
        return log.toString(); 
    }

    //finds the min through a recursive helper
    public K min() {
    	if(root == null) {
    		return null;
    	}
    	return minAux(root);
    }
    
    private K minAux(Node root) {
    	if(root.left == null) {
        	return root.key;

    	}
    	return minAux(root.left);
    }
    
    //finds the max through a recursive helper
    public K max() {
    	if(root == null) {
    		return null;
    	}
    	return maxAux(root);
    }
    
    private K maxAux(Node root) {
    	if(root.right == null) {
        	return root.key;

    	}
    	return maxAux(root.right);
    }
    
    public boolean remove(K key, boolean preferLeft) {
    	if(!contains(root, key)) {
    		return false;
    	}
    	//re-references the root so that it doesn't lose its value
    	root = removeAux(root, key, preferLeft);
    	return true;
    }
    
    //simple search through tree, checking if the tree even contains the key
    //this is to save time
    private boolean contains(Node root, K key) {
        if(root == null) {
        	return false;
        }
        int comp = key.compareTo(root.key);
        if(comp < 0) {
        	return contains(root.left, key);
        }
        else if(comp > 0){
        	return contains(root.right, key);
        }
        //return true after matching the compareTo values
        return true;
    }
    
    private Node removeAux(Node root, K key, boolean preferLeft) {
    	if(root == null) {
            return null;
        } 
    	//finds the compareTo value, to get the specific root
        int comp = root.key.compareTo(key);
        //does a check again
        if(comp < 0) {
            root.right = removeAux(root.right, key, preferLeft);
        } 
        else if(comp > 0) {
            root.left = removeAux(root.left, key, preferLeft);
        } 
        //if the comparison check is equal to 0
        else {
        	//these checks maintain the nodes and their links
        	//checks if the children are null, if so it returns a null node
            if(root.left == null && root.right == null) {
                return null;
            }
            //checks if left is null, then returns the right node as null
            if(root.left == null) {
                return root.right;
            }
            //same thing but does it with the right side.
            if(root.right == null) {
                return root.left;
            }
            if((preferLeft && root.left != null) 
            		|| (!preferLeft && root.right == null)) {
            	//use the auxiliary to find the max from a specific node
                K p = maxAux(root.left);
                root.key = p;
                //does it again, this time to move the nodes
                root.left = removeAux(root.left, p, preferLeft);
            } 
            else if((!preferLeft && root.right != null) 
            		|| (preferLeft && root.left == null)){
            	//use the auxiliary to find the minimum from a specific node
                K s = minAux(root.right);
                //swaps the root key and the minimum key
                root.key = s;
                root.right = removeAux(root.right, s, preferLeft);
            }
        }
        return root;
    }
    
    //gets the height to then use in the auxiliary method to see if each branch 
    //is level
    public boolean isPerfect() {
    	if(root == null) {
    		return true;
    	}
    	int h = getHeight(root);
    	return isPerfectAux(root, 0, h);
    }
    
    //helper method that gets the depth of the leftmost path
    private int getHeight(Node root) {
    	if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    
    //another helper to then check children based on the depth.
    private boolean isPerfectAux(Node root, int index, int h) {
    	//checks when both are null if it is at the right length
    	if(root.left == null && root.right == null) {
            return index + 1 == h;
        }
        //checks if internal node has only one child
        if(root.left == null || root.right == null) {
        	return false;
        }
        return isPerfectAux(root.left, index + 1, h)
                && isPerfectAux(root.right, index + 1, h);
    }
    
    //supposed to find if every node is filled up, so no null except maybe the 
    //last row which if filled from left to right should be complete
    public boolean isComplete() {
        if(root == null) {
        	return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean hasNull = false;
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            //checks if the current node is null
            if(curr == null) {
            	hasNull = true;
            } 
            else {
                if(hasNull) {
                    return false;
                }
                //if the current node is not null, it will add the left and
                //right nodes which show up next in the queue
                //this helps with checking left to right
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return true;
    }
    
    //first checks for empty tree
    //then if uses the auxiliary method to check if all nodes have either 0 or 
    //2 children
    public boolean isFull() {
    	if(root == null) {
    		return true;
    	}
    	return isFullAux(root);
    }

    //helper to search through tree to see if any node has 0 or 2 children
    //return false if it has 1 child
    private boolean isFullAux(Node root) {
    	//if both null that means it has to be a leaf with no children
    	if(root.left == null && root.right == null) {
    		return true;
    	}
    	//this checks if both are not null
    	//if so then it calls itself again
    	//continues until it can figure out if the node has children or not
    	if(root.left != null && root.right != null) {
    		return isFullAux(root.left) && isFullAux(root.right);
        }
        return false;
    }

}

