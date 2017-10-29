package Recursion;

public class Recursion {
	
	public int factorial(int n) {
		 
		if (n==0)
		    return 1;
		  
		return n*factorial(n-1);
	}
	
	public int bunnyEars(int bunnies) {
		  if (bunnies == 0)
		    return 0;
		  return 2+bunnyEars(bunnies-1);
		}
	
	public int fibonacci(int n) {
		  if (n<=1)
		    return n;
		  return fibonacci(n-1)+ fibonacci(n-2);
		}
	
	public int bunnyEars2(int bunnies) {
		  if(bunnies == 0)
		    return 0;
		  if (bunnies%2 == 1)
		    return 2 + bunnyEars2(bunnies - 1);
		  
		  return 3 + bunnyEars2(bunnies - 1);
		  
		}
	
	public int triangle(int rows) {
		  if (rows <= 1)
		    return rows;
		  return rows + triangle(rows - 1);
		}
	
	public int sumDigits(int n) {
		  if (n < 10)
		    return n;
		  return n%10 + sumDigits(n / 10);
	}
	
	public int count7(int n) {
		  if (n<7)
		    return 0;
		  
		  if (n%10 == 7)
		    return 1 + count7(n/10);
		  
		  return count7(n/10);
	}
	
	public int count8(int n) {
		  
		  int last = n%10;
		  
		  if (n<8)
		    return 0;

		  if(last == 8 && (n/10)%10 == 8)
		    return 2 + count8(n/10);
		    
		  if(last == 8)
		    return 1 + count8(n/10);
		  
		  return count8(n/10);
	}

	
	public int powerN(int base, int n) {
		  if (n == 1){
		    
		    return base;
		  }
		  
		  return base*powerN(base,--n);
	}
	
		
	public int countX(String str) {
		  if (str.length() == 0)
		    return 0;

		  if (str.substring(0, 1).equals("x"))
		    return 1 + countX(str.substring(1,str.length()));
		  
		  return  countX(str.substring(1));
		}

	
	public int countHi(String str) {
		  
		if (str.length()<=1) 
		     return 0;
		  
		  if (str.substring(0,2).equals("hi"))
		     return 1 + countHi(str.substring(2));
		  
		  return countHi(str.substring(1));
		}
	
	public String changeXY(String str) {
		
		  if(str.length() == 0)
		    return "";
		  if(str.substring(0,1).equals("x")){
		    return  "y" + changeXY(str.substring(1)) ;
		  }
		  return str.substring(0,1) + changeXY(str.substring(1)); 
	}
	
	public boolean array6(int[] nums, int index) {
		  
		  if (nums.length==0)
		    return false;
		  	  
		  if (nums.length-1 == index){
		     if(nums[index] == 6)
		       return true;
		     
		     return false;
		  }
		  
		  if (nums[index] == 6)
		    return true;
		  
		  
		  return false || array6(nums, index + 1);
	}

	public int array11(int[] nums, int index) {
		  
		  if (nums.length==0)
		     return 0;
				
		  if (nums.length-1 == index){
		     if (nums[index] == 11)
		       return 1;
		     return 0;
		  }
		  
		  if (nums[index] == 11)
		    return 1 + array11(nums, ++index);
		  
		
		  return array11(nums, ++index);
		}



}
