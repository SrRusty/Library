package com.axpe.example.service.exceptions;

public final class KConstantsError {
	
	public final static class General {
		public static final String RESOURCES = "resources: ";
	}
	
	public final static class ErrorMessages {
		public static final String NOT_FOUND = "Resources request were not found";
		public static final String INTERNAL_SERVER_ERROR = "Internal server Error";
		public static final String INCORRECT_AUTHORIZATION = "Incorrect Authorization";
		public static final String UNPROCESSABLE_ENTITY = "Unprocessable Entity";
		public static final String BAD_REQUEST = "Bad Request";
		public static final String MAIL_ERROR = "Mail Error";
	}
	
	public final static class ErrorDescriptions {
		public static final String NOT_FOUND = "The employee with given id was not found";
		public static final String INTERNAL_SERVER_ERROR = "An error inside the server";
		public static final String INCORRECT_AUTHORIZATION = "The employee with given id has not authorization";
		public static final String UNPROCESSABLE_ENTITY = "semanticamente";
		public static final String BAD_REQUEST = "Wrog selected parameters or functional error has ocurred";
		public static final String MAIL_ERROR = "Format error";
	}

}
