
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumbersToLetters {
	public static void main(String[] args){
	    System.out.println("请输入0-9的数字:");
        //输入按键数字1-9
        String digits=new String();
        Scanner in = new Scanner(System.in);
        while(true){
            digits=in.next();
            if(!digits.matches("[0-9]{1,2}")){
                System.out.println("输入不合法！只能输入0-99的数字,请重新输入：");
            }else{
                break;
            }
        }
        NumbersToLetters test = new NumbersToLetters();
	    System.out.println(test.containLetters(digits));
	}

	public List<String> containLetters(String digits) {
        List<String> strings = new ArrayList<>();
        if (digits.length() == 0) {
            return strings;
        }
        String[] dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //选中的字母组合
        String[] arr = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            arr[i] = dict[digits.charAt(i) - '0' - 2];
        }
        int startStr = 0;//循环下标
        group(arr, startStr, "",strings);
        return strings;
    }

    private static String group(String[] arr, int startStr, String str, List<String> strings) {
        char[] chars1 = arr[startStr].toCharArray();
        for (int j = 0; j < chars1.length; j++) {
            if (startStr == arr.length - 1) {
                strings.add(str + chars1[j]);
            } else {
                //startStr+1:遍历下一个字符组合;str + chars1[j]:拼接当前遍历的字符
                group(arr, startStr+1, str + chars1[j],strings);
            }
        }
        return str;
    }
}
