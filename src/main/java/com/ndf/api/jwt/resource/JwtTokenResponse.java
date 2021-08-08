package com.ndf.api.jwt.resource;

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {

	// {
	// Michael89 - "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJNaWNoYWVsODkiLCJleHAiOjE2MDk4NzIxNDMsImlhdCI6MTYwOTI2NzM0M30.qJj2cdP9yug_ZN8iHszx8XY1W5KH81WMIaizJo13Qk86HLo3Fs0GUM16YVLhlpl-iZXy5qi4V_9YTubwqWStCg"
	// }

	// {
	// mayk89 - "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXlrODkiLCJleHAiOjE2MDk4NzI0NjgsImlhdCI6MTYwOTI2NzY2OH0.MGhvsJTPC9YCq6553t-gEtWzwV6WK2O3vlaS6ZEEmyfQP4ERvxCBpQCt2foXWbZv9zAIFbYEs7aZau5W4xSHJg"
	// }

	private static final long serialVersionUID = 8317676219297719109L;

	private final String token;

	public JwtTokenResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}
}