package lib;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
public class BCA
{
void addBook(Statement st,Libb obj) throws IOException,SQLException
{
	InputStreamReader is=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(is);
	Scanner in=new Scanner(System.in);
	System.out.println("Enter BookName");
	obj.bookname=br.readLine();
	System.out.println("Enter BookAuthorName");
	obj.bookauthor=br.readLine();
	System.out.println("Subject");
	obj.subject=br.readLine();
	System.out.println("Semester");
	obj.sem=Integer.toString(in.nextInt());
	System.out.println("Year");
	obj.year=Integer.toString(in.nextInt());
	int a=Integer.parseInt(obj.sem);
	int b=Integer.parseInt(obj.year);
	String insert="insert into BCA values('"+obj.bookname+"','"+obj.bookauthor+"','"+obj.subject+"','"+a+","+b+");";
	int val=st.executeUpdate(insert);
}
void fine(Statement st,issuedBook tmp,Connection con) throws SQLException,IOException,ParseException
{
	ArrayList <issuedBook>al=new ArrayList<issuedBook>();
	ResultSet rs=st.executeQuery("select * from issuedbca");
	Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
	java.util.Date dat = new java.util.Date();
	String sp= new SimpleDateFormat("yyyy-MM-dd").format(dat);
	String s[]=sp.split("-");
	cal2.set((int)Integer.parseInt(s[0]),(int)Integer.parseInt(s[1]),(int)Integer.parseInt(s[2]));
		while(rs.next()){
		tmp=new issuedBook();
		tmp.rollno=rs.getString("rollno");
		tmp.bookname=rs.getString("bookname");
		tmp.date=rs.getString("dateofissue");
		tmp.fine=rs.getString("fine");
		String str[]=tmp.date.split("-");
		cal1.set((int)Integer.parseInt(str[0]),(int)Integer.parseInt(str[1]),(int)Integer.parseInt(str[2]));
		long milis1 = cal1.getTimeInMillis();
        long milis2 = cal2.getTimeInMillis();
		long diff = milis2 - milis1;
		long fn = diff / (24 * 60 * 60 * 1000);
		if(fn>5)
		{
			fn=fn-(long)5;
		}
		else
			fn=0;
		tmp.fine=Long.toString(fn);
		al.add(tmp);
		}
		PreparedStatement pst=null;
		for(issuedBook pp:al)
		{
			int ff=Integer.parseInt(pp.fine);
			int rno=Integer.parseInt(pp.rollno);
			String insert="UPDATE issuedbca set fine=? where RollNo=? and BookName=?";
			pst=con.prepareStatement(insert);
			pst.setInt(1,ff);
			pst.setInt(2,rno);
			pst.setString(3,pp.bookname);
			pst.executeUpdate();
		}
	}
void issueBook(Statement st,issuedBook obj) throws IOException,SQLException,ParseException
{
	InputStreamReader is=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(is);
	Scanner in=new Scanner(System.in);
	System.out.println("Enter Rollno");
	obj.rollno=br.readLine();
	System.out.println("Enter BookName");
	obj.bookname=br.readLine();
	System.out.println("Enter DateOfIssue(YYYY-MM-DD)");
	obj.date=br.readLine();
	int a=Integer.parseInt(obj.rollno);
	int cmp=compare(st,obj.bookname);
	if(cmp==1)
	{
	String insert="insert into issuedbca values("+a+",'"+obj.bookname+"','"+obj.date+"',0);";
	int val=st.executeUpdate(insert);
	}
	else{
		System.out.println("Your Request Cannot Be FulFilled");
	}
}
void dispIssue(Statement st,issuedBook tmp) throws SQLException
{
	ArrayList <issuedBook>al=new ArrayList<issuedBook>();
	ResultSet rs=st.executeQuery("select * from issuedbca");
	while(rs.next()){
		tmp=new issuedBook();
		tmp.rollno=rs.getString("rollno");
		tmp.bookname=rs.getString("bookname");
		tmp.date=rs.getString("dateofissue");
		tmp.fine=rs.getString("fine");
		al.add(tmp);}
		for(issuedBook pp:al)
		{
				System.out.println(pp.rollno+"\t"+pp.bookname+"\t"+pp.date+"\t"+pp.fine);
		}
}
void dispAll(Statement st,Libb tmp) throws SQLException
{
	ArrayList <Libb>al=new ArrayList<Libb>();
	ResultSet rs=st.executeQuery("select * from bca");
	while(rs.next()){
		tmp=new Libb();
		tmp.bookname=rs.getString("bookname");
		tmp.bookauthor=rs.getString("bookauthorname");
		tmp.subject=rs.getString("subject");
		tmp.sem=rs.getString("semester");
		tmp.year=rs.getString("year");
		al.add(tmp);
	}
		for(Libb pp:al)
		{
			System.out.println(pp.bookname+"\t"+pp.bookauthor+"\t"+pp.subject+"\t"+pp.sem+"\t"+pp.year);
		}
}
int compare(Statement st,String bookname) throws SQLException
{
	String search =("SELECT * FROM bca where bookname='"+bookname+"';");
	ResultSet rs = st.executeQuery(search);
		 if(!rs.next())
		 {
			 System.out.println("Book Not Avalilable");
			 return 0;
		 }
		 else{
			 return 1;
		 }
}
}