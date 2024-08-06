package Common_Package;
import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    boolean flag=true;
    for(int i=2;i<n;i++) {
    	if(n%i==0)
    	{
    	flag=false;
    	System.out.println("Not prime");
    	break;
    	}
    }
    if(flag==true)
    	System.out.println("Prime number");

	}

}
