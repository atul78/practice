package atul.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.*;
import java.util.Arrays;
import java.util.Base64;

/**
 * Created by agosain on 5/3/2017.
 */
public class SSHKeysUtil {
/*
    private static final String KEY_FACTORY_TYPE_RSA = "RSA";
    private static final String KEY_FACTORY_TYPE_DSA = "DSA";
    private static final String KEY_FACTORY_TYPE_ECDSA = "EC";

    private static final String KEY_TYPE_RSA = "ssh-rsa";
    private static final String KEY_TYPE_DSA = "ssh-dss";
    private static final String KEY_TYPE_ECDSA = "ecdsa-sha2-nistp256";

    private byte[] bytes = new byte[0];
    private int pos = 0;



    public PublicKey decodePublicKey(String keyLine) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException {

        // look for the Base64 encoded part of the line to decode
        // both ssh-rsa and ssh-dss begin with "AAAA" due to the length bytes
        bytes = Base64.decodeBase64(keyLine.getBytes());
        if (bytes.length == 0)
            throw new IllegalArgumentException("No Base64 part to decode in " + keyLine);
        pos = 0;

        String type = decodeType();
        if (type.equals(KEY_TYPE_RSA))
            return decodeAsRSA();

        if (type.equals(KEY_TYPE_DSA))
            return decodeAsDSA();

        if(type.equals(KEY_TYPE_ECDSA))
            return decodeAsECDSA();

        throw new IllegalArgumentException("Unknown decode key type " + type + " in " + keyLine);
    }

    private PublicKey decodeAsECDSA()
            throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
        KeyFactory ecdsaFactory = SecurityUtils.getKeyFactory(KEY_FACTORY_TYPE_ECDSA);

        ECNamedCurveParameterSpec spec256r1 = ECNamedCurveTable.getParameterSpec("secp256r1");
        ECNamedCurveSpec params256r1 = new ECNamedCurveSpec("secp256r1", spec256r1.getCurve(), spec256r1.getG(), spec256r1.getN());
        // copy last 65 bytes from ssh key.
        ECPoint point =  ECPointUtil.decodePoint(params256r1.getCurve(), Arrays.copyOfRange(bytes,39,bytes.length));
        ECPublicKeySpec pubKeySpec = new ECPublicKeySpec(point, params256r1);

        return ecdsaFactory.generatePublic(pubKeySpec);
    }

    private PublicKey decodeAsDSA() throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException
    {
        KeyFactory dsaFactory = SecurityUtils.getKeyFactory(KEY_FACTORY_TYPE_DSA);
        BigInteger p = decodeBigInt();
        BigInteger q = decodeBigInt();
        BigInteger g = decodeBigInt();
        BigInteger y = decodeBigInt();
        DSAPublicKeySpec spec = new DSAPublicKeySpec(y, p, q, g);

        return dsaFactory.generatePublic(spec);
    }

    private PublicKey decodeAsRSA() throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
        KeyFactory rsaFactory = SecurityUtils.getKeyFactory(KEY_FACTORY_TYPE_RSA);
        BigInteger exponent = decodeBigInt();
        BigInteger modulus = decodeBigInt();
        RSAPublicKeySpec spec = new RSAPublicKeySpec(modulus, exponent);

        return rsaFactory.generatePublic(spec);
    }

    private String decodeType() {
        int len = decodeInt();
        String type = new String(bytes, pos, len);
        pos += len;
        return type;
    }

    private int decodeInt() {
        return ((bytes[pos++] & 0xFF) << 24) | ((bytes[pos++] & 0xFF) << 16)
                | ((bytes[pos++] & 0xFF) << 8) | (bytes[pos++] & 0xFF);
    }

    private BigInteger decodeBigInt() {
        int len = decodeInt();
        byte[] bigIntBytes = new byte[len];
        System.arraycopy(bytes, pos, bigIntBytes, 0, len);
        pos += len;
        return new BigInteger(bigIntBytes);
    }

    public static String encodePublicKey(PublicKey publicKey) throws IOException {
        String publicKeyEncoded;
        ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
        if(publicKey.getAlgorithm().equals(KEY_FACTORY_TYPE_RSA)){
            RSAPublicKey rsaPublicKey = (RSAPublicKey) publicKey;
            DataOutputStream dout = new DataOutputStream(byteOs);
            dout.writeInt(KEY_TYPE_RSA.getBytes().length);
            dout.write(KEY_TYPE_RSA.getBytes());
            dout.writeInt(rsaPublicKey.getPublicExponent().toByteArray().length);
            dout.write(rsaPublicKey.getPublicExponent().toByteArray());
            dout.writeInt(rsaPublicKey.getModulus().toByteArray().length);
            dout.write(rsaPublicKey.getModulus().toByteArray());
        }
        else if(publicKey.getAlgorithm().equals(KEY_FACTORY_TYPE_DSA)){
            DSAPublicKey dsaPublicKey = (DSAPublicKey) publicKey;
            DSAParams dsaParams = dsaPublicKey.getParams();
            DataOutputStream dout = new DataOutputStream(byteOs);
            dout.writeInt(KEY_TYPE_DSA.getBytes().length);
            dout.write(KEY_TYPE_DSA.getBytes());
            dout.writeInt(dsaParams.getP().toByteArray().length);
            dout.write(dsaParams.getP().toByteArray());
            dout.writeInt(dsaParams.getQ().toByteArray().length);
            dout.write(dsaParams.getQ().toByteArray());
            dout.writeInt(dsaParams.getG().toByteArray().length);
            dout.write(dsaParams.getG().toByteArray());
            dout.writeInt(dsaPublicKey.getY().toByteArray().length);
            dout.write(dsaPublicKey.getY().toByteArray());
        }
        else if(publicKey.getAlgorithm().equals(KEY_FACTORY_TYPE_ECDSA)){
            BCECPublicKey ecPublicKey = (BCECPublicKey) publicKey;
            DataOutputStream dout = new DataOutputStream(byteOs);
            dout.writeInt(KEY_TYPE_ECDSA.getBytes().length);
            dout.write(KEY_TYPE_ECDSA.getBytes());
            dout.writeInt("nistp256".getBytes().length);
            dout.write("nistp256".getBytes());

            byte[] x = ecPublicKey.getQ().getAffineXCoord().getEncoded();
            byte[] y = ecPublicKey.getQ().getAffineYCoord().getEncoded();
            dout.writeInt(x.length+y.length+1);
            dout.writeByte(0x04);
            dout.write(x);
            dout.write(y);
        }
        else{
            throw new IllegalArgumentException(
                    "Unknown public key encoding: " + publicKey.getAlgorithm());
        }
        publicKeyEncoded = new String(Base64.encodeBase64(byteOs.toByteArray()));
        return publicKeyEncoded;

    }

    public static KeyPair parsePrivateKey(String keyPath, String passphrase) throws IOException {
        if(keyPath==null)
            return null;
        FileReader fileReader = new FileReader(keyPath);
        PEMParser keyReader = new PEMParser(fileReader);
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
        PEMDecryptorProvider decryptionProv = new JcePEMDecryptorProviderBuilder().build(passphrase.toCharArray());

        Object privateKey = keyReader.readObject();
        KeyPair keyPair;
        if (privateKey instanceof PEMEncryptedKeyPair) {
            PEMKeyPair decryptedKeyPair = ((PEMEncryptedKeyPair) privateKey).decryptKeyPair(decryptionProv);
            keyPair = converter.getKeyPair(decryptedKeyPair);
        } else {
            keyPair = converter.getKeyPair((PEMKeyPair) privateKey);
        }

        keyReader.close();
        return keyPair;
    }
*/
}
