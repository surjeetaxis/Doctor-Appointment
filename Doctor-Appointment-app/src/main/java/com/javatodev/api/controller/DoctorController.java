package com.javatodev.api.controller;
import com.javatodev.api.model.request.Auth;
import com.javatodev.api.model.request.Doctor;
import com.javatodev.api.model.response.Response;
import com.javatodev.api.service.AuthService;
import com.javatodev.api.service.DoctorService;
import com.javatodev.api.util.JwtGenerator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

        import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/doctor")
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorController {

    @Autowired
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("")
    public Response getAllDoctors(@RequestParam(defaultValue = "1") int limit) {
        return new Response(200, "Successfully Retrieve doctors !!", true, doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public Response getDoctor(@PathVariable String id) {
        Optional<Doctor> doctor = doctorService.getDoctorById(id);
        return new Response(200, "Successfully Retrieve doctors !!", true, doctor.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)));
    }

    @PostMapping("/")
    public Response createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        return new Response(200, "Successfully Retrieve doctors !!", true, createdDoctor);
    }

    @DeleteMapping("/{id}")
    public Response deleteDoctor(@PathVariable String id) {
        doctorService.deleteDoctor(id);
        return new Response(200, "Successfully Retrieve doctors !!", true, null);

    }

    @PatchMapping("/{id}")
    public Response updateDoctor(@PathVariable String id, @RequestBody Doctor doctor) {
        doctor.setId(id);
        Doctor updatedDoctor = doctorService.updateDoctor(doctor);
        return new Response(200, "Successfully Retrieve doctors !!", true, updatedDoctor);

    }
}