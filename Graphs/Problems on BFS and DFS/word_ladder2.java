class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList) set.add(word);
        set.remove(beginWord);

        Queue<List<String>> queue = new LinkedList<>();
        List<String> l = new ArrayList<>();
        l.add(beginWord);
        queue.add(l);

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean endWordfound = false;
            List<String> removeWords = new ArrayList<>();

            for(int i=0 ;i<size ;i++){
                List<String> temp= queue.poll();
                String lastAddedWord =  temp.get(temp.size()-1);
                char[] replace = lastAddedWord.toCharArray();

                for(int k=0 ;k<replace.length ;k++){
                    char chTemp = replace[k];
                    for(char ch='a' ;ch<='z' ;ch++){
                        replace[k]=ch;
                        String replacement = new String(replace);
                        if(set.contains(replacement)){
                            if(replacement.equals(endWord)) endWordfound = true;
                            removeWords.add(replacement);
                            List<String> temp2 = new ArrayList(temp); //dont use same temp or temp2 = temp
                            temp2.add(replacement);
                            queue.add(temp2);

                        }
                        replace[k]=chTemp;
                    }
                }
            }
            if(endWordfound) break;
            for(String word : removeWords) set.remove(word);

        }

        if(queue.size()==0) {
            System.out.println("hehe");
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();

        while(!queue.isEmpty()){
            List<String> temp =queue.poll();
            for(String word : temp) System.out.print(word+" ");
            String word = temp.get(temp.size()-1);
            if(word.equals(endWord)) res.add(temp);
        }
        return res;

    }
}
