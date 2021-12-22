public class Solution {
    private static int count = 0;

    public static void main(String[] args) {
        permutation("", "megsieihn");
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) unZipPasswordProtectedFiles("C:\\file.zip", prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    public static void unZipPasswordProtectedFiles(String zipFilePath, String password){
        // Get unzip file path by removing .zip from the zipped file name
        String unZipFilePath = zipFilePath.substring(0, zipFilePath.lastIndexOf("."));;
        try {
            ZipFile zipFile = new ZipFile(zipFilePath);
            // provide password if encrypted
            if(zipFile.isEncrypted()){
                count++;
                System.out.println("Trying with " + password + " combination " + count + "/90720");
                zipFile.setPassword(password.toCharArray());
            }
            // unzip
            zipFile.extractAll(unZipFilePath);
            System.out.println("Success password was " + password);
            System.exit(0);
        } catch (IOException e) {
        }
    }
}
