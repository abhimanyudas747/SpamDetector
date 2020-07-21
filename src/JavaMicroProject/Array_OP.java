/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMicroProject;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




 class Array_OP{
    
     //fun() take string input and convert it into lower case
     public String to_lower_case(String input){
         String output = input.toLowerCase();
         return output;
     }
     //fun take string input & return array of string
    public String[] array_of_string(String input){
        String[] output = input.split(" ");
        return output;
    }
    
    //fun print all element of array of string
    public void array_of_string_print(String[] input){
        int len;
        len = input.length;
        int j;
        for(j=0;j<len;j++){
            System.out.println(j +" - " +input[j]);
        }
    }
    private String removeUrl(String commentstr)
    {
        String urlPattern = "((https?|ftp|gopher|telnet|file|Unsure|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern p = Pattern.compile(urlPattern,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(commentstr);
        int i = 0;
        while (m.find()) {
            commentstr = commentstr.replaceAll(m.group(i),"XURLX").trim();
            i++;
        }
        return commentstr;
    }
    //fun() input string and output fress string
    public String prepareEmail(String email) {
    int beginIndex = email.indexOf("\n\n");
    String withoutHeader = email;
    if (beginIndex > 0) {
        withoutHeader = email.substring(beginIndex, email.length());
    }
    String urlReplaced = removeUrl(withoutHeader);
    String tagsRemoved = urlReplaced.replaceAll("<[^<>]+>", " ");
    String numberedReplaced = tagsRemoved.replaceAll("[0-9]+", " XNUMBERX ");
     numberedReplaced = numberedReplaced.replaceAll("www", "XURLX");
    String emailReplaced = numberedReplaced.replaceAll("[^\\s]+@[^\\s]+", " XEMAILX ");
    String dollarReplaced = emailReplaced.replaceAll("[$]+", " XMONEYX ");
    String euroReplaced = dollarReplaced.replaceAll("[£]+", " XMONEYX ");
    String yenReplaced = euroReplaced.replaceAll("[¥]+", " XMONEYX ");
    return yenReplaced;
}
  
    //fun() for 2nd step of prepareEmail
    public String symbolReplace(String input){
        String input1 = input.replace('-',' ');
        input1 = input.replace('!',' ');
        input1 = input1.replace('@',' ');
        input1 = input1.replace('#',' ');
        input1 = input1.replace('$',' ');
        input1 = input1.replace('%',' ');
        input1 = input1.replace('^',' ');
        input1 = input1.replace('&',' ');
        input1 = input1.replace('(',' ');
        input1 = input1.replace(')',' ');
        input1 = input1.replace('-',' ');
        input1 = input1.replace('_',' ');
        input1 = input1.replace('+',' ');
        input1 = input1.replace('=',' ');
        input1 = input1.replace('[',' ');
        input1 = input1.replace(']',' ');
        input1 = input1.replace('`',' ');
        input1 = input1.replace('|',' ');
        input1 = input1.replace('{',' ');
        input1 = input1.replace('}',' ');
        input1 = input1.replace(';',' ');
        input1 = input1.replace('.',' ');
        input1 = input1.replace(',',' ');
        input1 = input1.replace('<',' ');
        input1 = input1.replace('>',' ');
        input1 = input1.replace('?',' ');
        input1 = input1.replace('"',' ');
        input1 = input1.replace('/',' ');
        input1 = input1.replace(':',' ');
        input1 = input1.replaceAll("\\s+", " ");
        return input1;
        
    }
    //fun() for word stemmer; input = String ,output = string
    //Problem with this statement
   /* 
    List<String> tokenizeIntoWords(String dollarReplaced) {
    String delim = "[' @$/#.-:&*+=[]?!(){},''\\\">_<;%'\t\n\r\f";
    StringTokenizer stringTokenizer = new StringTokenizer(dollarReplaced, delim);
    List<String> wordsList = new ArrayList<>();
    while (stringTokenizer.hasMoreElements()) {
        String word = (String) stringTokenizer.nextElement();
        String nonAlphaNumericRemoved = word.replaceAll("[^a-zA-Z0-9]", "");
        PorterStemmer stemmer = new PorterStemmer();
        stemmer.setCurrent(nonAlphaNumericRemoved);
        stemmer.stem();
        String stemmed = stemmer.getCurrent();
        wordsList.add(stemmed);
    }
    return wordsList;
}
*/
    //fun() master function; input = string ;output = array of string
    public String[] master(String input){
        String input1 = to_lower_case(input);
        input1 = prepareEmail(input1);
        input1 = symbolReplace(input1);
       
        String[] output = array_of_string(input1);
        return output;
                          
  }
} 