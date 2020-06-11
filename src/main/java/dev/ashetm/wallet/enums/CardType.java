package dev.ashetm.wallet.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CardType {
	
	VISA("VISA"), MASTERCARD("MASTERCARD");
	
	private String type;

}
