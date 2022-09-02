import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class class2 {

	public static void main(String[] args) throws IOException  {
		//file location
		new File("output\\indexes").mkdirs();
		File floc = new File("assets files location.txt");
		BufferedReader br = new BufferedReader(new FileReader(floc));
		String loc = br.readLine();
		br.close();
		//version of the indexes
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("type the version  ex: 1.18 for 1.18!");
		String ver = sc.nextLine();
		sc.close();
		//indexes decoder
		FileInputStream fin = null;
		fin = new FileInputStream(loc+"\\indexes\\"+ver+".json");
		File out = new File("output\\indexes\\"+ver+".json");
		FileWriter fw = new FileWriter(out);
		PrintWriter pw = new PrintWriter(fw);
		char cd;
		byte vir = 0;
		System.out.println(ver);
		if (ver.equals("pre-1.6")) {
			vir = -1;
		}
		int line = 0;		
		//indexes decoder loop
		int c;
		for (c = fin.read(); c!=-1; c = fin.read()) {
			cd = (char)c;
			pw.print(cd);
			System.out.print(cd);
			if (cd==',') {
				vir++;
				if (vir==2) {
					vir = 0;
					line++;
					pw.println();
					System.out.println("  Line:"+line);
				}
			}
		}	
		fin.close();
		pw.close();
		line++;
		System.out.println("  Line:"+line);		
	}
}