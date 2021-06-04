package com.example.demo;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        //ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
        //트레이드 오프...  오브젝트 33page ~ 확인!!
        ticketOffice.sellTicketTo(audience);
    }
}