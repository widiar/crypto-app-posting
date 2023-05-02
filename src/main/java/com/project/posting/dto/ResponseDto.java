package com.project.posting.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto {

    private String status;
    private String message;

    public void setSuccess(){
        this.status = "success";
        this.message = "Berhasil";
    }
}
