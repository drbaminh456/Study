package com.example.common;

public class Const {
	public static final String STATUS_ACTIVE = "ACT";

	public static final String STATUS_INACTIVE = "INA";

	public class HTTP {
		public static final String STATUS_SUCCESS = "success";

		public static final String STATUS_ERROR = "error";
	}

	public class Authentication {
		public static final long TOKEN_TIME = 24 * 60 * 60;

		public static final String SIGNING_KEY = "auth123key";

		public static final String TOKEN_PREFIX = "Bearer ";

		public static final String HEADER_STRING = "Authorization";

		public static final String ROLE_ADMIN = "Admin";

		public static final String ROLE_USER = "User";

		public static final String RSA_PRIVATE = "RSA_PRIVATE_KEY";

		public static final String RSA_PUBLIC = "RSA_PUBLIC_KEY";

		public static final String PAYLOAD_NAME = "user";

		public static final String TOKEN_KEY1 = "E3B51E3A5B0035DDEA2D063728B4C79E39E9F259138CB42481AFA41084DB9F0B";

		public static final String TOKEN_KEY2 = "9C8F616E0317998A10F3518D6272EA31B3CB9FECAA4C9FAF1A2FEDB6B6C2AA9E";

		public static final int TOKEN_MINUTE = 2;

		public static final int TOKEN_NUMBER = 6;

		public static final int ACTIVE_NUMBER = 6;
	}

	public class User {
		public static final int FAILED_AUTH_ATTEMPTS = 2;
	}

	public class Type {
		public static final String STATEMENT = "Statement";

		public static final String GUESS = "Guess";
	}

	public class Mode {
		public static final String DEV = "DEV_MODE";

		public static final String RSA = "RSA_MODE";
	}

	public class UI {
		public static final String SELECT_OPTION = "-- Please select --";
	}
}