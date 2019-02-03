class TextWrapper {

    public static String wrap(String text, int width) {
        if (text == null)
            return "";
        text = text.trim();
        return text.length() <= width ? text : breakTextInLines(text, width);
    }

    private static String breakTextInLines(String text, int width) {
        int breakLineIndex = text.substring(0, width + 1).lastIndexOf(' ');
        breakLineIndex = breakLineIndex == -1 ? width : breakLineIndex;
        String line = text.substring(0, breakLineIndex);
        String nextLines = text.substring(breakLineIndex);
        return line + '\n' + wrap(nextLines, width);
    }
}
