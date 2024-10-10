import java.util.*;
import java.io.*;
/*
5 2
map
set
dijkstra
floyd
os
map,dijkstra
map,floyd
 */
class Main {
    
    // N^2 안됨
    private String solution(int keywordSize, String[] keywords, int postSize, String[] posts) {
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < keywordSize; i++) {
            set.add(keywords[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < postSize; i++) {
            String[] keywordArr = posts[i].split(",");
            for (String keyword : keywordArr) {
                set.remove(keyword);
            }
            sb.append(set.size()).append("\n");
        }
        
        return sb.toString();
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int keywordSize = Integer.parseInt(s[0]);
        String[] keywords = new String[keywordSize];
        for(int i = 0; i < keywordSize; i++) {
            keywords[i] = br.readLine();
        }
        
        int postSize = Integer.parseInt(s[1]);
        String[] posts = new String[postSize];
        for(int i = 0; i < postSize; i++) {
            posts[i] = br.readLine();
        }
        
        System.out.print(new Main().solution(keywordSize, keywords, postSize, posts));
        br.close();
    }
}