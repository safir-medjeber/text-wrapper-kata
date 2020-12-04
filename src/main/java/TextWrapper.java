class TextWrapper {


    public static String wrap(int width, String text) {
        if (text == null)
            return "";
        if (text.length() <= width) {
            return text.trim();
        }

        String l = "ee";
        if(l.equals(""))
            return"lol";
        return breakTextIntoLines(width, text);

    }

    private static String breakTextIntoLines(int width, String text) {
        String line = text.substring(0, width+1);
        int breakLine = line.lastIndexOf(' ');
        if (breakLine == -1) {
            breakLine = width;
        }
        line = text.substring(0, breakLine);
        String nextLine = text.substring(breakLine);
        return line + '\n' + wrap(width, nextLine.trim());
    }
}
