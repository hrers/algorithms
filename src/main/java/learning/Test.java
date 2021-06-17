package learning;

public class Test {

      public static void main(String[] args	) {
    		String[] val= {"123","42","3","90"};
    	      IteratorTest<String> it=new IteratorTest<String>(val); 
    	      while(it.hasNext()) {
    	    	  System.out.println(it.next());
    	      }
      }
}
