package ru.baburina.dbapp.app.models;

public class ScheduledTrainModel {
    private int timetableId;
    private TrainModel train;

    public int getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }

    public TrainModel getTrain() {
        return train;
    }

    public void setTrain(TrainModel train) {
        this.train = train;
    }
}
