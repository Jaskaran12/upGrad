import java.io.*;
import java.util.*;

class TOKEN{
    String name;
    float CGPA;
    int token;
    
    TOKEN(String name, float CGPA, int token)
    {
        this.name = name;
        this.CGPA = CGPA;
        this.token = token;
    }
}

/*save class name as upGrad8*/

class upGrad {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		
		PriorityQueue<TOKEN> pq = new PriorityQueue<TOKEN>(
		    new Comparator<TOKEN>(){
    		    public int compare(TOKEN t1, TOKEN t2){
    		        if(t1.CGPA>t2.CGPA)
    		            return -1;
    		        else if(t1.CGPA<t2.CGPA)
    		            return 1;
    		        else if((t1.name).equals(t2.name) == false){
    		            return (t1.name).compareTo(t2.name);
    		        }
    		        else{
    		            return t2.token - t1.token;
    		        }
		        }
		    });
		
		for(int i = 0; i<n; i++){
		    String str = s.nextLine();
		    String[] values=str.split(" ");
		    if(values[0].equals("ENTER")){
		        String name =values[1];
		        float cgpa = Float.parseFloat(values[2]);
		        int token = Integer.parseInt(values[3]);
		        
		        TOKEN temp = new TOKEN(name, cgpa, token);
		        pq.add(temp);
		    }
		    else{
		        if(str.equals("SERVED")){
		            pq.poll();
		        }
		    }
		}
		
		
		while(!pq.isEmpty()){
		    System.out.println(pq.poll().name);
		}
	}
}