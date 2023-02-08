<%@ page import="java.util.List" %>
<%@ page import="com.example.showadvisor_fia.Show" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ShowAdvisor!</title>
    <link rel = "stylesheet" href="css/bootstrap.min.css">
    <link rel = "stylesheet" href="style.css">
</head>


<body>
<nav class="navbar bg-dark fixed-top" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="logo SA.png" alt="Logo" width="40" height="30" class="d-inline-block align-text-top">
            ShowAdvisor!
        </a>
    </div>
</nav>

<p>
    <button class="form-position btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample">
        Consigliami una serie!
    </button>
</p>

<div style="min-height: 120px;">
    <div class="collapse" id="collapseWidthExample">
        <div class="card card-body" style="width: 480px;">

            <form class="row g-3">

                <div class="col-auto">
                    <p> Inserisci il nome di una Serie TV o din un Film che ti è piaciuta :</p>
                </div>

                <div class="col-auto">
                    <input type="Nome" class="form-control" id="inputPassword2" placeholder="Nome">
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                    Film
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
                    Serie Tv
                    </label>
                </div>

                <div class="col-auto">
                    <button type="submit" class="btn btn-primary mb-3">Cerca</button>
                </div>
            </form>
        </div>
    </div>
</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>