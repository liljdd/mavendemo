package apacheCommonsTest.codecTest;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author lilj
 * @date 18/12/18
 */
public class CodecTest {
    /**
     * Base64编解码
     */
    @Test
    public void Base64Test() throws UnsupportedEncodingException {
        String s = "wo 爱 you!";
        Base64 base64 = new Base64();
        //编码
        String str = base64.encodeToString(s.getBytes("UTF-8"));
        String str2 = Base64.encodeBase64String(s.getBytes("UTF-8"));
        System.out.println("Base64 编码后：" + str);
        System.out.println("Base64 编码后：" + str2);

        //解码
        byte[] decode = base64.decode(str.getBytes());
        byte[] decode2 = Base64.decodeBase64(str);
        System.out.println("解码： " + decode + "->" + ArrayUtils.toString(decode));
        System.out.println("解码： " + decode2 + "->" + ArrayUtils.toString(decode2));

        //编码
        String decStr1 = base64.encodeToString(decode);
        String decStr2 = Base64.encodeBase64String(decode);
        System.out.println("Base64 编码后：" + decStr1);
        System.out.println("Base64 编码后：" + decStr2);

        str = new String(decode2);
        System.out.println("Base64 解码后：" + str);
    }

    /**
     * Hex编解码
     */
    @Test
    public void HexTest() throws UnsupportedEncodingException, DecoderException {
        String s = "wo 爱 you!";
        //编码
        char[] cha = Hex.encodeHex(s.getBytes());
        String str = Hex.encodeHexString(s.getBytes("utf-8"));
        System.out.println(ArrayUtils.toString(cha));
        System.out.println(str);

        //解码
        byte[] bytes = Hex.decodeHex(cha);
        System.out.println(new String(bytes));

        Hex hex = new Hex();
        byte[] decode = hex.decode(str.getBytes());
        System.out.println(new String(decode));
    }

    /**
     * MD5加密
     * MD5是单向加密的，不可逆
     */
    @Test
    public void MD5Test() {
        String s = "wo 爱 you!123";
        // 加密
        byte[] bytes = DigestUtils.md5(s);

        //Base64编码
        String s1 = Base64.encodeBase64String(bytes);
        String s2 = Base64.encodeBase64URLSafeString(bytes);
        System.out.println("加密后： " + s1);
        System.out.println("加密后： " + s2);

        //Hex编码
        //Hex.encodeHexString(md5(data))
        String str1 = DigestUtils.md5Hex(s);
        String str2 = Hex.encodeHexString(bytes);
        System.out.println("加密后： " + str1);
        System.out.println("加密后： " + str2);

    }

    @Test
    public void test03() {

    }

}
