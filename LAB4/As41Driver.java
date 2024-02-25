// skeleton code -- do not modify!
//
// CCO 2103-01, Spring 2023
//
// Assignment 4

import java.io.*;

public class As41Driver {
	public static void main(String[] args) {
		BufferedReader	rd = null;
		BufferedWriter	wr = null;
		String			str;
		int[]			x, y;
		int				n, m, pos, i;
		boolean[]		ret;
		long			starttime, elapsedtime;
		
		try {
			// read in the input
			rd = new BufferedReader(new FileReader("input.txt"));
			str = rd.readLine();
			pos = str.indexOf(" ");
			n = Integer.parseInt(str.substring(0, pos));
			m = Integer.parseInt(str.substring(pos + 1));

			x = new int[m];
			y = new int[m];
			
			for (i = 0; i < m; i++) {
				str = rd.readLine();
				pos = str.indexOf(" ");
				x[i] = Integer.parseInt(str.substring(0, pos));
				y[i] = Integer.parseInt(str.substring(pos + 1));
			}
			
			rd.close();
			rd = null;

			starttime = System.nanoTime();
			ret = As41.getRed(n, m, x, y);
			elapsedtime = System.nanoTime() - starttime;
			System.out.println(Double.toString((double)elapsedtime / 1000000000));

			// write the output
			wr = new BufferedWriter(new FileWriter("output.txt"));
			if(ret == null || ret.length < m) {
				wr.write("error");
				wr.newLine();
			}
			else {
				for (i = 0; i < m; i++) {
					if (ret[i]) {
						wr.write("redundant");
						wr.newLine();
					} else {
						wr.write("not redundant");
						wr.newLine();
					}
				}
			}
			wr.close();
			wr = null;
		}
		catch (Exception e) {
			// if the code throws any exception, stack trace will be output and the program will halt
			e.printStackTrace();
			System.out.println("Error.");
		}
		finally {
			if (rd != null) {
				try {
					rd.close();
				}
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error.");
				}
			}
			if (wr != null) {
				try {
					wr.close();
				}
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error.");
				}
			}
		}
	}
}
