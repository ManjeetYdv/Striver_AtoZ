public class Solution {
    public static int dataTypes(String type) {
        // Write your code here
        switch (type){
            case "Integer" : return 4;
            case "Long" : return 8;
            case "Float" : return 4;
            case "Double" : return 8;
            case "Character" : return 1;
            default: return -1;
        }


      // Enhanced switch 
        // return switch (type) {
        //     case "Integer" -> 4;
        //     case "Long" -> 8;
        //     case "Float" -> 4;
        //     case "Double" -> 8;
        //     case "Character" -> 1;
        //     default -> -1;

    }
}
