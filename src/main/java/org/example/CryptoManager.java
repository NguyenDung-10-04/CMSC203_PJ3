/*
 * Class: CMSC203
 * Instructor: Ahmed Tarek
 * Description: CryptoManager is about methods using for implementation/ CryptoManagerTestStudent is about Testing
 * Due: 3/9/2025
 * Platform/compiler: INTELLIJ
 * I pledge that I have completed the programming  assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: DUNG NGUYEN
 */

package org.example;

public class CryptoManager {

        private static final int LOWER_RANGE = 32;
        private static final int UPPER_RANGE = 95;
        private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

        public static boolean isStringInBounds(String plainText) {
            for (int i = 0; i < plainText.length(); i++) {
                char c = plainText.charAt(i);
                if (c < LOWER_RANGE || c > UPPER_RANGE) return false;
            }
            return true;
        }

        // Mã hóa Caesar Cipher
        public static String caesarEncryption(String plainText, int key) {
            if (!isStringInBounds(plainText)) {
                return "The selected string is not in bounds, Try again.";
            }

            StringBuilder encryptedText = new StringBuilder();
            for (char c : plainText.toCharArray()) {
                int shifted = c + key;

                if (shifted > UPPER_RANGE) {
                    shifted -= RANGE;
                } else if (shifted < LOWER_RANGE) {
                    shifted += RANGE;
                }

                encryptedText.append((char) shifted);
            }
            return encryptedText.toString();
        }


        public static String caesarDecryption(String encryptedText, int key) {
            StringBuilder decryptedText = new StringBuilder();
            for (char c : encryptedText.toCharArray()) {
                int shifted = c - key;

                if (shifted > UPPER_RANGE) {
                    shifted -= RANGE;
                } else if (shifted < LOWER_RANGE) {
                    shifted += RANGE;
                }
                decryptedText.append((char) shifted);
            }
            return decryptedText.toString();
        }


        public static String bellasoEncryption(String plainText, String bellasoStr) {
            StringBuilder encryptedText = new StringBuilder();
            // helloEveryone 13
            // abcd 4
            StringBuilder extendedKey = new StringBuilder(bellasoStr);

            for (int i = bellasoStr.length(); i < plainText.length(); i++) {
                extendedKey.append(bellasoStr.charAt(i % bellasoStr.length()));
            }

            for (int i = 0; i < plainText.length(); i++) {
                char c = plainText.charAt(i);
                char keyChar = extendedKey.charAt(i);
                int shifted = c + keyChar;



                while (shifted > UPPER_RANGE) {
                    shifted -= RANGE;
                }

                while (shifted < LOWER_RANGE) {
                    shifted += RANGE;
                }

                encryptedText.append((char) shifted);
            }

            return encryptedText.toString();
        }

        public static String bellasoDecryption(String encryptedText, String bellasoStr) {
            StringBuilder decryptedText = new StringBuilder();


            for (int i = 0; i < encryptedText.length(); i++) {
                char c = encryptedText.charAt(i);


                char keyChar = bellasoStr.charAt(i % bellasoStr.length());


                int shifted = c - keyChar;


                while (shifted > UPPER_RANGE) {
                    shifted -= RANGE;
                }


                while (shifted < LOWER_RANGE) {
                    shifted += RANGE;
                }

                decryptedText.append((char) shifted);
            }

            return decryptedText.toString();
        }
    }


