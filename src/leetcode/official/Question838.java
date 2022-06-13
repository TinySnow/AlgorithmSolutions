package leetcode.official;

/**
 * UNFINISHED
 * 没时间，待以后回头做
 */
public class Question838 {
    public static String push(String dominoes) {
        int currentRIndex = -1;
        int currentLIndex = -1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i);
            if (c == '.') {

            } else if (c == 'R') {
                int lastRIndex = currentRIndex;
                currentRIndex = i;
                if(currentLIndex<lastRIndex){
                    for (int j = lastRIndex; j < currentRIndex +1; j++) {
                        result.append("R");
                    }
                }
            } else if (c == 'L') {
                currentLIndex = i;

            } else {
                return "Failed.";
            }
        }
        return result.toString();
    }
}

