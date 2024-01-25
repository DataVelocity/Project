package com.cms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cms.exception.AdmissionInvalidException;
import com.cms.model.Admission;
import com.cms.service.AdmissionServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/admission")
public class AdmissionController {

    @Autowired
    AdmissionServiceImpl admissionServiceImpl;

    @PostMapping("/register/{associateId}/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public Admission registerAssociateForCourse(@RequestBody Admission admission)throws AdmissionInvalidException{
        return admissionServiceImpl.registerAssociateForCourse(admission);
    }

    @PutMapping("/calculateFees/{associateId}")
    @ResponseStatus(HttpStatus.OK)
	public int calculateFees(@PathVariable String associateId)throws AdmissionInvalidException{
        return admissionServiceImpl.calculateFees(associateId);
    }

    @PostMapping("/feedback/{regNo}/{feedback}/{feedbackRating}")
    @ResponseStatus(HttpStatus.OK)
	public Admission addFeedback(@PathVariable Long regNo,@PathVariable String feedback,@PathVariable float feedbackRating) throws AdmissionInvalidException{
        return admissionServiceImpl.addFeedback(regNo, feedback, feedbackRating);
    }

    @GetMapping("/highestFee/{associateId}")
    @ResponseStatus(HttpStatus.OK)
	public List<String> highestFeeForTheRegisteredCourse(@PathVariable String associateId)throws AdmissionInvalidException{
        return admissionServiceImpl.highestFeeForTheRegisteredCourse(associateId);
    }

    @GetMapping("/viewFeedbackByCourseId/{courseId}")
    @ResponseStatus(HttpStatus.OK)
	public List<String> viewFeedbackByCourseId(@PathVariable String courseId) throws AdmissionInvalidException{
        return admissionServiceImpl.viewFeedbackByCourseId(courseId);
    }

    @DeleteMapping("/deactivate/{courseId}")
    @ResponseStatus(HttpStatus.OK)
	public boolean deactivateAdmission(@PathVariable String courseId)throws AdmissionInvalidException{
        return admissionServiceImpl.deactivateAdmission(courseId);
    }

    @PostMapping("/makePayment/{registartionId}/{fees}")
    @ResponseStatus(HttpStatus.OK)
	public boolean makePayment(@PathVariable int registartionId)throws AdmissionInvalidException{
        return admissionServiceImpl.makePayment(registartionId);
    }

    @GetMapping("viewAll")
    @ResponseStatus(HttpStatus.OK)
	public List<Admission> viewAll(){
        return admissionServiceImpl.viewAll();
    }
    
	
	
}
