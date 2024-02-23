package com.javatodev.api.controller;

import com.javatodev.api.model.request.Appointment;
import com.javatodev.api.model.request.Auth;
import com.javatodev.api.model.response.Response;
import com.javatodev.api.service.AppointmentService;
import com.javatodev.api.service.AuthService;
import com.javatodev.api.util.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/appointment")
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {

    @Autowired
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public Response getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return new Response(200, "Successfully created !!", true, appointments);
    }

    @GetMapping("/{id}")
    public Response getAppointment(@PathVariable String id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        return new Response(200, "Successfully created !!", true, appointment.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)));
    }

    @PostMapping("/create")
    public Response createAppointment(@RequestBody Appointment appointment) {
        Appointment createdAppointment = appointmentService.createAppointment(appointment);
        return new Response(200, "Successfully created !!", true, createdAppointment);
    }
    @PostMapping("/create-un-authenticate")
    public Response createAppointmentUnAuthenticate(@RequestBody Appointment appointment) {
        Appointment createdAppointment = appointmentService.createAppointment(appointment);
        return new Response(200, "Successfully created !!", true, createdAppointment);
    }

    @PatchMapping("/{id}")
    public Response updateAppointment(@PathVariable String id, @RequestBody Appointment appointment) {
        appointment.setId(id);
        Appointment updatedAppointment = appointmentService.updateAppointment(appointment);
        return new Response(200, "Successfully created !!", true, updatedAppointment);
    }

    @DeleteMapping("/{id}")
    public Response deleteAppointment(@PathVariable String id) {
        appointmentService.deleteAppointment(id);
        return new Response(200, "Successfully created !!", true, null);
    }
}