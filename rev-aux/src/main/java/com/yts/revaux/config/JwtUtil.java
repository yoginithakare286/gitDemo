package com.yts.revaux.config;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.Date;

@Component
public class JwtUtil {

	private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    private static final byte[] SECRET_KEY = "your_super_secret_key_which_is_at_least_32_bytes_long".getBytes(StandardCharsets.UTF_8);
    private static final long EXPIRATION_TIME = 3600000; // 1 hour

    public String generateToken(UserDetails userDetails) {
        try {
            JWSSigner signer = new MACSigner(SECRET_KEY);
            SignedJWT signedJWT = new SignedJWT(
                    new JWSHeader(JWSAlgorithm.HS256),
                    new com.nimbusds.jwt.JWTClaimsSet.Builder()
                            .subject(userDetails.getUsername())
                            .issueTime(new Date())
                            .expirationTime(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                            .build()
            );

            signedJWT.sign(signer);
            return signedJWT.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException("Error generating JWT", e);
        }
    }

    public String extractUsername(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            return signedJWT.getJWTClaimsSet().getSubject();
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing JWT", e);
        }
    }

    public boolean validateToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(SECRET_KEY);

            boolean isVerified = signedJWT.verify(verifier);
            boolean isExpired = signedJWT.getJWTClaimsSet().getExpirationTime().before(new Date());

            logger.info("🔍 Token Verification: " + isVerified);
            logger.info("🔍 Token Expired: " + isExpired);

            return isVerified && !isExpired;
        } catch (JOSEException | ParseException e) {
            logger.error("❌ Error validating JWT", e);
            return false;
        }
    }


}
