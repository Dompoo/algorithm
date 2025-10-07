class Solution {
    public int[] solution(int brown, int yellow) {
        for (int h = 1; h < brown; h++) {
            if ((brown - (2 * h)) % 2 != 0) continue;
            int w = (brown - (2 * h)) / 2;
            if ((h - 2) * (w) == yellow) return new int[]{w + 2, h};
        }
        return null;
    }
}