package com.libmanage.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;  

public class FormattedColumns{

    List<List<String>> lines = new ArrayList<List<String>>();
    List<Integer> maxLengths = new ArrayList<Integer>();
    int numColumns = -1;

    public FormattedColumns addLine(String... line) {

        if (numColumns == -1){
            numColumns = line.length;
            for(int i = 0; i < numColumns; i++) {
                maxLengths.add(0);
            }
        }

        if (numColumns != line.length) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < numColumns; i++) {
            maxLengths.set(  i, Math.max( maxLengths.get(i), line[i].length() )  );
        }

        lines.add( Arrays.asList(line) );

        return this;
    }
	/**
	 * This method helps to print output.
	 */
    public void print(){
        System.out.println( toString() );
    }

    public String toString(){
        String result = Constants.BLANKSTRING;
        for(List<String> line : lines) {
            for(int i = 0; i < numColumns; i++) {
                result += pad( line.get(i), maxLengths.get(i) + 1 );                
            }
            result += Constants.LINECHANGE;
        }
        return result;
    }

    private String pad(String word, int newLength){
        while (word.length() < newLength) {
            word += Constants.SPACESTRING;            
        }       
        return word;
    }
}