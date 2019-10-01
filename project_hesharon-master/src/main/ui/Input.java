package ui;

import java.util.Scanner;

public class Input {
    private Scanner input;

    public Input() {
        input = new Scanner(System.in);
    }

    //EFFECTS: removes white space and quotation marks around s
    public String makePrettyString(String s) {
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll("\"|\'", "");
        return s;
    }

    public String getUserInputString() {
        String str = "";
        if (input.hasNext()) {
            str = input.nextLine();
            str = makePrettyString(str);
        }
        return str;
    }
}
