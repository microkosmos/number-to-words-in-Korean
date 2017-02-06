/**
 * 숫자를 한글로 출력하는 프로그램
 * 2017.02.06
 */

public class Translator {
    public static void main(String[] args) {
        System.out.println(0 + " (" + translate(0) + ")");
        System.out.println(1 + " (" + translate(1) + ")");
        System.out.println(1000 + " (" + translate(1000) + ")");
        System.out.println(1234 + " (" + translate(1234) + ")");
        System.out.println(9999999 + " (" + translate(9999999) + ")");
        System.out.println(100700900 + " (" + translate(100700900) + ")");
        System.out.println(Integer.MAX_VALUE + " (" + translate(Integer.MAX_VALUE) + ")");
        System.out.println(-1 + " (" + translate(-1) + ")");
    }

    public static String translate(int input) {
        if (input == 0) {
            return "영";
        }

        if (input < 0) {
            return "입력범위 오류. 유효범위(0~2147483647)";
        }

        String val = String.valueOf(input);
        StringBuilder sb = new StringBuilder();

        int i = 1;
        int position = val.length();

        for ( ; position > 0; ) {
            String num = val.substring(position - 1, position);

            if (!("0".equals(num))) {
                sb.append(getUnit(i));
                sb.append(number2words(num));
            }

            position--;
            i++;
        }

        sb.reverse();
        String result = sb.toString();

        result = result.replace("일천", "천");
        result = result.replace("일백", "백");
        result = result.replace("일십", "십");

        return result;
    }

    public static String number2words(String str) {
        switch (str) {
            case "0": return "영";
            case "1": return "일";
            case "2": return "이";
            case "3": return "삼";
            case "4": return "사";
            case "5": return "오";
            case "6": return "육";
            case "7": return "칠";
            case "8": return "팔";
            case "9": return "구";

            default: return "";
        }
    }

    public static String getUnit(int i) {
        switch (i) {
            case 2: return "십";
            case 3: return "백";
            case 4: return "천";
            case 5: return "만";
            case 6: return "십";
            case 7: return "백";
            case 8: return "천";
            case 9: return "억";
            case 10: return "십";
            case 11: return "백";
            case 12: return "천";
            case 13: return "조";

            default: return "";
        }
    }
}
