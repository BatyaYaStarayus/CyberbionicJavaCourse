package sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public enum CustomRegularExpressions {

    ALL_SYMBOLS_INSIDE_THE_BRACKETS("[(](.*?)[)]"),
    ALL_SYMBOLS_INSIDE_THE_TAG("[<](.*?)[>]"),
    SYNC_BY("Sync & corrections by honeybunny"),
    RE_SYNC_BY("Resync for WEB-DL by lost0ne"),
    WEBSITE("[w]{3}(.*)([.com])"),
    DIGITS("\\d"),
    ARROW("-->"),
    CHARACTER("(.*?)[:]"),
    PUNCTUATION_SYMBOLS("[.,?!]"),
    DOUBLE_DASH("(--)"),
    SOLID_DASH("(- )");

    private static final List<String> ALL_REG_EXPS;
    private final String regexp;

    static {
        ALL_REG_EXPS = new ArrayList<>();
        for (CustomRegularExpressions customRegExp : CustomRegularExpressions.values()) {
            ALL_REG_EXPS.add(customRegExp.regexp);
        }
    }

    CustomRegularExpressions(String regExp) {
        this.regexp = regExp;
    }

    public String getRegexp() {
        return regexp;
    }

    public static List<String> getAllRegexpList() {
        return ALL_REG_EXPS;
    }


}
