package Test;

import component.MOptionPane;
import data.*;

public class getClass {
public static void main(String arg[]){
	
	Object object = new Book();
	
	
	 if (object.getClass()==Book.class){
		 Book boo= (Book) object;
		 MOptionPane.showMessageDialog(null,boo.GetData());
		 
		 
     }
	 
	 else if(object.getClass()==Member.class){
		 MOptionPane.showMessageDialog(null,"Member");
	 }
	 
	 else if (object.getClass()==Return.class){
		 MOptionPane.showMessageDialog(null,"Return");
	 }
	 
	 else if (object.getClass()==Borrow.class){
		 MOptionPane.showMessageDialog(null,"Borrow");
	 }
}
}
