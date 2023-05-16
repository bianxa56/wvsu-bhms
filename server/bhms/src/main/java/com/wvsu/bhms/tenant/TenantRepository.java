package com.wvsu.bhms.tenant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant,Long> {

    Tenant findFirstByFirstNameAndLastName(String firstName, String lastName);

    Tenant findByRoomId(long roomId);
}
