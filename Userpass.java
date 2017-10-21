package lib;
import java.io.*;
public class Userpass
{ 
void giveRev(File f, String u,String p) throws IOException
{
	u=new StringBuffer(u).reverse().append(System.lineSeparator()).toString();
	p=new StringBuffer(p).reverse().toString();
	f.createNewFile();
	FileOutputStream fw=new FileOutputStream(f);
	fw.write(u.getBytes());
	fw.write(p.getBytes());
}
int getAccess() throws IOException
{
int i=0;
String u=new String();
String p=new String();
File f=new File("User-Pass.txt");
FileReader fr=new FileReader(f);
BufferedReader br=new BufferedReader(fr);
while(i<2)
{
	if(i==0)
	{
		u=br.readLine();
		String [] c=u.split(System.lineSeparator());
		u=c[0];
		i=i+1;
	}
	else
	{
		p=br.readLine();
		i=i+1;
	}
}
Console con=System.console();
System.out.print("**************LOGIN PANEL***************\n");
System.out.println("........................................");
System.out.print("| UserName | ");
String user = con.readLine();
System.out.println("........................................");
System.out.print("| Password | ");
String pwd = con.readLine();
System.out.println("........................................");
	if(user.equalsIgnoreCase(u) && pwd.equals(p))
	{
		System.out.println("Authentication Successful!!!");
		giveRev(f,u,p);
		return 1;
	}
	else
	{
		System.out.println("Authentication Failed!!!");
		giveRev(f,u,p);
		return 0;
	}
}
}
