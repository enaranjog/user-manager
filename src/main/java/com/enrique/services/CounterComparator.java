package com.enrique.services;

import java.util.Comparator;

import com.enrique.model.Counter;

public class CounterComparator implements Comparator<Counter> {

	@Override
	public int compare(Counter counter1, Counter counter2) {
		if(counter2.getAreaValue() == counter1.getAreaValue()){
			return counter2.getCardWithMaxValue().getValue().compareTo(counter1.getCardWithMaxValue().getValue());
		}
	return counter2.getAreaValue().compareTo(counter1.getAreaValue());
	}

}
