import java.io.*;

class Test{
	static int a;
	static boolean isError;

	public static void validator(Node node, int cnt){
		if(node == null) {
			if(a == 0) a = cnt;
			if(a != 0 && a != cnt) isError = true;
			return;
		}
		if(node.red == true) {
			if((node.left != null && node.left.red == true) || (node.right != null && node.right.red == true)) {isError = true;}
		}
		else {cnt++;}
		validator(node.left, cnt);
		validator(node.right, cnt);
	}

	public static void main(String[] args) throws IOException{
		RBT rbt = new RBT();
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int c = 0;
		int b;
		for(;;){
			bw.write("case: " + c++ + "\n");
			rbt = new RBT();
			a = 0; isError = false;
			for(int i = 0; i < 1000; i++){
				b = (int)(Math.random() *2);
				switch (b){
					case 0:
					rbt.insert((int)(Math.random() * 200), null); break;
					case 1:
					rbt.delete((int)(Math.random() * 200)); break;
				}
			}
			validator(rbt.root, 0);
			if(rbt.root.red == true) isError = true;
			if(isError == true) break;
		}
		bw.close();
	}
}