//package com.otrebla.educa_facil_360.security;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class JwtUtil {
//    public class JwtUtil {
//
//        private static final String SECRET_KEY = "mysecretkey"; // Use uma chave segura e forte para produção
//
//        // Gera um token JWT com base no email
//        public String generateToken(String email) {
//            Map<String, Object> claims = new HashMap<>();
//            return createToken(claims, email);
//        }
//
//        // Cria o token JWT
//        private String createToken(Map<String, Object> claims, String subject) {
//            return Jwts.builder()
//                    .setClaims(claims)
//                    .setSubject(subject)
//                    .setIssuedAt(new Date(System.currentTimeMillis()))
//                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas de validade
//                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                    .compact();
//        }
//
//        // Valida o token JWT
//        public boolean validateToken(String token, String email) {
//            final String username = extractUsername(token);
//            return (username.equals(email) && !isTokenExpired(token));
//        }
//
//        // Extrai o email do token
//        public String extractUsername(String token) {
//            return extractAllClaims(token).getSubject();
//        }
//
//        // Verifica se o token está expirado
//        private boolean isTokenExpired(String token) {
//            return extractAllClaims(token).getExpiration().before(new Date());
//        }
//
//        private Claims extractAllClaims(String token) {
//            return Jwts.parser()
//                    .setSigningKey(SECRET_KEY)
//                    .parseClaimsJws(token)
//                    .getBody();
//        }
//    }
//}
