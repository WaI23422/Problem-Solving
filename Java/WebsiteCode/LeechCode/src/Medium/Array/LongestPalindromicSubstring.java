package Medium.Array;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/longest-palindromic-substring/">5.Longest Palindromic Substring</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a string <code>s</code>, return <em>the longest</em> <span data-keyword="palindromic-string" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:ri:"><div><em>palindromic</em></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(284px, 248px);"></div></div></div></span> <span data-keyword="substring-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rk:"><div><em>substring</em></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(56px, 269px);"></div></div></div></span> in <code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "babad"
<strong>Output:</strong> "bab"
<strong>Explanation:</strong> "aba" is also a valid answer.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "cbbd"
<strong>Output:</strong> "bb"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consist of only digits and English letters.</li>
</ul>
</div></div>
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String[] tests = {
            "babad",
            "cbbd",
            "ac",
            "ddc",
            "ccc",
            "abb",
            "aaaa"
        };

        LongestPalindromicSubstring_Solution res = new LongestPalindromicSubstring_Solution();

        for (String s : tests) {
            System.out.println(res.longestPalindrome(s));
        }
    }
}

class LongestPalindromicSubstring_Solution {
    public String longestPalindrome(String s) {
        
        // @see BetterCodeAnswer.Medium.Array.LongestPalindromicSubstring.java

        return "res";
    }
}