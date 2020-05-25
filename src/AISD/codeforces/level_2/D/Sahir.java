package AISD.codeforces.level_2.D;

import java.util.Arrays;
import java.util.Scanner;

public class Sahir {
    public static char[][] map;
    public static int[] nRooms;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt() + 2;
        map = new char[h][];
        nRooms = new int[h];
        int c = 0;

        for (int i = h-1; i >= 0; i--) {
            map[i] = sc.next().toCharArray();
            for (int j = 0; j < w; j++) {
                if (map[i][j] == '1') nRooms[i]++;
            }
            c += nRooms[i];
        }
        System.out.println(countMoves(0, 0, false, c));
    }

    public static int countMoves(int y, int x, boolean goLeft, int totCount) {
        int count = nRooms[y];
        int moves = 0;
        int subC = totCount-count;
        while (count > 0) {
            if (goLeft) x--;
            else x++;
            moves++;
            if (map[y][x] == '1') count--;
        }
        if (y==map.length-1 || subC == 0) {
            return moves;
        }
        int l = 1 + x + countMoves(y + 1, 0, false, subC);
        int r = map[0].length - x + countMoves(y + 1, map[0].length - 1, true, subC);
        return moves + (l > r ? r : l);
    }
}
