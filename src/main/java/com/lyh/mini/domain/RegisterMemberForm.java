package com.lyh.mini.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterMemberForm {
    @Size(min = 3, max = 15, message = "3자 이상 15자 이하로 적어주세요")
    @NotEmpty(message = "사용자 ID는 필수 항목입니다.")
    private String id;

    @NotEmpty(message = "사용자 비밀번호는 필수 항목입니다.")
    @Size(min = 3, max = 15, message = "3자 이상 15자 이하로 적어주세요")
    private String password1;

    @NotEmpty(message = "사용자 비밀번호는 필수 항목입니다.")
    @Size(min = 3, max = 15, message = "3자 이상 15자 이하로 적어주세요")
    private String password2;

    @NotEmpty(message = "사용자 이름은 필수 항목입니다.")
    @Size(max = 15, message = "이름을 15자 이하로 적어주세요")
    private String name;
}
