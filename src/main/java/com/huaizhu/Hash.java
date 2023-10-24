package com.huaizhu;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.DatatypeConverterInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class Hash {
    private MessageDigest hash;

    public Hash(String algorithm){
        try {
            hash = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String hashCode(String input){
        return DatatypeConverter.printHexBinary(hash.digest(input.getBytes())).toUpperCase();
    }

    public static void main(String[] args) {

        System.out.println("支持的算法");
        for (String str:Security.getAlgorithms("MessageDigest")){
            //SHA-384
            //SHA-224
            //SHA-512/256
            //SHA-256
            //MD2
            //SHA-512/224
            //SHA
            //SHA-512
            //MD5
            System.out.println(str);
        }
        System.out.println("==============");

        String algorithm = "SHA";
        Hash hash = new Hash(algorithm);

        String input = "abcdefgshshslk";
        System.out.println(hash.hashCode(input));
    }

}
