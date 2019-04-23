$(document).ready(function() {
    $("#add_course").click(function (e) { 
        e.preventDefault();
        val = {
        		planned_start: $("#date_begin").val(),
        		planned_end: $("#date_end").val(),
                driver: $("#driver_id").val(),
                vehicle: $("#vehicle_id").val(),	
        };
        $.ajax({
            type: "post",
            url: "course",
            data: JSON.stringify(val),
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
            	alert("Dodano nowy kurs.");
            },
            error: function() {
                alert("Nie udało się dodać kursu. Spróbuj jeszcze raz.");
            }
        });
    });
    $("#course_search").click(function (e) { 
        e.preventDefault();
        let vehicle_id = $("#vehicle").val();

        if(vehicle_id == "") {
            alert("Podaj numer rejestracyjny pojazdu");
            return;
        }

        $.get("course/" + vehicle_id, function(data, status) {
            if(status != "success") {
                alert("Wyszukiwanie nie powiodło się.");
                return;
            }
            $("#course_info").empty();
            if(data.length == 0){
                alert("Nie znaleziono pojazdu o podanym numerze rejestracyjnym");
            }
            for(let i = 0; i < data.length; ++i) {
                let course = data[i];
                
                let fragment = $("<div class=\"w3-border w3-border-red\"></div>");
                fragment.append("<p>Identyfikator kursu: " + course.id + "</p>");
                fragment.append("<p>Numer rejestracyjny pojazdu: " + course.vehicle + "</p>");
                fragment.append("<p>Identyfikator kierowcy: " + course.driver + "</p>");
                
                $.get("driver/" + course.driver, function(data, status) {
                    if(status != "success") return;
                    var name = data[0].name + " " + data[0].surrname;
                    fragment.append("<p>Imię i nazwisko kierowcy: " + name + "</p");
                });
                if (!course.planned_start) course.planned_start = "brak danych";
                fragment.append("<p>Planowana data rozpoczęcia kursu: " + course.planned_start + "</p>");
                
                if (!course.planned_end) course.planned_end = "brak danych";
                fragment.append("<p>Planowana data zakończenia kursu: " + course.planned_end + "</p>");
                
                if (!course.real_start) course.real_start = "brak danych";
                fragment.append("<p>Faktyczna data rozpoczęcia kursu: " + course.real_start + "</p>");
                
                if (!course.real_end) course.real_end = "brak danych";
                fragment.append("<p>Faktyczna data zakończenia kursu: " + course.real_end + "</p>");
                
                $("#course_info").append(fragment).append("<br/>");
            }
        }).fail(function() {
            alert("Wyszukiwanie nie powiodło się.");
        });
    });
});   
    
    
    