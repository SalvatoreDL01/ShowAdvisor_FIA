<%@ page import="java.util.List" %>
<%@ page import="com.example.showadvisor_fia.Show" %>
<%@ page import="com.example.showadvisor_fia.Individuo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ShowAdvisor!</title>
    <link rel = "stylesheet" href="css/css/bootstrap.min.css">
    <link rel = "stylesheet" href="css/style.css">
</head>


<body>
<nav class="navbar bg-dark fixed-top" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="immagini/logo SA.png" alt="Logo" width="40" height="30" class="d-inline-block align-text-top">
            ShowAdvisor!
        </a>
    </div>
</nav>

<div class="container text-center">
    <div class="row">
        <div class="col">

            <p>
                <button class="btn btn-outline-danger buttonPosition1" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample">
                    Consigliami un Film!
                </button>
            </p>
            <div style="min-height: 120px;">
                <div class="collapse collapse-vertical" id="collapseWidthExample">
                    <div class="cardFilm card-bodyFilm card card-body">
                        <form  method="get" action = "ServletFilm">
                            <table>

                                <row class = "empty">
                                    <div class="col-auto">
                                        <select class="form-select" name = "durataFilm" id = "selezionaDurata2" aria-label="Default select example">
                                            <option selected>Seleziona la durata desiderara</option>
                                            <option value="0">Corta (massimo 80 minuti)</option>
                                            <option value="1">Media (tra 80 e 120 minuti)</option>
                                            <option value="2">Lungo (minimo 120 minuti)</option>
                                        </select>
                                    </div>
                                </row>
                                <row class = "empty">&nbsp;</row>

                                <row>
                                    <div class="container text-center">
                                        <div class="row justify-content-start">
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiFilm" type="checkbox" value="thriller" id="thrillerFilm">
                                                    <label class="form-check-label" for="thrillerFilm">
                                                        Thriller
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiFilm" type="checkbox" value="sport" id="sportFilm" >
                                                    <label class="form-check-label" for="sportFilm">
                                                        Sport
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiFilm" type="checkbox" value="scifi" id="scifiFilm" >
                                                    <label class="form-check-label" for="scifiFilm">
                                                        Scifi
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </row>

                                <row>
                                    <div class="container text-center">
                                        <div class="row justify-content-start">
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiFilm" type="checkbox" value="animation" id="animationFilm" >
                                                    <label class="form-check-label" for="animationFilm">
                                                        Animation
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiFilm" type="checkbox" value="fantasy" id="fantasyFilm" >
                                                    <label class="form-check-label" for="fantasyFilm">
                                                        Fantasy
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiFilm" type="checkbox" value="family" id="familyFilm" >
                                                    <label class="form-check-label" for="familyFilm">
                                                        Family
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </row>

                                <row>
                                    <div class="container text-center">
                                        <div class="row justify-content-start">
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="checkbox" value="romance" name = "generiFilm" id="romanceFilm" >
                                                    <label class="form-check-label" for="romanceFilm">
                                                        Romance
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="checkbox" value="war" name = "generiFilm" id="warFilm" >
                                                    <label class="form-check-label" for="warFilm">
                                                        War
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="checkbox" value="crime" name = "generiFilm" id="crimeFilm" >
                                                    <label class="form-check-label" for="crimeFilm">
                                                        Crime
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </row>

                                <row>
                                    <div class="container text-center">
                                        <div class="row justify-content-start">
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="checkbox" value="european" name = "generiFilm" id="europeanFilm" >
                                                    <label class="form-check-label" for="europeanFilm">
                                                        European
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="checkbox" value="documentation" name = "generiFilm" id="documentationFilm" >
                                                    <label class="form-check-label" for="documentationFilm">
                                                        Documentation
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="checkbox" value="action" name = "generiFilm" id="actionFilm" >
                                                    <label class="form-check-label" for="actionFilm">
                                                        Action
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </row>

                                <row>
                                    <div class="container text-center">
                                        <div class="row justify-content-start">
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="checkbox" value="western" name = "generiFilm" id="westernFilm" >
                                                    <label class="form-check-label" for="westernFilm">
                                                        Western
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="checkbox" value="music" name = "generiFilm" id="musicFilm" >
                                                    <label class="form-check-label" for="musicFilm">
                                                        Music
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="checkbox" value="comedy" name = "generiFilm" id="comedyFilm" >
                                                    <label class="form-check-label" for="comedyFilm">
                                                        Comedy
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </row>

                                <row>
                                    <div class="container text-center">
                                        <div class="row justify-content-start">
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="checkbox" value="horror" name = "generiFilm" id="horrorFilm" >
                                                    <label class="form-check-label" for="horrorFilm">
                                                        Horror
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="checkbox" value="drama" name = "generiFilm" id="dramaFilm" >
                                                    <label class="form-check-label" for="dramaFilm">
                                                        Drama
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                            </div>
                                        </div>
                                    </div>
                                </row>

                                <row class = "empty">&nbsp;</row>

                                <row>
                                    <div class="col-auto">
                                        <button type="submit" class="btn btn-outline-danger mb-3">Cerca</button>
                                    </div>
                                </row>

                            </table>
                        </form>
                    </div>
                </div>
            </div>

        </div>
        <div class="col">

            <p>
                <button class="btn btn-outline-danger buttonPosition2" type="button" data-bs-toggle="collapse" data-bs-target="#collassaSerieTv" aria-expanded="false" aria-controls="collassaSerieTv">
                    Consigliami una SerieTv!
                </button>
            </p>
            <div style="min-height: 120px;">
                <div class="collapse collapse-vertical" id="collassaSerieTv">
                    <div class="card card-body cardSerie card-bodySerie">
                        <form  method="get" action = "ServletSerie">
                            <table>

                                <row class = "empty">
                                    <div class="col-auto">
                                        <select class="form-select" name = "durataSerie" id = "selezionaDurata" aria-label="Default select example">
                                            <option selected>Seleziona la durata desiderata</option>
                                            <option value="0">Corta (massimo 27 minuti)</option>
                                            <option value="1">Media (tra 27 e 48 minuti)</option>
                                            <option value="2">Lunga (minimo 44 minuti)</option>
                                        </select>
                                    </div>
                                </row>
                                <row class = "empty">&nbsp;</row>

                                <row>
                                    <div class="container text-center">
                                        <div class="row justify-content-start">
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input name = "generiSerie" class="form-check-input" type="checkbox" value="thriller" id="thrillerSerie">
                                                    <label class="form-check-label" for="thrillerFilm">
                                                        Thriller
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="sport" id="sportSerie" >
                                                    <label class="form-check-label" for="sportSerie">
                                                        Sport
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="scifi" id="scifiSerie" >
                                                    <label class="form-check-label" for="scifiSerie">
                                                        Scifi
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </row>

                                <row>
                                    <div class="container text-center">
                                        <div class="row justify-content-start">
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="animation" id="animationSerie" >
                                                    <label class="form-check-label" for="animationSerie">
                                                        Animation
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="fantasy" id="fantasySerie" >
                                                    <label class="form-check-label" for="fantasySerie">
                                                        Fantasy
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="family" id="familySerie" >
                                                    <label class="form-check-label" for="familySerie">
                                                        Family
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </row>

                                <row>
                                    <div class="container text-center">
                                        <div class="row justify-content-start">
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="romance" id="romanceSerie" >
                                                    <label class="form-check-label" for="romanceSerie">
                                                        Romance
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="war" id="warSerie" >
                                                    <label class="form-check-label" for="warSerie">
                                                        War
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="crime" id="crimeSerie" >
                                                    <label class="form-check-label" for="crimeSerie">
                                                        Crime
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </row>

                                <row>
                                    <div class="container text-center">
                                        <div class="row justify-content-start">
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="european" id="europeanSerie" >
                                                    <label class="form-check-label" for="europeanSerie">
                                                        European
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="documentation" id="documentationSerie" >
                                                    <label class="form-check-label" for="documentationSerie">
                                                        Documentation
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="action" id="actionSerie" >
                                                    <label class="form-check-label" for="actionSerie">
                                                        Action
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </row>

                                <row>
                                    <div class="container text-center">
                                        <div class="row justify-content-start">
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="western" id="westernSerie" >
                                                    <label class="form-check-label" for="westernSerie">
                                                        Western
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="music" id="musicSerie" >
                                                    <label class="form-check-label" for="musicSerie">
                                                        Music
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="comedy" id="comedySerie" >
                                                    <label class="form-check-label" for="comedySerie">
                                                        Comedy
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </row>

                                <row>
                                    <div class="container text-center">
                                        <div class="row justify-content-start">
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="horror" id="horrorSerie" >
                                                    <label class="form-check-label" for="horrorSerie">
                                                        Horror
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" name = "generiSerie" type="checkbox" value="drama" id="dramaSerie" >
                                                    <label class="form-check-label" for="dramaSerie">
                                                        Drama
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                            </div>
                                        </div>
                                    </div>
                                </row>

                                <row class = "empty">&nbsp;</row>

                                <row>
                                    <div class="mb-3">
                                        <label for="formGroupExampleInput" class="form-label">Numero minimo di stagioni</label>
                                        <input type="number" max="18" min ="0" name = "minSeason" class="form-control" id="formGroupExampleInput" placeholder="Minimo" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="formGroupExampleInput2" class="form-label">Numero massimo di stagioni</label>
                                        <input type="number" max = "18" min = "0" name = "maxSeason" class="form-control" id="formGroupExampleInput2" placeholder="Massimo" required>
                                    </div>
                                </row>

                                <row class = "empty">&nbsp;</row>

                                <row>
                                    <div class="col-auto">
                                        <button type="submit" class="btn btn-outline-danger mb-3">Cerca</button>
                                    </div>
                                </row>

                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--
<div class = "risultati">
    <div class="accordion accordion-flush" id="accordionFlushExample">
        <div class="accordion-item">
            <h2 class="accordion-header" id="flush-headingOne">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                    Primo Risultato
                </button>
            </h2>
            <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body"></div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header" id="flush-headingTwo">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                    Secondo risultato
                </button>
            </h2>
            <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body"></div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header" id="flush-headingThree">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
                    Terzo risultato
                </button>
            </h2>
            <div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body"> </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header" id="flush-headingQuarto">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseQuarto" aria-expanded="false" aria-controls="flush-collapseQuarto">
                    Quarto risultato
                </button>
            </h2>
            <div id="flush-collapseQuarto" class="accordion-collapse collapse" aria-labelledby="flush-headingQuarto" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body"> </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header" id="flush-headingQuinto">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-headingQuinto" aria-expanded="false" aria-controls="flush-collapseQuinto">
                    Quinto risultato
                </button>
            </h2>
            <div id="flush-collapseQuinto" class="accordion-collapse collapse" aria-labelledby="flush-headingQuinto" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body"> </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header" id="flush-headingSesto">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-headingSesto" aria-expanded="false" aria-controls="flush-collapseSesto">
                    Sesto risultato
                </button>
            </h2>
            <div id="flush-collapseSesto" class="accordion-collapse collapse" aria-labelledby="flush-headingSesto" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body"> </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header" id="flush-headingSettimo">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseSettimo" aria-expanded="false" aria-controls="flush-collapseSettimo">
                    Settimo risultato
                </button>
            </h2>
            <div id="flush-collapseSettimo" class="accordion-collapse collapse" aria-labelledby="flush-headingSettimo" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body"> </div>
            </div>
        </div>
    </div>
</div>
-->

<div class="risultati">
    <ul class="list-group">
        <%
            Individuo individuo = null;
            if(session.getAttribute("individuo") != null){
                individuo = (Individuo) session.getAttribute("individuo");
                for(Show s: individuo){
        %>
        <li class="list-group-item" name ="result1" style="height: 200px; overflow-y: scroll;">TITOLO:<%=s.getTitle()%>,<br> DESCRIZIONE:<%=s.getDescription()%>,<br> ANNO REALIZZAZIONE:<%=s.getRelease_year()%>,<br> DURATA: <%=s.getRuntime()%>,<br> GENERI: <%=s.getGenres()%>,<br><%if(session.getAttribute("tipo").equals("SERIE")){%>NUMERO STAGIONI: <%=s.getSeasons()%>,<br> <%}%> PUNTEGGIO: <%=s.getScore()%></li>
        <%}}%>
    </ul>
</div>

<script src="js/script.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>