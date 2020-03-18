package vn.easycredit.enums;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum PartnerCodeEnum {

	ZALO("ZAL", "ZALO")
	;
	
	private String code;
	private String description;
	private static final Map<String, PartnerCodeEnum> mapPartnerCodeEnum = new HashMap<>(); 
	
	private PartnerCodeEnum(String code, String description){
		this.code = code;
		this.description = description;
	}
	
	static
    {
        for(PartnerCodeEnum partnerCodeEnum : PartnerCodeEnum.values())
        {
        	mapPartnerCodeEnum.put(partnerCodeEnum.getCode(), partnerCodeEnum);
        }
    }
	
	public static PartnerCodeEnum findCode(String code)
    {
        return mapPartnerCodeEnum.get(code);
    }
}
