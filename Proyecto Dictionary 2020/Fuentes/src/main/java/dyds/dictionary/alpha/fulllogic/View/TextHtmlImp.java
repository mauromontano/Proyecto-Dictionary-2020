package dyds.dictionary.alpha.fulllogic.View;

public class TextHtmlImp {

    public static String textToHtml(String text, String term) {

        StringBuilder builder = new StringBuilder();

        builder.append("<font face=\"arial\">");

        String textWithBold = text
                .replace("'", "`")
                .replaceAll("(?i)" + term, "<b>" + term +"</b>");

        builder.append(textWithBold);

        builder.append("</font>");

        return builder.toString();
    }

}
