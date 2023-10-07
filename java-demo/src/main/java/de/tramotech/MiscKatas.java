package de.tramotech;

import java.util.HashSet;
import java.util.Set;

public class MiscKatas {

    /**
     * Returns the length of the longest substring in the input string that contains at most k distinct characters.
     *
     * @param inputString the input string to be processed
     * @param k the maximum number of distinct characters allowed in a substring
     * @return the length of the longest substring with at most k distinct characters
     */
    public int longestSubstring(String inputString, int k)  {

        //{ "aabbcc", 1, 2 },
        int maxLength = 0;
        for(int startIndex = 0; startIndex < inputString.length(); startIndex ++) {
            Set<Character> charSet = new HashSet<>();
            charSet.add(inputString.charAt(startIndex));
            int currentLength = 1;
            for(int endIndex = startIndex + 1; endIndex < inputString.length();  endIndex ++) {
                char currentChar = inputString.charAt(endIndex);

                if(charSet.size() == k && !charSet.contains(currentChar)) {
                    break;
                }

                charSet.add(currentChar);
                currentLength ++;
            }
            if(charSet.size() == k) {
                maxLength = Math.max(maxLength, currentLength);
                if(maxLength >= inputString.length() - startIndex) {
                    break;
                }
            }
        }



        return maxLength;
    }


}
