package com.demo.librarymanagement.library_management_system.controller;

import com.demo.librarymanagement.library_management_system.model.PersonRequest;
import com.demo.librarymanagement.library_management_system.model.PersonResponse;
import com.demo.librarymanagement.library_management_system.services.ProcureBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ProcureBookController {

    @Autowired
    ProcureBookService procureBookService;

    @PostMapping(value = "/book/reserve", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> reserveBook(@RequestBody PersonRequest request){
        PersonResponse response = procureBookService.reserveBook(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/books/reserve/detail/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonResponse>> reserveBookDetails(@PathVariable String firstName){
        List<PersonResponse> response = procureBookService.reserveBookDetails(firstName);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/book/reserve/update/{firstName}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> reserveBookUpdate(@RequestBody PersonRequest request, @PathVariable String firstName){
        PersonResponse response = procureBookService.reserveBookUpdate(request, firstName);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/book/remove/{firstName}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> reserveBookDelete(@PathVariable String firstName){
        String response = procureBookService.reserveBookDelete(firstName);
        return ResponseEntity.ok(response);
    }
}
