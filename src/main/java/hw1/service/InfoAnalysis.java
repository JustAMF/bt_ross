package hw1.service;

import hw1.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InfoAnalysis {

    List<RunningInformation> saveRunningLocations(List<RunningInformation> runningInformations);

    void deleteAll();

    Page<RunningInformation> findByHealthWarningLevel(RunningInformation.HealthWarningLevel healthWarningLevel, Pageable pageable);

    Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable);

    void deleteByRunningId(String runningId);
}
