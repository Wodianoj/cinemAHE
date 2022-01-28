$(document).ready(function(){

    $(".cahe-criteria-one").change(function(){
        var cinemaId = $("#ticket-cinema").val();
        var movieId = $("#ticket-movie").val();

        fetch('http://localhost:8080/api/v1/seance/all')
        .then(response => {
            return response.json();
        })
        .then(seances => {
            console.log(seances);
        });

    });
});


