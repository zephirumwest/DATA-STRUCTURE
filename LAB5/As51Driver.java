// sample driver
//
// CCO 2103-01, Spring 2023
//
// Assignment 5

class As51Driver {
	public static void main(String[] args) {
		RBT 	tree;
		Node 	node;

		try {
			tree = new RBT();
			
			tree.insert(0, "CCO 2103");
	
			node = tree.root;
			if (node == null) throw new Exception();
			if (node.red) throw new Exception();
			if (!node.payload.equals("CCO 2103")) throw new Exception();
	
			tree.insert(1, "data");
			
			node = tree.root;
			if (node == null) throw new Exception();
			if (tree.hasLeftChild(node)) throw new Exception();
			if (!tree.hasRightChild(node)) throw new Exception();
	
			tree.insert(-1, "structures");
			
			node = tree.root;
			if (node == null) throw new Exception();
			if (!tree.hasLeftChild(node)) throw new Exception();
			if (!tree.hasRightChild(node)) throw new Exception();

			System.out.println("passed");
		}

		catch (Exception e) {
			// if the code throws any exception, stack trace will be output and the program will halt
			e.printStackTrace();
			System.out.println("failed");
		}
	}
}
