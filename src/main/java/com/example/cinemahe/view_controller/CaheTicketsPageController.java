package com.example.cinemahe.view_controller;

import com.example.cinemahe.data.CahePurchaseRequest;
import com.example.cinemahe.data.CaheTicketRequest;
import com.example.cinemahe.form.CaheTicketRequestForm;
import com.example.cinemahe.repository.*;
import com.example.cinemahe.service.CaheSeatService;
import com.example.cinemahe.service.CaheTicketService;
import com.example.cinemahe.utils.CaheTicketRequestCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

import static java.util.UUID.*;

@Controller
public class CaheTicketsPageController
{
    private final CaheMovieRepository movieRepository;
    private final CaheGenreRepository genreRepository;
    private final CaheCinemaRepository cinemaRepository;
    private final CaheRoomRepository roomRepository;
    private final CaheSeatRepository seatRepository;
    private final CaheSeanceRepository seanceRepository;

    private final CaheTicketRequestCache requestCache;

    private final CaheSeatService seatService;
    private final CaheTicketService ticketService;

    @Autowired
    public CaheTicketsPageController(final CaheMovieRepository movieRepository,
                                     final CaheGenreRepository genreRepository,
                                     final CaheCinemaRepository cinemaRepository,
                                     final CaheRoomRepository roomRepository,
                                     final CaheSeatRepository seatRepository,
                                     final CaheSeanceRepository seanceRepository,
                                     final CaheTicketRequestCache requestCache,
                                     final CaheSeatService seatService,
                                     final CaheTicketService ticketService)
    {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.cinemaRepository = cinemaRepository;
        this.roomRepository = roomRepository;
        this.seatRepository = seatRepository;
        this.seanceRepository = seanceRepository;
        this.requestCache = requestCache;
        this.seatService = seatService;
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public String getTicketSearchPage(Model model)
    {
        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        model.addAttribute("cinemas", cinemaRepository.findAll());
        model.addAttribute("rooms", roomRepository.findAll());
        model.addAttribute("seats", seatRepository.findAll());
        model.addAttribute("seances", seanceRepository.findAll());

        final CaheTicketRequestForm caheTicketRequestForm = CaheTicketRequestForm.builder().build();
        model.addAttribute("ticketRequest", caheTicketRequestForm);

        return "tickets";
    }

    @PostMapping("/tickets/payment")
    public String getTicketPaymentPage(@ModelAttribute CaheTicketRequestForm form, Model model)
    {
        String resultingView;
        try
        {
            if (!ticketService.isTicketRequestOk(form))
            {
                throw new IllegalArgumentException("Buying ticket impossible.");
            }

            final CaheTicketRequest ticketRequest = CaheTicketRequest.builder()
                    .uuid(randomUUID())
                    .creationDate(LocalDateTime.now())
                    .seanceId(form.getSeanceId())
                    .seatIds(form.getSeatIds())
                    .build();

            requestCache.add(ticketRequest);

            model.addAttribute("purchaseRequest", CahePurchaseRequest.builder().uuid(ticketRequest.getUuid().toString()).build());
            model.addAttribute("ticketSummary", ticketService.generatePurchaseSummary(form));

            resultingView = "tickets_payment";
        }
        catch (Exception e)
        {
            model.addAttribute("title", "Nie udało się!");
            model.addAttribute("message", "Spróbuj jeszcze raz.");

            resultingView = "tickets_problem";
        }
        return resultingView;
    }

    @PostMapping("/tickets/confirmation")
    public String getTicketConfirmationPage(@ModelAttribute CahePurchaseRequest purchaseRequest, Model model)
    {
        String resultingView;
        try
        {
            final CaheTicketRequest caheTicketRequest = requestCache.returnAndRemove(fromString(purchaseRequest.getUuid()));
            final CaheTicketRequestForm form = CaheTicketRequestForm.builder().seanceId(caheTicketRequest.getSeanceId()).seatIds(caheTicketRequest.getSeatIds()).build();
            ticketService.buyTicket(purchaseRequest.getBlik(), form);

            model.addAttribute("title", "Miłego oglądania!");
            model.addAttribute("message", "Bilety wysłaliśmy na Twój mail.");

            resultingView = "tickets_confirmation";
        }
        catch (Exception e)
        {
            model.addAttribute("title", "Nie udało się!");
            model.addAttribute("message", "Spróbuj jeszcze raz.");

            resultingView = "tickets_problem";
        }
        return resultingView;
    }
}
