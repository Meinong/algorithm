package leetcodes;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数
 */
public class 字符串相乘 {

    public static void main(String[] args) {
        String num1= "99";
        String num2= "99";
        String maxStr = num1.length() > num2.length() ? num1 : num2;
        String minStr = maxStr.equals(num1) ? num2 : num1;
        int minWei = 1;
        int maxlast = maxStr.length()-1;
        StringBuffer str = new StringBuffer();
        for (int i=minStr.length()-1 ;i>=0;i--){












            int wei = 1;
            int jinwei = 0;
            while (maxlast >=0){
                int curSum = ((maxStr.charAt(maxlast) - 48)  * (minStr.charAt(i) - 48)) + jinwei;
                jinwei = curSum / 10;
                int sum = curSum % 10;
                maxlast--;
                wei++;
            }
            minWei++;
            maxlast = maxStr.length()-1;
        }


    }


//    public String multiply(String num1, String num2) {
//        if (num1.equals("0") || num2.equals("0")) {
//            return "0";
//        }
//        String ans = "0";
//        int m = num1.length(), n = num2.length();
//        for (int i = n - 1; i >= 0; i--) {
//            StringBuffer curr = new StringBuffer();
//            int add = 0;
//            for (int j = n - 1; j > i; j--) {
//                curr.append(0);
//            }
//            int y = num2.charAt(i) - '0';
//            for (int j = m - 1; j >= 0; j--) {
//                int x = num1.charAt(j) - '0';
//                int product = x * y + add;
//                curr.append(product % 10);
//                add = product / 10;
//            }
//            if (add != 0) {
//                curr.append(add % 10);
//            }
//            ans = addStrings(ans, curr.reverse().toString());
//        }
//        return ans;
//    }
//
//    public String addStrings(String num1, String num2) {
//        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
//        StringBuffer ans = new StringBuffer();
//        while (i >= 0 || j >= 0 || add != 0) {
//            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
//            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
//            int result = x + y + add;
//            ans.append(result % 10);
//            add = result / 10;
//            i--;
//            j--;
//        }
//        ans.reverse();
//        return ans.toString();
//    }



    //99980001

}
