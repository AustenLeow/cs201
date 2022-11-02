// Group Name (e.g. GXTX) :  G2T6
// 
// Instructions  
// 1. You will only submit this file and output_data10000.txt_verify1000.txt.txt in eLearn
// 2. You are only allowed to use the Java Standard Library classes
// 3. Do not modify the variables and methods given except for the implementation of HashCode()
// 4. You can create additional Private variables and methods
// 5. Do not modify any other files to execute the application
// 6. Refer to the project documents write-up and Piazza for clarifications

public class DNASequence {

    // hashmap to store the Strings
    // private final static HashMap<String, Integer> map = new HashMap<String, Integer>();
    // private final static HashMap <Integer, Integer> hashMap = new HashMap<>();
    // private static int count = 0;

    // public static boolean computeSimilarity(String mapkey, String newSequence) {
    //     int numCharMisMatched = 0;
    //     for (int i = 0; i < mapkey.length(); i++) {
    //         if (mapkey.charAt(i) != newSequence.charAt(i)) {
    //             numCharMisMatched++;
    //         }
    //     }
    //     if (numCharMisMatched > 6) {
    //         return false;
    //     }
    //     return true;
    // }

    private String sequence;

    public DNASequence(String sequence) {
        this.sequence = sequence;
    }

    public String getSequence() {
        return sequence;
    }

    public String toString() {
        return sequence;
    }

    public int hashCode() {
        String sequence1 = sequence.substring(2, sequence.length());
        int hash = 0;
        // System.out.println(sequence1);
        int length = sequence1.length();
        // int l1 = length / 10;

        for (int i = 0; i < length ; i += 2) {
             for(int j= 0; j < 1 ; j++){

                switch (sequence1.charAt(j + i)) {
                    case 'A':
                        hash += 1;
                        break;
                    case 'C':
                        hash += 2;
                        break;
                    case 'G':
                        hash += 3;
                        break;
                    case 'T':
                        hash += 4;
                }
            }
            
            hash <<= 2;
        }
        return hash;
    }
}

// import java.util.*;
// import java.io.*;

// // Group Name (e.g. GXTX) : 
// // 
// // Instructions  
// // 1. You will only submit this file and output_data10000.txt_verify1000.txt.txt in eLearn
// // 2. You are only allowed to use the Java Standard Library classes
// // 3. Do not modify the variables and methods given except for the implementation of HashCode()
// // 4. You can create additional Private variables and methods
// // 5. Do not modify any other files to execute the application
// // 6. Refer to the project documents write-up and Piazza for clarifications

// public class DNASequence {

//     private String sequence;

//     public DNASequence(String sequence) {
//         this.sequence = sequence;
//     }
//     public String getSequence(){
//         return sequence;
//     }

//     public String toString() {
//         return sequence;
//     }

//     public int hashCode() {
//         // int h = 1;
//         // int b = 1;
//         // int c = 1;
//         // int d = 1;
//         // for (int i=0; i < sequence.length(); i++) {
//         //     h *= 128;
//         //     b *= 32;
//         //     c *= 64;
//         //     d *= 256;
//         //     if (sequence.charAt(i) == 'A') {
//         //         h += 1;
//         //         b += 1;
//         //         c += 1;
//         //         d += 1;
//         //     }
//         //     if (sequence.charAt(i) == 'C') {
//         //         h += 2;
//         //         b += 2;
//         //         c += 2;
//         //         d += 2;
//         //     }
//         //     if (sequence.charAt(i) == 'G') {
//         //         h += 3;
//         //         b += 3;
//         //         c += 3;
//         //         d += 3;
//         //     }
//         //     if (sequence.charAt(i) == 'T') {
//         //         h += 4;
//         //         b += 4;
//         //         c += 4;
//         //         d += 4;
//         //     }
//         // }

//         // return b;

//         List<String> verifyList = new ArrayList<>();

//         try {
//             File myObj = new File("verify1000.txt");
//             Scanner myReader = new Scanner(myObj);
//             while (myReader.hasNextLine()) {
//               String data = myReader.nextLine();
//               verifyList.add(data);
//             }
//             myReader.close();
//         } catch (FileNotFoundException e) {
//             System.out.println("An error occurred.");
//             e.printStackTrace();
//         }

//         for (int a = 0; a < verifyList.size(); a++) {
//             int distance = mismatch(verifyList.get(a), sequence);
//             if (distance <= 6) {
//                 return a;       
//             }
//         }
//         return verifyList.size() + 1;
//     }

//     private static int mismatch(String str1, String str2) {
//         int count = 0;
//         for (int i =0; i < str1.length(); i++) {
//             if (str1.charAt(i) != str2.charAt(i)) {
//                 count += 1;
//             }
//         } 
//         return count;
//     }

//     private static int EditDistDP(String str1, String str2)
//     {
//     int len1 = str1.length();
//     int len2 = str2.length();
 
//     // Create a DP array to memoize result
//     // of previous computations
//     int [][]DP = new int[2][len1 + 1];
 
 
//     // Base condition when second String
//     // is empty then we remove all characters
//     for (int i = 0; i <= len1; i++)
//         DP[0][i] = i;
 
//     // Start filling the DP
//     // This loop run for every
//     // character in second String
//     for (int i = 1; i <= len2; i++)
//     {
       
//         // This loop compares the char from
//         // second String with first String
//         // characters
//         for (int j = 0; j <= len1; j++)
//         {
           
//             // if first String is empty then
//             // we have to perform add character
//             // operation to get second String
//             if (j == 0)
//                 DP[i % 2][j] = i;
 
//             // if character from both String
//             // is same then we do not perform any
//             // operation . here i % 2 is for bound
//             // the row number.
//             else if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
//                 DP[i % 2][j] = DP[(i - 1) % 2][j - 1];
//             }
 
//             // if character from both String is
//             // not same then we take the minimum
//             // from three specified operation
//             else {
//                 DP[i % 2][j] = 1 + Math.min(DP[(i - 1) % 2][j],
//                                        Math.min(DP[i % 2][j - 1],
//                                            DP[(i - 1) % 2][j - 1]));
//             }
//         }
//     }
 
//     // after complete fill the DP array
//     // if the len2 is even then we end
//     // up in the 0th row else we end up
//     // in the 1th row so we take len2 % 2
//     // to get row
//     return DP[len2 % 2][len1];
// }




    // public int hashCode() {

    //     if (map.containsKey(sequence)) {
    //         return map.get(sequence);
    //     }

    //     int hashCode = 0;

    //     for (int i = 0; i < sequence.length(); i++) {
    //         hashCode *= 8;

    //         switch (sequence.charAt(i)) {
    //             case 'A':
    //                 hashCode += 0;

    //                 break;
    //             case 'C':
    //                 hashCode += 1;

    //                 break;
    //             case 'G':
    //                 hashCode += 2;

    //                 break;
    //             case 'T':
    //                 hashCode += 3;

    //                 break;
    //             default:
    //                 break;
    //         }

    //     }

    //     if (count > 10000) {
    //         for (String string : map.keySet()) {
    //             if (computeSimilarity(string, sequence)) {
    //                 return map.get(string);
    //             }
    //         }
    //     } else {
    //         while (checkIfEmpty(hashCode)) {
    //             hashCode *= 8;
    //         }
    //         hashMap.put(hashCode, 1);
    //     }

    //     map.put(sequence, hashCode);
    //     count++;
    //     return hashCode;
    // }





    // public int hashCode() {

    // int hashCode = 0;

    // for (int i = 0; i < sequence.length(); i++) {

    // // if (i % 2 == 0) {
    // // hashCode *= 128;
    // // } else {
    // // hashCode *= 128;
    // // }

    // hashCode *= 32;
    // switch (sequence.charAt(i)) {
    // case 'A':
    // hashCode += 0;

    // break;
    // case 'C':
    // hashCode += 1;

    // break;
    // case 'G':
    // hashCode += 2;

    // break;
    // case 'T':
    // hashCode += 3;

    // break;
    // default:
    // break;
    // }

    // }

    // int hashCode2 = 0;

    // for (int i = 0; i < sequence.length(); i++) {

    // // if (i % 2 == 0) {
    // // hashCode *= 128;
    // // } else {
    // // hashCode *= 128;
    // // }

    // hashCode2 *= 32;
    // switch (sequence.charAt(i)) {
    // case 'A':
    // hashCode2 += hashCode;

    // break;
    // case 'C':
    // hashCode2 += hashCode + 1;

    // break;
    // case 'G':
    // hashCode2 += hashCode + 2;

    // break;
    // case 'T':
    // hashCode2 += hashCode + 3;

    // break;
    // default:
    // break;
    // }

    // }

    // return hashCode + hashCode2;
    // }

    // Highest 0.39 //490 found 510 not found
    // public static void main(String[] args) {
    // System.out.println(new DNASequence("TGTTTTACAACACGCT").hashCode());
    // // //32*0
    // System.out.println(new DNASequence("CACGCT").hashCode());
    // System.out.println(new DNASequence("TCGCAC").hashCode());

    // }

    // 32 - 6
    // 16 - 6
    // 8 - 11
    // 4 - 16

    // public int hashCode() {
    // // TODO Auto-generated method stub
    // return sequence.hashCode();
    // }

    // public int hashCode() {
    // String seq1 = sequence.substring(0, 8);

    // int code1 = 0;
    // for (char c : seq1.toCharArray()) {
    // switch (c) {
    // case 'A':
    // // hashCode = (hashCode << 5 | hashCode >>> 27);
    // // code1 *= 32;
    // code1 += 0;

    // break;
    // case 'C':
    // // hashCode = (hashCode << 5 | hashCode >>> 27);
    // // code1 *= 32;
    // code1 += 1;

    // break;
    // case 'G':
    // // hashCode = (hashCode << 5 | hashCode >>> 27);
    // // code1 *= 32;
    // code1 += 2;

    // break;
    // case 'T':
    // // hashCode = (hashCode << 5 | hashCode >>> 27);
    // // code1 *= 32;
    // code1 += 3;

    // break;
    // default:
    // break;
    // }
    // }

    // int code2 = 0;
    // for (char c : seq1.toCharArray()) {
    // switch (c) {
    // case 'A':
    // // hashCode = (hashCode << 5 | hashCode >>> 27);
    // // code1 *= 32;
    // code2 += 0;

    // break;
    // case 'C':
    // // hashCode = (hashCode << 5 | hashCode >>> 27);
    // // code1 *= 32;
    // code2 += 1;

    // break;
    // case 'G':
    // // hashCode = (hashCode << 5 | hashCode >>> 27);
    // // code1 *= 32;
    // code2 += 2;

    // break;
    // case 'T':
    // // hashCode = (hashCode << 5 | hashCode >>> 27);
    // // code1 *= 32;
    // code2 += 3;

    // break;
    // default:
    // break;
    // }
    // }

    // return (code1 << 1) ^ code1 ^ code2 ^ (code2 >> 3);
    // }