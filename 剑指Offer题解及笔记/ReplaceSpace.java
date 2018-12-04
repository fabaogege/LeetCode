package exercise.replaceSpace;

/**
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，则输出“We%20are%20happy.”。
 */

import org.omg.CORBA.StructMember;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 思路：
 * 1.O(n2)解法：遍历字符串，每一次找到空格就进行替换，空格替换成%20,
 * 由于1个字符替换成了3个字符，后面的数字都要往后移动2个字节
 * 字符串长度为n，每一个空格后面都有n个字符进行移动，所以时间复杂度为O(n2)
 * 2。O(n)解法：遍历字符串， 计算出空格总数继而计算出替换后的字符串总长度（原长度+空格数*2）
 * 从字符串后面开始复制和替换，准备2个指针，P1P2，P1指向原字符串的末尾，P2指向需要替换后的字符串的末尾，移动P1
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String string1="We are happy.";
        StringBuffer str = new StringBuffer();
        str.append("  ");
        /*System.out.println(new Solution().replaceSpace(string1.toCharArray()));*/
        System.out.println(new Solution().replaceSpace(str));
    }
}
class Solution{
    public static String replaceSpace(StringBuffer str){
        char[] ch = str.toString().toCharArray();
        if(ch==null)
            return null;
        int oldLength=ch.length;
        int spaceCount=0;
        //计算空格数
        for(int i=0;i<oldLength;i++){
            if(ch[i]==' ')
                spaceCount++;
        }
        //新的char[]数组长度
        int newLength=oldLength+spaceCount*2;
        char[] newCh=new char[newLength];
        //2个指针
        int pOld=oldLength-1;
        int PNew=newLength-1;
        while(pOld>=0){
            if(ch[pOld]==' '){
                newCh[PNew--]='0';
                newCh[PNew--]='2';
                newCh[PNew--]='%';

            }else{
                newCh[PNew--]=ch[pOld];
            }
            pOld--;
        }
        return String.valueOf(newCh);
    }
    }
