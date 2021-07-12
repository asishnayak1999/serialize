package serialize;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SerializationDemo {

	String basepath = "";
	String fileName = "oldapproach.txt";
	String fileName2 = "SerApproach.txt";
	
	
	public static void main(String[] args) {
		
		SerializationDemo obj = new SerializationDemo();
		try {
			//obj.oldApproach();
			
			String filePath = obj.basepath+""+obj.fileName2;
			
			Account a1 = new Account(101, "Ramesh", 2000);
			Account a2 = new Account(102, "Bolt", 3000);
			Account a3 = new Account(103, "Asish", 1000);
			Account a4 = new Account(104, "Mike", 4000);
			
			ArrayList<Account> accList = new ArrayList<>();
			
			accList.add(a1);
			accList.add(a2);
			accList.add(a3);
			accList.add(a4);
			
			
			File serFile = new File(filePath);
			obj.saveSerializableAccount(serFile,accList);
			
			obj.readSerializableAccount(serFile);
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public void saveSerializableAccount(File serfile,ArrayList<Account> accList) throws Exception
	{
		
		FileOutputStream fos = new FileOutputStream(serfile);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(accList);  // List<Account>
		oos.close();
		
	}
	
	public void readSerializableAccount(File serfile) throws Exception
	{
		 FileInputStream fis = new FileInputStream(serfile);
		 ObjectInputStream ois = new ObjectInputStream(fis);
		 
		 //// read List<Account> balance based on r1-r2
		 ArrayList<Account> list = (ArrayList<Account>) ois.readObject();
		 for(Account acc: list) {
			 
			 if(acc.getBalance() >= 1000 && acc.getBalance() <= 4000) {
				 System.out.println(acc.getAccountHolderName()+""+acc.getBalance());
			 }
		 }
		// Account account = (Account)ois.readObject(); 
		
			/*
			 * System.out.println(account.getAccountHolderName());
			 * System.out.println(account.getBalance());
			 * System.out.println(account.fundTransfer(200));
			 */
		 
		 
	}
	
	
	
	public void oldApproach() throws Exception// working with data
	{
		File f = new File(basepath+""+fileName);
		PrintWriter pw = new PrintWriter(new FileWriter(f,true));
		
		Account a = new Account(101, "Ramesh", 2000);
		// cannot work with Object
		//pw.append(a); // error
		pw.append(a.getAccountNumber()+" - "+a.getAccountHolderName()+" - "+a.getBalance());
		pw.close();
	}

}//end class
