package dev.ashetm.wallet.utils;

import java.util.List;
import java.util.stream.Stream;

public interface IEntityUtil<T> {
	
	public static <T> Stream<T> getStream(List<T> list) {
		return list.stream();
	}
	

}
