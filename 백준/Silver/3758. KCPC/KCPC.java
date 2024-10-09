import java.io.*;
import java.util.*;

class Main {

    public static class Solve {
        int team;
        int problem;
        int score;

        public Solve(int team, int problem, int score) {
            this.team = team;
            this.problem = problem;
            this.score = score;
        }

        public Solve(String[] s) {
            this.team = Integer.parseInt(s[0]);
            this.problem = Integer.parseInt(s[1]);
            this.score = Integer.parseInt(s[2]);
        }
    }

    public class Team implements Comparable<Team> {
        int id;
        int[] scores;
        int totalScore;
        int solveTime;
        int lastSubmitTime;

        public Team(int id, int problemN) {
            this.id = id;
            this.scores = new int[problemN + 1];
        }

        @Override
        public int compareTo(Team o) {
            // 최종점수 높은순
            if(this.totalScore != o.totalScore) return o.totalScore - this.totalScore;
            // 제출 횟수 적은순
            else if(this.solveTime != o.solveTime) return this.solveTime - o.solveTime;
            // 제출 시간 적은순
            else return this.lastSubmitTime - o.lastSubmitTime;
        }
    }

    public String solution(int teamN, int problemN, int myTeam, int logN, List<Solve> list) {
        Map<Integer, Team> teamMap = new HashMap<>(); //Id : Team

        for(int i = 1; i <= teamN; i++) {
            teamMap.put(i, new Team(i, problemN));
        }

        int logNumber = 0;
        for(Solve s : list) {
            Team team = teamMap.get(s.team);

            //새로 획득한 점수가 더 높다면 점수 업데이트, 합산 점수 업데이트
            if(team.scores[s.problem] < s.score) {
                team.totalScore -= team.scores[s.problem];
                team.totalScore += s.score;
                team.scores[s.problem] = s.score;
            }

            team.solveTime++;
            team.lastSubmitTime = logNumber++;
        }

        List<Team> teamList = new ArrayList<>(teamMap.values());
        Collections.sort(teamList);

        int result = -1;
        for(int i = 0; i < teamList.size(); i++) {
            if(teamList.get(i).id == myTeam) {
                result = i + 1;
                break;
            }
        }

        return result + "\n";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < testcase; t++) {
            String[] s = br.readLine().split(" ");
            int teamN = Integer.parseInt(s[0]);
            int problemN = Integer.parseInt(s[1]);
            int myTeam = Integer.parseInt(s[2]);
            int logN = Integer.parseInt(s[3]);
            List<Solve> list = new ArrayList<>();
            for(int i = 0; i < logN; i++) {
                String[] solve = br.readLine().split(" ");
                list.add(new Solve(solve));
            }
            sb.append(new Main().solution(teamN, problemN, myTeam, logN, list));
        }
        System.out.print(sb);
    }
}