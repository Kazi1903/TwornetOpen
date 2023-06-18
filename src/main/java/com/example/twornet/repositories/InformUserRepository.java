package com.example.twornet.repositories;

import com.example.twornet.models.InformUser;
import com.example.twornet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformUserRepository extends JpaRepository<InformUser, Long> {

    InformUser findInformUserByUser(User user);

    InformUser findInformUserByUmorGreaterThan(double umor);
    InformUser findInformUserByMarshrutGreaterThan(double marshrut);
    InformUser findInformUserByPunktualnostGreaterThan(double punktualnost);
    InformUser findInformUserByOpryatnostGreaterThan(double opryatnost);
    InformUser findInformUserByMestnostGreaterThan(double mestnost);
    InformUser findInformUserByBesedaGreaterThan(double beseda);

}
