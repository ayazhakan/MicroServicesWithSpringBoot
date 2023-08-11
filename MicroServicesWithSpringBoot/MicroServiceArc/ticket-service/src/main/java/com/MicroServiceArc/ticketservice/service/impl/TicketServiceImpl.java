package com.MicroServiceArc.ticketservice.service.impl;

import com.MicroServiceArc.ticketservice.dto.TicketDto;
import com.MicroServiceArc.ticketservice.model.PriorityType;
import com.MicroServiceArc.ticketservice.model.Ticket;
import com.MicroServiceArc.ticketservice.model.TicketStatus;
import com.MicroServiceArc.ticketservice.model.es.TicketModel;
import com.MicroServiceArc.ticketservice.repository.TicketRepository;
import com.MicroServiceArc.ticketservice.repository.es.TicketElasticRepository;
import com.MicroServiceArc.ticketservice.service.TicketService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketElasticRepository ticketElasticRepository;
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto)
    {
        Ticket ticket= new Ticket();


        if(ticketDto.getDescription() == null)
            throw new IllegalArgumentException("Description can not be null!");

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));

        //save to mysql
        ticket= ticketRepository.save(ticket);

        //creating ticket object
        TicketModel model = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate())
                .build();

        //save to elastic search
        ticketElasticRepository.save(model);

        //return object
        ticketDto.setId(ticket.getId());
        return ticketDto;

    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
