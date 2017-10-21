package lib;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.ParseException;
class Lib
{
	String bookname;
	String bookauthor;
	String subject;
	String stream;
	String sem;
	String year;
}
class Libb
{
	String bookname;
	String bookauthor;
	String subject;
	String sem;
	String year;
}
class issuedBook
{
	String rollno;
	String bookname;
	String date;
	String fine;
}
public class Library
{
	public static int btech=0,mca=0,bca=0;
	public static void main(String args[])
	{
		int i,j,k;
		char ch='y';
		Scanner in=new Scanner(System.in);
		Scanner ins=new Scanner(System.in);
		Btech btech=new Btech();
		BCA bca=new BCA();
		MCA mca=new MCA();
		String str=new String();
		try
		{
		Lib lb=new Lib();
		Libb lbb=new Libb();
		issuedBook ib=new issuedBook();
		Userpass up=new Userpass();
		int access=up.getAccess();
		if(access==1)
		{
		int p=0;
		String t=new String();;
		String loc=new String();
		String pass=new String();
		File f=new File("details.txt");
		if(f.exists()==false)
			f.createNewFile();
		FileReader fis=new FileReader(f);
		BufferedReader br=new BufferedReader(fis);
		while((t=br.readLine())!=null)
		{
			if(p==0)
			{
				loc=t;
				p++;
				t=new String();
			}
			else
			{
				if(t==null)
					pass=" ";
				else
				pass=t;
			}
		}
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(loc,"root",pass);
			Statement st=con.createStatement();
			while(ch=='y')
			{
			System.out.println("1.Issue the Book\n2.Add A book\n3.Fine Calculator\n4.Display");
			i=in.nextInt();
			switch(i)
			{
				case 1:
				System.out.println("Use Exact String--\nBtech\nMCA\nBCA");
				str=new String();
				str=ins.nextLine();
				switch(str)
				{
					case "Btech":
					btech.issueBook(st,ib);
					break;
					case "BCA":
					bca.issueBook(st,ib);
					break;
					case "MCA":
					mca.issueBook(st,ib);
					break;
					default:
					System.out.println("Wrong Choice");
				}
				break;
				case 2:
				System.out.println("Use Exact String--\nBtech\nMCA\nBCA");
				str=new String();
				str=ins.nextLine();
				switch(str)
				{
					case "Btech":
					btech.addBook(st,lb);
					break;
					case "BCA":
					bca.addBook(st,lbb);
					break;
					case "MCA":
					mca.addBook(st,lbb);
					break;
					default:
					System.out.println("Wrong Choice");
				}
				break;
				case 3:
				System.out.println("Use Exact String--\nBtech\nMCA\nBCA");
				str=new String();
				str=ins.nextLine();
				switch(str)
				{
					case "Btech":
					btech.fine(st,ib,con);
					break;
					case "BCA":
					bca.fine(st,ib,con);
					break;
					case "MCA":
					mca.fine(st,ib,con);
					break;
					default:
					System.out.println("Wrong Choice");
				}
				break;
				case 4:
				System.out.println("Use Exact String--\nBtech\nMCA\nBCA");
				str=new String();
				str=ins.nextLine();
				switch(str)
				{
					case "Btech":
					System.out.println("\nBTECH ISSUE TABLE");
					btech.dispIssue(st,ib);
					System.out.println("\nBTECH BOOK TABLE");
					btech.dispAll(st,lb);
					break;
					case "BCA":
					System.out.println("\nBCA ISSUE TABLE");
					bca.dispIssue(st,ib);
					System.out.println("\nBCA BOOK TABLE");
					bca.dispAll(st,lbb);
					break;
					case "MCA":
					System.out.println("\nMCA ISSUE TABLE");
					mca.dispIssue(st,ib);
					System.out.println("\nMCA BOOK TABLE");
					mca.dispAll(st,lbb);
					break;
					default:
					System.out.println("Wrong Choice");
				}
				break;
			default:
			System.out.println("Wrong Choice");
			}
			
		System.out.println("\nDo you want to continue, press y");
		ch=in.next().charAt(0);
			}
		}
			else
		{
			System.out.println("Wrong Credentials!! Try Again Later!!");
		}
			}catch(ClassNotFoundException e)
		{
			System.out.println("jar not found");
		}
		catch(SQLException e)
		{
			System.out.println("Connection cannot be established");
		}
		catch(IOException e)
		{
			System.out.println("IOException occured");
		}
		catch(ParseException e)
		{
			System.out.println("ParseException occured");
		}
	}
	}
