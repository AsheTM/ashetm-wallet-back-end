package dev.ashetm.wallet.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CardTypeEnum {
	
	VISA("VISA"), MASTERCARD("MASTERCARD"), UNKNOWN(null);

    private String type;

}
