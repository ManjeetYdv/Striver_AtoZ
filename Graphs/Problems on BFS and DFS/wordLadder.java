class Duo{
    String word;
    int level;
    public Duo(){}
    public Duo(String word , int level){
        this.word = word;
        this.level = level;
    }
}
class Solution {
    //  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //     boolean []vis = new boolean[wordList.size()];
    //     Queue<Duo> queue = new LinkedList<>();
    //     queue.add(new Duo(beginWord , 1));
        
    //     while(!queue.isEmpty()){
    //         Duo duo = queue.poll();
    //         String word =duo.word;
    //         int level = duo.level;
    //         if(word.equals(endWord)) return level;
            
    //         for(int i=0 ;i<wordList.size(); i++){
    //             if(!vis[i] && differByOne(word , wordList.get(i))){
    //                 vis[i]=true;
    //                 queue.add(new Duo(wordList.get(i) ,level+1));
    //             }
    //         }
    //     }
    //     return 0;
        
    // }
    // public boolean differByOne(String str1 , String str2){
    //     if(str1.length()!=str2.length()) return false;
    //     int diff=0;
    //     for(int i=0 ;i<str1.length() ;i++){
    //         if(str1.charAt(i)!=str2.charAt(i)) diff++;
    //         if(diff>2) return false;
    //     }
    //     return diff==1;
    // }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word: wordList) set.add(word);
        set.remove(beginWord);

        Queue<Duo> queue = new LinkedList<>();
        queue.add(new Duo(beginWord , 1));

        while(!queue.isEmpty()){
            Duo duo = queue.poll();
            String word = duo.word;
            int level = duo.level;
            if(word.equals(endWord))return level;

            char [] charWord = word.toCharArray();
            for(int i=0 ;i<word.length();i++){
                for(char ch='a' ;ch<='z' ; ch++){
                    char temp = charWord[i];
                    charWord[i]=ch;
                    String replacement = String.valueOf(charWord); //or new String(charWord);
                    //dont use charWord.toString()
                    
                    if(set.contains(replacement)){
                        set.remove(replacement);
                        queue.add(new Duo(replacement  , level+1));
                    }
                    charWord[i]=temp;

                }
            }
        }
        return 0;

    }
}
