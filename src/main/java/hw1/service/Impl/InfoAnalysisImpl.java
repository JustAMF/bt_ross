package hw1.service.Impl;

import hw1.domain.RunningInfoRepository;
import hw1.domain.RunningInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import hw1.service.InfoAnalysis;

import java.util.List;

@Service
public class InfoAnalysisImpl implements InfoAnalysis{

    @Autowired
    private RunningInfoRepository runningInfoRepository;

    @Override
    public List<RunningInformation> saveRunningLocations(List<RunningInformation> runningInformations) {
        for(RunningInformation ri: runningInformations){
            ri.judgeHealthWarningLevel();
        }
        return runningInfoRepository.save(runningInformations);
    }

    @Override
    public void deleteAll() {
        runningInfoRepository.deleteAll();
    }

    @Override
    public Page<RunningInformation> findByHealthWarningLevel(RunningInformation.HealthWarningLevel healthWarningLevel, Pageable pageable){
        return runningInfoRepository.findByhealthWarningLevel(healthWarningLevel, pageable);
    }

    @Override
    public Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable) {
        return runningInfoRepository.findAllByOrOrderByHeartRateDesc(pageable);
    }

    @Override
    public void deleteByRunningId(String runningId) {
        runningInfoRepository.deleteByRunningId(runningId);
    }
}
