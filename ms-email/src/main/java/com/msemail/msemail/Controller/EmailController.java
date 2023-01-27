package com.msemail.msemail.Controller;

import com.msemail.msemail.dtos.EmailDto;
import com.msemail.msemail.models.EmailModel;
import com.msemail.msemail.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    EmailService emailService;

    @PostMapping("/envio-email")
    public ResponseEntity<EmailModel> envioEmail(@RequestBody @Valid EmailDto emailDto){
        EmailModel emailModel= new EmailModel();
        BeanUtils.copyProperties(emailDto,emailModel);
        emailService.sendEmail(emailModel);
        return  new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}
