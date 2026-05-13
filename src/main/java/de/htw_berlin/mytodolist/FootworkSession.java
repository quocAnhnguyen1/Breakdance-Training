package de.htw_berlin.mytodolist;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FootworkSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int workTime;
    private int restTime;
    private int round;

    public FootworkSession() {}

    public FootworkSession(int workTime, int restTime, int round) {
        this.workTime = workTime;
        this.restTime = restTime;
        this.round = round;
    }

    public Long getId() { return id; }

    public int getWorkTime() { return workTime; }
    public void setWorkTime(int workTime) { this.workTime = workTime; }

    public int getRestTime() { return restTime; }
    public void setRestTime(int restTime) { this.restTime = restTime; }

    public int getRound() { return round; }
    public void setRound(int round) { this.round = round; }
}
