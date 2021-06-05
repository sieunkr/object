package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TheaterTest {


    /*
    오브젝트 15 ~ 16 page

    Theater 의 enter 메서드를 보면, enter 메서드를 이해하기 위해서는, Audience 가 Bag 을 가지고 있고,
    Bag 안에는 현금과 티켓이 들어있으며, TicketSeller 가 TicketOffice 에서 티켓을 판매하고,
    TIcketOffice 안에 돈과 티켓이 보관돼 있다는 모든 사실을 동시에 기억하고 있어야 한다.

    이 코드는 하나의 클래스나 메서드에서 너무 많은 세부사항을 다루기 때문에 코드를 작성하는 사람뿐만 아니라 코드를 읽고
    이해해야 하는 사람 모두에게 큰 부담을 준다.

    더 큰문제는..
    Audience 와 TicketSeller 를 변경할 경우, Theater 도 함께 변경해야한다는 사실이다...


    Theater 가 Audience, TIcketSeller 뿐만 아니라, AUdience 소유의 Bag 과 TicketSeller 가 근무하는
    TicketOffice 까지 마음대로 접근할 수 있기 때문에... 설계를 변경하기 어렵다.

     */


    //TODO: Theater 클래스는, 너무 많은 클래스에 의존한다.
    @Test
    @DisplayName("초대장이 없는 관람객, 소극장 입장 검증")
    void withoutInvitationEnterTest() {

        //given
        long beforeEnteringBagAmount = 30000;
        long ticketFee = 12000;
        long expectedAfterEnteringBagAmount = 18000;

        Theater theater = getSampleTheater(ticketFee);
        Audience audience = new Audience(new Bag(beforeEnteringBagAmount));
        assertFalse(audience.getBag().hasTicket());

        //when
        theater.enter(audience);

        //then
        assertTrue(audience.getBag().hasTicket());
        assertEquals(expectedAfterEnteringBagAmount, audience.getBag().getAmount());
    }

    @Test
    @DisplayName("초대장이 있는 관람객, 소극장 입장 검증")
    void withInvitationEnterTest() {

        //given
        long beforeEnteringBagAmount = 30000;
        long ticketFee = 12000;
        long expectedAfterEnteringBagAmount = 30000;

        Theater theater = getSampleTheater(ticketFee);
        Invitation invitation = new Invitation(LocalDateTime.of(2021, 06, 04, 14, 00));
        Audience audience = new Audience(new Bag(invitation, beforeEnteringBagAmount));
        assertFalse(audience.getBag().hasTicket());

        //when
        theater.enter(audience);

        //then
        assertTrue(audience.getBag().hasTicket());
        assertEquals(expectedAfterEnteringBagAmount, audience.getBag().getAmount());
    }

    private Theater getSampleTheater(long fee) {
        Ticket ticket = new Ticket(fee);
        TicketOffice office = new TicketOffice(0L, ticket);
        TicketSeller seller = new TicketSeller(office);
        return new Theater(seller);
    }

}