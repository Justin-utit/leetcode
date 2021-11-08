package hiskio.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy_Maze_Cost_A {

    Integer[][] maze;
    PriorityQueue<Node> pq;
    Integer[][] maze_best;

    static class Node{
        Integer row;
        Integer column;
        Integer cost;
        public Node(Integer row, Integer column){
            this.row = row;
            this.column = column;
        }
    }

    static class MyCompare implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost.compareTo(o2.cost);
        }
    }

    public Greedy_Maze_Cost_A(Integer[][] maze){
        this.maze = maze;
        this.pq = new PriorityQueue<Node>(20, new MyCompare());
        this.maze_best = new Integer[maze.length][maze[0].length];
    }

    public int go_maze(int row_start, int col_start, int row_target, int col_target){
        Node start = new Node(row_start,col_start);
        start.cost = this.maze[row_start][col_start];
        Node target = new Node(row_target,col_target);
        return go_maze(start,target);
    }

    private int go_maze(Node start, Node target) {

        pq.add(start);

        while (true){
            if(pq.size()==0)
                break;

            Node curr = pq.poll();

            if(this.maze_best[curr.row][curr.column]!=null)
                continue;

            maze_best[curr.row][curr.column] = curr.cost;

            // 上 (取得上node的節點與其成本，放進pq)
            if(curr.row-1>=0){
                Node up = new Node(curr.row-1, curr.column);
                up.cost = curr.cost + maze[up.row][up.column];
                pq.add(up);
            }
            // 下
            if(curr.row+1 < this.maze.length){
                Node up = new Node(curr.row+1, curr.column);
                up.cost = curr.cost + maze[up.row][up.column];
                pq.add(up);
            }

            // 左
            if(curr.column-1>=0){
                Node up = new Node(curr.row, curr.column-1);
                up.cost = curr.cost + maze[up.row][up.column];
                pq.add(up);
            }

            // 右
            if(curr.column+1<this.maze[0].length){
                Node up = new Node(curr.row, curr.column+1);
                up.cost = curr.cost + maze[up.row][up.column];
                pq.add(up);
            }
        }

        return maze_best[target.row][target.column];

    }

    public static void main(String[] args) {
        Integer[][] maze = new Integer[][] {
                {1,3,1,2,9},
                {7,3,4,9,9},
                {1,7,5,5,3},
                {2,3,4,2,5},
        };

        Greedy_Maze_Cost_A gmc = new Greedy_Maze_Cost_A(maze);
        int row_start = 0;
        int col_start = 0;
        int row_target = 3;
        int col_target = 4;

        int cost_min = gmc.go_maze(row_start,col_start,row_target,col_target);
        System.out.println();
    }
}













