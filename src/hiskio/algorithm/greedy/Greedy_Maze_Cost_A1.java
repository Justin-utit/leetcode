package hiskio.algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy_Maze_Cost_A1 {

    Integer[][] maze;
    PriorityQueue<Node> pq = new PriorityQueue<>();
    Integer[][] maze_min;

    static class Node{
        Integer row;
        Integer col;
        Integer cost;
        public Node(Integer row, Integer col){
            this.row = row;
            this.col = col;
        }
    }

    public Greedy_Maze_Cost_A1(Integer[][] maze){
        this.maze = maze;
        this.pq = new PriorityQueue<>(20, new MyComp()  );
        this.maze_min = new Integer[maze.length][maze[0].length];
    }

    class MyComp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost.compareTo(o2.cost);
        }
    }

    public int go_maze(int row_start, int col_start, int row_target, int col_target){
        Node start = new Node(row_start,col_start);
        start.cost = maze[row_start][col_start];
        Node target = new Node(row_target,col_target);
        return go_maze(start,target);
    }

    public int go_maze(Node start, Node target){
        // 初始化
        pq.add(start);
        while (true){
            if(pq.isEmpty())
                break;

            Node curr = pq.poll();

            if(maze_min[curr.row][curr.col]!=null)
                continue;

            // confirm
            maze_min[curr.row][curr.col] = curr.cost;

            // 上
            if (curr.row-1>=0){
                Node up = new Node(curr.row-1, curr.col);
                up.cost = curr.cost + maze[curr.row-1][curr.col];
                pq.add(up);
            }

            // 下
            if (curr.row+1 < maze.length){
                Node up = new Node(curr.row+1, curr.col);
                up.cost = curr.cost + maze[curr.row+1][curr.col];
                pq.add(up);
            }

            // 左
            if (curr.col-1>=0){
                Node up = new Node(curr.row, curr.col-1);
                up.cost = curr.cost + maze[curr.row][curr.col-1];
                pq.add(up);
            }

            // 右
            if (curr.col+1<maze[0].length){
                Node up = new Node(curr.row, curr.col+1);
                up.cost = curr.cost + maze[curr.row][curr.col+1];
                pq.add(up);
            }

        }

        return maze_min[target.row][target.col];
    }

    public static void main(String[] args) {
        Integer[][] maze = new Integer[][] {
                {1,3,1,2,9},
                {7,3,4,9,9},
                {1,7,5,5,3},
                {2,3,4,2,5},
        };

        Greedy_Maze_Cost_A1 gmc = new Greedy_Maze_Cost_A1(maze);
        int row_start = 0;
        int col_start = 0;
        int row_target = 3;
        int col_target = 4;

        int cost_min = gmc.go_maze(row_start,col_start,row_target,col_target);
        System.out.println();
    }
}













