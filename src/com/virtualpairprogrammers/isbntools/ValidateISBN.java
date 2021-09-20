package com.virtualpairprogrammers.isbntools;

public class ValidateISBN {

    public boolean checkISBN(String isbn) {
        if (isbn.length() == 13) {

            return isThisAValid13DigitISBN(isbn);
        } else {
            if (isbn.length() != 10) throw new NumberFormatException(" ISBN numbers must be 10 or 13 digits long");

            return
                    isThisAValid10DigitISBN(isbn);

        }

    }

    public boolean isThisAValid10DigitISBN(String isbn) {
        int total = 0;

        for (int i = 0; i < 10; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("ISBN numbers can only contain numeric digits");
                }
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
//                total += isbn.charAt(i) * (10 - i);
            }
        }


        return total % 11 == 0;
    }

    private boolean isThisAValid13DigitISBN(String isbn) {
        int total = 0;

        for(int i = 0; i < 13; i++){
            if(i % 2 == 0){
                total += Character.getNumericValue(isbn.charAt(i));
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }

        return total % 10 == 0;
    }
}
