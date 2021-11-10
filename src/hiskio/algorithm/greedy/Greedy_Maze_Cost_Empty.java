package hiskio.algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy_Maze_Cost_Empty {




    public Greedy_Maze_Cost_Empty(Integer[][] maze){

    }

    public int go_maze(int row_start, int col_start, int row_target, int col_target){

        return 0;
    }

    public static void main(String[] args) {
        Integer[][] maze = new Integer[][] {
                {1,3,1,2,9},
                {7,3,4,9,9},
                {1,7,5,5,3},
                {2,3,4,2,5},
        };

        Greedy_Maze_Cost_Empty gmc = new Greedy_Maze_Cost_Empty(maze);
        int row_start = 0;
        int col_start = 0;
        int row_target = 3;
        int col_target = 4;

        int cost_min = gmc.go_maze(row_start,col_start,row_target,col_target);
        System.out.println();
    }
}













