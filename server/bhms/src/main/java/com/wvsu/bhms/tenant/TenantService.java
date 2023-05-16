package com.wvsu.bhms.tenant;

import java.util.List;

public interface TenantService {
    Tenant create(Tenant tenant);

    Tenant update(Tenant tenant);

    void delete(long id);

    Tenant findById(long id);

    List<Tenant> findAll();

    Tenant assignRoom(long tenantId, long roomId);
}
