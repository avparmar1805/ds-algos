package Arrays;
import java.util.*;
public class SourceToDestPaths {
	public static void main (String[] args) {
		ArrayList<String> paths = getBoardPaths(0, 10);
		
		for(String path: paths) {
			System.out.println(path);
		}
		
	}
	
	public static ArrayList<String> getBoardPaths(int src, int dest){
		
		if(src == dest) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("\n");
			return br;
		} else if(src > dest) {
			ArrayList<String> br = new ArrayList<String>();
			
			return br;
		}
		ArrayList<String> pathsFromSrcToDest = new ArrayList<String>();
		for(int dice=1; dice<=6; dice++) {
			int i = src + dice;
			
			ArrayList<String> pathsFromIToDest = getBoardPaths(i, dest);
			for(String pathFromIToDest: pathsFromIToDest) {
				pathsFromSrcToDest.add(dice+pathFromIToDest);
			}
			
		}
			
		return pathsFromSrcToDest;
	}
}
