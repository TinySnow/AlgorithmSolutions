import leetcode.*;
import necessary.ListNode;
import necessary.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
//        int[] test = new int[]{3, 2, 4};
//        int target = 6;
//        System.out.println(Arrays.toString(Question1.twoSum(test, target)));

//        int a = 9;
//        int b = 1999999999;
//        System.out.println(String.valueOf(a + b));

//        String s = new String("abc");
//        System.out.println(Question3.lengthOfLongestSubstring(s));

//        System.out.println(Arrays.toString(Question884.uncommonFromSentences("this apple is sweet", "this apple is sour")));

//        System.out.println(Question1342.numberOfSteps(123));

//        Question1405.longestDiverseString(2,2,1);

//        System.out.println(Question1447.simplifiedFractions(98));

//        System.out.println(Question1984.minimumDifference(new int[]{8216,18083,81861,92320,30808,4467,36436,7960}, 8));

//        Question1020.numEnclaves(new int[][]{{0}, {1}, {1}, {0}, {0}});

//        System.out.println(Question1189.maxNumberOfBalloons("kajfsodivnwoeifalsidhoaweiballonoweooooooooooonsdfnnnnnnnnnnnnnasdihfowudbvadfbbbbbbbbbbbbbbbsdufhwillllllllllllllllllllllnaaaaaaaaaswoeifoaanvosueowllasieowqwpwo"));

//        Question540.singleNonDuplicate(new int[]{1, 1, 2});

//        System.out.println(Question1380.luckyNumbers(new int[][]{{3,7,8},{9,11,13},{15,16,17}}));

//        System.out.println("Final: " + Question969.pancakeSort(new int[]{3, 2, 4, 1}));

//        System.out.println(Question838.push(".....LLL..R..RR...L.R...L...R."));

//        System.out.println(Question917.reverseOnlyLetters("Test1ng-Leet=code-Q!"));

//        System.out.println(Question537.complexNumberMultiply("1+1i", "1+1i"));

//        System.out.println(Question2016.maximumDifference(new int[]{
//                999, 997, 980, 976, 948, 940, 938, 928, 924, 917,
//                907, 907, 881, 878, 864, 862, 859, 857, 848, 840,
//                824, 824, 824, 805, 802, 798, 788, 777, 775, 766,
//                755, 748, 735, 732, 727, 705, 700, 697, 693, 679,
//                676, 644, 634, 624, 599, 596, 588, 583, 562, 558,
//                553, 539, 537, 536, 509, 491, 485, 483, 454, 449,
//                438, 425, 403, 368, 345, 327, 287, 285, 270, 263,
//                255, 248, 235, 234, 224, 221, 201, 189, 187, 183,
//                179, 168, 155, 153, 150, 144, 107, 102, 102, 87,
//                80, 57, 55, 49, 48, 45, 26, 26, 23, 15}));

//        System.out.println(Question6.convert("PAYPALISHIRING", 4));

//        System.out.println(Question258.addDigits(19));

//        System.out.println(Question2104.subArrayRanges(new int[]{4,-2,-3,4,1}));

//        System.out.println(Question504.convertToBase7(100));

//        System.out.println(Question393.validUtf8(new int[]{248,130,130,130}));

//        System.out.println(Arrays.toString(Question599.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
//                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));

//        System.out.println(Question728.selfDividingNumbers(3111, 3126));

//        System.out.println(Question762.countPrimeSetBits(3, 100));

//        System.out.println(Question20.isValid("{[]}"));

//        List<Node> list = new ArrayList<>();
//        list.add(new Node(3));
//        list.add(new Node(2));
//        list.add(new Node(4));
//        Node node = new Node(1,list);
//        System.out.println(Question429.levelOrder(node));

//        System.out.println(Arrays.toString(Question806.numberOfLines(
//                new int[]{3,4,10,4,8,7,3,3,4,9,8,2,9,6,2,8,4,9,9,10,2,4,9,10,8,2},
//        "mqblbtpvicqhbrejb")));

//        System.out.println(Question819.mostCommonWord
//                ("L, P! X! C; u! P? w! P. G, S? l? X? D. w? m? f? v, x? i. z; x' m! " +
//                        "U' M! j? V; l. S! j? r, K. O? k? p? p, H! t! z' X! v. u; F, h; s? X? " +
//                        "K. y, Y! L; q! y? j, o? D' y? F' Z; E? W; W' W! n! p' U. N; w? V' y! " +
//                        "Q; J, o! T? g? o! N' M? X? w! V. w? o' k. W. y, k; o' m! r; i, n. k, " +
//                        "w; U? S? t; O' g' z. V. N? z, W? j! m? W! h; t! V' T! Z? R' w, w? y? y;" +
//                        " O' w; r? q. G, V. x? n, Y; Q. s? S. G. f, s! U? l. o! i. L; Z' X! u. y," +
//                        " Q. q; Q, D; V. m. q. s? Y, U; p? u! q? h? O. W' y? Z! x! r. E, R, r' X'" +
//                        " V, b. z, x! Q; y, g' j; j. q; W; v' X! J' H? i' o? n, Y. X! x? h? u; T?" +
//                        " l! o? z. K' z' s; L? p? V' r. L? Y; V! V' S. t? Z' T' Y. s? i? Y! G? r;" +
//                        " Y; T! h! K; M. k. U; A! V? R? C' x! X. M; z' V! w. N. T? Y' w? n, Z, Z?" +
//                        " Y' R; V' f; V' I; t? X? Z; l? R, Q! Z. R. R, O. S! w; p' T. u? U! n, V," +
//                        " M. p? Q, O? q' t. B, k. u. H' T; T? S; Y! S! i? q! K' z' S! v; L. x; q;" +
//                        " W? m? y, Z! x. y. j? N' R' I? r? V! Z; s, O? s; V, I, e? U' w! T? T! u;" +
//                        " U! e? w? z; t! C! z? U, p' p! r. x; U! Z; u! j; T! X! N' F? n! P' t, X. s; q'",
//                        new String[]{"m","i","s","w","y","d","q","l","a","p","n","t","u","b","o","e","f","g","c","x"}));

//        System.out.println(Arrays.toString(Question821.shortestToChar("abbb", 'b')));

//        System.out.println(Question396.maxRotateFunction(new int[]{4, 3, 2, 6}));

        System.out.println(Question868.binaryGap(13));


    }
}