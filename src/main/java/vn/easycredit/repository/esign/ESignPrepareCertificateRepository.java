package vn.easycredit.repository.esign;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.easycredit.entity.esign.ESignPrepareCertificateEntity;

@Repository
public interface ESignPrepareCertificateRepository extends JpaRepository<ESignPrepareCertificateEntity, String> {

}
