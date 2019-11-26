package concurrent;


public class BigTest {

    public static void main(String[] args) {
//        System.out.println(add("100", "222222"));
//        System.out.println(subtract("11111", "2"));
//        System.out.println(multiply("20", "100"));
//        System.out.println(divide2("10000000"));

        System.out.println(calculate("1","100"));
    }

    public static String calculate(String num1, String num2) {
        subtract(num1, num2);
        add(num1, num2);
        add(subtract(num1, num2), "1");
        multiply((add(num1, num2)), (add(subtract(num1, num2), "1")));
        return divide2(multiply((add(num1, num2)), (add(subtract(num1, num2), "1"))));
    }

    /**
     * 两数相减
     *
     * @param numStr1 数1
     * @param numStr2 数2
     * @return 结果
     */
    public static String subtract(String numStr1, String numStr2) {
        int numLen1 = numStr1.length();
        int numLen2 = numStr2.length();

        int[] numArray1 = new int[numLen1]; //数字数组
        int[] numArray2 = new int[numLen2];


        // "12345"-> [5,4,3,2,1]
        for (int i = 0; i < numLen1; i++) {
            String c = numStr1.substring(i, i + 1);
            numArray1[numLen1 - i - 1] = Integer.parseInt(c); //低位存字符串尾部数字
        }
        for (int i = 0; i < numLen2; i++) {
            String c = numStr2.substring(i, i + 1);
            numArray2[numLen2 - i - 1] = Integer.parseInt(c); //低位存字符串尾部数字
        }


        int minLen = 0; //取长度小的数位数
        int maxLen = 0; //取长度大的数位数
        int[] maxArray = null; //数值大的数
        if (numLen1 < numLen2) {
            minLen = numLen1;
            maxLen = numLen2;
            maxArray = numArray2;
        } else {
            minLen = numLen2;
            maxLen = numLen1;
            maxArray = numArray1;
            if (numLen1 == numLen2) { //等于
                maxArray = getMaxNumber(numArray1, numArray2);
            }
        }
        int[] minArray = maxArray == numArray1 ? numArray2 : numArray1; //数值小的数

        int[] resultArray = new int[maxLen];

        //大数-小数，同位相减，小于0借位
        int subtracted = 0;
        int i = 0;
        for (; i < minLen; i++) {
            int t = maxArray[i] - minArray[i] - subtracted; //两数相减，再减借位
            if (t < 0) {
                subtracted = 1; //向高位借1，暂存起来
                resultArray[i] = t + 10; //当前位计算结果（借1相当于借了10）
            } else {
                subtracted = 0; //不借位
                resultArray[i] = t; //当前位计算结果
            }
        }
        //大数超出部分减掉借位
        for (; i < maxLen; i++) {
            int t = maxArray[i] - subtracted; //多余位数减掉借位
            if (t < 0) {
                subtracted = 1; //进1
                resultArray[i] = t + 10; //当前位计算结果
            } else {
                subtracted = 0; //不借位
                resultArray[i] = t; //当前位计算结果
            }
        }

        //拼接结果 [1,4,8,2,0] -> 2841
        StringBuilder builder = new StringBuilder();
        boolean highBitNotEqualZero = false; //存在高位不为0的情况，低位0保留
        for (int n = resultArray.length - 1; n >= 0; n--) {
            //如果高位为0,移除
            if (resultArray[n] == 0 && !highBitNotEqualZero && n != 0) { //高位无用的0去除
                continue; //跳过
            } else {
                highBitNotEqualZero = true; //找到不为0的位
                builder.append(resultArray[n]);
            }
        }

        if (maxArray == numArray1) { //第一个数大或相等

        } else {  //第一个数小于第二个数，相减为负数
            builder.insert(0, "-");
        }

        return builder.toString();
    }

    public static String divide2(String num) {
        char chars[] = num.toCharArray();
        int numints[] = new int[chars.length];

        //把char转换成int数组，为什么要减去一个'0'呢？因为要减去0的ascii码得到的就是实际的数字
        for (int i = 0; i < chars.length; i++)
            numints[i] = chars[i] - '0';

        //声明存放结果和两个乘积的容器
        int result[] = new int[chars.length];
        //逐个相除，
        for (int i = 0; i < result.length; i++) {
            result[i] += numints[i] / 2;
            if (numints[i] % 2 != 0) {
                numints[i + 1] += 10;
            }
        }

        //转成string并返回
        String resultStr = "";
        boolean first = true;
        for (int i = 0; i < result.length; i++) {
            if (first && (result[i] == 0)) {
                continue;
            } else {
                first = false;
            }
            resultStr += "" + result[i];
        }
        return resultStr;
    }

    public static String add(String n1, String n2) {
        StringBuffer result = new StringBuffer();

        // 反转字符串
        n1 = new StringBuffer(n1).reverse().toString();
        n2 = new StringBuffer(n2).reverse().toString();

        int len1 = n1.length();
        int len2 = n2.length();
        int maxLen = len1 > len2 ? len1 : len2;

        int c = 0;//进位
        if (len1 < len2) {
            for (int i = len1; i < len2; i++) {
                n1 += "0";
            }
        } else if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                n2 += "0";
            }
        }

//		System.out.println(n1);
//		System.out.println(n2);

        for (int i = 0; i < maxLen; i++) {
            int nSum = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "") + c;
            int ap = nSum % 10;
            result.append(ap);
            c = nSum / 10;


        }
        //最高位进位
        if (c > 0) {
            result.append(c);
        }


        return result.reverse().toString();


    }


    /**
     * 大数相乘基本思想，输入字符串，转成char数组，转成int数组。采用分治思想，每一位的相乘;<br>
     * 公式：AB*CD = AC (BC+AD) BD , 然后从后到前满十进位(BD,(BC+AD),AC)。
     *
     * @param num1
     * @param num2
     */
    public static String multiply(String num1, String num2) {
        //把字符串转换成char数组
        char chars1[] = num1.toCharArray();
        char chars2[] = num2.toCharArray();

        //声明存放结果和两个乘积的容器
        int result[] = new int[chars1.length + chars2.length];
        int n1[] = new int[chars1.length];
        int n2[] = new int[chars2.length];

        //把char转换成int数组，为什么要减去一个'0'呢？因为要减去0的ascii码得到的就是实际的数字
        for (int i = 0; i < chars1.length; i++)
            n1[i] = chars1[i] - '0';
        for (int i = 0; i < chars2.length; i++)
            n2[i] = chars2[i] - '0';

        //逐个相乘，因为你会发现。AB*CD = AC(BC+AD)BD , 然后进位。
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                result[i + j] += n1[i] * n2[j];
            }
        }

        //满10进位，从后往前满十进位
        for (int i = result.length - 1; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        //转成string并返回
        String resultStr = "";
        for (int i = 0; i < result.length - 1; i++) {
            resultStr += "" + result[i];
        }
        return resultStr;
    }

    /**
     * 计算大数
     *
     * @param numArray1 数1
     * @param numArray2 数2
     * @return 大数
     */
    public static int[] getMaxNumber(int[] numArray1, int[] numArray2) {
        for (int i = numArray1.length - 1; i >= 0; i--) {
            if (numArray1[i] > numArray2[i]) {
                return numArray1;
            } else {
                if (numArray1[i] == numArray2[i]) {
                    continue; //待继续比较
                } else {
                    return numArray2;
                }
            }
        }
        return numArray1; //全部相等，返回第一个
    }
}
