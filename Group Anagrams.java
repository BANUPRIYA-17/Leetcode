import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<List<String>> groupAnagrams(String[] str) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            String res = str[i];
            char[] fin = res.toCharArray();
            Arrays.sort(fin);
            String word = new String(fin);
            
            if (map.containsKey(word) == false) {
                map.put(word, new ArrayList<String>());
            }
            map.get(word).add(res);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of words");
        int n = sc.nextInt();
        String[] str = new String[n];
        System.out.println("enter words");
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }      
        Solution solver = new Solution();
        List<List<String>> result = solver.groupAnagrams(str);
        System.out.println("Anagrams:");
        System.out.println(result);
        sc.close();
    }
}
