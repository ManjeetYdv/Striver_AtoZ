class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int idx=0;
        for(int i=0;i<g.length;i++){
            while(idx<s.length && s[idx]<g[i]) idx++;
            if(idx==s.length) return i;
            idx++;
        }
        return g.length;
    }
}
