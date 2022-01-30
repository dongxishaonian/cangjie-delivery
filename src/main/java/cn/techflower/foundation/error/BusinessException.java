package cn.techflower.foundation.error;

import lombok.Data;
import lombok.EqualsAndHashCode;

import static cn.techflower.foundation.error.BusinessErrorEnums.CUSTOM_ERROR;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {
    private BusinessErrorEnums businessErrorEnums;

    public BusinessException(BusinessErrorEnums businessErrorEnums) {
        super(businessErrorEnums.getErrorMessage());
        this.businessErrorEnums = businessErrorEnums;
    }


    public BusinessException(String message) {
        super(message);
        this.businessErrorEnums = CUSTOM_ERROR;
    }

}
