package top.gongyanhui.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Gong Yanhui
 * @description 824. 山羊拉丁文
 * @date 2022-04-21 12:02:07
 */
public class M824 {

    public static void main(String[] args) {
        M824 m824 = new M824();

        String str1 = m824.toGoatLatin("I speak Goat Latin");
        System.out.println(str1.equals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa"));

        String str2 = m824.toGoatLatin("The quick brown fox jumped over the lazy dog");
        System.out.println(str2.equals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));
    }

    /**
     * 我的解法
     * 执行用时：7 ms, 在所有 Java 提交中击败了21.44%的用户
     * 内存消耗：41.7 MB, 在所有 Java 提交中击败了5.04%的用户
     */
    public String toGoatLatin1(String sentence) {
        // 分解其中的数据
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            // 判断是否是元音单词开头
            if (isVowel(words[i])) {
                words[i] += "ma";
            } else {
                words[i] = words[i].substring(1) + words[i].charAt(0) + "ma";
            }
            // 加上第索引个单词的缩写
            for (int j = 0; j <= i; j++) {
                words[i] += "a";
            }
        }
        // 将数据进行拼接
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // 是否是元音单词开头
    private boolean isVowel(String word) {
        return  word.charAt(0) == 'a' ||
                word.charAt(0) == 'e' ||
                word.charAt(0) == 'i' ||
                word.charAt(0) == 'o' ||
                word.charAt(0) == 'u' ||
                word.charAt(0) == 'A' ||
                word.charAt(0) == 'E' ||
                word.charAt(0) == 'I' ||
                word.charAt(0) == 'O' ||
                word.charAt(0) == 'U';
    }

    /**
     * 力扣官方解法: (没理解)
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.78%的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了45.30%的用户
     */
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        int n = sentence.length();
        int i = 0, cnt = 1;
        StringBuffer ans = new StringBuffer();

        while (i < n) {
            int j = i;
            while (j < n && sentence.charAt(j) != ' ') {
                ++j;
            }

            ++cnt;
            if (cnt != 2) {
                ans.append(' ');
            }
            if (vowels.contains(sentence.charAt(i))) {
                ans.append(sentence.substring(i, j));
            } else {
                ans.append(sentence.substring(i + 1, j));
                ans.append(sentence.charAt(i));
            }
            ans.append('m');
            for (int k = 0; k < cnt; ++k) {
                ans.append('a');
            }

            i = j + 1;
        }

        return ans.toString();
    }
}
