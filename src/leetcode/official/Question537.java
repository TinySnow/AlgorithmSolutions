package leetcode.official;

public class Question537 {
    public static String complexNumberMultiply(String num1, String num2) {
        int num1Real = Integer.parseInt(num1.split("\\+")[0]);
        int num1Virtual = Integer.parseInt(num1.split("\\+")[1].split("i")[0]);
        int num2Real = Integer.parseInt(num2.split("\\+")[0]);
        int num2Virtual = Integer.parseInt(num2.split("\\+")[1].split("i")[0]);
        int real = num1Real * num2Real - num1Virtual * num2Virtual;
        int virtual = num1Real * num2Virtual + num2Real * num1Virtual;
        return real + "+" + virtual + "i";
    }
}
