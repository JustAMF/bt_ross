package hw1.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "runningInformation")
public interface RunningInfoRepository extends JpaRepository<RunningInformation, Long>{

    @RestResource(path = "runners")
    Page<RunningInformation> findByhealthWarningLevel(@Param("HealthWarningLevel") RunningInformation.HealthWarningLevel healthWarningLevel, Pageable pageable);
    Page<RunningInformation> findAllByOrOrderByHeartRateDesc(Pageable pageable);
    void deleteByRunningId(String runningId);
}
