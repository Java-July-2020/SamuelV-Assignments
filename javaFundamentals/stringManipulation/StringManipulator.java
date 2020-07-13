public class StringManipulator {
    public String trimAndConcat(String stringOne, String stringTwo){
        String output = stringOne.trim() + stringTwo.trim();
        return output;
    }
    public Integer getIndexOrNull(String aString, char aCharacter){
        Integer output = aString.indexOf(aCharacter);
        if (output < 0){
            output = null;
        }
        return output;
    }
    public Integer getIndexOrNull(String stringOne, String stringTwo){
        Integer output = stringOne.indexOf(stringTwo);
        if (output < 0){
            output = null;
        }
        return output;
    }
    public String concatSubstring(String stringOne, int startingIndex, int endingIndex, String stringTwo){
        String output = stringOne.substring(startingIndex, endingIndex) + stringTwo;
        return output;
    }
}