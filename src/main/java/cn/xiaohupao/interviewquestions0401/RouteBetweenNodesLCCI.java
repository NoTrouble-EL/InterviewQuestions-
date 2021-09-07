package cn.xiaohupao.interviewquestions0401;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/7 22:16
 */
public class RouteBetweenNodesLCCI {

    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target){
        //创建一个访问数组的状态
        boolean[] used = new boolean[graph.length];

        return helper(graph, start, target, used);
    }

    private static boolean helper(int[][] graph, int start, int target, boolean[] used){
        //遍历访问每一个数组
        for (int i = 0; i < graph.length; i++){
            //若当前数组没有被访问
            if (!used[i]){
                //若当前数组为所求则直接返回true
                if (graph[i][0] == start && graph[i][1] == target){
                    return true;
                }

                //当前数组访问完毕
                used[i] = true;

                //若当前目标地址找到，则将去寻找当前的起始
                if (graph[i][1] == target && helper(graph, start, graph[i][0], used)){
                    return true;
                }
                //回溯
                used[1] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0,1},
                {0,2},
                {0,4},
                {0,4},
                {0,1},
                {1,3},
                {1,4},
                {1,3},
                {2,3},
                {3,4}
        };
        System.out.println(findWhetherExistsPath(5, graph, 0, 4));
    }
}
