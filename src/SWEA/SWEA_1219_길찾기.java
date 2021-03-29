package SWEA;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1219_길찾기 {
     static  int A;
    static int N;
    static LinkNode[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine()," ");

        for (int t = 1; t <=10; t++) {
            st= new StringTokenizer(br.readLine()," ");
            N=Integer.parseInt(st.nextToken());

            graph =new LinkNode[N];

            while(st.hasMoreTokens()){
                st= new StringTokenizer(br.readLine()," ");
                int from =Integer.parseInt(st.nextToken());
                int to =Integer.parseInt(st.nextToken());
                graph[from] =new LinkNode(to,graph[from]);
            }
            A=0;
            bfs();
            sb.append("#").append(t).append(" ").append(A).append('\n');

        }
        System.out.println(sb);



    }

    private static void bfs() {
        Queue<Integer>q =new LinkedList<>();

        boolean[] visited =new boolean[100];

        q.offer(0);
        visited[0]=true;

        while(!q.isEmpty()){
            int head =q.poll();

            if(head==99){
                A=1;
                return;
            }

            LinkNode child =graph[head];
            while(child!=null){
                if(!visited[child.i]){
                    visited[child.i]=true;
                    q.offer(child.i);
                }
                child =child.next;
            }
        }
    }

    static  class LinkNode{
        int i;
        LinkNode next;
        public LinkNode(int i, LinkNode next){
            super( );
            this.i =i;
            this.next=next;
        }


    }




}
