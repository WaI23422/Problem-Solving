package Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/number-of-senior-citizens/">2678. Number of Senior Citizens</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> array of strings <code>details</code>. Each element of <code>details</code> provides information about a given passenger compressed into a string of length <code>15</code>. The system is such that:</p>
 * 
 * <ul>
 * 	<li>The first ten characters consist of the phone number of passengers.</li>
 * 	<li>The next character denotes the gender of the person.</li>
 * 	<li>The following two characters are used to indicate the age of the person.</li>
 * 	<li>The last two characters determine the seat allotted to that person.</li>
 * </ul>
 * 
 * <p>Return <em>the number of passengers who are <strong>strictly </strong><strong>more than 60 years old</strong>.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> details = ["7868190130M7522","5303914400F9211","9273338290F4010"]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The passengers at indices 0, 1, and 2 have ages 75, 92, and 40. Thus, there are 2 people who are over 60 years old.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> details = ["1313579440F2036","2921522980M5644"]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> None of the passengers are older than 60.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= details.length &lt;= 100</code></li>
 * 	<li><code>details[i].length == 15</code></li>
 * 	<li><code>details[i] consists of digits from '0' to '9'.</code></li>
 * 	<li><code>details[i][10] is either 'M' or 'F' or 'O'.</code></li>
 * 	<li>The phone numbers and seat numbers of the passengers are distinct.</li>
 * </ul>
 * </div>
 */
public class NumberOfSeniorCitizens {
    public static void main(String[] args) {
        String[][] tests = { 
            {"7868190130M7522","5303914400F9211","9273338290F4010"}
        };       
        
        for (String[] details : tests) {
            System.out.println(new NumberOfSeniorCitizens_Solution().countSeniors(details));
        }
    }
}

// 1ms 42.56MB -> 0ms 42.23MB
class NumberOfSeniorCitizens_Solution {
    public int countSeniors(String[] details) {
        int above_60 = 0;
        for (String detail : details) {
            if (getAge(detail) > 60) {
                above_60++;   
            }
            
            // 1ms 42.56MB
            // if (Integer.valueOf(detail.substring(11, 13)) > 60) {
            //     above_60++;
            // }
        }

        return above_60;
    }

    private int getAge(String detail) {
        return (detail.charAt(11)-'0')*10 + (detail.charAt(12)-'0');
    }
}