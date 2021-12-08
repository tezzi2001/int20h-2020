package com.bondarenko.int20h2020.constants;

public final class SecurityConstants {

    public static final String SECRET = "e4rtb436h6e44n34neyne54ny4ny5";
    public static final long EXPIRATION_TIME = 604_800_000; // 7 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public static final String SIGN_UP_URL = "/auth/register";
    public static final String SIGN_IN_URL = "/auth/login";
    public static final String SIGN_OUT_URL = "/auth/logout";
    public static final String FIND_DONOR_APPLICATIONS = "/api/findDonorApplications";
    public static final String FIND_RECIPIENT_APPLICATIONS = "/api/findRecipientApplications";
    public static final String ADD_DONOR_APPLICATIONS = "/api/addDonorApplication";
    public static final String ADD_RECIPIENT_APPLICATIONS = "/api/addRecipientApplication";

    private SecurityConstants() {
    }
}
