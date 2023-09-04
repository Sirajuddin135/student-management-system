package com.sms.app.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAddressDTO {

    private Long id;
    private String area;
    private String state;
    private String district;
    private String pincode;
    private String addressType;
    private StudentDTO student;
}
