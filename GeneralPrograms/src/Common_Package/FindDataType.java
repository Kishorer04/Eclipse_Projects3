package Common_Package;
import java.util.*;  
// create class CheckDataTypeExample to check the datatype of the variable  
public class FindDataType {  
    // main() method start  
    public static void main(String args[]) {  
                // declare variables  
        int intData;  
        char charData;  
          
        Scanner sc = new Scanner(System.in);  
          
      
        System.out.println("Enter a String value:"); 
        
        String str = sc.nextLine();  
          
        System.out.println("Enter Integer value:");  
        intData = sc.nextInt();  
          
        System.out.println("Enter Character value:");  
        charData = sc.next().charAt(0);
        
         int ab=34;
          
        // close Scanner class object  
        sc.close();  
          
        // show datatypes of variables by using getClass() and getSimpleName() methods  
        System.out.println(intData + " is of type " + ((Object)intData).getClass().getSimpleName());  
        System.out.println(charData + " is of type " + ((Object)charData).getClass().getSimpleName());  
        System.out.println(str + " is of type " + str.getClass().getSimpleName()); 
        System.out.println(((Object)ab).getClass().getName());
        System.out.println(((Object)ab).getClass().getSimpleName());
    }  
}  


