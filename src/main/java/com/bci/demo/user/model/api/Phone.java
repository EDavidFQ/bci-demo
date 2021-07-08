package com.bci.demo.user.model.api;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class Phone {

    @Pattern(regexp = "^\\d{7,9}$", message = "Number field contains between 7 to 9 digits")
    private String number;

    @Pattern(regexp = "^\\d{1,2}$", message = "CityCode field contains one or two digits")
    private String cityCode;

    @Pattern(regexp = "^\\d{2}$", message = "CountryCode field contains two digits")
    private String countryCode;

}
