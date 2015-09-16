package com.robin4.newc;

/**
 * Created by robinmac on 15-9-10.
 */
public class Read4 {

    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
    int read4(char[] buff) {
        buff[0] = 'a';
        return 1;
    }

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        char[] tbuf = new char[4];
        while (true) {
            int size = read4(tbuf);
            int tin = 0;
            for (; index < n && tin < size; index++) {
                buf[index] = tbuf[tin];
                tin++;
            }
            //full
            if (index >= n)
                break;
            //empty file
            if (size < 4)
                break;
        }
        if (index < n)
            buf[index] = '\0';
        return index;
    }

    public int read2(char[] buf, int n) {
        boolean eof = false;      // end of file flag
        int total = 0;            // total bytes have read
        char[] tmp = new char[4]; // temp buffer

        while (!eof && total < n) {
            int count = read4(tmp);

            // check if it's the end of the file
            eof = count < 4;

            // get the actual count
            count = Math.min(count, n - total);

            // copy from temp buffer to buf
            for (int i = 0; i < count; i++)
                buf[total++] = tmp[i];
        }

        return total;
    }

    public static void main(String[] args) {
        Read4 tr4 = new Read4();
        char[] buff = new char[4];
        System.out.println("index: "+tr4.read(buff, 1));
        for (int i = 0; i < buff.length; i++)
            System.out.println(buff[i]);
    }
}
