<%@ page import="java.util.List" %>
<%@ page import="com.example.showadvisor_fia.Show" %>
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
            <img src="/home/giuseppe/IdeaProjects/ShowAdvisor_FIA/src/main/webapp/immagini/logo SA.png" alt="Logo" width="40" height="30" class="d-inline-block align-text-top">
            ShowAdvisor!
        </a>
    </div>
</nav>


<p>
    <a class="btn btn-primary" data-bs-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Consigliami una SerieTv!</a>
    <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#multiCollapseExample2" aria-expanded="false" aria-controls="multiCollapseExample2">Consigliami un Film!</button>
</p>
<div class="row">
    <div class="col">
        <div class="collapse multi-collapse" id="multiCollapseExample1">
            <div class="card card-body">

                <form class="row g-3">

                    <div class="col-auto">
                        <p> Inserisci il nome di una Serie TV che ti è piaciuta :</p>
                    </div>

                    <div class="col-auto">
                        <input type="Nome" class="form-control" id="inputPassword22" placeholder="Nome">
                    </div>

                    <div class="col-auto">
                        <button type="submit" class="btn btn-primary mb-3">Cerca</button>
                    </div>
                </form>

            </div>
        </div>
    </div>

    <div class="col">
        <div class="collapse multi-collapse" id="multiCollapseExample2">
            <div class="card card-body">

                <form class="row g-3">

                    <div class="col-auto">
                        <p> Inserisci il nome di un Film che ti è piaciuto :</p>
                    </div>

                    <div class="col-auto">
                        <input type="Nome" class="form-control" id="inputPassword2" placeholder="Nome">
                    </div>


                    <div class="col-auto">
                        <button type="submit" class="btn btn-primary mb-3">Cerca</button>
                    </div>
                </form></div>
        </div>
    </div>
</div>

<div class="wrapper">
    <header>
        <h2>Price Range</h2>
        <p>Use slider or enter min and max price</p>
    </header>
    <div class="value-input">
        <div class="field">
            <span>Min</span>
            <input type="number" class="input-min" value="1">
        </div>
        <div class="separator">-</div>
        <div class="field">
            <span>Max</span>
            <input type="number" class="input-max" value="30">
        </div>
    </div>
    <div class="slider">
        <div class="progress">
            sium
        </div>
    </div>
    <div class="range-input">
        <input type="range" class="range-min" min="0" max="10000" value="2500" step="100">
        <input type="range" class="range-max" min="0" max="10000" value="7500" step="100">
    </div>
</div>

<script src="js/script.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>