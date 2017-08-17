package hw1.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {

    @Id
    @GeneratedValue
    private long id;

    public enum HealthWarningLevel{
        LOW, NORMAL, HIGH;
    }

    private String runningId;
    private double latitude;
    private double longitude;

    private double runningDistance;
    private double totalRunningTime;
    private int heartRate = 0;
    private Date timestamp = new Date();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "userInfo_name")),
            @AttributeOverride(name = "address", column = @Column(name = "userInfo_address"))
    })
    private UserInfo userInfo;
    private HealthWarningLevel healthWarningLevel = HealthWarningLevel.LOW;

    public RunningInformation(){

    }

    @JsonCreator
    public RunningInformation(@JsonProperty("username") String username, @JsonProperty("address") String address){
        this.userInfo = new UserInfo(username, address);
        heartRate = (int)(Math.random()*(140) + 60);
    }

    public void judgeHealthWarningLevel(){
        if(heartRate <= 75){
            healthWarningLevel = HealthWarningLevel.LOW;
        }else if (heartRate <= 120){
            healthWarningLevel = HealthWarningLevel.NORMAL;
        }else{
            healthWarningLevel = HealthWarningLevel.HIGH;
        }
    }
}
