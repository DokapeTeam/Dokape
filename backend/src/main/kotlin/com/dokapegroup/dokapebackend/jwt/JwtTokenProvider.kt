package com.dokapegroup.dokapebackend.jwt

import com.dokapegroup.dokapebackend.user.DokapeUserDetails
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.UnsupportedJwtException
import org.springframework.stereotype.Component
import java.util.Date

private const val JWT_SECRET = "daylajwtsecretcuadokapegroupneeeee"
private const val JWT_EXPIRATION = 604800000L

@Component
class JwtTokenProvider {
    fun generateToken(userDetails: DokapeUserDetails): String {
        // Lấy thông tin user
        val now = Date()
        val expiryDate = Date(now.time + JWT_EXPIRATION)
        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
            .setSubject(userDetails.user.id.toString())
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
            .compact()
    }

    fun getUserIdFromJWT(token: String?): Long {
        val claims: Claims = Jwts.parser()
            .setSigningKey(JWT_SECRET)
            .parseClaimsJws(token)
            .body
        return claims.subject.toLong()
    }

    fun validateToken(authToken: String?): Boolean {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken)
            return true
        } catch (ex: MalformedJwtException) {
            println("Invalid JWT token")
        } catch (ex: ExpiredJwtException) {
            println("Expired JWT token")
        } catch (ex: UnsupportedJwtException) {
            println("Unsupported JWT token")
        } catch (ex: IllegalArgumentException) {
            println("JWT claims string is empty.")
        }
        return false
    }
}
