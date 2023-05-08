package com.wvsu.bhms.tenant;

import com.wvsu.bhms.BhmsApplicationTests;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TenantResourceIntegrationTest extends BhmsApplicationTests {

    @Autowired
    private RestTemplate restTemplate;
    @LocalServerPort
    private int port;

    @Test
    public void create() {
        Tenant tenant = buildTenant();
        String url = "http://localhost:" + port + "/tenant/create";
        Tenant saved = restTemplate.postForObject(url, tenant, Tenant.class);
        System.out.println(saved);
    }

    @Test
    public void update() {
        Tenant tenant = buildTenant();
        tenant.setId(1);
        String url = "http://localhost:" + port + "/tenant/update";
        Tenant saved = restTemplate.postForObject(url, tenant, Tenant.class);
        System.out.println(saved);
    }

    @Test
    public void delete() {
        String url = "http://localhost:" + port + "/tenant/delete?id=1";
        restTemplate.postForObject(url, null, Void.class);
    }

    @Test
    public void findAll() {
        String url = "http://localhost:" + port + "/tenant/findAll";
        List<Tenant> tenants = restTemplate.getForObject(url, List.class);
        System.out.println(tenants);
    }

    @Test
    public void findById() {
        String url = "http://localhost:" + port + "/tenant/findById?id=2";
        Tenant tenant = restTemplate.getForObject(url, Tenant.class);
        System.out.println(tenant);
    }

    private static Tenant buildTenant() {
        Tenant tenant = new Tenant();
        tenant.setFirstName(RandomString.make());
        tenant.setLastName(RandomString.make());
        return tenant;
    }
}
