package dev.ashetm.wallet.views.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateCardResponseView implements IResponseView {

	@ApiModelProperty(
			name = "authenticate",
			dataType = "boolean",
			readOnly = false,
			allowEmptyValue = false,
			notes = "Check if is authenticated or not",
			position = 0,
			hidden = false,
			required = true)
	private boolean authenticate;
	
	public static AuthenticateCardResponseView from(boolean authenticate) {
		return new AuthenticateCardResponseView(authenticate);
	}

}
