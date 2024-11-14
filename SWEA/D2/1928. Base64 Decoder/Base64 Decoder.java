import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

/*
5
TGlmZSBpdHNlbGYgaXMgYSBxdW90YXRpb24u
U3VzcGljaW9uIGZvbGxvd3MgY2xvc2Ugb24gbWlzdHJ1c3Qu
VG8gZG91YnQgaXMgc2FmZXIgdGhhbiB0byBiZSBzZWN1cmUu
T25seSB0aGUganVzdCBtYW4gZW5qb3lzIHBlYWNlIG9mIG1pbmQu
QSBmdWxsIGJlbGx5IGlzIHRoZSBtb3RoZXIgb2YgYWxsIGV2aWwu
 */
class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= testcase; t++) {
			String input = br.readLine().trim();
			byte[] decodedByte = Base64.getDecoder().decode(input);
			String output = new String(decodedByte);
			sb.append("#").append(t).append(" ").append(output).append("\n");
		}
		System.out.print(sb);
	}
}