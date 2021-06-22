package ru.baburina.dbapp.db.entities;

public class ScheduledTrainEntity {
    private int timetableId;
    private TrainEntity train;

    public ScheduledTrainEntity() {
    }

    public ScheduledTrainEntity(int timetableId, TrainEntity train) {
        this.timetableId = timetableId;
        this.train = train;
    }

    public int getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }

    public TrainEntity getTrain() {
        return train;
    }

    public void setTrain(TrainEntity train) {
        this.train = train;
    }
}
