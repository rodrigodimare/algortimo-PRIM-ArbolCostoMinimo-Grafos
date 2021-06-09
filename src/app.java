public class app {
    public static void main(String[] args)
    {
    /* Let us create following weighted graph
             2
        1--------2
        | 3 \  / |
       4|    \   |2
        | /5   \ |
        3--------4
            1       */
        int v = 4;
        Prim t = new Prim(v);
        int graph[][] = new int[][]{
                { 0, 2, 4, 3 },
                { 2, 0, 5, 2 },
                { 4, 5, 0, 1 },
                { 3, 2, 1, 0 }};

        // Print the solution
        t.primMST(graph);
    }
}
