import javax.swing.*; import java.awt.*; import java.awt.event.*; import java.sql.*;
public class hospital implements ActionListener{
JFrame F=new JFrame(); JTextField t;
JButton b;
JTextField p;
public hospital() {
F.setSize(500,500);
JLabel l1 = new JLabel("Username:");
JLabel l2 = new JLabel("Password:"); t = new JTextField();
p = new JPasswordField();
b = new JButton("Login"); 
l1.setBounds(100,50,150,20); 
l2.setBounds(100,100,150,20);
t.setBounds(200,50,150,20); 
p.setBounds(200,100,150,20);
b.setBounds(200,200,100,50); 
F.add(l1);
F.add(l2);
F.add(t);
F.add(p);
F.add(b);
b.addActionListener(this);
F.setLayout(null);
F.setVisible(true);
}
public void actionPerformed(ActionEvent e) {
String s1 = t.getText();
String s2 = p.getText(); 
JFrame f1 = new JFrame();
if(e.getSource()==b) {
JLabel l3 = new JLabel(); JButton b1,b2;
if(s1.trim().equals("Admin") && s2.trim().equals("password")) {
 f1.setSize(500,500);
 l3.setText("Welcome "+s1+"!!");
l3.setBounds(200,50,200,30);
b1=new JButton("DOCTOR");
b2 = new JButton("PATIENT");
b1.setBounds(150,100,200,30);
b2.setBounds(150,150,200,30);
f1.add(l3);
f1.add(b1);
f1.add(b2);
b1.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e1) {
JFrame f2;
if(e1.getSource()==b1) {
JLabel lb = new JLabel("Doctor's Data!!");
f2 = new JFrame();
f2.setSize(500,500);
JButton b3 = new JButton("INSERT");
JButton b4 = new JButton("DELETE");
JButton b5 = new JButton("SEARCH");
b3.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e3) {
if(e3.getSource()==b3) { JFrame F1=new JFrame(); JTextField t1;
JTextField t2;
JTextField t3; JTextField t4; JTextField t5; JTextField t6; JButton de;
F1.setSize(500,500);
JLabel di = new JLabel("Doctor ID:");
JLabel dn = new JLabel("Name: "); JLabel da = new JLabel("Age: ");
JLabel ds = new JLabel("Specialisation:"); JLabel dq = new JLabel("Qualification:"); JLabel dc = new JLabel("Contact:");
t1 = new JTextField(); t2 = new JTextField(); t3 = new JTextField(); t4 = new JTextField(); t5 = new JTextField(); t6 = new JTextField();
de = new JButton("Enter"); di.setBounds(100,50,150,20);
dn.setBounds(100,100,150,20); da.setBounds(100,150,150,20); ds.setBounds(100,200,150,20); dq.setBounds(100,250,150,20); dc.setBounds(100,300,150,20); t1.setBounds(200,50,150,20); t2.setBounds(200,100,150,20); t3.setBounds(200,150,150,20); t4.setBounds(200,200,150,20);
t5.setBounds(200,250,150,20);

 t6.setBounds(200,300,150,20); de.setBounds(200,400,100,50);
F1.add(di); F1.add(dn); F1.add(da); F1.add(ds); F1.add(dq); F1.add(dc); F1.add(t1); F1.add(t2); F1.add(t3); F1.add(t4); F1.add(t5); F1.add(t6); F1.add(de);
de.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e4) { if(e4.getSource()==de)
{
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
try { Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","765425@vishnu"); stmt = con.createStatement();
String did=t1.getText(); System.out.println(did);
String dname = t2.getText();
String age=t3.getText();
String specialisation = t4.getText(); String qualification = t5.getText(); String contact=t6.getText();
String sql;
sql="insert into doctor values('"+did+"','"+dname+"','"+age+"','"+specialisation+"','"+qualification+"','"+contact+"')";
stmt.executeUpdate(sql);
JOptionPane.showMessageDialog(F1,"record inserted");
stmt.execute("select * from doctor");
rs=stmt.getResultSet();
while(rs.next()) {
System.out.println(rs.getString("did")+" "+rs.getString("dname")+" "+rs.getString("age")+"
"+rs.getString("specialisation")+" "+rs.getString("qualification")+" "+rs.getString("contact")); }
}
catch(Exception e) { System.out.println(e); }
}
}
});
F1.setLayout(null); F1.setVisible(true); }
}

 });
b4.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e5) { if(e5.getSource()==b4) {
JFrame F5=new JFrame(); F5.setSize(500,500); JTextField t7;
JButton del;
JLabel ddi = new JLabel("ID of doctor to be removed:"); del = new JButton("Delete");
t7 = new JTextField();
ddi.setBounds(20,150,200,30); t7.setBounds(200,150,150,30); del.setBounds(300,300,100,50); F5.add(ddi);
F5.add(t7);
F5.add(del);
del.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e6)
{
if(e6.getSource()==del) {
Connection con=null;
Statement stmt=null;;
ResultSet rs=null;
try
{ Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","765425@vishnu"); stmt = con.createStatement();
String ddid=t7.getText();
stmt.execute("delete from doctor where Did='"+ddid+"'");
rs=stmt.getResultSet(); JOptionPane.showMessageDialog(F5,"record removed");
}
catch(Exception e1)
{
System.out.println(e1);
}
}
}
});
F5.setLayout(null); F5.setVisible(true); }
}
});
b5.addActionListener(new ActionListener() {

 public void actionPerformed(ActionEvent e7) { if(e7.getSource()==b5)
{
JFrame F6=new JFrame(); F6.setSize(500,500);
JTextField t8;
JButton dis;
JLabel ddis = new JLabel("id of doctor to be searched:"); dis = new JButton("Display");
t8 = new JTextField();
ddis.setBounds(100,150,150,30); t8.setBounds(200,150,150,30); dis.setBounds(300,300,100,50); F6.add(ddis);
F6.add(t8); F6.add(dis);
dis.addActionListener(new ActionListener()
{
@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e8) {
if(e8.getSource()==dis)
{
try
{ Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); Connection con
=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","765425@vishnu" ); Statement stmt = con.createStatement();
int docid=Integer.parseInt(t8.getText());
stmt.execute("select * from doctor where Did='"+docid+"'"); ResultSet rs=stmt.getResultSet();
JFrame F10=new JFrame();
F10.setSize(500,500);
while(rs.next()) {
String vish,nu,jy,ot,hi,de,vu; System.out.println(rs.getString("did")+" "+rs.getString("dname")+"
"+rs.getString("age")+" "+rs.getString("specialisation")+" "+rs.getString("qualification")+" "+rs.getString("contact"));
nu="doctor id : ".concat(rs.getString("did")); jy="name : ".concat(rs.getString("dname"));
ot="age : ".concat(rs.getString("age"));
hi="specialization : ".concat(rs.getString("specialisation")); de="qualification : ".concat(rs.getString("qualification")); vu="contact : ".concat(rs.getString("contact")); vish=nu+"\n"+jy+"\n"+ot+"\n"+hi+"\n"+de+"\n"+vu; 
JOptionPane.showMessageDialog(F10,vish);} 
F10.setVisible(true);
}
catch(Exception e1)
{ System.out.println(e1); }

 }
}
}); F6.setLayout(null); F6.setVisible(true); }
} });
lb.setBounds(150,50,200,30); b3.setBounds(150,100,200,30); b4.setBounds(150,150,200,30); b5.setBounds(150,200,200,30); f2.add(lb);
f2.add(b3); f2.add(b4); f2.add(b5); f2.setLayout(null); f2.setVisible(true); }
} });
b2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e1) {
JFrame f2;
if(e1.getSource()==b2) {
JLabel lb = new JLabel("Patient's Data!!");
f2 = new JFrame();
f2.setSize(500,500);
JButton b3 = new JButton("INSERT");
JButton b4 = new JButton("DELETE");
JButton b5 = new JButton("SEARCH"); b3.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e3) { if(e3.getSource()==b3) {
JFrame F1=new JFrame(); JTextField t1; JTextField t2;
JTextField t3;
JTextField t4;
JTextField t5;
JTextField t6;
JButton de;
F1.setSize(500,500);
JLabel di = new JLabel("Patient ID:");
JLabel dn = new JLabel("Name: ");
JLabel da = new JLabel("Age: ");
JLabel ds = new JLabel("Case: ");
JLabel dq = new JLabel("Consulting Doctor: ");
JLabel dc = new JLabel("Contact: ");

 t1 = new JTextField();
t2 = new JTextField();
t3 = new JTextField();
t4 = new JTextField();
t5 = new JTextField();
t6 = new JTextField();
de = new JButton("Enter");
di.setBounds(100,50,150,20); dn.setBounds(100,100,150,20); da.setBounds(100,150,150,20); ds.setBounds(100,200,150,20); dq.setBounds(100,250,150,20); dc.setBounds(100,300,150,20); t1.setBounds(200,50,150,20); t2.setBounds(200,100,150,20); t3.setBounds(200,150,150,20); t4.setBounds(200,200,150,20); t5.setBounds(200,250,150,20);
t6.setBounds(200,300,150,20); de.setBounds(200,400,100,50);
F1.add(di); F1.add(dn); F1.add(da); F1.add(ds); F1.add(dq); F1.add(dc); F1.add(t1); F1.add(t2); F1.add(t3); F1.add(t4); F1.add(t5); F1.add(t6); F1.add(de);
de.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e4) {
if(e4.getSource()==de) {
Connection con=null; Statement stmt=null; ResultSet rs=null;
try
{ Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","765425@vishnu"); stmt = con.createStatement();
String did=t1.getText();

 String dname = t2.getText();
String age=t3.getText();
String specialisation = t4.getText(); String qualification = t5.getText(); String contact=t6.getText();
String sql;
sql="insert into patient
values('"+did+"','"+dname+"','"+age+"','"+specialisation+"','"+qualification+"','"+contact+"')"; stmt.executeUpdate(sql);
JOptionPane.showMessageDialog(F1,"record inserted");
stmt.execute("select * from patient"); rs=stmt.getResultSet(); while(rs.next()) {
System.out.println(rs.getString("Pid")+" "+rs.getString("Pname")+" "+rs.getString("age")+" "+rs.getString("Disease")+" "+rs.getString("Dname")+" "+rs.getString("mobile"));
}
}
catch(Exception e)
{ System.out.println(e); }
}
}
}); F1.setLayout(null); F1.setVisible(true);
}
}
});
b4.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e5) {
if(e5.getSource()==b4) {
JFrame F5=new JFrame(); F5.setSize(500,500);
JTextField t7;
JButton del;
JLabel ddi = new JLabel("ID of patient to be removed:"); del = new JButton("Delete");
t7 = new JTextField();
ddi.setBounds(20,150,200,30); t7.setBounds(200,150,150,30); del.setBounds(300,300,100,50); F5.add(ddi);
F5.add(t7);
F5.add(del);
del.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e6) {
if(e6.getSource()==del)
{

 try
{
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","765425
@vishnu");
Statement stmt = con.createStatement();
String ddid=t7.getText();
stmt.execute("delete from patient where Pid='"+ddid+"'"); ResultSet rs=stmt.getResultSet(); JOptionPane.showMessageDialog(F5,"record removed"); }
catch(Exception e1)
{
System.out.println(e1);
}
}
}
});
F5.setLayout(null);
F5.setVisible(true);
}
}
});
b5.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e7)
{
if(e7.getSource()==b5) {
JFrame F6=new JFrame();  F6.setSize(500,500);
JTextField t8; JButton dis;
JLabel ddis = new JLabel("ID of patient to be searched:"); dis = new JButton("SEARCH");
t8 = new JTextField();
ddis.setBounds(100,150,150,30); t8.setBounds(200,150,150,30); dis.setBounds(300,300,100,50);
F6.add(ddis);
F6.add(t8);
F6.add(dis);
dis.addActionListener(new ActionListener() {
@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e8) {
if(e8.getSource()==dis)
{
try {
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","765425@vishnu");
Statement stmt = con.createStatement();
int docid=Integer.parseInt(t8.getText());
stmt.execute("select * from patient where Pid='"+docid+"'"); ResultSet rs=stmt.getResultSet();
JFrame F10=new JFrame();
F10.setSize(500,500);
while(rs.next()) {
String vish,nu,jy,ot,hi,de,vu; System.out.println(rs.getString("Pid")+" "+rs.getString("Pname")+"
"+rs.getString("age")+" "+rs.getString("Disease")+" "+rs.getString("Dname")+" "+rs.getString("mobile"));
nu="Patient id : ".concat(rs.getString("Pid"));
jy="Name : ".concat(rs.getString("Pname"));
ot="Age : ".concat(rs.getString("age"));
hi="Disease : ".concat(rs.getString("Disease"));
de="Consulting doctor : ".concat(rs.getString("Dname"));
vu="contact : ".concat(rs.getString("mobile")); vish=nu+"\n"+jy+"\n"+ot+"\n"+hi+"\n"+de+"\n"+vu; JOptionPane.showMessageDialog(F10,vish);}
F10.setVisible(true);
 }
catch(Exception e1)
{ System.out.println(e1); }
}
}
}); F6.setLayout(null); F6.setVisible(true); }
}
}); lb.setBounds(150,50,200,30); b3.setBounds(150,100,200,30); b4.setBounds(150,150,200,30); b5.setBounds(150,200,200,30); f2.add(lb);
f2.add(b3);
f2.add(b4);
f2.add(b5);
f2.setLayout(null); f2.setVisible(true);
}
}
});
f1.setLayout(null); f1.setVisible(true);
}
else {
JOptionPane.showMessageDialog(F,"Invalid User"); }
}
}
public static void main(String[] args)
{
new hospital(); }
}
