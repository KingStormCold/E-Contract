package vn.easycredit.repository.esign;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.easycredit.entity.esign.ESignPrepareFileEntity;

@Repository
public interface ESignPrepareFileRepository extends JpaRepository<ESignPrepareFileEntity, String> {

}
