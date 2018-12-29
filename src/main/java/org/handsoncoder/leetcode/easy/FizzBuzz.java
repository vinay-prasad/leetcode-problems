package org.handsoncoder.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
        List <String> fizzBizz = new ArrayList<>();
        int fizz =0;
        int buzz =0;
        for (int i=1; i <=n; i++) {
                fizz++;
                buzz++;
                
            if (fizz == 3 && buzz ==5) {
                fizzBizz.add("FizzBuzz");
                fizz = buzz =0;
            }else if (fizz == 3) {
                fizzBizz.add("Fizz");
                fizz =0;
            }else if (buzz == 5) {
                fizzBizz.add("Buzz");
                buzz =0;
            }else {
                fizzBizz.add(i+"");
            }
        }
        return fizzBizz;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
