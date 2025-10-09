
class dp
{
    String s, p;

    public boolean regex(int i, int j)
    {
        int n = s.length();
        int m = p.length();
        
        if(i >= n && j >= m)
            return true;
        
        if(j >= m) return false;

        boolean match = i < n && j < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
    
        if(j + 1 < m && p.charAt(j + 1) == '*')
        {
            return (match && regex(i + 1, j)) || regex(i, j + 2);
        }
        else
        {
            return regex(i + 1, j + 1);
        }
    }

}


public class StringRegEx {

  
    public static void main(String[] args) {

        String s = "";
        String p = "a*";

        dp obj = new dp();
        obj.s = s;
        obj.p = p;

         obj.regex(0, 0);

        
    }
}
