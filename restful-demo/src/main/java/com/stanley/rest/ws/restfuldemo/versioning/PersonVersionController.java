package com.stanley.rest.ws.restfuldemo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

    // URI versioning ======================= twitter 
    @GetMapping("/v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Joy Jonathan");
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Joy", "Jonathan"));
    }

    // Params versioning ======================= Amazon
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramV1() {
        return new PersonV1("Joy Jonathan");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Joy", "Jonathan"));
    }

    // Header versioning ======================= used by Microsoft
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Joy Jonathan");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Joy", "Jonathan"));
    }

    // MIME type versioning and accept header or content negotiation =======================
    // used by GitHub
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Joy Jonathan");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Joy", "Jonathan"));
    }

}
