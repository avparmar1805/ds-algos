import java.io.*;
import java.util.*;

public class Client {

    public static class pair{
        int start;
        int end;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<pair> arrp = new ArrayList<pair>();
        for(int i=0; i<n; i++){
            pair p = new pair(); 
            p.start = sc.nextInt();
            p.end = sc.nextInt();
            arrp.add(p);
        }
        mergeIntervals(arrp);
    }
    
    
    public static void mergeIntervals(ArrayList<pair> arrp){
        
        Collections.sort(arrp, new Comparator<pair>(){
        	@Override
        	public int compare(pair a, pair b){
        		return a.start - b.start;
        	}
        });
        
        List<pair> result = new ArrayList<>();
        result.add(arrp.get(0));
        
        for (int i = 1; i < arrp.size(); i++) {     // Overlapping intervals, move the end if needed
        		pair itr = arrp.get(i);
            pair topofstack = result.get(result.size() - 1);
            
            if (itr.start <= topofstack.end) {
                topofstack.end = Math.max(itr.end, topofstack.end);
            } else {     // Disjoint intervals
                result.add(itr);
            }
        } 
        
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i).start+" "+result.get(i).end);
        }
    }
}