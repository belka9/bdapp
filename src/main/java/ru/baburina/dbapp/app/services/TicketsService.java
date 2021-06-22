package ru.baburina.dbapp.app.services;

import ru.baburina.dbapp.app.models.TicketsCreateModel;
import ru.baburina.dbapp.db.entities.TicketsEntity;
import ru.baburina.dbapp.db.repository.TicketsRepository;
import ru.baburina.dbapp.db.repository.TimetableRepository;

public class TicketsService {

    private final TicketsRepository ticketsRepository = new TicketsRepository();
    private final TimetableRepository timetableRepository = new TimetableRepository();


    public boolean createTicket(TicketsCreateModel model) {
        var stations = timetableRepository.getEntitiesBetween(
                model.getId_timetable(),
                model.getSt1(),
                model.getSt2());

        if (stations == null || stations.size() == 0) {
            return false;
        }

        var first = stations.get(0);
        var last = stations.get(stations.size() - 1);
        var train = first.getTrain();

        var maxSizes = train.getQuantity();

        if (stations.stream().anyMatch(t -> t.getTickets() >= maxSizes)) {
            return false;
        }

        stations.forEach(s -> s.setTickets(s.getTickets() + 1));

        var ticketEntity = new TicketsEntity();
        ticketEntity.setDt(first.getDt2());
        ticketEntity.setId_timetable(model.getId_timetable());
        ticketEntity.setTimetables(stations);
        ticketEntity.setFIO(model.getFio());
        ticketEntity.setStation1(first.getStation());
        ticketEntity.setStation2(last.getStation());

        ticketsRepository.create(ticketEntity);
        stations.forEach(timetableRepository::update);

        return true;
    }

    public boolean deleteTicket(int id) {
        var ticket = ticketsRepository.findById(id);
        ticket.getTimetables().forEach(s -> {
            s.setTickets(s.getTickets() - 1);
            timetableRepository.update(s);
        });

        ticketsRepository.delete(ticket);
        return true;
    }

}
