class TextWrapper {
    static String wrap(String text, int width) {
        if (text == null)
            return "";
        text = text.trim();
        text = text.length() <= width ? text : breakTextInLines(text, width);
        return text;

    }

    private static String breakTextInLines(String text, int width) {
        int breakLine = text.substring(0, width+1).lastIndexOf(' ');
        breakLine = (breakLine == -1)? width : breakLine;
        String line = text.substring(0, breakLine);
        String nextLines = text.substring(breakLine);
        return line + '\n' + TextWrapper.wrap(nextLines, width);
    }
}
