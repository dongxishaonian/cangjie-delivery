package cn.techflower.foundation.error;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {
    private BusinessErrorEnums businessErrorEnums;

    public BusinessException(BusinessErrorEnums businessErrorEnums) {
        super(businessErrorEnums.getErrorMessage());
        this.businessErrorEnums = businessErrorEnums;
    }
}
