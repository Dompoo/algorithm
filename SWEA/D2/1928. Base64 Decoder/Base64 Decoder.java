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
/*
인코딩 과정
아스키 숫자로 바꿈
8비트 이진수로 바꿈
6비트씩 끊어서 10진수로 읽음 (0~63)
컨버트
 */
/*
디코딩 과정
char 하나씩을 10진수로 컨버트
10진수를 6비트로 컨버트 x N번
8비트씩 끊어서 아스키로 읽음
 */
class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= testcase; t++) {
			String input = br.readLine().trim();
			int buffer = 0;
			int bitCount = 0;
			sb.append("#").append(t).append(" ");
			for(int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				int num = base64decode(ch);
				buffer = (buffer << 6) | num;
				bitCount += 6;
				
				while(bitCount >= 8) {
					bitCount -= 8;
					int charCode = (buffer >> bitCount) & 0xFF;
					sb.append((char) charCode);
				}
			}
			
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	private static int base64decode(char ch) {
		if ('A' <= ch && ch <= 'Z') {
			return ch - 'A';
		} else if ('a' <= ch && ch <= 'z') {
			return ch - 'a' + 26;
		} else if ('0' <= ch && ch <= '9') {
			return ch - '0' + 52;
		} else if (ch == '+') {
			return 62;
		} else if (ch == '/') {
			return 63;
		}
		throw new IllegalArgumentException();
	}
}