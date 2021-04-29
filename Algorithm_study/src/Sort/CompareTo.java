package Sort;

public class CompareTo {

	public static void main(String[] args) {
//		String version1 = "8.5.2.4", version2 = "8.5.3";
		String version1 = "1.0.1", version2 = "1";
		System.out.println(solve(version1,version2));
	}
	
	public static int solve(String v1, String v2) {
		// 1
		String v1StrArray [] = v1.split("\\.");
		String v2StrArray [] = v2.split("\\.");
		
		//2
		int length = Math.max(v1StrArray.length , v2StrArray.length);
		for(int i=0;i<length;i++) {
			Integer v1Int = i < v1StrArray.length ? Integer.parseInt( v1StrArray[i]) : 0;
			Integer v2Int = i < v2StrArray.length ? Integer.parseInt( v2StrArray[i]) : 0;

			int comp = v1Int.compareTo(v2Int);
			if(comp !=0) {
				return comp;
			}
		}
		return 0;
	}	


}
