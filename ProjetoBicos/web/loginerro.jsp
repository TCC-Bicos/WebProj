<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style-login.css">
        <title> Login </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%
          String mensagem = (String) request.getAttribute("mensagem");
        %>    
        <section class="h-100 gradient-form" style="background-color: #eee;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-xl-10">
                        <div class="card rounded-3 text-black ">
                            <div class="row g-0 ">
                                <div class="col-lg-6 ">
                                    <div class="card-body p-md-5 mx-md-4 ">

                                        <div class="text-center">
                                            <img src="img/bg-logo.png" class="logol" alt="logo">
                                        </div>

                                        <form method="post" action="loguser.jsp" id="formulario">

                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="form2Example11">Email</label>
                                                <input type="email" name="email" id="form2Example11" class="form-control" placeholder="Email" />
                                            </div>

                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="form2Example22">Senha</label>
                                                <input type="password" id="form2Example22" name="senha" class="form-control" placeholder="Senha" />
                                                <a class="text-muted" href="#!">Esqueceu a sua senha?</a>
                                            </div>

                                            <div class="text-center pt-1 mb-5 pb-1">
                                                  <input type="submit" value="Entrar" class="btn btn-primary">
                                                  <p> <%= mensagem %> </p>
                                            </div>

                                            <div class="d-flex align-items-center justify-content-center pb-4 df-r">
                                                <p class="mb-0 me-2 ">Não tem uma conta?</p>
                                                <button class="create "> <a href="cad.html"> Criar Conta </a> </button>
                                            </div>

                                        </form>

                                    </div>
                                </div>
                                <div class="col-lg-6 d-flex align-items-center bd-grad d-n">
                                    <div class="text-white px-3 py-4 p-md-5 mx-md-4 d-n">
                                        <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>