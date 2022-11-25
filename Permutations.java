import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Permutations {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        result = findPermutation("abc");
        System.out.println(result);
    }

    public static List<String> findPermutation(String S) {
        List<String> result = permutations("", S);
        Collections.sort(result);
        return result;
    }
    
    public static List<String> permutations(String p, String up) {
        if(up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        char ch = up.charAt(0);
        List<String> ans = new ArrayList<>();
        for(int i=0; i<=p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            ans.addAll(permutations(first + ch + second, up.substring(1)));
        }
        return ans;
    }
}