package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketSellerTest {

    //TODO: 정리 해야 함.
    @Test
    @DisplayName("")
    void sellToTest() {

        //given
        long beforeEnteringBagAmount = 30000;
        long ticketFee = 12000;
        long expectedTicketOfficeTotalAmount = 12000;

        TicketSeller seller = getTicketSeller(ticketFee);
        Audience audience = new Audience(new Bag(beforeEnteringBagAmount));
        assertFalse(audience.getBag().hasTicket());

        //when
        seller.sellTo(audience);

        //then
        assertTrue(audience.getBag().hasTicket());
        assertEquals(expectedTicketOfficeTotalAmount ,seller.getTicketOffice().getAmount());
    }

    private TicketSeller getTicketSeller(long fee) {
        Ticket ticket = new Ticket(fee);
        TicketOffice office = new TicketOffice(0L, ticket);
        return new TicketSeller(office);
    }
}