package com.hamza.subscriptionplans.jpa.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp>{

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime aDateTime) {
		return Timestamp.valueOf(aDateTime);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp aTimeStamp) {
		return aTimeStamp.toLocalDateTime();
	}
	
	

}
