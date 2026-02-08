/**
 * Given a list paths of directory info, including the directory path, and all
 * the files with contents in this directory, return all the duplicate files in
 * the file system in terms of their paths. You may return the answer in any
 * order.
 * 
 * A group of duplicate files consists of at least two files that have the same
 * content.
 * 
 * A single directory info string in the input list has the following format:
 * 
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ...
 * fn.txt(fn_content)"
 * It means there are n files (f1.txt, f2.txt ... fn.txt) with content
 * (f1_content, f2_content ... fn_content) respectively in the directory
 * "root/d1/d2/.../dm". Note that n >= 1 and m >= 0. If m = 0, it means the
 * directory is just the root directory.
 * 
 * The output is a list of groups of duplicate file paths. For each group, it
 * contains all the file paths of the files that have the same content. A file
 * path is a string that has the following format:
 * 
 * "directory_path/file_name.txt"
 * 
 * 
 * Example 1:
 * 
 * Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c
 * 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
 * Output:
 * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 * Example 2:
 * 
 * Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c
 * 3.txt(abcd)","root/c/d 4.txt(efgh)"]
 * Output: [["root/a/2.txt","root/c/d/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= paths.length <= 2 * 104
 * 1 <= paths[i].length <= 3000
 * 1 <= sum(paths[i].length) <= 5 * 105
 * paths[i] consist of English letters, digits, '/', '.', '(', ')', and ' '.
 * You may assume no files or directories share the same name in the same
 * directory.
 * You may assume each given directory info represents a unique directory. A
 * single blank space separates the directory path and file info.
 */

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> hm = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String path : paths) {
            String arr[] = path.split(" ");
            for (int i = 1; i < arr.length; i++) {
                StringBuilder sb = new StringBuilder(arr[0] + '/');
                String str = arr[i];
                int index = -1;
                for (int j = 0; j < str.length(); j++) {
                    char c = str.charAt(j);
                    if (c == '(') {
                        index = j;
                        break;
                    }
                    sb.append(c);

                }
                String info = str.substring(index + 1, str.length() - 1);
                if (!hm.containsKey(info)) {
                    hm.put(info, new ArrayList<String>());
                }
                hm.get(info).add(sb.toString());
            }

        }
        for (String str : hm.keySet()) {
            if (hm.get(str).size() > 1)
                ans.add(hm.get(str));
        }
        return ans;
    }
}