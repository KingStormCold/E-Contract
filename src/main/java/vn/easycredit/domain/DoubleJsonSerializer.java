package vn.easycredit.domain;

import java.math.BigDecimal;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import lombok.extern.slf4j.Slf4j;
import vn.easycredit.constant.Constant;

/**
 * 
 * @author hien.nguyen
 *
 */

@Slf4j
public class DoubleJsonSerializer implements JsonSerializer<Double>, JsonDeserializer<Double> {
    @Override
    public JsonElement serialize(Double src, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
        BigDecimal value = BigDecimal.valueOf(src);
        try {
            value = new BigDecimal(value.toBigIntegerExact());
        } catch (ArithmeticException e) {
            log.error(Constant.CONVERT_TO_DOUBLE_ERROR, e);
        }

        return new JsonPrimitive(value);
    }

	@Override
	public Double deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return null;
	}

}