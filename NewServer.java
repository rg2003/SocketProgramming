import java.net.*;
import java.io.*;
class NewServer
{

public static void main(String[] args) throws Exception
{
ServerSocket ss = new ServerSocket(6000);
Socket s = ss.accept();
DataInputStream dis = new DataInputStream(s.getInputStream());
DataOutputStream dos = new DataOutputStream(s.getOutputStream());
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String stream="";
String input="";
while(!stream.equals("stop"))
{
stream = dis.readUTF();
System.out.println("Client: " + stream);
input = br.readLine();
dos.writeUTF(input);
dos.flush();
}
dis.close();
dos.close();
s.close();
ss.close();
}
}