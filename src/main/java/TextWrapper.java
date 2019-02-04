class TextWrapper {


    public static String wrap(String text, int width) {
        if (text == null)
            return "";
        if (text.length() <= width) {
            return text.trim();
        }
        return breakText(text, width);
    }

    private static String breakText(String text, int width) {
        int breakPoint = text.substring(0, width+1).lastIndexOf(' ');
        if (breakPoint == -1) {
            breakPoint = width;
        }
        String line = text.substring(0, breakPoint);
        String nextLines = text.substring(breakPoint).trim();
        return line + '\n' + wrap(nextLines, width);
    }
}
