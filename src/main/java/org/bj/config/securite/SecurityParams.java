package org.bj.config.securite;

public interface SecurityParams {
	public static final String JWT_HEADER_NAME="Authorization";
	public static final String SECRET="Pa$$w0rd";
	// 10 jours=10*24*3600*1000 ms
	public static final long EXPIRATION_TIME=864000000;
	public static final String TOKEN_PREFIX="Bearer ";
}
