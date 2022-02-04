import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    public StringCalculator() {}

    private ArrayList<String> getDelims(String input) {
        ArrayList<String> delims = new ArrayList<>();
        if (input.indexOf("//") == 0) {
            int index = input.indexOf("\n");
            String delim = input.substring(2, index);
            if (delim.length() > 1) {
                delims.addAll(List.of(delim.split(",")));
                if (delims.stream().distinct().limit(2).count() > 1) {
                    delims.add(",");
                }
            }
            else {
                delims.add(delim);
            }
            return delims;
        }
        delims.add(",");
        return delims;
    }

    private String formatDelim(ArrayList<String> delims) {
        String delim = String.join("", delims);
        if (delims.size() == 1) {
            return Pattern.quote(delim);
        }
        else {
            return "[" + delim + "]";
        }
    }

    private int sum(ArrayList<String> numbers) {
        int sum = 0;
        for (String num : numbers) {
            int parse = Integer.parseInt(num);
            if (parse < 0) {
                throw new IllegalArgumentException("Negatives not allowed (" + parse + " is invalid)");
            }
            else if (parse <= 1000) {
                sum += parse;
            }
        }
        return sum;
    }

    public int Add(String input) {
        if (input.equals("")) return 0;
        ArrayList<String> delims = getDelims(input);
        String delim = formatDelim(delims);
        String stripped = input.replaceAll("[\n/]", "");
        ArrayList<String> numbers = new ArrayList<>(List.of(stripped.split(delim)));
        numbers.removeAll(Collections.singleton(""));
        return sum(numbers);
    }
}
