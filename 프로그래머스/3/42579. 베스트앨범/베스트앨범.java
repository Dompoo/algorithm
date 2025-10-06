import java.util.*;
import java.util.stream.*;

class Solution {

    static class Song {
        final int play;
        final int idx;
        Song(int play, int idx) { this.play = play; this.idx = idx; }
    }

    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;

        // 1) 장르별 총 재생수
        Map<String, Integer> sumByGenre = new HashMap<>();
        // 2) 장르별 상위 2곡 유지
        Map<String, List<Song>> top2ByGenre = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String g = genres[i];
            int p = plays[i];

            sumByGenre.merge(g, p, Integer::sum);

            List<Song> list = top2ByGenre.computeIfAbsent(g, k -> new ArrayList<>(2));
            list.add(new Song(p, i));
            // 재생수(desc), 같으면 인덱스(asc)
            list.sort((a, b) -> a.play != b.play ? b.play - a.play : a.idx - b.idx);
            if (list.size() > 2) list.remove(2); // 3개째 제거해서 항상 2개 이하 유지
        }

        // 3) 장르 총 재생수(desc) 순으로 장르 정렬 후, 장르별 상위 2곡 인덱스 수집
        List<Integer> result = sumByGenre.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .map(Map.Entry::getKey)
                .flatMap(g -> top2ByGenre.getOrDefault(g, List.of())
                        .stream()
                        .map(s -> s.idx))
                .collect(Collectors.toList());

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
