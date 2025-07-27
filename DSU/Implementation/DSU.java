package Implementation;

class DSU {
    int n;
    int parent[], size[];

    DSU(int n) {
        this.n = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    void union(int u, int v) {
        int a = find(u);
        int b = find(v);

        if (a == b)
            return;

        if (size[a] > size[b]) {
            parent[b] = a;
            size[a] += size[b];
        } else {
            parent[a] = b;
            size[b] += size[a];
        }

    }

    int find(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = find(parent[u]);
    }

}