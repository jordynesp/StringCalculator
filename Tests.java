public class Tests {
    public static void testWithEmptyString(StringCalculator calculator) {
        int output = calculator.Add("");
        int expectedOutput = 0;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithEmptyString");
    }

    public static void testWithOneNum(StringCalculator calculator) {
        int output = calculator.Add("1");
        int expectedOutput = 1;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithOneNum");
    }

    public static void testWithTwoNums(StringCalculator calculator) {
        int output = calculator.Add("1,2");
        int expectedOutput = 3;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithTwoNums");
    }

    public static void testWithMultipleNums(StringCalculator calculator) {
        int output = calculator.Add("1,2,5");
        int expectedOutput = 8;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithMultipleNums");
    }

    public static void testWithMultipleCommas(StringCalculator calculator) {
        int output = calculator.Add(",1,4,");
        int expectedOutput = 5;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithMultipleCommas");
    }

    public static void testWithNewline(StringCalculator calculator) {
        int output = calculator.Add("1\n,2,3");
        int expectedOutput = 6;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithNewline");
    }

    public static void testWithMultipleNewlines(StringCalculator calculator) {
        int output = calculator.Add("\n1,\n2\n,4\n");
        int expectedOutput = 7;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithMultipleNewlines");
    }

    public static void testWithCustomDelim(StringCalculator calculator) {
        int output = calculator.Add("//;\n1;3;4");
        int expectedOutput = 8;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithCustomDelim");
    }

    public static void testWithNegNum(StringCalculator calculator) {
        String expectedOutput = "Negatives not allowed";
        try {
            int output = calculator.Add("//@\n1@-3@4@");
            System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithNegNum");
        }
        catch(Exception e) {
            System.out.println("caught: " + e.getMessage() + ", expected: " + expectedOutput + " -> testWithNegNum");
        }
    }

    public static void testWithLargeNum(StringCalculator calculator) {
        int output = calculator.Add("2,1001,2");
        int expectedOutput = 4;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithLargeNum");
    }

    public static void testWithArbDelimLen(StringCalculator calculator) {
        int output = calculator.Add("//***\n1***2***3");
        int expectedOutput = 6;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithArbDelimLen");
    }

    public static void testWithDiffArbDelimLen(StringCalculator calculator) {
        int output = calculator.Add("//[[\n1[[4[[2[[");
        int expectedOutput = 7;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithDiffArbDelimLen");
    }

    public static void testWithMultipleDelim(StringCalculator calculator) {
        int output = calculator.Add("//$,@,%\n1$2@3\n%3");
        int expectedOutput = 9;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithMultipleDelim");
    }

    public static void testWithDiffMultipleDelim(StringCalculator calculator) {
        int output = calculator.Add("//(,#,$,&\n1&1$1#1(1");
        int expectedOutput = 5;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithDiffMultipleDelim");
    }

    public static void testWithMultipleDelimArbLen(StringCalculator calculator) {
        int output = calculator.Add("//!,@@,###,$$$$\n1@@2\n$$$$3!2###1");
        int expectedOutput = 9;
        System.out.println("output: " + output + ", expected: " + expectedOutput + " -> testWithMultipleDelimArbLen");
    }

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        testWithEmptyString(calculator);
        testWithOneNum(calculator);
        testWithTwoNums(calculator);
        testWithMultipleNums(calculator);
        testWithMultipleCommas(calculator);
        testWithNewline(calculator);
        testWithMultipleNewlines(calculator);
        testWithCustomDelim(calculator);
        testWithNegNum(calculator);
        testWithLargeNum(calculator);
        testWithArbDelimLen(calculator);
        testWithDiffArbDelimLen(calculator);
        testWithMultipleDelim(calculator);
        testWithDiffMultipleDelim(calculator);
        testWithMultipleDelimArbLen(calculator);
    }
}
