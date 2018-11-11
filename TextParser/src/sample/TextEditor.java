package sample;

import java.util.ArrayList;
import java.util.List;

public class TextEditor {

    String scenario;
    List regExps = CustomRegularExpressions.getAllRegexpList();

    public TextEditor() {
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    private String removeTextsUsingRexexp(String string, String regExp) {
        return string.replaceAll(regExp, "");
    }

    public String replaceCarriageReturnWithWhiteSpace(String string) {
        return string.replaceAll("\r", " ");
    }

    public String replaceNewLineWithWhiteSpace(String string) {
        return string.replaceAll("\n", " ");
    }

    private String replaceDoubledWhiteSpaces(String string) {
        return string.replaceAll("  ", " ");
    }

    public String replaceAllDoubledWhiteSpaces(String string) {
        String editedString = string;
        while (editedString.contains("  ")) {
            editedString = replaceDoubledWhiteSpaces(editedString);
        }
        return editedString;
    }

    private String makeAllTextInOneString(String string) {
        String oneStringText;

        oneStringText = replaceNewLineWithWhiteSpace(string);
        oneStringText = replaceCarriageReturnWithWhiteSpace(oneStringText);
        oneStringText = replaceAllDoubledWhiteSpaces(oneStringText);

        return oneStringText;
    }

    public String getScenarioCharactersWords(String string) {
        String editedString = string;

        for (Object regExp : regExps) {
            editedString = removeTextsUsingRexexp(editedString, (String) regExp);
        }

        editedString = makeAllTextInOneString(editedString);

        return editedString;
    }


}
