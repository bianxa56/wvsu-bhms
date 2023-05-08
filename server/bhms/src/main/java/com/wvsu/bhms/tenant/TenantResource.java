package com.wvsu.bhms.tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant")
public class TenantResource {

    @Autowired
    private TenantService tenantService;

    @PostMapping("/create")
    Tenant create(@RequestBody Tenant tenant) {
        return tenantService.create(tenant);
    }

    @PostMapping("/update")
    Tenant update(@RequestBody Tenant tenant) {
        return tenantService.update(tenant);
    }

    @PostMapping("/delete")
    void delete(@RequestParam long id) {
        tenantService.delete(id);
    }

    @GetMapping("/findAll")
    List<Tenant> findAll() {
        return tenantService.findAll();
    }

    @GetMapping("/findById")
    Tenant findById(@RequestParam long id) {
        return tenantService.findById(id);
    }
}
