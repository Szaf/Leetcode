import java.util.ArrayList;

public class Palindrome_list {
	private static ArrayList<String> words = new ArrayList<String>();
	public static void main(String[] args) {
		words.add("abcd");
		words.add("dcba");
		words.add("lls");
		words.add("s");
		words.add("sssll");
		System.out.println("List of words: " + words);
		ArrayList<int[]> indices = checkPalindroms(words);
		printIndices(indices);
	}

	private static ArrayList<int[]> checkPalindroms(ArrayList<String> list){
		ArrayList<int[]> indices = new ArrayList<int[]>();
		for(int i=0; i<list.size(); i++){
			for(int j=0; j<list.size(); j++){
				if(i==j){
					continue;
				}
				//System.out.println("i: " + i +" j: " + j);
				String concatWord = list.get(i).concat(list.get(j));
				boolean palindrom = true;
				int cWLength = concatWord.length();
				// cut out middle char if length is not even
				// i.e. ada -> aa
				// assuming that "ada" is a palindrom
				if((cWLength % 2)!=0){
					concatWord = concatWord.substring(0, cWLength/2).concat(concatWord.substring((cWLength/2)+1, cWLength));
					cWLength--;
				}
				for(int k=0; k<cWLength/2;k++){
					if (concatWord.charAt(k) != concatWord.charAt(cWLength-1-k)){ // "ada" -> length 3 -> highest index 2
						palindrom = false;
						break;
					}
				}
				if (palindrom){
					indices.add(new int[] {i,j});
				}
			}
		}
		return indices;
	}
	
	private static void printIndices(ArrayList<int[]> indices){
		System.out.print("Indices: ");
		for(int i=0;i<indices.size(); i++){
			System.out.print("["+indices.get(i)[0]+","+indices.get(i)[1]+"]");
		}
		System.out.println();
	}
}
