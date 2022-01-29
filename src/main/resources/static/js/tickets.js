$(document).ready(function(){

    $(".cahe-criteria-one").change(function(){
        let cinemaId = $("#ticket-cinema").val();
        cinemaId = cinemaId == "0" ? null : cinemaId;

        let movieId = $("#ticket-movie").val();
        movieId = movieId == "0" ? null : movieId;

        fetch('http://localhost:8080/api/v1/seance/search', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({"movieId": movieId, "cinemaId": cinemaId})
        })
        .then(response => {
            return response.json();
        })
        .then(seances => {
            let seanceSelect = $("#ticket-seance");
            seanceSelect.empty();

            if (seances.length < 1)
            {
                seanceSelect.append($("<option></option>").attr("value", "0").text("brak seansów"));
            }
            else {
                seanceSelect.append($("<option></option>").attr("value", "0").text("---"));
                for (var i = 0; i < seances.length; i++)
                {
                    let date = formatDate(new Date(seances[i].startDate));
                    let seance = seances[i];
                    let text = date + ' (sala: ' + seance.room.name + ', ' + seance.room.cinema.name + ', film: ' + seance.movie.title + ')';
                    seanceSelect.append($("<option></option>").attr("value", seance.id).text(text));
                }
            }
            console.log("abc");
        });
    });

        $("#ticket-seance").change(function(){
            let seanceId = $("#ticket-seance").val();
            if (seanceId == 0)
            {
                return;
            }

            fetch('http://localhost:8080/api/v1/seat/search', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({"seanceId": seanceId})
            })
            .then(response => {
                return response.json();
            })
            .then(seats => {
                let seatSelect = $("#ticket-seats");
                seatSelect.empty();

                for (var i = 0; i < seats.length; i++)
                {
                    let seatInfo = seats[i];
                    let text = 'Miejsce ' + seatInfo.seat.seatNumber + ' (rząd ' + seatInfo.seat.rowNumber + ')';
                    let option = $("<option></option>");
                    option.attr("value", seatInfo.seat.id);
                    option.text(text);
                    if (!seatInfo.available) {
                        option.attr("disabled", true);
                        option.attr("style", "text-decoration: line-through;");
                    }
                    seatSelect.append(option);
                }
                console.log("zzz");
            });
        });

});

function formatDate(date){
    let month = zeroPad(date.getMonth()) + 1;
    return zeroPad(date.getDate()) + "." + month + "." + date.getFullYear() + ", " + zeroPad(date.getHours()) + ":" + zeroPad(date.getMinutes());
}

function zeroPad(number){
    return ('0' + number).slice(-2);
}