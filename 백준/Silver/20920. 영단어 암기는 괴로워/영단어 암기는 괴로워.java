import java.io.*;
import java.util.*;
/*
7 4
apple
ant
sand
apple
append
sand
sand
 */
class Main {
	
	private class Word implements Comparable<Word> {
		String word;
		int ratio;
		
		public Word(String word, int ratio) {
			this.word = word;
			this.ratio = ratio;
		}
		
		public Word getNextRatioWord() {
			return new Word(this.word, this.ratio + 1);
		}
		
		@Override
		public int compareTo(Word o) {
			if(this.ratio != o.ratio) {
				return o.ratio - this.ratio;
			} else if (this.word.length() != o.word.length()) {
				return o.word.length() - this.word.length();
			} else {
				return this.word.compareTo(o.word);
			}
		}
	}
	
	private String solution(int size, List<String> list, int m) {
		
		// ratio 계산
		Map<String, Word> map = new HashMap<>();
		
		for (String str : list) {
			if (!map.containsKey(str)) { //새로운 단어라면
				map.put(str, new Word(str, 1));
			} else { //이미 있던 단어라면
				map.put(str, map.get(str).getNextRatioWord());
			}
		}
		
		List<Word> wordList = new ArrayList<>(map.values());
		
		// 사이즈가 안되는 것 삭제
		for (int i = wordList.size() - 1; i >= 0; i--) {
			if (wordList.get(i).word.length() < m) {
				wordList.remove(i);
			}
		}
		
		// 정렬
		Collections.sort(wordList);
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < wordList.size(); i++) {
			sb.append(wordList.get(i).word);
			if (i != wordList.size() - 1) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int size = Integer.parseInt(s[0]);
		List<String> list = new ArrayList<>();
		int M = Integer.parseInt(s[1]);
		for (int i = 0; i < size; i++) {
			list.add(br.readLine());
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(new Main().solution(size, list, M));
		bw.flush();
	}
}